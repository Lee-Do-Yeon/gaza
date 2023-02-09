<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col">
          <br />
          <div class="row d-flex justify-content-center">
            <div class="col-lg-4 me-2">
              <h3 style="color: #15d4cd">상담날짜</h3>
              <br />
              <div>
                <div class="flight_Search_boxed date_flex_area">
                  <div class="Journey_date">
                    <input type="date" name = "consult-date" v-model="state.info.consult_date"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 ms-2">
              <h3 style="color: #15d4cd">시간대 설정</h3>
              <div class="reser_boxed">
                <div class="btn-group" role="group">
                  <button type="button" class="btn btn_theme btn_sm me-1 mb-2" data-bs-toggle="button" aria-pressed="false" autocomplete="off" value="1" @click="setTime">
                    01
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="2" @click="setTime">
                    02
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="3" @click="setTime">
                    03
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="4" @click="setTime">
                    04
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="5" @click="setTime">
                    05
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="6" @click="setTime">
                    06
                  </button>
                </div>
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="7" @click="setTime">
                    07
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="8" @click="setTime">
                    08
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="9" @click="setTime">
                    09
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="10" @click="setTime">
                    10
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="11" @click="setTime">
                    11
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="12" @click="setTime">
                    12
                  </button>
                </div>
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="13" @click="setTime">
                    13
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="14" @click="setTime">
                    14
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="15" @click="setTime">
                    15
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="16" @click="setTime">
                    16
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="17" @click="setTime">
                    17
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="18" @click="setTime">
                    18
                  </button>
                </div>
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="19" @click="setTime">
                    19
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="20" @click="setTime">
                    20
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="21" @click="setTime">
                    21
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="22" @click="setTime">
                    22
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="23" @click="setTime">
                    23
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" value="24" @click="setTime">
                    24
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8 offset-lg-2 mt-5">
          <div class="section_heading_center">
            <h3 style="color: #15d4cd">여행 정보 입력</h3>
          </div>
          <div class="contact_form">
            <div class="row">
              <div class="col-lg-4">
                <div class="form-check">
                  <input class="form-check-input" name = "disabled" type="checkbox" v-model="state.info.withDisabled"/>
                  <label class="form-check-label">장애 여부</label>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="form-check">
                  <input class="form-check-input" name = "with-baby" type="checkbox" v-model="state.info.withChildren"/>
                  <label class="form-check-label">유아 동반</label>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="form-check">
                  <input class="form-check-input" name = "with-weak-or-elderly" type="checkbox" v-model="state.info.withElderly"/>
                  <label class="form-check-label">노약자 동반</label>
                </div>
              </div>
              <div class="row mt-4 mb-4">
                <div class="col-lg-6">
                  <div class="input-group">
                    인원 : <input min="0" name = "head-count" type="number" v-model="state.info.numberOfPeople"/>
                  </div>
                </div>
                <div class="col-lg-6">여행날짜: <input type="date" name = "travel-date" v-model="state.info.travel_date" /></div>
              </div>
              <div style="font-weight: bold">특이사항</div>
              <div class="col-lg-12 mt-4">
                <div class="form-group">
                  <textarea class="form-control bg_input" name = "remark"  rows="6" v-model="state.info.note"></textarea>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="section_heading_center mt-4">
          <router-link to="/complete">
            <button type="button" class="btn btn_theme btn_md" @click="reserve()">예약하기</button>
          </router-link>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { onMounted, reactive } from 'vue';
import { useStore } from 'vuex';
import { reserve } from '../../../common/api/commonAPI.js'

export default {
    setup() {
        const store = useStore();

        const state = reactive({
          info: {
            consultingDate: '',
            consult_time: '',
            withDisabled:'',
            withChildren:'',
            withElderly:'',
            numberOfPeople:'',
            travel_date:'',
            note:'',
          },
        })

        onMounted(() => {
          state.info.withDisabled=false
          state.info.withChildren=false
          state.info.withElderly=false
        })

        const setTime = function() {
          state.info.consult_time = event.currentTarget.value;
        }

        const reserve = function () {
          console.log(state.info);
          reserve(state.info);
        }

        return {
          store,
          registerGuideList,
          state,
          setTime,
          reserve
        };
  },
}
</script>