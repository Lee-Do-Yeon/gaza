<template>
  <section id="dashboard_main_arae" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="dashboard_sidebar">
            <div class="dashboard_sidebar_user">
              <img src="../../assets/img/common/dashboard-user.png" alt="img" />
              <h3>최지성</h3>
              <div>
                <picturemodalVue />
              </div>
            </div>
            <div class="dashboard_menu_area">
              <ul>
                <li>
                  <router-link to="/dashboard"
                    ><i class="fas fa-list"></i>이용후기</router-link
                  >
                </li>
                <!-- <MyBookingOption /> -->
                <li>
                  <router-link to="/my-profile"
                    ><i class="fas fa-user-circle"></i>내 정보 수정</router-link
                  >
                </li>
                <!-- <li>
                  <router-link to="/wallet"
                    ><i class="fas fa-wallet"></i>Wallet</router-link
                  >
                </li> -->
                <li>
                  <router-link to="/notification" class="active"
                    ><i class="fas fa-bell"></i>예약내역</router-link
                  >
                </li>
                <LogoutBtn />
              </ul>
            </div>
          </div>
        </div>

        <div class="col-lg-8">
          <div class="dashboard_common_table">
            <div class="notification_top_heading">
              <h3>예약 내역</h3>
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
                        <img
                          src="../../assets/img/common/dashboard-user.png"
                          alt="img"
                        />
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
                        <button class="me-2 btn btn_theme btn-lg">
                          일정확인
                        </button>

                        <router-link to="/review"
                          ><button class="me-2 btn btn_theme btn-lg">
                            후기작성
                          </button></router-link
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
import LogoutBtn from "@/components/dashboard/LogoutBtn.vue";
import MyBookingOption from "@/components/dashboard/MyBookingOption.vue";
import picturemodalVue from "../modal/picturemodal.vue";
import axios from "axios";
import { ref } from "vue";
import { reser } from "../../../common/api/commonAPI";

export default {
  name: "NotificationDashboard",
  components: {
    LogoutBtn,
    MyBookingOption,
    picturemodalVue,
  },
  setup() {
    const reservation = ref([]);
    const getreservation = async () => {
      try {
        const res = await reser();
        console.log(res);
        reservation.value = res.data;
      } catch (err) {
        console.log(err);
      }
    };

    getreservation();

    return {
      reservation,
      getreservation,
      instance
    };
  },
};
</script>
