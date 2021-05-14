<template>
	<nav :class="name!='Presentation'?'nav-solid':'nav-fixed'">
		<div class="logo">
			<router-link to="/" class="navbar-brand">BankIndra</router-link>
		</div>
		<ul>
			<div v-show="this.$session.exists()">
				<li><a href="">Aspirante</a></li>
				<li><a href="">Entrevistador</a></li>
				<li><a href="">Vacantes</a></li>
				<li><a @click="logout" href="">Cerrar sesión</a></li>
			</div>
			<div v-show="!this.$session.exists()">
				<router-link to="/login" tag="li"><a>Iniciar sesión</a></router-link>
				<router-link to="/signup" tag="li"><a href="#">Registrarse</a></router-link>
			</div>
		</ul>
	</nav>
</template>

<script>
export default {
	props:['name'],
	methods:{
		logout(){
			if (this.$session.exists()) {
				this.$session.destroy();
				this.$router.push('/');
			}
		}
	},
	watch: {
        $route(){
            let path = this.$route.path;
			console.log(this.name);
			console.log(path);
        }
	}
}
</script>

<style scoped>
.nav-fixed{
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100px;
	padding: 10px 50px;
	box-sizing: border-box;
	transition: 0.5s;
}
.nav-solid{
	background:#2A628F;
	color: #fff;
	width: 100%;
	height: 100px;
	padding: 10px 50px;
}
nav .logo{
	float: left;
}
.navbar-brand{
	color:#2A628F;
	font-size: 25px;
	Font-weight: bold;
	text-decoration: none;
	transition: 0.5s;
}

.navbar-brand:hover{
	color: #FFFFFF;
}

nav ul{
	display: flex;
	float: right;
	margin: 0;
	padding: 0;
}

nav ul li{
	list-style: none;
}

nav ul li a{
	color:#2A628F;
	line-height: 40px;
	padding: 5px 10px;
	transition: 0.5s;
	text-decoration: none;
}

nav ul li a:hover,
nav ul li a.active{
	color:#FFFFFF;
	background-color: #16324F;
	border: none;
	margin:5px;
	transition: 0.2s;
}
</style>
