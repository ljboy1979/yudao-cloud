import request from '@/utils/request'

// 创建认养信息
export function createAdoptInfo(data) {
  return request({
    url: '/service/adopt-info/create',
    method: 'post',
    data: data
  })
}

// 更新认养信息
export function updateAdoptInfo(data) {
  return request({
    url: '/service/adopt-info/update',
    method: 'put',
    data: data
  })
}

// 删除认养信息
export function deleteAdoptInfo(id) {
  return request({
    url: '/service/adopt-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得认养信息
export function getAdoptInfo(id) {
  return request({
    url: '/service/adopt-info/get?id=' + id,
    method: 'get'
  })
}

// 获得认养信息分页
export function getAdoptInfoPage(query) {
  return request({
    url: '/service/adopt-info/page',
    method: 'get',
    params: query
  })
}

// 导出认养信息 Excel
export function exportAdoptInfoExcel(query) {
  return request({
    url: '/service/adopt-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
