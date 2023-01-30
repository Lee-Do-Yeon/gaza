<template>

    <!-- Common Banner Area -->
    <RegisterBanner />

    <!--  Common Author Area -->
    <CommonAuthorThree />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import RegisterBanner from '@/components/user/RegisterBanner.vue'
import CommonAuthorThree from '@/components/user/CommonAuthorThree.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "RegisterView",
    components: {
        RegisterBanner, CommonAuthorThree, Cta
    }
};
</script>
