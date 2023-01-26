<template>

    <!-- Common Banner Area -->
    <WalletBanner />

    <!-- Dashboard Area -->
    <WalletDashboard />

     <!-- Cta Area -->
     <Cta />

</template>
<script>

import WalletBanner from '@/components/dashboard/WalletBanner.vue'
import WalletDashboard from '@/components/dashboard/WalletDashboard.vue'
import Cta from '@/components/home/Cta.vue'
export default {
    name: "WalletView",
    components: {
        WalletBanner, WalletDashboard, Cta
    }
};
</script>
