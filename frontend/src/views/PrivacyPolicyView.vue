<template>

    <!-- Common Banner Area -->
    <PrivacyPolicyBanner />

    <!-- Privacy Policy Areas -->
    <PrivacyPolicyContent />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import PrivacyPolicyBanner from '@/components/pages/PrivacyPolicyBanner.vue'
import PrivacyPolicyContent from '@/components/pages/PrivacyPolicyContent.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "PrivacyPolicyView",
    components: {
        PrivacyPolicyBanner, PrivacyPolicyContent, Cta
    }
};
</script>
