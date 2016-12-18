export default [{
  path: '/roles',
  name: 'roles',
  component(resolve) {
    require(['../../views/roles/roleIndex.vue'], resolve)
  }
}, {
  path: '/menus',
  name: 'menus',
  component(resolve) {
    require(['../../views/menus/menuIndex.vue'], resolve)
  }
}, {
  path: '/permissions',
  name: 'permissions',
  component(resolve) {
    require(['../../views/permissions/permitsIndex.vue'], resolve)
  }
}]
