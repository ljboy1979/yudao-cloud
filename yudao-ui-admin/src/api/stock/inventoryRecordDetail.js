import request from '@/utils/request'

// 创建盘点记录表子表-明细
export function createInventoryRecordDetail(data) {
  return request({
    url: '/stock/inventory-record-detail/create',
    method: 'post',
    data: data
  })
}

// 更新盘点记录表子表-明细
export function updateInventoryRecordDetail(data) {
  return request({
    url: '/stock/inventory-record-detail/update',
    method: 'put',
    data: data
  })
}

// 删除盘点记录表子表-明细
export function deleteInventoryRecordDetail(id) {
  return request({
    url: '/stock/inventory-record-detail/delete?id=' + id,
    method: 'delete'
  })
}

// 获得盘点记录表子表-明细
export function getInventoryRecordDetail(id) {
  return request({
    url: '/stock/inventory-record-detail/get?id=' + id,
    method: 'get'
  })
}

// 获得盘点记录表子表-明细分页
export function getInventoryRecordDetailPage(query) {
  return request({
    url: '/stock/inventory-record-detail/page',
    method: 'get',
    params: query
  })
}

// 导出盘点记录表子表-明细 Excel
export function exportInventoryRecordDetailExcel(query) {
  return request({
    url: '/stock/inventory-record-detail/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
