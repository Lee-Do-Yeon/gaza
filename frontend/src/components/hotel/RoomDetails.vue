<template>
    <section id="tour_details_main" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="tour_details_leftside_wrapper">
                        <div class="tour_details_heading_wrapper">
                            <div class="tour_details_top_heading">
                                <h2>Double deluxe room</h2>
                                <h5><i class="fas fa-map-marker-alt"></i> Los angeles</h5>
                            </div>
                            <div class="tour_details_top_heading_right">
                                <h4>Excellent</h4>
                                <h6>4.8/5</h6>
                                <p>(1214 reviewes)</p>
                            </div>
                        </div>
                        <div class="tour_details_img_wrapper">

                            <div class="image__gallery">
                                <div class="gallery">
                                    <div class="gallery__slideshow">
                                        <div class="gallery__slides">
                                            <div class="gallery__slide">
                                                <img class="gallery__img" :src="slide.img" alt=""
                                                    v-for="(slide, index) in gallerySlides" :key="index" :style="
                                                        slideIndex === index
                                                            ? 'display:block;'
                                                            : 'display:none;'
                                                    " />
                                            </div>
                                        </div>
                                        <a @click.prevent="move(-1)" class="gallery__prev">&#10095;</a>
                                        <a @click.prevent="move(1)" class="gallery__next">&#10094;</a>
                                    </div>

                                    <div class="gallery__content">
                                        <div class="gallery__items">

                                            <div class="gallery__item" :class="{
                                                'gallery__item--is-acitve': slideIndex === index
                                            }" v-for="(slide, index) in gallerySlides" :key="`item-${index}`">
                                                <img :src="slide.img" @click="currentSlide(index)"
                                                    class="gallery__item-img" />
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tour_details_boxed">
                            <h3 class="heading_theme">Overview</h3>
                            <div class="tour_details_boxed_inner">
                                <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod
                                    tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero
                                    eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea
                                    takimata sanctus est.
                                </p>
                                <p>
                                    Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
                                    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod.
                                </p>
                                <ul>
                                    <li><i class="fas fa-circle"></i>Buffet breakfast as per the Itinerary</li>
                                    <li><i class="fas fa-circle"></i>Visit eight villages showcasing Polynesian culture
                                    </li>
                                    <li><i class="fas fa-circle"></i>Complimentary Camel safari, Bonfire, and Cultural
                                        Dance at Camp</li>
                                    <li><i class="fas fa-circle"></i>All toll tax, parking, fuel, and driver allowances
                                    </li>
                                    <li><i class="fas fa-circle"></i>Comfortable and hygienic vehicle (SUV/Sedan) for
                                        sightseeing on all days as per the itinerary.</li>
                                </ul>
                            </div>
                        </div>
                        <div class="tour_details_boxed">
                            <h3 class="heading_theme">Included/Excluded</h3>
                            <div class="tour_details_boxed_inner">
                                <p>
                                    Stet clitaStet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor
                                    sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
                                    eirmod.
                                </p>
                                <ul>
                                    <li><i class="fas fa-circle"></i>Buffet breakfast as per the Itinerary</li>
                                    <li><i class="fas fa-circle"></i>Visit eight villages showcasing Polynesian culture
                                    </li>
                                    <li><i class="fas fa-circle"></i>Complimentary Camel safari, Bonfire, and Cultural
                                        Dance at Camp</li>
                                    <li><i class="fas fa-circle"></i>All toll tax, parking, fuel, and driver allowances
                                    </li>
                                    <li><i class="fas fa-circle"></i>Comfortable and hygienic vehicle (SUV/Sedan) for
                                        sightseeing on all days as per the itinerary.</li>
                                </ul>
                            </div>
                        </div>
                        <div class="tour_details_boxed">
                            <h3 class="heading_theme">Room facilities</h3>
                            <div class="tour_details_boxed_inner">
                                <div class="room_details_facilities">
                                    <div class="toru_details_top_bottom_item">
                                        <div class="tour_details_top_bottom_icon">
                                            <img src="../../assets/img/icon/ac.png" alt="icon">
                                        </div>
                                        <div class="tour_details_top_bottom_text">
                                            <p>Air condition</p>
                                        </div>
                                    </div>
                                    <div class="toru_details_top_bottom_item">
                                        <div class="tour_details_top_bottom_icon">
                                            <img src="../../assets/img/icon/tv.png" alt="icon">
                                        </div>
                                        <div class="tour_details_top_bottom_text">
                                            <p>Flat television</p>
                                        </div>
                                    </div>
                                    <div class="toru_details_top_bottom_item">
                                        <div class="tour_details_top_bottom_icon">
                                            <img src="../../assets/img/icon/gym.png" alt="icon">
                                        </div>
                                        <div class="tour_details_top_bottom_text">
                                            <p>Fitness center</p>
                                        </div>
                                    </div>
                                    <div class="toru_details_top_bottom_item">
                                        <div class="tour_details_top_bottom_icon">
                                            <img src="../../assets/img/icon/wifi.png" alt="icon">
                                        </div>
                                        <div class="tour_details_top_bottom_text">
                                            <p>Free Wi-fi</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="tour_details_right_sidebar_wrapper">
                        <div class="tour_detail_right_sidebar">
                            <div class="tour_details_right_boxed">
                                <div class="tour_details_right_box_heading">
                                    <h3>Price</h3>
                                </div>
                                <div class="tour_package_bar_price">
                                    <h6><del>$ 35,500</del></h6>
                                    <h3>$ 30,500 <sub>/Per serson</sub> </h3>
                                </div>

                                <div class="tour_package_details_bar_list">
                                    <h5>Hotel facilities</h5>
                                    <ul>
                                        <li><i class="fas fa-circle"></i>Buffet breakfast as per the Itinerary</li>
                                        <li><i class="fas fa-circle"></i>Visit eight villages showcasing Polynesian
                                            culture
                                        </li>
                                        <li><i class="fas fa-circle"></i>Complimentary Camel safari, Bonfire,</li>
                                        <li><i class="fas fa-circle"></i>All toll tax, parking, fuel, and driver
                                            allowances
                                        </li>
                                        <li><i class="fas fa-circle"></i>Comfortable and hygienic vehicle</li>
                                    </ul>
                                </div>

                            </div>
                            <div class="tour_select_offer_bar_bottom">
                                <button class="btn btn_theme btn_md w-100" data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">Book Now</button>
                            </div>

                            <!-- Offcanvas Area -->
                            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
                                aria-labelledby="offcanvasRightLabel">

                                <div class="offcanvas-header">
                                    <h5 id="offcanvasRightLabel">Book now</h5>
                                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                                        aria-label="Close"></button>
                                </div>
                                <div class="offcanvas-body">
                                    <div class="side_canvas_wrapper">
                                        <div class="travel_date_side">
                                            <div class="form-group">
                                                <label for="dates">Select your travel date</label>
                                                <input type="date" value="2022-05-05" class="form-control" id="dates">
                                            </div>
                                        </div>
                                        <div class="select_person_side">
                                            <h3>Select person</h3>
                                            <div class="select_person_item">
                                                <div class="select_person_left">
                                                    <h6>Adult</h6>
                                                    <p>12y+</p>
                                                </div>
                                                <div class="select_person_right">
                                                    <div class="button-set">
                                                        <button type="button">
                                                            <i class="fas fa-plus"></i>
                                                        </button>
                                                        <span>01</span>
                                                        <button type="button">
                                                            <i class="fas fa-minus"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="select_person_item">
                                                <div class="select_person_left">
                                                    <h6>Children</h6>
                                                    <p>2 - 12 years</p>
                                                </div>
                                                <div class="select_person_right">
                                                    <div class="button-set">
                                                        <button type="button">
                                                            <i class="fas fa-plus"></i>
                                                        </button>
                                                        <span>01</span>
                                                        <button type="button">
                                                            <i class="fas fa-minus"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="select_person_item">
                                                <div class="select_person_left">
                                                    <h6>Infant</h6>
                                                    <p>Below 2 years</p>
                                                </div>
                                                <div class="select_person_right">
                                                    <div class="button-set">
                                                        <button type="button">
                                                            <i class="fas fa-plus"></i>
                                                        </button>
                                                        <span>01</span>
                                                        <button type="button">
                                                            <i class="fas fa-minus"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="write_spical_not">
                                                <label for="texts">Write any special note</label>
                                                <textarea rows="5" class="form-control"
                                                    placeholder="Write any special note" id="texts"></textarea>
                                            </div>
                                            <div class="form-check write_spical_check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="flexCheckDefaultf1">
                                                <label class="form-check-label" for="flexCheckDefaultf1">
                                                    <span class="main_spical_check">
                                                        <span>I read and accept all <router-link
                                                                to="/terms-service">Terms
                                                                and conditios</router-link></span>
                                                    </span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="proceed_booking_btn">
                                    <a href="#!" class="btn btn_theme btn_md w-100">Proceed to
                                        Booking</a>
                                </div>
                            </div>

                        </div>
                        <div class="tour_detail_right_sidebar">
                            <div class="tour_details_right_boxed">
                                <div class="tour_details_right_box_heading">
                                    <h3>Why choose us</h3>
                                </div>

                                <div class="tour_package_details_bar_list first_child_padding_none">
                                    <ul>
                                        <li><i class="fas fa-circle"></i>Buffet breakfast as per the Itinerary</li>
                                        <li><i class="fas fa-circle"></i>Visit eight villages showcasing Polynesian
                                            culture
                                        </li>
                                        <li><i class="fas fa-circle"></i>Complimentary Camel safari, Bonfire,</li>
                                        <li><i class="fas fa-circle"></i>All toll tax, parking, fuel, and driver
                                            allowances
                                        </li>
                                        <li><i class="fas fa-circle"></i>Comfortable and hygienic vehicle</li>
                                    </ul>
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

export default {
    name: "RoomDetails",
    data() {
        return {

            gallerySlides: [
                { img: require('@/assets/img/hotel/hotel-big-1.png') },
                { img: require('@/assets/img/hotel/hotel-big-1.png') },
                { img: require('@/assets/img/hotel/hotel-big-1.png') },
                { img: require('@/assets/img/hotel/hotel-big-1.png') },
                { img: require('@/assets/img/hotel/hotel-big-1.png') },
                { img: require('@/assets/img/hotel/hotel-big-1.png') },
                { img: require('@/assets/img/hotel/hotel-big-1.png') }
            ],

            slideIndex: 0,

            slides: [
                { img: require('@/assets/img/hotel/small-1.png') },
                { img: require('@/assets/img/hotel/small-2.png') },
                { img: require('@/assets/img/hotel/small-3.png') },
                { img: require('@/assets/img/hotel/small-4.png') },
                { img: require('@/assets/img/hotel/small-5.png') },
                { img: require('@/assets/img/hotel/small-6.png') }
            ]

        }
    },

    methods: {

        move(n) {
            if (this.gallerySlides.length <= this.slideIndex + n) {
                this.slideIndex = 0
            } else if (this.slideIndex + n < 0) {
                this.slideIndex = this.gallerySlides.length - 1
            } else {
                this.slideIndex += n
            }
        },
        currentSlide(index) {
            this.slideIndex = index
        },

    }
};
</script>