<template>

    <!-- Common Banner Area -->
    <RoomBanner />

    <!-- Room Details Areas -->
    <RoomDetails />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import RoomBanner from '@/components/hotel/RoomBanner.vue'
import RoomDetails from '@/components/hotel/RoomDetails.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "RoomDetailsView",
    components: {
        RoomBanner, RoomDetails, Cta
    }
};
</script>
