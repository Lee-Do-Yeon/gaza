<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col">
          <div class="tour_details_leftside_wrapper">
            <div class="tour_details_heading_wrapper">
              <div>
                <h3>
                  <img src="../../assets/img/banner/guide_profile.jpg" />
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
            <div
              class="d-flex mt-2 justify-content-end"
            >
              <button @click="MoveReser(review.id)" class="me-2 btn btn_theme btn-lg">
                예약하기
              </button>
            </div>

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

          <h3 style="font-weight: bold">리뷰</h3>
          <div class="table-responsive-lg table_common_area">
            <table class="table">
              <thead>
                <tr>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>별점</th>
                  <th>내용</th>
                </tr>
              </thead>
              <tbody v-for="rev in review" :key="rev.id">
                <tr>
                  <td>{{ rev.userId }}</td>
                  <td>{{ getDate(rev.createdDate) }}</td>
                  <td>
                    <i
                      v-for="score in rev.score"
                      :key="score"
                      class="fas fa-sharp fa-solid fa-star"
                      style="color: yellow"
                    ></i>
                  </td>
                  <td>{{ rev.content }}</td>
                </tr>
              </tbody>
            </table>
          </div>

          <div class="pagination_area">
            <ul class="pagination">
              <li v-if="currentpage !== 1" class="page-item">
                <a
                  style="cursor: pointer"
                  class="page-link"
                  @click="getValue(currentpage - 1)"
                  aria-label="Previous"
                >
                  <span aria-hidden="true">«</span>
                  <span class="sr-only">Previous</span>
                </a>
              </li>
              <li v-for="page in numberofpages" :key="page" class="page-item">
                <a
                  style="cursor: pointer"
                  class="page-link"
                  @click="getValue(page)"
                >
                  {{ page }}</a
                >
              </li>
              <a
                v-if="currentpage !== numberofpages"
                style="cursor: pointer"
                class="page-link"
                @click="getValue(currentpage + 1)"
                aria-label="Next"
              >
                <span aria-hidden="true">»</span>
                <span class="sr-only">Next</span>
              </a>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { reviewss } from "../../../common/api/commonAPI";

import { ref, computed } from "vue";
import { useRouter } from "vue-router";

export default {
  setup() {
    const review = ref([]);
    const numberofreviews = ref(0);
    const currentpage = ref(1);
    const limit = 5;
    const StartDate = ref("");
    const EndDate = ref("");

    const router = useRouter();

    const getDate = (date) => {
      const DAT = new Date(date);
      return (
        DAT.getFullYear() + "-" + (DAT.getMonth() + 1) + "-" + DAT.getDay()
      );
    };

    const getValue = async (page = currentpage.value) => {
      currentpage.value = page;
      try {
        const res = await reviewss(
          `?_sort=id&_order=desc&_page=${page}&_limit=${limit}`
        );
        numberofreviews.value = res.data["length"];
        review.value = res.data;
      } catch (err) {
        console.log(err);
      }
    };
    getValue();

    const coputeReview = computed(() => {
      return review, StartDate, EndDate;
    });

    const numberofpages = computed(() => {
      return Math.ceil(numberofreviews.value / limit);
    });

    const MoveReser = (id) => {
      router.push({
        name: "about",
        params: {
          id: id,
        },
      });
    };
    console.log(review)

    return {
      getValue,
      limit,
      numberofpages,
      currentpage,
      numberofreviews,
      review,
      StartDate,
      EndDate,
      coputeReview,
      getDate,
      router,
      MoveReser,
    };
  },
};
</script>
