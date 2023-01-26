<template>

    <!-- Common Banner Area -->
    <DashboardBanner />

    <!-- Dashboard Area -->
    <DashboardArea />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import DashboardBanner from '@/components/dashboard/DashboardBanner.vue'
import DashboardArea from '@/components/dashboard/DashboardArea.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "DashboardView",
    components: {
        DashboardBanner, DashboardArea, Cta
    }
};
</script>