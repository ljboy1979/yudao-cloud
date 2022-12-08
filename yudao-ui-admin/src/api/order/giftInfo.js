import request from '@/utils/request'

// 创建赠品
export function createGiftInfo(data) {
  return request({
    url: '/order/gift-info/create',
    method: 'post',
    data: data
  })
}

// 更新赠品
export function updateGiftInfo(data) {
  return request({
    url: '/order/gift-info/update',
    method: 'put',
    data: data
  })
}

// 删除赠品
export function deleteGiftInfo(id) {
  return request({
    url: '/order/gift-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得赠品
export function getGiftInfo(id) {
  return request({
    url: '/order/gift-info/get?id=' + id,
    method: 'get'
  })
}

// 获得赠品分页
export function getGiftInfoPage(query) {
  return request({
    url: '/order/gift-info/page',
    method: 'get',
    params: query
  })
}

// 导出赠品 Excel
export function exportGiftInfoExcel(query) {
  return request({
    url: '/order/gift-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
