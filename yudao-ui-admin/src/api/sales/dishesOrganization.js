import request from '@/utils/request'

// 创建菜品组成
export function createDishesOrganization(data) {
  return request({
    url: '/sales/dishes-organization/create',
    method: 'post',
    data: data
  })
}

// 更新菜品组成
export function updateDishesOrganization(data) {
  return request({
    url: '/sales/dishes-organization/update',
    method: 'put',
    data: data
  })
}

// 删除菜品组成
export function deleteDishesOrganization(id) {
  return request({
    url: '/sales/dishes-organization/delete?id=' + id,
    method: 'delete'
  })
}

// 获得菜品组成
export function getDishesOrganization(id) {
  return request({
    url: '/sales/dishes-organization/get?id=' + id,
    method: 'get'
  })
}

// 获得菜品组成分页
export function getDishesOrganizationPage(query) {
  return request({
    url: '/sales/dishes-organization/page',
    method: 'get',
    params: query
  })
}

// 导出菜品组成 Excel
export function exportDishesOrganizationExcel(query) {
  return request({
    url: '/sales/dishes-organization/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
