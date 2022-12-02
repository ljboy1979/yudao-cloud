import request from '@/utils/request'

// 创建代理商管理
export function createAgentManagement(data) {
  return request({
    url: '/member/agent-management/create',
    method: 'post',
    data: data
  })
}

// 更新代理商管理
export function updateAgentManagement(data) {
  return request({
    url: '/member/agent-management/update',
    method: 'put',
    data: data
  })
}

// 删除代理商管理
export function deleteAgentManagement(id) {
  return request({
    url: '/member/agent-management/delete?id=' + id,
    method: 'delete'
  })
}

// 获得代理商管理
export function getAgentManagement(id) {
  return request({
    url: '/member/agent-management/get?id=' + id,
    method: 'get'
  })
}

// 获得代理商管理分页
export function getAgentManagementPage(query) {
  return request({
    url: '/member/agent-management/page',
    method: 'get',
    params: query
  })
}

// 导出代理商管理 Excel
export function exportAgentManagementExcel(query) {
  return request({
    url: '/member/agent-management/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
