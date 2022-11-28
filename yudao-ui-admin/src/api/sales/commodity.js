import request from '@/utils/request'

// 创建商品
export function createCommodity(data) {
  return request({
    url: '/sales/commodity/create',
    method: 'post',
    data: data
  })
}

// 更新商品
export function updateCommodity(data) {
  return request({
    url: '/sales/commodity/update',
    method: 'put',
    data: data
  })
}

// 删除商品
export function deleteCommodity(id) {
  return request({
    url: '/sales/commodity/delete?id=' + id,
    method: 'delete'
  })
}

// 获得商品
export function getCommodity(id) {
  return request({
    url: '/sales/commodity/get?id=' + id,
    method: 'get'
  })
}

// 获得商品分页
export function getCommodityPage(query) {
  return request({
    url: '/sales/commodity/page',
    method: 'get',
    params: query
  })
}

// 导出商品 Excel
export function exportCommodityExcel(query) {
  return request({
    url: '/sales/commodity/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
