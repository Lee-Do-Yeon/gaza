<template>
  <!-- Common Banner Area -->
  <Banner />

  <!-- How It Work
    <HowWork /> -->
  <!-- Vendor Form Area -->
  <VendorForm />

 
</template>
<script>
import Banner from "@/components/about/Banner.vue";
import VendorForm from "@/components/vendor/VendorForm.vue";

export default {
  name: "BecomeVendorView",
  components: {
    Banner,
    VendorForm  
  },
};
</script>
