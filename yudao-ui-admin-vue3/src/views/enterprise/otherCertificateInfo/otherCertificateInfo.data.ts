import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { DICT_TYPE } from '@/utils/dict'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
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
    label: '经营主体ID',
    field: 'enterpriseId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '证件类型',
    field: 'certificateType',
    form: {
      show: true,
    },
    search: {
      show: true,
      component: 'Select',
      componentProps: {
        option: [{'','请选择字典生成'}]
      }
    }
  },
  {
    label: '证件名称',
    field: 'certificateName',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '证件号',
    field: 'certificateNo',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '证件截止日期',
    field: 'certificateEndTime',
    form: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetime',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
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
    label: '证件照片',
    field: 'certificatePhoto',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '租户集合',
    field: 'source',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '经营主体ID',
    field: 'subjectId',
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