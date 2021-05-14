<template>
    <div class="container">
        <ul class="list-group">
            <li class="list-group-item" v-for="user in users" :key="user">{{user.username}}</li>
        </ul>
    </div>
</template>

<script>
import { bus } from '../main';
export default {
    data(){
        return{
            users: {}
        }
    },
    beforeCreate(){
        if(!this.$session.exists()) {
            this.$router.push('/');
        }
    },
    created(){
        this.$http.get('auth/users')
            .then(res => res.json())
            .then(resJson => this.users=resJson);
    },
    beforeCreate(){
		bus.componentName('Users');
	}
}
</script>

<style>

</style>
    