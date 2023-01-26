<template>

    <!-- Common Banner Area -->
    <TestimonialBanner />

    <!-- Testimonials Area -->
    <Testimonials />

    <!--Top tour packages Area -->
    <TopTourPackage />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import TestimonialBanner from '@/components/pages/TestimonialBanner.vue'
import TopTourPackage from '@/components/pages/TopTourPackage.vue'
import Testimonials from '@/components/pages/Testimonials.vue'
import Cta from '@/components/home/Cta.vue'


export default {
    name: "TestimonialsView",
    components: {
        TopTourPackage, Testimonials, TestimonialBanner, Cta
    }
};
</script>
