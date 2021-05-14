<template>
    <section class="bg">
    </section>
</template>

<script>
import { bus } from '../main';
export default {
    beforeCreate(){
		bus.componentName('Presentation');
	},
    created(){
        if(this.$session.exists()) {
            this.$router.redirect('/user');
        }
    }
}
</script>

<style scoped>
.bg{
    width: 100%;
    height: 100vh;
    background: url('../assets/images/bg2.jpg');
}
</style>
