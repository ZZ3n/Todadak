<template>
    <aside class="right-aside">
        <div class="input-wrap">
            <input type="text" class="todo-text" v-model="todo.todo.text" />
        </div>

        <div class="input-wrap">
            <font-awesome-icon icon="tag" />
            <div @click.stop="selectLabelActive" class="label">
                <p v-if="todo.todo.label.length == 0" style="font-size: 16px">
                    라벨 선택(최대 6개)
                </p>
                <p
                    v-for="(tag, index) in todo.todo.label"
                    :key="tag.id"
                    :id="'tag' + index"
                    :style="
                        'color:' +
                        color[index] +
                        ';' +
                        'background-color:' +
                        backgroundColor[index] +
                        ';'
                    "
                >
                    {{ tag }}
                </p>
            </div>

            <!-- context menu -->
            <ul class="label-select">
                <li class="label-select-option" @click="selectLabelOption('공부')">
                    공부
                </li>
                <li class="label-select-option" @click="selectLabelOption('운동')">
                    운동
                </li>
                <li class="label-select-option" @click="selectLabelOption('식사')">
                    식사
                </li>
                <li class="label-select-option" @click="selectLabelOption('약속')">
                    약속
                </li>
                <li>
                    <input
                        type="text"
                        class="label-input"
                        id="label_input"
                        name="label_input"
                        placeholder="추가할 라벨을 작성해 주세요."
                        @click.stop
                        @keyup.enter="selectLabelOption(tagInput)"
                        v-model="tagInput"
                    />
                </li>
            </ul>
        </div>

        <div class="input-wrap">
            <font-awesome-icon icon="redo" />
            <div class="repeat" @click.stop="selectRepeatActive">
                <p v-if="!todo.todo.repeat">반복</p>
                <p v-else>{{ todo.todo.repeat }}</p>
            </div>
            <!-- context menu -->
            <ul class="repeat-select">
                <li class="repeat-select-option" @click="selectRepeatOption('매일')">
                    매일
                </li>
                <li class="repeat-select-option" @click="selectRepeatOption('매주')">
                    매주
                </li>
                <li class="repeat-select-option" @click="selectRepeatOption('매달')">
                    매달
                </li>
            </ul>
        </div>

        <div class="input-wrap">
            <font-awesome-icon icon="calendar-alt" />
            <input type="date" v-model="todo.todo.date" />
        </div>

        <div class="btn-wrap">
            <a href="" class="hide-button" @click.prevent="hideShow">
                <span class="chevron"></span>
            </a>

            <a href="" class="delete-button" @click.prevent="deleteTodo">
                <font-awesome-icon :icon="['far', 'trash-alt']" />
            </a>
        </div>
    </aside>
</template>

<script>
export default {
    data() {
        return {
            tagInput: "",
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
    computed: {
        todo() {
            return this.$store.state.todoStore.todoList[
                this.$store.state.todoStore.index
                ];
        },
        page() {
            return this.$store.state.todoStore.page;
        },
    },
    methods: {
        selectLabelActive() {
            document.querySelector(".label-select").classList.toggle("active");
            document.querySelector(".repeat-select").classList.remove("active");
        },
        selectLabelOption(tag) {
            var flag = 0; //같은게 없을때 0 있을때 1
            var idx = 0;
            document.querySelector(".label-select").classList.remove("active");

            if (this.todo.todo.label.length > 0) {
                this.todo.todo.label.some((item, index) => {
                    if (item != tag) {
                        flag = 0;
                    } else {
                        return [(flag = 1), (idx = index)];
                    }
                });
            }

            if (flag == 0) {
                if (this.todo.todo.label.length >= 6) {
                    this.todo.todo.label.pop();
                }
                this.todo.todo.label.push(tag);
            } else {
                this.todo.todo.label.splice(idx, 1);
            }

            this.tagInput = "";
        },
        selectRepeatActive() {
            document.querySelector(".repeat-select").classList.toggle("active");
            document.querySelector(".label-select").classList.remove("active");
        },
        selectRepeatOption(repeat) {
            document.querySelector(".repeat-select").classList.remove("active");
            this.todo.todo.repeat = repeat;
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
            var index = this.$store.state.todoStore.index;
            this.$store.commit("deleteTodo", { index });
            this.hideShow();
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/layouts/navigation/right-aside.sass";
</style>
