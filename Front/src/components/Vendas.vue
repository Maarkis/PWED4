<template>
    <div class="vendas">
        <b-container>
            <b-row class="buttons-row">
                <b-col sm="12" md="12">
                    <div @click="novaVenda" class="button">Nova Venda</div>
                </b-col>
            </b-row>
            <b-row>
                <div class="vendas-list">
                    <div class="venda-header">
                        <div class="venda-header-item">Vendedor</div>
                        <div class="venda-header-item">Valor Total</div>
                        <div class="venda-header-item">Data da venda</div>
                    </div>
                    <div class="venda-item" v-for="v in vendas" :key="v.idVenda">
                        <div class="venda-section">
                            {{ v.usuario.nome }}
                        </div>
                        <div class="venda-section">
                            {{ v | valorTotal }}
                        </div>
                        <div class="venda-section">
                            {{ v.dataVenda | date | formattedDate }}
                        </div>
                    </div>
                </div>
            </b-row>
        </b-container>
        <modal :show="showModal" @modal-closed="closeModal">
            <nova-venda slot="modal-body"></nova-venda>
        </modal>
    </div>
</template>

<script>
    import Modal from "./Template/Modal";
    import NovaVenda from "./NovaVenda";

    export default {
        name: "Vendas",
        components: {NovaVenda, Modal},
        data() {
            return {
                vendas: [],
                showModal: false
            }
        },
        methods: {
            fetchVendas() {
                this.$http('/venda').then(res => {
                    this.vendas = res.data;
                })
            },
            novaVenda() {
                this.showModal = true;
            },
            closeModal() {
                this.showModal = false;
                this.fetchVendas();
            }
        },
        filters: {
            valorTotal(obj) {
                return obj.produtos.reduce((acc, act) => acc + act.preco, 0)
            },
            date(timestamp) {
                if (timestamp) {
                    let time = timestamp.split('T')[0];
                    let arr = time.split('-');
                    return new Date(arr[0], arr[1] - 1, arr[2]);
                }
            },
            formattedDate(dateObj) {
                if (dateObj)
                    return `${dateObj.getDate()}/${dateObj.getMonth() + 1}/${dateObj.getFullYear()}`;
            }
        },
        beforeRouteEnter(to, from, next) {
            let profile = localStorage.getItem('profile');
            if (!profile || (profile !== 'Administrador' && profile !== 'Vendedor')) {
                alert('Acesso negado!');
            } else {
                next(true);
            }
        },
        mounted() {
            this.fetchVendas()
        }
    }
</script>

<style scoped>

    .vendas {
        box-shadow: -1px -1px 11px 1px #bebebe;
        padding: 20px;
    }

    .button {
        background-color: #ffb000;
        width: 30%;
        padding: 10px 0;
        display: flex;
        justify-content: center;
        align-items: center;
        border: #4e555b 1px solid;
        height: 40px;
        border-radius: 20px;
    }

    [class^="col"] {
        display: flex;
        justify-content: center;
    }

    .venda-header {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        width: 100%;
        background-color: #f7f7f7;
        padding: 10px 0;
    }

    .venda-header > :first-child {
        border: none;
    }

    .venda-header-item {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        border-left: #ccc 1px solid;
        /*border-right: #ccc 1px solid;*/
    }

    .vendas-list {
        width: 100%;
        margin-top: 20px;
    }

    .venda-item {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        width: 100%;
        padding: 10px 0;
    }

    .venda-item > :last-child {
        cursor: pointer;
    }

    .venda-section {
        display: flex;
        width: 100%;
        justify-content: center;
        align-items: center;
    }

    .row {
        width: 100%;
        margin-left: 0;
    }
</style>
