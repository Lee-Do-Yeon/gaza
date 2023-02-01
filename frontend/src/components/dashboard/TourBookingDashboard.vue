<template>
    <section id="dashboard_main_arae" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="dashboard_sidebar">
                        <div class="dashboard_sidebar_user">
                            <img src="../../assets/img/common/dashboard-user.png" alt="img">
                            <h3>Sherlyn Chopra</h3>
                            <p><a href="tel:+00-123-456-789">+00 123 456 789</a></p>
                            <p><a href="mailto:sherlyn@domain.com">sherlyn@domain.com</a></p>
                        </div>
                        <div class="dashboard_menu_area">
                            <ul>
                                <li><router-link to="/dashboard"><i
                                            class="fas fa-tachometer-alt"></i>Dashboard</router-link></li>
                                <MyBookingOption />
                                <li><router-link to="/my-profile"><i class="fas fa-user-circle"></i>My
                                        profile</router-link></li>
                                <li><router-link to="/dashboard"><i class="fas fa-wallet"></i>Wallet</router-link>
                                </li>
                                <li><router-link to="/notification"><i
                                            class="fas fa-bell"></i>Notifications</router-link></li>
                                <LogoutBtn />
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="dashboard_common_table">
                        <h3>Tour booking</h3>
                        <div class="table-responsive-lg table_common_area">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Sl no.</th>
                                        <th>Booking ID</th>
                                        <th>Booking type</th>
                                        <th>Booking amount</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>01.</td>
                                        <td>#JK589V80</td>
                                        <td>Hotel</td>
                                        <td>$754.00</td>
                                        <td class="complete">Completed</td>
                                        <td><i class="fas fa-eye"></i></td>
                                    </tr>
                                    <tr>
                                        <td>02.</td>
                                        <td>#JK589V80</td>
                                        <td>Hotel</td>
                                        <td>$754.00</td>
                                        <td class="complete">Completed</td>
                                        <td><i class="fas fa-eye"></i></td>
                                    </tr>
                                    <tr>
                                        <td>03.</td>
                                        <td>#JK589V80</td>
                                        <td>Hotel</td>
                                        <td>$754.00</td>
                                        <td class="complete">Completed</td>
                                        <td><i class="fas fa-eye"></i></td>
                                    </tr>
                                    <tr>
                                        <td>04.</td>
                                        <td>#JK589V80</td>
                                        <td>Hotel</td>
                                        <td>$754.00</td>
                                        <td class="complete">Completed</td>
                                        <td><i class="fas fa-eye"></i></td>
                                    </tr>
                                    <tr>
                                        <td>05.</td>
                                        <td>#JK589V80</td>
                                        <td>Hotel</td>
                                        <td>$754.00</td>
                                        <td class="cancele">Canceled</td>
                                        <td><i class="fas fa-eye"></i></td>
                                    </tr>
                                    <tr>
                                        <td>06.</td>
                                        <td>#JK589V80</td>
                                        <td>Hotel</td>
                                        <td>$754.00</td>
                                        <td class="complete">Completed</td>
                                        <td><i class="fas fa-eye"></i></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="pagination_area">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">«</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">»</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import LogoutBtn from '@/components/dashboard/LogoutBtn.vue'
import MyBookingOption from '@/components/dashboard/MyBookingOption.vue'
export default {
    name: "TourBookingDashboard",
    components: {
        LogoutBtn, MyBookingOption
    }
};
</script>