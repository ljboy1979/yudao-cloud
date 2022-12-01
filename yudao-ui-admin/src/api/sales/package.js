import request from '@/utils/request'

// 创建套餐
export function createPackage(data) {
  return request({
    url: '/sales/package/create',
    method: 'post',
    data: data
  })
}

// 更新套餐
export function updatePackage(data) {
  return request({
    url: '/sales/package/update',
    method: 'put',
    data: data
  })
}

// 删除套餐
export function deletePackage(id) {
  return request({
    url: '/sales/package/delete?id=' + id,
    method: 'delete'
  })
}

// 获得套餐
export function getPackage(id) {
  return request({
    url: '/sales/package/get?id=' + id,
    method: 'get'
  })
}

// 获得套餐分页
export function getPackagePage(query) {
  return request({
    url: '/sales/package/page',
    method: 'get',
    params: query
  })
}

// 导出套餐 Excel
export function exportPackageExcel(query) {
  return request({
    url: '/sales/package/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
