<script setup lang="ts">
import { ref, unref } from 'vue'
import dayjs from 'dayjs'
import { ElMessage } from 'element-plus'
import { DICT_TYPE } from '@/utils/dict'
import { useTable } from '@/hooks/web/useTable'
import { useI18n } from '@/hooks/web/useI18n'
import { FormExpose } from '@/components/Form'
import type { BaseInfoVO } from '@/api/enterprise/baseInfo/types'
import { rules, allSchemas } from './baseInfo.data'
import * as BaseInfoApi from '@/api/enterprise/baseInfo'
const { t } = useI18n() // 国际化

// ========== 列表相关 ==========
const { register, tableObject, methods } = useTable<BaseInfoVO>({
  getListApi: BaseInfoApi.getBaseInfoPageApi,
  delListApi: BaseInfoApi.deleteBaseInfoApi,
  exportListApi: BaseInfoApi.exportBaseInfoApi
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
const handleUpdate = async (row: BaseInfoVO) => {
  setDialogTile('update')
  // 设置数据
  const res = await BaseInfoApi.getBaseInfoApi(row.id)
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
        const data = unref(formRef)?.formModel as BaseInfoVO
        if (actionType.value === 'create') {
          await BaseInfoApi.createBaseInfoApi(data)
          ElMessage.success(t('common.createSuccess'))
        } else {
          await BaseInfoApi.updateBaseInfoApi(data)
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
const handleDetail = async (row: BaseInfoVO) => {
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
        v-hasPermi="['enterprise:base-info:create']"
        @click="handleCreate()"
      />
      <XButton
        type="warning"
        preIcon="ep:download"
        :title="t('action.export')"
        v-hasPermi="['enterprise:base-info:export']"
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
          v-hasPermi="['enterprise:base-info:update']"
          @click="handleUpdate(row.id)"
        />
        <XButton
          link
          type="primary"
          preIcon="ep:view"
          :title="t('action.detail')"
          v-hasPermi="['enterprise:base-info:update']"
          @click="handleDetail(row)"
        />
        <XButton
          link
          type="primary"
          preIcon="ep:delete"
          :title="t('action.del')"
          v-hasPermi="['enterprise:base-info:delete']"
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
