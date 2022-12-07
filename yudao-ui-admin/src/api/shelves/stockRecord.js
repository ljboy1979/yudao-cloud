import request from '@/utils/request'

// 创建货架库存记录
export function createStockRecord(data) {
  return request({
    url: '/shelves/stock-record/create',
    method: 'post',
    data: data
  })
}

// 更新货架库存记录
export function updateStockRecord(data) {
  return request({
    url: '/shelves/stock-record/update',
    method: 'put',
    data: data
  })
}

// 删除货架库存记录
export function deleteStockRecord(id) {
  return request({
    url: '/shelves/stock-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得货架库存记录
export function getStockRecord(id) {
  return request({
    url: '/shelves/stock-record/get?id=' + id,
    method: 'get'
  })
}

// 获得货架库存记录分页
export function getStockRecordPage(query) {
  return request({
    url: '/shelves/stock-record/page',
    method: 'get',
    params: query
  })
}

// 导出货架库存记录 Excel
export function exportStockRecordExcel(query) {
  return request({
    url: '/shelves/stock-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
