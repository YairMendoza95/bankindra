<template>
	<div>
		<navbar :name="name"></navbar>
		<router-view></router-view>
		<footer-page></footer-page>
	</div>
</template>

<script>
import Navbar from './components/layout/Navbar.vue';
import FooterPage from './components/layout/FooterPage.vue';
import { bus } from './main';

export default {
	components:{
		Navbar,
		FooterPage
	},
	data(){
		return {
			name:''
		}
	},
	beforeCreate(){
		bus.$on('componentName', name => {
			this.name = name;
		});
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
