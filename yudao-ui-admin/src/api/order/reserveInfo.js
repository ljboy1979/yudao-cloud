import request from '@/utils/request'

// 创建预定订单
export function createReserveInfo(data) {
  return request({
    url: '/order/reserve-info/create',
    method: 'post',
    data: data
  })
}

// 更新预定订单
export function updateReserveInfo(data) {
  return request({
    url: '/order/reserve-info/update',
    method: 'put',
    data: data
  })
}

// 删除预定订单
export function deleteReserveInfo(id) {
  return request({
    url: '/order/reserve-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得预定订单
export function getReserveInfo(id) {
  return request({
    url: '/order/reserve-info/get?id=' + id,
    method: 'get'
  })
}

// 获得预定订单分页
export function getReserveInfoPage(query) {
  return request({
    url: '/order/reserve-info/page',
    method: 'get',
    params: query
  })
}

// 导出预定订单 Excel
export function exportReserveInfoExcel(query) {
  return request({
    url: '/order/reserve-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
