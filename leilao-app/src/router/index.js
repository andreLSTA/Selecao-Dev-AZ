import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'
import Empresas from '@/views/Empresas.vue'
import EmpresaCriar from '@/views/EmpresaCriar.vue'
import EmpresaEditar from '@/views/EmpresaEditar.vue'
import Leiloes from '@/views/Leiloes.vue'
import Unidades from '@/views/Unidades.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/empresas',
        name: 'Empresas',
        component: Empresas
    },
    {
        path: '/empresa',
        name: 'EmpresaCriar',
        component: EmpresaCriar
    },
    {
        path: '/empresa/:empresaId',
        name: 'EmpresaEditar',
        component: EmpresaEditar
    },
    {
        path: '/leiloes',
        name: 'Leiloes',
        component: Leiloes
    },
    {
        path: '/unidades',
        name: 'Unidades',
        component: Unidades
    },
    {
        path: '*',
        redirect: "/"
    }
]

const router = new VueRouter({
    routes
})

export default router
