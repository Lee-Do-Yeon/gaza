<template>

    <!-- Common Banner Area -->
    <!-- <RoomBanner /> -->

    <!-- Room Details Areas -->
    <GuideQNA />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import RoomBanner from '@/components/hotel/RoomBanner.vue'
import GuideQNA from '@/components/hotel/GuideQNA.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "GuideQNAView",
    components: {
        RoomBanner, GuideQNA, Cta
    }
};
</script>
