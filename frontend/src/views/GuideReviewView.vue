<template>

    <!-- Common Banner Area -->


    <!-- Room Details Areas -->
    <GuideReview />

    <!-- Cta Area -->
    <Cta />


</template>
<script>

import GuideReview from '@/components/hotel/GuideReview.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "GuideReviewView",
    components: {
         GuideReview, Cta
    }
};
</script>
