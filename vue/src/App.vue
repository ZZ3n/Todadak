<template>
    <headers></headers>
    <main @click="handleContentClose">
        <left-aside></left-aside>
        <router-view></router-view>
    </main>
</template>

<script>
import Headers from "./components/layouts/Header.vue";
import LeftAside from "./components/layouts/navigation/LeftAside.vue";

export default {
    name: "Main",
    components: {
        Headers,
        LeftAside,
    },
    methods: {
        handleContentClose() {
            var contextMenu = document.getElementById("todo-context-menu");
            var labelSelect = document.querySelector(".label-select");
            var repeatSelect = document.querySelector(".repeat-select");

            if (contextMenu) {
                contextMenu.classList.remove("context-active");
            }

            if (labelSelect) {
                labelSelect.classList.remove("active");
            }

            if (repeatSelect) {
                repeatSelect.classList.remove("active");
            }
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/index.sass";
</style>
