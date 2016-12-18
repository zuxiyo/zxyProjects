export default [{
  path: '/users',
  name: 'users',
  component: function (resolve) {
    require(['../../views/users/userIndex.vue'], resolve)
  },
  /*components: {
    //命名视图
    main: function (resolve) {
      require(['../../components/firstcomponent.vue'], resolve)
    }
  },*/
  children: [{
    path: '/add',
    name: 'add',
    component: function (resolve) {
      require(['../../views/dictionary/dictCategoryEdit.vue'], resolve)
    }
  }, {
    path: '/edit',
    component(resolve) {
    }
  }, {
    path: '/delete',
    component(resolve) {
      require(['../../views/depts/deptIndex.vue'], resolve)
    }
  }]
}, {
  path: '/depts',
  name: 'depts',
  component(resolve) {
    require(['../../views/depts/deptIndex.vue'], resolve)
  }
}, {
  path: '/orgs',
  name: 'orgs',
  component(resolve) {
    require(['../../views/orgs/orgIndex.vue'], resolve)
  }
}]
