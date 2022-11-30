import request from '@/utils/request'

// 创建病史记录
export function createMedicalHistoryRecord(data) {
  return request({
    url: '/member/medical-history-record/create',
    method: 'post',
    data: data
  })
}

// 更新病史记录
export function updateMedicalHistoryRecord(data) {
  return request({
    url: '/member/medical-history-record/update',
    method: 'put',
    data: data
  })
}

// 删除病史记录
export function deleteMedicalHistoryRecord(id) {
  return request({
    url: '/member/medical-history-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得病史记录
export function getMedicalHistoryRecord(id) {
  return request({
    url: '/member/medical-history-record/get?id=' + id,
    method: 'get'
  })
}

// 获得病史记录分页
export function getMedicalHistoryRecordPage(query) {
  return request({
    url: '/member/medical-history-record/page',
    method: 'get',
    params: query
  })
}

// 导出病史记录 Excel
export function exportMedicalHistoryRecordExcel(query) {
  return request({
    url: '/member/medical-history-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
