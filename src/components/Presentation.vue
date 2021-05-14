<template>
    <section class="bg">
    </section>
</template>

<script>
import { bus } from '../main';
export default {
    beforeCreate(){
		bus.componentName('Presentation');
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
