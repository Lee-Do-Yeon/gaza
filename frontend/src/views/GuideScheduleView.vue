<template>

    <!-- Common Banner Area -->


    <!-- Room Details Areas -->
    <GuideSchedule />

    <!-- Cta Area -->
    <Cta />


</template>
<script>

import GuideSchedule from '@/components/hotel/GuideSchedule.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "GuideScheduleView",
    components: {
         GuideSchedule, Cta
    }
};
</script>
