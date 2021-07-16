export const todoStore = {
    state: {
        todoList: [],
        index: "",
        show: false,
        page: "kanban",
    },
    mutations: {
        addTodo(state, payload) {
            state.todoList.push(payload);
        },
        deleteTodo(state, payload) {
            state.todoList.splice(payload.index, 1);
        },
        deleteAll(state) {
            state.todoList = [];
        },
        editTodoStatus(state, payload) {
            state.todoList[payload.index].todo.status = payload.status;
        },
        toggleStar(state, payload) {
            state.todoList[payload.index].todo.star = !state.todoList[payload.index]
                .todo.star;
        },
        handlePage(state) {
            var urls = document.location.href.split("/");
            state.page = urls[urls.length - 1];
        },
    },
    actions: {},
    modules: {},
};
