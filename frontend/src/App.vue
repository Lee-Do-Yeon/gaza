<template>

  <Header v-if="$route.name !== 'admin' && $route.name !== 'mapdetail'" />

  <router-view />

  <Footer v-if="$route.name !== 'admin' && $route.name !== 'mapdetail'" />

</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'App',
  components: {
    Header, Footer
  }
}
</script>
