<template>

    <!-- Common Banner Area -->
    <RoomBookingBanner />

    <!-- Tour Booking Submission Areas -->
    <TourBookingSubmission />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import RoomBookingBanner from '@/components/hotel/RoomBookingBanner.vue'
import TourBookingSubmission from '@/components/hotel/TourBookingSubmission.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "RoomBookingView",
    components: {
        RoomBookingBanner, TourBookingSubmission, Cta
    }
};
</script>