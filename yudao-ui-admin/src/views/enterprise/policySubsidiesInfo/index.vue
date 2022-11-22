<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="经营主体ID" prop="enterpriseId">
        <el-input v-model="queryParams.enterpriseId" placeholder="请输入经营主体ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="补贴种类" prop="subsidiesCategory">
        <el-input v-model="queryParams.subsidiesCategory" placeholder="请输入补贴种类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="补贴名称" prop="subsidiesName">
        <el-input v-model="queryParams.subsidiesName" placeholder="请输入补贴名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="补贴金额" prop="subsidiesAmount">
        <el-input v-model="queryParams.subsidiesAmount" placeholder="请输入补贴金额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="补贴方式" prop="subsidiesType">
        <el-select v-model="queryParams.subsidiesType" placeholder="请选择补贴方式" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="补贴状态" prop="subsidiesStatus">
        <el-select v-model="queryParams.subsidiesStatus" placeholder="请选择补贴状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="申请人" prop="applyPerson">
        <el-input v-model="queryParams.applyPerson" placeholder="请输入申请人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="申请时间" prop="applyTime">
        <el-date-picker v-model="queryParams.applyTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户集合" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入租户集合" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经营主体ID" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
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
                   v-hasPermi="['enterprise:policy-subsidies-info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['enterprise:policy-subsidies-info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="经营主体ID" align="center" prop="enterpriseId" />
      <el-table-column label="补贴种类" align="center" prop="subsidiesCategory" />
      <el-table-column label="补贴名称" align="center" prop="subsidiesName" />
      <el-table-column label="补贴金额" align="center" prop="subsidiesAmount" />
      <el-table-column label="补贴方式" align="center" prop="subsidiesType" />
      <el-table-column label="补贴状态" align="center" prop="subsidiesStatus" />
      <el-table-column label="申请人" align="center" prop="applyPerson" />
      <el-table-column label="申请时间" align="center" prop="applyTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['enterprise:policy-subsidies-info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['enterprise:policy-subsidies-info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="经营主体ID" prop="enterpriseId">
          <el-input v-model="form.enterpriseId" placeholder="请输入经营主体ID" />
        </el-form-item>
        <el-form-item label="补贴种类" prop="subsidiesCategory">
          <el-input v-model="form.subsidiesCategory" placeholder="请输入补贴种类" />
        </el-form-item>
        <el-form-item label="补贴名称" prop="subsidiesName">
          <el-input v-model="form.subsidiesName" placeholder="请输入补贴名称" />
        </el-form-item>
        <el-form-item label="补贴金额" prop="subsidiesAmount">
          <el-input v-model="form.subsidiesAmount" placeholder="请输入补贴金额" />
        </el-form-item>
        <el-form-item label="补贴方式" prop="subsidiesType">
          <el-select v-model="form.subsidiesType" placeholder="请选择补贴方式">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="补贴状态" prop="subsidiesStatus">
          <el-radio-group v-model="form.subsidiesStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="申请人" prop="applyPerson">
          <el-input v-model="form.applyPerson" placeholder="请输入申请人" />
        </el-form-item>
        <el-form-item label="申请时间" prop="applyTime">
          <el-date-picker clearable v-model="form.applyTime" type="date" value-format="timestamp" placeholder="选择申请时间" />
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
import { createPolicySubsidiesInfo, updatePolicySubsidiesInfo, deletePolicySubsidiesInfo, getPolicySubsidiesInfo, getPolicySubsidiesInfoPage, exportPolicySubsidiesInfoExcel } from "@/api/enterprise/policySubsidiesInfo";

export default {
  name: "PolicySubsidiesInfo",
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
      // 企业政策补贴信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        enterpriseId: null,
        subsidiesCategory: null,
        subsidiesName: null,
        subsidiesAmount: null,
        subsidiesType: null,
        subsidiesStatus: null,
        applyPerson: null,
        applyTime: [],
        source: null,
        subjectId: null,
        createTime: [],
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
      getPolicySubsidiesInfoPage(this.queryParams).then(response => {
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
        enterpriseId: undefined,
        subsidiesCategory: undefined,
        subsidiesName: undefined,
        subsidiesAmount: undefined,
        subsidiesType: undefined,
        subsidiesStatus: undefined,
        applyPerson: undefined,
        applyTime: undefined,
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
      this.title = "添加企业政策补贴信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPolicySubsidiesInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改企业政策补贴信息";
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
          updatePolicySubsidiesInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPolicySubsidiesInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除企业政策补贴信息编号为"' + id + '"的数据项?').then(function() {
          return deletePolicySubsidiesInfo(id);
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
      this.$modal.confirm('是否确认导出所有企业政策补贴信息数据项?').then(() => {
          this.exportLoading = true;
          return exportPolicySubsidiesInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '企业政策补贴信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
