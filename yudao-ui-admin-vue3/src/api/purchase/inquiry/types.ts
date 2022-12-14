export type InquiryVO = {
  id: number
  inquiryNo: string
  productId: number
  classifyId: number
  specificationsId: number
  lowestPlannedQuantity: number
  highestPlannedQuantity: number
  subjectId: string
}

export type InquiryPageReqVO = {
  inquiryNo: string
  productId: number
  classifyId: number
  specificationsId: number
  lowestPlannedQuantity: number
  highestPlannedQuantity: number
  createTime: string
  subjectId: string
}

export type InquiryExcelReqVO = {
  inquiryNo: string
  productId: number
  classifyId: number
  specificationsId: number
  lowestPlannedQuantity: number
  highestPlannedQuantity: number
  createTime: string
  subjectId: string
}