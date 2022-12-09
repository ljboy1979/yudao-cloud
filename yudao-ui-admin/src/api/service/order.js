import request from '@/utils/request'

// 创建服务交易单
export function createOrder(data) {
  return request({
    url: '/service/order/create',
    method: 'post',
    data: data
  })
}

// 更新服务交易单
export function updateOrder(data) {
  return request({
    url: '/service/order/update',
    method: 'put',
    data: data
  })
}

// 删除服务交易单
export function deleteOrder(id) {
  return request({
    url: '/service/order/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务交易单
export function getOrder(id) {
  return request({
    url: '/service/order/get?id=' + id,
    method: 'get'
  })
}

// 获得服务交易单分页
export function getOrderPage(query) {
  return request({
    url: '/service/order/page',
    method: 'get',
    params: query
  })
}

// 导出服务交易单 Excel
export function exportOrderExcel(query) {
  return request({
    url: '/service/order/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
