import request from '@/utils/request'

// 创建告警通知规则
export function createAlarmNotifier(data) {
  return request({
    url: '/devices/alarm-notifier/create',
    method: 'post',
    data: data
  })
}

// 更新告警通知规则
export function updateAlarmNotifier(data) {
  return request({
    url: '/devices/alarm-notifier/update',
    method: 'put',
    data: data
  })
}

// 删除告警通知规则
export function deleteAlarmNotifier(id) {
  return request({
    url: '/devices/alarm-notifier/delete?id=' + id,
    method: 'delete'
  })
}

// 获得告警通知规则
export function getAlarmNotifier(id) {
  return request({
    url: '/devices/alarm-notifier/get?id=' + id,
    method: 'get'
  })
}

// 获得告警通知规则分页
export function getAlarmNotifierPage(query) {
  return request({
    url: '/devices/alarm-notifier/page',
    method: 'get',
    params: query
  })
}

// 导出告警通知规则 Excel
export function exportAlarmNotifierExcel(query) {
  return request({
    url: '/devices/alarm-notifier/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
