<template>
    <div class="col-8">
        <table class="table text-center" >
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
                    <td> <router-link to="/" >{{user["userId"]}}</router-link> </td>
                    <td><a href="https://s3.ap-northeast-2.amazonaws.com/ssafy.common.gaza//gaza/guide_document/id_file/user['idfile']"><img src="../../assets/img/admin/file.png" alt=""></a></td>
                    <td><a href="https://s3.ap-northeast-2.amazonaws.com/ssafy.common.gaza//gaza/guide_document/certificate_residence/user['certificateResidence']"><img src="../../assets/img/admin/file.png" alt=""></a></td>
                    <td><a href="https://s3.ap-northeast-2.amazonaws.com/ssafy.common.gaza//gaza/guide_document/certificate/user['certificateResidence']"><img src="../../assets/img/admin/file.png" alt=""></a></td>
                    <td> <button @click="allow()">승인</button> <button @click="reject()">거부</button> </td>
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

        const allow = function () {
            console.log("신청 승인");
            store.dispatch('adminStore/allowGuideRequest');
        }

        const reject = function () {
            console.log("신청 거부");
            store.dispatch('adminStore/rejectGuideRequest');
        }

        return {
            store,
            registerGuideList,
            allow,
            reject
        };
  },
}
</script>

<style>

</style>