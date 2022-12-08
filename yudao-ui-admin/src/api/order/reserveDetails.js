import request from '@/utils/request'

// 创建订单预定详情
export function createReserveDetails(data) {
  return request({
    url: '/order/reserve-details/create',
    method: 'post',
    data: data
  })
}

// 更新订单预定详情
export function updateReserveDetails(data) {
  return request({
    url: '/order/reserve-details/update',
    method: 'put',
    data: data
  })
}

// 删除订单预定详情
export function deleteReserveDetails(id) {
  return request({
    url: '/order/reserve-details/delete?id=' + id,
    method: 'delete'
  })
}

// 获得订单预定详情
export function getReserveDetails(id) {
  return request({
    url: '/order/reserve-details/get?id=' + id,
    method: 'get'
  })
}

// 获得订单预定详情分页
export function getReserveDetailsPage(query) {
  return request({
    url: '/order/reserve-details/page',
    method: 'get',
    params: query
  })
}

// 导出订单预定详情 Excel
export function exportReserveDetailsExcel(query) {
  return request({
    url: '/order/reserve-details/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
