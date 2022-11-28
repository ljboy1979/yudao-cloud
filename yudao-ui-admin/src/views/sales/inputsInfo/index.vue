<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="投入品名称" prop="inputsName">
        <el-input v-model="queryParams.inputsName" placeholder="请输入投入品名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="种类" prop="inputsKind">
        <el-input v-model="queryParams.inputsKind" placeholder="请输入种类" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['sales:inputs-info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['sales:inputs-info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="类型(农药,化肥,物料,种子)" align="center" prop="inputsType" />
      <el-table-column label="投入品名称" align="center" prop="inputsName" />
      <el-table-column label="种类" align="center" prop="inputsKind" />
      <el-table-column label="生产厂家" align="center" prop="manufacturer" />
      <el-table-column label="有效成分" align="center" prop="activeIngredients" />
      <el-table-column label="包装规格" align="center" prop="packingSpecification" />
      <el-table-column label="产品剂型" align="center" prop="productDosageForm" />
      <el-table-column label="picture" align="center" prop="picture" />
      <el-table-column label="每亩最高用量" align="center" prop="standardUse" />
      <el-table-column label="标准用量" align="center" prop="unitConsumption" />
      <el-table-column label="条形码" align="center" prop="barCode" />
      <el-table-column label="包装类型" align="center" prop="packagingType" />
      <el-table-column label="计量单位" align="center" prop="measureUnit" />
      <el-table-column label="状态（0正常 1不可修改）" align="center" prop="state" />
      <el-table-column label="单位" align="center" prop="unit" />
      <el-table-column label="数量" align="center" prop="num" />
      <el-table-column label="采购价（单价）" align="center" prop="purchasePrice" />
      <el-table-column label="供应商" align="center" prop="supplier" />
      <el-table-column label="安全期" align="center" prop="secureDays" />
      <el-table-column label="项目类型" align="center" prop="projectType" />
      <el-table-column label="投入品编码" align="center" prop="inputsCode" />
      <el-table-column label="投入品批次号" align="center" prop="inputsBatch" />
      <el-table-column label="单位名称" align="center" prop="unitNames" />
      <el-table-column label="包装规格名称" align="center" prop="packingSpecificationNames" />
      <el-table-column label="中华水产专用，图片，多张逗号隔开" align="center" prop="inputsinfoImage" />
      <el-table-column label="供应商" align="center" prop="refactsupplier" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="source" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['sales:inputs-info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['sales:inputs-info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="类型(农药,化肥,物料,种子)" prop="inputsType">
          <el-select v-model="form.inputsType" placeholder="请选择类型(农药,化肥,物料,种子)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="投入品名称" prop="inputsName">
          <el-input v-model="form.inputsName" placeholder="请输入投入品名称" />
        </el-form-item>
        <el-form-item label="种类" prop="inputsKind">
          <el-input v-model="form.inputsKind" placeholder="请输入种类" />
        </el-form-item>
        <el-form-item label="生产厂家" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入生产厂家" />
        </el-form-item>
        <el-form-item label="有效成分" prop="activeIngredients">
          <el-input v-model="form.activeIngredients" placeholder="请输入有效成分" />
        </el-form-item>
        <el-form-item label="包装规格" prop="packingSpecification">
          <el-input v-model="form.packingSpecification" placeholder="请输入包装规格" />
        </el-form-item>
        <el-form-item label="产品剂型" prop="productDosageForm">
          <el-input v-model="form.productDosageForm" placeholder="请输入产品剂型" />
        </el-form-item>
        <el-form-item label="picture" prop="picture">
          <el-input v-model="form.picture" placeholder="请输入picture" />
        </el-form-item>
        <el-form-item label="每亩最高用量" prop="standardUse">
          <el-input v-model="form.standardUse" placeholder="请输入每亩最高用量" />
        </el-form-item>
        <el-form-item label="标准用量" prop="unitConsumption">
          <el-input v-model="form.unitConsumption" placeholder="请输入标准用量" />
        </el-form-item>
        <el-form-item label="条形码" prop="barCode">
          <el-input v-model="form.barCode" placeholder="请输入条形码" />
        </el-form-item>
        <el-form-item label="包装类型" prop="packagingType">
          <el-select v-model="form.packagingType" placeholder="请选择包装类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="计量单位" prop="measureUnit">
          <el-input v-model="form.measureUnit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="状态（0正常 1不可修改）" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态（0正常 1不可修改）" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="采购价（单价）" prop="purchasePrice">
          <el-input v-model="form.purchasePrice" placeholder="请输入采购价（单价）" />
        </el-form-item>
        <el-form-item label="供应商" prop="supplier">
          <el-input v-model="form.supplier" placeholder="请输入供应商" />
        </el-form-item>
        <el-form-item label="安全期" prop="secureDays">
          <el-input v-model="form.secureDays" placeholder="请输入安全期" />
        </el-form-item>
        <el-form-item label="项目类型" prop="projectType">
          <el-select v-model="form.projectType" placeholder="请选择项目类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="投入品编码" prop="inputsCode">
          <el-input v-model="form.inputsCode" placeholder="请输入投入品编码" />
        </el-form-item>
        <el-form-item label="投入品批次号" prop="inputsBatch">
          <el-input v-model="form.inputsBatch" placeholder="请输入投入品批次号" />
        </el-form-item>
        <el-form-item label="单位名称" prop="unitNames">
          <el-input v-model="form.unitNames" placeholder="请输入单位名称" />
        </el-form-item>
        <el-form-item label="包装规格名称" prop="packingSpecificationNames">
          <el-input v-model="form.packingSpecificationNames" placeholder="请输入包装规格名称" />
        </el-form-item>
        <el-form-item label="供应商" prop="refactsupplier">
          <el-input v-model="form.refactsupplier" placeholder="请输入供应商" />
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
import { createInputsInfo, updateInputsInfo, deleteInputsInfo, getInputsInfo, getInputsInfoPage, exportInputsInfoExcel } from "@/api/sales/inputsInfo";

export default {
  name: "InputsInfo",
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
      // 投入品列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        inputsName: null,
        inputsKind: null,
        createTime: [],
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
      getInputsInfoPage(this.queryParams).then(response => {
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
        inputsType: undefined,
        inputsName: undefined,
        inputsKind: undefined,
        manufacturer: undefined,
        activeIngredients: undefined,
        packingSpecification: undefined,
        productDosageForm: undefined,
        picture: undefined,
        standardUse: undefined,
        unitConsumption: undefined,
        barCode: undefined,
        packagingType: undefined,
        measureUnit: undefined,
        state: undefined,
        unit: undefined,
        num: undefined,
        purchasePrice: undefined,
        supplier: undefined,
        secureDays: undefined,
        projectType: undefined,
        inputsCode: undefined,
        inputsBatch: undefined,
        unitNames: undefined,
        packingSpecificationNames: undefined,
        inputsinfoImage: undefined,
        refactsupplier: undefined,
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
      this.title = "添加投入品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInputsInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改投入品";
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
          updateInputsInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createInputsInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除投入品编号为"' + id + '"的数据项?').then(function() {
          return deleteInputsInfo(id);
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
      this.$modal.confirm('是否确认导出所有投入品数据项?').then(() => {
          this.exportLoading = true;
          return exportInputsInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '投入品.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
