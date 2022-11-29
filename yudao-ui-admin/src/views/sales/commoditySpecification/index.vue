<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品id" prop="commodityId">
        <el-input v-model="queryParams.commodityId" placeholder="请输入商品id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="规格名称" prop="specificationsName">
        <el-input v-model="queryParams.specificationsName" placeholder="请输入规格名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="包装类型(0定装1散装)" prop="packagingType">
        <el-select v-model="queryParams.packagingType" placeholder="请选择包装类型(0定装1散装)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="经营主体id" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="source" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入source" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['sales:commodity-specification:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['sales:commodity-specification:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="规格名称" align="center" prop="specificationsName" />
      <el-table-column label="包装类型(0定装1散装)" align="center" prop="packagingType" />
      <el-table-column label="规格数量" align="center" prop="number" />
      <el-table-column label="单位" align="center" prop="unit" />
      <el-table-column label="包装单位" align="center" prop="packaging" />
      <el-table-column label="计量单位" align="center" prop="measurementUnit" />
      <el-table-column label="采购价" align="center" prop="purchasePrice" />
      <el-table-column label="售出价" align="center" prop="sellingPrice" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['sales:commodity-specification:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['sales:commodity-specification:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品id" prop="commodityId">
          <el-input v-model="form.commodityId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="规格名称" prop="specificationsName">
          <el-input v-model="form.specificationsName" placeholder="请输入规格名称" />
        </el-form-item>
        <el-form-item label="包装类型(0定装1散装)" prop="packagingType">
          <el-select v-model="form.packagingType" placeholder="请选择包装类型(0定装1散装)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="规格数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入规格数量" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="包装单位" prop="packaging">
          <el-input v-model="form.packaging" placeholder="请输入包装单位" />
        </el-form-item>
        <el-form-item label="计量单位" prop="measurementUnit">
          <el-input v-model="form.measurementUnit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="采购价" prop="purchasePrice">
          <el-input v-model="form.purchasePrice" placeholder="请输入采购价" />
        </el-form-item>
        <el-form-item label="售出价" prop="sellingPrice">
          <el-input v-model="form.sellingPrice" placeholder="请输入售出价" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
import { createCommoditySpecification, updateCommoditySpecification, deleteCommoditySpecification, getCommoditySpecification, getCommoditySpecificationPage, exportCommoditySpecificationExcel } from "@/api/sales/commoditySpecification";

export default {
  name: "CommoditySpecification",
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
      // 商品规格列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        commodityId: null,
        specificationsName: null,
        packagingType: null,
        createTime: [],
        subjectId: null,
        source: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
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
      getCommoditySpecificationPage(this.queryParams).then(response => {
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
        commodityId: undefined,
        specificationsName: undefined,
        packagingType: undefined,
        number: undefined,
        unit: undefined,
        packaging: undefined,
        measurementUnit: undefined,
        purchasePrice: undefined,
        sellingPrice: undefined,
        remark: undefined,
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
      this.title = "添加商品规格";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getCommoditySpecification(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品规格";
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
          updateCommoditySpecification(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createCommoditySpecification(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除商品规格编号为"' + id + '"的数据项?').then(function() {
          return deleteCommoditySpecification(id);
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
      this.$modal.confirm('是否确认导出所有商品规格数据项?').then(() => {
          this.exportLoading = true;
          return exportCommoditySpecificationExcel(params);
        }).then(response => {
          this.$download.excel(response, '商品规格.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
