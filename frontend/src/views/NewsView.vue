<template>

    <!-- Common Banner Area -->
    <Banner />

    <!-- News Area -->
    <NewsArea />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import Banner from '@/components/news/Banner.vue'
import NewsArea from '@/components/news/NewsArea.vue'
import Cta from '@/components/home/Cta.vue'


export default {
    name: "NewsView",
    components: {
        Banner, NewsArea, Cta
    }
};
</script>
