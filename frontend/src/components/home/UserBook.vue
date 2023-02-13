<template >
  <section v-show="state.istemplate" id="promotional_tours" class="section_padding_top">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-12">
          <div class="section_heading_center">
            <h2>예약 내역</h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="promotional_tour_slider owl-theme owl-carousel dot_style">
            <swiper :slides-per-view="4"  :space-between="20" :pagination="{ clickable: true }">
              <swiper-slide v-for="guide in state.form.swiperItems" :key="guide.name">
                <div class="theme_common_box_two img_hover">
                  <div class="theme_two_box_img">
                    <router-link :to="{
                      name: 'notification',
                  }"><img src="../../assets/img/tab-img/hotel1.png" alt="img"></router-link>
                    <p>{{ guide.guideName }}</p>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link :to="{
                        name: 'notification',
                      }"
                      >{{ guide.guideName }}</router-link></h4>
                    <p><span class="review_rating">
                        <span>{{ guide.consultingDate.substr(0,4) }}년 {{ guide.consultingDate.substr(5,2) }}월 {{ guide.consultingDate.substr(8,2) }}일 {{ guide.consultingDate.substr(11, 2) }}시 {{ guide.consultingDate.substr(14,2) }}분 상담 예약</span>
                    </span> 
                    </p>
                    <router-link :to="{ name: 'notification'}"><button type="button" class="btn btn_theme">예약내역</button></router-link>
                  </div>
                </div>
              </swiper-slide>
            </swiper>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
  
<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import "swiper/swiper-bundle.css";
import { reactive, computed, ref, onMounted, watch } from 'vue';
import { useStore } from 'vuex';
import { userBookGuide } from '../../../common/api/commonAPI';

export default {
  name: "UserBook",

  components: {
    Swiper,
    SwiperSlide,
  },

  setup(props, { emit }) {

    const store = useStore()

    const state = reactive({
      form: {
        swiperItems: null,
      },
      istemplate: true,
    })

    const bookedGuides = async function () {
      const userId = store.getters["accountStore/getUserId"]
      const response = await userBookGuide(userId)
      const isLogin = store.getters["accountStore/getIsLogin"]
      const isBooked = (response.data.length == 0) ? false : true
      state.istemplate = (isLogin && isBooked) ? true : false
      state.form.swiperItems = response.data
    }

    onMounted(() => {

      bookedGuides()
    })

    return { state }
  },
};
</script>