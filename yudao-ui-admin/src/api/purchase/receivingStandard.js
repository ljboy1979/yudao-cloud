import request from '@/utils/request'

// 创建收货标准
export function createReceivingStandard(data) {
  return request({
    url: '/purchase/receiving-standard/create',
    method: 'post',
    data: data
  })
}

// 更新收货标准
export function updateReceivingStandard(data) {
  return request({
    url: '/purchase/receiving-standard/update',
    method: 'put',
    data: data
  })
}

// 删除收货标准
export function deleteReceivingStandard(id) {
  return request({
    url: '/purchase/receiving-standard/delete?id=' + id,
    method: 'delete'
  })
}

// 获得收货标准
export function getReceivingStandard(id) {
  return request({
    url: '/purchase/receiving-standard/get?id=' + id,
    method: 'get'
  })
}

// 获得收货标准分页
export function getReceivingStandardPage(query) {
  return request({
    url: '/purchase/receiving-standard/page',
    method: 'get',
    params: query
  })
}

// 导出收货标准 Excel
export function exportReceivingStandardExcel(query) {
  return request({
    url: '/purchase/receiving-standard/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
