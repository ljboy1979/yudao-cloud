import request from '@/utils/request'

// 创建租赁合同
export function createContract(data) {
  return request({
    url: '/facility/contract/create',
    method: 'post',
    data: data
  })
}

// 更新租赁合同
export function updateContract(data) {
  return request({
    url: '/facility/contract/update',
    method: 'put',
    data: data
  })
}

// 删除租赁合同
export function deleteContract(id) {
  return request({
    url: '/facility/contract/delete?id=' + id,
    method: 'delete'
  })
}

// 获得租赁合同
export function getContract(id) {
  return request({
    url: '/facility/contract/get?id=' + id,
    method: 'get'
  })
}

// 获得租赁合同分页
export function getContractPage(query) {
  return request({
    url: '/facility/contract/page',
    method: 'get',
    params: query
  })
}

// 导出租赁合同 Excel
export function exportContractExcel(query) {
  return request({
    url: '/facility/contract/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
