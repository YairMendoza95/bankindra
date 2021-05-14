<template>
	<nav :class="name!='Presentation'?'nav-solid':'nav-fixed'">
		<div class="logo">
			<router-link to="/" class="navbar-brand">BankIndra</router-link>
		</div>
		<ul>
			<div v-show="this.$session.exists()">
				<router-link to="/aspirantes" tag="li"><a>Aspirante</a></router-link>
				<router-link to="/entrevistador" tag="li"><a>Entrevistador</a></router-link>
				<router-link to="/vacantes" tag="li"><a>Vacantes</a></router-link>
				<li><a href="#" @click="logout">Cerrar sesión</a></li>
			</div>
			<div v-show="!this.$session.exists()">
				<router-link to="/login" tag="li"><a>Iniciar sesión</a></router-link>
				<router-link to="/signup" tag="li"><a>Registrarse</a></router-link>
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
			console.log(this.$session.id);
            let path = this.$route.path;
			console.log(this.name);
			console.log(path);
        }
	},
	created(){
		console.log(this.$session.id);
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
	position: sticky;
	background:#2A628F;
	top: 0;
	left: 0;
	color: #fff;
	width: 100%;
	height: 60px;
	box-sizing: border-box;
	padding: 8px 50px;
}

.nav-fixed .logo{
	float: left;
}

.nav-solid .logo{
	float: left;
}

.navbar-brand{
	color:#2A628F;
	font-size: 25px;
	Font-weight: bold;
	text-decoration: none;
	transition: 0.5s;
}

.nav-solid .logo .navbar-brand{
	color:#FFFFFF;
	font-size: 25px;
	Font-weight: bold;
	text-decoration: none;
	transition: 0.5s;
}

.navbar-brand:hover{
	color: #FFFFFF;
}

.nav-fixed ul div{
	display: flex;
	float: right;
	margin: 0;
	padding: 0;
}
.nav-solid ul div{
	display: flex;
	float: right;
	margin: 0;
	padding: 0;
}
.nav-fixed ul div li{
	list-style: none;
}

.nav-solid ul div li{
	list-style: none;
}

.nav-fixed ul div li a{
	color:#2A628F;
	line-height: 40px;
	padding: 5px 10px;
	transition: 0.5s;
	text-decoration: none;
}

.nav-solid ul div li a{
	color:#FFFFFF;
	line-height: 40px;
	padding: 5px 10px;
	transition: 0.5s;
	text-decoration: none;
}

.nav-fixed ul div li a:hover,
.nav-fixed ul div li a.active{
	color:#FFFFFF;
	background-color: #16324F;
	border: none;
	margin:5px;
	transition: 0.2s;
}

.nav-solid ul div li a:hover,
.nav-solid ul div li a.active{
	color:#16324F;
	background-color: #FFFFFF;
	border: none;
	margin:5px;
	transition: 0.2s;
}
</style>
