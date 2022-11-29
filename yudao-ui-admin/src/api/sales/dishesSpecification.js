import request from '@/utils/request'

// 创建菜品规格
export function createDishesSpecification(data) {
  return request({
    url: '/sales/dishes-specification/create',
    method: 'post',
    data: data
  })
}

// 更新菜品规格
export function updateDishesSpecification(data) {
  return request({
    url: '/sales/dishes-specification/update',
    method: 'put',
    data: data
  })
}

// 删除菜品规格
export function deleteDishesSpecification(id) {
  return request({
    url: '/sales/dishes-specification/delete?id=' + id,
    method: 'delete'
  })
}

// 获得菜品规格
export function getDishesSpecification(id) {
  return request({
    url: '/sales/dishes-specification/get?id=' + id,
    method: 'get'
  })
}

// 获得菜品规格分页
export function getDishesSpecificationPage(query) {
  return request({
    url: '/sales/dishes-specification/page',
    method: 'get',
    params: query
  })
}

// 导出菜品规格 Excel
export function exportDishesSpecificationExcel(query) {
  return request({
    url: '/sales/dishes-specification/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
