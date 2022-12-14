<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="采购单id" prop="orderId">
        <el-input v-model="queryParams.orderId" placeholder="请输入采购单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单号" prop="orderNo">
        <el-input v-model="queryParams.orderNo" placeholder="请输入采购单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货单id" prop="goodsId">
        <el-input v-model="queryParams.goodsId" placeholder="请输入货单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货单单号" prop="goodsNo">
        <el-input v-model="queryParams.goodsNo" placeholder="请输入货单单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货电子表-明细id" prop="electronicBillOfGoodsId">
        <el-input v-model="queryParams.electronicBillOfGoodsId" placeholder="请输入货电子表-明细id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货架id" prop="goodsShelvesId">
        <el-input v-model="queryParams.goodsShelvesId" placeholder="请输入货架id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货架号" prop="goodsShelvesNo">
        <el-input v-model="queryParams.goodsShelvesNo" placeholder="请输入货架号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货品名称" prop="goodsName">
        <el-input v-model="queryParams.goodsName" placeholder="请输入货品名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装规格" prop="packingSpecifications">
        <el-input v-model="queryParams.packingSpecifications" placeholder="请输入包装规格" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="规格单位" prop="specificationUnit">
        <el-input v-model="queryParams.specificationUnit" placeholder="请输入规格单位" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="损耗数量" prop="lossCount">
        <el-input v-model="queryParams.lossCount" placeholder="请输入损耗数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="损耗重量" prop="lossWeight">
        <el-input v-model="queryParams.lossWeight" placeholder="请输入损耗重量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="金额" prop="amount">
        <el-input v-model="queryParams.amount" placeholder="请输入金额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报损人id" prop="lossReporterId">
        <el-input v-model="queryParams.lossReporterId" placeholder="请输入报损人id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报损人姓名" prop="lossReporterName">
        <el-input v-model="queryParams.lossReporterName" placeholder="请输入报损人姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报损时间" prop="lossReporterTime">
        <el-date-picker v-model="queryParams.lossReporterTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="库存记录id" prop="inventoryRecordsId">
        <el-input v-model="queryParams.inventoryRecordsId" placeholder="请输入库存记录id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="入库批次号" prop="receiptBatchNo">
        <el-input v-model="queryParams.receiptBatchNo" placeholder="请输入入库批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存记录明细id" prop="inventoryRecordDetailsId">
        <el-input v-model="queryParams.inventoryRecordDetailsId" placeholder="请输入库存记录明细id" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['purchase:loss:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:loss:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="采购单id" align="center" prop="orderId" />
      <el-table-column label="采购单号" align="center" prop="orderNo" />
      <el-table-column label="货单id" align="center" prop="goodsId" />
      <el-table-column label="货单单号" align="center" prop="goodsNo" />
      <el-table-column label="货电子表-明细id" align="center" prop="electronicBillOfGoodsId" />
      <el-table-column label="货架id" align="center" prop="goodsShelvesId" />
      <el-table-column label="货架号" align="center" prop="goodsShelvesNo" />
      <el-table-column label="货品名称" align="center" prop="goodsName" />
      <el-table-column label="包装规格" align="center" prop="packingSpecifications" />
      <el-table-column label="规格单位" align="center" prop="specificationUnit" />
      <el-table-column label="损耗数量" align="center" prop="lossCount" />
      <el-table-column label="损耗重量" align="center" prop="lossWeight" />
      <el-table-column label="金额" align="center" prop="amount" />
      <el-table-column label="报损人id" align="center" prop="lossReporterId" />
      <el-table-column label="报损人姓名" align="center" prop="lossReporterName" />
      <el-table-column label="报损时间" align="center" prop="lossReporterTime" />
      <el-table-column label="库存记录id" align="center" prop="inventoryRecordsId" />
      <el-table-column label="入库批次号" align="center" prop="receiptBatchNo" />
      <el-table-column label="库存记录明细id" align="center" prop="inventoryRecordDetailsId" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:loss:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:loss:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="采购单id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入采购单id" />
        </el-form-item>
        <el-form-item label="采购单号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入采购单号" />
        </el-form-item>
        <el-form-item label="货单id" prop="goodsId">
          <el-input v-model="form.goodsId" placeholder="请输入货单id" />
        </el-form-item>
        <el-form-item label="货单单号" prop="goodsNo">
          <el-input v-model="form.goodsNo" placeholder="请输入货单单号" />
        </el-form-item>
        <el-form-item label="货电子表-明细id" prop="electronicBillOfGoodsId">
          <el-input v-model="form.electronicBillOfGoodsId" placeholder="请输入货电子表-明细id" />
        </el-form-item>
        <el-form-item label="货架id" prop="goodsShelvesId">
          <el-input v-model="form.goodsShelvesId" placeholder="请输入货架id" />
        </el-form-item>
        <el-form-item label="货架号" prop="goodsShelvesNo">
          <el-input v-model="form.goodsShelvesNo" placeholder="请输入货架号" />
        </el-form-item>
        <el-form-item label="货品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入货品名称" />
        </el-form-item>
        <el-form-item label="包装规格" prop="packingSpecifications">
          <el-input v-model="form.packingSpecifications" placeholder="请输入包装规格" />
        </el-form-item>
        <el-form-item label="规格单位" prop="specificationUnit">
          <el-input v-model="form.specificationUnit" placeholder="请输入规格单位" />
        </el-form-item>
        <el-form-item label="损耗数量" prop="lossCount">
          <el-input v-model="form.lossCount" placeholder="请输入损耗数量" />
        </el-form-item>
        <el-form-item label="损耗重量" prop="lossWeight">
          <el-input v-model="form.lossWeight" placeholder="请输入损耗重量" />
        </el-form-item>
        <el-form-item label="金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="报损人id" prop="lossReporterId">
          <el-input v-model="form.lossReporterId" placeholder="请输入报损人id" />
        </el-form-item>
        <el-form-item label="报损人姓名" prop="lossReporterName">
          <el-input v-model="form.lossReporterName" placeholder="请输入报损人姓名" />
        </el-form-item>
        <el-form-item label="报损时间" prop="lossReporterTime">
          <el-date-picker clearable v-model="form.lossReporterTime" type="date" value-format="timestamp" placeholder="选择报损时间" />
        </el-form-item>
        <el-form-item label="库存记录id" prop="inventoryRecordsId">
          <el-input v-model="form.inventoryRecordsId" placeholder="请输入库存记录id" />
        </el-form-item>
        <el-form-item label="入库批次号" prop="receiptBatchNo">
          <el-input v-model="form.receiptBatchNo" placeholder="请输入入库批次号" />
        </el-form-item>
        <el-form-item label="库存记录明细id" prop="inventoryRecordDetailsId">
          <el-input v-model="form.inventoryRecordDetailsId" placeholder="请输入库存记录明细id" />
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
import { createLoss, updateLoss, deleteLoss, getLoss, getLossPage, exportLossExcel } from "@/api/purchase/loss";

export default {
  name: "Loss",
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
      // 损耗列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        orderId: null,
        orderNo: null,
        goodsId: null,
        goodsNo: null,
        electronicBillOfGoodsId: null,
        goodsShelvesId: null,
        goodsShelvesNo: null,
        goodsName: null,
        packingSpecifications: null,
        specificationUnit: null,
        lossCount: null,
        lossWeight: null,
        amount: null,
        lossReporterId: null,
        lossReporterName: null,
        lossReporterTime: [],
        inventoryRecordsId: null,
        receiptBatchNo: null,
        inventoryRecordDetailsId: null,
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        orderId: [{ required: true, message: "采购单id不能为空", trigger: "blur" }],
        orderNo: [{ required: true, message: "采购单号不能为空", trigger: "blur" }],
        goodsId: [{ required: true, message: "货单id不能为空", trigger: "blur" }],
        goodsNo: [{ required: true, message: "货单单号不能为空", trigger: "blur" }],
        electronicBillOfGoodsId: [{ required: true, message: "货电子表-明细id不能为空", trigger: "blur" }],
        goodsShelvesId: [{ required: true, message: "货架id不能为空", trigger: "blur" }],
        goodsShelvesNo: [{ required: true, message: "货架号不能为空", trigger: "blur" }],
        goodsName: [{ required: true, message: "货品名称不能为空", trigger: "blur" }],
        packingSpecifications: [{ required: true, message: "包装规格不能为空", trigger: "blur" }],
        specificationUnit: [{ required: true, message: "规格单位不能为空", trigger: "blur" }],
        lossReporterId: [{ required: true, message: "报损人id不能为空", trigger: "blur" }],
        lossReporterName: [{ required: true, message: "报损人姓名不能为空", trigger: "blur" }],
        inventoryRecordsId: [{ required: true, message: "库存记录id不能为空", trigger: "blur" }],
        receiptBatchNo: [{ required: true, message: "入库批次号不能为空", trigger: "blur" }],
        inventoryRecordDetailsId: [{ required: true, message: "库存记录明细id不能为空", trigger: "blur" }],
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
      getLossPage(this.queryParams).then(response => {
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
        orderId: undefined,
        orderNo: undefined,
        goodsId: undefined,
        goodsNo: undefined,
        electronicBillOfGoodsId: undefined,
        goodsShelvesId: undefined,
        goodsShelvesNo: undefined,
        goodsName: undefined,
        packingSpecifications: undefined,
        specificationUnit: undefined,
        lossCount: undefined,
        lossWeight: undefined,
        amount: undefined,
        lossReporterId: undefined,
        lossReporterName: undefined,
        lossReporterTime: undefined,
        inventoryRecordsId: undefined,
        receiptBatchNo: undefined,
        inventoryRecordDetailsId: undefined,
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
      this.title = "添加损耗";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getLoss(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改损耗";
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
          updateLoss(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createLoss(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除损耗编号为"' + id + '"的数据项?').then(function() {
          return deleteLoss(id);
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
      this.$modal.confirm('是否确认导出所有损耗数据项?').then(() => {
          this.exportLoading = true;
          return exportLossExcel(params);
        }).then(response => {
          this.$download.excel(response, '损耗.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
