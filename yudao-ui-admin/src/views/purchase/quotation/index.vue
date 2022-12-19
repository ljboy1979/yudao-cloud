<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="报价单编号" prop="quoteId">
        <el-input v-model="queryParams.quoteId" placeholder="请输入报价单编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报价单名称" prop="quoteName">
        <el-input v-model="queryParams.quoteName" placeholder="请输入报价单名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购商id" prop="purchaserId">
        <el-input v-model="queryParams.purchaserId" placeholder="请输入采购商id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="询价单编号" prop="enquiryId">
        <el-input v-model="queryParams.enquiryId" placeholder="请输入询价单编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报价有效期" prop="indateDate">
        <el-date-picker v-model="queryParams.indateDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="是否提交 0：未提交 1：已提交" prop="submitStatus">
        <el-select v-model="queryParams.submitStatus" placeholder="请选择是否提交 0：未提交 1：已提交" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="经营主体" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['purchase:quotation:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:quotation:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="报价单编号" align="center" prop="quoteId" />
      <el-table-column label="报价单名称" align="center" prop="quoteName" />
      <el-table-column label="采购商id" align="center" prop="purchaserId" />
      <el-table-column label="询价单编号" align="center" prop="enquiryId" />
      <el-table-column label="报价有效期" align="center" prop="indateDate" />
      <el-table-column label="是否提交 0：未提交 1：已提交" align="center" prop="submitStatus" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:quotation:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:quotation:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="报价单编号" prop="quoteId">
          <el-input v-model="form.quoteId" placeholder="请输入报价单编号" />
        </el-form-item>
        <el-form-item label="报价单名称" prop="quoteName">
          <el-input v-model="form.quoteName" placeholder="请输入报价单名称" />
        </el-form-item>
        <el-form-item label="采购商id" prop="purchaserId">
          <el-input v-model="form.purchaserId" placeholder="请输入采购商id" />
        </el-form-item>
        <el-form-item label="询价单编号" prop="enquiryId">
          <el-input v-model="form.enquiryId" placeholder="请输入询价单编号" />
        </el-form-item>
        <el-form-item label="报价有效期" prop="indateDate">
          <el-date-picker clearable v-model="form.indateDate" type="date" value-format="timestamp" placeholder="选择报价有效期" />
        </el-form-item>
        <el-form-item label="是否提交 0：未提交 1：已提交" prop="submitStatus">
          <el-radio-group v-model="form.submitStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="经营主体" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体" />
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
import { createQuotation, updateQuotation, deleteQuotation, getQuotation, getQuotationPage, exportQuotationExcel } from "@/api/purchase/quotation";

export default {
  name: "Quotation",
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
      // 采购询价电子列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        quoteId: null,
        quoteName: null,
        purchaserId: null,
        enquiryId: null,
        indateDate: [],
        submitStatus: null,
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        quoteId: [{ required: true, message: "报价单编号不能为空", trigger: "blur" }],
        quoteName: [{ required: true, message: "报价单名称不能为空", trigger: "blur" }],
        purchaserId: [{ required: true, message: "采购商id不能为空", trigger: "blur" }],
        enquiryId: [{ required: true, message: "询价单编号不能为空", trigger: "blur" }],
        subjectId: [{ required: true, message: "经营主体不能为空", trigger: "blur" }],
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
      getQuotationPage(this.queryParams).then(response => {
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
        quoteId: undefined,
        quoteName: undefined,
        purchaserId: undefined,
        enquiryId: undefined,
        indateDate: undefined,
        submitStatus: undefined,
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
      this.title = "添加采购询价电子";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getQuotation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购询价电子";
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
          updateQuotation(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createQuotation(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除采购询价电子编号为"' + id + '"的数据项?').then(function() {
          return deleteQuotation(id);
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
      this.$modal.confirm('是否确认导出所有采购询价电子数据项?').then(() => {
          this.exportLoading = true;
          return exportQuotationExcel(params);
        }).then(response => {
          this.$download.excel(response, '采购询价电子.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
