import request from '@/utils/request'

// 创建认养/租凭权益
export function createAdoptRight(data) {
  return request({
    url: '/resource/adopt-right/create',
    method: 'post',
    data: data
  })
}

// 更新认养/租凭权益
export function updateAdoptRight(data) {
  return request({
    url: '/resource/adopt-right/update',
    method: 'put',
    data: data
  })
}

// 删除认养/租凭权益
export function deleteAdoptRight(id) {
  return request({
    url: '/resource/adopt-right/delete?id=' + id,
    method: 'delete'
  })
}

// 获得认养/租凭权益
export function getAdoptRight(id) {
  return request({
    url: '/resource/adopt-right/get?id=' + id,
    method: 'get'
  })
}

// 获得认养/租凭权益分页
export function getAdoptRightPage(query) {
  return request({
    url: '/resource/adopt-right/page',
    method: 'get',
    params: query
  })
}

// 导出认养/租凭权益 Excel
export function exportAdoptRightExcel(query) {
  return request({
    url: '/resource/adopt-right/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
