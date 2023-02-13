<template>
    <div class="col-8">
        <table class="table text-center" >
            <thead class="table-mint">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">신분증</th>
                    <th scope="col">체류증빙서류</th>
                    <th scope="col">자격증</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in registerGuideList" :key="user.userId">
                    <td><a href="#"> {{user["id"]}} </a> </td>
                    <td><a :href="getFileUrl(user).idFile"><img src="../../assets/img/admin/file.png" alt=""></a></td>
                    <td><a :href="getFileUrl(user).certificateResidence"><img src="../../assets/img/admin/file.png" alt=""></a></td>
                    <td><a :href="getFileUrl(user).certificate"><img src="../../assets/img/admin/file.png" alt=""></a></td>
                    <td><button type="button" class="btn btn-outline-info" @click="allow()">승인</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button type="button" class="btn btn-outline-info" @click="reject()">거절</button></td>
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

        const getFileUrl = function(user) {
            const base = "https://s3.ap-northeast-2.amazonaws.com/ssafy.common.gaza//gaza/guide_document/";

            return {
                idFile : base + "id_file/" + user.idFile,
                certificateResidence : base + "certificate_residence/" + user.certificateResidence,
                certificate : base + "certificate/" + user.certificate
            }
        }

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
            reject,
            getFileUrl
        };
  },
}
</script>

<style scoped>
img {
    width: 21px;
    height: 21px;
}

.table-mint {
    background-color: #15C4CB;
    color: whitesmoke;
}
</style>
