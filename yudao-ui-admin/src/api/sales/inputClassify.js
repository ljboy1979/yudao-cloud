import request from '@/utils/request'

// 创建投入品分类
export function createInputClassify(data) {
  return request({
    url: '/sales/input-classify/create',
    method: 'post',
    data: data
  })
}

// 更新投入品分类
export function updateInputClassify(data) {
  return request({
    url: '/sales/input-classify/update',
    method: 'put',
    data: data
  })
}

// 删除投入品分类
export function deleteInputClassify(id) {
  return request({
    url: '/sales/input-classify/delete?id=' + id,
    method: 'delete'
  })
}

// 获得投入品分类
export function getInputClassify(id) {
  return request({
    url: '/sales/input-classify/get?id=' + id,
    method: 'get'
  })
}

// 获得投入品分类分页
export function getInputClassifyPage(query) {
  return request({
    url: '/sales/input-classify/page',
    method: 'get',
    params: query
  })
}

// 导出投入品分类 Excel
export function exportInputClassifyExcel(query) {
  return request({
    url: '/sales/input-classify/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
