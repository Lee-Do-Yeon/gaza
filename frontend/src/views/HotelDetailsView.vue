<template>



    <!-- Hotel Search Areas -->
    <HotelSearch />


    <!-- Cta Area -->
    <Cta />

</template>
<script>

import HotelSearch from '@/components/hotel/HotelSearch.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "HotelDetailsView",
    components: {
        HotelSearch, Cta
    }
};
</script>
