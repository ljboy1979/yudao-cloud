import request from '@/utils/request'

// 创建会员积分记录
export function createIntegralRecord(data) {
  return request({
    url: '/member/integral-record/create',
    method: 'post',
    data: data
  })
}

// 更新会员积分记录
export function updateIntegralRecord(data) {
  return request({
    url: '/member/integral-record/update',
    method: 'put',
    data: data
  })
}

// 删除会员积分记录
export function deleteIntegralRecord(id) {
  return request({
    url: '/member/integral-record/delete?id=' + id,
    method: 'delete'
  })
}

// 获得会员积分记录
export function getIntegralRecord(id) {
  return request({
    url: '/member/integral-record/get?id=' + id,
    method: 'get'
  })
}

// 获得会员积分记录分页
export function getIntegralRecordPage(query) {
  return request({
    url: '/member/integral-record/page',
    method: 'get',
    params: query
  })
}

// 导出会员积分记录 Excel
export function exportIntegralRecordExcel(query) {
  return request({
    url: '/member/integral-record/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
