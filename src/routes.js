import HomeComponent from './Presentation.vue';
import Login from './auth/Login.vue';
import Signup from './auth/Signup.vue';

export const routes = [
    { path: '', component: HomeComponent },
    { path: '/login', component: Login },
    { path: '/signup', component: Signup },
]