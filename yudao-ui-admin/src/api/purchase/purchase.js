import request from '@/utils/request'

// 创建采购单
export function createpurchase(data) {
  return request({
    url: '/purchase/purchase/create',
    method: 'post',
    data: data
  })
}

// 更新采购单
export function updatepurchase(data) {
  return request({
    url: '/purchase/purchase/update',
    method: 'put',
    data: data
  })
}

// 删除采购单
export function deletepurchase(id) {
  return request({
    url: '/purchase/purchase/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购单
export function getpurchase(id) {
  return request({
    url: '/purchase/purchase/get?id=' + id,
    method: 'get'
  })
}

// 获得采购单分页
export function getpurchasePage(query) {
  return request({
    url: '/purchase/purchase/page',
    method: 'get',
    params: query
  })
}

// 导出采购单 Excel
export function exportpurchaseExcel(query) {
  return request({
    url: '/purchase/purchase/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
