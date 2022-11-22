import request from '@/utils/request'

// 创建钱包信息
export function createInfo(data) {
  return request({
    url: '/wallet/info/create',
    method: 'post',
    data: data
  })
}

// 更新钱包信息
export function updateInfo(data) {
  return request({
    url: '/wallet/info/update',
    method: 'put',
    data: data
  })
}

// 删除钱包信息
export function deleteInfo(id) {
  return request({
    url: '/wallet/info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得钱包信息
export function getInfo(id) {
  return request({
    url: '/wallet/info/get?id=' + id,
    method: 'get'
  })
}

// 获得钱包信息分页
export function getInfoPage(query) {
  return request({
    url: '/wallet/info/page',
    method: 'get',
    params: query
  })
}

// 导出钱包信息 Excel
export function exportInfoExcel(query) {
  return request({
    url: '/wallet/info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
