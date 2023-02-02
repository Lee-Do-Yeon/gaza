<template>

    <!-- Common Banner Area -->
    <!-- <NBanner /> -->

    <NotificationDashboard />

    <Cta />

</template>



<script>
import NBanner from '@/components/dashboard/NBanner.vue'
import NotificationDashboard from '@/components/dashboard/NotificationDashboard.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "NotificationView",
    components: {
        NBanner, NotificationDashboard, Cta
    }
};
</script>