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
                <li>
                  <router-link to="/my-profile"
                    ><i class="fas fa-user-circle"></i>내 정보 수정</router-link
                  >
                </li>
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
                      class="accordion-button active d-flex justify-content-end"
                      type="button"
                      data-bs-toggle="collapse"
                      :data-bs-target="'#collapse' + index"
                      aria-expanded="true"
                      :aria-controls="'collapse' + index"
                    >
                      <div class="me-2">
                        {{ res.reservationId }}
                      </div>
                      <div class="me-2">
                        {{ res.guideName }}
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
                      <div>가이드 : {{ res.guideName }}</div>
                      <div>인원 : {{ res.numberOfPeople }}</div>
                      <div>여행날짜 : {{ getDate(res.travelStartDate) }}</div>
                      <div>
                        유아 동반 : {{ res.withChildren }} 장애 여부 :
                        {{ res.withDisabled }} 노약자 동반 :
                        {{ res.withElderly }}
                      </div>
                      <div>특이사항 : {{ res.note }}</div>
                      <div class="d-flex justify-content-end">
                        <button class="me-2 btn btn_theme btn-lg">
                          일정확인
                        </button>

                        <button
                          @click="movereview(res.reservationId,res.guideName)"
                          class="me-2 btn btn_theme btn-lg"
                        >
                          후기작성
                        </button>

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
import { ref } from "vue";
import { reser } from "../../../common/api/commonAPI";
import { useRouter } from "vue-router";

export default {
  name: "NotificationDashboard",
  components: {
    LogoutBtn,
    MyBookingOption,
    picturemodalVue,
  },
  setup() {
    const getDate = (date) => {
      const DAT = new Date(date);
      return (
        DAT.getFullYear() + "-" + (DAT.getMonth() + 1) + "-" + DAT.getDay()
      );
    };
    const router = useRouter();

    const movereview = (id,name) => {
      router.push({
        name: "review",
        params: {
          id: id,
          name: name
        },
      });
    };
    const reservation = ref([]);
    const getreservation = async () => {
      try {
        const res = await reser();
        reservation.value = res.data;
      } catch (err) {
        console.log(err);
      }
    };

    getreservation();

    return {
      reservation,
      getreservation,
      getDate,
      router,
      movereview,
    };
  },
};
</script>
