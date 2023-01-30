<template>
    <section id="common_banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="common_bannner_text">
                        <h2>Explore the evergreen forest</h2>
                        <ul>
                            <li><router-link to="/">Home</router-link>
                            </li>
                            <li><span><i class="fas fa-circle"></i></span><router-link to="/tour-search">
                                    Tours</router-link></li>
                            <li><span><i class="fas fa-circle"></i></span> Tours Details</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "TourDetailBanner"
};
</script>