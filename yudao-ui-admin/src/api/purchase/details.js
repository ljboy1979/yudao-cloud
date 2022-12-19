import request from '@/utils/request'

// 创建采购单明细
export function createDetails(data) {
  return request({
    url: '/purchase/details/create',
    method: 'post',
    data: data
  })
}

// 更新采购单明细
export function updateDetails(data) {
  return request({
    url: '/purchase/details/update',
    method: 'put',
    data: data
  })
}

// 删除采购单明细
export function deleteDetails(id) {
  return request({
    url: '/purchase/details/delete?id=' + id,
    method: 'delete'
  })
}

// 获得采购单明细
export function getDetails(id) {
  return request({
    url: '/purchase/details/get?id=' + id,
    method: 'get'
  })
}

// 获得采购单明细分页
export function getDetailsPage(query) {
  return request({
    url: '/purchase/details/page',
    method: 'get',
    params: query
  })
}

// 导出采购单明细 Excel
export function exportDetailsExcel(query) {
  return request({
    url: '/purchase/details/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
