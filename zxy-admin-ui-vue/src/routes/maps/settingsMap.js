export default [{
  path: "/dict",
  name: "dict",
  component: function (resolve) {
    require(["../../views/dictionary/dictIndex.vue"], resolve)
  },
}, {
  path: "/dict/category/add",
  component: function (resolve) {
    require(["../../views/dictionary/dictCategoryEdit.vue"], resolve)
  }
}, {
  path: "/dict/category/edit",
  component: function (resolve) {
    require(["../../views/dictionary/dictCategoryEdit.vue"], resolve)
  }
}, {
  path: "/dict/category/delete",
  component(resolve) {

  }
}, {
  path: "/dict/item/add",
  component: function (resolve) {
    require(["../../views/dictionary/dictItemEdit.vue"], resolve)
  }
}, {
  path: "/dict/item/edit",
  component: function (resolve) {
    require(["../../views/dictionary/dictItemEdit.vue"], resolve)
  }
}, {
  path: "/dict/item/delete",
  component(resolve) {

  }
},{
  path: "/countries",
  name: "countries",
  component: function (resolve) {
    require(["../../views/countries/countryIndex.vue"], resolve)
  }
}]
