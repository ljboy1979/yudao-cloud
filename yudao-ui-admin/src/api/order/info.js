import request from '@/utils/request'

// 创建订单
export function createInfo(data) {
  return request({
    url: '/order/info/create',
    method: 'post',
    data: data
  })
}

// 更新订单
export function updateInfo(data) {
  return request({
    url: '/order/info/update',
    method: 'put',
    data: data
  })
}

// 删除订单
export function deleteInfo(id) {
  return request({
    url: '/order/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得订单
export function getInfo(id) {
  return request({
    url: '/order/info/get?id=' + id,
    method: 'get'
  })
}

// 获得订单分页
export function getInfoPage(query) {
  return request({
    url: '/order/info/page',
    method: 'get',
    params: query
  })
}

// 导出订单 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/order/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
