<template>

    <!-- Common Banner Area -->
    <!-- <RoomBanner /> -->

    <!-- Room Details Areas -->
    <GuideSchedule />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import RoomBanner from '@/components/hotel/RoomBanner.vue'
import GuideSchedule from '@/components/hotel/GuideSchedule.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "GuideScheduleView",
    components: {
        RoomBanner, GuideSchedule, Cta
    }
};
</script>
