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
                <h3>{{ guideInfo.name }}</h3>
                <br />
                <h5>{{ guideInfo.country }} / {{ guideInfo.city }} / {{ guideInfo.gender }}</h5>
                <p v-for="data in themaInfo" :key="data.length">
                  {{ data }}
                </p>
                <div>{{ guideInfo.introduction }}</div>
              </div>
            </form>
            <div class="d-flex mt-2 justify-content-end">
              <router-link :to="{name : 'testimonials', params : { guideId : $route.params.guideId}}">
                <button class="me-2 btn btn_theme btn-lg">예약하기</button>
              </router-link>
            </div>

            <!--start 추천장소 -->
            <div class="new_main_news_box">
              <br />
              <h3 style="font-weight: bold">가이드의 추천 명소</h3>

              <div class="row">
                <div
                  class="col-lg-4 col-md-6 col-sm-12 col-12"
                  v-for="loc in recommendInfo"
                  :key="loc.name"
                >
                  <div class="news_item_boxed">
                    <div class="news_item_img">
                      <img src="../../assets/img/news/news-1.png" alt="img"
                      />
                    </div>
                    <div class="news_item_content">
                      <h3>
                        {{ loc.name }} 
                      </h3>
                      <p>{{ loc.address }}</p>
                    </div>
                  </div>
                </div>
              </div>
              <!--end 추천장소 -->
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
                <a style="cursor: pointer" class="page-link" @click="getValue(page)"> {{ page }}</a>
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
import { reviewss, guideDetail } from "../../../common/api/commonAPI";

import { ref, computed, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import axios from "@/api/http";

export default {
  setup() {
    const route = useRoute();
    const review = ref([]);
    const numberofreviews = ref(0);
    const currentpage = ref(1);
    const limit = 5;
    const StartDate = ref("");
    const EndDate = ref("");

    const guideInfo = ref([]);
    const recommendInfo = ref([]);
    const themaInfo = ref([]);

    const router = useRouter();

    const getDate = (date) => {
      const DAT = new Date(date);
      return DAT.getFullYear() + "-" + (DAT.getMonth() + 1) + "-" + DAT.getDay();
    };

    const getValue = async (page = currentpage.value) => {
      currentpage.value = page;
      try {
        const res = await reviewss(`?_sort=id&_order=desc&_page=${page}&_limit=${limit}`);
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

    // const detail = async (guideId) => {
    //   try {
    //     const response = await guideDetail(parseInt(guideId));
    //     guideInfo.value = response.data.result;
    //     recommendInfo.value = guideInfo.guideLocationList;
    //   } catch (err) {
    //     console.log(err);
    //   }
    // };

    onMounted(() => {
      const guideId = parseInt(route.params.guideId);
      //console.log(guideId);

      axios.get(`/guides/${guideId}`).then((res) => {
        guideInfo.value = res.data;
        console.log(res.data.gender);
        recommendInfo.value = res.data.guideLocationList;
        themaInfo.value = res.data.thema;
      });

      console.log(guideInfo);
      console.log(recommendInfo);
    });

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
      guideInfo,
      recommendInfo,
      //detail,
      themaInfo,
    };
  },
};
</script>
