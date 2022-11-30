import request from '@/utils/request'

// 创建健康档案
export function createPatientHealth(data) {
  return request({
    url: '/member/patient-health/create',
    method: 'post',
    data: data
  })
}

// 更新健康档案
export function updatePatientHealth(data) {
  return request({
    url: '/member/patient-health/update',
    method: 'put',
    data: data
  })
}

// 删除健康档案
export function deletePatientHealth(id) {
  return request({
    url: '/member/patient-health/delete?id=' + id,
    method: 'delete'
  })
}

// 获得健康档案
export function getPatientHealth(id) {
  return request({
    url: '/member/patient-health/get?id=' + id,
    method: 'get'
  })
}

// 获得健康档案分页
export function getPatientHealthPage(query) {
  return request({
    url: '/member/patient-health/page',
    method: 'get',
    params: query
  })
}

// 导出健康档案 Excel
export function exportPatientHealthExcel(query) {
  return request({
    url: '/member/patient-health/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
