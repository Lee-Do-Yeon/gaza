import axios from "axios";
import { apiInstance } from "./index.js";

const api = apiInstance();

let axiosConfig = {
    headers: {
        "Content-Type": "multipart/form-data",
    }
}


//유저구역
//유저 회원가입
const requestSignin = payload => api.post("/api/users",payload,{ headers: {"Content-Type": "multipart/form-data"}})

// https://i8c207.p.ssafy.io/api/users
//유저 로그인
const requestLogin = (payload) => api.post("/api/users/login", payload);

// 유저 정보 가져오기
const getUserInfo = accessToken => api.get("/api/users", {headers: {Authorization: accessToken}});

//유저 로그인 확인
const requestConfirm = accessToken => api.get("/api/users/isLogin", {headers: {Authorization: accessToken}})

// 유저 패스워드 변경
const changePassword = (payload, accessToken) => {console.log(payload); api.put('/api/users/pw', payload, {headers: {Authorization: accessToken, "Content-Type": 'application/json',}})};

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

// 테마별 가이드 조회
const themaGuide = (payload) => api.get("api/guides/search/thema/", { params: { themaName : payload } })

// 유저 예약내역 조회
const reviewss = (payload) => api.get('/api/reviews/user/ssafy',payload);

//유저 정보수정
const updateUser = (payload, accessToken) => api.put('/api/users/', payload, {headers: {Authorization: accessToken, "Content-Type": "multipart/form-data"}});

//리뷰 등록
const uploadReview =(payload) => api.post('/api/reviews',payload)

const requestConfirmId = userid => api.get(`/api/users/${userid}`)

// 예약
const reserve = payload => {
    console.log(payload);
    api.post('/api/books', payload)
}

//상담 불가능 시간대 설정
const registerTime = payload => {
    console.log(payload)
    
    api.post('/api/guides/time', payload).then((res)=>{console.log(res)});
}

//가이드 마이페이지 수정
const myPageUpdate = (payload) => {
    console.log(payload);
    api.put('/api/guides/mypage', payload, {
        headers: {
            "Content-Type": "multipart/form-data"
        }
    });
}

//가이드 마이페이지 조회
const myPageShow = loginId => api.get('/api/guides/mypage', { params: { userId: loginId } });





// 가이드 검색
const guideSearch = payload => api.get('/api/guides/search/', {params: {searchName: payload }})

const guideDetail = guideId => api.get(`/api/guides/${guideId}`)

//상담 불가능 날짜 등록
const registerDate = payload => {
    console.log(payload)
    api.post('/api/guides/day', payload).then((res)=>{console.log(res)})
};


//가이드 언어 등록
const guideLangRegister = payload => api.post('/api/guides/lang', payload).then((res) => { console.log(res) });


//추천 장소 등록
const guideLocationRegister = (payload) => {
    console.log(payload);
    api.put('/api/guides/location', payload, {
        headers: {
            "Content-Type": "multipart/form-data"
        }
    });
}


export { reviewss, requestLogin, requestSignin, requestConfirm, requestConfirmId, reser, popularGuide, guideSearch, guideDetail,requestGuideRegisterList,uploadReview,updateUser, allowGuideRequest, rejectGuideRequest, reserve, registerTime, myPageUpdate, myPageShow, registerDate, getUserInfo, changePassword, themaGuide, guideLangRegister ,guideLocationRegister};
