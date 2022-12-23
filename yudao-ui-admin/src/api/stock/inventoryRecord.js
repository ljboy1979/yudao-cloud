import request from '@/utils/request'

// 创建盘点记录
export function createInventoryRecord(data) {
  return request({
    url: '/stock/inventory-record/create',
    method: 'post',
    data: data
  })
}

// 更新盘点记录
export function updateInventoryRecord(data) {
  return request({
    url: '/stock/inventory-record/update',
    method: 'put',
    data: data
  })
}

// 删除盘点记录
export function deleteInventoryRecord(id) {
  return request({
    url: '/stock/inventory-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得盘点记录
export function getInventoryRecord(id) {
  return request({
    url: '/stock/inventory-record/get?id=' + id,
    method: 'get'
  })
}

// 获得盘点记录分页
export function getInventoryRecordPage(query) {
  return request({
    url: '/stock/inventory-record/page',
    method: 'get',
    params: query
  })
}

// 导出盘点记录 Excel
export function exportInventoryRecordExcel(query) {
  return request({
    url: '/stock/inventory-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
