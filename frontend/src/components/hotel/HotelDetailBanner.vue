<template>
   <section id="common_banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="common_bannner_text">
                        <h2>Hotel details</h2>
                        <ul>
                            <li><router-link to="/">Home</router-link>
</li>
                            <li><span><i class="fas fa-circle"></i></span><router-link to="/hotel-search">Hotel</router-link></li>
                            <li><span><i class="fas fa-circle"></i></span> Hotel Details</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "HotelDetailBanner"
};
</script>