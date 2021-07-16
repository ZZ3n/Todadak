<template>
    <div class="board super-wide">
        <to-do></to-do>
        <ongoing/>
        <testing></testing>
        <done></done>
    </div>
</template>

<script>
import ToDo from "@/views/kanban/ToDo.vue";
import Ongoing from "@/views/kanban/Ongoing.vue";
import Testing from "@/views/kanban/Testing.vue";
import Done from "@/views/kanban/Done.vue";

export default {
    name: "KanbanBoard",
    components: {
        ToDo,
        Ongoing,
        Testing,
        Done,
    },
};
</script>
