<template>

    <!-- Common Banner Area -->
    <HotelDetailBanner />

    <!-- Hotel Search Areas -->
    <HotelSearch />

    <!--Related hotel packages Area -->
    <RelatedHotel />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import HotelDetailBanner from '@/components/hotel/HotelDetailBanner.vue'
import HotelSearch from '@/components/hotel/HotelSearch.vue'
import RelatedHotel from '@/components/hotel/RelatedHotel.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "HotelDetailsView",
    components: {
        HotelDetailBanner, HotelSearch, RelatedHotel, Cta
    }
};
</script>
