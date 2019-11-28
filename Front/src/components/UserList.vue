<template>
    <div class="users">
        <div class="header">
            <div class="field">NOME</div>
            <div class="field">LOGIN</div>
            <div class="field">PERFIL</div>
        </div>
        <div class="user-list">
            <div class="user" v-for="user in userList" :key="user.id" @click="openModal(user)">
                <div class="field">
                    {{ user.nome }}
                </div>
                <div class="field">
                    {{ user.login }}
                </div>
                <div class="field">
                    {{ user.perfilUsuario.nome }}
                </div>
            </div>
        </div>
        <modal @modal-closed="closed" :show="modalShow">
            <user-form :user-data="selectedUser" :edit="true" slot="modal-body"></user-form>
        </modal>
    </div>
</template>

<script>
    import Modal from "./Template/Modal";
    import UserForm from "./UserForm";

    export default {
        name: "UserList",
        components: {UserForm, Modal},
        data() {
            return {
                userList: [],
                modalShow: false,
                selectedUser: null
            }
        },
        methods: {
            fetchUsers() {
                this.$http.get('/usuario').then(res => {
                    this.userList = res.data;
                })
            },
            openModal(user) {
                this.modalShow = true;
                this.selectedUser = user;
            },
            closed() {
                this.modalShow = false;
                this.fetchUsers();
            }
        },
        mounted() {
            this.fetchUsers()
        }
    }
</script>

<style scoped>
    .users {
        width: 100%;
        margin: 10px;
        border: #5c636e 1px solid;
        height: fit-content;
    }

    .header {
        background-color: #5c636e;
        padding: 10px;
        color: #fff;
    }

    .user {
        padding: 0 10px;
        height: 50px;
        align-items: center;
        border-bottom: #e6e6e6 1px solid;
        cursor: pointer;
    }

    .user, .header {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
    }
</style>
