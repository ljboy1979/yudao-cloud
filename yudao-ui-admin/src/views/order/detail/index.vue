<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="货架名称" prop="shelvesName">
        <el-input v-model="queryParams.shelvesName" placeholder="请输入货架名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="规格名称" prop="specificationName">
        <el-input v-model="queryParams.specificationName" placeholder="请输入规格名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="配送时间" prop="deliveryTime">
        <el-date-picker v-model="queryParams.deliveryTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
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
                   v-hasPermi="['order:detail:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['order:detail:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="编码" align="center" prop="code" />
      <el-table-column label="订单id" align="center" prop="orderId" />
      <el-table-column label="计划id" align="center" prop="planId" />
      <el-table-column label="货架id" align="center" prop="shelvesId" />
      <el-table-column label="货架名称" align="center" prop="shelvesName" />
      <el-table-column label="规格id" align="center" prop="specificationId" />
      <el-table-column label="规格名称" align="center" prop="specificationName" />
      <el-table-column label="计量单位" align="center" prop="measureUnit" />
      <el-table-column label="预定的用户" align="center" prop="userId" />
      <el-table-column label=" 餐次（1早 2中 3晚）" align="center" prop="mealsTime" />
      <el-table-column label="单价" align="center" prop="unitPrice" />
      <el-table-column label="购买量" align="center" prop="num" />
      <el-table-column label="总价" align="center" prop="totalPrice" />
      <el-table-column label="收货单价" align="center" prop="takeUnitPrice" />
      <el-table-column label="收货数量" align="center" prop="takeNum" />
      <el-table-column label="收货金额" align="center" prop="takePrice" />
      <el-table-column label="退补说明" align="center" prop="priceSpreadExplain" />
      <el-table-column label="退补差价" align="center" prop="priceSpread" />
      <el-table-column label="付款状态 0 未付款  1 已付款  2退款" align="center" prop="payStatus" />
      <el-table-column label="配送状态 默认状态0待配送 1已配送" align="center" prop="sendStatus" />
      <el-table-column label="配送时间" align="center" prop="deliveryTime" />
      <el-table-column label="处理规格" align="center" prop="processTagName" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="source" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['order:detail:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['order:detail:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入编码" />
        </el-form-item>
        <el-form-item label="订单id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入订单id" />
        </el-form-item>
        <el-form-item label="计划id" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入计划id" />
        </el-form-item>
        <el-form-item label="货架id" prop="shelvesId">
          <el-input v-model="form.shelvesId" placeholder="请输入货架id" />
        </el-form-item>
        <el-form-item label="货架名称" prop="shelvesName">
          <el-input v-model="form.shelvesName" placeholder="请输入货架名称" />
        </el-form-item>
        <el-form-item label="规格id" prop="specificationId">
          <el-input v-model="form.specificationId" placeholder="请输入规格id" />
        </el-form-item>
        <el-form-item label="规格名称" prop="specificationName">
          <el-input v-model="form.specificationName" placeholder="请输入规格名称" />
        </el-form-item>
        <el-form-item label="计量单位" prop="measureUnit">
          <el-input v-model="form.measureUnit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="预定的用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入预定的用户" />
        </el-form-item>
        <el-form-item label=" 餐次（1早 2中 3晚）" prop="mealsTime">
          <el-date-picker clearable v-model="form.mealsTime" type="date" value-format="timestamp" placeholder="选择 餐次（1早 2中 3晚）" />
        </el-form-item>
        <el-form-item label="单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="购买量" prop="num">
          <el-input v-model="form.num" placeholder="请输入购买量" />
        </el-form-item>
        <el-form-item label="总价" prop="totalPrice">
          <el-input v-model="form.totalPrice" placeholder="请输入总价" />
        </el-form-item>
        <el-form-item label="收货单价" prop="takeUnitPrice">
          <el-input v-model="form.takeUnitPrice" placeholder="请输入收货单价" />
        </el-form-item>
        <el-form-item label="收货数量" prop="takeNum">
          <el-input v-model="form.takeNum" placeholder="请输入收货数量" />
        </el-form-item>
        <el-form-item label="收货金额" prop="takePrice">
          <el-input v-model="form.takePrice" placeholder="请输入收货金额" />
        </el-form-item>
        <el-form-item label="退补说明" prop="priceSpreadExplain">
          <el-input v-model="form.priceSpreadExplain" placeholder="请输入退补说明" />
        </el-form-item>
        <el-form-item label="退补差价" prop="priceSpread">
          <el-input v-model="form.priceSpread" placeholder="请输入退补差价" />
        </el-form-item>
        <el-form-item label="付款状态 0 未付款  1 已付款  2退款" prop="payStatus">
          <el-radio-group v-model="form.payStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="配送状态 默认状态0待配送 1已配送" prop="sendStatus">
          <el-radio-group v-model="form.sendStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="配送时间" prop="deliveryTime">
          <el-date-picker clearable v-model="form.deliveryTime" type="date" value-format="timestamp" placeholder="选择配送时间" />
        </el-form-item>
        <el-form-item label="处理规格" prop="processTagName">
          <el-input v-model="form.processTagName" placeholder="请输入处理规格" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
        </el-form-item>
        <el-form-item label="source" prop="source">
          <el-input v-model="form.source" placeholder="请输入source" />
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
import { createDetail, updateDetail, deleteDetail, getDetail, getDetailPage, exportDetailExcel } from "@/api/order/detail";

export default {
  name: "Detail",
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
      // 订单详情列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        shelvesName: null,
        specificationName: null,
        deliveryTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        code: [{ required: true, message: "编码不能为空", trigger: "blur" }],
        orderId: [{ required: true, message: "订单id不能为空", trigger: "blur" }],
        payStatus: [{ required: true, message: "付款状态 0 未付款  1 已付款  2退款不能为空", trigger: "blur" }],
        sendStatus: [{ required: true, message: "配送状态 默认状态0待配送 1已配送不能为空", trigger: "blur" }],
        status: [{ required: true, message: "状态不能为空", trigger: "blur" }],
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
      getDetailPage(this.queryParams).then(response => {
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
        code: undefined,
        orderId: undefined,
        planId: undefined,
        shelvesId: undefined,
        shelvesName: undefined,
        specificationId: undefined,
        specificationName: undefined,
        measureUnit: undefined,
        userId: undefined,
        mealsTime: undefined,
        unitPrice: undefined,
        num: undefined,
        totalPrice: undefined,
        takeUnitPrice: undefined,
        takeNum: undefined,
        takePrice: undefined,
        priceSpreadExplain: undefined,
        priceSpread: undefined,
        payStatus: undefined,
        sendStatus: undefined,
        deliveryTime: undefined,
        processTagName: undefined,
        status: undefined,
        subjectId: undefined,
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
      this.title = "添加订单详情";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单详情";
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
          updateDetail(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createDetail(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除订单详情编号为"' + id + '"的数据项?').then(function() {
          return deleteDetail(id);
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
      this.$modal.confirm('是否确认导出所有订单详情数据项?').then(() => {
          this.exportLoading = true;
          return exportDetailExcel(params);
        }).then(response => {
          this.$download.excel(response, '订单详情.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
