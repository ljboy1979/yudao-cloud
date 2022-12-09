import request from '@/utils/request'

// 创建服务资源-生产品种
export function createProductionScores(data) {
  return request({
    url: '/resource/production-scores/create',
    method: 'post',
    data: data
  })
}

// 更新服务资源-生产品种
export function updateProductionScores(data) {
  return request({
    url: '/resource/production-scores/update',
    method: 'put',
    data: data
  })
}

// 删除服务资源-生产品种
export function deleteProductionScores(id) {
  return request({
    url: '/resource/production-scores/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务资源-生产品种
export function getProductionScores(id) {
  return request({
    url: '/resource/production-scores/get?id=' + id,
    method: 'get'
  })
}

// 获得服务资源-生产品种分页
export function getProductionScoresPage(query) {
  return request({
    url: '/resource/production-scores/page',
    method: 'get',
    params: query
  })
}

// 导出服务资源-生产品种 Excel
export function exportProductionScoresExcel(query) {
  return request({
    url: '/resource/production-scores/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
