import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { DICT_TYPE } from '@/utils/dict'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  inquiryNo: [{ required: true, message: '询价单编号不能为空', trigger: 'blur' }],
  productId: [{ required: true, message: '商品id不能为空', trigger: 'blur' }],
  classifyId: [{ required: true, message: '分类id不能为空', trigger: 'blur' }],
  subjectId: [{ required: true, message: '经营主体不能为空', trigger: 'blur' }],
})
// CrudSchema
const crudSchemas = reactive<CrudSchema[]>([
  {
    label: '编号',
    field: 'id',
    type: 'index',
    form: {
      show: false
    },
    detail: {
      show: false
    }
  },
  {
    label: '询价单编号',
    field: 'inquiryNo',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '商品id',
    field: 'productId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '分类id',
    field: 'classifyId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '规格id',
    field: 'specificationsId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '计划数量最低',
    field: 'lowestPlannedQuantity',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '计划数量最高',
    field: 'highestPlannedQuantity',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '创建时间',
    field: 'createTime',
    form: {
      show: false
    },
    search: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetimerange',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    }
  },
  {
    label: '经营主体',
    field: 'subjectId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: t('table.action'),
    field: 'action',
    width: '240px',
    form: {
      show: false
    },
    detail: {
      show: false
    }
  }
])

export const { allSchemas } = useCrudSchemas(crudSchemas)