import request from '@/utils/request'

// 创建库存分类
export function createStockClassify(data) {
  return request({
    url: '/shelves/stock-classify/create',
    method: 'post',
    data: data
  })
}

// 更新库存分类
export function updateStockClassify(data) {
  return request({
    url: '/shelves/stock-classify/update',
    method: 'put',
    data: data
  })
}

// 删除库存分类
export function deleteStockClassify(id) {
  return request({
    url: '/shelves/stock-classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得库存分类
export function getStockClassify(id) {
  return request({
    url: '/shelves/stock-classify/get?id=' + id,
    method: 'get'
  })
}

// 获得库存分类分页
export function getStockClassifyPage(query) {
  return request({
    url: '/shelves/stock-classify/page',
    method: 'get',
    params: query
  })
}

// 导出库存分类 Excel
export function exportStockClassifyExcel(query) {
  return request({
    url: '/shelves/stock-classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
