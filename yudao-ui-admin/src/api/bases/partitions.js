import request from '@/utils/request'

// 创建分区信息
export function createPartitions(data) {
  return request({
    url: '/bases/partitions/create',
    method: 'post',
    data: data
  })
}

// 更新分区信息
export function updatePartitions(data) {
  return request({
    url: '/bases/partitions/update',
    method: 'put',
    data: data
  })
}

// 删除分区信息
export function deletePartitions(id) {
  return request({
    url: '/bases/partitions/delete?id=' + id,
    method: 'delete'
  })
}

// 获得分区信息
export function getPartitions(id) {
  return request({
    url: '/bases/partitions/get?id=' + id,
    method: 'get'
  })
}

// 获得分区信息分页
export function getPartitionsPage(query) {
  return request({
    url: '/bases/partitions/page',
    method: 'get',
    params: query
  })
}

// 导出分区信息 Excel
export function exportPartitionsExcel(query) {
  return request({
    url: '/bases/partitions/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
