<template>

    <!-- Common Banner Area -->
    <TourBookingSubBanner />

    <!-- Tour Booking Submission Areas -->
    <TourBookingSubmission />

    <!-- Cta Area -->
    <Cta />


</template>
<script>

import TourBookingSubBanner from '@/components/tour/TourBookingSubBanner.vue'
import TourBookingSubmission from '@/components/tour/TourBookingSubmission.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "TourBookingSubmissionView",
    components: {
        TourBookingSubBanner, TourBookingSubmission, Cta
    }
};
</script>
