<template>
    <div class="login">
        <b-container>
            <b-card id="card">
                <b-card-header id="card-header">
                    <h1>Login</h1>
                </b-card-header>
                <b-card-body>
                    <b-row>
                        <b-col class="login-col" sm="12">
                            <span>Usuario:</span>
                            <input v-model="userLogin" class="login_input" type="text">
                        </b-col>
                        <b-col class="login-col" md="12">
                            <span>Senha:</span>
                            <input v-model="userPass" class="login_input" type="text">
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-col class="login-col" sm="12">
                            <div @click="doLogin" class="btn-login">Login</div>
                        </b-col>
                    </b-row>
                </b-card-body>
            </b-card>
        </b-container>
        <modal :show="modalShow" @modal-closed="modalShow = false"></modal>
    </div>
</template>

<script>
    import Modal from "./Template/Modal";
    import {mapActions} from "vuex";

    export default {
        name: "Login",
        components: {Modal},
        data() {
            return {
                modalShow: false,
                userLogin: 'Pedro',
                userPass: 'senhaTeste'
            }
        },
        methods: {
            ...mapActions(['login']),
            doLogin() {
                this.login({login: this.userLogin, password: this.userPass}).then(() => {
                    this.$router.push({
                        path: '/admin'
                    })
                })
            }
        }
    }
</script>

<style scoped>

    .login_input {
        width: 50%;
    }

    .login-col {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        margin-top: 20px;
    }

    .btn-login {
        width: 200px;
        height: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #f8b500;
        border-radius: 100px;
        border: #393e46 solid 1px;
        cursor: pointer;
    }

    input {
        height: 40px;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 20px;
        border: #393e46 solid 1px;
        outline: none;
        padding: 0 15px;
    }

    .btn-login:hover {

    }

    #card {
        box-shadow: 2px 3px 11px 1px #bebebe4f;
    }

    #card-header {
        display: flex;
        justify-content: center;
    }

</style>
