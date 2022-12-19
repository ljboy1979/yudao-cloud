import request from '@/utils/request'

// 创建设备参数配置
export function createParamsCfg(data) {
  return request({
    url: '/devices/params-cfg/create',
    method: 'post',
    data: data
  })
}

// 更新设备参数配置
export function updateParamsCfg(data) {
  return request({
    url: '/devices/params-cfg/update',
    method: 'put',
    data: data
  })
}

// 删除设备参数配置
export function deleteParamsCfg(id) {
  return request({
    url: '/devices/params-cfg/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设备参数配置
export function getParamsCfg(id) {
  return request({
    url: '/devices/params-cfg/get?id=' + id,
    method: 'get'
  })
}

// 获得设备参数配置分页
export function getParamsCfgPage(query) {
  return request({
    url: '/devices/params-cfg/page',
    method: 'get',
    params: query
  })
}

// 导出设备参数配置 Excel
export function exportParamsCfgExcel(query) {
  return request({
    url: '/devices/params-cfg/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
