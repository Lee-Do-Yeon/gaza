<template>
  <section id="dashboard_main_arae" class="section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="dashboard_sidebar">
            <div class="dashboard_sidebar_user">
              <img src="../../assets/img/common/dashboard-user.png" alt="img" />
              <h3>최지성</h3>
              <div>
                <picturemodalVue />
              </div>
            </div>
            <div class="dashboard_menu_area">
              <ul>
                <li>
                  <router-link to="/dashboard" class="active"
                    ><i class="fas fa-list"></i>이용후기</router-link
                  >
                </li>
                <!-- <MyBookingOption /> -->
                <li>
                  <router-link to="/my-profile"
                    ><i class="fas fa-user-circle"></i>내 정보 수정</router-link
                  >
                </li>
                <!-- <li>
                  <router-link to="/wallet"
                    ><i class="fas fa-wallet"></i>Wallet</router-link
                  >
                </li> -->
                <li>
                  <router-link to="/notification"
                    ><i class="fas fa-bell"></i>예약내역</router-link
                  >
                </li>
                <LogoutBtn />
              </ul>
            </div>
          </div>
        </div>

        <div class="col-lg-8">
          <div class="dashboard_common_table">
            <div class="dashboard_main_top">
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
              </div>
            </div>
          </div>
          <hr />

          <div class="dashboard_common_table">
            <h3>내가 쓴 후기</h3>
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
                <tbody v-for="rev in review" :key="rev.id">
                  <tr>
                    <td>{{ rev.reservation_id }}</td>
                    <td>{{ rev.created_date }}</td>
                    <td>
                      <i
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
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import LogoutBtn from "@/components/dashboard/LogoutBtn.vue";
import MyBookingOption from "@/components/dashboard/MyBookingOption.vue";
import picturemodalVue from "../modal/picturemodal.vue";
import axios from "axios";
import { ref, computed } from "vue";
export default {
  name: "DashboardArea",
  components: {
    LogoutBtn,
    MyBookingOption,
    picturemodalVue,
  },
  setup() {
    const review = ref([]);
    const numberofreviews = ref(0);
    const currentpage = ref(1);
    const limit = 5;

    const getValue = async (page = currentpage.value) => {
      currentpage.value = page;
      try {
        const res = await axios.get(
          `http://localhost:3000/review?_sort=id&_order=desc&_page=${page}&_limit=${limit}`
        );
        numberofreviews.value = res.headers["x-total-count"];
        review.value = res.data;
      } catch (err) {
        console.log(err);
      }
    };
    getValue();

    const numberofpages = computed(() => {
      return Math.ceil(numberofreviews.value / limit);
    });

    return {
      getValue,
      limit,
      numberofpages,
      currentpage,
      numberofreviews,
      review
    };
  },
};
</script>
