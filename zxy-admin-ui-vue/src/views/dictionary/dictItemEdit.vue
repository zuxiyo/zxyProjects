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
          <el-input v-model="form.dictionaryCode" placeholder="请输入字典编号/代码"></el-input>
        </el-form-item>
        <el-form-item label="名称">
          <el-input v-model="form.dictionaryName" placeholder="请输入字典名称"></el-input>
        </el-form-item>
        <el-form-item label="禁用">
          <input type="checkbox" v-model="form.status" />禁用
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
    data:function(){
        return {
          title: "数据字典项新增",
        }
    },

    computed: {
      form:function(){
          m_isEdit = this.$route.query.edit
          if(m_isEdit == true){
            this.title = "数据字典项修改"
            return this.$store.getters.itemUpdateForm
          }
          else
            return this.$store.getters.itemForm
        }
    },

    methods: {
      onCancel:function(){
        this.$router.push({path:"/dict"});
      },
      onSubmit:function(){
        if(m_isEdit){
          let _slef = this
          this.$store.dispatch("updateItem").then(function(){
             _slef.onCancel()
          })
        }else{
          this.$store.dispatch("addItem")
        }
      }
    }
  }
</script>
