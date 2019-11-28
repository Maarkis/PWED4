<template>
    <div class="admin">
        <div class="menu">
            <div @click="selected = 'listar'" class="option">Listar Usuários</div>
            <div @click="selected = 'cadastrar'" class="option">Cadastrar Usuário</div>
        </div>
        <div class="action">
            <user-list v-if="selected === 'listar'"></user-list>
            <user-form v-if="selected === 'cadastrar'"></user-form>
        </div>
    </div>
</template>

<script>
    import UserList from "./UserList";
    import UserForm from "./UserForm";
    import {mapGetters} from "vuex";

    export default {
        name: "Admin",
        data() {
            return {
                selected: 'listar',
            }
        },
        components: {UserForm, UserList},
        computed: {
            ...mapGetters(['getProfile'])
        },
        beforeRouteEnter(to, from, next) {
            let profile = localStorage.getItem('profile');
            if (!profile || profile !== 'Administrador') {
                alert('Acesso negado!');
            } else {
                next(true);
            }
        }
    }
</script>

<style scoped>
    .admin {
        box-shadow: 2px 3px 11px 1px #bebebe4f;
        display: grid;
        grid-template-columns: 1fr 4fr;
    }

    .action {
        display: flex;
        justify-content: center;
        box-sizing: border-box;
        height: 80vh;
        overflow-y: scroll;
    }

    .menu {
        background-color: #f7f7f7;
    }

    .option {
        height: 50px;
        display: flex;
        justify-content: flex-start;
        align-items: center;
        padding: 0 10px;
    }

    .option:hover {
        background-color: rgba(255, 185, 0, 0.52);
        color: #5c636e;
        transition: background-color 100ms cubic-bezier(0.675, 0.465, 0.520, 0.635);
    }
</style>
