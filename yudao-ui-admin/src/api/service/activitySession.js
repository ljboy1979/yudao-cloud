import request from '@/utils/request'

// 创建时间排期
export function createActivitySession(data) {
  return request({
    url: '/service/activity-session/create',
    method: 'post',
    data: data
  })
}

// 更新时间排期
export function updateActivitySession(data) {
  return request({
    url: '/service/activity-session/update',
    method: 'put',
    data: data
  })
}

// 删除时间排期
export function deleteActivitySession(id) {
  return request({
    url: '/service/activity-session/delete?id=' + id,
    method: 'delete'
  })
}

// 获得时间排期
export function getActivitySession(id) {
  return request({
    url: '/service/activity-session/get?id=' + id,
    method: 'get'
  })
}

// 获得时间排期分页
export function getActivitySessionPage(query) {
  return request({
    url: '/service/activity-session/page',
    method: 'get',
    params: query
  })
}

// 导出时间排期 Excel
export function exportActivitySessionExcel(query) {
  return request({
    url: '/service/activity-session/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
