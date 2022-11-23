export type OtherCertificateInfoVO = {
  id: number
  certificateType: number
  certificateName: string
  certificateNo: string
  certificateEndTime: string
  certificatePhoto: string
  tenantId: number
  source: number
  subjectId: number
}

export type OtherCertificateInfoPageReqVO = {
  enterpriseId: number
  certificateType: number
  certificateName: string
  certificateNo: string
  certificateEndTime: string
  certificatePhoto: string
  tenantId: number
  source: number
  subjectId: number
  createTime: string
  updateTime: string
}

export type OtherCertificateInfoExcelReqVO = {
  enterpriseId: number
  certificateType: number
  certificateName: string
  certificateNo: string
  certificateEndTime: string
  certificatePhoto: string
  tenantId: number
  source: number
  subjectId: number
  createTime: string
  updateTime: string
}