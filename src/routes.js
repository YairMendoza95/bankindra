import HomeComponent from './Presentation.vue';
import Login from './auth/Login.vue';

export const routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: Login },
]