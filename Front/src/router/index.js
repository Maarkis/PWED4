import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from "../components/Login";
import Admin from "../components/Admin";
import Vendas from "../components/Vendas";
import SobreNos from "../components/SobreNos";

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'login',
        component: Login
    },
    {
        path: '/admin',
        name: 'admin',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: Admin
    },
    {
        path: '/vendas',
        name: 'vendas',
        component: Vendas
    },
    {
        path: '/credits',
        name: 'creditos',
        component: SobreNos
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
