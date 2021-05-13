<template>
	<div class="row justify-content-center">
		<div class="col-4">
			<section class="container">
				<h2 class="text-center">Inicio de sesión</h2>
				<div>
					<div class="form-group-custom field">
						<input type="text" id="username" name="username" placeholder=" " class="form-control-custom" v-model="user.username">
						<label for="username" class="form-label">Nombre de usuario</label>
					</div>
					<div class="form-group-custom field">
						<input type="password" id="password" name="password" class="form-control-custom" placeholder=" " v-model="user.password">
						<label for="password" class="form-label">Contraseña</label>
					</div>
					<div class="form-group">
						<div class="row justify-content-center">
							<button class="btn col-4" type="submit" @click="login"><i class="fas fa-sign-in-alt"></i> Enviar</button>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</template>

<script>
export default {
	data(){
		return{
			user: {
				username:'',
				password:''
			}
		}
	},
	methods:{
		login(){
			this.$http.post('auth/login', this.user)
			.then(res => {
				if(res.status == 200){
					this.$session.start();
					this.$router.push('/user');
				}
			}).catch(console.log);
		}
	}
}
</script>

<style scoped>
.container{
	border:1px solid black;	
	border-radius: 0.5rem;
	padding: 2rem;
}
.form-group-custom { 	
	margin-top: 10px;
	padding: 15px 0 0;
	position: relative;
	width: 100%;
}

.form-label{
	color:#3E92CC;
	display: block;
	font-size: 1rem;
	position: absolute;
	top: 0;
	transform: 0.2s;
}

.form-control-custom{
	background:transparent;
	border: 0;
	border-bottom: 2px solid #3E92CC;
	font-family: inherit;
	font-size: 1rem;
	outline: 0;
	padding:7px 0;
	transition: border-color 0.2s;
	width: 100%;
}

.form-control-custom:placeholder{
	color:transparent;
}

.form-control-custom:placeholder-shown ~ .form-label{
	font-size: 1rem;
	cursor: text;
	color:#3E92CC;
	top: 20px;
}

.form-control-custom:focus{
	padding-bottom:6px;
	font-weight: 70;
	border-width: 3px;
	border-image:linear-gradient(to right, #3E92CC,#16324F);
	border-image-slice: 1;
}

.form-control-custom:focus~.form-label{
	position:absolute;
	top:0;
	display:block;
	transition:0.2s;
	font-size: 1rem;
	font-weight: 70;
}

.form-control-custom:required, .form-control-custom:invalid{
	box-shadow: none;
}

.btn{
	margin-top:1.3rem;
	padding:10px 10px;
	background-color:#16324F;
	color:white;
}
</style>
