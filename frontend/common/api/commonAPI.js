import { apiInstance } from "./index.js";

const api = apiInstance();


//유저구역
//유저 회원가입
const requestSignin = payload => api.post("/users", payload);

//유저 로그인
const requestLogin = (payload) => api.post("/users/login", payload);

//유저 로그인 확인
const requestConfirm = accessToken => api.get("/users/isLogin", {headers: {Authorization: accessToken}})

// 예약내역조회 Notification
const reser = () => api.get("/reservation");

// 인기 가이드 조회
const popularGuide = () => api.get("/guides/popular")

// 유저 예약내역 조회
const reviewss = (payload) => api.get('/review',payload);


const requestConfirmId = userid => api.get(`/users/${userid}`)


export { reviewss, requestLogin, requestSignin, requestConfirm, requestConfirmId, reser, popularGuide};
