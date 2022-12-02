import request from '@/utils/request'

// 创建套餐规格
export function createPackageSpecification(data) {
  return request({
    url: '/sales/package-specification/create',
    method: 'post',
    data: data
  })
}

// 更新套餐规格
export function updatePackageSpecification(data) {
  return request({
    url: '/sales/package-specification/update',
    method: 'put',
    data: data
  })
}

// 删除套餐规格
export function deletePackageSpecification(id) {
  return request({
    url: '/sales/package-specification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得套餐规格
export function getPackageSpecification(id) {
  return request({
    url: '/sales/package-specification/get?id=' + id,
    method: 'get'
  })
}

// 获得套餐规格分页
export function getPackageSpecificationPage(query) {
  return request({
    url: '/sales/package-specification/page',
    method: 'get',
    params: query
  })
}

// 导出套餐规格 Excel
export function exportPackageSpecificationExcel(query) {
  return request({
    url: '/sales/package-specification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
