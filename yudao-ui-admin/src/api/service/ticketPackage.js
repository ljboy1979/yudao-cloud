import request from '@/utils/request'

// 创建套票
export function createTicketPackage(data) {
  return request({
    url: '/service/ticket-package/create',
    method: 'post',
    data: data
  })
}

// 更新套票
export function updateTicketPackage(data) {
  return request({
    url: '/service/ticket-package/update',
    method: 'put',
    data: data
  })
}

// 删除套票
export function deleteTicketPackage(id) {
  return request({
    url: '/service/ticket-package/delete?id=' + id,
    method: 'delete'
  })
}

// 获得套票
export function getTicketPackage(id) {
  return request({
    url: '/service/ticket-package/get?id=' + id,
    method: 'get'
  })
}

// 获得套票分页
export function getTicketPackagePage(query) {
  return request({
    url: '/service/ticket-package/page',
    method: 'get',
    params: query
  })
}

// 导出套票 Excel
export function exportTicketPackageExcel(query) {
  return request({
    url: '/service/ticket-package/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
