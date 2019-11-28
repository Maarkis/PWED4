import Vue from 'vue'
import MainComponent from "./components/MainComponent"
import router from './router'

import './plugins/axios'
import './plugins/bootstrap-vue'

import store from './store/Store'


Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(MainComponent)
}).$mount('#app');
