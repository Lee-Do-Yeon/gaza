<template>

    <!-- Testimonials Area -->
    <Testimonials />



    <!-- Cta Area -->
    <Cta />


</template>
<script>

import Testimonials from '@/components/pages/Testimonials.vue'
import Cta from '@/components/home/Cta.vue'


export default {
    name: "TestimonialsView",
    components: {
        Testimonials,  Cta
    }
};
</script>
