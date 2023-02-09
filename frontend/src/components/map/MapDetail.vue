<template>
    <div class="container" id="app" v-cloak>
        <div style="height:100px"></div>
        <h1>{{ $route.params.roomId }}</h1>
        <div class="button-box" style="width:8%; height: 400px; background-color: lightgray; float:left">
            <button class="btn btn-primary" type="button" @click="sendPoint('FOCUS')" style="margin:5px; width:90px;">FOCUS</button>
            <button class="btn btn-primary" type="button" @click="saveRoute" style="margin:5px; width:90px;">저장</button>
            <button class="btn btn-primary" type="button" @click="insertToDB" style="margin:5px; width:90px;">DB</button>
        </div>
        <div id="map" style="width: 65%; height: 400px; position: relative; overflow: hidden; float:left">
        </div>
        <h3>[여행일정]</h3>
        <div style="width:27%; height:400px; overflow: auto;">
                <list-item v-for="(route, index) in travel_route" :key="index" :index="index" :route="route" @deleteRoute="manageRoute" @downRoute="manageRoute" @upRoute="manageRoute" />
                <!-- <li
                    v-for="route in travel_route"
                    v-bind:key="route.order"
                >
                    {{ route.order }} | {{ route.name }} | {{ route.address }} 
                </li> -->
         </div><div style="clear:both:"></div>
        <div id="clickLatlng"></div>
        <span>{{ recvPoint.recvLat }}-{{ recvPoint.recvLng }}-{{ recvPoint.type }}</span>
        <div></div>




        <div id="session">
      <div id="session-header">
        <input class="btn btn-large btn-danger" type="button" id="buttonLeaveSession" @click="leaveSession"
          value="Leave session" />
      </div>
      <div id="video-container" class="col-md-6">
        <user-video :stream-manager="OpenVidu.publisher" @click="updateMainVideoStreamManager(OpenVidu.publisher)" />
        <user-video v-for="sub in OpenVidu.subscribers" :key="sub.stream.connection.connectionId" :stream-manager="sub"
          @click="updateMainVideoStreamManager(sub)" />
      </div>
    </div>




    </div>
</template>

<script>
import Stomp from "webstomp-client";
import SockJS from "sockjs-client";
import ListItem from "@/components/map/list/ListItem";
import axios from "axios";
import UserVideo from "@/openvidu/UserVideo";
import { OpenVidu } from "openvidu-browser";

axios.defaults.headers.post["Content-Type"] = "application/json";

const APPLICATION_SERVER_URL = "https://i8c207.p.ssafy.io/api";

export default {
    components: {
        ListItem,
        UserVideo,
    },
    data() {
        return {
            roomId: "",
            OpenVidu: Object,
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
            markerImageSrc: require('./markers.png'),
            yourMarker: Object,
            OpenVidu: {
                OV: undefined,
                session: undefined,
                mainStreamManager: undefined,
                publisher: undefined,
                subscribers: [],
            },
            myUserName: "참가자",
        };
    },
    created() {
        console.log("=======================test====================");
        console.log(this.$route.params.roomId);
        this.connect();
        this.roomId = localStorage.getItem("wschat.roomId");
        this.myUserName = localStorage.getItem("wschat.sender");
        this.joinSession();
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

            var myPosition = new kakao.maps.LatLng(126.911186, 35.1401744);
            
            // ******************************************* 남의 마커 미리 세팅
            var yourMakerOption = {
                spriteOrigin: new kakao.maps.Point(0, 80),    
                spriteSize: new kakao.maps.Size(29, 166)
            }
            var yourMarkerImage =  new kakao.maps.MarkerImage(this.markerImageSrc, new kakao.maps.Size(29, 40), yourMakerOption);

            var yourMarker = new kakao.maps.Marker({
                position: myPosition,
                image: yourMarkerImage,
            });

            base.yourMarker = yourMarker;

            base.yourMarker.setMap(map);

            // ********************************************
            

            // ******************************************** 클릭했을 때 마커 시작
            var myMakerOption = {
                spriteOrigin: new kakao.maps.Point(0, 40),    
                spriteSize: new kakao.maps.Size(29, 166)  
            }
            var myMarkerImage =  new kakao.maps.MarkerImage(base.markerImageSrc, new kakao.maps.Size(29, 40), myMakerOption);

            // 지도를 클릭한 위치에 표출할 마커입니다
            var myMarker = new kakao.maps.Marker({
                // 지도 중심좌표에 마커를 생성합니다
                position: map.getCenter(),
                image: myMarkerImage,
            });
            // 지도에 마커를 표시합니다
            myMarker.setMap(map);

            kakao.maps.event.addListener(map, "click", function (mouseEvent) {
                // 클릭한 위도, 경도 정보를 가져옵니다
                var latlng = mouseEvent.latLng;

                // 마커 위치를 클릭한 위치로 옮깁니다
                myMarker.setPosition(latlng);

                var message = "클릭한 위치의 위도는 " + latlng.getLat() + " 이고, ";
                message += "경도는 " + latlng.getLng() + " 입니다";

                base.clickLat = latlng.getLat();
                base.clickLng = latlng.getLng();

                var resultDiv = document.getElementById("clickLatlng");
                resultDiv.innerHTML = message;

                base.sendPoint("CLICK");
            });
            // ******************************************** 클릭했을 때 마커 끝
            
            
            // ******************************************** 가이드의 추천 장소 출력을 위한 forEach 시작
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
                            var recommendMarker =  new kakao.maps.MarkerImage(base.markerImageSrc, new kakao.maps.Size(29, 40), {
                                                                                                            spriteOrigin: new kakao.maps.Point(0, 0),    
                                                                                                            spriteSize: new kakao.maps.Size(29, 166)  
                                                                                                         });
                            
                            var marker = new kakao.maps.Marker({
                                map: map,
                                position: coords,
                                image: recommendMarker,
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
            // ******************************************** forEach 끝

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
            axios.get(APPLICATION_SERVER_URL+`/map/room/${this.roomId}`).then((res) => {
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
            var tmpLng = recv.lng;
            var tmpLat = recv.lat;

            if(tmpLng != this.clickLng && tmpLat != this.clickLng){
                this.recvPoint = {
                    recvLng : recv.lng,
                    recvLat : recv.lat,
                    type : recv.type,
                }

                var position = new kakao.maps.LatLng(this.recvPoint.recvLat, this.recvPoint.recvLng);
                this.yourMarker.setPosition(position);

                if(recv.type == "FOCUS"){
                    this.panTo();
                }
            }
        },
        connect() {
            //var sock = new SockJS("http://localhost:8080/ws-stomp");
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
                        var routeItem = JSON.parse(route.body);
                        console.log("루트의 타입은 "+routeItem.type);
                        if(routeItem.type=="UP"){
                            this.upRoute(routeItem);
                        }else if(routeItem.type=="DOWN"){
                            this.downRoute(routeItem);
                        }else if(routeItem.type=="DELETE"){
                            this.deleteRoute(routeItem);            
                        }else if(routeItem.type=="SAVE"){
                            this.saveRecvRoute(routeItem);
                        }
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
            axios.get(APPLICATION_SERVER_URL+`/guides/location/${this.guideId}`).then((res) => {
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
        setMarker(lat, lng, markerImage){
            var markerPosition  = new kakao.maps.LatLng(lat, lng); 
            var marker = new kakao.maps.Marker({
                position: markerPosition,
                image: markerImage,
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
                longitude: this.clickLng,
                type: "SAVE",
            })
            );
        },
        saveRecvRoute(route){
            console.log("saveRecvRoute() call.")
            this.travel_route.push({
                name: route.address,
                address: route.address,
                latitude: route.latitude,
                longitude: route.longitude
            });

            var saveMakerOption = {
                spriteOrigin: new kakao.maps.Point(0, 120),    
                spriteSize: new kakao.maps.Size(29, 166)
            }
            var saveMarkerImage =  new kakao.maps.MarkerImage(this.markerImageSrc, new kakao.maps.Size(29, 40), saveMakerOption);

            this.setMarker(route.latitude, route.longitude, saveMarkerImage);
        },
        // 정말 마지막에 드디어 정말 DB에 저장할 때.
        insertToDB(){
            axios.post(APPLICATION_SERVER_URL+`/routes/${this.reservationId}`, JSON.stringify(this.travel_route))
            .then(({ data }) => {
                let msg = "등록 처리시 문제가 발생했습니다.";
                if (data === "Success") {
                    msg = "등록이 완료되었습니다.";
                }
                alert(msg);
                console.log(msg);
            });
        },
        deleteRoute(route){
            const index = this.travel_route.findIndex(i => i.name == route.address);
            console.log("호출이염 " + index);
            this.travel_route.splice(index, 1);
        },
        manageRoute(param){
            console.log("manageRoute");
            console.log(param.index +" "+param.type);
            var route = this.travel_route[param.index];
            route.type = param.type;
            route.roomId = this.roomId;
            this.stompClient.send(
                "/pub/map/route",
                JSON.stringify(route)
            );
        },
        upRoute(route){
            const index = this.travel_route.findIndex(i => i.name == route.address);
            if(index!=0){
                [this.travel_route[index-1], this.travel_route[index]] = [this.travel_route[index], this.travel_route[index-1]];
            }
        },
        downRoute(route){
            const index = this.travel_route.findIndex(i => i.name == route.address);
            if(index!=this.travel_route.length-1){
                [this.travel_route[index+1], this.travel_route[index]] = [this.travel_route[index], this.travel_route[index+1]];
            }
        },








        joinSession() {
            // --- 1) Get an OpenVidu object ---
            this.OpenVidu.OV = new OpenVidu();

            // --- 2) Init a session ---
            this.OpenVidu.session = this.OpenVidu.OV.initSession();

            // --- 3) Specify the actions when events take place in the session ---

            // On every new Stream received...
            this.OpenVidu.session.on("streamCreated", ({ stream }) => {
                const subscriber = this.OpenVidu.session.subscribe(stream);
                this.OpenVidu.subscribers.push(subscriber);
            });

            // On every Stream destroyed...
            this.OpenVidu.session.on("streamDestroyed", ({ stream }) => {
                const index = this.OpenVidu.subscribers.indexOf(stream.streamManager, 0);
                if (index >= 0) {
                this.OpenVidu.subscribers.splice(index, 1);
                }
            });

            // On every asynchronous exception...
            this.OpenVidu.session.on("exception", ({ exception }) => {
                console.warn(exception);
            });

            // --- 4) Connect to the session with a valid user token ---

            // Get a token from the OpenVidu deployment
            this.getToken(this.roomId).then((token) => {
                // First param is the token. Second param can be retrieved by every user on event
                // 'streamCreated' (property Stream.connection.data), and will be appended to DOM as the user's nickname
                this.OpenVidu.session.connect(token, { clientData: this.myUserName })
                .then(() => {

                    // --- 5) Get your own camera stream with the desired properties ---

                    // Init a publisher passing undefined as targetElement (we don't want OpenVidu to insert a video
                    // element: we will manage it on our own) and with the desired properties
                    let publisher = this.OpenVidu.OV.initPublisher(undefined, {
                    audioSource: undefined, // The source of audio. If undefined default microphone
                    videoSource: undefined, // The source of video. If undefined default webcam
                    publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
                    publishVideo: true, // Whether you want to start publishing with your video enabled or not
                    resolution: "640x480", // The resolution of your video
                    frameRate: 30, // The frame rate of your video
                    insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
                    mirror: false, // Whether to mirror your local video or not
                    });

                    // Set the main video in the page to display our webcam and store our Publisher
                    this.OpenVidu.mainStreamManager = publisher;
                    this.OpenVidu.publisher = publisher;

                    // --- 6) Publish your stream ---

                    this.OpenVidu.session.publish(this.OpenVidu.publisher);
                })
                .catch((error) => {
                    console.log("There was an error connecting to the session:", error.code, error.message);
                });
            });

            window.addEventListener("beforeunload", this.leaveSession);
            },

            leaveSession() {
            // --- 7) Leave the session by calling 'disconnect' method over the Session object ---
            if (this.OpenVidu.session) this.OpenVidu.session.disconnect();

            // Empty all properties...
            this.OpenVidu.session = undefined;
            this.OpenVidu.mainStreamManager = undefined;
            this.OpenVidu.publisher = undefined;
            this.OpenVidu.subscribers = [];
            this.OpenVidu.OV = undefined;

            // Remove beforeunload listener
            window.removeEventListener("beforeunload", this.leaveSession);
            },

            updateMainVideoStreamManager(stream) {
            if (this.OpenVidu.mainStreamManager === stream) return;
            this.OpenVidu.mainStreamManager = stream;
            },

            /**
             * --------------------------------------------
             * GETTING A TOKEN FROM YOUR APPLICATION SERVER
             * --------------------------------------------
             * The methods below request the creation of a Session and a Token to
             * your application server. This keeps your OpenVidu deployment secure.
             * 
             * In this sample code, there is no user control at all. Anybody could
             * access your application server endpoints! In a real production
             * environment, your application server must identify the user to allow
             * access to the endpoints.
             * 
             * Visit https://docs.openvidu.io/en/stable/application-server to learn
             * more about the integration of OpenVidu in your application server.
             */
            async getToken(mySessionId) {
            const sessionId = await this.createSession(mySessionId);
            return await this.createToken(sessionId);
            },

            async createSession(sessionId) {
            const response = await axios.post(APPLICATION_SERVER_URL + '/api/sessions', { customSessionId: sessionId }, {
                headers: { 'Content-Type': 'application/json', },
            });
            return response.data; // The sessionId
            },

            async createToken(sessionId) {
            const response = await axios.post(APPLICATION_SERVER_URL + '/api/sessions/' + sessionId + '/connections', {}, {
                headers: { 'Content-Type': 'application/json', },
            });
            return response.data; // The token
            },















    }
};
</script>

<style>
[v-cloak] {
    display: none;
}
</style>
