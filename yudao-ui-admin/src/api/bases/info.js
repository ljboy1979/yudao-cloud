import request from '@/utils/request'

// 创建基地信息
export function createInfo(data) {
  return request({
    url: '/bases/info/create',
    method: 'post',
    data: data
  })
}

// 更新基地信息
export function updateInfo(data) {
  return request({
    url: '/bases/info/update',
    method: 'put',
    data: data
  })
}

// 删除基地信息
export function deleteInfo(id) {
  return request({
    url: '/bases/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得基地信息
export function getInfo(id) {
  return request({
    url: '/bases/info/get?id=' + id,
    method: 'get'
  })
}

// 获得基地信息分页
export function getInfoPage(query) {
  return request({
    url: '/bases/info/page',
    method: 'get',
    params: query
  })
}

// 导出基地信息 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/bases/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
