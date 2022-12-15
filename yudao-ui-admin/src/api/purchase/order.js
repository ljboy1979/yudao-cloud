import request from '@/utils/request'

// 创建采购单
export function createOrder(data) {
  return request({
    url: '/purchase/order/create',
    method: 'post',
    data: data
  })
}

// 更新采购单
export function updateOrder(data) {
  return request({
    url: '/purchase/order/update',
    method: 'put',
    data: data
  })
}

// 删除采购单
export function deleteOrder(id) {
  return request({
    url: '/purchase/order/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购单
export function getOrder(id) {
  return request({
    url: '/purchase/order/get?id=' + id,
    method: 'get'
  })
}

// 获得采购单分页
export function getOrderPage(query) {
  return request({
    url: '/purchase/order/page',
    method: 'get',
    params: query
  })
}

// 导出采购单 Excel
export function exportOrderExcel(query) {
  return request({
    url: '/purchase/order/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
