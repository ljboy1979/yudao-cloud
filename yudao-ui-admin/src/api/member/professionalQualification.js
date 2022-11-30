import request from '@/utils/request'

// 创建专业资质
export function createProfessionalQualification(data) {
  return request({
    url: '/member/professional-qualification/create',
    method: 'post',
    data: data
  })
}

// 更新专业资质
export function updateProfessionalQualification(data) {
  return request({
    url: '/member/professional-qualification/update',
    method: 'put',
    data: data
  })
}

// 删除专业资质
export function deleteProfessionalQualification(id) {
  return request({
    url: '/member/professional-qualification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得专业资质
export function getProfessionalQualification(id) {
  return request({
    url: '/member/professional-qualification/get?id=' + id,
    method: 'get'
  })
}

// 获得专业资质分页
export function getProfessionalQualificationPage(query) {
  return request({
    url: '/member/professional-qualification/page',
    method: 'get',
    params: query
  })
}

// 导出专业资质 Excel
export function exportProfessionalQualificationExcel(query) {
  return request({
    url: '/member/professional-qualification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
