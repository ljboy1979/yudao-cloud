import request from '@/utils/request'

// 创建基地能耗信息
export function createConsume(data) {
  return request({
    url: '/bases/consume/create',
    method: 'post',
    data: data
  })
}

// 更新基地能耗信息
export function updateConsume(data) {
  return request({
    url: '/bases/consume/update',
    method: 'put',
    data: data
  })
}

// 删除基地能耗信息
export function deleteConsume(id) {
  return request({
    url: '/bases/consume/delete?id=' + id,
    method: 'delete'
  })
}

// 获得基地能耗信息
export function getConsume(id) {
  return request({
    url: '/bases/consume/get?id=' + id,
    method: 'get'
  })
}

// 获得基地能耗信息分页
export function getConsumePage(query) {
  return request({
    url: '/bases/consume/page',
    method: 'get',
    params: query
  })
}

// 导出基地能耗信息 Excel
export function exportConsumeExcel(query) {
  return request({
    url: '/bases/consume/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
