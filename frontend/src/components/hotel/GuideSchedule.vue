<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-3">
          <div class="dashboard_menu_area">
            <ul>
              <li>
                <router-link to="/room-details"
                  >내 정보 확인 및 수정</router-link
                >
              </li>
              <li>
                <router-link to="/guideInfoDelete"
                  >내 정보 삭제</router-link
                >
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
                          src="../../assets/img/common/dashboard-user.png"
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
                        <button class="btn btn_theme btn-lg">입장</button>
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
    const getDate = (date) => {
      const DAT = new Date(date);
      return (
        DAT.getFullYear() + "-" + (DAT.getMonth() + 1) + "-" + DAT.getDay()
      );
    };
    return {
      getDate,
    };
  },

  data() {
    return {
      reservation: [],
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
  },
};
</script>
