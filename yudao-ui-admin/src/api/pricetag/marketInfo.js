import request from '@/utils/request'

// 创建市场信息
export function createMarketInfo(data) {
  return request({
    url: '/pricetag/market-info/create',
    method: 'post',
    data: data
  })
}

// 更新市场信息
export function updateMarketInfo(data) {
  return request({
    url: '/pricetag/market-info/update',
    method: 'put',
    data: data
  })
}

// 删除市场信息
export function deleteMarketInfo(id) {
  return request({
    url: '/pricetag/market-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得市场信息
export function getMarketInfo(id) {
  return request({
    url: '/pricetag/market-info/get?id=' + id,
    method: 'get'
  })
}

// 获得市场信息分页
export function getMarketInfoPage(query) {
  return request({
    url: '/pricetag/market-info/page',
    method: 'get',
    params: query
  })
}

// 导出市场信息 Excel
export function exportMarketInfoExcel(query) {
  return request({
    url: '/pricetag/market-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
