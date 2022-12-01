import request from '@/utils/request'

// 创建特医食品规格
export function createSpecialMedicalFoodSpecification(data) {
  return request({
    url: '/sales/special-medical-food-specification/create',
    method: 'post',
    data: data
  })
}

// 更新特医食品规格
export function updateSpecialMedicalFoodSpecification(data) {
  return request({
    url: '/sales/special-medical-food-specification/update',
    method: 'put',
    data: data
  })
}

// 删除特医食品规格
export function deleteSpecialMedicalFoodSpecification(id) {
  return request({
    url: '/sales/special-medical-food-specification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得特医食品规格
export function getSpecialMedicalFoodSpecification(id) {
  return request({
    url: '/sales/special-medical-food-specification/get?id=' + id,
    method: 'get'
  })
}

// 获得特医食品规格分页
export function getSpecialMedicalFoodSpecificationPage(query) {
  return request({
    url: '/sales/special-medical-food-specification/page',
    method: 'get',
    params: query
  })
}

// 导出特医食品规格 Excel
export function exportSpecialMedicalFoodSpecificationExcel(query) {
  return request({
    url: '/sales/special-medical-food-specification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
