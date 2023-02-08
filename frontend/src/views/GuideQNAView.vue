<template>



    <!-- Room Details Areas -->
    <GuideQNA />

    <!-- Cta Area -->
    <Cta />


</template>
<script>

import GuideQNA from '@/components/hotel/GuideQNA.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "GuideQNAView",
    components: {
        GuideQNA, Cta
    }
};
</script>
