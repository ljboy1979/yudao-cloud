import request from '@/utils/request'

// 创建服务
export function createInfo(data) {
  return request({
    url: '/service/info/create',
    method: 'post',
    data: data
  })
}

// 更新服务
export function updateInfo(data) {
  return request({
    url: '/service/info/update',
    method: 'put',
    data: data
  })
}

// 删除服务
export function deleteInfo(id) {
  return request({
    url: '/service/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务
export function getInfo(id) {
  return request({
    url: '/service/info/get?id=' + id,
    method: 'get'
  })
}

// 获得服务分页
export function getInfoPage(query) {
  return request({
    url: '/service/info/page',
    method: 'get',
    params: query
  })
}

// 导出服务 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/service/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
