import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TourSearchView from '../views/TourSearchView.vue'
import TourSearchViewCopy from '../views/TourSearchViewCopy.vue'
import HotelDetailsView from '../views/HotelDetailsView.vue'
import RoomDetailsView from '../views/RoomDetailsView.vue'
import TestimonialsView from '../views/TestimonialsView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import HotelSearchView from '../views/HotelSearchView.vue'
import DashboardView from '../views/DashboardView.vue'
import MyProfileView from '../views/MyProfileView.vue'
import NotificationView from '../views/NotificationView.vue'
import ErrorView from '../views/ErrorView.vue'
import CompleteView from '../views/CompleteView.vue'
import BecomeVendorView from '../views/BecomeVendorView.vue'
import NotFound from '../components/NotFound.vue'
import reviewView from '../views/reviewView.vue'
import GuideScheduleView from '../views/GuideScheduleView.vue'
import GuideReviewView from '../views/GuideReviewView.vue'
import GuideQNAView from '../views/GuideQNAView.vue'
import OpenViduView from '../views/OpenViduView.vue'
import OpenViduViewCopy from '../views/OpenViduViewCopy.vue'
import MapDetail from "@/components/map/MapDetail";
import MapTest from "@/components/map/MapTest";
import AppMap from "../views/AppMap.vue";
import AppChat from "../views/AppChat.vue";
import ChatDetail from "@/components/chat/ChatDetail.vue";
import ChatEnter from "@/components/chat/ChatEnter.vue";

import Admin from "../views/AdminView.vue"

// --------------------------
import ResetPasswordView from '../views/ResetPasswordView.vue'
import ForgotPasswordView from '../views/ForgotPasswordView.vue'

import GuideReview from "@/components/hotel/GuideReview"









































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
    path: '/hotel-search',
    name: 'hotel-search',
    component: HotelSearchView
  },
  {
    path: '/hotel-details/:guideId',
    name: 'hotel-details',
    component: HotelDetailsView
  },
  {
    path: '/room-details',
    name: 'room-details',
    component: RoomDetailsView
  },



  {
    path: '/testimonials',
    name: 'testimonials',
    component: TestimonialsView
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
    path: '/my-profile',
    name: 'my-profile',
    component: MyProfileView
  },

  {
    path: '/notification',
    name: 'notification',
    component: NotificationView,
  },

  {
    path: '/error',
    name: 'error',
    component: ErrorView
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
    path: '/guide_review/:guideId',
    name : 'guide_review',
    component : GuideReview
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
    path : '/openviducopy',
    name : 'openviducopy',
    component :OpenViduViewCopy
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
  },

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