import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Paciente from './components/Paciente.vue'
//import Orden from './components/Orden.vue'
//import RegistroEmisor from './components/RegistroEmisor.vue'
import Login from './views/Login.vue'
import MisRecibos from './views/MisRecibos.vue'
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/pacientes',
      name: 'pacientes',
      component: Paciente
    },
    {
      path: '/emisor/login',
      name: 'login',
      component: Login
    },
    {
      path: '/recibos',
      name: 'recibos',
      component: MisRecibos
    }
  ]
})
