import request from '@/utils/request'

// 创建库存清单
export function createInventory(data) {
  return request({
    url: '/stock/inventory/create',
    method: 'post',
    data: data
  })
}

// 更新库存清单
export function updateInventory(data) {
  return request({
    url: '/stock/inventory/update',
    method: 'put',
    data: data
  })
}

// 删除库存清单
export function deleteInventory(id) {
  return request({
    url: '/stock/inventory/delete?id=' + id,
    method: 'delete'
  })
}

// 获得库存清单
export function getInventory(id) {
  return request({
    url: '/stock/inventory/get?id=' + id,
    method: 'get'
  })
}

// 获得库存清单分页
export function getInventoryPage(query) {
  return request({
    url: '/stock/inventory/page',
    method: 'get',
    params: query
  })
}

// 导出库存清单 Excel
export function exportInventoryExcel(query) {
  return request({
    url: '/stock/inventory/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
