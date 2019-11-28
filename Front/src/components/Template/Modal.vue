<template>
    <div class="my-modal" v-if="show">
        <div class="my-modal-content">
            <div class="my-modal-close" @click="$emit('modal-closed')">x</div>
            <div class="my-modal-body">
                <slot name="modal-body"></slot>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Modal",
        props: {
            show: {
                required: true,
                type: Boolean
            }
        }
    }
</script>

<style scoped>

    .my-modal {
        position: absolute;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        background-color: rgba(92, 99, 110, 0.29);
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .my-modal-content {
        background-color: #f7f7f7;
        position: absolute;
        top: 100px;
        min-height: 300px;
        min-width: 300px;
        box-shadow: 2px 3px 11px 1px #bebebe4f;
        border-radius: 10px;
    }

    .my-modal-close {
        position: absolute;
        right: 20px;
        top: 10px;
        height: 20px;
    }

    .my-modal-body {
        margin-top: 50px;
        padding: 10px;
    }


</style>
