<template>

    <!-- Common Banner Area -->
    <Banner />

    <!-- How It Work -->
    <HowWork />

    <!-- Video Area -->
    <Video />

    <!-- About Service Area -->
    <AboutService />

    <!-- Vendor Form Area -->
    <VendorForm />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import Banner from '@/components/about/Banner.vue'
import HowWork from '@/components/vendor/HowWork.vue'
import Video from '@/components/vendor/Video.vue'
import AboutService from '@/components/vendor/AboutService.vue'
import VendorForm from '@/components/vendor/VendorForm.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "BecomeVendorView",
    components: {
        Banner, HowWork, Video, AboutService, VendorForm, Cta
    }
};
</script>