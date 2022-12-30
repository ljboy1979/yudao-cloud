import request from '@/utils/request'

// 创建设施货位
export function createCargoSpace(data) {
  return request({
    url: '/facility/cargo-space/create',
    method: 'post',
    data: data
  })
}

// 更新设施货位
export function updateCargoSpace(data) {
  return request({
    url: '/facility/cargo-space/update',
    method: 'put',
    data: data
  })
}

// 删除设施货位
export function deleteCargoSpace(id) {
  return request({
    url: '/facility/cargo-space/delete?id=' + id,
    method: 'delete'
  })
}

// 获得设施货位
export function getCargoSpace(id) {
  return request({
    url: '/facility/cargo-space/get?id=' + id,
    method: 'get'
  })
}

// 获得设施货位分页
export function getCargoSpacePage(query) {
  return request({
    url: '/facility/cargo-space/page',
    method: 'get',
    params: query
  })
}

// 导出设施货位 Excel
export function exportCargoSpaceExcel(query) {
  return request({
    url: '/facility/cargo-space/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
