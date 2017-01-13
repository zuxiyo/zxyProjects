
var OperationUtil = {

  confirm:function(owenr){
   return owenr.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {confirmButtonText: '确定', cancelButtonText: '取消',type: 'warning'})
  }
}

export default OperationUtil

