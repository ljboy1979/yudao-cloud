import request from '@/utils/request'

// 创建市场分类
export function createMarketClassify(data) {
  return request({
    url: '/pricetag/market-classify/create',
    method: 'post',
    data: data
  })
}

// 更新市场分类
export function updateMarketClassify(data) {
  return request({
    url: '/pricetag/market-classify/update',
    method: 'put',
    data: data
  })
}

// 删除市场分类
export function deleteMarketClassify(id) {
  return request({
    url: '/pricetag/market-classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得市场分类
export function getMarketClassify(id) {
  return request({
    url: '/pricetag/market-classify/get?id=' + id,
    method: 'get'
  })
}

// 获得市场分类分页
export function getMarketClassifyPage(query) {
  return request({
    url: '/pricetag/market-classify/page',
    method: 'get',
    params: query
  })
}

// 导出市场分类 Excel
export function exportMarketClassifyExcel(query) {
  return request({
    url: '/pricetag/market-classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
