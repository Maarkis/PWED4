<template>
    <div class="nova-venda">
        <div class="lista-produtos">
            <div class="header">
                <div>Selecionar</div>
                <div>Nome</div>
                <div>Preco</div>
            </div>
            <div class="produto" v-for="produto in produtosDisponiveis" :key="produto.idProduto">
                <div class="check"><input @click="addProduto(produto)" type="checkbox"></div>
                <div class="nome">{{produto.nome}}</div>
                <div class="preco">{{produto.preco | currency}}</div>
            </div>
        </div>
        <div class="valor-total">Valor total: {{ valorTotal }}</div>
        <div @click="finalizarVenda" class="venda-btn">Finalizar venda</div>
    </div>
</template>

<script>
    import {mapGetters} from "vuex";

    export default {
        name: "NovaVenda",
        data() {
            return {
                produtosDisponiveis: [],
                produtosSelecionados: []
            }
        },
        methods: {
            fetchProdutos() {
                this.$http('/produto').then(res => {
                    this.produtosDisponiveis = res.data;
                })
            },
            addProduto(produto) {
                if (this.produtosSelecionados.includes(produto)) {
                    let index = this.produtosSelecionados.indexOf(produto);
                    this.produtosSelecionados.splice(index, 1);
                } else
                    this.produtosSelecionados.push(produto);
            },
            finalizarVenda() {
                this.$http.post('/venda', {
                    usuario: {
                        idUsuario: localStorage.getItem('id'),
                    },
                    produtos: this.produtosSelecionados
                }).then(() => {
                    this.$emit('modal-closed');
                })
            }
        },
        mounted() {
            this.fetchProdutos()
        },
        filters: {
            currency(float) {
                return Number.parseFloat(Number.parseFloat(float).toFixed(2)).toLocaleString()
            }
        },
        computed: {
            valorTotal() {
                return this.produtosSelecionados.reduce((acc, act) => acc + act.preco, 0)
            },
            ...mapGetters(['getId'])
        }
    }
</script>

<style scoped>

    .lista-produtos {
        width: 100%;
    }

    .header {
        background-color: #5c636e;
        color: #fff;
    }

    .header > div, .preco, .nome, .check {
        display: flex;
        justify-content: center;
        padding: 10px;
    }

    .produto, .header {
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        padding: 0 10px;

    }

    .venda-btn {
        background-color: orange;
        width: 50%;
        padding: 10px;
        margin-top: 10px;
        display: flex;
        justify-content: center;
        cursor: pointer;
    }

    .nova-venda {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

</style>
