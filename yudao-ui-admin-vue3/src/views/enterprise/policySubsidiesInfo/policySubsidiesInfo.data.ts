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
    label: '补贴种类',
    field: 'subsidiesCategory',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '补贴名称',
    field: 'subsidiesName',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '补贴金额',
    field: 'subsidiesAmount',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '补贴方式',
    field: 'subsidiesType',
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
    label: '补贴状态',
    field: 'subsidiesStatus',
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
    label: '申请人',
    field: 'applyPerson',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '申请时间',
    field: 'applyTime',
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