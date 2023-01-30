<template>

    <!-- Common Banner Area -->
    <FlightBanner />

    <!-- Dashboard Area -->
    <FlightDashboard />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import FlightBanner from '@/components/dashboard/FlightBanner.vue'
import FlightDashboard from '@/components/dashboard/FlightDashboard.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "FlightBookingView",
    components: {
        FlightBanner, FlightDashboard, Cta
    }
};
</script>