<template>

    <!-- Common Banner Area -->
    <LoginBanner />

    <!--  Common Author Area -->
    <CommonAuthorFour />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import LoginBanner from '@/components/user/LoginBanner.vue'
import CommonAuthorFour from '@/components/user/CommonAuthorFour.vue'
import Cta from '@/components/home/Cta.vue'


export default {
    name: "LoginView",
    components: {
        LoginBanner, CommonAuthorFour, Cta
    }
};
</script>