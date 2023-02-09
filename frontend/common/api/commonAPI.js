import { apiInstance } from "./index.js";

const api = apiInstance();


//유저구역
//유저 회원가입
const requestSignin = payload => api.post("/api/users", payload, {headers: { 'Content-Type': 'multipart/form-data'}});

//유저 로그인
const requestLogin = (payload) => api.post("/api/users/login", payload);

//유저 로그인 확인
const requestConfirm = accessToken => api.get("/api/users/isLogin", {headers: {Authorization: accessToken}})

// 가이드 신청 중인 유저 목록
const requestGuideRegisterList = (payload) => api.get("/api/users/guide", payload);

// 가이드 신청 승인
const allowGuideRequest = (payload) => api.put("/api/users/guide/success", payload);

// 가이드 신청 거부
const rejectGuideRequest = (payload) => api.put("/api/users/guide/failure", payload);

// 예약내역조회 Notification
const reser = (payload) => api.get("/api/books/user/ssafy",payload);

// 인기 가이드 조회
const popularGuide = () => api.get("/api/guides/popular")

// 유저 예약내역 조회
const reviewss = (payload) => api.get('/api/reviews/user/ssafy',payload);

//유저 정보수정
const updateUser = () => api.put('/api/users/ssafy');

//리뷰 등록
const uploadReview =(payload) => api.post('/api/reviews',payload)



const requestConfirmId = userid => api.get(`/api/users/${userid}`)


// 가이드 검색
const guideSearch = payload => api.get('/api/guides/search/', {params: {searchName: payload }})

const guideDetail = guideId => api.get(`/guides/${guideId}`)

export { reviewss, requestLogin, requestSignin, requestConfirm, requestConfirmId, reser, popularGuide, guideSearch, guideDetail,requestGuideRegisterList,uploadReview,updateUser, allowGuideRequest, rejectGuideRequest};
