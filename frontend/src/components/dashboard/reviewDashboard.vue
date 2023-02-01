<template>
  <section id="dashboard_main_arae" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="dashboard_sidebar">
            <div class="dashboard_sidebar_user">
              <img src="../../assets/img/common/dashboard-user.png" alt="img" />
              <h3>최지성</h3>
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
            <div class="write_your_review_wrapper">
              <h3 class="heading_theme">후기작성</h3>
              <div class="write_review_inner_boxed">
                <form action="!#" id="news_comment_form">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-froup">
                        <input
                          type="text"
                          class="form-control bg_input"
                          placeholder="가이드"
                        />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <select class="star form-select form-control">
                        <option selected="selected" value="1">별점 선택하기</option>
                        <option class="star 5">&#xf005 &#xf005 &#xf005 &#xf005 &#xf005</option>
                        <option class="star 4">&#xf005 &#xf005 &#xf005 &#xf005</option>
                        <option class="star 3">&#xf005 &#xf005 &#xf005</option>
                        <option class="star 2">&#xf005 &#xf005</option>
                        <option class="star 1">&#xf005</option>
                      </select>
                    </div>
                    <div class="col-lg-12">
                      <div class="form-froup">
                        <textarea
                          rows="6"
                          placeholder="리뷰를 작성해 주세요"
                          class="form-control bg_input"
                        ></textarea>
                      </div>
                      <div class="comment_form_submit">
                        <button class="btn btn_theme btn_md">
                          제출
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
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

export default {
  name: "reviewDashboard",
  components: {
    LogoutBtn,
    MyBookingOption,
    picturemodalVue,
  },
  setup() {
    const reservation = ref([]);

    const getreservation = async () => {
      try {
        const res = await axios.get("http://localhost:3000/reservation");
        reservation.value = res.data;
      } catch (err) {
        console.log(err);
      }
    };

    getreservation();

    return {
      reservation,
      getreservation,
    };
  },
};
</script>
<style>
    .star{
        font-family: 'Font Awesome 5 Free';
        font-weight : 900;
    }
</style>
