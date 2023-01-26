<template>

    <!-- Common Banner Area -->
    <ErrorBanner />

    <!--Error Areas -->
    <ErrorArea />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import ErrorBanner from '@/components/pages/ErrorBanner.vue'
import ErrorArea from '@/components/pages/ErrorArea.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "ErrorView",
    components: {
        ErrorBanner, ErrorArea, Cta
    }
};
</script>