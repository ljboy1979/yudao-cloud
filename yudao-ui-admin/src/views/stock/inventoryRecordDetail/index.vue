<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="库存记录id" prop="stockRecordId">
        <el-input v-model="queryParams.stockRecordId" placeholder="请输入库存记录id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存批次号" prop="stockBatchNo">
        <el-input v-model="queryParams.stockBatchNo" placeholder="请输入库存批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存记录明细id" prop="stockRecordDetailId">
        <el-input v-model="queryParams.stockRecordDetailId" placeholder="请输入库存记录明细id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存类型(1.原料 2.投入品 3.成品 4.办公用品)" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择库存类型(1.原料 2.投入品 3.成品 4.办公用品)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="二级分类(成品类：套餐/商品/特医食品)" prop="secondaryClassification">
        <el-input v-model="queryParams.secondaryClassification" placeholder="请输入二级分类(成品类：套餐/商品/特医食品)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货品id" prop="goodsId">
        <el-input v-model="queryParams.goodsId" placeholder="请输入货品id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货品编号" prop="goodsNumber">
        <el-input v-model="queryParams.goodsNumber" placeholder="请输入货品编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货品名称" prop="goodsName">
        <el-input v-model="queryParams.goodsName" placeholder="请输入货品名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货品类型" prop="goodsType">
        <el-select v-model="queryParams.goodsType" placeholder="请选择货品类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="包装规格id" prop="packagingSpecificationId">
        <el-input v-model="queryParams.packagingSpecificationId" placeholder="请输入包装规格id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装规格" prop="packagingSpecification">
        <el-input v-model="queryParams.packagingSpecification" placeholder="请输入包装规格" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装规格名称" prop="packagingSpecificationName">
        <el-input v-model="queryParams.packagingSpecificationName" placeholder="请输入包装规格名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装类型" prop="packagingType">
        <el-select v-model="queryParams.packagingType" placeholder="请选择包装类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="盘点前数量" prop="inventoryFrontQuantity">
        <el-input v-model="queryParams.inventoryFrontQuantity" placeholder="请输入盘点前数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="盘点后数量" prop="inventoryAfterQuantity">
        <el-input v-model="queryParams.inventoryAfterQuantity" placeholder="请输入盘点后数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货位id" prop="goodsAllocationId">
        <el-input v-model="queryParams.goodsAllocationId" placeholder="请输入货位id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货位号" prop="goodsAllocationNo">
        <el-input v-model="queryParams.goodsAllocationNo" placeholder="请输入货位号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="来源/去向说明" prop="sourceTo">
        <el-input v-model="queryParams.sourceTo" placeholder="请输入来源/去向说明" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['stock:inventory-record-detail:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['stock:inventory-record-detail:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="盘点记录明细id" align="center" prop="id" />
      <el-table-column label="库存记录id" align="center" prop="stockRecordId" />
      <el-table-column label="库存批次号" align="center" prop="stockBatchNo" />
      <el-table-column label="库存记录明细id" align="center" prop="stockRecordDetailId" />
      <el-table-column label="库存类型(1.原料 2.投入品 3.成品 4.办公用品)" align="center" prop="type" />
      <el-table-column label="二级分类(成品类：套餐/商品/特医食品)" align="center" prop="secondaryClassification" />
      <el-table-column label="货品id" align="center" prop="goodsId" />
      <el-table-column label="货品编号" align="center" prop="goodsNumber" />
      <el-table-column label="货品名称" align="center" prop="goodsName" />
      <el-table-column label="货品类型" align="center" prop="goodsType" />
      <el-table-column label="包装规格id" align="center" prop="packagingSpecificationId" />
      <el-table-column label="包装规格" align="center" prop="packagingSpecification" />
      <el-table-column label="包装规格名称" align="center" prop="packagingSpecificationName" />
      <el-table-column label="包装类型" align="center" prop="packagingType" />
      <el-table-column label="盘点前数量" align="center" prop="inventoryFrontQuantity" />
      <el-table-column label="盘点后数量" align="center" prop="inventoryAfterQuantity" />
      <el-table-column label="货位id" align="center" prop="goodsAllocationId" />
      <el-table-column label="货位号" align="center" prop="goodsAllocationNo" />
      <el-table-column label="来源/去向说明" align="center" prop="sourceTo" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="租户集合" align="center" prop="sourceId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['stock:inventory-record-detail:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['stock:inventory-record-detail:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="库存记录id" prop="stockRecordId">
          <el-input v-model="form.stockRecordId" placeholder="请输入库存记录id" />
        </el-form-item>
        <el-form-item label="库存批次号" prop="stockBatchNo">
          <el-input v-model="form.stockBatchNo" placeholder="请输入库存批次号" />
        </el-form-item>
        <el-form-item label="库存记录明细id" prop="stockRecordDetailId">
          <el-input v-model="form.stockRecordDetailId" placeholder="请输入库存记录明细id" />
        </el-form-item>
        <el-form-item label="库存类型(1.原料 2.投入品 3.成品 4.办公用品)" prop="type">
          <el-select v-model="form.type" placeholder="请选择库存类型(1.原料 2.投入品 3.成品 4.办公用品)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="二级分类(成品类：套餐/商品/特医食品)" prop="secondaryClassification">
          <el-input v-model="form.secondaryClassification" placeholder="请输入二级分类(成品类：套餐/商品/特医食品)" />
        </el-form-item>
        <el-form-item label="货品id" prop="goodsId">
          <el-input v-model="form.goodsId" placeholder="请输入货品id" />
        </el-form-item>
        <el-form-item label="货品编号" prop="goodsNumber">
          <el-input v-model="form.goodsNumber" placeholder="请输入货品编号" />
        </el-form-item>
        <el-form-item label="货品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入货品名称" />
        </el-form-item>
        <el-form-item label="货品类型" prop="goodsType">
          <el-select v-model="form.goodsType" placeholder="请选择货品类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="包装规格id" prop="packagingSpecificationId">
          <el-input v-model="form.packagingSpecificationId" placeholder="请输入包装规格id" />
        </el-form-item>
        <el-form-item label="包装规格" prop="packagingSpecification">
          <el-input v-model="form.packagingSpecification" placeholder="请输入包装规格" />
        </el-form-item>
        <el-form-item label="包装规格名称" prop="packagingSpecificationName">
          <el-input v-model="form.packagingSpecificationName" placeholder="请输入包装规格名称" />
        </el-form-item>
        <el-form-item label="包装类型" prop="packagingType">
          <el-select v-model="form.packagingType" placeholder="请选择包装类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="盘点前数量" prop="inventoryFrontQuantity">
          <el-input v-model="form.inventoryFrontQuantity" placeholder="请输入盘点前数量" />
        </el-form-item>
        <el-form-item label="盘点后数量" prop="inventoryAfterQuantity">
          <el-input v-model="form.inventoryAfterQuantity" placeholder="请输入盘点后数量" />
        </el-form-item>
        <el-form-item label="货位id" prop="goodsAllocationId">
          <el-input v-model="form.goodsAllocationId" placeholder="请输入货位id" />
        </el-form-item>
        <el-form-item label="货位号" prop="goodsAllocationNo">
          <el-input v-model="form.goodsAllocationNo" placeholder="请输入货位号" />
        </el-form-item>
        <el-form-item label="来源/去向说明" prop="sourceTo">
          <el-input v-model="form.sourceTo" placeholder="请输入来源/去向说明" />
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
import { createInventoryRecordDetail, updateInventoryRecordDetail, deleteInventoryRecordDetail, getInventoryRecordDetail, getInventoryRecordDetailPage, exportInventoryRecordDetailExcel } from "@/api/stock/inventoryRecordDetail";

export default {
  name: "InventoryRecordDetail",
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
      // 盘点记录表子表-明细列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        stockRecordId: null,
        stockBatchNo: null,
        stockRecordDetailId: null,
        type: null,
        secondaryClassification: null,
        goodsId: null,
        goodsNumber: null,
        goodsName: null,
        goodsType: null,
        packagingSpecificationId: null,
        packagingSpecification: null,
        packagingSpecificationName: null,
        packagingType: null,
        inventoryFrontQuantity: null,
        inventoryAfterQuantity: null,
        goodsAllocationId: null,
        goodsAllocationNo: null,
        sourceTo: null,
        createTime: [],
        subjectId: null,
        userId: null,
        sourceId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        stockRecordId: [{ required: true, message: "库存记录id不能为空", trigger: "blur" }],
        stockBatchNo: [{ required: true, message: "库存批次号不能为空", trigger: "blur" }],
        stockRecordDetailId: [{ required: true, message: "库存记录明细id不能为空", trigger: "blur" }],
        goodsId: [{ required: true, message: "货品id不能为空", trigger: "blur" }],
        goodsName: [{ required: true, message: "货品名称不能为空", trigger: "blur" }],
        inventoryFrontQuantity: [{ required: true, message: "盘点前数量不能为空", trigger: "blur" }],
        inventoryAfterQuantity: [{ required: true, message: "盘点后数量不能为空", trigger: "blur" }],
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
      getInventoryRecordDetailPage(this.queryParams).then(response => {
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
        stockRecordId: undefined,
        stockBatchNo: undefined,
        stockRecordDetailId: undefined,
        type: undefined,
        secondaryClassification: undefined,
        goodsId: undefined,
        goodsNumber: undefined,
        goodsName: undefined,
        goodsType: undefined,
        packagingSpecificationId: undefined,
        packagingSpecification: undefined,
        packagingSpecificationName: undefined,
        packagingType: undefined,
        inventoryFrontQuantity: undefined,
        inventoryAfterQuantity: undefined,
        goodsAllocationId: undefined,
        goodsAllocationNo: undefined,
        sourceTo: undefined,
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
      this.title = "添加盘点记录表子表-明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInventoryRecordDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改盘点记录表子表-明细";
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
          updateInventoryRecordDetail(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createInventoryRecordDetail(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除盘点记录表子表-明细编号为"' + id + '"的数据项?').then(function() {
          return deleteInventoryRecordDetail(id);
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
      this.$modal.confirm('是否确认导出所有盘点记录表子表-明细数据项?').then(() => {
          this.exportLoading = true;
          return exportInventoryRecordDetailExcel(params);
        }).then(response => {
          this.$download.excel(response, '盘点记录表子表-明细.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
