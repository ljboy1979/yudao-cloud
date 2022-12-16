import request from '@/utils/request'

// 创建设备表参数
export function createParameter(data) {
  return request({
    url: '/devices/parameter/create',
    method: 'post',
    data: data
  })
}

// 更新设备表参数
export function updateParameter(data) {
  return request({
    url: '/devices/parameter/update',
    method: 'put',
    data: data
  })
}

// 删除设备表参数
export function deleteParameter(id) {
  return request({
    url: '/devices/parameter/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备表参数
export function getParameter(id) {
  return request({
    url: '/devices/parameter/get?id=' + id,
    method: 'get'
  })
}

// 获得设备表参数分页
export function getParameterPage(query) {
  return request({
    url: '/devices/parameter/page',
    method: 'get',
    params: query
  })
}

// 导出设备表参数 Excel
export function exportParameterExcel(query) {
  return request({
    url: '/devices/parameter/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
