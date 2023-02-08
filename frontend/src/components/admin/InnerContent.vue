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
                <tr v-for="user in registerGuideList" :key="user.userId">
                    <td> {{user["userId"]}} </td>
                    <td> {{user["idFile"]}} </td>
                    <td> {{user["certificateResidence"]}} </td>
                    <td> {{user["certificate"]}} </td>
                    <td> <a href="https://s3.ap-northeast-2.amazonaws.com/ssafy.common.gaza//gaza/user/picture/a49240f1-9ca7-413b-8345-3712492ebafc_Image+Pasted+at+2023-1-17+14-03.png">과연 그럴까</a></td>
                    <td> <button>승인</button> <button>거부</button> </td>
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

        onMounted(() => {
            store.dispatch('adminStore/getRegisterGuideListAction');
        })
        
        const registerGuideList = computed(() => {
            return store.getters['adminStore/getRegisterGuideList'];
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