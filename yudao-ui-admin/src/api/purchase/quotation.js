import request from '@/utils/request'

// 创建采购询价电子
export function createQuotation(data) {
  return request({
    url: '/purchase/quotation/create',
    method: 'post',
    data: data
  })
}

// 更新采购询价电子
export function updateQuotation(data) {
  return request({
    url: '/purchase/quotation/update',
    method: 'put',
    data: data
  })
}

// 删除采购询价电子
export function deleteQuotation(id) {
  return request({
    url: '/purchase/quotation/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购询价电子
export function getQuotation(id) {
  return request({
    url: '/purchase/quotation/get?id=' + id,
    method: 'get'
  })
}

// 获得采购询价电子分页
export function getQuotationPage(query) {
  return request({
    url: '/purchase/quotation/page',
    method: 'get',
    params: query
  })
}

// 导出采购询价电子 Excel
export function exportQuotationExcel(query) {
  return request({
    url: '/purchase/quotation/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
