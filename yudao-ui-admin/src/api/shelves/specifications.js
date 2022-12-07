import request from '@/utils/request'

// 创建货架规格
export function createSpecifications(data) {
  return request({
    url: '/shelves/specifications/create',
    method: 'post',
    data: data
  })
}

// 更新货架规格
export function updateSpecifications(data) {
  return request({
    url: '/shelves/specifications/update',
    method: 'put',
    data: data
  })
}

// 删除货架规格
export function deleteSpecifications(id) {
  return request({
    url: '/shelves/specifications/delete?id=' + id,
    method: 'delete'
  })
}

// 获得货架规格
export function getSpecifications(id) {
  return request({
    url: '/shelves/specifications/get?id=' + id,
    method: 'get'
  })
}

// 获得货架规格分页
export function getSpecificationsPage(query) {
  return request({
    url: '/shelves/specifications/page',
    method: 'get',
    params: query
  })
}

// 导出货架规格 Excel
export function exportSpecificationsExcel(query) {
  return request({
    url: '/shelves/specifications/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
