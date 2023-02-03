<template>
    <section id="common_author_area" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2">
                    <div class="common_author_boxed">
                        <div class="common_author_heading">
                            <h3>회원 가입</h3>
                        </div>
                        <div class="common_author_form">
                            <form action="#" id="main_author_form" class="row" onsubmit="return false;">
                                <div class="form-group">
                                    <input type="text" :class="{ 'formerror': idc }" class="form-control"  placeholder="아이디를 입력해주세요." minlength="4" v-model="state.form.id" required/>
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" placeholder="이메일을 입력해 주세요." v-model="state.form.emailfront" required/>
                                </div>
                                <div class="form-group col-1 position-relative">
                                    <h3 class="position-absolute top-50 start-50 translate-middle">@</h3>
                                </div>
                                <div class="form-group col-5">
                                    <input type="text" class="form-control" v-model="state.form.emailend" :class="{ 'formerror': emailc }" @keyup="upemail" required/>
                                    <p v-if="emailc">이메일이 잘못되었습니다.</p>
                                </div>
                                <div class="form-group">
                                    <select class="form-select form-control" id="validationCustom04" required v-model="state.form.gender">
                                        <option selected disabled value="">성별을 골라주세요</option>
                                        <option value="man" >남자</option>
                                        <option value="woman">여자</option>
                                    </select>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" placeholder="전화번호" disabled readonly/>
                                </div>
                                <div class="form-group col-3">
                                    <input required type="text" class="form-control" maxlength='4' minlength="1" v-model="state.form.phonefront" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\.-/g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <input required type="text" class="form-control" maxlength='4' minlength="1" v-model="state.form.phonemid" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\.-/g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <input required type="text" class="form-control" maxlength='4' minlength="1" v-model="state.form.phoneend" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\.-/g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" placeholder="생년월일" disabled readonly/>
                                </div>
                                <div class="form-group col-3">
                                    <input required type="text" class="form-control" v-model="state.form.birthdayyear" maxlength='4' minlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\.-/g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <select required name="month" id="month" class="form-control custom-select" v-model="state.form.birthdaymonth">
                                        <option value="01">1월</option>
                                        <option value="02">2월</option>
                                        <option value="03">3월</option>
                                        <option value="04">4월</option>
                                        <option value="05">5월</option>
                                        <option value="06">6월</option>
                                        <option value="07">7월</option>
                                        <option value="08">8월</option>
                                        <option value="09">9월</option>
                                        <option value="10">10월</option>
                                        <option value="11">11월</option>
                                        <option value="12">12월</option>
                                    </select>
                                </div>
                                <div class="form-group col-3">
                                    <select required name="day" id="day" class="form-control custom-select" v-model="state.form.birthdaydate">
                                        <option value="01" selected="selected">1일</option>
                                        <option value="02">2일</option>
                                        <option value="03">3일</option>
                                        <option value="04">4일</option>
                                        <option value="05">5일</option>
                                        <option value="06">6일</option>
                                        <option value="07">7일</option>
                                        <option value="08">8일</option>
                                        <option value="09">9일</option>
                                        <option value="10">10일</option>
                                        <option value="11">11일</option>
                                        <option value="12">12일</option>
                                        <option value="13">13일</option>
                                        <option value="14">14일</option>
                                        <option value="15">15일</option>
                                        <option value="16">16일</option>
                                        <option value="17">17일</option>
                                        <option value="18">18일</option>
                                        <option value="19">19일</option>
                                        <option value="20">20일</option>
                                        <option value="21">21일</option>
                                        <option value="22">22일</option>
                                        <option value="23">23일</option>
                                        <option value="24">24일</option>
                                        <option value="25">25일</option>
                                        <option value="26">26일</option>
                                        <option value="27">27일</option>
                                        <option value="28">28일</option>
                                        <option value="29">29일</option>
                                        <option value="30">30일</option>
                                        <option value="31">31일</option>
                                    </select>                                    
                                </div>
                                <div class="form-group">
                                    <input required type="text" class="form-control" placeholder="이름" v-model="state.form.name" minlength="1" />
                                </div>
                                <div class="form-group">
                                    <input required type="password" class="form-control" placeholder="비밀번호" :class="{ 'formerror': passwordc }" @keyup="uppassword" v-model="state.form.password" minlength="6"/>
                                </div>
                                <div class="form-group">
                                    <input required type="password" class="form-control" :class="{ 'formerror': passwordc }" @keyup="uppassword" placeholder="비밀번호 확인" v-model="state.form.passwordcheck" minlength="6"/>
                                    <p v-if="passwordc">비밀번호가 일치하지 않습니다.</p>
                                </div>
                                <div class="common_form_submit">
                                    <button class="btn btn_theme btn_md" @click="Signin">회원가입</button>
                                </div>
                                
                                <div class="have_acount_area other_author_option">
                                    <!-- <div class="line_or">
                                        <span>or</span>
                                    </div>
                                    <ul>
                                        <li><a href="#!"><img src="../../assets/img/icon/google.png" alt="icon"></a></li>
                                        <li><a href="#!"><img src="../../assets/img/icon/facebook.png" alt="icon"></a></li>
                                        <li><a href="#!"><img src="../../assets/img/icon/twitter.png" alt="icon"></a></li>
                                    </ul> -->
                                    <p>계정이 있으십니까? <router-link to="/login">로그인</router-link></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</template>
<style>
.formerror{
    border: 1px solid red !important;
}
</style>
    
<script>
import { reactive, computed, ref, onMounted, watch } from 'vue'
import { useStore } from 'vuex'
import { requestSignin, requesttest } from "../../../common/api/commonAPI"
import router from "@/router";

export default {
    name: "CommonAuthorThree",

    setup(props, { emit }) {
        // const store = useStore()
        const idc = ref(false)
        const passwordc =ref(false)
        const emailc = ref(false)
        const state = reactive({
            form: {
                id: '',
                password: '',
                passwordcheck: '',
                name:'',
                gender:'',
                birthdaymonth:'',
                birthdayyear:'',
                birthdaydate:'',
                phonefront:'',
                phonemid:'',
                phoneend:'',
                emailfront:'',
                emailend:'',
            },

        })

        onMounted(() => {
            idc.value = false
            passwordc.value = false
            emailc.value =false
            state.form.id=''
            state.form.password=''
            state.form.passwordcheck=''
            state.form.name=''
            state.form.gender=''
            state.form.birthdaymonth=''
            state.form.birthdayyear=''
            state.form.birthdaydate=''
            state.form.phonefront=''
            state.form.phonemid=''
            state.form.phoneend=''
            state.form.emailfront=''
            state.form.emailend=''
        })

        const Signin = async function () {
            console.log('submit sign');
            if (!state.form.emailend.includes('.')) {
                if (state.form.emailend) {
                    emailc.value = true
                }
            } else {
                emailc.value = false
            }

            if (state.form.password !== state.form.passwordcheck) {
                passwordc.value = true
            } else {
                passwordc.value = false
            }
            try {   
                    console.log('test')
                    const response = await requesttest()
                    console.log(response);
                    
                } catch (error) {
                    console.log(error);
                }

            if (!passwordc.value && !emailc.value) {
                try {
                    const response = await requestSignin({
                        "birthday": `${state.form.birthdayyear}-${state.form.birthdaymonth}-${state.form.birthdaydate}T14:35:34.008Z`,
                        "email": state.form.emailfront,
                        "email_domain": state.form.emailend,
                        "gender": state.form.gender,
                        "id": state.form.id,
                        "name": state.form.name,
                        "password": state.form.password,
                        "phone_number": `${state.form.phonefront}-${state.form.phonemid}-${state.form.phoneend}`,
                    })
                    console.log(response);
                    router.push({name: "login"})
                } catch (error) {
                    console.log(error);
                }
            }

            
        }

        const upemail = function ()  {
            emailc.value = false
        }

        const uppassword = function () {
            passwordc.value = false
        }

        return { state, Signin, idc, passwordc, emailc, upemail, uppassword}
     },
    
};
</script>
