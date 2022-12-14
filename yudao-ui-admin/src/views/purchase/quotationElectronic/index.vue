<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="报价单id" prop="quotationId">
        <el-input v-model="queryParams.quotationId" placeholder="请输入报价单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报价单编号" prop="quotationNo">
        <el-input v-model="queryParams.quotationNo" placeholder="请输入报价单编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="询价单明细id" prop="inquiryId">
        <el-input v-model="queryParams.inquiryId" placeholder="请输入询价单明细id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品id" prop="commodityId">
        <el-input v-model="queryParams.commodityId" placeholder="请输入商品id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类id" prop="classifyId">
        <el-input v-model="queryParams.classifyId" placeholder="请输入分类id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="规格id" prop="specificationsId">
        <el-input v-model="queryParams.specificationsId" placeholder="请输入规格id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="起批数量" prop="initialBatchCount">
        <el-input v-model="queryParams.initialBatchCount" placeholder="请输入起批数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="单价" prop="unitPrice">
        <el-input v-model="queryParams.unitPrice" placeholder="请输入单价" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购数量" prop="purchaseCount">
        <el-input v-model="queryParams.purchaseCount" placeholder="请输入采购数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="总价" prop="totalPrice">
        <el-input v-model="queryParams.totalPrice" placeholder="请输入总价" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始时间" prop="startTime">
        <el-date-picker v-model="queryParams.startTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker v-model="queryParams.endTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
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
                   v-hasPermi="['purchase:quotation-electronic:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:quotation-electronic:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="报价单id" align="center" prop="quotationId" />
      <el-table-column label="报价单编号" align="center" prop="quotationNo" />
      <el-table-column label="询价单明细id" align="center" prop="inquiryId" />
      <el-table-column label="商品id" align="center" prop="commodityId" />
      <el-table-column label="分类id" align="center" prop="classifyId" />
      <el-table-column label="规格id" align="center" prop="specificationsId" />
      <el-table-column label="起批数量" align="center" prop="initialBatchCount" />
      <el-table-column label="单价" align="center" prop="unitPrice" />
      <el-table-column label="采购数量" align="center" prop="purchaseCount" />
      <el-table-column label="总价" align="center" prop="totalPrice" />
      <el-table-column label="开始时间" align="center" prop="startTime" />
      <el-table-column label="结束时间" align="center" prop="endTime" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:quotation-electronic:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:quotation-electronic:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="报价单id" prop="quotationId">
          <el-input v-model="form.quotationId" placeholder="请输入报价单id" />
        </el-form-item>
        <el-form-item label="报价单编号" prop="quotationNo">
          <el-input v-model="form.quotationNo" placeholder="请输入报价单编号" />
        </el-form-item>
        <el-form-item label="询价单明细id" prop="inquiryId">
          <el-input v-model="form.inquiryId" placeholder="请输入询价单明细id" />
        </el-form-item>
        <el-form-item label="商品id" prop="commodityId">
          <el-input v-model="form.commodityId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="分类id" prop="classifyId">
          <el-input v-model="form.classifyId" placeholder="请输入分类id" />
        </el-form-item>
        <el-form-item label="规格id" prop="specificationsId">
          <el-input v-model="form.specificationsId" placeholder="请输入规格id" />
        </el-form-item>
        <el-form-item label="起批数量" prop="initialBatchCount">
          <el-input v-model="form.initialBatchCount" placeholder="请输入起批数量" />
        </el-form-item>
        <el-form-item label="单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="采购数量" prop="purchaseCount">
          <el-input v-model="form.purchaseCount" placeholder="请输入采购数量" />
        </el-form-item>
        <el-form-item label="总价" prop="totalPrice">
          <el-input v-model="form.totalPrice" placeholder="请输入总价" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable v-model="form.startTime" type="date" value-format="timestamp" placeholder="选择开始时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable v-model="form.endTime" type="date" value-format="timestamp" placeholder="选择结束时间" />
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
import { createQuotationElectronic, updateQuotationElectronic, deleteQuotationElectronic, getQuotationElectronic, getQuotationElectronicPage, exportQuotationElectronicExcel } from "@/api/purchase/quotationElectronic";

export default {
  name: "QuotationElectronic",
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
      // 采购报价单电子列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        quotationId: null,
        quotationNo: null,
        inquiryId: null,
        commodityId: null,
        classifyId: null,
        specificationsId: null,
        initialBatchCount: null,
        unitPrice: null,
        purchaseCount: null,
        totalPrice: null,
        startTime: [],
        endTime: [],
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        quotationId: [{ required: true, message: "报价单id不能为空", trigger: "blur" }],
        quotationNo: [{ required: true, message: "报价单编号不能为空", trigger: "blur" }],
        inquiryId: [{ required: true, message: "询价单明细id不能为空", trigger: "blur" }],
        commodityId: [{ required: true, message: "商品id不能为空", trigger: "blur" }],
        classifyId: [{ required: true, message: "分类id不能为空", trigger: "blur" }],
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
      getQuotationElectronicPage(this.queryParams).then(response => {
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
        quotationId: undefined,
        quotationNo: undefined,
        inquiryId: undefined,
        commodityId: undefined,
        classifyId: undefined,
        specificationsId: undefined,
        initialBatchCount: undefined,
        unitPrice: undefined,
        purchaseCount: undefined,
        totalPrice: undefined,
        startTime: undefined,
        endTime: undefined,
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
      this.title = "添加采购报价单电子";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getQuotationElectronic(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购报价单电子";
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
          updateQuotationElectronic(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createQuotationElectronic(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除采购报价单电子编号为"' + id + '"的数据项?').then(function() {
          return deleteQuotationElectronic(id);
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
      this.$modal.confirm('是否确认导出所有采购报价单电子数据项?').then(() => {
          this.exportLoading = true;
          return exportQuotationElectronicExcel(params);
        }).then(response => {
          this.$download.excel(response, '采购报价单电子.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
