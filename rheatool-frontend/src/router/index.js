import { createRouter, createWebHistory } from 'vue-router'
import LanguageView from '../views/LanguageView.vue'
import ModelView from '../views/ModelView.vue'
import InfoView from '../views/InfoView.vue'
import LanguageViewAlt from '../views/LanguageViewAlt.vue'

const routes = [
  {
    path: '/',
    name: 'language',
    component: LanguageView
  },
  {
    path: '/model',
    name: 'model',
    component: ModelView
  },
  {
    path: '/info',
    name: 'info',
    component: InfoView
  },
  {
    path: '/alt',
    name: 'language-alt',
    component: LanguageViewAlt
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
