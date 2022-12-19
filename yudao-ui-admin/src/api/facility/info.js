import request from '@/utils/request'

// 创建设施
export function createInfo(data) {
  return request({
    url: '/facility/info/create',
    method: 'post',
    data: data
  })
}

// 更新设施
export function updateInfo(data) {
  return request({
    url: '/facility/info/update',
    method: 'put',
    data: data
  })
}

// 删除设施
export function deleteInfo(id) {
  return request({
    url: '/facility/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设施
export function getInfo(id) {
  return request({
    url: '/facility/info/get?id=' + id,
    method: 'get'
  })
}

// 获得设施分页
export function getInfoPage(query) {
  return request({
    url: '/facility/info/page',
    method: 'get',
    params: query
  })
}

// 导出设施 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/facility/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
