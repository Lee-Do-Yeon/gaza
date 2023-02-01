<template>

    <!-- Common Banner Area -->
    <NewsDetailsBanner />

    <!-- News Area -->
    <NewsAreaThree />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import NewsDetailsBanner from '@/components/news/NewsDetailsBanner.vue'
import NewsAreaThree from '@/components/news/NewsAreaThree.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "NewsDetailsView",
    components: {
        NewsDetailsBanner, NewsAreaThree, Cta
    }
};
</script>
