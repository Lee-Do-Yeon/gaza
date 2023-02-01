<template>
    <section id="tour_details_main" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="tour_details_leftside_wrapper">
                        <div class="tour_details_heading_wrapper">
                            <div class="tour_details_top_heading">
                                <h2>Explore the evergreen forest</h2>
                                <h5><i class="fas fa-map-marker-alt"></i> Amazon evergreen forest, Amazon.</h5>
                            </div>
                            <div class="tour_details_top_heading_right">
                                <h4>Excellent</h4>
                                <h6>4.8/5</h6>
                                <p>(1214 reviewes)</p>
                            </div>
                        </div>
                        <div class="tour_details_top_bottom">
                            <div class="toru_details_top_bottom_item">
                                <div class="tour_details_top_bottom_icon">
                                    <i class="fas fa-clock"></i>
                                </div>
                                <div class="tour_details_top_bottom_text">
                                    <h5>Duration</h5>
                                    <p>10 days</p>
                                </div>
                            </div>
                            <div class="toru_details_top_bottom_item">
                                <div class="tour_details_top_bottom_icon">
                                    <i class="fas fa-paw"></i>
                                </div>
                                <div class="tour_details_top_bottom_text">
                                    <h5>Tour type</h5>
                                    <p>Group tour</p>
                                </div>
                            </div>
                            <div class="toru_details_top_bottom_item">
                                <div class="tour_details_top_bottom_icon">
                                    <i class="fas fa-users"></i>
                                </div>
                                <div class="tour_details_top_bottom_text">
                                    <h5>Group size</h5>
                                    <p>50 people</p>
                                </div>
                            </div>
                            <div class="toru_details_top_bottom_item">
                                <div class="tour_details_top_bottom_icon">
                                    <i class="fas fa-map-marked"></i>
                                </div>
                                <div class="tour_details_top_bottom_text">
                                    <h5>Location</h5>
                                    <p>Amazon rain forest</p>
                                </div>
                            </div>
                        </div>
                        <div class="tour_details_img_wrapper">
                            <div class="image__gallery">
                                <div class="gallery">
                                    <div class="gallery__slideshow">
                                        <div class="gallery__slides">
                                            <div class="gallery__slide">
                                                <img class="gallery__img slick-slide" :src="slide.img" alt=""
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
                            <h3 class="heading_theme">Itinerary</h3>
                            <div class="tour_details_boxed_inner">
                                <div class="accordion" id="accordionExample">
                                    <div class="accordion_flex_area">
                                        <div class="accordion_left_side">
                                            <h5>Day 1</h5>
                                        </div>
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="headingOne">
                                                <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                                    data-bs-target="#collapseOne" aria-expanded="true"
                                                    aria-controls="collapseOne">
                                                    Stet clita kasd gubergren, no sea takimata sanctus est
                                                </button>
                                            </h2>
                                            <div id="collapseOne" class="accordion-collapse collapse show"
                                                aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                                <div class="accordion-body">
                                                    <div class="accordion_itinerary_list">
                                                        <ul>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                There are many variations of passages of Lorem Ipsum
                                                                available, but the majority have
                                                                suffered alteration in some form
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Contrary to popular belief, Lorem Ipsum is not simply
                                                                random
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Many desktop publishing packages and web page editors
                                                                now
                                                                use
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Lorem Ipsum is that it has a more-or-less normal
                                                                distribution of letters, to using 'Content here
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                The standard chunk of Lorem Ipsum used since the 1500s
                                                                is
                                                                reproduced below for those interested.
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="accordion_flex_area">
                                        <div class="accordion_left_side">
                                            <h5>Day 2</h5>
                                        </div>
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="headingTwo">
                                                <button class="accordion-button collapsed" type="button"
                                                    data-bs-toggle="collapse" data-bs-target="#collapseTwo"
                                                    aria-expanded="false" aria-controls="collapseTwo">
                                                    Stet clita kasd gubergren, no sea takimata sanctus est
                                                </button>
                                            </h2>
                                            <div id="collapseTwo" class="accordion-collapse collapse"
                                                aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                                <div class="accordion-body">
                                                    <div class="accordion_itinerary_list">
                                                        <ul>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                There are many variations of passages of Lorem Ipsum
                                                                available, but the majority have
                                                                suffered alteration in some form
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Lorem Ipsum is that it has a more-or-less normal
                                                                distribution of letters, to using 'Content here
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                The standard chunk of Lorem Ipsum used since the 1500s
                                                                is
                                                                reproduced below for those interested.
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="accordion_flex_area">
                                        <div class="accordion_left_side">
                                            <h5>Day 3</h5>
                                        </div>
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="headingThree">
                                                <button class="accordion-button collapsed" type="button"
                                                    data-bs-toggle="collapse" data-bs-target="#collapseThree"
                                                    aria-expanded="false" aria-controls="collapseThree">
                                                    Stet clita kasd gubergren, no sea takimata sanctus est
                                                </button>
                                            </h2>
                                            <div id="collapseThree" class="accordion-collapse collapse"
                                                aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                                                <div class="accordion-body">
                                                    <div class="accordion_itinerary_list">
                                                        <ul>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Contrary to popular belief, Lorem Ipsum is not simply
                                                                random
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Many desktop publishing packages and web page editors
                                                                now
                                                                use
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Lorem Ipsum is that it has a more-or-less normal
                                                                distribution of letters, to using 'Content here
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                The standard chunk of Lorem Ipsum used since the 1500s
                                                                is
                                                                reproduced below for those interested.
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="accordion_flex_area">
                                        <div class="accordion_left_side">
                                            <h5>Day 4</h5>
                                        </div>
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="headingFour">
                                                <button class="accordion-button collapsed" type="button"
                                                    data-bs-toggle="collapse" data-bs-target="#collapseFour"
                                                    aria-expanded="false" aria-controls="collapseFour">
                                                    Stet clita kasd gubergren, no sea takimata sanctus est
                                                </button>
                                            </h2>
                                            <div id="collapseFour" class="accordion-collapse collapse"
                                                aria-labelledby="headingFour" data-bs-parent="#accordionExample">
                                                <div class="accordion-body">
                                                    <div class="accordion_itinerary_list">
                                                        <ul>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                There are many variations of passages of Lorem Ipsum
                                                                available, but the majority have
                                                                suffered alteration in some form
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Contrary to popular belief, Lorem Ipsum is not simply
                                                                random
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                Many desktop publishing packages and web page editors
                                                                now
                                                                use
                                                            </li>
                                                            <li>
                                                                <i class="fas fa-circle"></i>
                                                                The standard chunk of Lorem Ipsum used since the 1500s
                                                                is
                                                                reproduced below for those interested.
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
                            <h3 class="heading_theme">Tours location</h3>
                            <div class="map_area">
                                <iframe
                                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3677.6962663570607!2d89.56355961427838!3d22.813715829827952!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39ff901efac79b59%3A0x5be01a1bc0dc7eba!2sAnd+IT!5e0!3m2!1sen!2sbd!4v1557901943656!5m2!1sen!2sbd"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="tour_details_right_sidebar_wrapper">
                        <div class="tour_detail_right_sidebar">
                            <div class="tour_details_right_boxed">
                                <div class="tour_details_right_box_heading">
                                    <h3>Standard package44</h3>
                                </div>
                                <div class="valid_date_area">
                                    <div class="valid_date_area_one">
                                        <h5>Valid from</h5>
                                        <p>01 Feb 2022</p>
                                    </div>
                                    <div class="valid_date_area_one">
                                        <h5>Valid till</h5>
                                        <p>15 Feb 2022</p>
                                    </div>
                                </div>
                                <div class="tour_package_details_bar_list">
                                    <h5>Package details</h5>
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
                                <div class="tour_package_details_bar_price">
                                    <h5>Price</h5>
                                    <div class="tour_package_bar_price">
                                        <h6><del>$ 35,500</del></h6>
                                        <h3>$ 30,500 <sub>/Per serson</sub> </h3>
                                    </div>
                                </div>
                            </div>
                            <div class="tour_select_offer_bar_bottom">
                                <button class="btn btn_theme btn_md w-100" data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">Select
                                    offer</button>
                            </div>



                            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
                                aria-labelledby="offcanvasRightLabel">

                                <!-- Offcanvas Area -->
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
                                                <input type="date" id="dates" value="2022-05-05" class="form-control">
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
                                                <label for="textse">Write any special note</label>
                                                <textarea rows="5" id="textse" class="form-control"
                                                    placeholder="Write any special note"></textarea>
                                            </div>
                                            <div class="form-check write_spical_check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="flexCheckDefaultf1">
                                                <label class="form-check-label" for="flexCheckDefaultf1">
                                                    <span class="main_spical_check">
                                                        <span>I read and accept all <router-link to="/terms-service">Terms
                                                                and conditios</router-link></span>
                                                    </span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="proceed_booking_btn ">
                                   <a href="#!" class="btn btn_theme btn_md w-100">Proceed to
                                        Booking</a>
                                </div>
                            </div>

                        </div>
                        <div class="tour_detail_right_sidebar">
                            <div class="tour_details_right_boxed">
                                <div class="tour_details_right_box_heading">
                                    <h3>Deluxe package</h3>
                                </div>
                                <div class="valid_date_area">
                                    <div class="valid_date_area_one">
                                        <h5>Valid from</h5>
                                        <p>01 Feb 2022</p>
                                    </div>
                                    <div class="valid_date_area_one">
                                        <h5>Valid till</h5>
                                        <p>15 Feb 2022</p>
                                    </div>
                                </div>
                                <div class="tour_package_details_bar_list">
                                    <h5>Package details</h5>
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
                                <div class="tour_package_details_bar_price">
                                    <h5>Price</h5>
                                    <div class="tour_package_bar_price">
                                        <h6><del>$ 35,500</del></h6>
                                        <h3>$ 30,500 <sub>/Per serson</sub> </h3>
                                    </div>
                                </div>
                            </div>
                            <div class="tour_select_offer_bar_bottom">
                                <button class="btn btn_theme btn_md w-100" data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">Select
                                    offer</button>
                            </div>
                        </div>
                        <div class="tour_detail_right_sidebar">
                            <div class="tour_details_right_boxed">
                                <div class="tour_details_right_box_heading">
                                    <h3>Super deluxe package</h3>
                                </div>
                                <div class="valid_date_area">
                                    <div class="valid_date_area_one">
                                        <h5>Valid from</h5>
                                        <p>01 Feb 2022</p>
                                    </div>
                                    <div class="valid_date_area_one">
                                        <h5>Valid till</h5>
                                        <p>15 Feb 2022</p>
                                    </div>
                                </div>
                                <div class="tour_package_details_bar_list">
                                    <h5>Package details</h5>
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
                                <div class="tour_package_details_bar_price">
                                    <h5>Price</h5>
                                    <div class="tour_package_bar_price">
                                        <h6><del>$ 35,500</del></h6>
                                        <h3>$ 30,500 <sub>/Per serson</sub> </h3>
                                    </div>
                                </div>
                            </div>
                            <div class="tour_select_offer_bar_bottom">
                                <button class="btn btn_theme btn_md w-100" data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">Select
                                    offer</button>
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
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="write_your_review_wrapper">
                        <h3 class="heading_theme">Write your review</h3>
                        <div class="write_review_inner_boxed">
                            <form action="!#" id="news_comment_form">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-froup">
                                            <input type="text" class="form-control bg_input"
                                                placeholder="Enter full name">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-froup">
                                            <input type="text" class="form-control bg_input"
                                                placeholder="Enter email address">
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="form-froup">
                                            <textarea rows="6" placeholder="Write your comments"
                                                class="form-control bg_input"></textarea>
                                        </div>
                                        <div class="comment_form_submit">
                                            <button class="btn btn_theme btn_md">Post comment</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="all_review_wrapper">
                        <h3 class="heading_theme">All review</h3>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="all_review_box">
                        <div class="all_review_date_area">
                            <div class="all_review_date">
                                <h5>08 Dec, 2021</h5>
                            </div>
                            <div class="all_review_star">
                                <h5>Excellent</h5>
                                <div class="review_star_all">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="all_review_text">
                            <img src="../../assets/img/review/review1.png" alt="img">
                            <h4>Manresh Chandra</h4>
                            <p>" Loved the overall tour for all 6 days covering jaipur jodhpur and jaisalmer. worth ur
                                money for sure. thanks. Driver was very good and polite and safe driving for all 6 days.
                                on time pickup and drop overall. Thanks for it. "</p>
                        </div>
                        <div class="all_review_small_img">
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small1.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small2.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small3.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small4.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small5.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <h5>+5</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="all_review_box">
                        <div class="all_review_date_area">
                            <div class="all_review_date">
                                <h5>08 Dec, 2021</h5>
                            </div>
                            <div class="all_review_star">
                                <h5>Excellent</h5>
                                <div class="review_star_all">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="all_review_text">
                            <img src="../../assets/img/review/review2.png" alt="img">
                            <h4>Michel falak</h4>
                            <p>" Loved the overall tour for all 6 days covering jaipur jodhpur and jaisalmer. worth ur
                                money for sure. thanks. Driver was very good and polite and safe driving for all 6 days.
                                on time pickup and drop overall. Thanks for it. "</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="all_review_box">
                        <div class="all_review_date_area">
                            <div class="all_review_date">
                                <h5>08 Dec, 2021</h5>
                            </div>
                            <div class="all_review_star">
                                <h5>Excellent</h5>
                                <div class="review_star_all">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="all_review_text">
                            <img src="../../assets/img/review/review3.png" alt="img">
                            <h4>Chester dals</h4>
                            <p>" Loved the overall tour for all 6 days covering jaipur jodhpur and jaisalmer. worth ur
                                money for sure. thanks. Driver was very good and polite and safe driving for all 6 days.
                                on time pickup and drop overall. Thanks for it. "</p>
                        </div>
                        <div class="all_review_small_img">
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small1.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small2.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small5.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <h5>+15</h5>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="all_review_box">
                        <div class="all_review_date_area">
                            <div class="all_review_date">
                                <h5>08 Dec, 2021</h5>
                            </div>
                            <div class="all_review_star">
                                <h5>Excellent</h5>
                                <div class="review_star_all">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="all_review_text">
                            <img src="../../assets/img/review/review4.png" alt="img">
                            <h4>Casper mike</h4>
                            <p>" Loved the overall tour for all 6 days covering jaipur jodhpur and jaisalmer. worth ur
                                money for sure. thanks. Driver was very good and polite and safe driving for all 6 days.
                                on time pickup and drop overall. Thanks for it. "</p>
                        </div>
                        <div class="all_review_small_img">
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small4.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <img src="../../assets/img/review/review-small5.png" alt="img">
                            </div>
                            <div class="all_review_small_img_item">
                                <h5>+19</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="all_review_box">
                        <div class="all_review_date_area">
                            <div class="all_review_date">
                                <h5>08 Dec, 2021</h5>
                            </div>
                            <div class="all_review_star">
                                <h5>Excellent</h5>
                                <div class="review_star_all">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="all_review_text">
                            <img src="../../assets/img/review/review5.png" alt="img">
                            <h4>Jason bruno</h4>
                            <p>" Loved the overall tour for all 6 days covering jaipur jodhpur and jaisalmer. worth ur
                                money for sure. thanks. Driver was very good and polite and safe driving for all 6 days.
                                on time pickup and drop overall. Thanks for it. "</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "TourSearchTwo",

    data() {
        return {

            gallerySlides: [
                { img: require('@/assets/img/tour/big-img.png') },
                { img: require('@/assets/img/tour/big-img2.png') },
                { img: require('@/assets/img/tour/big-img3.png') },
                { img: require('@/assets/img/tour/big-img4.png') },
                { img: require('@/assets/img/tour/big-img5.png') },
                { img: require('@/assets/img/tour/big-img6.png') },
                { img: require('@/assets/img/tour/big-img7.png') }
            ],

            slideIndex: 0,

            slides: [
                { img: require('@/assets/img/tour/small1-img.png') },
                { img: require('@/assets/img/tour/small2-img.png') },
                { img: require('@/assets/img/tour/small3-img.png') },
                { img: require('@/assets/img/tour/small4-img.png') },
                { img: require('@/assets/img/tour/small5-img.png') },
                { img: require('@/assets/img/tour/small6-img.png') },
                { img: require('@/assets/img/tour/small7-img.png') },
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