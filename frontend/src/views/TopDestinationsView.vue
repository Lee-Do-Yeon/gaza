<template>

    <!-- Common Banner Area -->
    <TopDestinationBanner />

    <!-- Form Area -->
    <TopDestinationForm />

    <!-- Destinations Areas -->
    <Destinations />

    <!-- Cta Area -->
    <Cta />

</template>
<script>
import TopDestinationBanner from '@/components/tour/TopDestinationBanner.vue'
import TopDestinationForm from '@/components/tour/TopDestinationForm.vue'
import Destinations from '@/components/tour/Destinations.vue'
import Cta from '@/components/home/Cta.vue'


export default {
    name: "TopDestinationsView",
    components: {
        TopDestinationBanner, TopDestinationForm, Destinations, Cta
    }
};
</script>
