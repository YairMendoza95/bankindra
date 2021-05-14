import HomeComponent from './components/Presentation.vue';
import Login from './components/auth/Login.vue';
import Signup from './components/auth/Signup.vue';
import User from './components/Users.vue';
import Aspirantes from './components/Aspirantes.vue';
import Entrevistador from './components/Entrevistador.vue';
import Vacantes from './components/Vacantes.vue';

export const routes = [
    { path: '', component: HomeComponent },
    { path: '/login', component: Login },
    { path: '/signup', component: Signup },
    { path: '/user', component: User },
    { path: '/vacantes', component: Vacantes },
    { path: '/aspirantes', component: Aspirantes },
    { path: '/entrevistador', component: Entrevistador },
]