import request from '@/utils/request'

// 创建特医食品使用记录表
export function createSpecialMedicalFoodRecords(data) {
  return request({
    url: '/member/special-medical-food-records/create',
    method: 'post',
    data: data
  })
}

// 更新特医食品使用记录表
export function updateSpecialMedicalFoodRecords(data) {
  return request({
    url: '/member/special-medical-food-records/update',
    method: 'put',
    data: data
  })
}

// 删除特医食品使用记录表
export function deleteSpecialMedicalFoodRecords(id) {
  return request({
    url: '/member/special-medical-food-records/delete?id=' + id,
    method: 'delete'
  })
}

// 获得特医食品使用记录表
export function getSpecialMedicalFoodRecords(id) {
  return request({
    url: '/member/special-medical-food-records/get?id=' + id,
    method: 'get'
  })
}

// 获得特医食品使用记录表分页
export function getSpecialMedicalFoodRecordsPage(query) {
  return request({
    url: '/member/special-medical-food-records/page',
    method: 'get',
    params: query
  })
}

// 导出特医食品使用记录表 Excel
export function exportSpecialMedicalFoodRecordsExcel(query) {
  return request({
    url: '/member/special-medical-food-records/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
