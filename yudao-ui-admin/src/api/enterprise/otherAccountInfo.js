import request from '@/utils/request'

// 创建经营主体其他账户
export function createOtherAccountInfo(data) {
  return request({
    url: '/enterprise/other-account-info/create',
    method: 'post',
    data: data
  })
}

// 更新经营主体其他账户
export function updateOtherAccountInfo(data) {
  return request({
    url: '/enterprise/other-account-info/update',
    method: 'put',
    data: data
  })
}

// 删除经营主体其他账户
export function deleteOtherAccountInfo(id) {
  return request({
    url: '/enterprise/other-account-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得经营主体其他账户
export function getOtherAccountInfo(id) {
  return request({
    url: '/enterprise/other-account-info/get?id=' + id,
    method: 'get'
  })
}

// 获得经营主体其他账户分页
export function getOtherAccountInfoPage(query) {
  return request({
    url: '/enterprise/other-account-info/page',
    method: 'get',
    params: query
  })
}

// 导出经营主体其他账户 Excel
export function exportOtherAccountInfoExcel(query) {
  return request({
    url: '/enterprise/other-account-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
