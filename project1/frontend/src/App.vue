<!-- App component-->
<template>
  <div id="app" align="center">
    <h1>Login Page</h1>
    <login-form v-on:sendStatus="sendStatus"></login-form>
    <hr style="width:300px" />
    <status-message v-bind:getLoginResult="message"></status-message>
  </div>
</template>

<script>
import LoginForm from "./components/LoginForm";
import StatusMessage from "./components/StatusMessage";

export default {
  name: "App",
  components: {
    "login-form": LoginForm,
    "status-message": StatusMessage
  },
  data() {
    return {
      message: ""
    };
  },
  methods: {
    sendStatus(value) {
      console.log("[app component data] " + value.status);
      this.message = value;
    }
  }
};
</script>

<style scoped>
</style>


