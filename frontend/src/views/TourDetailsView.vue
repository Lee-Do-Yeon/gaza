<template>

    <!-- Common Banner Area -->
    <TourDetailBanner />

    <!-- Tour Search Areas -->
    <TourSearchTwo />

    <!--Related tour packages Area -->
    <RelatedTour />

    <!-- Cta Area -->
    <Cta />

</template>
<script>

import TourDetailBanner from '@/components/tour/TourDetailBanner.vue'
import TourSearchTwo from '@/components/tour/TourSearchTwo.vue'
import RelatedTour from '@/components/tour/RelatedTour.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "TourDetailsView",
    components: {
        TourDetailBanner, TourSearchTwo, RelatedTour, Cta
    }
};
</script>
