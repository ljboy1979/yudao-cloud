<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="库存记录id" prop="recordId">
        <el-input v-model="queryParams.recordId" placeholder="请输入库存记录id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存批次号" prop="stockBatchNo">
        <el-input v-model="queryParams.stockBatchNo" placeholder="请输入库存批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="操作类型(0.入库 1.出库)" prop="operationType">
        <el-select v-model="queryParams.operationType" placeholder="请选择操作类型(0.入库 1.出库)" clearable size="small">
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
      <el-form-item label="包装类型" prop="packagingType">
        <el-select v-model="queryParams.packagingType" placeholder="请选择包装类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="包装规格" prop="packingSpecification">
        <el-input v-model="queryParams.packingSpecification" placeholder="请输入包装规格" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="入库数量" prop="receiptQuantity">
        <el-input v-model="queryParams.receiptQuantity" placeholder="请输入入库数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="现有库存量" prop="existingInventory">
        <el-input v-model="queryParams.existingInventory" placeholder="请输入现有库存量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="出库数量" prop="deliveryQuantity">
        <el-input v-model="queryParams.deliveryQuantity" placeholder="请输入出库数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存记录明细id(只出库类型才有值-对应入库记录)" prop="recordDetailId">
        <el-input v-model="queryParams.recordDetailId" placeholder="请输入库存记录明细id(只出库类型才有值-对应入库记录)" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="单价" prop="unitPrice">
        <el-input v-model="queryParams.unitPrice" placeholder="请输入单价" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="计量单位" prop="unit">
        <el-input v-model="queryParams.unit" placeholder="请输入计量单位" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合计总价" prop="totalPrice">
        <el-input v-model="queryParams.totalPrice" placeholder="请输入合计总价" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="付款方式(0.微信 1.银联 2.支付宝 3.现金)" prop="payMethod">
        <el-input v-model="queryParams.payMethod" placeholder="请输入付款方式(0.微信 1.银联 2.支付宝 3.现金)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="生产批次号" prop="productionBatchNo">
        <el-input v-model="queryParams.productionBatchNo" placeholder="请输入生产批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地" prop="bases">
        <el-input v-model="queryParams.bases" placeholder="请输入基地" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块" prop="tunnel">
        <el-input v-model="queryParams.tunnel" placeholder="请输入地块" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="入库来源" prop="treasurySource">
        <el-input v-model="queryParams.treasurySource" placeholder="请输入入库来源" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采收记录id" prop="harvestBatchId">
        <el-input v-model="queryParams.harvestBatchId" placeholder="请输入采收记录id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单id" prop="purchaseId">
        <el-input v-model="queryParams.purchaseId" placeholder="请输入采购单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单号" prop="purchaseNumber">
        <el-input v-model="queryParams.purchaseNumber" placeholder="请输入采购单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="加工单id" prop="processingOrderId">
        <el-input v-model="queryParams.processingOrderId" placeholder="请输入加工单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="称重记录id" prop="weighingRecordId">
        <el-input v-model="queryParams.weighingRecordId" placeholder="请输入称重记录id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装单id" prop="packingListId">
        <el-input v-model="queryParams.packingListId" placeholder="请输入包装单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="临时时间" prop="temporaryTime">
        <el-date-picker v-model="queryParams.temporaryTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他" prop="environmentalRequirements">
        <el-input v-model="queryParams.environmentalRequirements" placeholder="请输入0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['stock:record-detail:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['stock:record-detail:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="库存记录明细id" align="center" prop="id" />
      <el-table-column label="库存记录id" align="center" prop="recordId" />
      <el-table-column label="库存批次号" align="center" prop="stockBatchNo" />
      <el-table-column label="操作类型(0.入库 1.出库)" align="center" prop="operationType" />
      <el-table-column label="二级分类(成品类：套餐/商品/特医食品)" align="center" prop="secondaryClassification" />
      <el-table-column label="货品id" align="center" prop="goodsId" />
      <el-table-column label="货品编号" align="center" prop="goodsNumber" />
      <el-table-column label="货品名称" align="center" prop="goodsName" />
      <el-table-column label="货品类型" align="center" prop="goodsType" />
      <el-table-column label="包装类型" align="center" prop="packagingType" />
      <el-table-column label="包装规格" align="center" prop="packingSpecification" />
      <el-table-column label="入库数量" align="center" prop="receiptQuantity" />
      <el-table-column label="现有库存量" align="center" prop="existingInventory" />
      <el-table-column label="出库数量" align="center" prop="deliveryQuantity" />
      <el-table-column label="库存记录明细id(只出库类型才有值-对应入库记录)" align="center" prop="recordDetailId" />
      <el-table-column label="货位id" align="center" prop="goodsAllocationId" />
      <el-table-column label="货位号" align="center" prop="goodsAllocationNo" />
      <el-table-column label="来源/去向说明" align="center" prop="sourceTo" />
      <el-table-column label="单价" align="center" prop="unitPrice" />
      <el-table-column label="计量单位" align="center" prop="unit" />
      <el-table-column label="合计总价" align="center" prop="totalPrice" />
      <el-table-column label="付款方式(0.微信 1.银联 2.支付宝 3.现金)" align="center" prop="payMethod" />
      <el-table-column label="生产批次号" align="center" prop="productionBatchNo" />
      <el-table-column label="基地" align="center" prop="bases" />
      <el-table-column label="地块" align="center" prop="tunnel" />
      <el-table-column label="入库来源" align="center" prop="treasurySource" />
      <el-table-column label="采收记录id" align="center" prop="harvestBatchId" />
      <el-table-column label="采购单id" align="center" prop="purchaseId" />
      <el-table-column label="采购单号" align="center" prop="purchaseNumber" />
      <el-table-column label="加工单id" align="center" prop="processingOrderId" />
      <el-table-column label="称重记录id" align="center" prop="weighingRecordId" />
      <el-table-column label="包装单id" align="center" prop="packingListId" />
      <el-table-column label="临时时间" align="center" prop="temporaryTime" />
      <el-table-column label="0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他" align="center" prop="environmentalRequirements" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="租户集合" align="center" prop="sourceId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['stock:record-detail:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['stock:record-detail:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="库存记录id" prop="recordId">
          <el-input v-model="form.recordId" placeholder="请输入库存记录id" />
        </el-form-item>
        <el-form-item label="库存批次号" prop="stockBatchNo">
          <el-input v-model="form.stockBatchNo" placeholder="请输入库存批次号" />
        </el-form-item>
        <el-form-item label="操作类型(0.入库 1.出库)" prop="operationType">
          <el-radio-group v-model="form.operationType">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
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
        <el-form-item label="包装类型" prop="packagingType">
          <el-select v-model="form.packagingType" placeholder="请选择包装类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="包装规格" prop="packingSpecification">
          <el-input v-model="form.packingSpecification" placeholder="请输入包装规格" />
        </el-form-item>
        <el-form-item label="入库数量" prop="receiptQuantity">
          <el-input v-model="form.receiptQuantity" placeholder="请输入入库数量" />
        </el-form-item>
        <el-form-item label="现有库存量" prop="existingInventory">
          <el-input v-model="form.existingInventory" placeholder="请输入现有库存量" />
        </el-form-item>
        <el-form-item label="出库数量" prop="deliveryQuantity">
          <el-input v-model="form.deliveryQuantity" placeholder="请输入出库数量" />
        </el-form-item>
        <el-form-item label="库存记录明细id(只出库类型才有值-对应入库记录)" prop="recordDetailId">
          <el-input v-model="form.recordDetailId" placeholder="请输入库存记录明细id(只出库类型才有值-对应入库记录)" />
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
        <el-form-item label="单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="计量单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="合计总价" prop="totalPrice">
          <el-input v-model="form.totalPrice" placeholder="请输入合计总价" />
        </el-form-item>
        <el-form-item label="付款方式(0.微信 1.银联 2.支付宝 3.现金)" prop="payMethod">
          <el-input v-model="form.payMethod" placeholder="请输入付款方式(0.微信 1.银联 2.支付宝 3.现金)" />
        </el-form-item>
        <el-form-item label="生产批次号" prop="productionBatchNo">
          <el-input v-model="form.productionBatchNo" placeholder="请输入生产批次号" />
        </el-form-item>
        <el-form-item label="基地" prop="bases">
          <el-input v-model="form.bases" placeholder="请输入基地" />
        </el-form-item>
        <el-form-item label="地块" prop="tunnel">
          <el-input v-model="form.tunnel" placeholder="请输入地块" />
        </el-form-item>
        <el-form-item label="入库来源" prop="treasurySource">
          <el-input v-model="form.treasurySource" placeholder="请输入入库来源" />
        </el-form-item>
        <el-form-item label="采收记录id" prop="harvestBatchId">
          <el-input v-model="form.harvestBatchId" placeholder="请输入采收记录id" />
        </el-form-item>
        <el-form-item label="采购单id" prop="purchaseId">
          <el-input v-model="form.purchaseId" placeholder="请输入采购单id" />
        </el-form-item>
        <el-form-item label="采购单号" prop="purchaseNumber">
          <el-input v-model="form.purchaseNumber" placeholder="请输入采购单号" />
        </el-form-item>
        <el-form-item label="加工单id" prop="processingOrderId">
          <el-input v-model="form.processingOrderId" placeholder="请输入加工单id" />
        </el-form-item>
        <el-form-item label="称重记录id" prop="weighingRecordId">
          <el-input v-model="form.weighingRecordId" placeholder="请输入称重记录id" />
        </el-form-item>
        <el-form-item label="包装单id" prop="packingListId">
          <el-input v-model="form.packingListId" placeholder="请输入包装单id" />
        </el-form-item>
        <el-form-item label="临时时间" prop="temporaryTime">
          <el-date-picker clearable v-model="form.temporaryTime" type="date" value-format="timestamp" placeholder="选择临时时间" />
        </el-form-item>
        <el-form-item label="0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他" prop="environmentalRequirements">
          <el-input v-model="form.environmentalRequirements" placeholder="请输入0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他" />
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
import { createRecordDetail, updateRecordDetail, deleteRecordDetail, getRecordDetail, getRecordDetailPage, exportRecordDetailExcel } from "@/api/stock/recordDetail";

export default {
  name: "RecordDetail",
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
      // 库存记录字表-明细列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        recordId: null,
        stockBatchNo: null,
        operationType: null,
        secondaryClassification: null,
        goodsId: null,
        goodsNumber: null,
        goodsName: null,
        goodsType: null,
        packagingType: null,
        packingSpecification: null,
        receiptQuantity: null,
        existingInventory: null,
        deliveryQuantity: null,
        recordDetailId: null,
        goodsAllocationId: null,
        goodsAllocationNo: null,
        sourceTo: null,
        unitPrice: null,
        unit: null,
        totalPrice: null,
        payMethod: null,
        productionBatchNo: null,
        bases: null,
        tunnel: null,
        treasurySource: null,
        harvestBatchId: null,
        purchaseId: null,
        purchaseNumber: null,
        processingOrderId: null,
        weighingRecordId: null,
        packingListId: null,
        temporaryTime: [],
        environmentalRequirements: null,
        createTime: [],
        subjectId: null,
        userId: null,
        sourceId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        recordId: [{ required: true, message: "库存记录id不能为空", trigger: "blur" }],
        stockBatchNo: [{ required: true, message: "库存批次号不能为空", trigger: "blur" }],
        operationType: [{ required: true, message: "操作类型(0.入库 1.出库)不能为空", trigger: "blur" }],
        goodsId: [{ required: true, message: "货品id不能为空", trigger: "blur" }],
        goodsName: [{ required: true, message: "货品名称不能为空", trigger: "blur" }],
        productionBatchNo: [{ required: true, message: "生产批次号不能为空", trigger: "blur" }],
        purchaseId: [{ required: true, message: "采购单id不能为空", trigger: "blur" }],
        purchaseNumber: [{ required: true, message: "采购单号不能为空", trigger: "blur" }],
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
      getRecordDetailPage(this.queryParams).then(response => {
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
        recordId: undefined,
        stockBatchNo: undefined,
        operationType: undefined,
        secondaryClassification: undefined,
        goodsId: undefined,
        goodsNumber: undefined,
        goodsName: undefined,
        goodsType: undefined,
        packagingType: undefined,
        packingSpecification: undefined,
        receiptQuantity: undefined,
        existingInventory: undefined,
        deliveryQuantity: undefined,
        recordDetailId: undefined,
        goodsAllocationId: undefined,
        goodsAllocationNo: undefined,
        sourceTo: undefined,
        unitPrice: undefined,
        unit: undefined,
        totalPrice: undefined,
        payMethod: undefined,
        productionBatchNo: undefined,
        bases: undefined,
        tunnel: undefined,
        treasurySource: undefined,
        harvestBatchId: undefined,
        purchaseId: undefined,
        purchaseNumber: undefined,
        processingOrderId: undefined,
        weighingRecordId: undefined,
        packingListId: undefined,
        temporaryTime: undefined,
        environmentalRequirements: undefined,
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
      this.title = "添加库存记录字表-明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getRecordDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改库存记录字表-明细";
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
          updateRecordDetail(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createRecordDetail(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除库存记录字表-明细编号为"' + id + '"的数据项?').then(function() {
          return deleteRecordDetail(id);
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
      this.$modal.confirm('是否确认导出所有库存记录字表-明细数据项?').then(() => {
          this.exportLoading = true;
          return exportRecordDetailExcel(params);
        }).then(response => {
          this.$download.excel(response, '库存记录字表-明细.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
