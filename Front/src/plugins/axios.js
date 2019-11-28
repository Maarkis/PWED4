import Vue from 'vue'

import Axios from 'axios'

Axios.defaults.baseURL = 'http://localhost:8080/';

Axios.interceptors.response.use(function (response) {
    return response
}, function (error) {
    if (error.response.status === 401) {
        localStorage.clear();
        window.location.pathname = '/';
        alert('a')
    }
    return Promise.reject(error);
});

// Axios.defaults.headers['Access-Control-Allow-Origin'] = '/**';
// Axios.defaults.withCredentials = true;


Axios.interceptors.request.use(config => {
    let storedToken = localStorage.getItem('access-token');
    if (storedToken) {
        config.headers['access-token'] = storedToken;
        config.headers['session-id'] = localStorage.getItem('session-id');
    }
    return config;
});


Vue.use({
    install(Vue) {
        Vue.prototype.$http = Axios
    }
});
