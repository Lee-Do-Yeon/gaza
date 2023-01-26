<template>
    <section id="top_destinations" class="section_padding_top">
        <div class="container">
            <!-- Section Heading -->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>Top destinations</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-12 col-sm-12 col-12">
                    <div class="destinations_content_box img_animation">
                        <img src="../../assets/img/destination/big-img.png" alt="img">
                        <div class="destinations_content_inner">
                            <h2>Up to</h2>
                            <div class="destinations_big_offer">
                                <h1>50</h1>
                                <h6><span>%</span> <span>Off</span></h6>
                            </div>
                            <h2>Holiday packages</h2>
                            <router-link to="/top-destinations" class="btn btn_theme btn_md">Book now</router-link>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-12 col-sm-12 col-12">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12 col-12">
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination1.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">China</router-link></h3>
                                </div>
                            </div>
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination2.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">Darjeeling</router-link></h3>
                                </div>
                            </div>
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination3.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">Malaysia</router-link></h3>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-12">
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination4.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">Gangtok</router-link></h3>
                                </div>
                            </div>
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination5.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">Thailand</router-link></h3>
                                </div>
                            </div>
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination6.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">Australia</router-link></h3>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-12">
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination7.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">London</router-link></h3>
                                </div>
                            </div>
                            <div class="destinations_content_box img_animation">
                                <router-link to="/top-destinations">
                                    <img src="../../assets/img/destination/destination8.png" alt="img">
                                </router-link>
                                <div class="destinations_content_inner">
                                    <h3><router-link to="/top-destinations">USA</router-link></h3>
                                </div>
                            </div>
                            <div class="destinations_content_box">
                                <router-link to="/top-destinations" class="btn btn_theme btn_md w-100">View all</router-link>
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
    name: "TopDestinations"
};
</script>