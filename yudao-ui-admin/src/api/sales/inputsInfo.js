import request from '@/utils/request'

// 创建投入品
export function createInputsInfo(data) {
  return request({
    url: '/sales/inputs-info/create',
    method: 'post',
    data: data
  })
}

// 更新投入品
export function updateInputsInfo(data) {
  return request({
    url: '/sales/inputs-info/update',
    method: 'put',
    data: data
  })
}

// 删除投入品
export function deleteInputsInfo(id) {
  return request({
    url: '/sales/inputs-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得投入品
export function getInputsInfo(id) {
  return request({
    url: '/sales/inputs-info/get?id=' + id,
    method: 'get'
  })
}

// 获得投入品分页
export function getInputsInfoPage(query) {
  return request({
    url: '/sales/inputs-info/page',
    method: 'get',
    params: query
  })
}

// 导出投入品 Excel
export function exportInputsInfoExcel(query) {
  return request({
    url: '/sales/inputs-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
