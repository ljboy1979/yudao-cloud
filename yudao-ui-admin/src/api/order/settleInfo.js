import request from '@/utils/request'

// 创建订单结账
export function createSettleInfo(data) {
  return request({
    url: '/order/settle-info/create',
    method: 'post',
    data: data
  })
}

// 更新订单结账
export function updateSettleInfo(data) {
  return request({
    url: '/order/settle-info/update',
    method: 'put',
    data: data
  })
}

// 删除订单结账
export function deleteSettleInfo(id) {
  return request({
    url: '/order/settle-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得订单结账
export function getSettleInfo(id) {
  return request({
    url: '/order/settle-info/get?id=' + id,
    method: 'get'
  })
}

// 获得订单结账分页
export function getSettleInfoPage(query) {
  return request({
    url: '/order/settle-info/page',
    method: 'get',
    params: query
  })
}

// 导出订单结账 Excel
export function exportSettleInfoExcel(query) {
  return request({
    url: '/order/settle-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
