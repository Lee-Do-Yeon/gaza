<template>
<div class="col-lg-4 col-md-6 col-sm-12 col-12">
    <div class="news_item_boxed">
    <form id="profile_form_area" v-on:submit="langRegister">
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
import { ref } from "vue";

export default {
    setup() {
        const language = ref();

        //가이드 사용 가능한 언어 등록
        const langRegister = function () {
            const request = language.value;
            const payload = {
            languageName: request,
            loginId: store.getters["accountStore/getUserId"],
            };

            guideLangRegister(payload); //call axios
        };

        return{
            language,
            langRegister,
        };
    },
}
</script>