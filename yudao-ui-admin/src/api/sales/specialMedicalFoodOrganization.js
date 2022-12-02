import request from '@/utils/request'

// 创建特医食品组成
export function createSpecialMedicalFoodOrganization(data) {
  return request({
    url: '/sales/special-medical-food-organization/create',
    method: 'post',
    data: data
  })
}

// 更新特医食品组成
export function updateSpecialMedicalFoodOrganization(data) {
  return request({
    url: '/sales/special-medical-food-organization/update',
    method: 'put',
    data: data
  })
}

// 删除特医食品组成
export function deleteSpecialMedicalFoodOrganization(id) {
  return request({
    url: '/sales/special-medical-food-organization/delete?id=' + id,
    method: 'delete'
  })
}

// 获得特医食品组成
export function getSpecialMedicalFoodOrganization(id) {
  return request({
    url: '/sales/special-medical-food-organization/get?id=' + id,
    method: 'get'
  })
}

// 获得特医食品组成分页
export function getSpecialMedicalFoodOrganizationPage(query) {
  return request({
    url: '/sales/special-medical-food-organization/page',
    method: 'get',
    params: query
  })
}

// 导出特医食品组成 Excel
export function exportSpecialMedicalFoodOrganizationExcel(query) {
  return request({
    url: '/sales/special-medical-food-organization/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
