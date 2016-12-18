<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>数据字典管理</el-breadcrumb-item>
    </el-breadcrumb>
    <hr/>
    <el-row :gutter="10">
      <el-col :span="10">
        <span class="left"><i class="el-icon-caret-right"></i>类别</span>
        <span class="right">
        <el-button-group>
          <el-button icon="plus " size="small" @click="addCategory">新增</el-button>
          <el-button icon="edit" size="small" @click="editCategory">编辑</el-button>
          <el-button icon="delete" size="small" @click="deleteCategory">删除</el-button>
        </el-button-group>
         </span>
      </el-col>
      <el-col :span="14">
        <span class="left"><i class="el-icon-caret-right"></i>【{{itemTableTitle}}】的数据项</span>
        <span class="right">
          <el-button-group>
            <el-button icon="plus " size="small" @click="addItem">新增</el-button>
          </el-button-group>
        </span>
      </el-col>
      <el-col :span="10">
        <el-table ref="categoryTable" :data="categoryData" highlight-current-row @current-change="handleCategoryCurrentChange">
          <!--<el-table-column type="index" width="25"></el-table-column>-->
          <el-table-column property="sort" label="#" width="30"></el-table-column>
          <el-table-column property="categoryCode" label="编码" width="120">
          </el-table-column>
          <el-table-column property="categoryName" label="名称" width="130">
          </el-table-column>
          <el-table-column property="status" label="状态" v-bind:formatter="setStatus" width="70">
          </el-table-column>
           <el-table-column property="remark" label="备注">
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="14">
        <el-table :data="itemData" highlight-current-row style="width: 100%">
          <el-table-column property="sort" label="#" width="30"></el-table-column>
          <el-table-column property="dictionaryCode" label="编码" width="110">
          </el-table-column>
          <el-table-column property="dictionaryName" label="名称" width="120">
          </el-table-column>
          <el-table-column property="status" label="状态"  v-bind:formatter="setStatus" width="70">
          </el-table-column>
          <el-table-column property="remark" label="备注">
          </el-table-column>
          <el-table-column :context="_self" inline-template label="操作" width="140">
            <span>
              <el-button size="small"  @click="editItem($index, row)">编辑</el-button>
              <el-button size="small"  @click="deleteItem($index, row)">删除</el-button>
            </span>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
  </div>
</template>
<script>
 import { mapGetters, mapActions } from 'vuex'
 // import pagination from "../../components/pagination.vue"; <pagination />
  let m_is_selected_category = false
  export default {

    computed: mapGetters({
        categoryData:"categoryDataSet",
        itemData:"itemDataSet",
        itemTableTitle:"itemTableTitle"
    }),

    created(){
        this.$store.dispatch("getCategoryPage")
    },
    mounted(){
      //if(typeof(this.$store.getters.categoryCurrentRow) != "undefined" ){
        if(this.$store.getters.categoryCurrentRow != null ){
          //console.log(this.$store.getters.categoryCurrentRow);
          //选中先前行
          //下面两种写法好像都不起作用
          //this.$refs.categoryTable.toggleRowSelection(this.$store.getters.categoryCurrentRow,true)
          //this.$refs.categoryTable.toggleRowSelection(this.categoryData.find(d=>d.uid = this.$store.getters.categoryCurrentRow.uid),true)
          this.$store.dispatch("getItemPage",this.$store.getters.categoryCurrentRow)
        }
    },

    methods:{

      handleCategoryCurrentChange(currentRow){
        //删除类别后，本事件会再触发一次，所以这里需要在判断
        if(currentRow != null){
          m_is_selected_category = true
          this.$store.dispatch("selectedCategoryRow",currentRow)
        }
      },

      addCategory(){
        //字典类别新增
        this.$router.push({path:"/dict/category/add"});
      },

      editCategory(){
        if(m_is_selected_category == false)
          this.$message({
            message: '请先选择类别！',
            type: 'warning'
          });
        else
          this.$router.push({path:"/dict/category/edit",query:{edit:true}});
      },

      deleteCategory(){
        if(m_is_selected_category == false)
          this.$message({message: '请先选择类别！', type: 'warning'});
        else{
          let _self = this
          this.$store.dispatch("deleteCategory").then(function(){
             //重新绑定
             _self.$store.dispatch("getCategoryPage")
          })
        }
      },
      //--------------------------------------------------------
      addItem(){
         this.$router.push({path:"/dict/item/add"});
      },
      editItem(index,row){
          this.$store.dispatch("selectedItemRow",row)
          this.$router.push({path:"/dict/item/edit",query:{edit:true}});
      },
      deleteItem(index,row){
          let _self = this
          this.$store.dispatch("selectedItemRow",row)
          this.$store.dispatch("deleteItem").then(function(){
             //重新绑定
             _self.$store.dispatch("getItemPage",_self.$store.getters.categoryCurrentRow)
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
