<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-3">
          <div class="dashboard_menu_area">
            <ul>
              <li>
                <router-link to="/dashboard" class="active"
                  >내 정보 확인 및 수정</router-link
                >
              </li>
              <li>
                <router-link to="/my-profile">상담일정 확인</router-link>
              </li>

              <li>
                <router-link to="/notification">리뷰조회</router-link>
              </li>
              <li>
                <router-link to="/notification">질문답변</router-link>
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
                <br/>
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
                        <router-link to="/news-details"
                          >한강
                        </router-link>
                      </h3>
                      <p>
                        대한민국 치킨 맛집
                      </p>
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
                        <router-link to="/news-details">
                          전주
                        </router-link>
                      </h3>
                      <p>
                        대한민국 비빔밥 맛집
                      </p>
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
                        <router-link to="/news-details">
                            완도
                        </router-link>
                      </h3>
                      <p>
                        대한민국 김 맛집
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr/>



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
