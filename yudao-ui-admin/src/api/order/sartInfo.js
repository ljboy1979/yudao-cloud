import request from '@/utils/request'

// 创建购物车
export function createSartInfo(data) {
  return request({
    url: '/order/sart-info/create',
    method: 'post',
    data: data
  })
}

// 更新购物车
export function updateSartInfo(data) {
  return request({
    url: '/order/sart-info/update',
    method: 'put',
    data: data
  })
}

// 删除购物车
export function deleteSartInfo(id) {
  return request({
    url: '/order/sart-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得购物车
export function getSartInfo(id) {
  return request({
    url: '/order/sart-info/get?id=' + id,
    method: 'get'
  })
}

// 获得购物车分页
export function getSartInfoPage(query) {
  return request({
    url: '/order/sart-info/page',
    method: 'get',
    params: query
  })
}

// 导出购物车 Excel
export function exportSartInfoExcel(query) {
  return request({
    url: '/order/sart-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
