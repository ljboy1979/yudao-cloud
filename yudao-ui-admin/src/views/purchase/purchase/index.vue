<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编号" prop="id">
        <el-input v-model="queryParams.id" placeholder="请输入编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购类型(1:原料 2:投入品 3:成品 4:办公用品)" prop="purchaseType">
        <el-select v-model="queryParams.purchaseType" placeholder="请选择采购类型(1:原料 2:投入品 3:成品 4:办公用品)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="二级分类" prop="secondaryClassification">
        <el-input v-model="queryParams.secondaryClassification" placeholder="请输入二级分类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单号" prop="purchaseOrderNumber">
        <el-input v-model="queryParams.purchaseOrderNumber" placeholder="请输入采购单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供应商(用户id)" prop="providerId">
        <el-input v-model="queryParams.providerId" placeholder="请输入供应商(用户id)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供应商名称" prop="providerName">
        <el-input v-model="queryParams.providerName" placeholder="请输入供应商名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供应商联系方式" prop="providerContactInformation">
        <el-input v-model="queryParams.providerContactInformation" placeholder="请输入供应商联系方式" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购时间" prop="purchaseTime">
        <el-date-picker v-model="queryParams.purchaseTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="采购完成时间" prop="purchaseCompletionTime">
        <el-date-picker v-model="queryParams.purchaseCompletionTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="采购总额（元）" prop="totalProcurement">
        <el-input v-model="queryParams.totalProcurement" placeholder="请输入采购总额（元）" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="结算方式" prop="settlementMethod">
        <el-input v-model="queryParams.settlementMethod" placeholder="请输入结算方式" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="收款名称" prop="beneficiaryName">
        <el-input v-model="queryParams.beneficiaryName" placeholder="请输入收款名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开户行" prop="bankOfDeposit">
        <el-input v-model="queryParams.bankOfDeposit" placeholder="请输入开户行" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="收款账号" prop="collectionAccountNo">
        <el-input v-model="queryParams.collectionAccountNo" placeholder="请输入收款账号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="付款方式(0:微信 1:银联 2:支付宝 3:现金)" prop="paymentMethod">
        <el-input v-model="queryParams.paymentMethod" placeholder="请输入付款方式(0:微信 1:银联 2:支付宝 3:现金)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购人(用户id)" prop="purchaserId">
        <el-input v-model="queryParams.purchaserId" placeholder="请输入采购人(用户id)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购人姓名" prop="purchaserName">
        <el-input v-model="queryParams.purchaserName" placeholder="请输入采购人姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购部门id" prop="procurementDepartmentId">
        <el-input v-model="queryParams.procurementDepartmentId" placeholder="请输入采购部门id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购部门名称" prop="procurementDepartmentName">
        <el-input v-model="queryParams.procurementDepartmentName" placeholder="请输入采购部门名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="省" prop="province">
        <el-input v-model="queryParams.province" placeholder="请输入省" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input v-model="queryParams.city" placeholder="请输入市" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区" prop="area">
        <el-input v-model="queryParams.area" placeholder="请输入区" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="详细地址" prop="detailedAddress">
        <el-input v-model="queryParams.detailedAddress" placeholder="请输入详细地址" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input v-model="queryParams.longitude" placeholder="请输入经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="纬度" prop="latitude">
        <el-input v-model="queryParams.latitude" placeholder="请输入纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地id" prop="baseId">
        <el-input v-model="queryParams.baseId" placeholder="请输入基地id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块id" prop="massifId">
        <el-input v-model="queryParams.massifId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购状态(1.未开始 2.执行中 3.已完成 4.其他)" prop="purchaseStatus">
        <el-select v-model="queryParams.purchaseStatus" placeholder="请选择采购状态(1.未开始 2.执行中 3.已完成 4.其他)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="报价单id" prop="quotationId">
        <el-input v-model="queryParams.quotationId" placeholder="请输入报价单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报价单号" prop="quotationNo">
        <el-input v-model="queryParams.quotationNo" placeholder="请输入报价单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="有效期" prop="termOfValidity">
        <el-input v-model="queryParams.termOfValidity" placeholder="请输入有效期" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采收批次号" prop="collectionBatchNo">
        <el-input v-model="queryParams.collectionBatchNo" placeholder="请输入采收批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="交易单号(多个交易单用 "," 分割)" prop="transactionNo">
        <el-input v-model="queryParams.transactionNo" placeholder="请输入交易单号(多个交易单用 "," 分割)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" prop="purchaseOrderSource">
        <el-input v-model="queryParams.purchaseOrderSource" placeholder="请输入采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态(1.待生效 2.有效 3.无效)" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态(1.待生效 2.有效 3.无效)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
                   v-hasPermi="['purchase:purchase:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:purchase:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="采购类型(1:原料 2:投入品 3:成品 4:办公用品)" align="center" prop="purchaseType" />
      <el-table-column label="二级分类" align="center" prop="secondaryClassification" />
      <el-table-column label="采购单号" align="center" prop="purchaseOrderNumber" />
      <el-table-column label="供应商(用户id)" align="center" prop="providerId" />
      <el-table-column label="供应商名称" align="center" prop="providerName" />
      <el-table-column label="供应商联系方式" align="center" prop="providerContactInformation" />
      <el-table-column label="采购时间" align="center" prop="purchaseTime" />
      <el-table-column label="采购完成时间" align="center" prop="purchaseCompletionTime" />
      <el-table-column label="采购总额（元）" align="center" prop="totalProcurement" />
      <el-table-column label="结算方式" align="center" prop="settlementMethod" />
      <el-table-column label="收款名称" align="center" prop="beneficiaryName" />
      <el-table-column label="开户行" align="center" prop="bankOfDeposit" />
      <el-table-column label="收款账号" align="center" prop="collectionAccountNo" />
      <el-table-column label="付款方式(0:微信 1:银联 2:支付宝 3:现金)" align="center" prop="paymentMethod" />
      <el-table-column label="采购人(用户id)" align="center" prop="purchaserId" />
      <el-table-column label="采购人姓名" align="center" prop="purchaserName" />
      <el-table-column label="采购部门id" align="center" prop="procurementDepartmentId" />
      <el-table-column label="采购部门名称" align="center" prop="procurementDepartmentName" />
      <el-table-column label="省" align="center" prop="province" />
      <el-table-column label="市" align="center" prop="city" />
      <el-table-column label="区" align="center" prop="area" />
      <el-table-column label="详细地址" align="center" prop="detailedAddress" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="基地id" align="center" prop="baseId" />
      <el-table-column label="地块id" align="center" prop="massifId" />
      <el-table-column label="采购状态(1.未开始 2.执行中 3.已完成 4.其他)" align="center" prop="purchaseStatus" />
      <el-table-column label="报价单id" align="center" prop="quotationId" />
      <el-table-column label="报价单号" align="center" prop="quotationNo" />
      <el-table-column label="有效期" align="center" prop="termOfValidity" />
      <el-table-column label="采收批次号" align="center" prop="collectionBatchNo" />
      <el-table-column label="交易单号(多个交易单用 "," 分割)" align="center" prop="transactionNo" />
      <el-table-column label="采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" align="center" prop="purchaseOrderSource" />
      <el-table-column label="状态(1.待生效 2.有效 3.无效)" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:purchase:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:purchase:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="采购类型(1:原料 2:投入品 3:成品 4:办公用品)" prop="purchaseType">
          <el-select v-model="form.purchaseType" placeholder="请选择采购类型(1:原料 2:投入品 3:成品 4:办公用品)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="二级分类" prop="secondaryClassification">
          <el-input v-model="form.secondaryClassification" placeholder="请输入二级分类" />
        </el-form-item>
        <el-form-item label="采购单号" prop="purchaseOrderNumber">
          <el-input v-model="form.purchaseOrderNumber" placeholder="请输入采购单号" />
        </el-form-item>
        <el-form-item label="供应商(用户id)" prop="providerId">
          <el-input v-model="form.providerId" placeholder="请输入供应商(用户id)" />
        </el-form-item>
        <el-form-item label="供应商名称" prop="providerName">
          <el-input v-model="form.providerName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-form-item label="供应商联系方式" prop="providerContactInformation">
          <el-input v-model="form.providerContactInformation" placeholder="请输入供应商联系方式" />
        </el-form-item>
        <el-form-item label="采购时间" prop="purchaseTime">
          <el-date-picker clearable v-model="form.purchaseTime" type="date" value-format="timestamp" placeholder="选择采购时间" />
        </el-form-item>
        <el-form-item label="采购完成时间" prop="purchaseCompletionTime">
          <el-date-picker clearable v-model="form.purchaseCompletionTime" type="date" value-format="timestamp" placeholder="选择采购完成时间" />
        </el-form-item>
        <el-form-item label="采购总额（元）" prop="totalProcurement">
          <el-input v-model="form.totalProcurement" placeholder="请输入采购总额（元）" />
        </el-form-item>
        <el-form-item label="结算方式" prop="settlementMethod">
          <el-input v-model="form.settlementMethod" placeholder="请输入结算方式" />
        </el-form-item>
        <el-form-item label="收款名称" prop="beneficiaryName">
          <el-input v-model="form.beneficiaryName" placeholder="请输入收款名称" />
        </el-form-item>
        <el-form-item label="开户行" prop="bankOfDeposit">
          <el-input v-model="form.bankOfDeposit" placeholder="请输入开户行" />
        </el-form-item>
        <el-form-item label="收款账号" prop="collectionAccountNo">
          <el-input v-model="form.collectionAccountNo" placeholder="请输入收款账号" />
        </el-form-item>
        <el-form-item label="付款方式(0:微信 1:银联 2:支付宝 3:现金)" prop="paymentMethod">
          <el-input v-model="form.paymentMethod" placeholder="请输入付款方式(0:微信 1:银联 2:支付宝 3:现金)" />
        </el-form-item>
        <el-form-item label="采购人(用户id)" prop="purchaserId">
          <el-input v-model="form.purchaserId" placeholder="请输入采购人(用户id)" />
        </el-form-item>
        <el-form-item label="采购人姓名" prop="purchaserName">
          <el-input v-model="form.purchaserName" placeholder="请输入采购人姓名" />
        </el-form-item>
        <el-form-item label="采购部门id" prop="procurementDepartmentId">
          <el-input v-model="form.procurementDepartmentId" placeholder="请输入采购部门id" />
        </el-form-item>
        <el-form-item label="采购部门名称" prop="procurementDepartmentName">
          <el-input v-model="form.procurementDepartmentName" placeholder="请输入采购部门名称" />
        </el-form-item>
        <el-form-item label="省" prop="province">
          <el-input v-model="form.province" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="区" prop="area">
          <el-input v-model="form.area" placeholder="请输入区" />
        </el-form-item>
        <el-form-item label="详细地址" prop="detailedAddress">
          <el-input v-model="form.detailedAddress" placeholder="请输入详细地址" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="基地id" prop="baseId">
          <el-input v-model="form.baseId" placeholder="请输入基地id" />
        </el-form-item>
        <el-form-item label="地块id" prop="massifId">
          <el-input v-model="form.massifId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="采购状态(1.未开始 2.执行中 3.已完成 4.其他)" prop="purchaseStatus">
          <el-radio-group v-model="form.purchaseStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="报价单id" prop="quotationId">
          <el-input v-model="form.quotationId" placeholder="请输入报价单id" />
        </el-form-item>
        <el-form-item label="报价单号" prop="quotationNo">
          <el-input v-model="form.quotationNo" placeholder="请输入报价单号" />
        </el-form-item>
        <el-form-item label="有效期" prop="termOfValidity">
          <el-input v-model="form.termOfValidity" placeholder="请输入有效期" />
        </el-form-item>
        <el-form-item label="采收批次号" prop="collectionBatchNo">
          <el-input v-model="form.collectionBatchNo" placeholder="请输入采收批次号" />
        </el-form-item>
        <el-form-item label="交易单号(多个交易单用 "," 分割)" prop="transactionNo">
          <el-input v-model="form.transactionNo" placeholder="请输入交易单号(多个交易单用 "," 分割)" />
        </el-form-item>
        <el-form-item label="采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" prop="purchaseOrderSource">
          <el-input v-model="form.purchaseOrderSource" placeholder="请输入采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" />
        </el-form-item>
        <el-form-item label="状态(1.待生效 2.有效 3.无效)" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
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
import { createpurchase, updatepurchase, deletepurchase, getpurchase, getpurchasePage, exportpurchaseExcel } from "@/api/purchase/purchase";

export default {
  name: "purchase",
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
      // 采购单列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        id: null,
        purchaseType: null,
        secondaryClassification: null,
        purchaseOrderNumber: null,
        providerId: null,
        providerName: null,
        providerContactInformation: null,
        purchaseTime: [],
        purchaseCompletionTime: [],
        totalProcurement: null,
        settlementMethod: null,
        beneficiaryName: null,
        bankOfDeposit: null,
        collectionAccountNo: null,
        paymentMethod: null,
        purchaserId: null,
        purchaserName: null,
        procurementDepartmentId: null,
        procurementDepartmentName: null,
        province: null,
        city: null,
        area: null,
        detailedAddress: null,
        longitude: null,
        latitude: null,
        baseId: null,
        massifId: null,
        purchaseStatus: null,
        quotationId: null,
        quotationNo: null,
        termOfValidity: null,
        collectionBatchNo: null,
        transactionNo: null,
        purchaseOrderSource: null,
        status: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        purchaseOrderNumber: [{ required: true, message: "采购单号不能为空", trigger: "blur" }],
        providerId: [{ required: true, message: "供应商(用户id)不能为空", trigger: "blur" }],
        providerName: [{ required: true, message: "供应商名称不能为空", trigger: "blur" }],
        providerContactInformation: [{ required: true, message: "供应商联系方式不能为空", trigger: "blur" }],
        purchaseTime: [{ required: true, message: "采购时间不能为空", trigger: "blur" }],
        purchaserId: [{ required: true, message: "采购人(用户id)不能为空", trigger: "blur" }],
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
      getpurchasePage(this.queryParams).then(response => {
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
        purchaseType: undefined,
        secondaryClassification: undefined,
        purchaseOrderNumber: undefined,
        providerId: undefined,
        providerName: undefined,
        providerContactInformation: undefined,
        purchaseTime: undefined,
        purchaseCompletionTime: undefined,
        totalProcurement: undefined,
        settlementMethod: undefined,
        beneficiaryName: undefined,
        bankOfDeposit: undefined,
        collectionAccountNo: undefined,
        paymentMethod: undefined,
        purchaserId: undefined,
        purchaserName: undefined,
        procurementDepartmentId: undefined,
        procurementDepartmentName: undefined,
        province: undefined,
        city: undefined,
        area: undefined,
        detailedAddress: undefined,
        longitude: undefined,
        latitude: undefined,
        baseId: undefined,
        massifId: undefined,
        purchaseStatus: undefined,
        quotationId: undefined,
        quotationNo: undefined,
        termOfValidity: undefined,
        collectionBatchNo: undefined,
        transactionNo: undefined,
        purchaseOrderSource: undefined,
        status: undefined,
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
      this.title = "添加采购单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getpurchase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购单";
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
          updatepurchase(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createpurchase(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除采购单编号为"' + id + '"的数据项?').then(function() {
          return deletepurchase(id);
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
      this.$modal.confirm('是否确认导出所有采购单数据项?').then(() => {
          this.exportLoading = true;
          return exportpurchaseExcel(params);
        }).then(response => {
          this.$download.excel(response, '采购单.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
