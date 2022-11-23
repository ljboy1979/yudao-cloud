import request from '@/config/axios'
import { BaseInfoVO, BaseInfoPageReqVO, BaseInfoExcelReqVO } from './types'

// 查询经营主体列表
export const getBaseInfoPageApi = async (params: BaseInfoPageReqVO) => {
  return await request.get({ url: '/enterprise/base-info/page', params })
}

// 查询经营主体详情
export const getBaseInfoApi = async (id: number) => {
  return await request.get({ url: '/enterprise/base-info/get?id=' + id })
}

// 新增经营主体
export const createBaseInfoApi = async (data: BaseInfoVO) => {
  return await request.post({ url: '/enterprise/base-info/create', data })
}

// 修改经营主体
export const updateBaseInfoApi = async (data: BaseInfoVO) => {
  return await request.put({ url: '/enterprise/base-info/update', data })
}

// 删除经营主体
export const deleteBaseInfoApi = async (id: number) => {
  return await request.delete({ url: '/enterprise/base-info/delete?id=' + id })
}

// 导出经营主体 Excel
export const exportBaseInfoApi = async (params: BaseInfoExcelReqVO) => {
  return await request.download({ url: '/enterprise/base-info/export-excel', params })
}
