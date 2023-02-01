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
                                <li><router-link to="/dashboard" class="active"><i
                                            class="fas fa-wallet"></i>Wallet</router-link></li>
                                <li><router-link to="/notification"><i
                                            class="fas fa-bell"></i>Notifications</router-link></li>
                                <LogoutBtn />
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="dashboard_common_table">
                        <div class="wallwt_area_top">
                            <h3>Wallet</h3>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="wallet_area_boxed">
                                        <h4>My wallet</h4>
                                        <div class="wallet_blance_boxed">
                                            <p>Wallet balance</p>
                                            <h5>BDT 12,750.00</h5>
                                        </div>
                                        <div class="wallet_boxed_flex">
                                            <div class="wallet_blance_boxed">
                                                <p>Total credit</p>
                                                <h5>BDT 52,050.00</h5>
                                            </div>
                                            <div class="wallet_blance_boxed">
                                                <p>Total debit</p>
                                                <h5>BDT 52,050.00</h5>
                                            </div>
                                        </div>
                                        <div class="dashboard_price_range">
                                            <div class="main_range_price"></div>
                                            <div class="price_range_blance">
                                                <p>BDT 52,050.00</p>
                                                <p>BDT 52,050.00</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="wallet_area_boxed">
                                        <h4>Add wallet</h4>
                                        <div class="add_balance_area">
                                            <div class="input-group">
                                                <span class="input-group-text">$</span>
                                                <input type="number" class="form-control"
                                                    aria-label="Amount (to the nearest dollar)">
                                            </div>
                                            <div class="other_add_balance_area">
                                                <span>or</span>
                                                <div class="other_add_bal_button">
                                                    <button class="btn btn_add_bal">BDT 100</button>
                                                    <button class="btn btn_add_bal active">BDT 500</button>
                                                    <button class="btn btn_add_bal">BDT 400</button>
                                                </div>
                                                <button class="btn btn_theme btn_md w-100">Add wallet</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <h3 class="wallet_table_top">Wallet transaction</h3>
                            <div class="wallet_data_table">
                                <div class="table-responsive-lg table_common_area">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Sl no.</th>
                                                <th>Date</th>
                                                <th>Credit</th>
                                                <th>Debit</th>
                                                <th>Balance</th>
                                                <th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>01.</td>
                                                <td>30 Jan 2022</td>
                                                <td>$500.00</td>
                                                <td>-</td>
                                                <td>$500.00 </td>
                                                <td class="complete">Completed</td>
                                            </tr>
                                            <tr>
                                                <td>02.</td>
                                                <td>30 Jan 2022</td>
                                                <td>$500.00</td>
                                                <td>-</td>
                                                <td>$500.00 </td>
                                                <td class="complete">Completed</td>
                                            </tr>
                                            <tr>
                                                <td>03.</td>
                                                <td>30 Jan 2022</td>
                                                <td>-</td>
                                                <td>$500.00</td>
                                                <td>$500.00 </td>
                                                <td class="cancele">Canceled</td>
                                            </tr>
                                            <tr>
                                                <td>04.</td>
                                                <td>30 Jan 2022</td>
                                                <td>$500.00</td>
                                                <td>-</td>
                                                <td>$500.00 </td>
                                                <td class="complete">Completed</td>
                                            </tr>
                                            <tr>
                                                <td>05.</td>
                                                <td>30 Jan 2022</td>
                                                <td>-</td>
                                                <td>$500.00</td>
                                                <td>$500.00</td>
                                                <td class="cancele">Canceled</td>
                                            </tr>
                                            <tr>
                                                <td>06.</td>
                                                <td>30 Jan 2022</td>
                                                <td>$500.00</td>
                                                <td>-</td>
                                                <td>$500.00 </td>
                                                <td class="complete">Completed</td>
                                            </tr>
                                        </tbody>
                                    </table>
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
import LogoutBtn from '@/components/dashboard/LogoutBtn.vue'
import MyBookingOption from '@/components/dashboard/MyBookingOption.vue'
export default {
    name: "WalletDashboard",
    components: {
        LogoutBtn, MyBookingOption
    }
};
</script>