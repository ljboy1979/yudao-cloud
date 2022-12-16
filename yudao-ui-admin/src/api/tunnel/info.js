import request from '@/utils/request'

// 创建地块信息
export function createInfo(data) {
  return request({
    url: '/tunnel/info/create',
    method: 'post',
    data: data
  })
}

// 更新地块信息
export function updateInfo(data) {
  return request({
    url: '/tunnel/info/update',
    method: 'put',
    data: data
  })
}

// 删除地块信息
export function deleteInfo(id) {
  return request({
    url: '/tunnel/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得地块信息
export function getInfo(id) {
  return request({
    url: '/tunnel/info/get?id=' + id,
    method: 'get'
  })
}

// 获得地块信息分页
export function getInfoPage(query) {
  return request({
    url: '/tunnel/info/page',
    method: 'get',
    params: query
  })
}

// 导出地块信息 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/tunnel/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
