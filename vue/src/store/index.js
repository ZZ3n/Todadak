import {createStore} from "vuex";
import {todoStore} from "@/store/modules/todoStore.js";
import {userStore} from "@/store/modules/userStore.js";

export default createStore({
    modules: {todoStore, userStore},
});
