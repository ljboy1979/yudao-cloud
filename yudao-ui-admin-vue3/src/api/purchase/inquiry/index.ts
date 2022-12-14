import request from '@/config/axios'
import { InquiryVO, InquiryPageReqVO, InquiryExcelReqVO } from './types'

// 查询采购询价电子列表
export const getInquiryPageApi = async (params: InquiryPageReqVO) => {
  return await request.get({ url: '/purchase/inquiry/page', params })
}

// 查询采购询价电子详情
export const getInquiryApi = async (id: number) => {
  return await request.get({ url: '/purchase/inquiry/get?id=' + id })
}

// 新增采购询价电子
export const createInquiryApi = async (data: InquiryVO) => {
  return await request.post({ url: '/purchase/inquiry/create', data })
}

// 修改采购询价电子
export const updateInquiryApi = async (data: InquiryVO) => {
  return await request.put({ url: '/purchase/inquiry/update', data })
}

// 删除采购询价电子
export const deleteInquiryApi = async (id: number) => {
  return await request.delete({ url: '/purchase/inquiry/delete?id=' + id })
}

// 导出采购询价电子 Excel
export const exportInquiryApi = async (params: InquiryExcelReqVO) => {
  return await request.download({ url: '/purchase/inquiry/export-excel', params })
}
