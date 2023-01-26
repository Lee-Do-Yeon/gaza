<template>
    <!-- Common Banner Area -->
    <Banner />

    <!-- Form Area -->
    <Form />

    <!-- Flight Search Areas -->
    <SearchResult />

    <!-- Cta Area -->
    <Cta />

</template>
  
<script>
// @ is an alias to /src
import Banner from '@/components/flight/Banner.vue'
import Form from '@/components/flight/Form.vue'
import SearchResult from '@/components/flight/SearchResult.vue'
import Cta from '@/components/home/Cta.vue'
export default {
    name: 'FlightSearchResultView',
    components: {
        Banner, Form, SearchResult, Cta
    }
}
</script>