import request from '@/utils/request'

// 创建基地补贴信息
export function createSubsidy(data) {
  return request({
    url: '/bases/subsidy/create',
    method: 'post',
    data: data
  })
}

// 更新基地补贴信息
export function updateSubsidy(data) {
  return request({
    url: '/bases/subsidy/update',
    method: 'put',
    data: data
  })
}

// 删除基地补贴信息
export function deleteSubsidy(id) {
  return request({
    url: '/bases/subsidy/delete?id=' + id,
    method: 'delete'
  })
}

// 获得基地补贴信息
export function getSubsidy(id) {
  return request({
    url: '/bases/subsidy/get?id=' + id,
    method: 'get'
  })
}

// 获得基地补贴信息分页
export function getSubsidyPage(query) {
  return request({
    url: '/bases/subsidy/page',
    method: 'get',
    params: query
  })
}

// 导出基地补贴信息 Excel
export function exportSubsidyExcel(query) {
  return request({
    url: '/bases/subsidy/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
