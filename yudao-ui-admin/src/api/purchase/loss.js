import request from '@/utils/request'

// 创建损耗
export function createLoss(data) {
  return request({
    url: '/purchase/loss/create',
    method: 'post',
    data: data
  })
}

// 更新损耗
export function updateLoss(data) {
  return request({
    url: '/purchase/loss/update',
    method: 'put',
    data: data
  })
}

// 删除损耗
export function deleteLoss(id) {
  return request({
    url: '/purchase/loss/delete?id=' + id,
    method: 'delete'
  })
}

// 获得损耗
export function getLoss(id) {
  return request({
    url: '/purchase/loss/get?id=' + id,
    method: 'get'
  })
}

// 获得损耗分页
export function getLossPage(query) {
  return request({
    url: '/purchase/loss/page',
    method: 'get',
    params: query
  })
}

// 导出损耗 Excel
export function exportLossExcel(query) {
  return request({
    url: '/purchase/loss/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
