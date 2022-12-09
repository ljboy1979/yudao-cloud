import request from '@/utils/request'

// 创建认养物/租凭物
export function createAdoptContent(data) {
  return request({
    url: '/resource/adopt-content/create',
    method: 'post',
    data: data
  })
}

// 更新认养物/租凭物
export function updateAdoptContent(data) {
  return request({
    url: '/resource/adopt-content/update',
    method: 'put',
    data: data
  })
}

// 删除认养物/租凭物
export function deleteAdoptContent(id) {
  return request({
    url: '/resource/adopt-content/delete?id=' + id,
    method: 'delete'
  })
}

// 获得认养物/租凭物
export function getAdoptContent(id) {
  return request({
    url: '/resource/adopt-content/get?id=' + id,
    method: 'get'
  })
}

// 获得认养物/租凭物分页
export function getAdoptContentPage(query) {
  return request({
    url: '/resource/adopt-content/page',
    method: 'get',
    params: query
  })
}

// 导出认养物/租凭物 Excel
export function exportAdoptContentExcel(query) {
  return request({
    url: '/resource/adopt-content/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
