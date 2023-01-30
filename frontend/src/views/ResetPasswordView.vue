<template>

    <!-- Common Banner Area -->
    <ResetPasswordBanner />

    <!--  Common Author Area -->
    <CommonAuthorTwo />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import ResetPasswordBanner from '@/components/user/ResetPasswordBanner.vue'
import CommonAuthorTwo from '@/components/user/CommonAuthorTwo.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "ResetPasswordView",
    components: {
        ResetPasswordBanner, CommonAuthorTwo, Cta
    }
};
</script>
