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
                <router-link
                  :to="{
                    name: 'guide_schedule',
                  }"
                  >상담일정 확인</router-link
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
                <div v-for="(res, index) in reservation" :key="res.id" class="accordion-item">
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
                        {{ res.guide_id }}
                      </div>
                      <div>Date : {{ res.travel_start_date }}</div>
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
                        <img src="../../assets/img/common/dashboard-user.png" alt="img" />
                      </div>
                      <div>가이드 : {{ res.guide_id }}</div>
                      <div>인원 : {{ res.number_of_people }}</div>
                      <div>여행날짜 : {{ res.travel_start_date }}</div>
                      <div>
                        유아 동반 : {{ res.with_children }} 장애 여부 :
                        {{ res.with_disabled }} 노약자 동반 :
                        {{ res.with_elderly }}
                      </div>
                      <div>특이사항 : {{ res.note }}</div>
                      <div class="d-flex justify-content-end">
                        <button class="me-2 btn btn_theme btn-lg">일정확인</button>

                        <router-link to="/review"
                          ><button class="me-2 btn btn_theme btn-lg">후기작성</button></router-link
                        >

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

  data() {
    return {
      reservation: [],
    };
  },
  computed: {
    ...mapState(accountStore, ["userId"]),
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
