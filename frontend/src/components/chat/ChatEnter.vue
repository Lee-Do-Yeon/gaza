<template>
    <div>
        <h1>채팅방 목록</h1>
        <form v-on:submit="makeRoom">
            <input name="title" v-model="roomTitle">
            <button class="send" type="submit">보내기</button>
        </form>
        <ul>
            <li><a href="/chat/rooms/{{roomId}}"></a></li>
        </ul>

    </div>
</template>
<script>
import axios from 'axios';

export default{

    data:{
        roomId:'',
        roomTitle:'',
        roomInfo:{}
    },
    methods:{

        makeRoom(){
            axios.post('https://i8c207.p.ssafy.io/chat/room/' + this.roomTitle).then(response=>{this.roomInfo=response.data});
            console.log(this.roomInfo);
            this.roomId=this.roomInfo.roomId
        }

    }
}
</script>