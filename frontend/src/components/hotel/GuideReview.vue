<template>
  <section id="tour_details_main" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-3">
          <div class="dashboard_menu_area">
            <ul>
              <li>
                <router-link to="/room-details">내 정보 확인 및 수정</router-link>
              </li>
              <li>
                <router-link
                  :to="{
                    name: 'guide_schedule',
                  }"
                  >예약내역 확인</router-link
                >
              </li>
              <li>
                <router-link
                  :to="{
                    name: 'guide_review',
                  }"
                  class="active">리뷰조회</router-link
                >
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-8">
          <div class="dashboard_common_table">
            <div class="dashboard_main_top">
              <!--
              <div class="d-flex align-items-center justify-content-between">
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="form_search_date">
                    <div class="flight_Search_boxed date_flex_area">
                      <div class="Journey_date">
                        <p>From</p>
                        <input type="date" value="2023-01-10" />
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                  <div class="form_search_date">
                    <div class="flight_Search_boxed date_flex_area">
                      <div class="Journey_date">
                        <p>To</p>
                        <input type="date" value="2023-01-30" />
                      </div>
                    </div>
                  </div>
                </div>

                <div>
                  <button class="btn btn_theme btn-lg">Filter</button>
                </div>
              </div>-->
            </div>
          </div>
          <hr />

          <div class="dashboard_common_table">
            <h3>리뷰조회</h3>
            <div class="table-responsive-lg table_common_area">
              <table class="table">
                <thead>
                  <tr>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>별점</th>
                    <th>내용</th>
                    <!-- <th>Status</th>
                    <th>Action</th> -->
                  </tr>
                </thead>
                <tbody v-for="rev in review" :key="rev.reviewId">
                  <tr>
                    <td>{{ rev.reviewId }}</td>
                    <td>{{ rev.createdDate }}</td>
                    <td>
                      <i
                        v-for="score in rev.score"
                        :key="score"
                        class="fas fa-sharp fa-solid fa-star"
                        style="color: yellow"
                      ></i>
                    </td>
                    <td>{{ rev.content }}</td>
                    <!-- <td class="complete">Completed</td>
                    <td><i class="fas fa-eye"></i></td> -->
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <!-- <div class="pagination_area">
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
              <li  v-for="page in numberofpages" :key="page" class="page-item">
                <a
                  style="cursor: pointer"
                  class="page-link"
                  @click="getValue(page)"
                >
                  {{ page }}</a
                >
              </li>
              <a v-if="currentpage !== numberofpages" style="cursor:pointer" class="page-link" @click="getValue(currentpage +1)" aria-label="Next">
                <span aria-hidden="true">»</span>
                <span class="sr-only">Next</span>
              </a>
            </ul>
          </div> -->
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import axios from "@/api/http";
import { mapState } from "vuex";
const accountStore = "accountStore";

export default {
  name: "GuideReview",

  data() {
    return {
      review: [],
    };
  },
  computed: {
    ...mapState(accountStore, ["userId"]),
  },
  created() {
    this.reviewList(this.userId);
  },
  methods: {
    reviewList(guideId) {
      axios.get(`/reviews/guide/${guideId}`).then((res) => {
        this.review = res.data;
      });
    },
  },
};
</script>
