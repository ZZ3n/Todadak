import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import { library } from "@fortawesome/fontawesome-svg-core";
import {
    faClipboardCheck,
    faChalkboard,
    faTag,
    faRedo,
    faCalendarAlt,
    faCheckCircle,
    faTimes,
    faStar as fasStar,
    faStarOfLife,
} from "@fortawesome/free-solid-svg-icons";
import {
    faCircle,
    faStar as farStar,
    faTimesCircle,
    faTrashAlt,
} from "@fortawesome/free-regular-svg-icons";

library.add(
    faClipboardCheck,
    faChalkboard,
    faTag,
    faRedo,
    faCalendarAlt,
    faCircle,
    faCheckCircle,
    fasStar,
    farStar,
    faTimes,
    faStarOfLife,
    faTimesCircle,
    faTrashAlt
);

import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

const app = createApp(App);

app.component("font-awesome-icon", FontAwesomeIcon);

app.use(store).use(router);
app.mount("#app");
