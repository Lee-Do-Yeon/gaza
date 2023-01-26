<template>

    <!-- Common Banner Area -->
    <FaqBanner />

    <!-- Faqs Area -->
    <FaqArea />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import FaqBanner from '@/components/pages/FaqBanner.vue'
import FaqArea from '@/components/pages/FaqArea.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "FaqsView",
    components: {
        FaqBanner, FaqArea, Cta
    }
};
</script>