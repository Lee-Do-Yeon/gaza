<template>
    <div class="container" id="app" v-cloak>
        <div>
            <h2>{{room.name}}</h2>
        </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <label class="input-group-text">내용</label>
            </div>
            <input type="text" class="form-control" v-model="message" v-on:keypress.enter="sendMessage">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="sendMessage">보내기</button>
            </div>
        </div>
        <ul class="list-group">
            <li class="list-group-item" v-for="item in messages" :key="item">
                {{item.sender}} - {{item.message}}</a>
            </li>
        </ul>
        <div></div>
    </div>    
</template>


    <script>
import Stomp from "webstomp-client";
import SockJS from "sockjs-client";
import axios from "@/api/http";

        var sock = new SockJS("http://localhost:8080/ws-stomp");
        var ws = Stomp.over(sock);
                    
        export default {
            el: '#app',
            data: {
                roomId: '',
                room: {},
                sender: '',
                msg: '',
                messages: []
            },
        created() {
            this.connect();
                this.roomId = localStorage.getItem('wschat.roomId');
                this.sender = localStorage.getItem('wschat.sender');
                this.findRoom();
        },
            methods: {
                findRoom() {
                    axios.get('/chat/room/'+this.roomId).then(response => { this.room = response.data; });
                },
                sendMessage() {
                    //메시지를 보냄
                    this.stompClient.send("/pub/chat/message", {}, JSON.stringify({messageType:'CHAT', chatRoomId:this.roomId, writerName:this.sender, message:this.msg}));
                    this.msg = '';
                },
                recvMessage(recv) {
                    this.msg.unshift({"type":recv.messageType,"writerName":recv.messageType=='ENTER'?'[알림]':recv.writerName,"message":recv.message})
                },
                connect(){
                    var sock = new SockJS("http://localhost:8080/ws-stomp");
                    this.stompClient = Stomp.over(sock);
                    console.log(`소켓 연결을 시도합니다.`);
            
                    // pub/sub event
                    this.stompClient.connect({},
                        (frame) => {
                            console.log("소켓 연결 성공", frame);
                            this.stompClient.send("/pub/chat/message", {}, JSON.stringify({ messageType: 'ENTER', chatRoomId: this.roomId, writerName: this.sender }));

                            this.stompClient.subscribe(`/sub/chat/room/${this.roomId}`, res => {
                                this.messages.push(JSON.parse(res.body));
                                this.recvMessage(JSON.parse(res.body));
                            });
                        },
                        // 소켓 연결 실패
                        (error) => {
                            console.log("소켓 연결 실패", error);
                            this.connected = false;
                        }
                    );
                }
                
            }
        };

        // function connect() {
        //     // pub/sub event
        //     ws.connect({}, function(frame) {
        //         ws.subscribe("/sub/chat/room/"+vm.$data.roomId, function(message) {
        //             var recv = JSON.parse(message.body);
        //             vm.recvMessage(recv);
        //         });
        //         //채팅방 입장
        //         ws.send("/pub/chat/message", {}, JSON.stringify({type:'ENTER', roomId:vm.$data.roomId, sender:vm.$data.sender}));
        //     }, function(error) {
        //         if(reconnect++ < 5) {
        //             setTimeout(function() {
        //                 // console.log("connection reconnect");
        //                 sock = new SockJS("/ws-stomp");
        //                 ws = Stomp.over(sock);
        //                 connect();
        //             },10*1000);
        //         }
        //     });
        // }
        // connect();
    </script>
