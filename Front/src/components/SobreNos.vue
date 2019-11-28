<template>
    <div class="about">
        <b-container>
            <b-row>
                <b-col sm="12">
                    <p class="nome">Jean Markis</p>
                </b-col>
                <b-col sm="12">
                    Atuou majoritariamente no back-end da aplicação, criando a estrutura necessária para a execução dos
                    métodos requisitados.
                </b-col>
            </b-row>
            <b-row style="margin-top: 100px">
                <b-col sm="12">
                    <p class="nome">Pedro Henrique Muro</p>
                </b-col>
                <b-col sm="12">
                    Atuou, na maior parte do tempo, no front-end, mas com participação no sistema de autenticação da API (no fim deu errado :[ )
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: "SobreNos"
    }
</script>

<style scoped>
    .nome{
        font-weight: bold;
        font-size: 20px;
    }
</style>
