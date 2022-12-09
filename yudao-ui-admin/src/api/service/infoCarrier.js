import request from '@/utils/request'

// 创建服务-认养物/租凭物
export function createInfoCarrier(data) {
  return request({
    url: '/service/info-carrier/create',
    method: 'post',
    data: data
  })
}

// 更新服务-认养物/租凭物
export function updateInfoCarrier(data) {
  return request({
    url: '/service/info-carrier/update',
    method: 'put',
    data: data
  })
}

// 删除服务-认养物/租凭物
export function deleteInfoCarrier(id) {
  return request({
    url: '/service/info-carrier/delete?id=' + id,
    method: 'delete'
  })
}

// 获得服务-认养物/租凭物
export function getInfoCarrier(id) {
  return request({
    url: '/service/info-carrier/get?id=' + id,
    method: 'get'
  })
}

// 获得服务-认养物/租凭物分页
export function getInfoCarrierPage(query) {
  return request({
    url: '/service/info-carrier/page',
    method: 'get',
    params: query
  })
}

// 导出服务-认养物/租凭物 Excel
export function exportInfoCarrierExcel(query) {
  return request({
    url: '/service/info-carrier/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
