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
      <el-form-item label="货品编号" prop="goodsId">
        <el-input v-model="queryParams.goodsId" placeholder="请输入货品编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="货品名称" prop="goodsName">
        <el-input v-model="queryParams.goodsName" placeholder="请输入货品名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装规格id" prop="packagingSpecificationId">
        <el-input v-model="queryParams.packagingSpecificationId" placeholder="请输入包装规格id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装规格" prop="packagingSpecification">
        <el-input v-model="queryParams.packagingSpecification" placeholder="请输入包装规格" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="计量单位" prop="unit">
        <el-input v-model="queryParams.unit" placeholder="请输入计量单位" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装类型" prop="packagingType">
        <el-select v-model="queryParams.packagingType" placeholder="请选择包装类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="采购数量/重量" prop="buyNumber">
        <el-input v-model="queryParams.buyNumber" placeholder="请输入采购数量/重量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="期望到货频次" prop="frequency">
        <el-input v-model="queryParams.frequency" placeholder="请输入期望到货频次" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="单价" prop="price">
        <el-input v-model="queryParams.price" placeholder="请输入单价" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="优惠金额" prop="discount">
        <el-input v-model="queryParams.discount" placeholder="请输入优惠金额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采购金额(总金额)" prop="total">
        <el-input v-model="queryParams.total" placeholder="请输入采购金额(总金额)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="收货标准id" prop="standardId">
        <el-input v-model="queryParams.standardId" placeholder="请输入收货标准id" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['purchase:details:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['purchase:details:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="采购单编号" align="center" prop="purchaseId" />
      <el-table-column label="采购单号" align="center" prop="purchaseNumber" />
      <el-table-column label="货品编号" align="center" prop="goodsId" />
      <el-table-column label="货品名称" align="center" prop="goodsName" />
      <el-table-column label="包装规格id" align="center" prop="packagingSpecificationId" />
      <el-table-column label="包装规格" align="center" prop="packagingSpecification" />
      <el-table-column label="计量单位" align="center" prop="unit" />
      <el-table-column label="包装类型" align="center" prop="packagingType" />
      <el-table-column label="采购数量/重量" align="center" prop="buyNumber" />
      <el-table-column label="期望到货频次" align="center" prop="frequency" />
      <el-table-column label="单价" align="center" prop="price" />
      <el-table-column label="优惠金额" align="center" prop="discount" />
      <el-table-column label="采购金额(总金额)" align="center" prop="total" />
      <el-table-column label="收货标准id" align="center" prop="standardId" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['purchase:details:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['purchase:details:delete']">删除</el-button>
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
        <el-form-item label="货品编号" prop="goodsId">
          <el-input v-model="form.goodsId" placeholder="请输入货品编号" />
        </el-form-item>
        <el-form-item label="货品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入货品名称" />
        </el-form-item>
        <el-form-item label="包装规格id" prop="packagingSpecificationId">
          <el-input v-model="form.packagingSpecificationId" placeholder="请输入包装规格id" />
        </el-form-item>
        <el-form-item label="包装规格" prop="packagingSpecification">
          <el-input v-model="form.packagingSpecification" placeholder="请输入包装规格" />
        </el-form-item>
        <el-form-item label="计量单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="包装类型" prop="packagingType">
          <el-select v-model="form.packagingType" placeholder="请选择包装类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="采购数量/重量" prop="buyNumber">
          <el-input v-model="form.buyNumber" placeholder="请输入采购数量/重量" />
        </el-form-item>
        <el-form-item label="期望到货频次" prop="frequency">
          <el-input v-model="form.frequency" placeholder="请输入期望到货频次" />
        </el-form-item>
        <el-form-item label="单价" prop="price">
          <el-input v-model="form.price" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="优惠金额" prop="discount">
          <el-input v-model="form.discount" placeholder="请输入优惠金额" />
        </el-form-item>
        <el-form-item label="采购金额(总金额)" prop="total">
          <el-input v-model="form.total" placeholder="请输入采购金额(总金额)" />
        </el-form-item>
        <el-form-item label="收货标准id" prop="standardId">
          <el-input v-model="form.standardId" placeholder="请输入收货标准id" />
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
import { createDetails, updateDetails, deleteDetails, getDetails, getDetailsPage, exportDetailsExcel } from "@/api/purchase/details";

export default {
  name: "Details",
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
      // 采购单明细列表
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
        goodsId: null,
        goodsName: null,
        packagingSpecificationId: null,
        packagingSpecification: null,
        unit: null,
        packagingType: null,
        buyNumber: null,
        frequency: null,
        price: null,
        discount: null,
        total: null,
        standardId: null,
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        purchaseId: [{ required: true, message: "采购单编号不能为空", trigger: "blur" }],
        purchaseNumber: [{ required: true, message: "采购单号不能为空", trigger: "blur" }],
        goodsId: [{ required: true, message: "货品编号不能为空", trigger: "blur" }],
        goodsName: [{ required: true, message: "货品名称不能为空", trigger: "blur" }],
        unit: [{ required: true, message: "计量单位不能为空", trigger: "blur" }],
        buyNumber: [{ required: true, message: "采购数量/重量不能为空", trigger: "blur" }],
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
      getDetailsPage(this.queryParams).then(response => {
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
        goodsId: undefined,
        goodsName: undefined,
        packagingSpecificationId: undefined,
        packagingSpecification: undefined,
        unit: undefined,
        packagingType: undefined,
        buyNumber: undefined,
        frequency: undefined,
        price: undefined,
        discount: undefined,
        total: undefined,
        standardId: undefined,
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
      this.title = "添加采购单明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getDetails(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改采购单明细";
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
          updateDetails(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createDetails(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除采购单明细编号为"' + id + '"的数据项?').then(function() {
          return deleteDetails(id);
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
      this.$modal.confirm('是否确认导出所有采购单明细数据项?').then(() => {
          this.exportLoading = true;
          return exportDetailsExcel(params);
        }).then(response => {
          this.$download.excel(response, '采购单明细.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
