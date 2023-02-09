<template>

  <Header v-if="$route.name !== 'admin'" />

  <router-view />

  <Footer v-if="$route.name !== 'admin'" />

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
