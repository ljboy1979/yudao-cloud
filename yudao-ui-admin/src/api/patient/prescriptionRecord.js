import request from '@/utils/request'

// 创建处方记录表
export function createPrescriptionRecord(data) {
  return request({
    url: '/member/prescription-record/create',
    method: 'post',
    data: data
  })
}

// 更新处方记录表
export function updatePrescriptionRecord(data) {
  return request({
    url: '/member/prescription-record/update',
    method: 'put',
    data: data
  })
}

// 删除处方记录表
export function deletePrescriptionRecord(id) {
  return request({
    url: '/member/prescription-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得处方记录表
export function getPrescriptionRecord(id) {
  return request({
    url: '/member/prescription-record/get?id=' + id,
    method: 'get'
  })
}

// 获得处方记录表分页
export function getPrescriptionRecordPage(query) {
  return request({
    url: '/member/prescription-record/page',
    method: 'get',
    params: query
  })
}

// 导出处方记录表 Excel
export function exportPrescriptionRecordExcel(query) {
  return request({
    url: '/member/prescription-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
