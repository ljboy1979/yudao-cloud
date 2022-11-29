import request from '@/utils/request'

// 创建投入品规格
export function createInputsInfoSpecification(data) {
  return request({
    url: '/sales/inputs-info-specification/create',
    method: 'post',
    data: data
  })
}

// 更新投入品规格
export function updateInputsInfoSpecification(data) {
  return request({
    url: '/sales/inputs-info-specification/update',
    method: 'put',
    data: data
  })
}

// 删除投入品规格
export function deleteInputsInfoSpecification(id) {
  return request({
    url: '/sales/inputs-info-specification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得投入品规格
export function getInputsInfoSpecification(id) {
  return request({
    url: '/sales/inputs-info-specification/get?id=' + id,
    method: 'get'
  })
}

// 获得投入品规格分页
export function getInputsInfoSpecificationPage(query) {
  return request({
    url: '/sales/inputs-info-specification/page',
    method: 'get',
    params: query
  })
}

// 导出投入品规格 Excel
export function exportInputsInfoSpecificationExcel(query) {
  return request({
    url: '/sales/inputs-info-specification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
