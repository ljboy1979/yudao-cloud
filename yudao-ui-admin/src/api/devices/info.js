import request from '@/utils/request'

// 创建设备
export function createInfo(data) {
  return request({
    url: '/devices/info/create',
    method: 'post',
    data: data
  })
}

// 更新设备
export function updateInfo(data) {
  return request({
    url: '/devices/info/update',
    method: 'put',
    data: data
  })
}

// 删除设备
export function deleteInfo(id) {
  return request({
    url: '/devices/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备
export function getInfo(id) {
  return request({
    url: '/devices/info/get?id=' + id,
    method: 'get'
  })
}

// 获得设备分页
export function getInfoPage(query) {
  return request({
    url: '/devices/info/page',
    method: 'get',
    params: query
  })
}

// 导出设备 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/devices/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
