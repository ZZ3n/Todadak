<template>
    <div class="find-login super-wide">
        <div class="find-login-wrap">
            <div class="find-id-wrap">
                <h2>아이디 찾기</h2>
                <div class="input-wrap">
                    <input type="text" id="find_id" placeholder="이름을 입력해주세요."/>
                </div>
                <div class="btn-zone">
                    <button>아이디 찾기</button>
                </div>
            </div>
            <div class="find-password-wrap">
                <h2>비밀번호 찾기</h2>
                <div class="input-wrap">
                    <input
                        type="text"
                        id="find_password"
                        placeholder="아이디를 입력해주세요."
                    />
                </div>
                <div class="btn-zone">
                    <button>비밀번호 찾기</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "FindLogin",
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
@import "~@/assets/sass/pages/user/find-login.sass";
</style>
