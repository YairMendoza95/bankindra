import HomeComponent from './Presentation.vue';
import Login from './auth/Login.vue';
import Signup from './auth/Signup.vue';
import User from './components/Users.vue'

export const routes = [
    { path: '', component: HomeComponent },
    { path: '/login', component: Login },
    { path: '/signup', component: Signup },
    { path: '/user', component: User },
]