import request from '@/utils/request'

// 创建货架
export function createshelves(data) {
  return request({
    url: '/shelves/shelves/create',
    method: 'post',
    data: data
  })
}

// 更新货架
export function updateshelves(data) {
  return request({
    url: '/shelves/shelves/update',
    method: 'put',
    data: data
  })
}

// 删除货架
export function deleteshelves(id) {
  return request({
    url: '/shelves/shelves/delete?id=' + id,
    method: 'delete'
  })
}

// 获得货架
export function getshelves(id) {
  return request({
    url: '/shelves/shelves/get?id=' + id,
    method: 'get'
  })
}

// 获得货架分页
export function getshelvesPage(query) {
  return request({
    url: '/shelves/shelves/page',
    method: 'get',
    params: query
  })
}

// 导出货架 Excel
export function exportshelvesExcel(query) {
  return request({
    url: '/shelves/shelves/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
