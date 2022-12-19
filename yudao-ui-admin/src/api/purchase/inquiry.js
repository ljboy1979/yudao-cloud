import request from '@/utils/request'

// 创建采购询价电子
export function createInquiry(data) {
  return request({
    url: '/purchase/inquiry/create',
    method: 'post',
    data: data
  })
}

// 更新采购询价电子
export function updateInquiry(data) {
  return request({
    url: '/purchase/inquiry/update',
    method: 'put',
    data: data
  })
}

// 删除采购询价电子
export function deleteInquiry(id) {
  return request({
    url: '/purchase/inquiry/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购询价电子
export function getInquiry(id) {
  return request({
    url: '/purchase/inquiry/get?id=' + id,
    method: 'get'
  })
}

// 获得采购询价电子分页
export function getInquiryPage(query) {
  return request({
    url: '/purchase/inquiry/page',
    method: 'get',
    params: query
  })
}

// 导出采购询价电子 Excel
export function exportInquiryExcel(query) {
  return request({
    url: '/purchase/inquiry/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
