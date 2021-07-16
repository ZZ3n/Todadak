import Login from "@/views/user/Login.vue";
import Register from "@/views/user/Register.vue";
import FindLogin from "@/views/user/FindLogin.vue";

const routes = [
    {
        path: "/user/login",
        ame: "Login",
        component: Login,
    },
    {
        path: "/user/register",
        name: "Register",
        component: Register,
    },
    {
        path: "/user/find",
        name: "FindLogin",
        component: FindLogin,
    },
];

export default routes;
