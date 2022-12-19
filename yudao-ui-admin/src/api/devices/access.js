import request from '@/utils/request'

// 创建设备允许访问名单信息
export function createAccess(data) {
  return request({
    url: '/devices/access/create',
    method: 'post',
    data: data
  })
}

// 更新设备允许访问名单信息
export function updateAccess(data) {
  return request({
    url: '/devices/access/update',
    method: 'put',
    data: data
  })
}

// 删除设备允许访问名单信息
export function deleteAccess(id) {
  return request({
    url: '/devices/access/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备允许访问名单信息
export function getAccess(id) {
  return request({
    url: '/devices/access/get?id=' + id,
    method: 'get'
  })
}

// 获得设备允许访问名单信息分页
export function getAccessPage(query) {
  return request({
    url: '/devices/access/page',
    method: 'get',
    params: query
  })
}

// 导出设备允许访问名单信息 Excel
export function exportAccessExcel(query) {
  return request({
    url: '/devices/access/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
