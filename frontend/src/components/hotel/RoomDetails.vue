<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-3">
          <div class="dashboard_menu_area">
            <ul>
              <li>
                <router-link to="/room-details" class="active">내 정보 확인 및 수정</router-link>
              </li>
              <li>
                <!-- <router-link
                  :to="{
                    name: 'guide_schedule',
                    params: { guideId: this.userId },
                  }"
                  >상담일정 확인</router-link
                > -->
              </li>

              <li>
                <!-- <router-link
                  :to="{
                    name: 'guide_review',
                    params: { guideId: this.userId },
                  }"
                  >리뷰조회</router-link
                > -->
              </li>
            </ul>
          </div>
        </div>

        <div class="col">
          <div class="tour_details_leftside_wrapper">
            <div class="tour_details_heading_wrapper">
              <div></div>
            </div>
            <hr />

            <!--자기소개 form -->
            <form class="d-flex" v-on:submit.prevent="updateMyPage">
              <div class="dashboard_common_table" style="height: 655px">
                <img
                  style="width: 300px; height: 150px; border-radius: 50%"
                  src="../../assets/img/common/dashboard-user.png"
                  alt="img"
                />
                <div style="text-align: center; padding: 60px">
                  <button class="btn btn_theme">사진 업로드</button>
                </div>
              </div>

              <div class="ms-3">
                <div class="dashboard_common_table">
                  <h3>내 정보 수정</h3>
                  <div class="profile_update_form">
                    <form action="!#" id="profile_form_area" v-on:submit="updateMyPage">
                      <div class="row">
                        <div class="col-lg-20">
                          <div class="form-group">
                            <label for="f-one-liner">One-liner</label>
                            <input
                              type="text"
                              class="form-control"
                              id="f-one-liner"
                              v-model="guide_info.onlineIntroduction"
                            />
                          </div>
                        </div>
                        <div class="col-lg-20">
                          <div class="form-group">
                            <label for="l-price">Price</label>
                            <input
                              type="text"
                              class="form-control"
                              id="l-price"
                              v-model="guide_info.price"
                            />
                          </div>
                        </div>
                        <div class="col-lg-6">
                          <div class="form-group">
                            <label for="country">Country</label>
                            <input
                              type="text"
                              class="form-control"
                              id="country"
                              v-model="guide_info.country"
                            />
                          </div>
                        </div>
                        <div class="col-lg-6">
                          <div class="form-group">
                            <label for="city">City</label>
                            <input
                              type="text"
                              class="form-control"
                              id="city"
                              v-model="guide_info.city"
                            />
                          </div>
                        </div>
                        <div class="change_password_input_boxed">
                          <h3>Introduction</h3>
                          <div class="row">
                            <div class="col-lg-20">
                              <div class="form-group">
                                <textarea
                                  type="text"
                                  class="form-control"
                                  placeholder="Introduction"
                                  v-model="guide_info.introduction"
                                ></textarea>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                  <div class="d-flex justify-content-end mt-3">
                    <button class="btn btn_theme">수정</button>
                    <withdrawVue />
                  </div>
                </div>
              </div>
            </form>

            <!--start 추천 장소 -->
            <div class="new_main_news_box">
              <br />
              <h3 style="font-weight: bold">가이드의 추천 명소</h3>
              <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <router-link to="/news-details"
                        ><img src="../../assets/img/news/news-1.png" alt="img"
                      /></router-link>
                    </div>
                    <div class="news_item_content">
                      <h3>
                        <router-link to="/news-details">한강 </router-link>
                      </h3>
                      <p>대한민국 치킨 맛집</p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <router-link to="/news-details"
                        ><img src="../../assets/img/news/news-2.png" alt="img"
                      /></router-link>
                    </div>
                    <div class="news_item_content">
                      <h3>
                        <router-link to="/news-details"> 전주 </router-link>
                      </h3>
                      <p>대한민국 비빔밥 맛집</p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <router-link to="/news-details"
                        ><img src="../../assets/img/news/news-3.png" alt="img"
                      /></router-link>
                    </div>
                    <div class="news_item_content">
                      <h3>
                        <router-link to="/news-details"> 완도 </router-link>
                      </h3>
                      <p>대한민국 김 맛집</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- end 추천장소-->
          </div>
          <hr />
          <h3 style="font-weight: bold">상담 불가 날짜/시간 설정</h3>
          <br />
          <div class="row d-flex justify-content-center">
            <div class="col-lg-4 me-5">
              <h5 style="color: #15d4cd">Choose a Date</h5>
              <br />
              <div class="form_search_date">
                <div class="flight_Search_boxed date_flex_area">
                  <div class="Journey_date">
                    <input type="date" value="2023-02-01" />
                  </div>
                </div>
              </div>
            </div>

            <!--start 시간대 설정 form -->
            <div class="col-lg-4 ms-5">
              <form v-on:submit.prevent="registerTime">
                <h5 style="color: #15d4cd">Pick a time</h5>
                <div class="tour_details_boxed">
                  <div class="btn-group" role="group" v-for="index in 4" :key="index">
                    <button
                      type="button"
                      id
                      class="btn btn_theme btn_sm me-1 mb-2"
                      :value="(index - 1) * 6 + btn_index"
                      @click="setTime"
                      v-for="btn_index in 6"
                      :key="btn_index"
                    >
                      {{
                        (index - 1) * 6 + btn_index < 10
                          ? "0" + ((index - 1) * 6 + btn_index)
                          : (index - 1) * 6 + btn_index
                      }}
                    </button>
                  </div>
                </div>
                <button class="btn btn_theme btn_sm">submit</button>
              </form>
            </div>
            <!--end 시간대 설정 form -->
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { onMounted, reactive } from "vue";
import { useStore } from "vuex";
import { useRoute } from "vue-router";
import { registerTime, myPageUpdate } from "../../../common/api/commonAPI.js";

export default {
  setup() {
    const store = useStore();

    const time_info = reactive({
      hour: "",
      minute: "",
      nano: 0,
      second: "",
    });

    const guide_info = reactive({
      city: "",
      country: "",
      introduction: "",
      onlineIntroduction: "",
      price: Object,
    });

    onMounted(() => {});

    const registerTime = function () {
      const set_time_info = {
        userId: store.getters["accountStore/getUserId"],
        startTime: {
          time_info,
        },
        endTime: {
          time_info,
        },
      };
    };

    registerTime();

    //마이페이지 수정
    const updateMyPage = function () {
      console.log(guide_info);

      const info = {
        city: guide_info.city,
        country: guide_info.country,
        introduction: guide_info.introduction,
        onlineIntroduction: guide_info.onlineIntroduction,
        price: guide_info.price,
      };

      myPageUpdate(info); //call axios
    };

    return {
      registerTime,
      store,
      time_info,
      updateMyPage,
      guide_info,
    };
  },
};
</script>

<style scoped></style>
