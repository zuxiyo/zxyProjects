<template>
  <div>
    <header1></header1>
    <content1></content1>
  </div>
</template>
<script>
// 导入文件取得变量名不能为 header、Content，否则输不出来 
import header1 from './Header'
import content1   from './Content'

export default {
  components: {
    content1,
    header1
  }
}
</script>
