<template>


  <section id="promotional_tours" class="section_padding_top">
    <div class="container">
      <!-- Section Heading -->
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-12">
          <div class="section_heading_center">
            <h2>인기 가이드</h2>
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
                      name: 'hotel-details',
                      params: { guideId: guide.guideId },
                  }"><img src="../../assets/img/tab-img/hotel1.png" alt="img"></router-link>
                    <p><i class="fas fa-map-marker-alt"></i>{{ guide.country }}, {{ guide.city }}</p>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link :to="{
                        name: 'hotel-details',
                        params: { guideId: guide.guideId  },
                      }"
                      >{{ guide.name }}</router-link></h4>
                    <p><span class="review_rating">
                        <span v-for="lang in guide.language" :key="lang">#{{ lang }}</span>
                    </span> <span class="review_count">
                      <span v-for="theme in guide.thema" :key="theme" >#{{ theme }}</span>
                    </span></p>
                    <h3>{{guide.price}} <span>Price starts from</span></h3>
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
import router from "@/router";
import { popularGuide, themaGuide } from '../../../common/api/commonAPI';

export default {
  name: "PromotionalTours",

  components: {
    Swiper,
    SwiperSlide,
  },

  setup(props, { emit }) {

    const state = reactive({
      form: {
        swiperItems: null,
      },
      // themas: [ '힐링', '액티비티', '맛집', '유명관광지', '로컬관광지', '쇼핑', '식사', '관광', '숙박', '쇼핑', '체험' ]
    })

    // const rand_0_10 = Math.floor(Math.random() * 11);

    const popularGuides = async function () {
      console.log('popularguides');
      const response = await popularGuide()
      state.form.swiperItems = response.data
      console.log(state.form.swiperItems);
    }

    // const themaGuides = async function () {
    //   console.log('themaguides');
    //   console.log(rand_0_10);
    //   const searchT = state.themas[Math.floor(Math.random() * 11)]
    //   console.log(searchT);
    //   const response = await themaGuide(searchT)
    //   console.log(response.data)
    // }

    onMounted(() => {
      console.log('guides mounted')
      popularGuides()
      // themaGuides()
      
    })

    return { popularGuides, state}
  },
};
</script>