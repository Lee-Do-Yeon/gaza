<template>
    <section id="testimonials_main_arae" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>What our client say about us</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div v-for="(testimonialContent, index) in items" :key="index" class="col-lg-4 col-md-6">
                    <div class="all_review_box">
                        <div class="all_review_date_area">
                            <div class="all_review_date">
                                <h5>{{ testimonialContent.date }}</h5>
                            </div>
                            <div class="all_review_star">
                                <h5>{{ testimonialContent.review }}</h5>
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
                            <img :src="require(`@/assets/img/review/${testimonialContent.clientImage}.png`)"
                                alt="img" />
                            <h4>{{ testimonialContent.clientName }}</h4>
                            <p>"{{ testimonialContent.reviewMessage }}"</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="pagination_area">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

import data from '../../data'
export default {
    name: "Testimonials",
    data() {
        return {
            value: [0, 75],
            items: [],
        }
    },

    mounted() {
        this.items = data.testimonialsData
    },
};
</script>