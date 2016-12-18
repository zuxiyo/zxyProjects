<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>
<script>
  export default{
    data(){
            return {
                title: '',
                date: '',
                content: ''
            }
        },
    created(){
      console.log("created");
    },
    ready(){
      console.log("ready");
    }
  }
</script>
