import request from '@/utils/request'

// 创建原料规格
export function createRawMaterialSpecification(data) {
  return request({
    url: '/sales/raw-material-specification/create',
    method: 'post',
    data: data
  })
}

// 更新原料规格
export function updateRawMaterialSpecification(data) {
  return request({
    url: '/sales/raw-material-specification/update',
    method: 'put',
    data: data
  })
}

// 删除原料规格
export function deleteRawMaterialSpecification(id) {
  return request({
    url: '/sales/raw-material-specification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得原料规格
export function getRawMaterialSpecification(id) {
  return request({
    url: '/sales/raw-material-specification/get?id=' + id,
    method: 'get'
  })
}

// 获得原料规格分页
export function getRawMaterialSpecificationPage(query) {
  return request({
    url: '/sales/raw-material-specification/page',
    method: 'get',
    params: query
  })
}

// 导出原料规格 Excel
export function exportRawMaterialSpecificationExcel(query) {
  return request({
    url: '/sales/raw-material-specification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
