<template>
    <div class="content">
        <h2>여기는 채팅방, 대화하기</h2>
        <ul class="chat_box">
        </ul>
        <form v-on:submit="sendMessage">
            <input name="message" v-model="msg">
            <input name="writerName" v-model="writer">
            <button class="send" type="submit">보내기</button>
        </form>
        <ul class="list-group">
            <li class="list-group-item" v-for="message in messages">
                {{message.writer}} - {{message.message}}
            </li>
        </ul>
    </div>

</template>

<script>
import axios from '@/api/http';
import SockJS from 'sockjs-client';

export default{
    name:"chatDetail",

    data() {
        return {
            roomId: "",
            room: {},
            sender: "",
        };
    },
    created() {
        this.connect();
        this.roomId = localStorage.getItem("wschat.roomId");
        this.sender = localStorage.getItem("wschat.sender");
        this.findRoom();

    },
    methods:{
        sendMessage(){
            console.log(this.msg);
            socket.send(JSON.stringify({messageType:'CHAT', chatRoomId:this.roomId, writerName:this.writer, message:this.message}));
        },

        connect() {

            var socket = new SockJS("http://localhost:8080//ws/chat");//handshake
            this.stompClient = Stomp.over(sock);
            console.log(`소켓 연결을 시도합니다.`);
            
            socket.send(JSON.stringify({messageType:'ENTER', chatRoomId:this.roomId, writerName:this.writer, message:this.message}));
        }, // connect() 끝

    }

}
</script>