import request from '@/utils/request'

// 创建市场价格
export function createMarketPrice(data) {
  return request({
    url: '/pricetag/market-price/create',
    method: 'post',
    data: data
  })
}

// 更新市场价格
export function updateMarketPrice(data) {
  return request({
    url: '/pricetag/market-price/update',
    method: 'put',
    data: data
  })
}

// 删除市场价格
export function deleteMarketPrice(id) {
  return request({
    url: '/pricetag/market-price/delete?id=' + id,
    method: 'delete'
  })
}

// 获得市场价格
export function getMarketPrice(id) {
  return request({
    url: '/pricetag/market-price/get?id=' + id,
    method: 'get'
  })
}

// 获得市场价格分页
export function getMarketPricePage(query) {
  return request({
    url: '/pricetag/market-price/page',
    method: 'get',
    params: query
  })
}

// 导出市场价格 Excel
export function exportMarketPriceExcel(query) {
  return request({
    url: '/pricetag/market-price/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
