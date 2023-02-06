<template>
  <div class="container" id="app" v-cloak>
    <div class="row">
      <div style="height: 100px"></div>
      <div class="col-md-12">
        <h2>💬 채팅방</h2>
      </div>
    </div>
    <div class="input-group">
      <div class="input-group-prepend">
        <label class="input-group-text">방제목</label>
      </div>
      <input
        type="text"
        class="form-control"
        v-model="room_name"
        v-on:keyup.enter="createRoom"
      />
      <div class="input-group-append">
        <button class="btn btn-primary" type="button" @click="createRoom">
          채팅방 개설
        </button>
      </div>
    </div>
    <ul class="list-group">
      <li
        class="list-group-item list-group-item-action"
        v-for="item in chatrooms"
        v-bind:key="item.roomId"
        v-on:click="enterRoom(item.roomId)"
      >
        {{ item.name }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "@/api/http";

export default {
  data() {
    return {
        room_name: "",
        chatrooms: []
    }
  },
   
  created() {
    this.findAllRoom();
  },
  methods: {
    findAllRoom: function () {
      axios.get("/chat/room").then((response) => {
        this.chatroms = response.data;
        console.log(this.chatrooms);
      });
    },
    createRoom: function () {
      if ("" === this.room_name) {
        alert("방 제목을 입력해 주십시요.");
        return;
      } else {
        axios
          .post("/chat/room", {"name":this.room_name})
          .then((response) => {
            alert(response.data.name + "방 개설에 성공하였습니다.");
            this.room_name = "";
            this.findAllRoom();
          })
          .catch((response) => {
            alert("채팅방 개설에 실패하였습니다.");
          });
      }
    },
    enterRoom: function (roomId) {
      var sender = prompt("닉네임 입력해 주세요.");
      localStorage.setItem("wschat.sender", sender);
      localStorage.setItem("wschat.roomId", roomId);
      location.href = "/chat/room" + roomId;
    },
  },
};
</script>
<!-- <style>
[v-cloak] {
  display: none;
}
</style> -->
