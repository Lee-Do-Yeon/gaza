<template>
    <section id="go_beyond_area" class="section_padding_top">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3 col-md-6 col-sm-6 col-12">
                    <div class="heading_left_area">
                        <h2>Go beyond your <span>imagination</span></h2>
                        <h5>Discover your ideal experience with us</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-12">
                    <div class="imagination_boxed">
                        <router-link to="/top-destinations">
                            <img src="../../assets/img/imagination/imagination1.png" alt="img">
                        </router-link>
                        <h3><router-link to="/top-destinations">7% Discount for all <span>Airlines</span></router-link></h3>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-12">
                    <div class="imagination_boxed">
                        <router-link to="/top-destinations">
                            <img src="../../assets/img/imagination/imagination2.png" alt="img">
                        </router-link>
                        <h3><router-link to="/#!">Travel around<span>the world</span></router-link></h3>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-12">
                    <div class="imagination_boxed">
                        <router-link to="/top-destinations">
                            <img src="../../assets/img/imagination/imagination3.png" alt="img">
                        </router-link>
                        <h3><router-link to="/top-destinations">Luxury resorts<span>top deals</span></router-link></h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "Imagination"
};
</script>