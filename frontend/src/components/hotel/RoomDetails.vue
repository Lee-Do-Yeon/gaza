<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-3">
          <div class="dashboard_menu_area">
            <ul>
              <li>
                <router-link to="/room-details" class="active"
                  >내 정보 확인 및 수정</router-link
                >
              </li>
              <li>
                <router-link to="/guide_schedule">상담일정 확인</router-link>
              </li>

              <li>
                <router-link to="/guide_review">리뷰조회</router-link>
              </li>
              <li>
                <router-link to="/guide_QNA">질문답변</router-link>
              </li>
            </ul>
          </div>
        </div>
        <div class="col">
          <div class="tour_details_leftside_wrapper">
            <div class="tour_details_heading_wrapper">
              <div>
                <h3>
                  <img src="../../assets/img/banner/background.jpg" />
                </h3>
              </div>
            </div>
            <hr />
            <form class="d-flex">
              <img
                style="border-radius: 50%"
                src="../../assets/img/common/dashboard-user.png"
                alt="img"
              />
              <div class="ms-3">
                <h3>고길동</h3>
                <br />
                <h5>대한민국 / 광주 / 54 / 남성</h5>
                <div>
                  안녕하세요!! 저는 가이드 고길동입니다.<br />
                  저는 대한민국 서울에서 30년을 살았고<br />
                  한국어와 영어에 능통합니다.
                </div>
              </div>
            </form>

            <div class="new_main_news_box">
              <br />
              <h3 style="font-weight: bold">가이드의 추천 명소</h3>

              <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <router-link to="/news-details"
                        ><img src="../../assets/img/news/news-1.png" alt="img"
                      /></router-link>
                    </div>
                    <div class="news_item_content">
                      <h3>
                        <router-link to="/news-details">한강 </router-link>
                      </h3>
                      <p>대한민국 치킨 맛집</p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <router-link to="/news-details"
                        ><img src="../../assets/img/news/news-2.png" alt="img"
                      /></router-link>
                    </div>
                    <div class="news_item_content">
                      <h3>
                        <router-link to="/news-details"> 전주 </router-link>
                      </h3>
                      <p>대한민국 비빔밥 맛집</p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <router-link to="/news-details"
                        ><img src="../../assets/img/news/news-3.png" alt="img"
                      /></router-link>
                    </div>
                    <div class="news_item_content">
                      <h3>
                        <router-link to="/news-details"> 완도 </router-link>
                      </h3>
                      <p>대한민국 김 맛집</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr />
          <h3 style="font-weight: bold">상담 불가 날짜/시간 설정</h3>
          <br />
          <div class="row d-flex justify-content-center">
            

            <div class="col-lg-4 me-5">
              <h5 style="color: #15d4cd">Choose a Date</h5>
            <br/>
              <div class="form_search_date">
                <div class="flight_Search_boxed date_flex_area">
                  <div class="Journey_date">
                    <input type="date" value="2023-02-01" />
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 ms-5">
              <h5 style="color: #15d4cd">Pick a time</h5>
              <div class="tour_details_boxed">
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
    </div>
  </section>
</template>
<script>
export default {
  name: "RoomDetails",
};
</script>
