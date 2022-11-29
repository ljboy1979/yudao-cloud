import request from '@/utils/request'

// 创建原料分类
export function createRawMaterialClassify(data) {
  return request({
    url: '/sales/raw-material-classify/create',
    method: 'post',
    data: data
  })
}

// 更新原料分类
export function updateRawMaterialClassify(data) {
  return request({
    url: '/sales/raw-material-classify/update',
    method: 'put',
    data: data
  })
}

// 删除原料分类
export function deleteRawMaterialClassify(id) {
  return request({
    url: '/sales/raw-material-classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得原料分类
export function getRawMaterialClassify(id) {
  return request({
    url: '/sales/raw-material-classify/get?id=' + id,
    method: 'get'
  })
}

// 获得原料分类分页
export function getRawMaterialClassifyPage(query) {
  return request({
    url: '/sales/raw-material-classify/page',
    method: 'get',
    params: query
  })
}

// 导出原料分类 Excel
export function exportRawMaterialClassifyExcel(query) {
  return request({
    url: '/sales/raw-material-classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
