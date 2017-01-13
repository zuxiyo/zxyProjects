<template>
  <div>
    <div  class="page-header clearfix">
      <div class="left">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>国家或地区</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="right"><el-button icon="plus " size="small" @click="add">新增</el-button></div>
    </div>
    <el-table ref="table" :data="tableData" highlight-current-row class="zxy-table">
      <el-table-column property="sort" label="#" width="60"></el-table-column>
      <el-table-column property="countryCode" label="编码" width="120">
      </el-table-column>
      <el-table-column property="countryName" label="名称" width="130">
      </el-table-column>
      <el-table-column property="fullName" label="完整名称">
      </el-table-column>
      <el-table-column property="phoneCode" label="电话区号" width="100">
      </el-table-column>
      <el-table-column property="domainName" label="域名" width="70">
      </el-table-column>
      <el-table-column property="status" label="状态" v-bind:formatter="setStatus" width="70">
      </el-table-column>
      <el-table-column :context="_self" inline-template label="操作" width="140">
          <span>
            <el-button size="small"  @click="edit($index, row)">编辑</el-button>
            <el-button size="small"  @click="remove($index, row)">删除</el-button>
          </span>
      </el-table-column>
    </el-table>
    <div class="right">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="pageSizes"
        :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
  import { mapGetters, mapActions } from "vuex"
  import OperationUtil from "../../utils/operation.js"

  export default{
    computed:mapGetters({
        tableData: "country/countryDataSet",
        currentPage:"country/currentPage",
        total:"country/total",
        pageSize:"country/pageSize",
        pageSizes:"country/pageSizes",
     }),

    created(){
      this.handleCurrentChange(this.currentPage)
    },
    methods:{
      handleSizeChange(val) {
        //console.log(`每页 ${val} 条`);
        this.$store.dispatch("country/getPage",{currentPage:this.currentPage,pageSize:val})
      },
      handleCurrentChange(val) {
        this.$store.dispatch("country/getPage",{currentPage:val,pageSize:this.pageSize})
        //console.log(`当前页: ${val}`);
      },
      add(){
         this.$router.push({path:"/countries/add"});
      },
      edit(index,row){
        this.$store.dispatch("country/setFormData",row)
        this.$router.push({path:"/countries/edit",query:{edit:true,currentPage:this.currentPage}});
      },
      //在这里函数命名delete会有名称冲突，不会进入该函数执行
      remove(index,row){
        let _self = this
        let result = OperationUtil.confirm(this)

        result.then(() =>{
          _self.$store.dispatch("country/delete",row.countryCode).then(function(){
            //重新绑定
            _self.$store.dispatch("country/getPage",{currentPage:_self.currentPage,pageSize:_self.pageSize})
          })
        })
      },

      setStatus(row,col){
        if(row.status == true)
            return "禁用";
        return "启用";
      }
    }
  }
</script>
