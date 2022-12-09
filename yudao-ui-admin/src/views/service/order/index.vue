<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="交易单号" prop="transactionNumber">
        <el-input v-model="queryParams.transactionNumber" placeholder="请输入交易单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务用户id" prop="serviceUserId">
        <el-input v-model="queryParams.serviceUserId" placeholder="请输入服务用户id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="手机号" prop="cellphoneNumber">
        <el-input v-model="queryParams.cellphoneNumber" placeholder="请输入手机号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="下单时间" prop="orderTime">
        <el-date-picker v-model="queryParams.orderTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="交易总额" prop="totalAmount">
        <el-input v-model="queryParams.totalAmount" placeholder="请输入交易总额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务id" prop="serviceId">
        <el-input v-model="queryParams.serviceId" placeholder="请输入服务id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务权益id" prop="serviceEquitiesId">
        <el-input v-model="queryParams.serviceEquitiesId" placeholder="请输入服务权益id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="参与人数" prop="participation">
        <el-input v-model="queryParams.participation" placeholder="请输入参与人数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务费" prop="serviceCharge">
        <el-input v-model="queryParams.serviceCharge" placeholder="请输入服务费" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销" prop="orderStatus">
        <el-select v-model="queryParams.orderStatus" placeholder="请选择交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="服务权益id" prop="servicePriceId">
        <el-input v-model="queryParams.servicePriceId" placeholder="请输入服务权益id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="下单人" prop="systemUserId">
        <el-input v-model="queryParams.systemUserId" placeholder="请输入下单人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="认养物的id" prop="carrierId">
        <el-input v-model="queryParams.carrierId" placeholder="请输入认养物的id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订阅地区" prop="areaCode">
        <el-input v-model="queryParams.areaCode" placeholder="请输入订阅地区" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订单类型(0 农事订单,1 认购订单)" prop="orderType">
        <el-select v-model="queryParams.orderType" placeholder="请选择订单类型(0 农事订单,1 认购订单)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="套票id" prop="ticketPackageId">
        <el-input v-model="queryParams.ticketPackageId" placeholder="请输入套票id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="支付方式(0.现金 1.套票)" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择支付方式(0.现金 1.套票)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="活动场次id" prop="activitySessionId">
        <el-input v-model="queryParams.activitySessionId" placeholder="请输入活动场次id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="家庭成员id" prop="farmFamilyId">
        <el-input v-model="queryParams.farmFamilyId" placeholder="请输入家庭成员id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="微信支付系统订单号" prop="weixinOrderId">
        <el-input v-model="queryParams.weixinOrderId" placeholder="请输入微信支付系统订单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="兑换码" prop="exchangeCode">
        <el-input v-model="queryParams.exchangeCode" placeholder="请输入兑换码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="核销操作人" prop="scanOperator">
        <el-input v-model="queryParams.scanOperator" placeholder="请输入核销操作人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="核销时间" prop="scanDate">
        <el-date-picker v-model="queryParams.scanDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="有效期" prop="expiryDate">
        <el-date-picker v-model="queryParams.expiryDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="项目来源" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入项目来源" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['service:order:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:order:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="交易单号" align="center" prop="transactionNumber" />
      <el-table-column label="服务用户id" align="center" prop="serviceUserId" />
      <el-table-column label="手机号" align="center" prop="cellphoneNumber" />
      <el-table-column label="下单时间" align="center" prop="orderTime" />
      <el-table-column label="交易总额" align="center" prop="totalAmount" />
      <el-table-column label="服务id" align="center" prop="serviceId" />
      <el-table-column label="服务权益id" align="center" prop="serviceEquitiesId" />
      <el-table-column label="参与人数" align="center" prop="participation" />
      <el-table-column label="服务费" align="center" prop="serviceCharge" />
      <el-table-column label="交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销" align="center" prop="orderStatus" />
      <el-table-column label="服务权益id" align="center" prop="servicePriceId" />
      <el-table-column label="下单人" align="center" prop="systemUserId" />
      <el-table-column label="认养物的id" align="center" prop="carrierId" />
      <el-table-column label="订阅地区" align="center" prop="areaCode" />
      <el-table-column label="订单类型(0 农事订单,1 认购订单)" align="center" prop="orderType" />
      <el-table-column label="套票id" align="center" prop="ticketPackageId" />
      <el-table-column label="支付方式(0.现金 1.套票)" align="center" prop="payType" />
      <el-table-column label="活动场次id" align="center" prop="activitySessionId" />
      <el-table-column label="家庭成员id" align="center" prop="farmFamilyId" />
      <el-table-column label="微信支付系统订单号" align="center" prop="weixinOrderId" />
      <el-table-column label="兑换码" align="center" prop="exchangeCode" />
      <el-table-column label="核销操作人" align="center" prop="scanOperator" />
      <el-table-column label="核销时间" align="center" prop="scanDate" />
      <el-table-column label="有效期" align="center" prop="expiryDate" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:order:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:order:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="交易单号" prop="transactionNumber">
          <el-input v-model="form.transactionNumber" placeholder="请输入交易单号" />
        </el-form-item>
        <el-form-item label="服务用户id" prop="serviceUserId">
          <el-input v-model="form.serviceUserId" placeholder="请输入服务用户id" />
        </el-form-item>
        <el-form-item label="手机号" prop="cellphoneNumber">
          <el-input v-model="form.cellphoneNumber" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="下单时间" prop="orderTime">
          <el-date-picker clearable v-model="form.orderTime" type="date" value-format="timestamp" placeholder="选择下单时间" />
        </el-form-item>
        <el-form-item label="交易总额" prop="totalAmount">
          <el-input v-model="form.totalAmount" placeholder="请输入交易总额" />
        </el-form-item>
        <el-form-item label="服务id" prop="serviceId">
          <el-input v-model="form.serviceId" placeholder="请输入服务id" />
        </el-form-item>
        <el-form-item label="服务权益id" prop="serviceEquitiesId">
          <el-input v-model="form.serviceEquitiesId" placeholder="请输入服务权益id" />
        </el-form-item>
        <el-form-item label="参与人数" prop="participation">
          <el-input v-model="form.participation" placeholder="请输入参与人数" />
        </el-form-item>
        <el-form-item label="服务费" prop="serviceCharge">
          <el-input v-model="form.serviceCharge" placeholder="请输入服务费" />
        </el-form-item>
        <el-form-item label="交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销" prop="orderStatus">
          <el-radio-group v-model="form.orderStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="服务权益id" prop="servicePriceId">
          <el-input v-model="form.servicePriceId" placeholder="请输入服务权益id" />
        </el-form-item>
        <el-form-item label="下单人" prop="systemUserId">
          <el-input v-model="form.systemUserId" placeholder="请输入下单人" />
        </el-form-item>
        <el-form-item label="认养物的id" prop="carrierId">
          <el-input v-model="form.carrierId" placeholder="请输入认养物的id" />
        </el-form-item>
        <el-form-item label="订阅地区" prop="areaCode">
          <el-input v-model="form.areaCode" placeholder="请输入订阅地区" />
        </el-form-item>
        <el-form-item label="订单类型(0 农事订单,1 认购订单)" prop="orderType">
          <el-select v-model="form.orderType" placeholder="请选择订单类型(0 农事订单,1 认购订单)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="套票id" prop="ticketPackageId">
          <el-input v-model="form.ticketPackageId" placeholder="请输入套票id" />
        </el-form-item>
        <el-form-item label="支付方式(0.现金 1.套票)" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择支付方式(0.现金 1.套票)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="活动场次id" prop="activitySessionId">
          <el-input v-model="form.activitySessionId" placeholder="请输入活动场次id" />
        </el-form-item>
        <el-form-item label="家庭成员id" prop="farmFamilyId">
          <el-input v-model="form.farmFamilyId" placeholder="请输入家庭成员id" />
        </el-form-item>
        <el-form-item label="微信支付系统订单号" prop="weixinOrderId">
          <el-input v-model="form.weixinOrderId" placeholder="请输入微信支付系统订单号" />
        </el-form-item>
        <el-form-item label="兑换码" prop="exchangeCode">
          <el-input v-model="form.exchangeCode" placeholder="请输入兑换码" />
        </el-form-item>
        <el-form-item label="核销操作人" prop="scanOperator">
          <el-input v-model="form.scanOperator" placeholder="请输入核销操作人" />
        </el-form-item>
        <el-form-item label="核销时间" prop="scanDate">
          <el-date-picker clearable v-model="form.scanDate" type="date" value-format="timestamp" placeholder="选择核销时间" />
        </el-form-item>
        <el-form-item label="有效期" prop="expiryDate">
          <el-date-picker clearable v-model="form.expiryDate" type="date" value-format="timestamp" placeholder="选择有效期" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="项目来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入项目来源" />
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
import { createOrder, updateOrder, deleteOrder, getOrder, getOrderPage, exportOrderExcel } from "@/api/service/order";

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
      // 服务交易单列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        transactionNumber: null,
        serviceUserId: null,
        cellphoneNumber: null,
        orderTime: [],
        totalAmount: null,
        serviceId: null,
        serviceEquitiesId: null,
        participation: null,
        serviceCharge: null,
        orderStatus: null,
        servicePriceId: null,
        systemUserId: null,
        carrierId: null,
        areaCode: null,
        orderType: null,
        ticketPackageId: null,
        payType: null,
        activitySessionId: null,
        farmFamilyId: null,
        weixinOrderId: null,
        exchangeCode: null,
        scanOperator: null,
        scanDate: [],
        expiryDate: [],
        status: null,
        createTime: [],
        source: null,
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
        transactionNumber: undefined,
        serviceUserId: undefined,
        cellphoneNumber: undefined,
        orderTime: undefined,
        totalAmount: undefined,
        serviceId: undefined,
        serviceEquitiesId: undefined,
        participation: undefined,
        serviceCharge: undefined,
        orderStatus: undefined,
        servicePriceId: undefined,
        systemUserId: undefined,
        carrierId: undefined,
        areaCode: undefined,
        orderType: undefined,
        ticketPackageId: undefined,
        payType: undefined,
        activitySessionId: undefined,
        farmFamilyId: undefined,
        weixinOrderId: undefined,
        exchangeCode: undefined,
        scanOperator: undefined,
        scanDate: undefined,
        expiryDate: undefined,
        status: undefined,
        source: undefined,
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
      this.title = "添加服务交易单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改服务交易单";
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
      this.$modal.confirm('是否确认删除服务交易单编号为"' + id + '"的数据项?').then(function() {
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
      this.$modal.confirm('是否确认导出所有服务交易单数据项?').then(() => {
          this.exportLoading = true;
          return exportOrderExcel(params);
        }).then(response => {
          this.$download.excel(response, '服务交易单.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
