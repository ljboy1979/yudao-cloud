import request from '@/utils/request'

// 创建菜品分类
export function createDishesCategory(data) {
  return request({
    url: '/sales/dishes-category/create',
    method: 'post',
    data: data
  })
}

// 更新菜品分类
export function updateDishesCategory(data) {
  return request({
    url: '/sales/dishes-category/update',
    method: 'put',
    data: data
  })
}

// 删除菜品分类
export function deleteDishesCategory(id) {
  return request({
    url: '/sales/dishes-category/delete?id=' + id,
    method: 'delete'
  })
}

// 获得菜品分类
export function getDishesCategory(id) {
  return request({
    url: '/sales/dishes-category/get?id=' + id,
    method: 'get'
  })
}

// 获得菜品分类分页
export function getDishesCategoryPage(query) {
  return request({
    url: '/sales/dishes-category/page',
    method: 'get',
    params: query
  })
}

// 导出菜品分类 Excel
export function exportDishesCategoryExcel(query) {
  return request({
    url: '/sales/dishes-category/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
