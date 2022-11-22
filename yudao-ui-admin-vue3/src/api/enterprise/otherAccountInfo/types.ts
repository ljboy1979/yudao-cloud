export type OtherAccountInfoVO = {
  id: number
  enterpriseId: number
  accountName: string
  accountNo: string
  accountIdCard: string
  accountBank: string
  source: number
  subjectId: number
}

export type OtherAccountInfoPageReqVO = {
  enterpriseId: number
  accountName: string
  accountNo: string
  accountIdCard: string
  accountBank: string
  source: number
  subjectId: number
  createTime: string
}

export type OtherAccountInfoExcelReqVO = {
  enterpriseId: number
  accountName: string
  accountNo: string
  accountIdCard: string
  accountBank: string
  source: number
  subjectId: number
  createTime: string
}