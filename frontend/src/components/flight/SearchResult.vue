<template>
    <section id="explore_area" class="section_padding">
        <div class="container">
            <!-- Section Heading -->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>42 tours found</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="col-lg-3">
                    <div class="left_side_search_area">
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>Filter by price</h5>
                            </div>
                            <div class="filter-price">
                                <Slider v-model="value" class="apply" />
                            </div>
                            <button class="apply" type="button">Apply</button>
                        </div>
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>Number of stops</h5>
                            </div>
                            <div class="tour_search_type">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultf1">
                                    <label class="form-check-label" for="flexCheckDefaultf1">
                                        <span class="area_flex_one">
                                            <span>1 stop</span>
                                            <span>20</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultf2">
                                    <label class="form-check-label" for="flexCheckDefaultf2">
                                        <span class="area_flex_one">
                                            <span>2 stop</span>
                                            <span>16</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultf3">
                                    <label class="form-check-label" for="flexCheckDefaultf3">
                                        <span class="area_flex_one">
                                            <span>3 stop</span>
                                            <span>30</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultf4">
                                    <label class="form-check-label" for="flexCheckDefaultf4">
                                        <span class="area_flex_one">
                                            <span>Non-stop</span>
                                            <span>22</span>
                                        </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>Flight class</h5>
                            </div>
                            <div class="tour_search_type">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultt1">
                                    <label class="form-check-label" for="flexCheckDefaultt1">
                                        <span class="area_flex_one">
                                            <span>Economy</span>
                                            <span>20</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultt2">
                                    <label class="form-check-label" for="flexCheckDefaultt2">
                                        <span class="area_flex_one">
                                            <span>Business</span>
                                            <span>26</span>
                                        </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>Airlines</h5>
                            </div>
                            <div class="tour_search_type">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaults1">
                                    <label class="form-check-label" for="flexCheckDefaults1">
                                        <span class="area_flex_one">
                                            <span>Quatar Airways</span>
                                            <span>17</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaults2">
                                    <label class="form-check-label" for="flexCheckDefaults2">
                                        <span class="area_flex_one">
                                            <span>Fly Amirates </span>
                                            <span>14</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaults3">
                                    <label class="form-check-label" for="flexCheckDefaults3">
                                        <span class="area_flex_one">
                                            <span>Novo Air </span>
                                            <span>62</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaults4">
                                    <label class="form-check-label" for="flexCheckDefaults4">
                                        <span class="area_flex_one">
                                            <span>Air Asia </span>
                                            <span>08</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaults5">
                                    <label class="form-check-label" for="flexCheckDefaults5">
                                        <span class="area_flex_one">
                                            <span>Singapore Airlines </span>
                                            <span>12</span>
                                        </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>Refundable</h5>
                            </div>
                            <div class="tour_search_type">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultp1">
                                    <label class="form-check-label" for="flexCheckDefaultp1">
                                        <span class="area_flex_one">
                                            <span>Yes</span>
                                            <span>17</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultp2">
                                    <label class="form-check-label" for="flexCheckDefaultp2">
                                        <span class="area_flex_one">
                                            <span>No</span>
                                            <span>14</span>
                                        </span>
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefaultp3">
                                    <label class="form-check-label" for="flexCheckDefaultp3">
                                        <span class="area_flex_one">
                                            <span>As per rules</span>
                                            <span>62</span>
                                        </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="flight_search_result_wrapper">

                                <div v-for='(flightInfos, index) in items' class="flight_search_item_wrappper">
                                    <div class="flight_search_items">
                                        <div class="multi_city_flight_lists">
                                            <div class="flight_multis_area_wrapper">
                                                <div class="flight_search_left">
                                                    <div class="flight_logo">
                                                        <img :src="require(`@/assets/img/common/${flightInfos.flightImage}.png`)"
                                                            alt="img" />

                                                    </div>
                                                    <div class="flight_search_destination">
                                                        <p>{{ flightInfos.form }}</p>
                                                        <h3>{{ flightInfos.location }}</h3>
                                                        <h6>{{ flightInfos.terminal1 }}</h6>
                                                    </div>
                                                </div>
                                                <div class="flight_search_middel">
                                                    <div class="flight_right_arrow">
                                                        <img :src="require(`@/assets/img/icon/${flightInfos.arrowImage}.png`)"
                                                            alt="img" />
                                                        <h6>{{ flightInfos.stopes }}</h6>
                                                        <p>{{ flightInfos.time }} </p>
                                                    </div>
                                                    <div class="flight_search_destination">
                                                        <p>{{ flightInfos.to }}</p>
                                                        <h3>{{ flightInfos.destination }} </h3>
                                                        <h6>{{ flightInfos.terminal2 }} </h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="flight_search_right">
                                            <h5><del>{{ flightInfos.discuntPrice }}</del></h5>
                                            <h2>{{ flightInfos.offerPrice }}<sup> {{ flightInfos.offrePercentage
}}</sup></h2>
                                            <router-link to="/flight-booking-submission" class="btn btn_theme btn_sm">{{
        flightInfos.bookNow
}}</router-link>
                                            <p> {{ flightInfos.discuntInfo }}</p>
                                            <h6 data-bs-toggle="collapse"
                                                :data-bs-target="'#collapseExample' + flightInfos.id"
                                                aria-expanded="false" aria-controls="collapseExample"> {{
        flightInfos.showMore
}}<i class="fas fa-chevron-down"></i></h6>
                                        </div>
                                    </div>

                                    <div class="flight_policy_refund collapse" :id="'collapseExample' + flightInfos.id">

                                        <div v-for='(flightInfos, index) in items' class="flight_show_down_wrapper">
                                            <div class="flight-shoe_dow_item">
                                                <div class="airline-details">
                                                    <div class="img"><img src="../../assets/img/icon/bg.png" alt="img">
                                                    </div>
                                                    <span class="airlineName fw-500">Biman Bangladesh Airlines 123
                                                        &nbsp;
                                                        BG435</span>
                                                    <span class="flightNumber">BOEING 737-800 - 738</span>
                                                </div>
                                                <div class="flight_inner_show_component">
                                                    <div class="flight_det_wrapper">
                                                        <div class="flight_det">
                                                            <div class="code_time">
                                                                <span class="code">DAC</span>
                                                                <span class="time">15:00</span>
                                                            </div>
                                                            <p class="airport">Hazrat Shahjalal International Airport
                                                            </p>
                                                            <p class="date">7th Jun 2022</p>
                                                        </div>
                                                    </div>
                                                    <div class="flight_duration">
                                                        <div class="arrow_right"></div>
                                                        <span>01h 15m</span>
                                                    </div>
                                                    <div class="flight_det_wrapper">
                                                        <div class="flight_det">
                                                            <div class="code_time">
                                                                <span class="code">DAC</span>
                                                                <span class="time">15:00</span>
                                                            </div>
                                                            <p class="airport">Hazrat Shahjalal International Airport
                                                            </p>
                                                            <p class="date">7th Jun 2022</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="flight_refund_policy">
                                                <div class="TabPanelInner flex_widht_less">
                                                    <h4>Refund Policy</h4>
                                                    <p class="fz12">1. Refund and Date Change are done as per the
                                                        following policies.</p>
                                                    <p class="fz12">2. Refund Amount= Refund Charge (as per airline
                                                        policy + ShareTrip Convenience Fee). </p>
                                                    <p class="fz12">3. Date Change Amount= Date Change Fee (as per
                                                        Airline Policy + ShareTrip Convenience Fee).</p>
                                                </div>
                                                <div class="TabPanelInner">
                                                    <h4>Baggage</h4>
                                                    <div class="flight_info_taable">
                                                        <h3>DAC-SPD</h3>
                                                        <p><span>20KG /</span> person</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="load_more_flight">
                                <button class="btn btn_md"><i class="fas fa-spinner"></i> Load more..</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import Slider from '@vueform/slider'

import data from '../../data'

export default {
    name: "SearchResult",
    components: {
        Slider
    },
    data() {
        return {
            value: [0, 75],
            items: [],
        }
    },

    mounted() {
        this.items = data.flightData
    },
};
</script>
<style src="@vueform/slider/themes/default.css">

</style>