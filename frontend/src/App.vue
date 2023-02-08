<template>

  <Header v-show="Admin"/>

  <router-view />

  <Footer v-show="Admin"/>
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