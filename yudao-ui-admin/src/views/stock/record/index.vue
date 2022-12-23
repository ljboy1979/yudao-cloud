<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="库存类型(1.原料 2.投入品 3.成品 4.办公用品)" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择库存类型(1.原料 2.投入品 3.成品 4.办公用品)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="操作类型(0.入库 1.出库)" prop="operationType">
        <el-select v-model="queryParams.operationType" placeholder="请选择操作类型(0.入库 1.出库)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="仓库id" prop="warehouseId">
        <el-input v-model="queryParams.warehouseId" placeholder="请输入仓库id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="仓库编号" prop="warehouseCode">
        <el-input v-model="queryParams.warehouseCode" placeholder="请输入仓库编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="仓库名称" prop="warehouseName">
        <el-input v-model="queryParams.warehouseName" placeholder="请输入仓库名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="批次号" prop="batchNo">
        <el-input v-model="queryParams.batchNo" placeholder="请输入批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="操作时间" prop="operationTime">
        <el-date-picker v-model="queryParams.operationTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="负责人id" prop="headId">
        <el-input v-model="queryParams.headId" placeholder="请输入负责人id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="负责人名称" prop="headName">
        <el-input v-model="queryParams.headName" placeholder="请输入负责人名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="经营主体" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input v-model="queryParams.userId" placeholder="请输入用户id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户集合" prop="sourceId">
        <el-input v-model="queryParams.sourceId" placeholder="请输入租户集合" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['stock:record:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['stock:record:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="库存记录id" align="center" prop="id" />
      <el-table-column label="库存类型(1.原料 2.投入品 3.成品 4.办公用品)" align="center" prop="type" />
      <el-table-column label="操作类型(0.入库 1.出库)" align="center" prop="operationType" />
      <el-table-column label="仓库id" align="center" prop="warehouseId" />
      <el-table-column label="仓库编号" align="center" prop="warehouseCode" />
      <el-table-column label="仓库名称" align="center" prop="warehouseName" />
      <el-table-column label="批次号" align="center" prop="batchNo" />
      <el-table-column label="操作时间" align="center" prop="operationTime" />
      <el-table-column label="负责人id" align="center" prop="headId" />
      <el-table-column label="负责人名称" align="center" prop="headName" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="租户集合" align="center" prop="sourceId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['stock:record:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['stock:record:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="库存类型(1.原料 2.投入品 3.成品 4.办公用品)" prop="type">
          <el-select v-model="form.type" placeholder="请选择库存类型(1.原料 2.投入品 3.成品 4.办公用品)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="操作类型(0.入库 1.出库)" prop="operationType">
          <el-radio-group v-model="form.operationType">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="仓库id" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入仓库id" />
        </el-form-item>
        <el-form-item label="仓库编号" prop="warehouseCode">
          <el-input v-model="form.warehouseCode" placeholder="请输入仓库编号" />
        </el-form-item>
        <el-form-item label="仓库名称" prop="warehouseName">
          <el-input v-model="form.warehouseName" placeholder="请输入仓库名称" />
        </el-form-item>
        <el-form-item label="批次号" prop="batchNo">
          <el-input v-model="form.batchNo" placeholder="请输入批次号" />
        </el-form-item>
        <el-form-item label="操作时间" prop="operationTime">
          <el-date-picker clearable v-model="form.operationTime" type="date" value-format="timestamp" placeholder="选择操作时间" />
        </el-form-item>
        <el-form-item label="负责人id" prop="headId">
          <el-input v-model="form.headId" placeholder="请输入负责人id" />
        </el-form-item>
        <el-form-item label="负责人名称" prop="headName">
          <el-input v-model="form.headName" placeholder="请输入负责人名称" />
        </el-form-item>
        <el-form-item label="经营主体" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="租户集合" prop="sourceId">
          <el-input v-model="form.sourceId" placeholder="请输入租户集合" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createRecord, updateRecord, deleteRecord, getRecord, getRecordPage, exportRecordExcel } from "@/api/stock/record";

export default {
  name: "Record",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 库存记录列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        type: null,
        operationType: null,
        warehouseId: null,
        warehouseCode: null,
        warehouseName: null,
        batchNo: null,
        operationTime: [],
        headId: null,
        headName: null,
        createTime: [],
        subjectId: null,
        userId: null,
        sourceId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        type: [{ required: true, message: "库存类型(1.原料 2.投入品 3.成品 4.办公用品)不能为空", trigger: "change" }],
        operationType: [{ required: true, message: "操作类型(0.入库 1.出库)不能为空", trigger: "blur" }],
        warehouseId: [{ required: true, message: "仓库id不能为空", trigger: "blur" }],
        warehouseCode: [{ required: true, message: "仓库编号不能为空", trigger: "blur" }],
        warehouseName: [{ required: true, message: "仓库名称不能为空", trigger: "blur" }],
        subjectId: [{ required: true, message: "经营主体不能为空", trigger: "blur" }],
        userId: [{ required: true, message: "用户id不能为空", trigger: "blur" }],
        sourceId: [{ required: true, message: "租户集合不能为空", trigger: "blur" }],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getRecordPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        type: undefined,
        operationType: undefined,
        warehouseId: undefined,
        warehouseCode: undefined,
        warehouseName: undefined,
        batchNo: undefined,
        operationTime: undefined,
        headId: undefined,
        headName: undefined,
        subjectId: undefined,
        userId: undefined,
        sourceId: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加库存记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改库存记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          updateRecord(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createRecord(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除库存记录编号为"' + id + '"的数据项?').then(function() {
          return deleteRecord(id);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有库存记录数据项?').then(() => {
          this.exportLoading = true;
          return exportRecordExcel(params);
        }).then(response => {
          this.$download.excel(response, '库存记录.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
