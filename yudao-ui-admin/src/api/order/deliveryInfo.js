import request from '@/utils/request'

// 创建配送
export function createDeliveryInfo(data) {
  return request({
    url: '/order/delivery-info/create',
    method: 'post',
    data: data
  })
}

// 更新配送
export function updateDeliveryInfo(data) {
  return request({
    url: '/order/delivery-info/update',
    method: 'put',
    data: data
  })
}

// 删除配送
export function deleteDeliveryInfo(id) {
  return request({
    url: '/order/delivery-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得配送
export function getDeliveryInfo(id) {
  return request({
    url: '/order/delivery-info/get?id=' + id,
    method: 'get'
  })
}

// 获得配送分页
export function getDeliveryInfoPage(query) {
  return request({
    url: '/order/delivery-info/page',
    method: 'get',
    params: query
  })
}

// 导出配送 Excel
export function exportDeliveryInfoExcel(query) {
  return request({
    url: '/order/delivery-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
