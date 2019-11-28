<template>
    <div class="navbar">
        <div class="navbar-item">
            <router-link tag="div" exact-active-class="active" to="/admin">
                <div class="link">
                    Administrativo
                </div>
            </router-link>
        </div>
        <div class="navbar-item">
            <router-link tag="div" exact-active-class="active" to="/vendas">
                <div class="link">
                    Vendas
                </div>
            </router-link>
        </div>
        <div class="navbar-item">
            <router-link tag="div" exact-active-class="active" to="/credits">
                <div class="link">
                    Sobre nós
                </div>
            </router-link>
        </div>
        <div class="user-info">
            <router-link v-if="isAuthenticated" tag="div" exact-active-class="active" to="/">
                <div class="login-link">
                    Login
                </div>
            </router-link>
            <div @click="showOptions = !showOptions" v-else class="user-name">
                <p>{{getUsername}}</p>
                <div class="user-options" v-if="showOptions">
                    <div class="option" @click="doLogout">Logout</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from "vuex";

    export default {
        name: "Navbar",
        data() {
            return {
                showOptions: false
            }
        },
        computed: {
            ...mapGetters(['getUsername', 'isAuthenticated'])
        },
        methods: {
            ...mapActions(['logout']),
            doLogout() {
                this.logout();
                this.$router.push('/')
            }
        }
    }
</script>

<style scoped>
    .navbar {
        display: flex;
        position: fixed;
        top: 0;
        left: 0;
        box-shadow: -1px -1px 11px 1px #bebebe;
        width: 100%;
        margin: 0;
        background-color: #f7f7f7;
        justify-content: center;
        align-items: center;
        z-index: 1000;
    }

    .navbar .navbar-item > div {
        border: #7e7e7e 1px solid;
        padding: 10px;
        width: 150px;
        margin: 5px 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 6px;
        cursor: pointer;
        background-color: #5c636e;
        color: #fff;
    }

    .navbar .navbar-item > div:hover {
        background-color: rgba(255, 185, 0, 0.52);
        color: #5c636e;
        transition: background-color 100ms cubic-bezier(0.675, 0.465, 0.520, 0.635);
    }

    .navbar .navbar-item > .active {
        background-color: #f8b500;
        color: #5c636e;
    }

    p {
        padding: 0 !important;
        display: flex;
        align-items: center;
        margin: 0;
    }

    .user-info {
        position: absolute;
        right: 75px;
    }

    .user-options {
        background-color: #fff;
        position: absolute;
        box-shadow: 2px 3px 11px 1px rgba(134, 134, 134, 0.31);
    }

    .option {
        padding: 15px;
        cursor: pointer;
    }

    .option:hover {
        background-color: #f8b500;
    }

    .login-link {
        border: #7e7e7e 1px solid;
        border-radius: 6px;
        padding: 10px;
        cursor: pointer;
    }

    .login-link:hover {
        background-color: rgba(255, 185, 0, 0.52);
        color: #5c636e;
        transition: background-color 100ms cubic-bezier(0.675, 0.465, 0.520, 0.635);
    }
</style>
