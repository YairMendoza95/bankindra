<template>
	<nav class="nav-fixed">
		<div class="logo">
			<a href="#" class="navbar-brand">BankIndra</a>
		</div>
		<ul>
			<li><a href="">Aspirante</a></li>
			<li><a href="">Entrevistador</a></li>
			<li><a href="">Vacantes</a></li>
			<li><a href="#" data-bs-toggle="modal" data-bs-target="#modalAuth">Iniciar sesión</a>&nbsp; / &nbsp; </li>
			<li><a href="#">Registrarse</a></li>
		</ul>
	</nav>
</template>

<script>

export default {
	props:['home']
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
	position: absolute;
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
