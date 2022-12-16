import request from '@/utils/request'

// 创建设备运行时间
export function createTime(data) {
  return request({
    url: '/devices/time/create',
    method: 'post',
    data: data
  })
}

// 更新设备运行时间
export function updateTime(data) {
  return request({
    url: '/devices/time/update',
    method: 'put',
    data: data
  })
}

// 删除设备运行时间
export function deleteTime(id) {
  return request({
    url: '/devices/time/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备运行时间
export function getTime(id) {
  return request({
    url: '/devices/time/get?id=' + id,
    method: 'get'
  })
}

// 获得设备运行时间分页
export function getTimePage(query) {
  return request({
    url: '/devices/time/page',
    method: 'get',
    params: query
  })
}

// 导出设备运行时间 Excel
export function exportTimeExcel(query) {
  return request({
    url: '/devices/time/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
