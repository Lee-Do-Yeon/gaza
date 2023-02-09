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
                    <p><span class="review_rating">4.8/5 Excellent</span> <span class="review_count">(1214
                        reviewes)</span></p>
                    <h3>{{guide.price}} <span>Price starts from</span></h3>
                  </div>
                </div>
              </swiper-slide>

              <!-- <swiper-slide>
                <div class="theme_common_box_two img_hover">
                  <div class="theme_two_box_img">
                    <router-link to="/hotel-details"><img src="../../assets/img/tab-img/hotel2.png" alt="img"></router-link>
                    <p><i class="fas fa-map-marker-alt"></i>Indonesia</p>
                    <div class="discount_tab">
                      <span>50%</span>
                    </div>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link to="/hotel-details">Hotel paradise international</router-link></h4>
                    <p><span class="review_rating">4.8/5 Excellent</span> <span class="review_count">(1214
                        reviewes)</span></p>
                    <h3>$99.00 <span>Price starts from</span></h3>
                  </div>
                </div>
              </swiper-slide>

              <swiper-slide>
                <div class="theme_common_box_two img_hover">
                  <div class="theme_two_box_img">
                    <router-link to="/hotel-details"><img src="../../assets/img/tab-img/hotel3.png" alt="img"></router-link>
                    <p><i class="fas fa-map-marker-alt"></i>Kualalampur</p>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link to="/hotel-details">Hotel kualalampur</router-link></h4>
                    <p><span class="review_rating">4.8/5 Excellent</span> <span class="review_count">(1214
                        reviewes)</span></p>
                    <h3>$99.00 <span>Price starts from</span></h3>
                  </div>
                </div>
              </swiper-slide>

              <swiper-slide>
                <div class="theme_common_box_two img_hover">
                  <div class="theme_two_box_img">
                    <router-link to="/hotel-details"><img src="../../assets/img/tab-img/hotel4.png" alt="img"></router-link>
                    <p><i class="fas fa-map-marker-alt"></i>Mariana island</p>
                    <div class="discount_tab">
                      <span>50%</span>
                    </div>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link to="/hotel-details">Hotel deluxe</router-link></h4>
                    <p><span class="review_rating">4.8/5 Excellent</span> <span class="review_count">(1214
                        reviewes)</span></p>
                    <h3>$99.00 <span>Price starts from</span></h3>
                  </div>
                </div>
              </swiper-slide>

              <swiper-slide>
                <div class="theme_common_box_two img_hover">
                  <div class="theme_two_box_img">
                    <router-link to="/hotel-details"><img src="../../assets/img/tab-img/hotel6.png" alt="img"></router-link>
                    <p><i class="fas fa-map-marker-alt"></i>Beach view</p>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link to="/hotel-details">Thailand grand suit</router-link></h4>
                    <p><span class="review_rating">4.8/5 Excellent</span> <span class="review_count">(1214
                        reviewes)</span></p>
                    <h3>$99.00 <span>Price starts from</span></h3>
                  </div>
                </div>
              </swiper-slide>

              <swiper-slide>
                <div class="theme_common_box_two img_hover">
                  <div class="theme_two_box_img">
                    <router-link to="/hotel-details"><img src="../../assets/img/tab-img/hotel7.png" alt="img"></router-link>
                    <p><i class="fas fa-map-marker-alt"></i>Long island</p>
                  </div>
                  <div class="theme_two_box_content">
                    <h4><router-link to="/hotel-details">Zefi resort and spa</router-link></h4>
                    <p><span class="review_rating">4.8/5 Excellent</span> <span class="review_count">(1214
                        reviewes)</span></p>
                    <h3>$99.00 <span>Price starts from</span></h3>
                  </div>
                </div>
              </swiper-slide> -->
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
import { popularGuide } from '../../../common/api/commonAPI';

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
      }
    })

    const popularGuides = async function () {
      console.log('popularguides');
      const response = await popularGuide()
      state.form.swiperItems = response.data
      console.log(state.form.swiperItems);
    }

    onMounted(() => {
      console.log('guides mounted')
      popularGuides()
    })

    return { popularGuides, state}
  },
};
</script>