<template>
    <kanban-board></kanban-board>
</template>

<script>
import KanbanBoard from "@/views/kanban/KanbanBoard.vue";

export default {
    name: "Kanban",
    mounted() {
        this.handlePage();
    },
    components: {
        KanbanBoard,
    },
    methods: {
        handlePage() {
            this.$store.commit("handlePage");
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/pages/kanban/kanban.sass";
</style>
