<template>
  <Banner/>
  <!-- How It Work
    <HowWork /> -->
  <!-- Vendor Form Area -->
  <VendorForm />

 
</template>
<script>

import VendorForm from "@/components/vendor/VendorForm.vue";
import Banner from "@/components/vendor/Banner.vue"

export default {
  name: "BecomeVendorView",
  components: {
    Banner,
    VendorForm  
  },
};
</script>
