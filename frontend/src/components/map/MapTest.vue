<template>
  <div class="container" id="app" v-cloak>
    <div class="row">
      <div style="height:100px"></div>
      <div class="col-md-12">
          <h2>💬 채팅방</h2>
      </div>
    </div>
    <div class="input-group">
      <div class="input-group-prepend">
        <label class="input-group-text">방제목</label>
      </div>
      <input type="text" class="form-control" v-model="room_name" v-on:keyup.enter="createRoom" />
      <div class="input-group-append">
        <button class="btn btn-primary" type="button" @click="createRoom">채팅방 개설</button>
      </div>
    </div>
    <ul class="list-group">
      <li
        class="list-group-item list-group-item-action"
        v-for="item in maprooms"
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
      maprooms: [],
    };
  },
  created() {
    this.findAllRoom();
  },
  methods: {
    findAllRoom() {
      axios.get("/map/rooms").then((response) => {
        this.maprooms = response.data;
        console.log("findAllRoom");
        console.log(this.maprooms);
      });
    },
    createRoom() {
      console.log("createRoom");
      if ("" === this.room_name) {
        alert("방 제목을 입력해 주십시요.");
        return;
      } else {
        var params = new URLSearchParams();
        params.append("name", this.room_name);
        axios
          .post("/map/room", this.room_name)
          .then((data) => {
            console.log("[" + data.data.name + "] 개설");
            this.room_name = "";
            this.findAllRoom();
          })
          .catch(() => {
            alert("채팅방 개설에 실패하였습니다.");
          });
      }
    },
    enterRoom(roomId) {
      var sender = prompt("대화명을 입력해 주세요.");
      if (sender != "") {
        localStorage.setItem("wschat.sender", sender);
        localStorage.setItem("wschat.roomId", roomId);
        this.$router.push({ name: "mapdetail", params: { roomId: roomId } });
      }
    },
  },
};
</script>

<style>
[v-cloak] {
  display: none;
}
</style>
