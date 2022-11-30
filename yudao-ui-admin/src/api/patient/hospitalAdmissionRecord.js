import request from '@/utils/request'

// 创建住院记录
export function createHospitalAdmissionRecord(data) {
  return request({
    url: '/member/hospital-admission-record/create',
    method: 'post',
    data: data
  })
}

// 更新住院记录
export function updateHospitalAdmissionRecord(data) {
  return request({
    url: '/member/hospital-admission-record/update',
    method: 'put',
    data: data
  })
}

// 删除住院记录
export function deleteHospitalAdmissionRecord(id) {
  return request({
    url: '/member/hospital-admission-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得住院记录
export function getHospitalAdmissionRecord(id) {
  return request({
    url: '/member/hospital-admission-record/get?id=' + id,
    method: 'get'
  })
}

// 获得住院记录分页
export function getHospitalAdmissionRecordPage(query) {
  return request({
    url: '/member/hospital-admission-record/page',
    method: 'get',
    params: query
  })
}

// 导出住院记录 Excel
export function exportHospitalAdmissionRecordExcel(query) {
  return request({
    url: '/member/hospital-admission-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
