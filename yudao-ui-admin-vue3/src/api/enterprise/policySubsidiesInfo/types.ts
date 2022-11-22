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
  createTime: string
}

export type PolicySubsidiesInfoExcelReqVO = {
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
  createTime: string
}