import request from '@/utils/request'

// 创建服务资源-认养物/租凭物就医记录
export function createAdoptContentHealth(data) {
  return request({
    url: '/resource/adopt-content-health/create',
    method: 'post',
    data: data
  })
}

// 更新服务资源-认养物/租凭物就医记录
export function updateAdoptContentHealth(data) {
  return request({
    url: '/resource/adopt-content-health/update',
    method: 'put',
    data: data
  })
}

// 删除服务资源-认养物/租凭物就医记录
export function deleteAdoptContentHealth(id) {
  return request({
    url: '/resource/adopt-content-health/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务资源-认养物/租凭物就医记录
export function getAdoptContentHealth(id) {
  return request({
    url: '/resource/adopt-content-health/get?id=' + id,
    method: 'get'
  })
}

// 获得服务资源-认养物/租凭物就医记录分页
export function getAdoptContentHealthPage(query) {
  return request({
    url: '/resource/adopt-content-health/page',
    method: 'get',
    params: query
  })
}

// 导出服务资源-认养物/租凭物就医记录 Excel
export function exportAdoptContentHealthExcel(query) {
  return request({
    url: '/resource/adopt-content-health/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
