import request from '@/utils/request'

// 创建菜品
export function createDishes(data) {
  return request({
    url: '/sales/dishes/create',
    method: 'post',
    data: data
  })
}

// 更新菜品
export function updateDishes(data) {
  return request({
    url: '/sales/dishes/update',
    method: 'put',
    data: data
  })
}

// 删除菜品
export function deleteDishes(id) {
  return request({
    url: '/sales/dishes/delete?id=' + id,
    method: 'delete'
  })
}

// 获得菜品
export function getDishes(id) {
  return request({
    url: '/sales/dishes/get?id=' + id,
    method: 'get'
  })
}

// 获得菜品分页
export function getDishesPage(query) {
  return request({
    url: '/sales/dishes/page',
    method: 'get',
    params: query
  })
}

// 导出菜品 Excel
export function exportDishesExcel(query) {
  return request({
    url: '/sales/dishes/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
