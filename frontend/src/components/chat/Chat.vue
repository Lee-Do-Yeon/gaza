<template>
    <div class="content">
        <h2>채팅방</h2>
        <ul class="chat_box">
        </ul>
        <form v-on:submit="sendMessage">
            <input name="message" v-model="msg">
            <button class="send" type="submit">보내기</button>
        </form>
    </div>

</template>

<script>
import axios from 'axios';
import { response } from 'express';
var socket = new SockJS("/ws/chat");//handshake

export default{
    name:"Chat",

    data:{
        message:'',
        roomId:'',
        writer:'',
        room:{}
    },

    created(){
        
    },
    methods:{
        sendMessage(){
            console.log(this.msg);
            socket.send(JSON,stringify({messageType:'CHAT', chatRoomId:this.roomId, writerName:this.writer, message:this.message}));
        },
        connect(){

        },

    }

}
</script>