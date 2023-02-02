<template>

    <!-- Common Banner Area -->
    <!-- <NBanner /> -->

    <reviewDashboard />

    <Cta />

</template>



<script>
import reviewDashboard from '@/components/dashboard/reviewDashboard.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "reviewView",
    components: {
        reviewDashboard, Cta
    }
};
</script>