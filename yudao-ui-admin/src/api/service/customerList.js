import request from '@/utils/request'

// 创建服务客户名单
export function createCustomerList(data) {
  return request({
    url: '/service/customer-list/create',
    method: 'post',
    data: data
  })
}

// 更新服务客户名单
export function updateCustomerList(data) {
  return request({
    url: '/service/customer-list/update',
    method: 'put',
    data: data
  })
}

// 删除服务客户名单
export function deleteCustomerList(id) {
  return request({
    url: '/service/customer-list/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务客户名单
export function getCustomerList(id) {
  return request({
    url: '/service/customer-list/get?id=' + id,
    method: 'get'
  })
}

// 获得服务客户名单分页
export function getCustomerListPage(query) {
  return request({
    url: '/service/customer-list/page',
    method: 'get',
    params: query
  })
}

// 导出服务客户名单 Excel
export function exportCustomerListExcel(query) {
  return request({
    url: '/service/customer-list/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
