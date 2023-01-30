<template>
    <section id="about_us_top" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="about_us_left">
                        <h5>{{ about_us }}</h5>
                        <h2>{{ title }}</h2>
                        <p>{{ aboutInfo1 }} </p>
                        <p>{{ aboutInfo2 }} </p>
                        <router-link to="/tour-search" class="btn btn_theme btn_md">{{ findTour }}</router-link>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="about_us_right">
                        <img src="../../assets/img/common/abour_right.png" alt="img">
                    </div>
                </div>

            </div>
        </div>
    </section>

</template>
<script>

export default {
    name: "AboutInfo",
    data() {
        return {
            about_us: 'About us',
            title: 'We Are The World Best Travel Agency Company Since 2000',
            aboutInfo1: `At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,
                            no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum
                            dolor sit amet, consetetur sadipscing elitr`,
            aboutInfo2: `At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,
                            no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum
                            dolor sit amet, consetetur sadipscing elitr`,
            findTour: 'Find tours'
        };
    }
};
</script>