import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { DICT_TYPE } from '@/utils/dict'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
  manageStatus: [{ required: true, message: '经营状态不能为空', trigger: 'change' }],
})
// CrudSchema
const crudSchemas = reactive<CrudSchema[]>([
  {
    label: '主键ID',
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
    label: '主体编号',
    field: 'code',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '主体名称',
    field: 'name',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '主体类型',
    field: 'enterpriseType',
    dictType: DICT_TYPE.ENTERPRISE_TYPE,
    search: {
      show: true
    }
  },
  {
    label: '主体类型名称',
    field: 'enterpriseTypeName',
    form: {
      show: true,
    },
  },
  {
    label: '状态',
    field: 'stauts',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '产业角色',
    field: 'userTag',
    dictType: DICT_TYPE.USER_TAG,
    search: {
      show: true
    }
  },
  {
    label: '产业角色名称',
    field: 'userTagName',
    form: {
      show: true,
    },
  },
  {
    label: '经营状态',
    field: 'manageStatus',
    dictType: DICT_TYPE.MANAGE_STATUS,
  },
  {
    label: '注册地址',
    field: 'address',
    form: {
      show: true,
    },
  },
  {
    label: '详细地址',
    field: 'detailedAddress',
    form: {
      show: true,
    },
  },
  {
    label: '统一社会信用代码或注册号',
    field: 'socialCreditCode',
    form: {
      show: true,
    },
  },
  {
    label: '电子营业执照',
    field: 'businessCertificatePhoto',
    form: {
      show: true,
    },
  },
  {
    label: '法定代表人',
    field: 'legalPerson',
    form: {
      show: true,
    },
  },
  {
    label: '法人身份证',
    field: 'legalIdCard',
    form: {
      show: true,
    },
  },
  {
    label: '法人身份证照片',
    field: 'legalIdCardPhoto',
    form: {
      show: true,
    },
  },
  {
    label: '注册时间',
    field: 'registerTime',
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
    label: '公司简介',
    field: 'description',
    form: {
      show: true,
      component: 'Editor',
      colProps: {
        span: 24
      },
      componentProps: {
        valueHtml: ''
      }
    },
  },
  {
    label: '企业LOGO',
    field: 'logo',
    form: {
      show: true,
    },
  },
  {
    label: '经营许可证号',
    field: 'businessLicenseNo',
    form: {
      show: true,
    },
  },
  {
    label: '生产/经营许可证图片',
    field: 'businessLicensePhoto',
    form: {
      show: true,
    },
  },
  {
    label: '证件截止日期',
    field: 'businessLicenseEndTime',
    form: {
      show: true,
      component: 'DatePicker',
      componentProps: {
        type: 'datetime',
        valueFormat: 'YYYY-MM-DD HH:mm:ss'
      }
    },
  },
  {
    label: '账户名',
    field: 'accountName',
    form: {
      show: true,
    },
  },
  {
    label: '账户银行卡号',
    field: 'accountNo',
    form: {
      show: true,
    },
  },
  {
    label: '账户身份证号',
    field: 'accountIdCard',
    form: {
      show: true,
    },
  },
  {
    label: '账户开户行',
    field: 'accountBank',
    form: {
      show: true,
    },
  },
  {
    label: '联系人',
    field: 'contactName',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '联系人电话',
    field: 'contactPhone',
    form: {
      show: true,
    },
  },
  {
    label: '省id',
    field: 'villagesAreaId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '省名称',
    field: 'villagesAreaName',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '市id',
    field: 'areaId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '市名称',
    field: 'areaName',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '区id',
    field: 'ruralId',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '区名称',
    field: 'ruralName',
    form: {
      show: true,
    },
    search: {
      show: true
    }
  },
  {
    label: '企业规模',
    field: 'enterpriseScale',
    form: {
      show: true,
    },
  },
  {
    label: '主营业务',
    field: 'serviceRange',
    form: {
      show: true,
    },
  },
  {
    label: '备注',
    field: 'remarks',
    form: {
      show: true,
    },
  },
  {
    label: '租户集合',
    field: 'source',
    form: {
      show: true,
    },
  },
  {
    label: '经营主体ID',
    field: 'subjectId',
    form: {
      show: true,
    },
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