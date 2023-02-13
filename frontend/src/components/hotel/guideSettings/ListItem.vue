<template>
    <span class="language badge bg-primary">{{ lang.lang_code }}</span><span class="lang-delete">x</span>
</template>

<script>

export default {
    props: {
        index: Number,
        lang: String,
    },
    setup() {
        
    },
}
</script>

<style scoped>

.language {
    font-size : 15px;
    margin-right: 3px;
}
.lang-delete {
    font-size : 15px;
    font-weight: bold;
    color : var(--main-color);
    margin-right: 10px;
    cursor : pointer;
}

</style>
