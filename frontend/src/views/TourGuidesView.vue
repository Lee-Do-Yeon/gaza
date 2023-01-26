<template>

    <!-- Common Banner Area -->
    <TourGuideBanner />

    <!-- Tour Guides Area -->
    <TourGuides />

    <!-- Cta Area -->
    <Cta />


</template>
<script>

import TourGuideBanner from '@/components/tour/TourGuideBanner.vue'
import TourGuides from '@/components/tour/TourGuides.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "TourGuidesView",
    components: {
        TourGuideBanner, TourGuides, Cta
    }
};
</script>