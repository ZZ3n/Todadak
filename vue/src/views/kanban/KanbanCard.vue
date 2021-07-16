<template>
    <ul>
        <template v-for="(todo, index) in todoList" :key="todo.id">
            <li
                v-if="todo.todo.status == this.status"
                draggable="true"
                @dragstart="dragStart($event, index)"
                @dragend="dragEnd($event)"
            >
                <div class="todo-title-wrap">
                    <span class="todo-title">{{ todo.todo.text }}</span>
                    <span class="star">
                        <template v-if="todo.todo.star == true">
                                <font-awesome-icon :icon="['fas', 'star']"/>
                        </template>
                        <template v-else>
                            <font-awesome-icon :icon="['far', 'star']"/>
                        </template>
                    </span>
                </div>
                <div class="todo-information">
                    <div class="label-wrap">
                        <span
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
                        </span>
                    </div>
                    <div class="todo-date-wrap">
                        <span class="todo-repeat">{{ todo.todo.repeat }}</span>
                        <span class="todo-date">{{ todo.todo.date }}</span>
                    </div>
                </div>
            </li>
        </template>
    </ul>
</template>

<script>
export default {
    props: {
        status: String,
    },
    computed: {
        todoList() {
            return this.$store.state.todoStore.todoList;
        },
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
        };
    },
    methods: {
        dragStart(event, index) {
            event.dataTransfer.dropEffect = "move";
            event.dataTransfer.effectAllowed = "move";
            event.dataTransfer.setData("itemId", index);
        },
        dragEnd(event) {
            event.target.style.opacity = "";
        },
    },
};
</script>
