import request from '@/utils/request'

// 创建营养检查记录
export function createNutritionExaminationRecord(data) {
  return request({
    url: '/member/nutrition-examination-record/create',
    method: 'post',
    data: data
  })
}

// 更新营养检查记录
export function updateNutritionExaminationRecord(data) {
  return request({
    url: '/member/nutrition-examination-record/update',
    method: 'put',
    data: data
  })
}

// 删除营养检查记录
export function deleteNutritionExaminationRecord(id) {
  return request({
    url: '/member/nutrition-examination-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得营养检查记录
export function getNutritionExaminationRecord(id) {
  return request({
    url: '/member/nutrition-examination-record/get?id=' + id,
    method: 'get'
  })
}

// 获得营养检查记录分页
export function getNutritionExaminationRecordPage(query) {
  return request({
    url: '/member/nutrition-examination-record/page',
    method: 'get',
    params: query
  })
}

// 导出营养检查记录 Excel
export function exportNutritionExaminationRecordExcel(query) {
  return request({
    url: '/member/nutrition-examination-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
