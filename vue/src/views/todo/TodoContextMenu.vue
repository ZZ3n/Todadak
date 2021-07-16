<template>
    <ul id="todo-context-menu" v-if="todoLength > 0">
        <li class="todo-context-menu-item" @click="handleStar">
            <template v-if="todo.todo.star == false">
                <font-awesome-icon :icon="['far', 'star']"/>
                중요로 표시
            </template>
            <template v-else>
                <font-awesome-icon :icon="['fas', 'star-of-life']"/>
                중요도 제거
            </template>
        </li>
        <li class="todo-context-menu-item" @click="deleteTodo">
            <font-awesome-icon icon="times"/>
            삭제
        </li>
        <li class="todo-context-menu-item" @click="handleComplete">
            <template v-if="todo.todo.status != 'complete'">
                <font-awesome-icon :icon="['far', 'circle']"/>
                완료로 표시
            </template>
            <template v-else>
                <font-awesome-icon :icon="['far', 'times-circle']"/>
                완료되지 않음으로 표시
            </template>
        </li>
    </ul>
</template>

<script>
export default {
    name: "TodoContextMenu",
    props: {
        todoIndex: Number,
    },
    computed: {
        todoLength() {
            return this.$store.state.todoStore.todoList.length;
        },
        todo() {
            return this.$store.state.todoStore.todoList[this.todoIndex];
        },
        page() {
            return this.$store.state.todoStore.page;
        },
    },
    methods: {
        handleStar() {
            var index = this.todoIndex;
            this.$store.commit("toggleStar", {index});
        },
        hideShow() {
            this.$store.state.todoStore.show = false;
            if (this.page == "todo") {
                document.querySelector(".todo").classList.add("super-wide");
            } else if (this.page == "kanban") {
                document.querySelector(".board").classList.add("super-wide");
            }
        },
        deleteTodo() {
            var index = this.todoIndex;
            this.$store.commit("deleteTodo", {index});
            this.hideShow();
        },
        handleComplete() {
            var index = this.todoIndex;

            if (this.todo.todo.todoStore.status == "complete") {
                this.$store.commit("editTodoStatus", {index: index, status: "open"});
            } else {
                this.$store.commit("editTodoStatus", {
                    index: index,
                    status: "complete",
                });
            }
        },
    },
};
</script>
