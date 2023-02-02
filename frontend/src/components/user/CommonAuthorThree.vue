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
                            <form action="#" id="main_author_form" class="row">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="아이디를 입력해주세요." v-model="state.form.id"/>
                                </div>
                                <div class="form-group col-6">
                                    <input type="text" class="form-control" placeholder="이메일을 입력해 주세요."/>
                                </div>
                                <div class="form-group col-1 position-relative">
                                    <h3 class="position-absolute top-50 start-50 translate-middle">@</h3>
                                </div>
                                <div class="form-group col-5">
                                    <input type="text" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <select class="form-select form-control" id="validationCustom04" required>
                                        <option selected disabled value="">성별을 골라주세요</option>
                                        <option>남자</option>
                                        <option>여자</option>
                                    </select>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" placeholder="전화번호" disabled readonly/>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" maxlength='4' minlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" maxlength='4' minlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" maxlength='4' minlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" placeholder="생년월일" disabled readonly/>
                                </div>
                                <div class="form-group col-3">
                                    <input type="text" class="form-control" maxlength='4' minlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
                                </div>
                                <div class="form-group col-3">
                                    <select name="month" id="month" class="form-control custom-select">
                                        <option value="1">1월</option>
                                        <option value="2">2월</option>
                                        <option value="3">3월</option>
                                        <option value="4">4월</option>
                                        <option value="5">5월</option>
                                        <option value="6">6월</option>
                                        <option value="7">7월</option>
                                        <option value="8">8월</option>
                                        <option value="9">9월</option>
                                        <option value="10">10월</option>
                                        <option value="11">11월</option>
                                        <option value="12">12월</option>
                                    </select>
                                </div>
                                <div class="form-group col-3">
                                    <select name="day" id="day" class="form-control custom-select">
                                        <option value="1" selected="selected">1일</option>
                                        <option value="2">2일</option>
                                        <option value="3">3일</option>
                                        <option value="4">4일</option>
                                        <option value="5">5일</option>
                                        <option value="6">6일</option>
                                        <option value="7">7일</option>
                                        <option value="8">8일</option>
                                        <option value="9">9일</option>
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
                                    <input type="text" class="form-control" placeholder="핸드폰 번호" />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="이름" />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="비밀번호" />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="비밀번호 확인" />
                                </div>
                                <div class="common_form_submit">
                                    <button class="btn btn_theme btn_md">Register</button>
                                </div>
                                
                                <div class="have_acount_area other_author_option">
                                    <div class="line_or">
                                        <span>or</span>
                                    </div>
                                    <ul>
                                        <li><a href="#!"><img src="../../assets/img/icon/google.png" alt="icon"></a></li>
                                        <li><a href="#!"><img src="../../assets/img/icon/facebook.png" alt="icon"></a></li>
                                        <li><a href="#!"><img src="../../assets/img/icon/twitter.png" alt="icon"></a></li>
                                    </ul>
                                    <p>Already have an account? <router-link to="/login">Log in now</router-link></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</template>
    
<script>
import { reactive, computed, ref, onMounted, watch } from 'vue'
import { useStore } from 'vuex'

export default {
    name: "CommonAuthorThree",

    setup(props, { emit }) {
        const store = useStore()
        const state = reactive({
            form: {
                id: '',
                password: '',
                passwordcheck: '',
                department:'',
                position:'',
                name:'',
                align: 'left',
                isformValid: true,
                isidValid: false,
            },

        })

        onMounted(() => {
            state.form.id = ''
            state.form.password = ''
            state.form.department = ''
            state.form.position = ''
            state.form.name = ''
            state.form.passwordcheck = ''
            state.form.isformValid = true
            state.form.isidValid = false
        })

        return { state,}
     },
    
};
</script>