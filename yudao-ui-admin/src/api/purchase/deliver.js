import request from '@/utils/request'

// 创建采购交付
export function createDeliver(data) {
  return request({
    url: '/purchase/deliver/create',
    method: 'post',
    data: data
  })
}

// 更新采购交付
export function updateDeliver(data) {
  return request({
    url: '/purchase/deliver/update',
    method: 'put',
    data: data
  })
}

// 删除采购交付
export function deleteDeliver(id) {
  return request({
    url: '/purchase/deliver/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购交付
export function getDeliver(id) {
  return request({
    url: '/purchase/deliver/get?id=' + id,
    method: 'get'
  })
}

// 获得采购交付分页
export function getDeliverPage(query) {
  return request({
    url: '/purchase/deliver/page',
    method: 'get',
    params: query
  })
}

// 导出采购交付 Excel
export function exportDeliverExcel(query) {
  return request({
    url: '/purchase/deliver/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
