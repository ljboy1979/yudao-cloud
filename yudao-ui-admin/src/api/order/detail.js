import request from '@/utils/request'

// 创建订单详情
export function createDetail(data) {
  return request({
    url: '/order/detail/create',
    method: 'post',
    data: data
  })
}

// 更新订单详情
export function updateDetail(data) {
  return request({
    url: '/order/detail/update',
    method: 'put',
    data: data
  })
}

// 删除订单详情
export function deleteDetail(id) {
  return request({
    url: '/order/detail/delete?id=' + id,
    method: 'delete'
  })
}

// 获得订单详情
export function getDetail(id) {
  return request({
    url: '/order/detail/get?id=' + id,
    method: 'get'
  })
}

// 获得订单详情分页
export function getDetailPage(query) {
  return request({
    url: '/order/detail/page',
    method: 'get',
    params: query
  })
}

// 导出订单详情 Excel
export function exportDetailExcel(query) {
  return request({
    url: '/order/detail/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
