<template>
    <div class="todo-input">
        <div class="input-wrap">
            <input
                type="text"
                placeholder="할일을 적어주세요"
                v-model="todo.text"
                @keyup.enter="addTodo"
            />
        </div>
        <div class="btn-wrap">
            <button type="button" @click="addTodo">추가</button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            todo: {
                text: "",
                status: "Todo",
                label: [],
                star: false,
                repeat: "",
                date: "",
            },
        };
    },
    computed: {
        id() {
            return this.$store.state.todoStore.id;
        },
    },
    methods: {
        addTodo() {
            this.$store.commit("addTodo", {todo: this.todo});
            this.todo = {
                text: "",
                status: "Todo",
                label: [],
                star: false,
                repeat: "",
                date: "",
            };
        },
    },
};
</script>
