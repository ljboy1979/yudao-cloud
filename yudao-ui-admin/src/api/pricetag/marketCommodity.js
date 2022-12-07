import request from '@/utils/request'

// 创建市场商品
export function createMarketCommodity(data) {
  return request({
    url: '/pricetag/market-commodity/create',
    method: 'post',
    data: data
  })
}

// 更新市场商品
export function updateMarketCommodity(data) {
  return request({
    url: '/pricetag/market-commodity/update',
    method: 'put',
    data: data
  })
}

// 删除市场商品
export function deleteMarketCommodity(id) {
  return request({
    url: '/pricetag/market-commodity/delete?id=' + id,
    method: 'delete'
  })
}

// 获得市场商品
export function getMarketCommodity(id) {
  return request({
    url: '/pricetag/market-commodity/get?id=' + id,
    method: 'get'
  })
}

// 获得市场商品分页
export function getMarketCommodityPage(query) {
  return request({
    url: '/pricetag/market-commodity/page',
    method: 'get',
    params: query
  })
}

// 导出市场商品 Excel
export function exportMarketCommodityExcel(query) {
  return request({
    url: '/pricetag/market-commodity/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
