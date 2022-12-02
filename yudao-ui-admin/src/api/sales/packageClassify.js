import request from '@/utils/request'

// 创建套餐分类
export function createPackageClassify(data) {
  return request({
    url: '/sales/package-classify/create',
    method: 'post',
    data: data
  })
}

// 更新套餐分类
export function updatePackageClassify(data) {
  return request({
    url: '/sales/package-classify/update',
    method: 'put',
    data: data
  })
}

// 删除套餐分类
export function deletePackageClassify(id) {
  return request({
    url: '/sales/package-classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得套餐分类
export function getPackageClassify(id) {
  return request({
    url: '/sales/package-classify/get?id=' + id,
    method: 'get'
  })
}

// 获得套餐分类分页
export function getPackageClassifyPage(query) {
  return request({
    url: '/sales/package-classify/page',
    method: 'get',
    params: query
  })
}

// 导出套餐分类 Excel
export function exportPackageClassifyExcel(query) {
  return request({
    url: '/sales/package-classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
