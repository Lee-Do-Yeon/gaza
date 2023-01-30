<template>


    <!-- Common Banner Area -->
    <NewsBannerTwo />

    <!-- News Area -->
    <NewsAreaTwo />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import NewsBannerTwo from '@/components/news/NewsBannerTwo.vue'
import NewsAreaTwo from '@/components/news/NewsAreaTwo.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "NewsV2View",
    components: {
        NewsBannerTwo, NewsAreaTwo, Cta
    }
};
</script>
