import request from '@/utils/request'

// 创建特医食品分类
export function createSpecialMedicalFoodClassify(data) {
  return request({
    url: '/sales/special-medical-food-classify/create',
    method: 'post',
    data: data
  })
}

// 更新特医食品分类
export function updateSpecialMedicalFoodClassify(data) {
  return request({
    url: '/sales/special-medical-food-classify/update',
    method: 'put',
    data: data
  })
}

// 删除特医食品分类
export function deleteSpecialMedicalFoodClassify(id) {
  return request({
    url: '/sales/special-medical-food-classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得特医食品分类
export function getSpecialMedicalFoodClassify(id) {
  return request({
    url: '/sales/special-medical-food-classify/get?id=' + id,
    method: 'get'
  })
}

// 获得特医食品分类分页
export function getSpecialMedicalFoodClassifyPage(query) {
  return request({
    url: '/sales/special-medical-food-classify/page',
    method: 'get',
    params: query
  })
}

// 导出特医食品分类 Excel
export function exportSpecialMedicalFoodClassifyExcel(query) {
  return request({
    url: '/sales/special-medical-food-classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
