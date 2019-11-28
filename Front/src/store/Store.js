import Vue from 'vue'

import Vuex from 'vuex'

import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        auth: {
            username: localStorage.getItem('username') || null,
            token: localStorage.getItem('access-token') || null,
            profile: localStorage.getItem('profile') || null,
            id: localStorage.getItem('id') || null
        }
    },
    getters: {
        getUsername: state => state.auth.username,
        getToken: state => state.auth.token,
        isAuthenticated: state => !state.auth.token,
        getProfile: state => state.profile,
        getId: state => state.id
    },
    actions: {
        login({commit}, credentials) {
            return new Promise((resolve, reject) => {
                axios.post('/login', {
                    login: credentials.login,
                    password: credentials.password
                }).then(response => {
                    commit('setUserData', response);
                    resolve(response);
                }).catch(error => {
                    commit('removeUserData');
                    reject(error);
                })
            })
        },
        logout({commit}) {
            commit('removeUserData');
        }
    },
    mutations: {
        setUserData(state, response) {
            state.auth.username = response.data.username;
            state.auth.token = response.data['access-token'];
            state.auth.profile = response.data.profile;
            state.auth.id = response.data.id;
            localStorage.setItem('access-token', response.data['access-token']);
            localStorage.setItem('username', response.data.username);
            localStorage.setItem('profile', response.data.profile);
            localStorage.setItem('id', response.data.id);
        },
        removeUserData(state) {
            state.auth.username = null;
            state.auth.token = null;
            state.auth.profile = null;
            state.auth.id = null;
            localStorage.removeItem('access-token');
            localStorage.removeItem('username');
            localStorage.removeItem('profile');
            localStorage.removeItem('id');
        }
    }
})
