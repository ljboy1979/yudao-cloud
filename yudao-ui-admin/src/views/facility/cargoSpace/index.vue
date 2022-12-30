<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="货位号" prop="code">
        <el-input v-model="queryParams.code" placeholder="请输入货位号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="行数" prop="rowNumber">
        <el-input v-model="queryParams.rowNumber" placeholder="请输入行数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="列数" prop="columnNumber">
        <el-input v-model="queryParams.columnNumber" placeholder="请输入列数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="层数" prop="layerNumber">
        <el-input v-model="queryParams.layerNumber" placeholder="请输入层数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设施" prop="facilityId">
        <el-input v-model="queryParams.facilityId" placeholder="请输入设施" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户集合" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入租户集合" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经营主体ID" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体ID" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['facility:cargo-space:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['facility:cargo-space:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="货位号" align="center" prop="code" />
      <el-table-column label="行数" align="center" prop="rowNumber" />
      <el-table-column label="列数" align="center" prop="columnNumber" />
      <el-table-column label="层数" align="center" prop="layerNumber" />
      <el-table-column label="设施" align="center" prop="facilityId" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['facility:cargo-space:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['facility:cargo-space:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="货位号" prop="code">
          <el-input v-model="form.code" placeholder="请输入货位号" />
        </el-form-item>
        <el-form-item label="行数" prop="rowNumber">
          <el-input v-model="form.rowNumber" placeholder="请输入行数" />
        </el-form-item>
        <el-form-item label="列数" prop="columnNumber">
          <el-input v-model="form.columnNumber" placeholder="请输入列数" />
        </el-form-item>
        <el-form-item label="层数" prop="layerNumber">
          <el-input v-model="form.layerNumber" placeholder="请输入层数" />
        </el-form-item>
        <el-form-item label="设施" prop="facilityId">
          <el-input v-model="form.facilityId" placeholder="请输入设施" />
        </el-form-item>
        <el-form-item label="租户集合" prop="source">
          <el-input v-model="form.source" placeholder="请输入租户集合" />
        </el-form-item>
        <el-form-item label="经营主体ID" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体ID" />
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
import { createCargoSpace, updateCargoSpace, deleteCargoSpace, getCargoSpace, getCargoSpacePage, exportCargoSpaceExcel } from "@/api/facility/cargoSpace";

export default {
  name: "CargoSpace",
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
      // 设施货位列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        code: null,
        rowNumber: null,
        columnNumber: null,
        layerNumber: null,
        facilityId: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
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
      getCargoSpacePage(this.queryParams).then(response => {
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
        code: undefined,
        rowNumber: undefined,
        columnNumber: undefined,
        layerNumber: undefined,
        facilityId: undefined,
        source: undefined,
        subjectId: undefined,
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
      this.title = "添加设施货位";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getCargoSpace(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设施货位";
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
          updateCargoSpace(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createCargoSpace(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除设施货位编号为"' + id + '"的数据项?').then(function() {
          return deleteCargoSpace(id);
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
      this.$modal.confirm('是否确认导出所有设施货位数据项?').then(() => {
          this.exportLoading = true;
          return exportCargoSpaceExcel(params);
        }).then(response => {
          this.$download.excel(response, '设施货位.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
