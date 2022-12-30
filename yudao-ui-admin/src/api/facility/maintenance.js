import request from '@/utils/request'

// 创建设施维护记录
export function createMaintenance(data) {
  return request({
    url: '/facility/maintenance/create',
    method: 'post',
    data: data
  })
}

// 更新设施维护记录
export function updateMaintenance(data) {
  return request({
    url: '/facility/maintenance/update',
    method: 'put',
    data: data
  })
}

// 删除设施维护记录
export function deleteMaintenance(id) {
  return request({
    url: '/facility/maintenance/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设施维护记录
export function getMaintenance(id) {
  return request({
    url: '/facility/maintenance/get?id=' + id,
    method: 'get'
  })
}

// 获得设施维护记录分页
export function getMaintenancePage(query) {
  return request({
    url: '/facility/maintenance/page',
    method: 'get',
    params: query
  })
}

// 导出设施维护记录 Excel
export function exportMaintenanceExcel(query) {
  return request({
    url: '/facility/maintenance/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
