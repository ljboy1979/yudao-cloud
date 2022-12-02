import request from '@/utils/request'

// 创建套餐组成
export function createPackageOrganization(data) {
  return request({
    url: '/sales/package-organization/create',
    method: 'post',
    data: data
  })
}

// 更新套餐组成
export function updatePackageOrganization(data) {
  return request({
    url: '/sales/package-organization/update',
    method: 'put',
    data: data
  })
}

// 删除套餐组成
export function deletePackageOrganization(id) {
  return request({
    url: '/sales/package-organization/delete?id=' + id,
    method: 'delete'
  })
}

// 获得套餐组成
export function getPackageOrganization(id) {
  return request({
    url: '/sales/package-organization/get?id=' + id,
    method: 'get'
  })
}

// 获得套餐组成分页
export function getPackageOrganizationPage(query) {
  return request({
    url: '/sales/package-organization/page',
    method: 'get',
    params: query
  })
}

// 导出套餐组成 Excel
export function exportPackageOrganizationExcel(query) {
  return request({
    url: '/sales/package-organization/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
