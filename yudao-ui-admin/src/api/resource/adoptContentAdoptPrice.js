import request from '@/utils/request'

// 创建认养/租凭价格
export function createAdoptContentAdoptPrice(data) {
  return request({
    url: '/resource/adopt-content-adopt-price/create',
    method: 'post',
    data: data
  })
}

// 更新认养/租凭价格
export function updateAdoptContentAdoptPrice(data) {
  return request({
    url: '/resource/adopt-content-adopt-price/update',
    method: 'put',
    data: data
  })
}

// 删除认养/租凭价格
export function deleteAdoptContentAdoptPrice(id) {
  return request({
    url: '/resource/adopt-content-adopt-price/delete?id=' + id,
    method: 'delete'
  })
}

// 获得认养/租凭价格
export function getAdoptContentAdoptPrice(id) {
  return request({
    url: '/resource/adopt-content-adopt-price/get?id=' + id,
    method: 'get'
  })
}

// 获得认养/租凭价格分页
export function getAdoptContentAdoptPricePage(query) {
  return request({
    url: '/resource/adopt-content-adopt-price/page',
    method: 'get',
    params: query
  })
}

// 导出认养/租凭价格 Excel
export function exportAdoptContentAdoptPriceExcel(query) {
  return request({
    url: '/resource/adopt-content-adopt-price/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
