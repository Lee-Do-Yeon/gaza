import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

// Main CSS Add
import './assets/app.css'

createApp(App).use(router).mount('#app');