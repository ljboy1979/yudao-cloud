import request from '@/config/axios'
import { OtherCertificateInfoVO, OtherCertificateInfoPageReqVO, OtherCertificateInfoExcelReqVO } from './types'

// 查询经营主体其他证件列表
export const getOtherCertificateInfoPageApi = async (params: OtherCertificateInfoPageReqVO) => {
  return await request.get({ url: '/enterprise/other-certificate-info/page', params })
}

// 查询经营主体其他证件详情
export const getOtherCertificateInfoApi = async (id: number) => {
  return await request.get({ url: '/enterprise/other-certificate-info/get?id=' + id })
}

// 新增经营主体其他证件
export const createOtherCertificateInfoApi = async (data: OtherCertificateInfoVO) => {
  return await request.post({ url: '/enterprise/other-certificate-info/create', data })
}

// 修改经营主体其他证件
export const updateOtherCertificateInfoApi = async (data: OtherCertificateInfoVO) => {
  return await request.put({ url: '/enterprise/other-certificate-info/update', data })
}

// 删除经营主体其他证件
export const deleteOtherCertificateInfoApi = async (id: number) => {
  return await request.delete({ url: '/enterprise/other-certificate-info/delete?id=' + id })
}

// 导出经营主体其他证件 Excel
export const exportOtherCertificateInfoApi = async (params: OtherCertificateInfoExcelReqVO) => {
  return await request.download({ url: '/enterprise/other-certificate-info/export-excel', params })
}
