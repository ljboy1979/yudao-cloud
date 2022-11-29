import request from '@/utils/request'

// 创建商品组成
export function createCommodityOrganization(data) {
  return request({
    url: '/sales/commodity-organization/create',
    method: 'post',
    data: data
  })
}

// 更新商品组成
export function updateCommodityOrganization(data) {
  return request({
    url: '/sales/commodity-organization/update',
    method: 'put',
    data: data
  })
}

// 删除商品组成
export function deleteCommodityOrganization(id) {
  return request({
    url: '/sales/commodity-organization/delete?id=' + id,
    method: 'delete'
  })
}

// 获得商品组成
export function getCommodityOrganization(id) {
  return request({
    url: '/sales/commodity-organization/get?id=' + id,
    method: 'get'
  })
}

// 获得商品组成分页
export function getCommodityOrganizationPage(query) {
  return request({
    url: '/sales/commodity-organization/page',
    method: 'get',
    params: query
  })
}

// 导出商品组成 Excel
export function exportCommodityOrganizationExcel(query) {
  return request({
    url: '/sales/commodity-organization/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
