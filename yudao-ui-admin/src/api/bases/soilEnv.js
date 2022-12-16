import request from '@/utils/request'

// 创建基地土壤环境
export function createSoilEnv(data) {
  return request({
    url: '/bases/soil-env/create',
    method: 'post',
    data: data
  })
}

// 更新基地土壤环境
export function updateSoilEnv(data) {
  return request({
    url: '/bases/soil-env/update',
    method: 'put',
    data: data
  })
}

// 删除基地土壤环境
export function deleteSoilEnv(id) {
  return request({
    url: '/bases/soil-env/delete?id=' + id,
    method: 'delete'
  })
}

// 获得基地土壤环境
export function getSoilEnv(id) {
  return request({
    url: '/bases/soil-env/get?id=' + id,
    method: 'get'
  })
}

// 获得基地土壤环境分页
export function getSoilEnvPage(query) {
  return request({
    url: '/bases/soil-env/page',
    method: 'get',
    params: query
  })
}

// 导出基地土壤环境 Excel
export function exportSoilEnvExcel(query) {
  return request({
    url: '/bases/soil-env/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
