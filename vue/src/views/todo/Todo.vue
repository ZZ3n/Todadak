<template>
    <div class="todo super-wide">
        <todo-input></todo-input>
        <todo-list></todo-list>
        <todo-clear></todo-clear>
    </div>
    <right-aside v-if="show"></right-aside>
</template>

<script>
import TodoList from "@/views/todo/TodoList.vue";
import TodoInput from "@/views/todo/TodoInput.vue";
import TodoClear from "@/views/todo/TodoClear.vue";
import RightAside from "@/components/layouts/navigation/RightAside";

export default {
    name: "Todo",
    components: {
        TodoInput,
        TodoList,
        TodoClear,
        RightAside,
    },
    mounted() {
        this.handlePage();
    },
    computed: {
        show() {
            return this.$store.state.todoStore.show;
        },
    },
    methods: {
        handlePage() {
            this.$store.commit("handlePage");
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/pages/todo/todo.sass";
</style>
