<template>
    <!-- Common Banner Area -->
    <BannerTwo />

    <!-- Booking Submission Areas -->
    <BookingSubmission />

    <!-- Cta Area -->
    <Cta />

</template>
  
<script>
// @ is an alias to /src
import BannerTwo from '@/components/flight/BannerTwo.vue'
import BookingSubmission from '@/components/flight/BookingSubmission.vue'
import Cta from '@/components/home/Cta.vue'
export default {
    name: 'FlightSearchResultView',
    components: {
        BannerTwo, BookingSubmission, Cta
    }
}
</script>