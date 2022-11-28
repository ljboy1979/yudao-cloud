import request from '@/utils/request'

// 创建商品sku
export function createCommoditySku(data) {
  return request({
    url: '/sales/commodity-sku/create',
    method: 'post',
    data: data
  })
}

// 更新商品sku
export function updateCommoditySku(data) {
  return request({
    url: '/sales/commodity-sku/update',
    method: 'put',
    data: data
  })
}

// 删除商品sku
export function deleteCommoditySku(id) {
  return request({
    url: '/sales/commodity-sku/delete?id=' + id,
    method: 'delete'
  })
}

// 获得商品sku
export function getCommoditySku(id) {
  return request({
    url: '/sales/commodity-sku/get?id=' + id,
    method: 'get'
  })
}

// 获得商品sku分页
export function getCommoditySkuPage(query) {
  return request({
    url: '/sales/commodity-sku/page',
    method: 'get',
    params: query
  })
}

// 导出商品sku Excel
export function exportCommoditySkuExcel(query) {
  return request({
    url: '/sales/commodity-sku/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
