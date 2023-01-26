<template>

  <!-- Banner Area -->
  <Banner />


  <!-- Form Area -->
  <Form />

  <!-- imagination Area -->
  <!-- <Imagination /> -->

 

  <!-- Top destinations -->
  <!-- <TopDestinations /> -->


  <!-- Explore our hot deals -->
  <!-- <ExploreDeals /> -->

  <!-- Offer Area -->
  <!-- <Offer /> -->

  <!--Promotional Tours Area -->
  <PromotionalTours />

  <!-- Destinations Area -->
  <Destinations />

  <!-- News Area -->
  <!-- <News /> -->

  <!-- Our partners Area -->
  <!-- <Partners /> -->

  <!-- Cta Area -->
  <!-- <Cta /> -->

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
import Destinations from '@/components/home/Destinations.vue'
import News from '@/components/home/News.vue'
import Partners from '@/components/home/Partners.vue'
import Cta from '@/components/home/Cta.vue'


export default {
  name: 'HomeView',
  components: {
    Banner, Form, Imagination, TopDestinations, ExploreDeals, Offer, PromotionalTours, Destinations, News, Partners, Cta
  }
}
</script>