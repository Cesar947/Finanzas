import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Inicio from './components/Inicio.vue'
import MisRecibos from './components/MisRecibos.vue'
import PasosASeguir from './components/PasosASeguir.vue'
import PreguntasFrecuentes from './components/PreguntasFrecuentes.vue'

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
    path: '/inicio',
    name: 'inicio',
    component: Inicio
   },
   {
    path: '/mis_recibos',
    name: 'misrecibos',
    component: MisRecibos
   },
   {
    path: '/pasos_a_seguir',
    name: 'pasos',
    component: PasosASeguir
   },
   {
    path: '/preguntas_frecuentes',
    name: 'preguntas',
    component: PreguntasFrecuentes 
   },
   {
     path: '/simulacion',
     name: 'simulacion',
     component: Simulacion
   },
   {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
  }
  ]
})
