import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource'
import { routes } from './routes';

Vue.use(VueRouter);
const router = new VueRouter({
    routes: routes,
    mode: 'history'
});

Vue.use(VueResource);
Vue.http.options.root = "http://localhost:8888/api";

new Vue({
    el: '#app',
    router: router,
    render: h => h(App)
});