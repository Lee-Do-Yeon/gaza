<template>

    <!-- Common Banner Area -->
  <OtpBanner />

    <!--  Common Author Area -->
   <CommonAuthor />

     <!-- Cta Area -->
     <Cta />
   

</template>
<script>

import OtpBanner from '@/components/user/OtpBanner.vue'
import CommonAuthor from '@/components/user/CommonAuthor.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "VerifyOtpView",
    components: {
        OtpBanner, CommonAuthor, Cta
    }
};
</script>
