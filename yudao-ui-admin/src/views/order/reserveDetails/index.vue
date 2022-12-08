<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="commodityName">
        <el-input v-model="queryParams.commodityName" placeholder="请输入商品名称" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['order:reserve-details:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['order:reserve-details:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="预定id" align="center" prop="reserveId" />
      <el-table-column label="商品名称" align="center" prop="commodityName" />
      <el-table-column label="规格名称" align="center" prop="specificationName" />
      <el-table-column label="购买数量" align="center" prop="num" />
      <el-table-column label="市场价格" align="center" prop="marketPrice" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="套餐状态（默认 0未付款 1已取消 2已锁定）" align="center" prop="planStatus" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="来源" align="center" prop="source" />
      <el-table-column label="捕捞商品id" align="center" prop="osCommodityFishingId" />
      <el-table-column label="捕捞规格id" align="center" prop="productSpecificationsFishingId" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="配送方式 0包邮 1不包邮" align="center" prop="sendType" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['order:reserve-details:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['order:reserve-details:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="预定id" prop="reserveId">
          <el-input v-model="form.reserveId" placeholder="请输入预定id" />
        </el-form-item>
        <el-form-item label="商品名称" prop="commodityName">
          <el-input v-model="form.commodityName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="规格名称" prop="specificationName">
          <el-input v-model="form.specificationName" placeholder="请输入规格名称" />
        </el-form-item>
        <el-form-item label="购买数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入购买数量" />
        </el-form-item>
        <el-form-item label="市场价格" prop="marketPrice">
          <el-input v-model="form.marketPrice" placeholder="请输入市场价格" />
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
        </el-form-item>
        <el-form-item label="套餐状态（默认 0未付款 1已取消 2已锁定）" prop="planStatus">
          <el-radio-group v-model="form.planStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入来源" />
        </el-form-item>
        <el-form-item label="捕捞商品id" prop="osCommodityFishingId">
          <el-input v-model="form.osCommodityFishingId" placeholder="请输入捕捞商品id" />
        </el-form-item>
        <el-form-item label="捕捞规格id" prop="productSpecificationsFishingId">
          <el-input v-model="form.productSpecificationsFishingId" placeholder="请输入捕捞规格id" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="配送方式 0包邮 1不包邮" prop="sendType">
          <el-select v-model="form.sendType" placeholder="请选择配送方式 0包邮 1不包邮">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
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
import { createReserveDetails, updateReserveDetails, deleteReserveDetails, getReserveDetails, getReserveDetailsPage, exportReserveDetailsExcel } from "@/api/order/reserveDetails";

export default {
  name: "ReserveDetails",
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
      // 订单预定详情列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        commodityName: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        reserveId: [{ required: true, message: "预定id不能为空", trigger: "blur" }],
        commodityName: [{ required: true, message: "商品名称不能为空", trigger: "blur" }],
        osCommodityFishingId: [{ required: true, message: "捕捞商品id不能为空", trigger: "blur" }],
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
      getReserveDetailsPage(this.queryParams).then(response => {
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
        reserveId: undefined,
        commodityName: undefined,
        specificationName: undefined,
        num: undefined,
        marketPrice: undefined,
        subjectId: undefined,
        planStatus: undefined,
        price: undefined,
        source: undefined,
        osCommodityFishingId: undefined,
        productSpecificationsFishingId: undefined,
        remarks: undefined,
        sendType: undefined,
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
      this.title = "添加订单预定详情";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getReserveDetails(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单预定详情";
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
          updateReserveDetails(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createReserveDetails(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除订单预定详情编号为"' + id + '"的数据项?').then(function() {
          return deleteReserveDetails(id);
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
      this.$modal.confirm('是否确认导出所有订单预定详情数据项?').then(() => {
          this.exportLoading = true;
          return exportReserveDetailsExcel(params);
        }).then(response => {
          this.$download.excel(response, '订单预定详情.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
