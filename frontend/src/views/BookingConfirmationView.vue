<template>

    <!-- Common Banner Area -->
    <BookingConfirmationBanner />

    <!-- Tour Booking Submission Areas -->
    <TourBooking />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import BookingConfirmationBanner from '@/components/pages/BookingConfirmationBanner.vue'
import TourBooking from '@/components/pages/TourBooking.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "BookingConfirmationView",
    components: {
        BookingConfirmationBanner, TourBooking, Cta
    }
};
</script>