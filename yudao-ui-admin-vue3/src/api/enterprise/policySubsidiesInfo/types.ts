export type PolicySubsidiesInfoVO = {
  id: number
  enterpriseId: number
  subsidiesCategory: string
  subsidiesName: string
  subsidiesAmount: bigdecimal
  subsidiesType: string
  subsidiesStatus: number
  applyPerson: string
  applyTime: string
  source: number
  subjectId: number
}

export type PolicySubsidiesInfoPageReqVO = {
  subsidiesCategory: string
  subsidiesName: string
  subsidiesType: string
  subsidiesStatus: number
  applyPerson: string
  applyTime: string
  tenantId: number
  source: number
  subjectId: number
  createTime: string
  updateTime: string
}

export type PolicySubsidiesInfoExcelReqVO = {
  subsidiesCategory: string
  subsidiesName: string
  subsidiesType: string
  subsidiesStatus: number
  applyPerson: string
  applyTime: string
  tenantId: number
  source: number
  subjectId: number
  createTime: string
  updateTime: string
}