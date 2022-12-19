import request from '@/utils/request'

// 创建地块土壤环境
export function createInfoSoilEnv(data) {
  return request({
    url: '/tunnel/info-soil-env/create',
    method: 'post',
    data: data
  })
}

// 更新地块土壤环境
export function updateInfoSoilEnv(data) {
  return request({
    url: '/tunnel/info-soil-env/update',
    method: 'put',
    data: data
  })
}

// 删除地块土壤环境
export function deleteInfoSoilEnv(id) {
  return request({
    url: '/tunnel/info-soil-env/delete?id=' + id,
    method: 'delete'
  })
}

// 获得地块土壤环境
export function getInfoSoilEnv(id) {
  return request({
    url: '/tunnel/info-soil-env/get?id=' + id,
    method: 'get'
  })
}

// 获得地块土壤环境分页
export function getInfoSoilEnvPage(query) {
  return request({
    url: '/tunnel/info-soil-env/page',
    method: 'get',
    params: query
  })
}

// 导出地块土壤环境 Excel
export function exportInfoSoilEnvExcel(query) {
  return request({
    url: '/tunnel/info-soil-env/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
