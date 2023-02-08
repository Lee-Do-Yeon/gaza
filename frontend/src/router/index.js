import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import HomeTwoView from '../views/HomeTwoView.vue'
import TourSearchView from '../views/TourSearchView.vue'
import TourSearchViewCopy from '../views/TourSearchViewCopy.vue'
import TourDetailsView from '../views/TourDetailsView.vue'
import TourBookingSubmissionView from '../views/TourBookingSubmissionView.vue'
import TopDestinationsView from '../views/TopDestinationsView.vue'
import FlightSearchResultView from '../views/FlightSearchResultView.vue'
import FlightBookingSubmission from '../views/FlightBookingSubmission.vue'
import HotelSearchView from '../views/HotelSearchView.vue'
import HotelDetailsView from '../views/HotelDetailsView.vue'
import RoomDetailsView from '../views/RoomDetailsView.vue'
import RoomBookingView from '../views/RoomBookingView.vue'
import AboutView from '../views/AboutView.vue'
import TourGuidesView from '../views/TourGuidesView.vue'
import TestimonialsView from '../views/TestimonialsView.vue'
import FaqsView from '../views/FaqsView.vue'
import BookingConfirmationView from '../views/BookingConfirmationView.vue'
import NewsView from '../views/NewsView.vue'
import NewsV2View from '../views/NewsV2View.vue'
import NewsDetailsView from '../views/NewsDetailsView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import ResetPasswordView from '../views/ResetPasswordView.vue'
import ForgotPasswordView from '../views/ForgotPasswordView.vue'
import VerifyOtpView from '../views/VerifyOtpView.vue'
import DashboardView from '../views/DashboardView.vue'
import HotelBookingView from '../views/HotelBookingView.vue'
import FlightBookingView from '../views/FlightBookingView.vue'
import TourBookingView from '../views/TourBookingView.vue'
import BookingHistoryView from '../views/BookingHistoryView.vue'
import MyProfileView from '../views/MyProfileView.vue'
import WalletView from '../views/WalletView.vue'
import NotificationView from '../views/NotificationView.vue'
import PrivacyPolicyView from '../views/PrivacyPolicyView.vue'
import ErrorView from '../views/ErrorView.vue'
import CompleteView from '../views/CompleteView.vue'
import ContactView from '../views/ContactView.vue'
import BecomeVendorView from '../views/BecomeVendorView.vue'
import NotFound from '../components/NotFound.vue'

import reviewView from '../views/reviewView.vue'

import GuideScheduleView from '../views/GuideScheduleView.vue'
import GuideReviewView from '../views/GuideReviewView.vue'
import GuideQNAView from '../views/GuideQNAView.vue'


import OpenViduView from '../views/OpenViduView.vue'

import MapDetail from "@/components/map/MapDetail";
import MapTest from "@/components/map/MapTest";
import AppMap from "../views/AppMap.vue";


import AppChat from "../views/AppChat.vue";
import ChatDetail from "@/components/chat/ChatDetail.vue";
import ChatEnter from "@/components/chat/ChatEnter.vue";

import Admin from "../views/AdminView.vue"

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/admin',
    name: 'admin',
    component: Admin
  },
  {
    path: '/home-two',
    name: 'home-two',
    component: HomeTwoView
  },
  {
    path: '/tour-search/:searchitem',
    name: 'tour-search',
    component: TourSearchView
  },
  {
    path: '/tour-search-copy/:searchitem',
    name: 'tour-search-copy',
    component: TourSearchViewCopy
  },
  {
    path: '/tour-details',
    name: 'tour-details',
    component: TourDetailsView
  },
  {
    path: '/tour-booking-submission',
    name: 'tour-booking-submission',
    component: TourBookingSubmissionView
  },
  {
    path: '/top-destinations',
    name: 'top-destinations',
    component: TopDestinationsView
  },
  {
    path: '/flight-search-result',
    name: 'flight-search-result',
    component: FlightSearchResultView
  },
  {
    path: '/flight-booking-submission',
    name: 'flight-booking-submission',
    component: FlightBookingSubmission
  },
  {
    path: '/hotel-search',
    name: 'hotel-search',
    component: HotelSearchView
  },
  {
    path: '/hotel-details',
    name: 'hotel-details',
    component: HotelDetailsView
  },
  {
    path: '/room-details',
    name: 'room-details',
    component: RoomDetailsView
  },
  {
    path: '/room-booking',
    name: 'room-booking',
    component: RoomBookingView
  },
  {
    path: '/about/:id',
    name: 'about',
    component: AboutView
  },
  {
    path: '/tour-guides',
    name: 'tour-guides',
    component: TourGuidesView
  },
  {
    path: '/testimonials',
    name: 'testimonials',
    component: TestimonialsView
  },
  {
    path: '/faqs',
    name: 'faqs',
    component: FaqsView
  },
  {
    path: '/booking-confirmation',
    name: 'booking-confirmation',
    component: BookingConfirmationView
  },
  {
    path: '/news',
    name: 'news',
    component: NewsView
  },
  {
    path: '/news-v2',
    name: 'news-v2',
    component: NewsV2View
  },
  {
    path: '/news-details',
    name: 'news-details',
    component: NewsDetailsView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/forgot-password',
    name: 'forgot-password',
    component: ForgotPasswordView
  },
  {
    path: '/verify-otp',
    name: 'verify-otp',
    component: VerifyOtpView
  },
  {
    path: '/reset-password',
    name: 'reset-password',
    component: ResetPasswordView
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: DashboardView
  },
  {
    path: '/hotel-booking',
    name: 'hotel-booking',
    component: HotelBookingView
  },
  {
    path: '/flight-booking',
    name: 'flight-booking',
    component: FlightBookingView
  },
  {
    path: '/tour-booking',
    name: 'tour-booking',
    component: TourBookingView
  },
  {
    path: '/booking-history',
    name: 'booking-history',
    component: BookingHistoryView
  },
  {
    path: '/my-profile',
    name: 'my-profile',
    component: MyProfileView
  },
  {
    path: '/wallet',
    name: 'wallet',
    component: WalletView
  },
  {
    path: '/notification',
    name: 'notification',
    component: NotificationView,
  },
  {
    path: '/privacy-policy',
    name: 'privacy-policy',
    component: PrivacyPolicyView
  },
  {
    path: '/error',
    name: 'error',
    component: ErrorView
  },
  {
    path: '/contact',
    name: 'contact',
    component: ContactView
  },
  {
    path: '/become-vendor',
    name: 'become-vendor',
    component: BecomeVendorView
  },
  {
    path: '/:cathAll(.*)',
    name: 'NotFound',
    component: NotFound
  },
  {
    path :'/review/:id/:name',
    name: 'review',
    component: reviewView
  },
  {
    path:'/guide_schedule',
    name : 'guide_schedule',
    component:GuideScheduleView
  },
  {
    path: '/guide_review',
    name : 'guide_review',
    component : GuideReviewView
  },
  {
    path : '/guide_QNA',
    name : 'guide_QNA',
    component :GuideQNAView
  },
  {
    path : '/openvidu',
    name : 'openvidu',
    component :OpenViduView
  },
  {
    path : '/complete',
    name : 'complete',
    component :  CompleteView
  },
  {
    path: "/map",
    name: "map",
    component: AppMap,
    redirect: "map/test",
    children: [
      {
        path: "test",
        name: "maptest",
        component: MapTest,
      },
      {
        path: "detail/:roomId",
        name: "mapdetail",
        component: MapDetail,
      },
    ],
  },

  {
    path: "/chat",
    name: "chat",
    component: AppChat,
    children: [
      {
        path: "enter",
        name: "chateEnter",
        component: ChatEnter,
      },
      {
        path: "room/:roomId",
        name: "chatDetail",
        component: ChatDetail,
      },
    ],
  }
]


const scrollBehavior = (to, from, savedPosition) => {
  return savedPosition || to.meta?.scrollPos || { top: 0, left: 0 }
}

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior,
})

router.beforeEach((to, from, next) => {
  console.log('window.scrollY:', window.scrollY)
  from.meta?.scrollPos && (from.meta.scrollPos.top = window.scrollY)
  console.log('from:\t', from.name, '\t', from.meta?.scrollPos)
  console.log('to:\t\t', to.name, '\t', to.meta?.scrollPos)
  return next()
})

export default router