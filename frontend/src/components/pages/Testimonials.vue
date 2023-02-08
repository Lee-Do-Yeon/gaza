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
                    <input type="date" value="2023-02-01" />
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 ms-2">
              <h3 style="color: #15d4cd">시간대 설정</h3>
              <div class="reser_boxed">
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    01
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    02
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    03
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    04
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    05
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    06
                  </button>
                </div>
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    07
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    08
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    09
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    10
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    11
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    12
                  </button>
                </div>
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    13
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    14
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    15
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    16
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    17
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    18
                  </button>
                </div>
                <div class="btn-group" role="group">
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    19
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    20
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    21
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    22
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
                    23
                  </button>
                  <button class="btn btn_theme btn_sm me-1 mb-2" type="submit">
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
                  <input class="form-check-input" type="checkbox" />
                  <label class="form-check-label">장애 여부</label>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" />
                  <label class="form-check-label">유아 동반</label>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" />
                  <label class="form-check-label">노약자 동반</label>
                </div>
              </div>
              <div class="row mt-4 mb-4">
                <div class="col-lg-6">
                  <div class="input-group">
                    인원 : <input min="0" type="number" />
                  </div>
                </div>
                <div class="col-lg-6">여행날짜: <input type="date" /></div>
              </div>
              <div style="font-weight: bold">특이사항</div>
              <div class="col-lg-12 mt-4">
                <div class="form-group">
                  <textarea class="form-control bg_input" rows="6"></textarea>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="section_heading_center mt-4">
          <router-link to="/complete">
            <button type="button" class="btn btn_theme btn_md">예약하기</button>
          </router-link>
        </div>
      </div>
    </div>
  </section>
</template>
<script></script>
