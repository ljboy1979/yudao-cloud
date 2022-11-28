import request from '@/utils/request'

// 创建商品分类
export function createCommodityCategory(data) {
  return request({
    url: '/sales/commodity-category/create',
    method: 'post',
    data: data
  })
}

// 更新商品分类
export function updateCommodityCategory(data) {
  return request({
    url: '/sales/commodity-category/update',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function deleteCommodityCategory(id) {
  return request({
    url: '/sales/commodity-category/delete?id=' + id,
    method: 'delete'
  })
}

// 获得商品分类
export function getCommodityCategory(id) {
  return request({
    url: '/sales/commodity-category/get?id=' + id,
    method: 'get'
  })
}

// 获得商品分类分页
export function getCommodityCategoryPage(query) {
  return request({
    url: '/sales/commodity-category/page',
    method: 'get',
    params: query
  })
}

// 导出商品分类 Excel
export function exportCommodityCategoryExcel(query) {
  return request({
    url: '/sales/commodity-category/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
