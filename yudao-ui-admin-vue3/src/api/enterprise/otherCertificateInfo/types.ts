export type OtherCertificateInfoVO = {
  id: number
  enterpriseId: number
  certificateType: number
  certificateName: string
  certificateNo: string
  certificateEndTime: string
  certificatePhoto: string
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
  source: number
  subjectId: number
  createTime: string
}

export type OtherCertificateInfoExcelReqVO = {
  enterpriseId: number
  certificateType: number
  certificateName: string
  certificateNo: string
  certificateEndTime: string
  certificatePhoto: string
  source: number
  subjectId: number
  createTime: string
}