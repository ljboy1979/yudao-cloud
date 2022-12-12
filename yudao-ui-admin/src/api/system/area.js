import request from '@/utils/request'

// 创建行政区划
export function createArea(data) {
  return request({
    url: '/system/area/create',
    method: 'post',
    data: data
  })
}

// 更新行政区划
export function updateArea(data) {
  return request({
    url: '/system/area/update',
    method: 'put',
    data: data
  })
}

// 删除行政区划
export function deleteArea(id) {
  return request({
    url: '/system/area/delete?id=' + id,
    method: 'delete'
  })
}

// 获得行政区划
export function getArea(id) {
  return request({
    url: '/system/area/get?id=' + id,
    method: 'get'
  })
}

// 获得行政区划分页
export function getAreaList4Query(query) {
  return request({
    url: '/system/area/getAreaList4Query',
    method: 'get',
    params: query
  })
}

// 导出行政区划 Excel
export function exportAreaExcel(query) {
  return request({
    url: '/system/area/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
//停用启用行政区划
export function updateStatus(data) {
  return request({
    url: '/system/area/updateStatus?id=' + data,
    method: 'put',
    params: data,
  })
}
//行政区划三级列表
export function getTree(){
  return request({
    url: '/system/area/tree/all',
    method: 'get',
    // params: query,
    // responseType: 'blob'
  })
}