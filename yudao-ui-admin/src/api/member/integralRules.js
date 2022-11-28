import request from '@/utils/request'

// 创建会员积分规则
export function createIntegralRules(data) {
  return request({
    url: '/member/integral-rules/create',
    method: 'post',
    data: data
  })
}

// 更新会员积分规则
export function updateIntegralRules(data) {
  return request({
    url: '/member/integral-rules/update',
    method: 'put',
    data: data
  })
}

// 删除会员积分规则
export function deleteIntegralRules(id) {
  return request({
    url: '/member/integral-rules/delete?id=' + id,
    method: 'delete'
  })
}

// 获得会员积分规则
export function getIntegralRules(id) {
  return request({
    url: '/member/integral-rules/get?id=' + id,
    method: 'get'
  })
}

// 获得会员积分规则分页
export function getIntegralRulesPage(query) {
  return request({
    url: '/member/integral-rules/page',
    method: 'get',
    params: query
  })
}

// 导出会员积分规则 Excel
export function exportIntegralRulesExcel(query) {
  return request({
    url: '/member/integral-rules/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
