import request from '@/utils/request'

// 创建预定价格
export function createScheduledPrice(data) {
  return request({
    url: '/pricetag/scheduled-price/create',
    method: 'post',
    data: data
  })
}

// 更新预定价格
export function updateScheduledPrice(data) {
  return request({
    url: '/pricetag/scheduled-price/update',
    method: 'put',
    data: data
  })
}

// 删除预定价格
export function deleteScheduledPrice(id) {
  return request({
    url: '/pricetag/scheduled-price/delete?id=' + id,
    method: 'delete'
  })
}

// 获得预定价格
export function getScheduledPrice(id) {
  return request({
    url: '/pricetag/scheduled-price/get?id=' + id,
    method: 'get'
  })
}

// 获得预定价格分页
export function getScheduledPricePage(query) {
  return request({
    url: '/pricetag/scheduled-price/page',
    method: 'get',
    params: query
  })
}

// 导出预定价格 Excel
export function exportScheduledPriceExcel(query) {
  return request({
    url: '/pricetag/scheduled-price/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
