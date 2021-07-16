<template>
    <div class="todo-clear">
        <div class="btn-wrap">
            <button type="button" @click="clearAll">모두 삭제</button>
        </div>
    </div>
</template>

<script>
export default {
    computed: {
        page() {
            return this.$store.state.todoStore.page;
        },
    },
    methods: {
        hideShow() {
            this.$store.state.todoStore.show = false;
            if (this.page == "todo") {
                document.querySelector(".todo").classList.add("super-wide");
            } else if (this.page == "kanban") {
                document.querySelector(".board").classList.add("super-wide");
            }
        },
        clearAll() {
            this.$store.commit("deleteAll");
            this.hideShow();
        },
    },
};
</script>
