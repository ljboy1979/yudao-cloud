<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="认养物的id" prop="adoptId">
        <el-input v-model="queryParams.adoptId" placeholder="请输入认养物的id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="认养物的名称" prop="adoptName">
        <el-input v-model="queryParams.adoptName" placeholder="请输入认养物的名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始时间" prop="startTime">
        <el-date-picker v-model="queryParams.startTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker v-model="queryParams.endTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="认养费用" prop="adoptPriceFee">
        <el-input v-model="queryParams.adoptPriceFee" placeholder="请输入认养费用" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="费用类型" prop="feeType">
        <el-select v-model="queryParams.feeType" placeholder="请选择费用类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="认养人标签" prop="adoptPersonFlag">
        <el-input v-model="queryParams.adoptPersonFlag" placeholder="请输入认养人标签" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="权益价格的id" prop="adoptRightId">
        <el-input v-model="queryParams.adoptRightId" placeholder="请输入权益价格的id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="付款人数" prop="payNum">
        <el-input v-model="queryParams.payNum" placeholder="请输入付款人数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="认养总数" prop="adoptTotal">
        <el-input v-model="queryParams.adoptTotal" placeholder="请输入认养总数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="认养剩余名额" prop="adoptQuota">
        <el-input v-model="queryParams.adoptQuota" placeholder="请输入认养剩余名额" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="经营主体id" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体id" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['service:adopt-content-adopt-price:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:adopt-content-adopt-price:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="认养物的id" align="center" prop="adoptId" />
      <el-table-column label="认养物的名称" align="center" prop="adoptName" />
      <el-table-column label="开始时间" align="center" prop="startTime" />
      <el-table-column label="结束时间" align="center" prop="endTime" />
      <el-table-column label="认养费用" align="center" prop="adoptPriceFee" />
      <el-table-column label="费用类型" align="center" prop="feeType" />
      <el-table-column label="认养人标签" align="center" prop="adoptPersonFlag" />
      <el-table-column label="权益价格的id" align="center" prop="adoptRightId" />
      <el-table-column label="付款人数" align="center" prop="payNum" />
      <el-table-column label="认养总数" align="center" prop="adoptTotal" />
      <el-table-column label="认养剩余名额" align="center" prop="adoptQuota" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:adopt-content-adopt-price:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:adopt-content-adopt-price:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="认养物的id" prop="adoptId">
          <el-input v-model="form.adoptId" placeholder="请输入认养物的id" />
        </el-form-item>
        <el-form-item label="认养物的名称" prop="adoptName">
          <el-input v-model="form.adoptName" placeholder="请输入认养物的名称" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable v-model="form.startTime" type="date" value-format="timestamp" placeholder="选择开始时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable v-model="form.endTime" type="date" value-format="timestamp" placeholder="选择结束时间" />
        </el-form-item>
        <el-form-item label="认养费用" prop="adoptPriceFee">
          <el-input v-model="form.adoptPriceFee" placeholder="请输入认养费用" />
        </el-form-item>
        <el-form-item label="费用类型" prop="feeType">
          <el-select v-model="form.feeType" placeholder="请选择费用类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="认养人标签" prop="adoptPersonFlag">
          <el-input v-model="form.adoptPersonFlag" placeholder="请输入认养人标签" />
        </el-form-item>
        <el-form-item label="权益价格的id" prop="adoptRightId">
          <el-input v-model="form.adoptRightId" placeholder="请输入权益价格的id" />
        </el-form-item>
        <el-form-item label="付款人数" prop="payNum">
          <el-input v-model="form.payNum" placeholder="请输入付款人数" />
        </el-form-item>
        <el-form-item label="认养总数" prop="adoptTotal">
          <el-input v-model="form.adoptTotal" placeholder="请输入认养总数" />
        </el-form-item>
        <el-form-item label="认养剩余名额" prop="adoptQuota">
          <el-input v-model="form.adoptQuota" placeholder="请输入认养剩余名额" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="项目来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入项目来源" />
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
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
import { createAdoptContentAdoptPrice, updateAdoptContentAdoptPrice, deleteAdoptContentAdoptPrice, getAdoptContentAdoptPrice, getAdoptContentAdoptPricePage, exportAdoptContentAdoptPriceExcel } from "@/api/resource/adoptContentAdoptPrice";

export default {
  name: "AdoptContentAdoptPrice",
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
      // 认养/租凭价格列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        adoptId: null,
        adoptName: null,
        startTime: [],
        endTime: [],
        adoptPriceFee: null,
        feeType: null,
        adoptPersonFlag: null,
        adoptRightId: null,
        payNum: null,
        adoptTotal: null,
        adoptQuota: null,
        status: null,
        createTime: [],
        source: null,
        subjectId: null,
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
      getAdoptContentAdoptPricePage(this.queryParams).then(response => {
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
        adoptId: undefined,
        adoptName: undefined,
        startTime: undefined,
        endTime: undefined,
        adoptPriceFee: undefined,
        feeType: undefined,
        adoptPersonFlag: undefined,
        adoptRightId: undefined,
        payNum: undefined,
        adoptTotal: undefined,
        adoptQuota: undefined,
        status: undefined,
        source: undefined,
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
      this.title = "添加认养/租凭价格";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getAdoptContentAdoptPrice(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改认养/租凭价格";
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
          updateAdoptContentAdoptPrice(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createAdoptContentAdoptPrice(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除认养/租凭价格编号为"' + id + '"的数据项?').then(function() {
          return deleteAdoptContentAdoptPrice(id);
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
      this.$modal.confirm('是否确认导出所有认养/租凭价格数据项?').then(() => {
          this.exportLoading = true;
          return exportAdoptContentAdoptPriceExcel(params);
        }).then(response => {
          this.$download.excel(response, '认养/租凭价格.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
