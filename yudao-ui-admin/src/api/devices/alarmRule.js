import request from '@/utils/request'

// 创建告警规则
export function createAlarmRule(data) {
  return request({
    url: '/devices/alarm-rule/create',
    method: 'post',
    data: data
  })
}

// 更新告警规则
export function updateAlarmRule(data) {
  return request({
    url: '/devices/alarm-rule/update',
    method: 'put',
    data: data
  })
}

// 删除告警规则
export function deleteAlarmRule(id) {
  return request({
    url: '/devices/alarm-rule/delete?id=' + id,
    method: 'delete'
  })
}

// 获得告警规则
export function getAlarmRule(id) {
  return request({
    url: '/devices/alarm-rule/get?id=' + id,
    method: 'get'
  })
}

// 获得告警规则分页
export function getAlarmRulePage(query) {
  return request({
    url: '/devices/alarm-rule/page',
    method: 'get',
    params: query
  })
}

// 导出告警规则 Excel
export function exportAlarmRuleExcel(query) {
  return request({
    url: '/devices/alarm-rule/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
