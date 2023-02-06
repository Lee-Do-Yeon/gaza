<template>
    <div class="container" id="app" v-cloak>
        <div style="height:100px"></div>
        <div>
            <h2>방</h2>
        </div>
        <div id="map" style="width: 75%; height: 400px; position: relative; overflow: hidden; float:left">
        </div>
        <h3>여행일정</h3>
        <div>
            <ul class="list-group">
                <li
                    v-for="route in travel_route"
                    v-bind:key="route.order"
                >
                    {{ route.order }} | {{ route.name }} | {{ route.address }} 
                </li>
            </ul>
         </div><div style="clear:both:"></div>
        <div id="clickLatlng"></div>
        <div class="input-group">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="panTo">클릭좌표포커스</button>
                <button class="btn btn-primary" type="button" @click="sendPoint">좌표전송</button>
            </div>
        </div>
        <span>{{ recvLat }} {{ recvLng }}</span>
        <div></div>
    </div>
</template>

<script>
import Stomp from "webstomp-client";
import SockJS from "sockjs-client";
import axios from "@/api/http";

export default {
    data() {
        return {
            roomId: "",
            room: {},
            sender: "",
            clickLng: 33.450701,
            clickLat: 126.570667,
            map: Object,
            recvLng: 0.0,
            recvLat: 0.0,
            travel_route: [],
            reservationId: 3,
        };
    },
    created() {
        this.connect();
        this.roomId = localStorage.getItem("wschat.roomId");
        this.sender = localStorage.getItem("wschat.sender");
        this.findRoom();
        this.getRoutes();
    },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.initMap();
        } else {
            const script = document.createElement("script");
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src =
                "//dapi.kakao.com/v2/maps/sdk.js?appkey=05df79f7ea0889a7f001a0cb12f76df8&autoload=false&libraries=services";
            document.head.appendChild(script);
        }
    },
    methods: {
        initMap() {
            var mapContainer = document.getElementById("map"), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
                    level: 4, // 지도의 확대 레벨
                };

            // 지도를 표시할 div와  지도 옵션으로  지도를 생성.
            var map = new kakao.maps.Map(mapContainer, mapOption);

            this.map = map;

            // 주소-좌표 변환 객체를 생성.
            var geocoder = new kakao.maps.services.Geocoder();

            // ***********가이드의 추천 장소 출력을 위한 forEach 시작
            // 이걸.. 뷰엑스에서 가져왔는데. 이 리스트를.
            let mapHouses = [
                { dong: "매탄동", number: 1284 },
                { dong: "매탄동", number: 416 },
            ];

            mapHouses.forEach(function (addr) {
                geocoder.addressSearch(
                    // 주소로 좌표 검색. (주소 - 법정동 + 지번)
                    addr.dong + " " + addr.number,
                    function (result, status) {
                        console.log(addr.dong + " " + addr.number);
                        // 정상적으로 검색이 완료됐으면
                        if (status === kakao.maps.services.Status.OK) {
                            console.log(result[0].y, result[0].x);
                            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                            var marker = new kakao.maps.Marker({
                                map: map,
                                position: coords,
                            });
                        } else {
                            console.log("안됨!!!!!" + status);
                        }

                        var infowindow = new kakao.maps.InfoWindow({
                            content:
                                '<div style="width:150px;text-align:center;padding:6px 0; color:black;">' +
                                "마커 위로 뜨는 네임" +
                                "</div>",
                        });
                        infowindow.open(map, marker);
                        map.setCenter(coords);
                    }
                );
            });
            // forEach 끝

            // *******************************************************카테고리 검색
    // *******************************************************카테고리 검색 /끝

            // 지도를 클릭한 위치에 표출할 마커입니다
            var marker = new kakao.maps.Marker({
                // 지도 중심좌표에 마커를 생성합니다
                position: map.getCenter(),
            });
            // 지도에 마커를 표시합니다
            marker.setMap(map);
            let base = this;
            kakao.maps.event.addListener(map, "click", function (mouseEvent) {
                // 클릭한 위도, 경도 정보를 가져옵니다
                var latlng = mouseEvent.latLng;

                // 마커 위치를 클릭한 위치로 옮깁니다
                marker.setPosition(latlng);

                var message = "클릭한 위치의 위도는 " + latlng.getLat() + " 이고, ";
                message += "경도는 " + latlng.getLng() + " 입니다";

                base.clickLat = latlng.getLat();
                base.clickLng = latlng.getLng();

                var resultDiv = document.getElementById("clickLatlng");
                resultDiv.innerHTML = message;
            });
            // init map ()
        },
        // this.clickLat, this.clickLng의 좌표로 부드럽게 중심좌표를 이동하는 함수.
        panTo() {
            console.log("좌표 : " + this.clickLat, this.clickLng);

            var moveLatLon = new kakao.maps.LatLng(
                parseFloat(this.clickLat),
                parseFloat(this.clickLng)
            );

            this.map.panTo(moveLatLon);
        },
        findRoom() {
            axios.get(`/map/room/${this.roomId}`).then((res) => {
                console.log("찾은 방 : " + JSON.stringify(res.data));
                console.log("찾은 방 이름 : " + res.data.name);
                this.room = {
                    name: res.data.name,
                    roomId: res.data.roomId,
                };
            });
        },
        sendPoint() {
            console.log("Send message:" + this.message);
            this.stompClient.send(
                "/pub/map/point",
                JSON.stringify(
                    {
                        roomId: this.roomId,
                        lng: this.clickLng,
                        lat: this.clickLat,
                    },
                    {}
                )
            );
            this.message = "";
        },
        recvPoint(recv) {
            (this.recvLng = recv.lng), (this.recvLat = recv.lat);
        },
        connect() {
            var sock = new SockJS("http://localhost:8080/ws-stomp");
            this.stompClient = Stomp.over(sock);
            console.log(`소켓 연결을 시도합니다.`);
            // pub/sub event
            this.stompClient.connect(
                {},
                (frame) => {
                    // 소켓 연결 성공
                    // 구독하기
                    console.log("소켓 연결 성공", frame);
                    this.stompClient.subscribe(`/sub/map/room2/${this.roomId}`, (point) => {
                        console.log("구독으로 받은 좌표 입니다.", point.body);
                        this.recvPoint(JSON.parse(point.body));
                    });
                },
                // 소켓 연결 실패
                (error) => {
                    console.log("소켓 연결 실패", error);
                    this.connected = false;
                }
            );
        }, // connect() 끝
        getRoutes(){
            axios.get(`/routes/${this.reservationId}`).then((res) => {
                this.travel_route = res.data;
                console.log("여행 일정 : " + JSON.stringify(res.data));
            });
            
            console.log("travel_route : " + this.travel_route);
            },
        }
    };
</script>

<style>
[v-cloak] {
    display: none;
}
</style>
