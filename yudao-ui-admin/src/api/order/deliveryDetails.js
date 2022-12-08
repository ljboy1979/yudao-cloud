import request from '@/utils/request'

// 创建配送详情
export function createDeliveryDetails(data) {
  return request({
    url: '/order/delivery-details/create',
    method: 'post',
    data: data
  })
}

// 更新配送详情
export function updateDeliveryDetails(data) {
  return request({
    url: '/order/delivery-details/update',
    method: 'put',
    data: data
  })
}

// 删除配送详情
export function deleteDeliveryDetails(id) {
  return request({
    url: '/order/delivery-details/delete?id=' + id,
    method: 'delete'
  })
}

// 获得配送详情
export function getDeliveryDetails(id) {
  return request({
    url: '/order/delivery-details/get?id=' + id,
    method: 'get'
  })
}

// 获得配送详情分页
export function getDeliveryDetailsPage(query) {
  return request({
    url: '/order/delivery-details/page',
    method: 'get',
    params: query
  })
}

// 导出配送详情 Excel
export function exportDeliveryDetailsExcel(query) {
  return request({
    url: '/order/delivery-details/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
