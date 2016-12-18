
//起始页
const PAGE_INDEX = 0;
 //一页的记录数
const PAGE_SIZE = 0;

var Pageable = {

    get getInitParams()  { return { pageIndex:PAGE_INDEX, pageSize:PAGE_SIZE} }
}

export default Pageable
