import request from '@/utils/request'

// 创建基地物候环境
export function createPhenologicalEnv(data) {
  return request({
    url: '/bases/phenological-env/create',
    method: 'post',
    data: data
  })
}

// 更新基地物候环境
export function updatePhenologicalEnv(data) {
  return request({
    url: '/bases/phenological-env/update',
    method: 'put',
    data: data
  })
}

// 删除基地物候环境
export function deletePhenologicalEnv(id) {
  return request({
    url: '/bases/phenological-env/delete?id=' + id,
    method: 'delete'
  })
}

// 获得基地物候环境
export function getPhenologicalEnv(id) {
  return request({
    url: '/bases/phenological-env/get?id=' + id,
    method: 'get'
  })
}

// 获得基地物候环境分页
export function getPhenologicalEnvPage(query) {
  return request({
    url: '/bases/phenological-env/page',
    method: 'get',
    params: query
  })
}

// 导出基地物候环境 Excel
export function exportPhenologicalEnvExcel(query) {
  return request({
    url: '/bases/phenological-env/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
