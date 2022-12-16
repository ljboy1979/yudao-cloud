import request from '@/utils/request'

// 创建产能计划
export function createProductionCapacityPlans(data) {
  return request({
    url: '/bases/production-capacity-plans/create',
    method: 'post',
    data: data
  })
}

// 更新产能计划
export function updateProductionCapacityPlans(data) {
  return request({
    url: '/bases/production-capacity-plans/update',
    method: 'put',
    data: data
  })
}

// 删除产能计划
export function deleteProductionCapacityPlans(id) {
  return request({
    url: '/bases/production-capacity-plans/delete?id=' + id,
    method: 'delete'
  })
}

// 获得产能计划
export function getProductionCapacityPlans(id) {
  return request({
    url: '/bases/production-capacity-plans/get?id=' + id,
    method: 'get'
  })
}

// 获得产能计划分页
export function getProductionCapacityPlansPage(query) {
  return request({
    url: '/bases/production-capacity-plans/page',
    method: 'get',
    params: query
  })
}

// 导出产能计划 Excel
export function exportProductionCapacityPlansExcel(query) {
  return request({
    url: '/bases/production-capacity-plans/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
