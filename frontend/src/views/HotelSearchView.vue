<template>
    <!-- Common Banner Area -->
    <Banner />

    <!-- Form Area -->
    <Form />

    <!-- Hotel Search Areas -->
    <SearchResult />

    <!-- Cta Area -->
    <Cta />

</template>
  
<script>
// @ is an alias to /src
import Banner from '@/components/hotel/Banner.vue'
import Form from '@/components/hotel/Form.vue'
import SearchResult from '@/components/hotel/SearchResult.vue'
import Cta from '@/components/home/Cta.vue'
export default {
    name: 'HotelSearchView',
    components: {
        Banner, Form, SearchResult, Cta
    }
}
</script>