<template>

  <Banner />

  <Form />
  <PromotionalTours />
  <PromotionalToursRecommand />


</template>

<script>
// @ is an alias to /src
import Banner from '@/components/home/Banner.vue'
import Form from '@/components/home/Form.vue'
import Imagination from '@/components/home/Imagination.vue'
import TopDestinations from '@/components/home/TopDestinations.vue'
import ExploreDeals from '@/components/home/ExploreDeals.vue'
import Offer from '@/components/home/Offer.vue'
import PromotionalTours from '@/components/home/PromotionalTours.vue'
import PromotionalToursRecommand from '@/components/home/PromotionalToursRecommand.vue'
import Destinations from '@/components/home/Destinations.vue'
import News from '@/components/home/News.vue'


export default {
  name: 'HomeView',
  components: {
    Banner, Form, Imagination, TopDestinations, ExploreDeals, Offer, PromotionalTours, Destinations, News,  PromotionalToursRecommand
  }
}
</script>