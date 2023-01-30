<template>

    <!-- Common Banner Area -->
    <Banner />

    <!-- Contact Area -->
    <ContactArea />

    <!-- Cta Area -->
    <Cta />

</template>
<script>

import Banner from '@/components/contact/Banner.vue'
import ContactArea from '@/components/contact/ContactArea.vue'
import Cta from '@/components/home/Cta.vue'
export default {
    name: "ContactView",
    components: {
        Banner, ContactArea, Cta
    }
};
</script>