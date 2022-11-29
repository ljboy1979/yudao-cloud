import request from '@/utils/request'

// 创建商品规格
export function createCommoditySpecification(data) {
  return request({
    url: '/sales/commodity-specification/create',
    method: 'post',
    data: data
  })
}

// 更新商品规格
export function updateCommoditySpecification(data) {
  return request({
    url: '/sales/commodity-specification/update',
    method: 'put',
    data: data
  })
}

// 删除商品规格
export function deleteCommoditySpecification(id) {
  return request({
    url: '/sales/commodity-specification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得商品规格
export function getCommoditySpecification(id) {
  return request({
    url: '/sales/commodity-specification/get?id=' + id,
    method: 'get'
  })
}

// 获得商品规格分页
export function getCommoditySpecificationPage(query) {
  return request({
    url: '/sales/commodity-specification/page',
    method: 'get',
    params: query
  })
}

// 导出商品规格 Excel
export function exportCommoditySpecificationExcel(query) {
  return request({
    url: '/sales/commodity-specification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
