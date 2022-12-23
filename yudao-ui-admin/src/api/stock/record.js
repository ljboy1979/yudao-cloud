import request from '@/utils/request'

// 创建库存记录
export function createRecord(data) {
  return request({
    url: '/stock/record/create',
    method: 'post',
    data: data
  })
}

// 更新库存记录
export function updateRecord(data) {
  return request({
    url: '/stock/record/update',
    method: 'put',
    data: data
  })
}

// 删除库存记录
export function deleteRecord(id) {
  return request({
    url: '/stock/record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得库存记录
export function getRecord(id) {
  return request({
    url: '/stock/record/get?id=' + id,
    method: 'get'
  })
}

// 获得库存记录分页
export function getRecordPage(query) {
  return request({
    url: '/stock/record/page',
    method: 'get',
    params: query
  })
}

// 导出库存记录 Excel
export function exportRecordExcel(query) {
  return request({
    url: '/stock/record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
