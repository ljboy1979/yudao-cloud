import request from '@/utils/request'

// 创建套票详情
export function createTicketDetail(data) {
  return request({
    url: '/service/ticket-detail/create',
    method: 'post',
    data: data
  })
}

// 更新套票详情
export function updateTicketDetail(data) {
  return request({
    url: '/service/ticket-detail/update',
    method: 'put',
    data: data
  })
}

// 删除套票详情
export function deleteTicketDetail(id) {
  return request({
    url: '/service/ticket-detail/delete?id=' + id,
    method: 'delete'
  })
}

// 获得套票详情
export function getTicketDetail(id) {
  return request({
    url: '/service/ticket-detail/get?id=' + id,
    method: 'get'
  })
}

// 获得套票详情分页
export function getTicketDetailPage(query) {
  return request({
    url: '/service/ticket-detail/page',
    method: 'get',
    params: query
  })
}

// 导出套票详情 Excel
export function exportTicketDetailExcel(query) {
  return request({
    url: '/service/ticket-detail/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
