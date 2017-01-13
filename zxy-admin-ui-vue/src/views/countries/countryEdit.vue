<template>
  <div>
    <div class="page-header">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/countries' }">国家或地区</el-breadcrumb-item>
        <el-breadcrumb-item>{{title}}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-form :model="formData" ref="countryForm" label-width="80px" class="middle-box" :rules="rules">
      <div>
        <el-col :span="12">
          <el-form-item label="代码" prop="countryCode">
            <el-input v-model="formData.countryCode" placeholder="请输入国家或地区的代码" :disabled="isDisabled"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="排序号" prop="sort">
            <el-input v-model="formData.sort" placeholder="请输入排序号"></el-input>
          </el-form-item>
        </el-col>
      </div>
      <div>
        <el-col :span="12">
          <el-form-item label="简称" prop="countryName">
            <el-input v-model="formData.countryName" placeholder="请输入国家或地区的简称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="英文简称" prop="englishName">
            <el-input v-model="formData.englishName" placeholder="请输入国家或地区的英文简称"></el-input>
          </el-form-item>
        </el-col>
      </div>
      <div>
        <el-col :span="24">
          <el-form-item label="全称" prop="fullName">
            <el-input v-model="formData.fullName" placeholder="请输入国家或地区的全称"></el-input>
          </el-form-item>
        </el-col>
      </div>
      <div>
        <el-col :span="12">
          <el-form-item label="电话代码" prop="phoneCode">
            <el-input v-model="formData.phoneCode"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="域名缩写" prop="domainName">
            <el-input v-model="formData.domainName"></el-input>
          </el-form-item>
        </el-col>
      </div>
      <div>
        <el-col :span="12">
          <el-form-item label="禁用" prop="status">
            <el-checkbox v-model="formData.status">禁用</el-checkbox>
          </el-form-item>
        </el-col>
        <el-col :span="12">
        </el-col>
      </div>
      <div>
        <el-col :span="24" class="text-center">
          <el-button type="primary" @click="onSubmit"> 保 存 </el-button>
          <el-button @click="onCancel"> 返 回 </el-button>
        </el-col>
      </div>
    </el-form>
  </div>
</template>
<script>
  import { mapGetters, mapActions } from 'vuex'
  let m_isEdit = false
  let formName = "countryForm"
  export default {
    data() {
      return {
        formData: {
            countryCode:"",
            sort:"",
            countryName:"",
            englishName:"",
            fullName:"",
            phoneCode:"",
            domainName:"",
            status:false
        },
        title:"新增",
        isDisabled:false,
        rules: {
          countryCode: [{ required: true, message: '请输入国家或地区代码' }],
          sort: [{ required: true, message: '请输入排序号' }],
          countryName: [{ required: true, message: '请输入国家或地区的简称' }],
          fullName: [{ required: true, message: '请输入国家或地区的全称' }]
        }
      }
    },
    created:function(){
       m_isEdit = this.$route.query.edit
       if(m_isEdit == true){
          this.title = "编辑"
          this.isDisabled = true
          this.$store.dispatch("country/getFormData").then((formData) =>{
             this.formData = formData
          })
       }
    },
    methods: {
      onCancel: function () {
        this.$router.push({ path: "/countries" });
      },
      onSubmit: function () {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let _slef = this
            if (m_isEdit) {
              this.$store.dispatch("country/update",this.formData).then(function () {
                _slef.onCancel()
              })
            } else {
              this.$store.dispatch("country/create",this.formData).then(function (){
                _slef.$refs[formName].resetFields();
              })
            }
          }
        })
      }
    }
  }

</script>
