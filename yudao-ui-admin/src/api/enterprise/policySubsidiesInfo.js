import request from '@/utils/request'

// 创建企业政策补贴信息
export function createPolicySubsidiesInfo(data) {
  return request({
    url: '/enterprise/policy-subsidies-info/create',
    method: 'post',
    data: data
  })
}

// 更新企业政策补贴信息
export function updatePolicySubsidiesInfo(data) {
  return request({
    url: '/enterprise/policy-subsidies-info/update',
    method: 'put',
    data: data
  })
}

// 删除企业政策补贴信息
export function deletePolicySubsidiesInfo(id) {
  return request({
    url: '/enterprise/policy-subsidies-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得企业政策补贴信息
export function getPolicySubsidiesInfo(id) {
  return request({
    url: '/enterprise/policy-subsidies-info/get?id=' + id,
    method: 'get'
  })
}

// 获得企业政策补贴信息分页
export function getPolicySubsidiesInfoPage(query) {
  return request({
    url: '/enterprise/policy-subsidies-info/page',
    method: 'get',
    params: query
  })
}

// 导出企业政策补贴信息 Excel
export function exportPolicySubsidiesInfoExcel(query) {
  return request({
    url: '/enterprise/policy-subsidies-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
