import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../components/Login.vue";
import Home from "../components/Home";
import Welcome from "@/components/Welcome";
import Users from "@/components/superUser/Users";
import EditInformation from "@/components/normalUser/EditInformation";
import CatDocuments from "@/components/normalUser/CatDocuments";
import ModifyBasicInformation from "@/components/manager/ModifyBasicInformation";

Vue.use(VueRouter);

const routes = [
  { path: "/", redirect: "/login" },
  { path: "/login", component: Login },
  {
    path: "/home",
    component: Home,
    redirect: "/welcome",
    children: [
      { path: "/welcome", component: Welcome },
      { path: "/users", component: Users },
      { path: "/editInformation", component: EditInformation },
      { path: "/catDocuments", component: CatDocuments },
      { path: "/modifyBasicInformation", component: ModifyBasicInformation },
    ],
  },
];

const router = new VueRouter({
  routes,
});
router.beforeEach((to, from, next) => {
  //  to表示将要访问的路径
  //  from表示从那个路出发
  //   next()表示放行
  if (to.path === "/login") return next();
  const tokenStr = window.sessionStorage.getItem("token");
  if (!tokenStr) return next("/login");
  next();
});

export default router;
