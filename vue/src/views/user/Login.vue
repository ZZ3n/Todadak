<template>
    <div class="login super-wide">
        <div class="login-wrap">
            <h2>로그인</h2>
            <div class="login-form">
                <div class="input-wrap">
                    <input
                        type="text"
                        id="login_id"
                        placeholder="아이디를 입력해주세요."
                    />
                </div>
                <div class="input-wrap">
                    <input
                        type="password"
                        id="login_pw"
                        placeholder="비밀번호를 입력해주세요."
                    />
                </div>
            </div>
            <div class="btn-zone">
                <button>로그인</button>
            </div>
            <div class="login-menu">
                <router-link to="/user/register">회원가입</router-link>
                <router-link to="/user/find">아이디 찾기/비밀번호 찾기</router-link>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Login",
    mounted() {
        this.handlePage();
    },
    methods: {
        handlePage() {
            this.$store.commit("handlePage");
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/pages/user/login.sass";
</style>
