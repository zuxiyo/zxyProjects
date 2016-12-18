<template>
  <el-pagination
    layout="total, sizes, prev, pager, next, jumper"
    :current-page="currentPage" :page-sizes="pageSizes" :page-size="pageSize" :total="totalElements">
  </el-pagination>
</template>
<script>
export default {
    data(){
      return {
        currentPage: 0,
        pageSize  : 100,
        pageSizes : [100, 200, 300, 400],
        totalElements:0
      }
    }
}
<script>
