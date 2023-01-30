<template>
    <!-- Common Banner Area -->
    <Banner />

    <!-- About Us -->
    <AboutInfo />

    <!-- About Banner -->
    <AboutOffer />

    <!-- About Service Area -->
    <AboutService />

    <!-- consultation Area -->
    <Consultation />

    <!-- Counter Area -->
    <Counter />

    <!-- Customer Area -->
    <Customer />

    <!-- Cta Area -->
    <Cta />


</template>
<script>

import Banner from '@/components/about/Banner.vue'
import AboutInfo from '@/components/about/AboutInfo.vue'
import AboutOffer from '@/components/about/AboutOffer.vue'
import AboutService from '@/components/about/AboutService.vue'
import Consultation from '@/components/about/Consultation.vue'
import Counter from '@/components/about/Counter.vue'
import Customer from '@/components/about/Customer.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "AboutView",
    components: {
        Banner, AboutInfo, AboutOffer, AboutService,  Consultation, Counter, Customer, Cta
    }
};
</script>