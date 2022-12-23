import request from '@/utils/request'

// 创建库存记录字表-明细
export function createRecordDetail(data) {
  return request({
    url: '/stock/record-detail/create',
    method: 'post',
    data: data
  })
}

// 更新库存记录字表-明细
export function updateRecordDetail(data) {
  return request({
    url: '/stock/record-detail/update',
    method: 'put',
    data: data
  })
}

// 删除库存记录字表-明细
export function deleteRecordDetail(id) {
  return request({
    url: '/stock/record-detail/delete?id=' + id,
    method: 'delete'
  })
}

// 获得库存记录字表-明细
export function getRecordDetail(id) {
  return request({
    url: '/stock/record-detail/get?id=' + id,
    method: 'get'
  })
}

// 获得库存记录字表-明细分页
export function getRecordDetailPage(query) {
  return request({
    url: '/stock/record-detail/page',
    method: 'get',
    params: query
  })
}

// 导出库存记录字表-明细 Excel
export function exportRecordDetailExcel(query) {
  return request({
    url: '/stock/record-detail/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
