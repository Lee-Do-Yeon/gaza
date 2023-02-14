<template>
    <section id="tour_details_main" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <div class="dashboard_menu_area">
                        <ul>
                            <li>
                                <router-link to="/room-details">내 정보 확인 및 수정</router-link>
                            </li>
                            <li>
                                <router-link to="/guideInfoDelete">내 정보 삭제</router-link>
                            </li>
                            <li>
                                <router-link
                                    :to="{
                                        name: 'guide_schedule',
                                    }"
                                    class="active"
                                    >예약내역 확인</router-link
                                >
                            </li>
                            <li>
                                <router-link
                                    :to="{
                                        name: 'guide_review',
                                    }"
                                    >리뷰조회</router-link
                                >
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col">
                    <div class="dashboard_common_table">
                        <div class="notification_top_heading">
                            <h3>상담일정 확인</h3>
                        </div>
                        <div class="notification_wrapper">
                            <div class="accordion" id="accordionExample">
                                <div
                                    v-for="(res, index) in reservation"
                                    :key="res.id"
                                    class="accordion-item"
                                >
                                    <h2 class="accordion-header" :id="'heading' + index">
                                        <button
                                            class="accordion-button active d-flex justify-content-between"
                                            type="button"
                                            data-bs-toggle="collapse"
                                            :data-bs-target="'#collapse' + index"
                                            aria-expanded="true"
                                            :aria-controls="'collapse' + index"
                                        >
                                            <div>
                                                {{ res.userName }}
                                            </div>
                                            <div>Date : {{ getDate(res.travelStartDate) }}</div>
                                        </button>
                                    </h2>
                                    <div
                                        :id="'collapse' + index"
                                        class="accordion-collapse collapse"
                                        :aria-labelledby="'heading' + index"
                                        data-bs-parent="#accordionExample"
                                    >
                                        <div class="accordion-body">
                                            <div>
                                                <img
                                                    :src="baseURL+res.picture"
                                                    alt="img"
                                                />
                                            </div>
                                            <div>인원 : {{ res.numberOfPeople }}</div>
                                            <div>여행날짜 : {{ getDate(res.travelStartDate) }}</div>
                                            <div>
                                                유아 동반 : {{ res.withChildren }} 장애 여부 :
                                                {{ res.withDisabled }} 노약자 동반 :
                                                {{ res.withElderly }}
                                            </div>
                                            <div>특이사항 : {{ res.note }}</div>
                                            <div class="d-flex justify-content-end">
                                                <button
                                                    class="btn btn_theme btn-lg"
                                                    @click="createConsulting(res.reservationId, res.guidePk)"
                                                >
                                                    상담 시작
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import axios from "@/api/http";
import { mapState } from "vuex";
const accountStore = "accountStore";

export default {
    name: "GuideSchedule",
    setup() {
        const baseURL = "https://s3.ap-northeast-2.amazonaws.com/ssafy.common.gaza//gaza/guide/mypage/";
        const getDate = (date) => {
            const DAT = new Date(date);
            return DAT.getFullYear() + "-" + (DAT.getMonth() + 1) + "-" + DAT.getDay();
        };
        return {
            getDate,
            baseURL
        };
    },

    data() {
        return {
            reservation: [],
            mySessionId: "",
        };
    },
    computed: {
        ...mapState(accountStore, ["userId"]),
    },
    created() {
        this.showList(this.userId);
    },

    methods: {
        showList(guideId) {
            //상담 일정을 가져옴
            axios.get(`/books/guide/${guideId}`).then((res) => {
                this.reservation = res.data;
                console.log(this.reservation);
            });
        },
        async createMapRoom(reservationId) {
            var base = this;
            console.log("createMapRoom");
            await axios
                .post("/map/room", reservationId)
                .then((data) => {
                    console.log("[" + data.data.roomId + "] 개설");
                    base.mySessionId = data.data.roomId;
                })
                .catch(() => {
                    alert("지도방 개설에 실패하였습니다.");
                });
            // 세션 아이디 저장.
            await axios
            .patch("/books/consulting/create?reservationId="+ reservationId+"&sessionId="+base.mySessionId)
            .then((data) => {
              console.log("예약 테이블에 세션 아이디 추가. " + base.mySessionId);
            })
            .catch(() => {
              alert("예약 데이터 업데이트에 실패하였습니다.");
            });
        },
        async createConsulting(reservationId, guidePk) {
            console.log("아이디: " + reservationId);
            await this.createMapRoom(reservationId);
            console.log("세션 아이디: " + this.mySessionId);
            const routeData = this.$router.resolve({
                name: "mapdetail",
                params: {
                    roomId: this.mySessionId,
                    reservationId: reservationId,
                    guideId: this.userId,
                    guidePk: guidePk,
                    userName: this.userId, // 원래 이름인데 일단 아이디로.
                },
            });
            window.open(routeData.href, "_blank");
        },
    },
};
</script>
