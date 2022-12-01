import request from '@/utils/request'

// 创建特医食品
export function createSpecialMedicalFood(data) {
  return request({
    url: '/sales/special-medical-food/create',
    method: 'post',
    data: data
  })
}

// 更新特医食品
export function updateSpecialMedicalFood(data) {
  return request({
    url: '/sales/special-medical-food/update',
    method: 'put',
    data: data
  })
}

// 删除特医食品
export function deleteSpecialMedicalFood(id) {
  return request({
    url: '/sales/special-medical-food/delete?id=' + id,
    method: 'delete'
  })
}

// 获得特医食品
export function getSpecialMedicalFood(id) {
  return request({
    url: '/sales/special-medical-food/get?id=' + id,
    method: 'get'
  })
}

// 获得特医食品分页
export function getSpecialMedicalFoodPage(query) {
  return request({
    url: '/sales/special-medical-food/page',
    method: 'get',
    params: query
  })
}

// 导出特医食品 Excel
export function exportSpecialMedicalFoodExcel(query) {
  return request({
    url: '/sales/special-medical-food/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
