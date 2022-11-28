import request from '@/utils/request'

// 创建原料
export function createRawMaterial(data) {
  return request({
    url: '/sales/raw-material/create',
    method: 'post',
    data: data
  })
}

// 更新原料
export function updateRawMaterial(data) {
  return request({
    url: '/sales/raw-material/update',
    method: 'put',
    data: data
  })
}

// 删除原料
export function deleteRawMaterial(id) {
  return request({
    url: '/sales/raw-material/delete?id=' + id,
    method: 'delete'
  })
}

// 获得原料
export function getRawMaterial(id) {
  return request({
    url: '/sales/raw-material/get?id=' + id,
    method: 'get'
  })
}

// 获得原料分页
export function getRawMaterialPage(query) {
  return request({
    url: '/sales/raw-material/page',
    method: 'get',
    params: query
  })
}

// 导出原料 Excel
export function exportRawMaterialExcel(query) {
  return request({
    url: '/sales/raw-material/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
