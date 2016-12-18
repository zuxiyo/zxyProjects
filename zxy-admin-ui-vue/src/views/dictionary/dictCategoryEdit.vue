<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/dict' }">数据字典</el-breadcrumb-item>
      <el-breadcrumb-item>{{title}}</el-breadcrumb-item>
    </el-breadcrumb>
    <hr/>
    <div class="small-box">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="排序号">
          <el-input v-model="form.sort" placeholder="请输入排序号"></el-input>
        </el-form-item>
        <el-form-item label="编码">
          <el-input v-model="form.categoryCode" placeholder="请输入种类编号/代码"></el-input>
        </el-form-item>
        <el-form-item label="名称">
          <el-input v-model="form.categoryName" placeholder="请输入种类名称"></el-input>
        </el-form-item>
        <el-form-item label="禁用">
          <input type="checkbox" v-model="form.status" />禁用
          <!-- <el-switch v-model="form.status" on-text="" off-text=""></el-switch>
          <el-checkbox v-model="form.status" checked>禁用</el-checkbox> -->
          <!--  <el-radio class="radio" v-model="form.status"  label="false">启用</el-radio>-->
        </el-form-item>
        <el-form-item label="备注">
          <el-input type="textarea" v-model="form.remark"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button @click="onCancel">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
  let m_isEdit = false
  export default {
  /*
   computed:{
      form:{
        get (){
           console.log("get");
           return this.$store.getter.categoryForm
          },
        set(value){
           this.$store.dispatch("updateFormVaue")
          }
      }
   },*/
  /* computed: mapGetters({
        //form:"categoryForm",
        tooltip:"tooltip"
    }),*/
  data:function(){
      return {
        title: "数据字典类别新增",
      }
  },

  computed: {
    form:function(){
        m_isEdit = this.$route.query.edit
        if(m_isEdit == true){
          this.title = "数据字典类别修改"
          return this.$store.getters.categoryCurrentRow
        }
        else
          return this.$store.getters.categoryForm
      }
   },

    methods: {
      onCancel:function(){
         this.$router.push({path:"/dict"});
      },
      onSubmit:function(){
        let _slef = this
        if(m_isEdit){
          this.$store.dispatch("updateCategory").then(function(){
             _slef.onCancel()
          })
        }else{
          this.$store.dispatch("addCategory")
        }
      }
    }
  }
</script>
