<template>
    <div class="col-8">
        <table class="table">
            <thead class="thead-black">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">신분증</th>
                    <th scope="col">체류증빙서류</th>
                    <th scope="col">자격증</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in registerGuideList" :key="user.id"></tr>
                <tr>
                    <td> {{user[0]}} </td>
                    <td> {{user[1]}} </td>
                    <td> {{user[2]}} </td>
                    <td> {{user[3]}} </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import { computed, onMounted } from 'vue';
import { useStore } from 'vuex';

export default {


    setup() {
        const store = useStore();

        const registerGuideList = computed(() => {
            return store.getters['adminStore/getRegisterGuideList'];
        })

        onMounted(() => {
            store.dispatch['adminStore/getRegisterGuideListAction'];
        })

        return {
            store,
            registerGuideList,
        };
  },
}
</script>

<style>

</style>