<template>

    <!-- Common Banner Area -->
    <ForgotBanner />

    <!--  Common Author Area -->
    <CommonAuthorFive />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import ForgotBanner from '@/components/user/ForgotBanner.vue'
import CommonAuthorFive from '@/components/user/CommonAuthorFive.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "ForgotPasswordView",
    components: {
        ForgotBanner, CommonAuthorFive, Cta
    }
};
</script>