<template>
    <!-- Banner Area -->
    <Banner />

    <!-- Top Service And Tour Area-->
    <TopService />

    <!-- Holiday Destinations  Area-->
    <HolidayDestinations />

    <!-- About Area -->
    <About />

    <!-- Find travel partner -->
    <FindTravellPartner />

    <!-- Choose your destinations Area-->
    <ChooseDestination />


    <!--Client Area -->
    <ClientSays />


    <!-- Our partners Area -->
    <Partners />

    <!-- Cta Area -->
    <Cta />

</template>
  
<script>
// @ is an alias to /src
import Banner from '@/components/hometwo/Banner.vue'
import TopService from '@/components/hometwo/TopService.vue'
import HolidayDestinations from '@/components/hometwo/HolidayDestinations.vue'
import About from '@/components/hometwo/About.vue'
import FindTravellPartner from '@/components/hometwo/FindTravellPartner.vue'
import ChooseDestination from '@/components/hometwo/ChooseDestination.vue'
import ClientSays from '@/components/hometwo/ClientSays.vue'
import Partners from '@/components/home/Partners.vue'
import Cta from '@/components/home/Cta.vue'
export default {
    name: 'HomeTwoView',
    components: {
        Banner, TopService, HolidayDestinations, About, FindTravellPartner, ChooseDestination, ClientSays, Partners, Cta
    }
}
</script>
  