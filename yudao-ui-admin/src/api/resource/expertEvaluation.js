import request from '@/utils/request'

// 创建健康状况
export function createExpertEvaluation(data) {
  return request({
    url: '/resource/expert-evaluation/create',
    method: 'post',
    data: data
  })
}

// 更新健康状况
export function updateExpertEvaluation(data) {
  return request({
    url: '/resource/expert-evaluation/update',
    method: 'put',
    data: data
  })
}

// 删除健康状况
export function deleteExpertEvaluation(id) {
  return request({
    url: '/resource/expert-evaluation/delete?id=' + id,
    method: 'delete'
  })
}

// 获得健康状况
export function getExpertEvaluation(id) {
  return request({
    url: '/resource/expert-evaluation/get?id=' + id,
    method: 'get'
  })
}

// 获得健康状况分页
export function getExpertEvaluationPage(query) {
  return request({
    url: '/resource/expert-evaluation/page',
    method: 'get',
    params: query
  })
}

// 导出健康状况 Excel
export function exportExpertEvaluationExcel(query) {
  return request({
    url: '/resource/expert-evaluation/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
