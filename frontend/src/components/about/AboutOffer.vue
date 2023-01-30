<template>
    <section id="about_offer_banner" class="section_padding_bottom">
        <div class="container-fluid">
            <div class="row">
                <h2 class="d-none">Heading</h2>
                <div class="col-lg-4">
                    <div class="about_offer_banner">
                        <a href="!#"><img src="../../assets/img/common/small_banner.png" alt="img"></a>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="about_offer_banner">
                        <img src="../../assets/img/common/big_banner.png" alt="img">
                        <div class="about_offer_text">
                            <h3>Enjoy <span>20%</span> discount</h3>
                            <h2>Thailand couple tour</h2>
                            <router-link to="/tour-search">Find tours</router-link>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "AboutOffer"
};
</script>