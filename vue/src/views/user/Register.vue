<template>
    <div class="register super-wide">
        <div class="register-wrap">
            <h2>회원가입</h2>
            <div class="input-wrap">
                <label for="name">이름</label>
                <input type="text" id="name" placeholder="이름을 입력해주세요."/>
            </div>
            <div class="input-wrap">
                <label for="login_id">아이디</label>
                <input type="text" id="login_id" placeholder="아이디를 입력해주세요"/>
            </div>
            <div class="input-wrap">
                <label for="password">비밀번호</label>
                <input
                    type="text"
                    id="password"
                    placeholder="비밀번호를 입력해주세요."
                />
            </div>
            <div class="input-wrap">
                <label for="password_check">비밀번호 확인</label>
                <input
                    type="text"
                    id="password_check"
                    placeholder="비밀번호를 한번 더 입력해주세요."
                />
            </div>
            <div class="btn-zone">
                <button>회원가입</button>
                <a href="" @click.prevent="clickCancel">취소</a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Register",
    mounted() {
        this.handlePage();
    },
    methods: {
        handlePage() {
            this.$store.commit("handlePage");
        },
        clickCancel() {
            window.history.back();
        },
    },
};
</script>

<style lang="scss">
@import "~@/assets/sass/pages/user/register.sass";
</style>
