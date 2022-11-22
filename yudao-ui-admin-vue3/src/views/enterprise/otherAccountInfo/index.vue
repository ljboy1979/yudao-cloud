<script setup lang="ts">
import { ref, unref } from 'vue'
import dayjs from 'dayjs'
import { ElMessage } from 'element-plus'
import { DICT_TYPE } from '@/utils/dict'
import { useTable } from '@/hooks/web/useTable'
import { useI18n } from '@/hooks/web/useI18n'
import { FormExpose } from '@/components/Form'
import type { OtherAccountInfoVO } from '@/api/enterprise/otherAccountInfo/types'
import { rules, allSchemas } from './otherAccountInfo.data'
import * as OtherAccountInfoApi from '@/api/enterprise/otherAccountInfo'
const { t } = useI18n() // 国际化

// ========== 列表相关 ==========
const { register, tableObject, methods } = useTable<OtherAccountInfoVO>({
  getListApi: OtherAccountInfoApi.getOtherAccountInfoPageApi,
  delListApi: OtherAccountInfoApi.deleteOtherAccountInfoApi,
  exportListApi: OtherAccountInfoApi.exportOtherAccountInfoApi
})
const { getList, setSearchParams, delList, exportList } = methods

// ========== CRUD 相关 ==========
const actionLoading = ref(false) // 遮罩层
const actionType = ref('') // 操作按钮的类型
const dialogVisible = ref(false) // 是否显示弹出层
const dialogTitle = ref('edit') // 弹出层标题
const formRef = ref<FormExpose>() // 表单 Ref

// 设置标题
const setDialogTile = (type: string) => {
  dialogTitle.value = t('action.' + type)
  actionType.value = type
  dialogVisible.value = true
}

// 新增操作
const handleCreate = () => {
  setDialogTile('create')
  // 重置表单
  unref(formRef)?.getElFormRef()?.resetFields()
}

// 修改操作
const handleUpdate = async (row: OtherAccountInfoVO) => {
  setDialogTile('update')
  // 设置数据
  const res = await OtherAccountInfoApi.getOtherAccountInfoApi(row.id)
  unref(formRef)?.setValues(res)
}

// 提交按钮
const submitForm = async () => {
  const elForm = unref(formRef)?.getElFormRef()
  if (!elForm) return
  elForm.validate(async (valid) => {
    if (valid) {
      actionLoading.value = true
      // 提交请求
      try {
        const data = unref(formRef)?.formModel as OtherAccountInfoVO
        if (actionType.value === 'create') {
          await OtherAccountInfoApi.createOtherAccountInfoApi(data)
          ElMessage.success(t('common.createSuccess'))
        } else {
          await OtherAccountInfoApi.updateOtherAccountInfoApi(data)
          ElMessage.success(t('common.updateSuccess'))
        }
        // 操作成功，重新加载列表
        dialogVisible.value = false
        await getList()
      } finally {
        actionLoading.value = false
      }
    }
  })
}

// ========== 详情相关 ==========
const detailRef = ref() // 详情 Ref

// 详情操作
const handleDetail = async (row: OtherAccountInfoVO) => {
  // 设置数据
  detailRef.value = row
  setDialogTile('detail')
}

// ========== 初始化 ==========
getList()
</script>

<template>
  <!-- 搜索工作区 -->
  <ContentWrap>
    <Search :schema="allSchemas.searchSchema" @search="setSearchParams" @reset="setSearchParams" />
  </ContentWrap>
  <ContentWrap>
    <!-- 操作工具栏 -->
    <div class="mb-10px">
      <XButton
        type="primary"
        preIcon="ep:zoom-in"
        :title="t('action.add')"
        v-hasPermi="['enterprise:other-account-info:create']"
        @click="handleCreate()"
      />
      <XButton
        type="warning"
        preIcon="ep:download"
        :title="t('action.export')"
        v-hasPermi="['enterprise:other-account-info:export']"
        @click="exportList('数据.xls')"
      />
    </div>
    <!-- 列表 -->
    <Table
      :columns="allSchemas.tableColumns"
      :selection="false"
      :data="tableObject.tableList"
      :loading="tableObject.loading"
      :pagination="{
        total: tableObject.total
      }"
      v-model:pageSize="tableObject.pageSize"
      v-model:currentPage="tableObject.currentPage"
      @register="register"
    >
      <template #action="{ row }">
        <XButton
          link
          type="primary"
          preIcon="ep:edit"
          :title="t('action.edit')"
          v-hasPermi="['enterprise:other-account-info:update']"
          @click="handleUpdate(row.id)"
        />
        <XButton
          link
          type="primary"
          preIcon="ep:view"
          :title="t('action.detail')"
          v-hasPermi="['enterprise:other-account-info:update']"
          @click="handleDetail(row)"
        />
        <XButton
          link
          type="primary"
          preIcon="ep:delete"
          :title="t('action.del')"
          v-hasPermi="['enterprise:other-account-info:delete']"
          @click="handleDelete(row.id)"
        />
      </template>
    </Table>
  </ContentWrap>

  <Dialog v-model="dialogVisible" :title="dialogTitle">
    <!-- 对话框(添加 / 修改) -->
    <Form
      v-if="['create', 'update'].includes(actionType)"
      :schema="allSchemas.formSchema"
      :rules="rules"
      ref="formRef"
    />
    <!-- 对话框(详情) -->
    <Descriptions
      v-if="actionType === 'detail'"
      :schema="allSchemas.detailSchema"
      :data="detailRef"
    >
    </Descriptions>
    <!-- 操作按钮 -->
    <template #footer>
      <XButton
        v-if="['create', 'update'].includes(actionType)"
        :loading="actionLoading"
        :title="t('action.save')"
        type="primary"
        @click="submitForm"
      />
      <XButton :loading="actionLoading" :title="t('dialog.close')" @click="dialogVisible = false" />
    </template>
  </Dialog>
</template>
