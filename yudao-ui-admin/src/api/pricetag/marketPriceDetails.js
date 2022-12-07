import request from '@/utils/request'

// 创建市场价格明细
export function createMarketPriceDetails(data) {
  return request({
    url: '/pricetag/market-price-details/create',
    method: 'post',
    data: data
  })
}

// 更新市场价格明细
export function updateMarketPriceDetails(data) {
  return request({
    url: '/pricetag/market-price-details/update',
    method: 'put',
    data: data
  })
}

// 删除市场价格明细
export function deleteMarketPriceDetails(id) {
  return request({
    url: '/pricetag/market-price-details/delete?id=' + id,
    method: 'delete'
  })
}

// 获得市场价格明细
export function getMarketPriceDetails(id) {
  return request({
    url: '/pricetag/market-price-details/get?id=' + id,
    method: 'get'
  })
}

// 获得市场价格明细分页
export function getMarketPriceDetailsPage(query) {
  return request({
    url: '/pricetag/market-price-details/page',
    method: 'get',
    params: query
  })
}

// 导出市场价格明细 Excel
export function exportMarketPriceDetailsExcel(query) {
  return request({
    url: '/pricetag/market-price-details/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
