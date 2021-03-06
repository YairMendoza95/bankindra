import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource'
import VueSession from 'vue-session';
import { routes } from './routes';

export const bus = new Vue({
    methods: {
        componentName(name) {
            this.$emit('componentName', name);
        }
    }
});

Vue.use(VueRouter);
const router = new VueRouter({
    routes: routes,
    mode: 'history'
});

Vue.use(VueResource);
Vue.http.options.root = "http://localhost:8888/api";

Vue.use(VueSession);

new Vue({
    el: '#app',
    router: router,
    render: h => h(App)
});