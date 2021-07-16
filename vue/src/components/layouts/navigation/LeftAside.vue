<template>
    <aside class="left-aside">
        <a href="" class="back" @click.prevent="hideShow">
            <span class="chevron"></span>
        </a>
        <ul>
            <li>
                <div class="icon">
                    <font-awesome-icon icon="chalkboard" />
                </div>
                <router-link to="/kanban">Kanban</router-link>
            </li>
            <li>
                <div class="icon">
                    <font-awesome-icon icon="clipboard-check" />
                </div>
                <router-link to="/todo">Todo List</router-link>
            </li>
        </ul>
        <div class="login-menu">
            <router-link to="/login">로그인</router-link>
        </div>
    </aside>
</template>

<script>
export default {
    name: "LeftAside",
    computed: {
        page() {
            return this.$store.state.todoStore.page;
        },
    },
    methods: {
        hideShow() {
            document.querySelector(".left-aside").classList.toggle("hide");
            if (this.page == "todo") {
                document.querySelector(".todo").classList.toggle("wide");
            } else if (this.page == "kanban") {
                document.querySelector(".board").classList.toggle("wide");
            } else if (this.page == "login") {
                document.querySelector(".login").classList.toggle("wide");
            } else if (this.page == "register") {
                document.querySelector(".register").classList.toggle("wide");
            } else if (this.page == "find") {
                document.querySelector(".find-login").classList.toggle("wide");
            }
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/layouts/navigation/left-aside.sass";
</style>
