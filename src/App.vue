<template>
	<div>
		<navbar></navbar>
		<router-view></router-view>
		<footer-page></footer-page>
	</div>
</template>

<script>
import Navbar from './layout/Navbar.vue';
import FooterPage from './layout/FooterPage.vue'

export default {
	components:{
		Navbar,
		FooterPage
	},
	data(){
		return {
			page:''
		}
	},
	mounted(){

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
