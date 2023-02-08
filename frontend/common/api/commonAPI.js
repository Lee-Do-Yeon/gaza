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
const reser = (payload) => api.get("/books/user/ssafy",payload);

// 인기 가이드 조회
const popularGuide = () => api.get("/guides/popular")

// 유저 예약내역 조회
const reviewss = (payload) => api.get('/reviews/user/ssafy',payload);

//유저 정보수정
const updateUser = () => api.put('/users/ssafy');

//리뷰 등록
const uploadReview =(payload) => api.post('/reviews',payload)



const requestConfirmId = userid => api.get(`/users/${userid}`)


// 가이드 검색
const guideSearch = payload => api.get('/guides/search/', {params: {searchName: payload }})


export {updateUser,uploadReview, reviewss, requestLogin, requestSignin, requestConfirm, requestConfirmId, reser, popularGuide, guideSearch};
