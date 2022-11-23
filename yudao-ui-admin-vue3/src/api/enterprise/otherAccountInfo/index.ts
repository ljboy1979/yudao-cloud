import request from '@/config/axios'
import { OtherAccountInfoVO, OtherAccountInfoPageReqVO, OtherAccountInfoExcelReqVO } from './types'

// 查询经营主体其他账户列表
export const getOtherAccountInfoPageApi = async (params: OtherAccountInfoPageReqVO) => {
  return await request.get({ url: '/enterprise/other-account-info/page', params })
}

// 查询经营主体其他账户详情
export const getOtherAccountInfoApi = async (id: number) => {
  return await request.get({ url: '/enterprise/other-account-info/get?id=' + id })
}

// 新增经营主体其他账户
export const createOtherAccountInfoApi = async (data: OtherAccountInfoVO) => {
  return await request.post({ url: '/enterprise/other-account-info/create', data })
}

// 修改经营主体其他账户
export const updateOtherAccountInfoApi = async (data: OtherAccountInfoVO) => {
  return await request.put({ url: '/enterprise/other-account-info/update', data })
}

// 删除经营主体其他账户
export const deleteOtherAccountInfoApi = async (id: number) => {
  return await request.delete({ url: '/enterprise/other-account-info/delete?id=' + id })
}

// 导出经营主体其他账户 Excel
export const exportOtherAccountInfoApi = async (params: OtherAccountInfoExcelReqVO) => {
  return await request.download({ url: '/enterprise/other-account-info/export-excel', params })
}
