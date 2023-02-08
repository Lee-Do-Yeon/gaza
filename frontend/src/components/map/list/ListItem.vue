<template>
<div>
        <span>{{ index }} - {{ route.name }}</span>
      <div class="p-2"><button variant="danger" @click="deleteRoute">삭제</button><button @click="upRoute">▲</button><button @click="downRoute">▼</button></div>
      </div>
</template>
  
  <script>
  export default {
    props: {
        index: Number,
        route: Object,
    },
    methods: {
        deleteRoute() {
            console.log("deleteRoute Call");
            this.$emit("deleteRoute", {index: this.index, type: "DELETE"});
        },
        upRoute() {
            console.log("upRoute Call");
            this.$emit("upRoute", {index: this.index, type: "UP"});
        },
        downRoute() {
            console.log("downRoute Call");
            this.$emit("downRoute", {index: this.index, type: "DOWN"});
        },
    },
  };
  </script>

  