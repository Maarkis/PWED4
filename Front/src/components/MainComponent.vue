<template>
    <div class="container main-component">
        <navbar/>
        <router-view/>
    </div>
</template>

<script>
    import Navbar from "./Navbar";

    export default {
        name: "MainComponent",
        components: {Navbar}
    }
</script>

<style scoped>


    .main-component {
        /*background: rgb(233, 233, 233);*/
        /*background: radial-gradient(circle, rgba(233, 233, 233, 1) 34%, rgba(190, 190, 190, 1) 100%);*/
        /*height: 100vh;*/
        /*display: flex;*/
        margin-top: 150px;
        font-family: 'Montserrat', sans-serif;
        user-select: none;
        color: #393e46;
    }
</style>
