<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="采购单编号" prop="purchaseId">
        <el-input v-model="queryParams.purchaseId" placeholder="请输入采购单编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购单号" prop="purchaseNumber">
        <el-input v-model="queryParams.purchaseNumber" placeholder="请输入采购单号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="交付批次号(系统自动生成)" prop="batchCode">
        <el-input v-model="queryParams.batchCode" placeholder="请输入交付批次号(系统自动生成)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="期望交付时间" prop="expectedDeliveryTime">
        <el-date-picker v-model="queryParams.expectedDeliveryTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="实际交付时间" prop="actualDelivery">
        <el-input v-model="queryParams.actualDelivery" placeholder="请输入实际交付时间" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="期望交付数量" prop="expectedDeliveryCount">
        <el-input v-model="queryParams.expectedDeliveryCount" placeholder="请输入期望交付数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="实际交付数量" prop="actualDeliveryCount">
        <el-input v-model="queryParams.actualDeliveryCount" placeholder="请输入实际交付数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="单位(字典id)" prop="companyId">
        <el-input v-model="queryParams.companyId" placeholder="请输入单位(字典id)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="结算时间" prop="settlementTime">
        <el-date-picker v-model="queryParams.settlementTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结算金额" prop="settlementAmount">
        <el-input v-model="queryParams.settlementAmount" placeholder="请输入结算金额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="1.未交付 2.已交付" prop="deliveryStatus">
        <el-select v-model="queryParams.deliveryStatus" placeholder="请选择1.未交付 2.已交付" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="发货单号" prop="shipmentNo">
        <el-input v-model="queryParams.shipmentNo" placeholder="请输入发货单号" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['purchase:deliver:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:deliver:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="采购单编号" align="center" prop="purchaseId" />
      <el-table-column label="采购单号" align="center" prop="purchaseNumber" />
      <el-table-column label="交付批次号(系统自动生成)" align="center" prop="batchCode" />
      <el-table-column label="期望交付时间" align="center" prop="expectedDeliveryTime" />
      <el-table-column label="实际交付时间" align="center" prop="actualDelivery" />
      <el-table-column label="期望交付数量" align="center" prop="expectedDeliveryCount" />
      <el-table-column label="实际交付数量" align="center" prop="actualDeliveryCount" />
      <el-table-column label="单位(字典id)" align="center" prop="companyId" />
      <el-table-column label="结算时间" align="center" prop="settlementTime" />
      <el-table-column label="结算金额" align="center" prop="settlementAmount" />
      <el-table-column label="1.未交付 2.已交付" align="center" prop="deliveryStatus" />
      <el-table-column label="发货单号" align="center" prop="shipmentNo" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:deliver:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:deliver:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="采购单编号" prop="purchaseId">
          <el-input v-model="form.purchaseId" placeholder="请输入采购单编号" />
        </el-form-item>
        <el-form-item label="采购单号" prop="purchaseNumber">
          <el-input v-model="form.purchaseNumber" placeholder="请输入采购单号" />
        </el-form-item>
        <el-form-item label="交付批次号(系统自动生成)" prop="batchCode">
          <el-input v-model="form.batchCode" placeholder="请输入交付批次号(系统自动生成)" />
        </el-form-item>
        <el-form-item label="期望交付时间" prop="expectedDeliveryTime">
          <el-date-picker clearable v-model="form.expectedDeliveryTime" type="date" value-format="timestamp" placeholder="选择期望交付时间" />
        </el-form-item>
        <el-form-item label="实际交付时间" prop="actualDelivery">
          <el-input v-model="form.actualDelivery" placeholder="请输入实际交付时间" />
        </el-form-item>
        <el-form-item label="期望交付数量" prop="expectedDeliveryCount">
          <el-input v-model="form.expectedDeliveryCount" placeholder="请输入期望交付数量" />
        </el-form-item>
        <el-form-item label="实际交付数量" prop="actualDeliveryCount">
          <el-input v-model="form.actualDeliveryCount" placeholder="请输入实际交付数量" />
        </el-form-item>
        <el-form-item label="单位(字典id)" prop="companyId">
          <el-input v-model="form.companyId" placeholder="请输入单位(字典id)" />
        </el-form-item>
        <el-form-item label="结算时间" prop="settlementTime">
          <el-date-picker clearable v-model="form.settlementTime" type="date" value-format="timestamp" placeholder="选择结算时间" />
        </el-form-item>
        <el-form-item label="结算金额" prop="settlementAmount">
          <el-input v-model="form.settlementAmount" placeholder="请输入结算金额" />
        </el-form-item>
        <el-form-item label="1.未交付 2.已交付" prop="deliveryStatus">
          <el-radio-group v-model="form.deliveryStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="发货单号" prop="shipmentNo">
          <el-input v-model="form.shipmentNo" placeholder="请输入发货单号" />
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
import { createDeliver, updateDeliver, deleteDeliver, getDeliver, getDeliverPage, exportDeliverExcel } from "@/api/purchase/deliver";

export default {
  name: "Deliver",
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
      // 采购交付列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        purchaseId: null,
        purchaseNumber: null,
        batchCode: null,
        expectedDeliveryTime: [],
        actualDelivery: null,
        expectedDeliveryCount: null,
        actualDeliveryCount: null,
        companyId: null,
        settlementTime: [],
        settlementAmount: null,
        deliveryStatus: null,
        shipmentNo: null,
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        purchaseId: [{ required: true, message: "采购单编号不能为空", trigger: "blur" }],
        purchaseNumber: [{ required: true, message: "采购单号不能为空", trigger: "blur" }],
        batchCode: [{ required: true, message: "交付批次号(系统自动生成)不能为空", trigger: "blur" }],
        expectedDeliveryTime: [{ required: true, message: "期望交付时间不能为空", trigger: "blur" }],
        expectedDeliveryCount: [{ required: true, message: "期望交付数量不能为空", trigger: "blur" }],
        companyId: [{ required: true, message: "单位(字典id)不能为空", trigger: "blur" }],
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
      getDeliverPage(this.queryParams).then(response => {
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
        purchaseId: undefined,
        purchaseNumber: undefined,
        batchCode: undefined,
        expectedDeliveryTime: undefined,
        actualDelivery: undefined,
        expectedDeliveryCount: undefined,
        actualDeliveryCount: undefined,
        companyId: undefined,
        settlementTime: undefined,
        settlementAmount: undefined,
        deliveryStatus: undefined,
        shipmentNo: undefined,
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
      this.title = "添加采购交付";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getDeliver(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购交付";
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
          updateDeliver(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createDeliver(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除采购交付编号为"' + id + '"的数据项?').then(function() {
          return deleteDeliver(id);
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
      this.$modal.confirm('是否确认导出所有采购交付数据项?').then(() => {
          this.exportLoading = true;
          return exportDeliverExcel(params);
        }).then(response => {
          this.$download.excel(response, '采购交付.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
