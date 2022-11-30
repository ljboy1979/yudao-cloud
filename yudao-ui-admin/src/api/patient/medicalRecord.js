import request from '@/utils/request'

// 创建医嘱记录
export function createMedicalRecord(data) {
  return request({
    url: '/member/medical-record/create',
    method: 'post',
    data: data
  })
}

// 更新医嘱记录
export function updateMedicalRecord(data) {
  return request({
    url: '/member/medical-record/update',
    method: 'put',
    data: data
  })
}

// 删除医嘱记录
export function deleteMedicalRecord(id) {
  return request({
    url: '/member/medical-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得医嘱记录
export function getMedicalRecord(id) {
  return request({
    url: '/member/medical-record/get?id=' + id,
    method: 'get'
  })
}

// 获得医嘱记录分页
export function getMedicalRecordPage(query) {
  return request({
    url: '/member/medical-record/page',
    method: 'get',
    params: query
  })
}

// 导出医嘱记录 Excel
export function exportMedicalRecordExcel(query) {
  return request({
    url: '/member/medical-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
