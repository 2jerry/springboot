<template>
    <div id="success" v-if="getLoginResult.status === 'Login Success'">
        {{ getLoginResult.status }} <br> Hello {{ getLoginResult.userid }}
    </div>
    <div id="failed" v-else>{{ getLoginResult.status }}</div>
</template>

<script>
    export default {
        props: ['getLoginResult'],
    }
</script>

<style scoped>
#success {
    color: green;
}

#failed {
    color: red;
}

</style>