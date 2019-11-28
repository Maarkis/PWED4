<template>
    <div class="form">
        <b-container>
            <b-card id="card">
                <b-card-header id="card-header">
                    <h1>{{ edit ? 'Editar' : 'Cadastrar'}}</h1>
                </b-card-header>
                <b-card-body>
                    <b-row>
                        <b-col class="form-col" md="6" sm="12">
                            <span>Nome:</span>
                            <input v-model="nome" class="user-input" type="text">
                        </b-col>
                        <b-col class="form-col" md="6" sm="12">
                            <span>Login:</span>
                            <input v-model="login" class="user-input" type="text">
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-col class="form-col" md="6" sm="12">
                            <span>Senha:</span>
                            <input v-model="senha" class="user-input" type="password">
                        </b-col>
                        <b-col class="form-col" md="6" sm="12">
                            <span>Perfil:</span>
                            <div @click="opened = !opened" :class="['profile_input', {opened: opened}]">
                                <div class="default-text">
                                    <p>{{ perfil ? perfil.nome : 'Selecione um perfil...' }}</p>
                                </div>
                                <div class="profiles" v-if="opened">
                                    <div class="profile" v-for="p in perfisUsuario" :key="p.id"
                                         @click="perfil = p"> {{ p.nome }}
                                    </div>
                                </div>
                            </div>
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-col class="form-col" sm="12" style="display: flex; flex-direction: row">
                            <div @click="salvar" class="btn-form">{{ edit ? 'Salvar' : 'Cadastrar'}}</div>
                            <div style="margin-left: 10px" v-if="edit" @click="excluir" class="btn-form">Excluir</div>
                        </b-col>
                    </b-row>
                </b-card-body>
            </b-card>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: "UserForm",
        props: {
            userData: {
                required: false,
                type: Object
            },
            edit: {
                required: false,
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                perfisUsuario: [],
                nome: '',
                login: '',
                senha: '',
                opened: false,
                perfil: null
            }
        },
        methods: {
            getPerfilUsuario() {
                this.$http('/usuario/perfil').then(res => {
                    this.perfisUsuario = res.data
                })
            },
            salvar() {
                if (this.nome && this.login && this.senha && this.perfil) {
                    if (this.edit) {
                        this.editar();
                    } else {
                        this.cadastrar();
                    }
                }
            },
            cadastrar() {
                this.$http.post('/usuario/cadastro', {
                    nome: this.nome,
                    login: this.login,
                    senha: this.senha,
                    perfilUsuario: this.perfil
                }).then(res => {
                    alert(`Usuário ${res.data.nome} cadastrado!`)
                }).catch(() => {
                    alert('O login já está sendo usado!')
                });
            },
            editar() {
                if (this.userData) {
                    this.$http.put('/usuario', {
                        idUsuario: this.userData.idUsuario,
                        nome: this.nome,
                        login: this.login,
                        senha: this.senha,
                        perfilUsuario: this.perfil
                    })
                }
            },
            recoverUserData() {
                if (this.userData) {
                    this.nome = this.userData.nome;
                    this.login = this.userData.login;
                    this.senha = this.userData.senha;
                    this.perfil = this.userData.perfilUsuario;
                }
            },
            excluir() {
                if (this.userData) {
                    this.$http.post('/usuario/excluir', {
                        idUsuario: this.userData.idUsuario
                    }).then(() => {
                        alert('Usuário excluído!')
                    }).catch(() => {
                        alert('Erro ao excluir usuário');
                    })
                }
            }
        },
        mounted() {
            this.getPerfilUsuario();
            this.recoverUserData()
        }
    }
</script>

<style scoped>

    .user-input {
        width: 100%;
        height: 40px;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 20px;
        border: #393e46 solid 1px;
        outline: none;
        padding: 0 15px;
    }

    .profile_input {
        width: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        position: relative;
        border: #393e46 solid 1px;
        border-radius: 20px;
    }

    .default-text {
        height: 40px;
        width: 100%;
        align-items: center;
        display: flex;
        padding: 0 20px;
    }

    .default-text p {
        width: 100%;
        align-items: center;
        margin: 0;
    }

    .profiles {
        position: absolute;
        top: 45px;
        width: 100%;
        z-index: 100;
        background-color: #fff;
        box-shadow: 2px 3px 11px 1px rgba(134, 134, 134, 0.31);
    }

    .profile {
        height: 30px;
        align-items: center;
        display: flex;
        padding: 0 20px;
    }

    .profile:hover {
        background-color: #f8b500;
    }


    .form {
        width: 100%;
    }

    .form-col {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        margin-top: 20px;
        position: relative;
    }

    .btn-form {
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

    }

    .btn-form:hover {

    }

    #card {
        box-shadow: 2px 3px 11px 1px #bebebe4f;
    }

    #card-header {
        display: flex;
        justify-content: center;
    }
</style>
