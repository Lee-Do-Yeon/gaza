<template>

    <!-- Common Banner Area -->
    <HotelBookingBanner />

    <!-- Dashboard Area -->
    <HotelBookingDashboard />

</template>
<script>

import HotelBookingBanner from '@/components/dashboard/HotelBookingBanner.vue'
import HotelBookingDashboard from '@/components/dashboard/HotelBookingDashboard.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "HotelBookingView",
    components: {
        HotelBookingBanner, HotelBookingDashboard, Cta
    }
};
</script>
