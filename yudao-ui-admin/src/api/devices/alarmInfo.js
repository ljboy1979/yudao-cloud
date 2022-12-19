import request from '@/utils/request'

// 创建告警信息
export function createAlarmInfo(data) {
  return request({
    url: '/devices/alarm-info/create',
    method: 'post',
    data: data
  })
}

// 更新告警信息
export function updateAlarmInfo(data) {
  return request({
    url: '/devices/alarm-info/update',
    method: 'put',
    data: data
  })
}

// 删除告警信息
export function deleteAlarmInfo(id) {
  return request({
    url: '/devices/alarm-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得告警信息
export function getAlarmInfo(id) {
  return request({
    url: '/devices/alarm-info/get?id=' + id,
    method: 'get'
  })
}

// 获得告警信息分页
export function getAlarmInfoPage(query) {
  return request({
    url: '/devices/alarm-info/page',
    method: 'get',
    params: query
  })
}

// 导出告警信息 Excel
export function exportAlarmInfoExcel(query) {
  return request({
    url: '/devices/alarm-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
