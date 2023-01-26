<template>
    <section id="home_two_banner">
        <div class="home_two_banner_slider_wrapper owl-carousel owl-theme">
            <swiper :slides-per-view="1" >
                <swiper-slide>
                    <div class="banner_two_slider_item fadeInUp" data-wow-duration="2s"
                        v-bind:style="{ 'background-image': 'url(' + image + ')' }">
                        <div class="container">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="banner_two_text">
                                        <h3 class="title">BEST TRAVEL AGENCY</h3>
                                        <h1 class="slider-sttle">EXPLORE</h1>
                                        <h2 class="slider-pararp">The world with us!</h2>
                                        <h4 class="slider-pararp">Find awesome flights, hotel, tour, car and packages
                                        </h4>
                                        <div class="home_two_button btn-animation">
                                            <router-link to="/top-destinations"
                                                class="btn btn_theme_white btn_md">Discover</router-link>
                                            <router-link to="/top-destinations"
                                                class="btn btn_theme_transparent btn_md">Know
                                                more</router-link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </swiper-slide>
                <swiper-slide>
                    <div class="banner_two_slider_item fadeInUp" data-wow-duration="2s"
                        v-bind:style="{ 'background-image': 'url(' + image + ')' }">
                        <div class="container">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="banner_two_text">
                                        <h3 class="title">BEST TRAVEL AGENCY</h3>
                                        <h1 class="slider-sttle">EXPLORE</h1>
                                        <h2 class="slider-pararp">The world with us!</h2>
                                        <h4 class="slider-pararp">Find awesome flights, hotel, tour, car and packages
                                        </h4>
                                        <div class="home_two_button btn-animation">
                                            <router-link to="/top-destinations"
                                                class="btn btn_theme_white btn_md">Discover</router-link>
                                            <router-link to="/top-destinations"
                                                class="btn btn_theme_transparent btn_md">Know
                                                more</router-link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </swiper-slide>
                <swiper-slide>
                    <div class="banner_two_slider_item fadeInUp" data-wow-duration="2s"
                        v-bind:style="{ 'background-image': 'url(' + image + ')' }">
                        <div class="container">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="banner_two_text">
                                        <h3 class="title">BEST TRAVEL AGENCY</h3>
                                        <h1 class="slider-sttle">EXPLORE</h1>
                                        <h2 class="slider-pararp">The world with us!</h2>
                                        <h4 class="slider-pararp">Find awesome flights, hotel, tour, car and packages
                                        </h4>
                                        <div class="home_two_button btn-animation">
                                            <router-link to="/top-destinations"
                                                class="btn btn_theme_white btn_md">Discover</router-link>
                                            <router-link to="/top-destinations"
                                                class="btn btn_theme_transparent btn_md">Know
                                                more</router-link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </swiper-slide>
            </swiper>
        </div>
    </section>
</template>
<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import "swiper/swiper-bundle.css";

export default {
    name: "Banner",
    components: {
        Swiper,
        SwiperSlide,
    },
    data() {
        return {
            image: require('@/assets/img/banner/banner-two-bg-1.png'),
            swiper: null,
        };
    }
};
</script>