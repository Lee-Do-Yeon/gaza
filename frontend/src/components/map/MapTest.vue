<template>
  <div class="container" id="app" v-cloak>
    <div class="row">
      <div style="height:100px"></div>
      <div class="col-md-12">
          <h2>💬 방</h2>
      </div>
    </div>
    <div class="input-group">
      <div class="input-group-prepend">
        <label class="input-group-text">방제목</label>
      </div>
      <input type="text" class="form-control" v-model="room_name"/>
      <div class="input-group-prepend">
        <label class="input-group-text">유저네임</label>
      </div>
      <input type="text" class="form-control" v-model="myUserName"/>
      <div class="input-group-append">
        <button class="btn btn-primary" type="button" @click="joinSession">개설</button>
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
import axios from "axios";

axios.defaults.headers.post["Content-Type"] = "application/json";

const APPLICATION_SERVER_URL = "https://i8c207.p.ssafy.io/api";

export default {
  data() {
    return {
      room_name: "roomName testest",
      // OpenVidu 객체들
      OpenVidu: {
        OV: undefined,
        session: undefined,
        mainStreamManager: undefined,
        publisher: undefined,
        subscribers: [],
      },
      // Join form
      mySessionId: "SessionA",
      myUserName: "Participant" + Math.floor(Math.random() * 100),
      maprooms: [],
    };
  },
  created() {
    this.findAllRoom();
  },
  methods: {
    findAllRoom() {
      axios.get(APPLICATION_SERVER_URL + "/map/rooms").then((response) => {
        this.maprooms = response.data;
        console.log("findAllRoom");
        console.log(this.maprooms);
      });
    },
    async createRoom() {
      var base = this;
      console.log("createRoom");
      if ("" === this.room_name) {
        alert("방 제목을 입력해 주세요.");
        return;
      } else {
        // var params = new URLSearchParams();
        // params.append("name", this.room_name);
        await axios
          .post(APPLICATION_SERVER_URL + "/map/room", this.room_name)
          .then((data) => {
            console.log("[" + data.data.roomId + "] 개설");
            base.mySessionId = data.data.roomId;
          })
          .catch(() => {
            alert("방 개설에 실패하였습니다.");
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
    async joinSession() {
      await this.createRoom();
      this.$router.push({ name: "mapdetail", params: { roomId: this.mySessionId } });
    },
  },
};
</script>

<style>
[v-cloak] {
  display: none;
}
</style>
