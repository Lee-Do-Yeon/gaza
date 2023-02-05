<template>

    <!-- Common Banner Area -->
    <!-- <RoomBanner /> -->

    <!-- Room Details Areas -->
    <GuideReview />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import RoomBanner from '@/components/hotel/RoomBanner.vue'
import GuideReview from '@/components/hotel/GuideReview.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "GuideReviewView",
    components: {
        RoomBanner, GuideReview, Cta
    }
};
</script>
