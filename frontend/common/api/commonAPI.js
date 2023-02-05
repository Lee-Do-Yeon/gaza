import { apiInstance } from "./index.js";

const api = apiInstance();


//유저구역
//유저 회원가입
const requestSignin = payload => api.post("/api/users", payload);

//유저 로그인
const requestLogin = (payload) => api.post("/api/login", payload);




// 예약내역조회 Notification
const reser = (payload) => api.get("/reservation", payload);



const requestConfirm = token => api.get("/users/me", {headers: {Authorization: token}})

const requestConfirmId = userid => api.get(`/users/${userid}`)


export { requestLogin, requestSignin, requestConfirm, requestConfirmId, reser};
