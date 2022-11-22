import request from '@/utils/request'

// 创建经营主体其他证件
export function createOtherCertificateInfo(data) {
  return request({
    url: '/enterprise/other-certificate-info/create',
    method: 'post',
    data: data
  })
}

// 更新经营主体其他证件
export function updateOtherCertificateInfo(data) {
  return request({
    url: '/enterprise/other-certificate-info/update',
    method: 'put',
    data: data
  })
}

// 删除经营主体其他证件
export function deleteOtherCertificateInfo(id) {
  return request({
    url: '/enterprise/other-certificate-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得经营主体其他证件
export function getOtherCertificateInfo(id) {
  return request({
    url: '/enterprise/other-certificate-info/get?id=' + id,
    method: 'get'
  })
}

// 获得经营主体其他证件分页
export function getOtherCertificateInfoPage(query) {
  return request({
    url: '/enterprise/other-certificate-info/page',
    method: 'get',
    params: query
  })
}

// 导出经营主体其他证件 Excel
export function exportOtherCertificateInfoExcel(query) {
  return request({
    url: '/enterprise/other-certificate-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
