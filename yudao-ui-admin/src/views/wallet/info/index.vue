<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="钱包编号" prop="walletNo">
        <el-input v-model="queryParams.walletNo" placeholder="请输入钱包编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="会员id" prop="memberId">
        <el-input v-model="queryParams.memberId" placeholder="请输入会员id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="queryParams.username" placeholder="请输入用户名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="queryParams.phone" placeholder="请输入手机号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="备注信息" prop="remark">
        <el-input v-model="queryParams.remark" placeholder="请输入备注信息" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态（0正常 1停用）" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态（0正常 1停用）" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
                   v-hasPermi="['wallet:info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['wallet:info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="钱包编号" align="center" prop="walletNo" />
      <el-table-column label="会员id" align="center" prop="memberId" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="备注信息" align="center" prop="remark" />
      <el-table-column label="状态（0正常 1停用）" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['wallet:info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['wallet:info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="钱包编号" prop="walletNo">
          <el-input v-model="form.walletNo" placeholder="请输入钱包编号" />
        </el-form-item>
        <el-form-item label="会员id" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员id" />
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="状态（0正常 1停用）" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
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
import { createInfo, updateInfo, deleteInfo, getInfo, getInfoPage, exportInfoExcel } from "@/api/wallet/info";

export default {
  name: "Info",
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
      // 钱包信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        walletNo: null,
        memberId: null,
        username: null,
        phone: null,
        remark: null,
        status: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [{ required: true, message: "状态（0正常 1停用）不能为空", trigger: "blur" }],
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
      getInfoPage(this.queryParams).then(response => {
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
        walletNo: undefined,
        memberId: undefined,
        username: undefined,
        phone: undefined,
        remark: undefined,
        status: undefined,
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
      this.title = "添加钱包信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改钱包信息";
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
          updateInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除钱包信息编号为"' + id + '"的数据项?').then(function() {
          return deleteInfo(id);
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
      this.$modal.confirm('是否确认导出所有钱包信息数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '钱包信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
