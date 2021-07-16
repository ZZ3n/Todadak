<template>
    <div class="todo-list">
        <ul>
            <template v-for="(todo, index) in todoList" :key="index">
                <li
                    v-if="todo.todo.status != 'Done'"
                    @click="handleListIndex(index, $event)"
                    @contextmenu.prevent="handleContextMenu(index, $event)"
                    :class="todo.todo.status == 'Done' ? 'complete' : 'todo-item'"
                >
                    <font-awesome-icon
                        icon="check-circle"
                        v-if="todo.todo.status == 'Done'"
                        @click="handleNotComplete(index)"
                    />
                    <font-awesome-icon
                        :icon="['far', 'circle']"
                        v-else
                        @click="handleComplete(index)"
                    />
                    <p class="todo-text">{{ todo.todo.text }}</p>
                    <p
                        class="todo-label"
                        v-for="(label, index) in todo.todo.label"
                        :key="label.index"
                        :style="
                            'color:' +
                            color[index] +
                            ';' +
                            'background-color:' +
                            backgroundColor[index] +
                            ';'
                        "
                    >
                        {{ label }}
                    </p>
                    <p class="todo-repeat">{{ todo.todo.repeat }}</p>
                    <div class="btn-wrap">
                        <button type="button" @click.stop="handleStar(index)">
                            <template v-if="todo.todo.star == true">
                                <font-awesome-icon :icon="['fas', 'star']"/>
                            </template>
                            <template v-else>
                                <font-awesome-icon :icon="['far', 'star']"/>
                            </template>
                        </button>
                    </div>
                </li>
            </template>
        </ul>

        <h2>완료됨</h2>

        <ul>
            <template v-for="(todo, index) in todoList" :key="index">
                <li
                    v-if="todo.todo.status == 'Done'"
                    @click="handleListIndex(index, $event)"
                    @contextmenu.prevent="handleContextMenu(index, $event)"
                    :class="todo.todo.status == 'Done' ? 'complete' : 'todo-item'"
                >
                    <font-awesome-icon
                        :icon="['far', 'circle']"
                        v-if="todo.todo.status == 'Todo'"
                        @click="handleComplete(index)"
                    />
                    <font-awesome-icon
                        icon="check-circle"
                        v-else
                        @click="handleNotComplete(index)"
                    />
                    <p class="todo-text">{{ todo.todo.text }}</p>
                    <p
                        class="todo-label"
                        v-for="(label, index) in todo.todo.label"
                        :key="label.index"
                        :style="
                            'color:' +
                            color[index] +
                            ';' +
                            'background-color:' +
                            backgroundColor[index] +
                            ';'
                        "
                    >
                        {{ label }}
                    </p>
                    <p class="todo-repeat">{{ todo.todo.repeat }}</p>
                    <div class="btn-wrap">
                        <button type="button" @click.prevent="handleStar(index)">
                            <template v-if="todo.todo.star == true">
                                <font-awesome-icon :icon="['fas', 'star']"/>
                            </template>
                            <template v-else>
                                <font-awesome-icon :icon="['far', 'star']"/>
                            </template>
                        </button>
                    </div>
                </li>
            </template>
        </ul>
    </div>
    <todo-context-menu :todoIndex="index"></todo-context-menu>
</template>

<script>
import TodoContextMenu from "@/views/todo/TodoContextMenu.vue";

export default {
    components: {
        TodoContextMenu,
    },
    data() {
        return {
            color: ["#D01B2A", "#007899", "#257E20", "#7A7400", "#A35A00", "#7D57B2"],
            backgroundColor: [
                "#FCE9EA",
                "#E0F7FD",
                "#E9F9E8",
                "#FFFDE0",
                "#FFF1E0",
                "#F0ECF6",
            ],
            index: 0,
        };
    },
    computed: {
        todoList() {
            return this.$store.state.todoStore.todoList;
        },
    },
    methods: {
        handleListIndex(index, event) {
            this.$store.state.todoStore.index = index;
            this.$store.state.todoStore.show = true;

            document.querySelector(".todo").classList.remove("super-wide");

            document.querySelectorAll(".todo-item, .complete").forEach((e) => {
                e.classList.remove("active");
            });
            event.target.classList.add("active");
        },
        handleComplete(index) {
            this.$store.commit("editTodoStatus", {
                index: index,
                status: "Done",
            });
        },
        handleNotComplete(index) {
            this.$store.commit("editTodoStatus", {index: index, status: "Todo"});
        },
        handleContextMenu(index, event) {
            var contextMenu = document.getElementById("todo-context-menu");

            contextMenu.classList.add("context-active");
            contextMenu.style.top = event.pageY + "px";
            contextMenu.style.left = event.pageX + "px";

            this.index = index;
        },
        handleStar(index) {
            this.$store.commit("toggleStar", {index});
        },
    },
};
</script>
