import request from '@/utils/request'

// 创建设备厂家
export function createManufacturer(data) {
  return request({
    url: '/devices/manufacturer/create',
    method: 'post',
    data: data
  })
}

// 更新设备厂家
export function updateManufacturer(data) {
  return request({
    url: '/devices/manufacturer/update',
    method: 'put',
    data: data
  })
}

// 删除设备厂家
export function deleteManufacturer(id) {
  return request({
    url: '/devices/manufacturer/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备厂家
export function getManufacturer(id) {
  return request({
    url: '/devices/manufacturer/get?id=' + id,
    method: 'get'
  })
}

// 获得设备厂家分页
export function getManufacturerPage(query) {
  return request({
    url: '/devices/manufacturer/page',
    method: 'get',
    params: query
  })
}

// 导出设备厂家 Excel
export function exportManufacturerExcel(query) {
  return request({
    url: '/devices/manufacturer/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
