<template>
    <section
        class="testing board-common"
        @drop="onDrop($event)"
        @dragover.prevent
        @dragenter.prevent="dragEnter($event)"
        @dragleave="dragLeave($event)"
    >
        <h2>Testing</h2>
        <kanban-card :status="'Testing'"></kanban-card>
    </section>
</template>

<script>
import KanbanCard from "@/views/kanban/KanbanCard.vue";

export default {
    components: {
        KanbanCard,
    },
    methods: {
        dragEnter(event) {
            event.target.style.opacity = 0.7;
        },
        dragLeave(event) {
            event.target.style.opacity = 1;
        },
        onDrop(event) {
            event.preventDefault();
            event.target.style.opacity = 1;
            const itemId = event.dataTransfer.getData("itemId");
            this.$store.commit("editTodoStatus", {
                index: itemId,
                status: "Testing",
            });
        },
    },
};
</script>
