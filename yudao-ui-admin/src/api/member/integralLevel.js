import request from '@/utils/request'

// 创建会员积分等级
export function createIntegralLevel(data) {
  return request({
    url: '/member/integral-level/create',
    method: 'post',
    data: data
  })
}

// 更新会员积分等级
export function updateIntegralLevel(data) {
  return request({
    url: '/member/integral-level/update',
    method: 'put',
    data: data
  })
}

// 删除会员积分等级
export function deleteIntegralLevel(id) {
  return request({
    url: '/member/integral-level/delete?id=' + id,
    method: 'delete'
  })
}

// 获得会员积分等级
export function getIntegralLevel(id) {
  return request({
    url: '/member/integral-level/get?id=' + id,
    method: 'get'
  })
}

// 获得会员积分等级分页
export function getIntegralLevelPage(query) {
  return request({
    url: '/member/integral-level/page',
    method: 'get',
    params: query
  })
}

// 导出会员积分等级 Excel
export function exportIntegralLevelExcel(query) {
  return request({
    url: '/member/integral-level/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
