<template>
<div>
        <span>{{ key }} - {{ route.name }}</span>
      <div class="p-2"><button variant="danger" @click="deleteRoute">삭제</button></div>
      </div>
</template>
  
  <script>
  export default {
    props: {
        key: Number,
        route: Object,
    },
    methods: {
        deleteRoute() {
            console.log("deleteRoute Call");
            this.$store.dispatch("deleteRoute", this.route);
        },
    },
  };
  </script>

  