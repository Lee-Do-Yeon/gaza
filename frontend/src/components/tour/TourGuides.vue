<template>
    <section id="tour_guides_area" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>Meet with our experienced team members</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="guide_heading_area">
                        <h3>Our leaders</h3>
                    </div>
                </div>

                <div  v-for="(tourGuide, index) in items" :key="index" class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="tour_guides_boxed">

                        <img :src="require(`@/assets/img/tour-guides/${tourGuide.memberImage}.png`)" alt="img" />
                        <div class="tour_guide_content">
                            <ul>
                                <li><a href="!#"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="!#"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="!#"><i class="fab fa-instagram"></i></a></li>
                                <li><a href="!#"><i class="fab fa-linkedin-in"></i></a></li>
                            </ul>
                            <h3>{{ tourGuide.memberName }}</h3>
                            <p>{{ tourGuide.designation }}</p>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="guide_heading_area pt-5">
                        <h3>Our leaders</h3>
                    </div>
                </div>

                <div v-for="(tourGuide2, index) in items2" :key="index"  class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="tour_guides_boxed">

                        <img :src="require(`@/assets/img/tour-guides/${tourGuide2.memberImage}.png`)" alt="img" />

                        <b-img :src="tourGuide2.memberImage" :img-alt="tourGuide2.altText"></b-img>
                        <div class="tour_guide_content">
                            <ul>
                                <li><a href="!#"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="!#"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="!#"><i class="fab fa-instagram"></i></a></li>
                                <li><a href="!#"><i class="fab fa-linkedin-in"></i></a></li>
                            </ul>
                            <h3>{{ tourGuide2.memberName }}</h3>
                            <p>{{ tourGuide2.designation }}</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
</template>
<script>
import data from '../../data'
export default {
    name: "TourGuides",
    data() {
        return {
            items: [],
            items2: [],
        }
    },

    mounted() {
        this.items = data.tourGuides
        this.items2 = data.tourGuides2
    },
};
</script>