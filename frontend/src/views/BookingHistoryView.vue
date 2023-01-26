<template>

    <!-- Common Banner Area -->
    <BookingHistoryBanner />

    <!-- Dashboard Area -->
    <BookingHistoryDashboard />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import BookingHistoryBanner from '@/components/dashboard/BookingHistoryBanner.vue'
import BookingHistoryDashboard from '@/components/dashboard/BookingHistoryDashboard.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "BookingHistoryView",
    components: {
        BookingHistoryBanner, BookingHistoryDashboard, Cta
    }
};
</script>