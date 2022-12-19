<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="采购类型(1:原料 2:投入品 3:成品 4:办公用品)" prop="purchaseType">
        <el-select v-model="queryParams.purchaseType" placeholder="请选择采购类型(1:原料 2:投入品 3:成品 4:办公用品)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="二级分类" prop="secondaryClassification">
        <el-input v-model="queryParams.secondaryClassification" placeholder="请输入二级分类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单号" prop="purchaseNumber">
        <el-input v-model="queryParams.purchaseNumber" placeholder="请输入采购单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供应商(用户id)" prop="providerId">
        <el-input v-model="queryParams.providerId" placeholder="请输入供应商(用户id)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供应商名称" prop="providerName">
        <el-input v-model="queryParams.providerName" placeholder="请输入供应商名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供应商联系方式" prop="providerPhone">
        <el-input v-model="queryParams.providerPhone" placeholder="请输入供应商联系方式" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购时间" prop="purchaseTime">
        <el-date-picker v-model="queryParams.purchaseTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="采购完成时间" prop="complateTime">
        <el-date-picker v-model="queryParams.complateTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="采购总额（元）" prop="purchaseTotalAmount">
        <el-input v-model="queryParams.purchaseTotalAmount" placeholder="请输入采购总额（元）" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="结算方式1货到付款、2先款后货、3账期付款、4其他" prop="settlementType">
        <el-select v-model="queryParams.settlementType" placeholder="请选择结算方式1货到付款、2先款后货、3账期付款、4其他" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="收款名称" prop="beneficiaryName">
        <el-input v-model="queryParams.beneficiaryName" placeholder="请输入收款名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开户行" prop="bankDeposit">
        <el-input v-model="queryParams.bankDeposit" placeholder="请输入开户行" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="收款账号" prop="collectionAccount">
        <el-input v-model="queryParams.collectionAccount" placeholder="请输入收款账号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="付款方式(0微信1银联2支付宝3现金)" prop="payWay">
        <el-input v-model="queryParams.payWay" placeholder="请输入付款方式(0微信1银联2支付宝3现金)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购人id" prop="purchaserId">
        <el-input v-model="queryParams.purchaserId" placeholder="请输入采购人id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购人姓名" prop="purchaserName">
        <el-input v-model="queryParams.purchaserName" placeholder="请输入采购人姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购部门id" prop="purchaseOfficeId">
        <el-input v-model="queryParams.purchaseOfficeId" placeholder="请输入采购部门id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购部门名称" prop="purchaseOfficeName">
        <el-input v-model="queryParams.purchaseOfficeName" placeholder="请输入采购部门名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="省" prop="province">
        <el-input v-model="queryParams.province" placeholder="请输入省" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input v-model="queryParams.city" placeholder="请输入市" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区" prop="country">
        <el-input v-model="queryParams.country" placeholder="请输入区" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="详细地址" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入详细地址" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input v-model="queryParams.longitude" placeholder="请输入经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="纬度" prop="latitude">
        <el-input v-model="queryParams.latitude" placeholder="请输入纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地id" prop="basesId">
        <el-input v-model="queryParams.basesId" placeholder="请输入基地id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块id" prop="tunnelId">
        <el-input v-model="queryParams.tunnelId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购状态(1.未开始 2.执行中 3.已完成 4.其他)" prop="purchaseStatus">
        <el-select v-model="queryParams.purchaseStatus" placeholder="请选择采购状态(1.未开始 2.执行中 3.已完成 4.其他)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="报价单id" prop="quoteId">
        <el-input v-model="queryParams.quoteId" placeholder="请输入报价单id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="有效期" prop="effectiveStage">
        <el-input v-model="queryParams.effectiveStage" placeholder="请输入有效期" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采收批次号" prop="batchCode">
        <el-input v-model="queryParams.batchCode" placeholder="请输入采收批次号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="交易单号" prop="transactionNumber">
        <el-input v-model="queryParams.transactionNumber" placeholder="请输入交易单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['purchase:order:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:order:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="采购类型(1:原料 2:投入品 3:成品 4:办公用品)" align="center" prop="purchaseType" />
      <el-table-column label="二级分类" align="center" prop="secondaryClassification" />
      <el-table-column label="采购单号" align="center" prop="purchaseNumber" />
      <el-table-column label="供应商(用户id)" align="center" prop="providerId" />
      <el-table-column label="供应商名称" align="center" prop="providerName" />
      <el-table-column label="供应商联系方式" align="center" prop="providerPhone" />
      <el-table-column label="采购时间" align="center" prop="purchaseTime" />
      <el-table-column label="采购完成时间" align="center" prop="complateTime" />
      <el-table-column label="采购总额（元）" align="center" prop="purchaseTotalAmount" />
      <el-table-column label="结算方式1货到付款、2先款后货、3账期付款、4其他" align="center" prop="settlementType" />
      <el-table-column label="收款名称" align="center" prop="beneficiaryName" />
      <el-table-column label="开户行" align="center" prop="bankDeposit" />
      <el-table-column label="收款账号" align="center" prop="collectionAccount" />
      <el-table-column label="付款方式(0微信1银联2支付宝3现金)" align="center" prop="payWay" />
      <el-table-column label="采购人id" align="center" prop="purchaserId" />
      <el-table-column label="采购人姓名" align="center" prop="purchaserName" />
      <el-table-column label="采购部门id" align="center" prop="purchaseOfficeId" />
      <el-table-column label="采购部门名称" align="center" prop="purchaseOfficeName" />
      <el-table-column label="省" align="center" prop="province" />
      <el-table-column label="市" align="center" prop="city" />
      <el-table-column label="区" align="center" prop="country" />
      <el-table-column label="详细地址" align="center" prop="address" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="基地id" align="center" prop="basesId" />
      <el-table-column label="地块id" align="center" prop="tunnelId" />
      <el-table-column label="采购状态(1.未开始 2.执行中 3.已完成 4.其他)" align="center" prop="purchaseStatus" />
      <el-table-column label="报价单id" align="center" prop="quoteId" />
      <el-table-column label="有效期" align="center" prop="effectiveStage" />
      <el-table-column label="采收批次号" align="center" prop="batchCode" />
      <el-table-column label="交易单号" align="center" prop="transactionNumber" />
      <el-table-column label="采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" align="center" prop="source" />
      <el-table-column label="状态(1.待生效 2.有效 3.无效)" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:order:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:order:delete']">删除</el-button>
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
        <el-form-item label="采购单号" prop="purchaseNumber">
          <el-input v-model="form.purchaseNumber" placeholder="请输入采购单号" />
        </el-form-item>
        <el-form-item label="供应商(用户id)" prop="providerId">
          <el-input v-model="form.providerId" placeholder="请输入供应商(用户id)" />
        </el-form-item>
        <el-form-item label="供应商名称" prop="providerName">
          <el-input v-model="form.providerName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-form-item label="供应商联系方式" prop="providerPhone">
          <el-input v-model="form.providerPhone" placeholder="请输入供应商联系方式" />
        </el-form-item>
        <el-form-item label="采购时间" prop="purchaseTime">
          <el-date-picker clearable v-model="form.purchaseTime" type="date" value-format="timestamp" placeholder="选择采购时间" />
        </el-form-item>
        <el-form-item label="采购完成时间" prop="complateTime">
          <el-date-picker clearable v-model="form.complateTime" type="date" value-format="timestamp" placeholder="选择采购完成时间" />
        </el-form-item>
        <el-form-item label="采购总额（元）" prop="purchaseTotalAmount">
          <el-input v-model="form.purchaseTotalAmount" placeholder="请输入采购总额（元）" />
        </el-form-item>
        <el-form-item label="结算方式1货到付款、2先款后货、3账期付款、4其他" prop="settlementType">
          <el-select v-model="form.settlementType" placeholder="请选择结算方式1货到付款、2先款后货、3账期付款、4其他">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="收款名称" prop="beneficiaryName">
          <el-input v-model="form.beneficiaryName" placeholder="请输入收款名称" />
        </el-form-item>
        <el-form-item label="开户行" prop="bankDeposit">
          <el-input v-model="form.bankDeposit" placeholder="请输入开户行" />
        </el-form-item>
        <el-form-item label="收款账号" prop="collectionAccount">
          <el-input v-model="form.collectionAccount" placeholder="请输入收款账号" />
        </el-form-item>
        <el-form-item label="付款方式(0微信1银联2支付宝3现金)" prop="payWay">
          <el-input v-model="form.payWay" placeholder="请输入付款方式(0微信1银联2支付宝3现金)" />
        </el-form-item>
        <el-form-item label="采购人id" prop="purchaserId">
          <el-input v-model="form.purchaserId" placeholder="请输入采购人id" />
        </el-form-item>
        <el-form-item label="采购人姓名" prop="purchaserName">
          <el-input v-model="form.purchaserName" placeholder="请输入采购人姓名" />
        </el-form-item>
        <el-form-item label="采购部门id" prop="purchaseOfficeId">
          <el-input v-model="form.purchaseOfficeId" placeholder="请输入采购部门id" />
        </el-form-item>
        <el-form-item label="采购部门名称" prop="purchaseOfficeName">
          <el-input v-model="form.purchaseOfficeName" placeholder="请输入采购部门名称" />
        </el-form-item>
        <el-form-item label="省" prop="province">
          <el-input v-model="form.province" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="区" prop="country">
          <el-input v-model="form.country" placeholder="请输入区" />
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入详细地址" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="基地id" prop="basesId">
          <el-input v-model="form.basesId" placeholder="请输入基地id" />
        </el-form-item>
        <el-form-item label="地块id" prop="tunnelId">
          <el-input v-model="form.tunnelId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="采购状态(1.未开始 2.执行中 3.已完成 4.其他)" prop="purchaseStatus">
          <el-radio-group v-model="form.purchaseStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="报价单id" prop="quoteId">
          <el-input v-model="form.quoteId" placeholder="请输入报价单id" />
        </el-form-item>
        <el-form-item label="有效期" prop="effectiveStage">
          <el-input v-model="form.effectiveStage" placeholder="请输入有效期" />
        </el-form-item>
        <el-form-item label="采收批次号" prop="batchCode">
          <el-input v-model="form.batchCode" placeholder="请输入采收批次号" />
        </el-form-item>
        <el-form-item label="交易单号" prop="transactionNumber">
          <el-input v-model="form.transactionNumber" placeholder="请输入交易单号" />
        </el-form-item>
        <el-form-item label="采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" prop="source">
          <el-input v-model="form.source" placeholder="请输入采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)" />
        </el-form-item>
        <el-form-item label="状态(1.待生效 2.有效 3.无效)" prop="status">
          <el-radio-group v-model="form.status">
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
import { createOrder, updateOrder, deleteOrder, getOrder, getOrderPage, exportOrderExcel } from "@/api/purchase/order";

export default {
  name: "Order",
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
        purchaseType: null,
        secondaryClassification: null,
        purchaseNumber: null,
        providerId: null,
        providerName: null,
        providerPhone: null,
        purchaseTime: [],
        complateTime: [],
        purchaseTotalAmount: null,
        settlementType: null,
        beneficiaryName: null,
        bankDeposit: null,
        collectionAccount: null,
        payWay: null,
        purchaserId: null,
        purchaserName: null,
        purchaseOfficeId: null,
        purchaseOfficeName: null,
        province: null,
        city: null,
        country: null,
        address: null,
        longitude: null,
        latitude: null,
        basesId: null,
        tunnelId: null,
        purchaseStatus: null,
        quoteId: null,
        effectiveStage: null,
        batchCode: null,
        transactionNumber: null,
        source: null,
        status: null,
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        purchaseNumber: [{ required: true, message: "采购单号不能为空", trigger: "blur" }],
        providerId: [{ required: true, message: "供应商(用户id)不能为空", trigger: "blur" }],
        providerName: [{ required: true, message: "供应商名称不能为空", trigger: "blur" }],
        providerPhone: [{ required: true, message: "供应商联系方式不能为空", trigger: "blur" }],
        purchaseTime: [{ required: true, message: "采购时间不能为空", trigger: "blur" }],
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
      getOrderPage(this.queryParams).then(response => {
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
        purchaseType: undefined,
        secondaryClassification: undefined,
        purchaseNumber: undefined,
        providerId: undefined,
        providerName: undefined,
        providerPhone: undefined,
        purchaseTime: undefined,
        complateTime: undefined,
        purchaseTotalAmount: undefined,
        settlementType: undefined,
        beneficiaryName: undefined,
        bankDeposit: undefined,
        collectionAccount: undefined,
        payWay: undefined,
        purchaserId: undefined,
        purchaserName: undefined,
        purchaseOfficeId: undefined,
        purchaseOfficeName: undefined,
        province: undefined,
        city: undefined,
        country: undefined,
        address: undefined,
        longitude: undefined,
        latitude: undefined,
        basesId: undefined,
        tunnelId: undefined,
        purchaseStatus: undefined,
        quoteId: undefined,
        effectiveStage: undefined,
        batchCode: undefined,
        transactionNumber: undefined,
        source: undefined,
        status: undefined,
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
      this.title = "添加采购单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getOrder(id).then(response => {
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
          updateOrder(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createOrder(this.form).then(response => {
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
          return deleteOrder(id);
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
          return exportOrderExcel(params);
        }).then(response => {
          this.$download.excel(response, '采购单.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
