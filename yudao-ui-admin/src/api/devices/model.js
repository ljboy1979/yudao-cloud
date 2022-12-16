import request from '@/utils/request'

// 创建设备型号
export function createModel(data) {
  return request({
    url: '/devices/model/create',
    method: 'post',
    data: data
  })
}

// 更新设备型号
export function updateModel(data) {
  return request({
    url: '/devices/model/update',
    method: 'put',
    data: data
  })
}

// 删除设备型号
export function deleteModel(id) {
  return request({
    url: '/devices/model/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备型号
export function getModel(id) {
  return request({
    url: '/devices/model/get?id=' + id,
    method: 'get'
  })
}

// 获得设备型号分页
export function getModelPage(query) {
  return request({
    url: '/devices/model/page',
    method: 'get',
    params: query
  })
}

// 导出设备型号 Excel
export function exportModelExcel(query) {
  return request({
    url: '/devices/model/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
