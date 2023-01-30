<template>

    <!-- Common Banner Area -->
    <TourBanner />

    <!-- Form Area -->
    <TourForm />

    <!-- Tour Search Areas -->
    <TourSearch />

    <!-- Cta Area -->
    <Cta />


</template>
<script>
import TourBanner from '@/components/tour/TourBanner.vue'
import TourForm from '@/components/tour/TourForm.vue'
import TourSearch from '@/components/tour/TourSearch.vue'
import Cta from '@/components/home/Cta.vue'

export default {
    name: "TourSearchView",
    components: {
        TourBanner, TourForm, TourSearch, Cta
    }
};
</script>
