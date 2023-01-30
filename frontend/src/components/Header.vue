<template>
    <div>
        <header class="main_header_arae">
            <!-- Navbar Bar -->
            <div class="navbar-area">
                <div class="main-responsive-nav">
                    <div class="container">
                        <div class="main-responsive-menu mean-container">
                            <nav class="navbar">
                                <div class="container">
                                    <div class="logo">
                                        <router-link to="/">
                                            <img src="../assets/img/white_logo.png" alt="logo">
                                        </router-link>
                                    </div>
                                    <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#navbar-content">
                                        <div class="hamburger-toggle">
                                            <div class="hamburger">
                                                <span></span>
                                                <span></span>
                                                <span></span>
                                            </div>
                                        </div>
                                    </button>
                                    <div class="collapse navbar-collapse mean-nav" id="navbar-content">
                                        <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
                                            <li class="nav-item dropdown">
                                                <router-link to="/" class="dropdown-item dropdown-toggle"
                                                    data-bs-toggle="dropdown"
                                                    data-bs-auto-close="outside">Home</router-link>
                                                <ul class="dropdown-menu shadow">
                                                    <li class="nav-item">
                                                        <router-link to="/" class="dropdown-item">Home One</router-link>
                                                    </li>
                                                    <li class="nav-item">
                                                        <router-link to="/home-two" class="dropdown-item">Home
                                                            Two</router-link>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"
                                                    data-bs-auto-close="outside">Pages</a>
                                                <ul class="dropdown-menu shadow">
                                                    <li class="dropend">
                                                        <a href="#" class="dropdown-item dropdown-toggle"
                                                            data-bs-toggle="dropdown" data-bs-auto-close="outside">User
                                                            Pages</a>
                                                        <ul class="dropdown-menu shadow">

                                                            <li class="nav-item">
                                                                <router-link to="/login"
                                                                    class="dropdown-item">Login</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/register"
                                                                    class="dropdown-item">Register</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/forgot-password"
                                                                    class="dropdown-item">Forget
                                                                    Password</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/verify-otp"
                                                                    class="dropdown-item">Verify
                                                                    OTP</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/reset-password"
                                                                    class="dropdown-item">Reset
                                                                    Password</router-link>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li class="dropend">
                                                        <a href="#" class="dropdown-item dropdown-toggle"
                                                            data-bs-toggle="dropdown"
                                                            data-bs-auto-close="outside">Customer Dashboard</a>
                                                        <ul class="dropdown-menu shadow">

                                                            <li class="nav-item">
                                                                <router-link to="/dashboard"
                                                                    class="dropdown-item">Dashboard</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/hotel-booking"
                                                                    class="dropdown-item">Hotel
                                                                    booking</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/flight-booking"
                                                                    class="dropdown-item">Flight
                                                                    booking</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/tour-booking"
                                                                    class="dropdown-item">Tour
                                                                    booking</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/booking-history"
                                                                    class="dropdown-item">Booking
                                                                    history</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/my-profile" class="dropdown-item">My
                                                                    profile</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/wallet"
                                                                    class="dropdown-item">Wallet</router-link>
                                                            </li>
                                                            <li class="nav-item">
                                                                <router-link to="/notification"
                                                                    class="dropdown-item">Notifications</router-link>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li class="nav-item">
                                                        <router-link to="/privacy-policy" class="dropdown-item">Privacy
                                                            Policy</router-link>
                                                    </li>
                                                    <li class="nav-item">
                                                        <router-link to="/error" class="dropdown-item">404
                                                            Error</router-link>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="nav-item">
                                                <router-link to="/contact" class="dropdown-item">Contact</router-link>
                                            </li>
                                            <li class="nav-item">
                                                <router-link to="/login" class="dropdown-item">Login</router-link>
                                            </li>
                                            <li class="nav-item">
                                                <router-link to="/register" class="dropdown-item">Signin</router-link>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="main-navbar">
                    <div class="container">
                        <nav class="navbar navbar-expand-md navbar-light">
                            <router-link class="navbar-brand" to="/">
                                <img src="../assets/img/logo.png" alt="logo">
                            </router-link>

                            <div class="collapse navbar-collapse mean-menu" id="navbarSupportedContent">
                                <div class="others-options d-flex align-items-center">
                                    <div class="option-item">
                                        <router-link to="/become-vendor" class="btn  btn_navber">Become a
                                            partner</router-link>
                                    </div>
                                    <div class="option-item">
                                        <router-link to="/login" class="btn btn_navber">Login</router-link>
                                    </div>
                                    <div class="option-item">
                                        <router-link to="/register" class="btn btn_navber">Sign up</router-link>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
                <div class="others-option-for-responsive">
                    <div class="container">
                        <div class="container">
                            <div class="option-inner">
                                <div class="others-options d-flex align-items-center">
                                    <div class="option-item">
                                        <a href="#" class="search-box"><i class="fas fa-search"></i></a>
                                    </div>
                                    <div class="option-item">
                                        <router-link to="/contact" class="btn btn_navber">Get free quote</router-link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </div>
</template>
<script>
export default {
    name: 'Header',
    data() {
        return {
            language: 'English',
            currency: 'USD',
            isSticky: false,
        }
    },

    mounted() {
        window.addEventListener('scroll', () => {
            let scroll = window.scrollY
            if (scroll >= 200) {
                this.isSticky = true
            } else {
                this.isSticky = false
            }
        })

        document.addEventListener('click', function (e) {
            // Hamburger menu
            if (e.target.classList.contains('hamburger-toggle')) {
                e.target.children[0].classList.toggle('active');
            }
        })
    }
}
</script>

