import request from '@/utils/request'

// 创建服务资源-养护记录
export function createMaintenanceRecord(data) {
  return request({
    url: '/resource/maintenance-record/create',
    method: 'post',
    data: data
  })
}

// 更新服务资源-养护记录
export function updateMaintenanceRecord(data) {
  return request({
    url: '/resource/maintenance-record/update',
    method: 'put',
    data: data
  })
}

// 删除服务资源-养护记录
export function deleteMaintenanceRecord(id) {
  return request({
    url: '/resource/maintenance-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务资源-养护记录
export function getMaintenanceRecord(id) {
  return request({
    url: '/resource/maintenance-record/get?id=' + id,
    method: 'get'
  })
}

// 获得服务资源-养护记录分页
export function getMaintenanceRecordPage(query) {
  return request({
    url: '/resource/maintenance-record/page',
    method: 'get',
    params: query
  })
}

// 导出服务资源-养护记录 Excel
export function exportMaintenanceRecordExcel(query) {
  return request({
    url: '/resource/maintenance-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
