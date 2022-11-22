import request from '@/config/axios'
import { PolicySubsidiesInfoVO, PolicySubsidiesInfoPageReqVO, PolicySubsidiesInfoExcelReqVO } from './types'

// 查询企业政策补贴信息列表
export const getPolicySubsidiesInfoPageApi = async (params: PolicySubsidiesInfoPageReqVO) => {
  return await request.get({ url: '/enterprise/policy-subsidies-info/page', params })
}

// 查询企业政策补贴信息详情
export const getPolicySubsidiesInfoApi = async (id: number) => {
  return await request.get({ url: '/enterprise/policy-subsidies-info/get?id=' + id })
}

// 新增企业政策补贴信息
export const createPolicySubsidiesInfoApi = async (data: PolicySubsidiesInfoVO) => {
  return await request.post({ url: '/enterprise/policy-subsidies-info/create', data })
}

// 修改企业政策补贴信息
export const updatePolicySubsidiesInfoApi = async (data: PolicySubsidiesInfoVO) => {
  return await request.put({ url: '/enterprise/policy-subsidies-info/update', data })
}

// 删除企业政策补贴信息
export const deletePolicySubsidiesInfoApi = async (id: number) => {
  return await request.delete({ url: '/enterprise/policy-subsidies-info/delete?id=' + id })
}

// 导出企业政策补贴信息 Excel
export const exportPolicySubsidiesInfoApi = async (params: PolicySubsidiesInfoExcelReqVO) => {
  return await request.download({ url: '/enterprise/policy-subsidies-info/export-excel', params })
}
