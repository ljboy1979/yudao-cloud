<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编号" prop="costCode">
        <el-input v-model="queryParams.costCode" placeholder="请输入编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="来源" prop="costSource">
        <el-input v-model="queryParams.costSource" placeholder="请输入来源" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="主体" prop="entityId">
        <el-input v-model="queryParams.entityId" placeholder="请输入主体" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="类型(0支出,1收入)" prop="costType">
        <el-select v-model="queryParams.costType" placeholder="请选择类型(0支出,1收入)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="单据名称" prop="accountName">
        <el-input v-model="queryParams.accountName" placeholder="请输入单据名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="账目内容" prop="accountInfo">
        <el-input v-model="queryParams.accountInfo" placeholder="请输入账目内容" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="账目金额" prop="accountAmount">
        <el-input v-model="queryParams.accountAmount" placeholder="请输入账目金额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="时间" prop="accountTime">
        <el-date-picker v-model="queryParams.accountTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="地点" prop="accountLocation">
        <el-input v-model="queryParams.accountLocation" placeholder="请输入地点" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="记账时间" prop="accountingTime">
        <el-date-picker v-model="queryParams.accountingTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="详情" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入详情" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="计数器" prop="counter">
        <el-input v-model="queryParams.counter" placeholder="请输入计数器" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="机构编码" prop="officeCode">
        <el-input v-model="queryParams.officeCode" placeholder="请输入机构编码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="机构名称" prop="officeName">
        <el-input v-model="queryParams.officeName" placeholder="请输入机构名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="公司编码" prop="companyCode">
        <el-input v-model="queryParams.companyCode" placeholder="请输入公司编码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="公司名称" prop="companyName">
        <el-input v-model="queryParams.companyName" placeholder="请输入公司名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="审核状态" prop="reviewStatus">
        <el-select v-model="queryParams.reviewStatus" placeholder="请选择审核状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="审核人" prop="reviewer">
        <el-input v-model="queryParams.reviewer" placeholder="请输入审核人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="审核时间" prop="reviewDate">
        <el-date-picker v-model="queryParams.reviewDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户代码" prop="corpCode">
        <el-input v-model="queryParams.corpCode" placeholder="请输入租户代码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户名称" prop="corpName">
        <el-input v-model="queryParams.corpName" placeholder="请输入租户名称" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['tunnel:cost-book:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['tunnel:cost-book:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="编号" align="center" prop="costCode" />
      <el-table-column label="来源" align="center" prop="costSource" />
      <el-table-column label="主体" align="center" prop="entityId" />
      <el-table-column label="类型(0支出,1收入)" align="center" prop="costType" />
      <el-table-column label="单据名称" align="center" prop="accountName" />
      <el-table-column label="账目内容" align="center" prop="accountInfo" />
      <el-table-column label="账目金额" align="center" prop="accountAmount" />
      <el-table-column label="时间" align="center" prop="accountTime" />
      <el-table-column label="地点" align="center" prop="accountLocation" />
      <el-table-column label="记账时间" align="center" prop="accountingTime" />
      <el-table-column label="详情" align="center" prop="remarks" />
      <el-table-column label="计数器" align="center" prop="counter" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['tunnel:cost-book:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['tunnel:cost-book:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="costCode">
          <el-input v-model="form.costCode" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="来源" prop="costSource">
          <el-input v-model="form.costSource" placeholder="请输入来源" />
        </el-form-item>
        <el-form-item label="主体" prop="entityId">
          <el-input v-model="form.entityId" placeholder="请输入主体" />
        </el-form-item>
        <el-form-item label="类型(0支出,1收入)" prop="costType">
          <el-select v-model="form.costType" placeholder="请选择类型(0支出,1收入)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="单据名称" prop="accountName">
          <el-input v-model="form.accountName" placeholder="请输入单据名称" />
        </el-form-item>
        <el-form-item label="账目内容" prop="accountInfo">
          <el-input v-model="form.accountInfo" placeholder="请输入账目内容" />
        </el-form-item>
        <el-form-item label="账目金额" prop="accountAmount">
          <el-input v-model="form.accountAmount" placeholder="请输入账目金额" />
        </el-form-item>
        <el-form-item label="时间" prop="accountTime">
          <el-date-picker clearable v-model="form.accountTime" type="date" value-format="timestamp" placeholder="选择时间" />
        </el-form-item>
        <el-form-item label="地点" prop="accountLocation">
          <el-input v-model="form.accountLocation" placeholder="请输入地点" />
        </el-form-item>
        <el-form-item label="记账时间" prop="accountingTime">
          <el-date-picker clearable v-model="form.accountingTime" type="date" value-format="timestamp" placeholder="选择记账时间" />
        </el-form-item>
        <el-form-item label="详情" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入详情" />
        </el-form-item>
        <el-form-item label="计数器" prop="counter">
          <el-input v-model="form.counter" placeholder="请输入计数器" />
        </el-form-item>
        <el-form-item label="机构编码" prop="officeCode">
          <el-input v-model="form.officeCode" placeholder="请输入机构编码" />
        </el-form-item>
        <el-form-item label="机构名称" prop="officeName">
          <el-input v-model="form.officeName" placeholder="请输入机构名称" />
        </el-form-item>
        <el-form-item label="公司编码" prop="companyCode">
          <el-input v-model="form.companyCode" placeholder="请输入公司编码" />
        </el-form-item>
        <el-form-item label="公司名称" prop="companyName">
          <el-input v-model="form.companyName" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="审核状态" prop="reviewStatus">
          <el-radio-group v-model="form.reviewStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="审核人" prop="reviewer">
          <el-input v-model="form.reviewer" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审核时间" prop="reviewDate">
          <el-date-picker clearable v-model="form.reviewDate" type="date" value-format="timestamp" placeholder="选择审核时间" />
        </el-form-item>
        <el-form-item label="审核内容">
          <editor v-model="form.reviewContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
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
import { createCostBook, updateCostBook, deleteCostBook, getCostBook, getCostBookPage, exportCostBookExcel } from "@/api/tunnel/costBook";
import Editor from '@/components/Editor';

export default {
  name: "CostBook",
  components: {
    Editor,
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
      // 地块账本列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        costCode: null,
        costSource: null,
        entityId: null,
        costType: null,
        accountName: null,
        accountInfo: null,
        accountAmount: null,
        accountTime: [],
        accountLocation: null,
        accountingTime: [],
        remarks: null,
        counter: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        corpCode: null,
        corpName: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        corpCode: [{ required: true, message: "租户代码不能为空", trigger: "blur" }],
        corpName: [{ required: true, message: "租户名称不能为空", trigger: "blur" }],
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
      getCostBookPage(this.queryParams).then(response => {
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
        costCode: undefined,
        costSource: undefined,
        entityId: undefined,
        costType: undefined,
        accountName: undefined,
        accountInfo: undefined,
        accountAmount: undefined,
        accountTime: undefined,
        accountLocation: undefined,
        accountingTime: undefined,
        remarks: undefined,
        counter: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        corpCode: undefined,
        corpName: undefined,
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
      this.title = "添加地块账本";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getCostBook(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地块账本";
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
          updateCostBook(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createCostBook(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除地块账本编号为"' + id + '"的数据项?').then(function() {
          return deleteCostBook(id);
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
      this.$modal.confirm('是否确认导出所有地块账本数据项?').then(() => {
          this.exportLoading = true;
          return exportCostBookExcel(params);
        }).then(response => {
          this.$download.excel(response, '地块账本.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
