<template>
<div class="col-lg-4 col-md-6 col-sm-12 col-12">
    <div class="language-list-box">
        <list-item v-for="(lang,index) in language_list" :key="index" :lang="lang" @deleteLanguage="deleteLang"></list-item>
    </div>
    <div class="news_item_boxed">
    <form id="profile_form_area" @submit.prevent="langRegister">
        <input
        type="text"
        id="lang"
        v-model="language"
        placeholder="사용 가능 언어 입력"
        />
        <button class="btn btn_theme btn_sm">submit</button>
    </form>
    </div>
</div>
</template>

<script>
import { useStore } from "vuex";
import { onMounted, ref } from "vue";
import { guideLangRegister, getGuideLang, deleteLanguage } from "@/../common/api/commonAPI.js";
import ListItem from "@/components/hotel/guideSettings/ListItem";

export default {
    components:{
        ListItem,
    },
    setup() {
        const language_list = ref();
        const store = useStore();
        const language = ref();

        const loginId = store.getters["accountStore/getUserId"];

        //가이드 언어 조회
        const getLangList = async (loginId) => {
            const response = await getGuideLang(loginId); //call axios
            language_list.value = response.data;
            console.log("getLangList");
            console.log(language_list.value);
        };

        onMounted(() => {
            getLangList(loginId);
        });

        //가이드 사용 가능한 언어 등록
        const langRegister = async function () {
            const request = language.value;
            const payload = {
            languageName: request,
            loginId: loginId,
            };

            await guideLangRegister(payload); //call axios
            await getLangList(loginId);
            console.log("langRegister");
            console.log(language_list.value);
        };

        // 언어 삭제
        const deleteLang = async function(langId, index) {
            console.log(langId+" "+loginId);
            language_list.value.splice(index, 1);
            await deleteLanguage(langId, loginId); //call axios
        };
        

        return{
            language,
            langRegister,
            store,
            language_list,
            deleteLang
        };
    },
}
</script>

<style scoped>

.language-list-box {
    margin-top: 20px;
}

</style>