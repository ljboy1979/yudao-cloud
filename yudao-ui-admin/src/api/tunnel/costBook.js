import request from '@/utils/request'

// 创建地块账本
export function createCostBook(data) {
  return request({
    url: '/tunnel/cost-book/create',
    method: 'post',
    data: data
  })
}

// 更新地块账本
export function updateCostBook(data) {
  return request({
    url: '/tunnel/cost-book/update',
    method: 'put',
    data: data
  })
}

// 删除地块账本
export function deleteCostBook(id) {
  return request({
    url: '/tunnel/cost-book/delete?id=' + id,
    method: 'delete'
  })
}

// 获得地块账本
export function getCostBook(id) {
  return request({
    url: '/tunnel/cost-book/get?id=' + id,
    method: 'get'
  })
}

// 获得地块账本分页
export function getCostBookPage(query) {
  return request({
    url: '/tunnel/cost-book/page',
    method: 'get',
    params: query
  })
}

// 导出地块账本 Excel
export function exportCostBookExcel(query) {
  return request({
    url: '/tunnel/cost-book/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
