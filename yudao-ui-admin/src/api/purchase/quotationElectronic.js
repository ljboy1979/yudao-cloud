import request from '@/utils/request'

// 创建采购报价单电子
export function createQuotationElectronic(data) {
  return request({
    url: '/purchase/quotation-electronic/create',
    method: 'post',
    data: data
  })
}

// 更新采购报价单电子
export function updateQuotationElectronic(data) {
  return request({
    url: '/purchase/quotation-electronic/update',
    method: 'put',
    data: data
  })
}

// 删除采购报价单电子
export function deleteQuotationElectronic(id) {
  return request({
    url: '/purchase/quotation-electronic/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购报价单电子
export function getQuotationElectronic(id) {
  return request({
    url: '/purchase/quotation-electronic/get?id=' + id,
    method: 'get'
  })
}

// 获得采购报价单电子分页
export function getQuotationElectronicPage(query) {
  return request({
    url: '/purchase/quotation-electronic/page',
    method: 'get',
    params: query
  })
}

// 导出采购报价单电子 Excel
export function exportQuotationElectronicExcel(query) {
  return request({
    url: '/purchase/quotation-electronic/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
