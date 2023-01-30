<template>
    <section id="common_banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="common_bannner_text">
                        <h2>Flight submission</h2>
                        <ul>
                            <li><router-link to="/">Home</router-link></li>
                            <li><span><i class="fas fa-circle"></i></span><router-link to="flight-search-result">Flight
                                    search </router-link></li>
                            <li><span><i class="fas fa-circle"></i></span> Flight booking</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

</template>
<script>

export default {
    name: "BannerTwo"
};
</script>