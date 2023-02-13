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
                <router-link to="/guideInfoDelete" class="active"
                  >내 정보 삭제</router-link
                >
              </li>
              <li>
                <router-link
                  :to="{
                    name: 'guide_schedule',
                  }"
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
          <!-- 추천장소 조회 및 삭제 -->

          <div class="new_main_news_box">
            <h3 style="font-weight: bold">가이드의 추천 명소 관리</h3>
            <br />
            <div class="row">
              <div
                class="col-lg-4 col-md-6 col-sm-12 col-12"
                v-for="loc in recommendLoc"
                :key="loc.name"
              >
                <div class="news_item_boxed">
                  <form
                    id="profile_form_area"
                    v-on:submit.prevent="locationdelete"
                  >
                    <div class="news_item_img">
                      <img src="../../assets/img/news/news-1.png" alt="img" />
                    </div>
                    <div class="news_item_content">
                      <h3>
                        {{ loc.name }}
                      </h3>
                      <p>{{ loc.address }}</p>

                      <!--end 추천장소 -->
                    </div>
                    <button class="btn btn_theme btn_sm">Delete</button>
                  </form>
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
import { reactive } from "vue";
import { useStore } from "vuex";
import { ref } from "vue";
import {
  locdel,
} from "../../../common/api/commonAPI.js";
import { LanguageBox } from "@/components/hotel/guideSettings/LanguageBox";
const accountStore = "accountStore";
export default {
  name: "GuideInfoDelete",
  components: {
    LanguageBox,
  },
  computed: {
    ...mapState(accountStore, ["userId"]),
  },
  created() {
    this.showList(this.userId);
  },
  data() {
    return {
      recommendLoc: [],
    };
  },
  //   추천장소 조회
  methods: {
    showList(guideId) {
      axios.get(`/guides/location/${guideId}`).then((res) => {
        this.recommendLoc = res.data;
        console.log(this.recommendLoc);
      });
    },
  },
  setup() {
    const store = useStore();

    const date_info = ref(null);
    const pictureData = ref(null);
    const pictureData2 = ref(null);

    const startTime = ref();
    const endTime = ref();

    //가이드 마이페이지 정보
    const guide = reactive({
      info: {
        city: "",
        country: "",
        introduction: "",
        onlineIntroduction: "",
        price: 0,
      },
    });

    //가이드 추천 장소 등록
    const locationdelete = function () {
      const loginId = store.getters["accountStore/getUserId"];

      const payload = {
        loginId: loginId,
        recommendId: recommendLoc.locationId,
      };

      locdel(payload); //call axios
    };

    return {
      store,
      guide,
      date_info,
      endTime,
      startTime,
      pictureData,
      locationdelete,
      location,
      pictureData2,
    };
  },
};
</script>
<style scoped></style>
