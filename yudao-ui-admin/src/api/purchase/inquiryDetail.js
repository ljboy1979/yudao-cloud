import request from '@/utils/request'

// 创建采购询价电子表
export function createInquiryDetail(data) {
  return request({
    url: '/purchase/inquiry-detail/create',
    method: 'post',
    data: data
  })
}

// 更新采购询价电子表
export function updateInquiryDetail(data) {
  return request({
    url: '/purchase/inquiry-detail/update',
    method: 'put',
    data: data
  })
}

// 删除采购询价电子表
export function deleteInquiryDetail(id) {
  return request({
    url: '/purchase/inquiry-detail/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购询价电子表
export function getInquiryDetail(id) {
  return request({
    url: '/purchase/inquiry-detail/get?id=' + id,
    method: 'get'
  })
}

// 获得采购询价电子表分页
export function getInquiryDetailPage(query) {
  return request({
    url: '/purchase/inquiry-detail/page',
    method: 'get',
    params: query
  })
}

// 导出采购询价电子表 Excel
export function exportInquiryDetailExcel(query) {
  return request({
    url: '/purchase/inquiry-detail/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
