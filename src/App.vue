<template>
	<div>
		<navbar></navbar>
		<login></login>
	</div>
</template>

<script>
import Navbar from './layout/Navbar.vue';
import Presentation from './Presentation.vue';
import Login from './auth/Login';	

export default {
	components:{
		Navbar,
		Presentation,
		Login,
	}
}
</script>

<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

body {
	font-family: sans-serif;
	background: #f1f1f1;
}
</style>
