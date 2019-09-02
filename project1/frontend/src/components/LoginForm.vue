<template>
    <form v-on:submit.prevent="submitForm">
        <div>
            <label for="uid"><b>User ID </b></label>&nbsp;&nbsp;
            <input id="uid" type="text" v-model="uid">
        </div>
        <div>
            <label for="password"><b>Password </b></label>
            <input id="password" type="password" v-model="password">
        </div>
        <button type="submit">Login</button>
    </form>
</template>

<script>
    import axios from 'axios'
    export default {
        data() {
           return {
               uid: '',
               password: '',
               status: ''
           } 
        },
        methods: {
            submitForm(event) {
                var user = {
                    uid: this.uid,
                    password: this.password,
                };

                axios({
                    method: 'post',
                    url: '/login',
                    data: user
                }).then(result => {
                    this.status = result.data;
                }).catch(error => {
                    this.status = error.response.data;
                }).finally(()=> {
                    console.log(this.status);
                    this.$emit('sendStatus',{
                        userid: this.uid,
                        status: this.status
                    });
                });

            }
        }
    }
</script>

<style scoped>

</style>

