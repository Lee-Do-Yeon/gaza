<template>

    <!-- Common Banner Area -->


    <!-- Room Details Areas -->
    <RoomDetails />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import RoomDetails from '@/components/hotel/RoomDetails.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "RoomDetailsView",
    components: {
        RoomDetails, Cta
    }
};
</script>
