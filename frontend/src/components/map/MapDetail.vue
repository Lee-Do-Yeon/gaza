<template>
    <div class="container" id="app" v-cloak>
        <div style="height:100px"></div>
        <div id="map" style="width: 75%; height: 400px; position: relative; overflow: hidden; float:left">
        </div>
        <h3>[여행일정]</h3>
        <div style="height:400px; overflow: auto;">
                <list-item v-for="(route, index) in travel_route" :key="index" :route="route" />
                <!-- <li
                    v-for="route in travel_route"
                    v-bind:key="route.order"
                >
                    {{ route.order }} | {{ route.name }} | {{ route.address }} 
                </li> -->
         </div><div style="clear:both:"></div>
        <div id="clickLatlng"></div>
        <div class="input-group">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="sendPoint('FOCUS')" style="margin-right:10px">FOCUS</button>
                <button class="btn btn-primary" type="button" @click="saveRoute" style="margin-right:10px">클릭 좌표 루트로 저장</button>
                <button class="btn btn-primary" type="button" @click="showTravelRoute" style="margin-right:10px">travel_route</button>
                <button class="btn btn-primary" type="button" @click="insertToDB" style="margin-right:10px">DB삽입</button>
            </div>
        </div>
        <span>{{ recvPoint.recvLat }}-{{ recvPoint.recvLng }}-{{ recvPoint.type }}</span>
        <div></div>
    </div>
</template>

<script>
import Stomp from "webstomp-client";
import SockJS from "sockjs-client";
import axios from "@/api/http";
import ListItem from "@/components/map/list/ListItem";

export default {
    components: {
        ListItem,
    },
    data() {
        return {
            roomId: "",
            room: {},
            sender: "",
            clickLng: 33.450701,
            clickLat: 126.570667,
            map: Object,
            recvPoint: {
                recvLng: 0.0,
                recvLat: 0.0,
                type: "",
            },
            travel_route: [],
            reservationId: 3,
            recommend_location: [],
            guideId: "ssafy2",
        };
    },
    created() {
        this.connect();
        this.roomId = localStorage.getItem("wschat.roomId");
        this.sender = localStorage.getItem("wschat.sender");
        this.findRoom();
        this.getRecommend();
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
            let base = this;     
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
            this.recommend_location.forEach(function (addr) {
                geocoder.addressSearch(
                    // 주소로 좌표 검색.
                    addr.address,
                    function (result, status) {
                        console.log("추천장소 : " + addr.address);
                        // 정상적으로 검색이 완료됐으면
                        if (status === kakao.maps.services.Status.OK) {
                            console.log(result[0].y, result[0].x);
                            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                            var marker = new kakao.maps.Marker({
                                map: map,
                                position: coords,
                            });
                            marker.setMap(map);

                            // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
                            var iwContent = '<div style="padding:5px;">'+addr.name+'</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

                            // 인포윈도우를 생성합니다
                            var infowindow = new kakao.maps.InfoWindow({
                                content : iwContent,
                                removable : iwRemoveable
                            });

                            // 마커에 클릭이벤트를 등록합니다
                            kakao.maps.event.addListener(marker, 'click', function() {
                                // 마커 위에 인포윈도우를 표시합니다
                                console.log(marker.position);
                                base.clickLat = coords.getLat();
                                base.clickLng = coords.getLng();
                                base.sendPoint("CLICK");
                                infowindow.open(map, marker);  
                            });


                        } else {
                            console.log("추천 장소 출력이 제대로 안됨 - " + status);
                        }

                        // 일단 추천 장소의 마지막을 기준으로 맵의 중심을 잡는다.
                        map.setCenter(coords);
                    }
                );
            });
            // ***********forEach 끝

            // *******************************************************카테고리 검색
            // *******************************************************카테고리 검색 /끝

            // 지도를 클릭한 위치에 표출할 마커입니다
            var marker = new kakao.maps.Marker({
                // 지도 중심좌표에 마커를 생성합니다
                position: map.getCenter(),
            });
            // 지도에 마커를 표시합니다
            marker.setMap(map);

                   
            
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

                base.sendPoint("CLICK");
            });
            // init map ()
        },
        // this.clickLat, this.clickLng의 좌표로 부드럽게 중심좌표를 이동하는 함수.
        panTo() {
            var moveLatLon = new kakao.maps.LatLng(
                parseFloat(this.recvPoint.recvLat),
                parseFloat(this.recvPoint.recvLng)
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
        sendPoint(type) {
            console.log("Send Point:" + this.clickLng +" "+ this.clickLat +" "+type);
            this.stompClient.send(
                "/pub/map/point",
                JSON.stringify(
                    {
                        roomId: this.roomId,
                        lng: this.clickLng,
                        lat: this.clickLat,
                        type: type,
                    }
                )
            );
        },
        convertRecvPoint(recv) {
            this.recvPoint = {
                recvLng : recv.lng,
                recvLat : recv.lat,
                type : recv.type,
            }

            if(recv.type == "FOCUS"){
                this.panTo();
            }
        },
        connect() {
            var sock = new SockJS("https://i8c207.p.ssafy.io/ws-stomp");
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
                        console.log("구독으로 받은 좌표의 타입은 ", JSON.parse(point.body).type);
                        this.convertRecvPoint(JSON.parse(point.body));
                    });
                    this.stompClient.subscribe(`/sub/map/room3/${this.roomId}`, (route) => {
                        console.log("구독으로 받은 루트 입니다.", route.body);
                        this.saveRecvRoute(JSON.parse(route.body))
                    });
                },
                // 소켓 연결 실패
                (error) => {
                    console.log("소켓 연결 실패", error);
                    this.connected = false;
                }
            );
        }, // connect() 끝
        getRecommend(){
            axios.get(`/guides/location/${this.guideId}`).then((res) => {
                this.recommend_location = res.data;
                console.log("추천 장소 : " + JSON.stringify(res.data));
            });
            
            console.log("recommend_location : " + this.travel_route);
        },
        // 좌표를 이용해서 법정도 주소를 얻는 함수.
        getAddress(lat, lng){
            var geocoder = new kakao.maps.services.Geocoder();
            return new Promise((resolve, reject) => {
                geocoder.coord2Address(lng, lat, function(result, status) {
                    if (status === kakao.maps.services.Status.OK) {
                        console.log(result[0].address.address_name);
                        resolve(result[0].address.address_name);
                    }else{
                        reject(status);
                    }
                });
            });
        },
        // 좌표에 대한 마커를 생성하는 함수.
        setMarker(lat, lng){
            var markerPosition  = new kakao.maps.LatLng(lat, lng); 
            // ★★★★★ 나중에 마커 이미지를 다르게 변경하자!!
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(this.map);
        },
        // 현재 클릭한 장소에 대해 travel_route를 추가하는 함수.
        async saveRoute(){
            console.log("saveRoute() call.")
            var address = await this.getAddress(this.clickLat, this.clickLng);
            this.stompClient.send(
                "/pub/map/route",
                JSON.stringify({
                roomId: this.roomId,
                name: address,
                address: address,
                latitude: this.clickLat,
                longitude: this.clickLng
            })
            );
        },
        saveRecvRoute(route){
            console.log("saveRecvRoute() call.")
            this.travel_route.unshift({
                name: route.address,
                address: route.address,
                latitude: route.latitude,
                longitude: route.longitude
            });
            this.setMarker(route.latitude, route.longitude);
        },
        // 정말 마지막에 드디어 정말 DB에 저장할 때.
        insertToDB(){
            axios.post(`/routes/${this.reservationId}`, JSON.stringify(this.travel_route))
            .then(({ data }) => {
                let msg = "등록 처리시 문제가 발생했습니다.";
                if (data === "Success") {
                    msg = "등록이 완료되었습니다.";
                }
                alert(msg);
                console.log(msg);
            });
        },
        showTravelRoute(){
            console.log(JSON.stringify(this.travel_route));
        }
    }
};
</script>

<style>
[v-cloak] {
    display: none;
}
</style>
