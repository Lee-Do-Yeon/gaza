import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "https://i8c207.p.ssafy.io/api",
  headers: {
    "Content-Type": "application/json;charset=utf-8",
  },
});
