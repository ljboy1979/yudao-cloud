import request from '@/utils/request'

// 创建经营主体
export function createBaseInfo(data) {
  return request({
    url: '/enterprise/base-info/create',
    method: 'post',
    data: data
  })
}

// 更新经营主体
export function updateBaseInfo(data) {
  return request({
    url: '/enterprise/base-info/update',
    method: 'put',
    data: data
  })
}

// 删除经营主体
export function deleteBaseInfo(id) {
  return request({
    url: '/enterprise/base-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得经营主体
export function getBaseInfo(id) {
  return request({
    url: '/enterprise/base-info/get?id=' + id,
    method: 'get'
  })
}

// 获得经营主体分页
export function getBaseInfoPage(query) {
  return request({
    url: '/enterprise/base-info/page',
    method: 'get',
    params: query
  })
}

// 停用经营主体分页
export function stopBaseInfoPage(id) {
  return request({
    url: '/enterprise/base-info/stop?id=' + id,
    method: 'put',
    // params: query
  })
}
//改变经营主体启用停用状态
export function changeStatusBaseInfoPage(id){
  return request({
    url: '/enterprise/base-info/changeStatus?id=' + id,
    method: 'put',
    // params: query
  })
}
// 导出经营主体 Excel
export function exportBaseInfoExcel(query) {
  return request({
    url: '/enterprise/base-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}


