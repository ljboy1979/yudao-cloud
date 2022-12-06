<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd"
          v-hasPermi="['enterprise:other-account-info:create']">新增</el-button>
      </el-form-item>
      <el-form-item prop="accountName">
        <el-input v-model="queryParams.accountName" placeholder="请输入账户名" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="accountNo">
        <el-input v-model="queryParams.accountNo" placeholder="请输入账户银行卡号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="accountIdCard">
        <el-input v-model="queryParams.accountIdCard" placeholder="请输入账户身份证号" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="accountBank">
        <el-input v-model="queryParams.accountBank" placeholder="请输入账户开户行" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="创建开始日期" end-placeholder="创建结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item prop="updateTime">
        <el-date-picker v-model="queryParams.updateTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="更新开始日期" end-placeholder="更新结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-button type="primary" plain icon="el-icon-download" @click="handleExport" :loading="exportLoading"
          v-hasPermi="['enterprise:other-account-info:export']">导出</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <!-- <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
      </el-col>
      <el-col :span="1.5">
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row> -->

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="账户名" align="center" prop="accountName" />
      <el-table-column label="账户银行卡号" align="center" prop="accountNo" />
      <el-table-column label="账户身份证号" align="center" prop="accountIdCard" />
      <el-table-column label="账户开户行" align="center" prop="accountBank" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['enterprise:other-account-info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['enterprise:other-account-info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="账户名" prop="accountName">
          <el-input v-model="form.accountName" placeholder="请输入账户名" />
        </el-form-item>
        <el-form-item label="账户银行卡号" prop="accountNo">
          <el-input v-model="form.accountNo" placeholder="请输入账户银行卡号" />
        </el-form-item>
        <el-form-item label="账户身份证号" prop="accountIdCard">
          <el-input v-model="form.accountIdCard" placeholder="请输入账户身份证号" />
        </el-form-item>
        <el-form-item label="账户开户行" prop="accountBank">
          <el-input v-model="form.accountBank" placeholder="请输入账户开户行" />
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
import { createOtherAccountInfo, updateOtherAccountInfo, deleteOtherAccountInfo, getOtherAccountInfo, getOtherAccountInfoPage, exportOtherAccountInfoExcel } from "@/api/enterprise/otherAccountInfo";

export default {
  name: "OtherAccountInfo",
  components: {
  },
  /**接受父组件传值*/
  props: {
    id: {
      type: String,
      required: true
    }
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
      // 经营主体其他账户列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        accountName: null,
        accountNo: null,
        accountIdCard: null,
        accountBank: null,
        createTime: [],
        updateTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        accountName: [
          { required: true, message: '请输入账户名', trigger: 'blur' },
          { min: 1, max: 50, message: '最大长度为50', trigger: 'blur' }
        ],
        accountNo: [
          { required: true, message: '请输入账户银行卡号', trigger: 'blur' },
          { min: 1, max: 50, message: '最大长度为50', trigger: 'blur' }],
        accountIdCard: [
          { required: true, message: '请输入账户身份证号', trigger: 'blur' },
          { min: 1, max: 50, message: '最大长度为50', trigger: 'blur' }],
        accountBank: [
          { required: true, message: '请输入账户开户行', trigger: 'blur' },
          { min: 1, max: 50, message: '最大长度为50', trigger: 'blur' }],
      },
    };
  },
  created() {
    this.queryParams.enterpriseId =this.id
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.queryParams.enterpriseId =this.id
      this.loading = true;
      // 执行查询
      getOtherAccountInfoPage(this.queryParams).then(response => {
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
        accountName: undefined,
        accountNo: undefined,
        accountIdCard: undefined,
        accountBank: undefined,
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
      this.title = "添加经营主体其他账户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getOtherAccountInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改经营主体其他账户";
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
          updateOtherAccountInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        this.form.enterpriseId=this.id
        createOtherAccountInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除经营主体其他账户编号为"' + id + '"的数据项?').then(function () {
        return deleteOtherAccountInfo(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = { ...this.queryParams };
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有经营主体其他账户数据项?').then(() => {
        this.exportLoading = true;
        return exportOtherAccountInfoExcel(params);
      }).then(response => {
        this.$download.excel(response, '经营主体其他账户.xls');
        this.exportLoading = false;
      }).catch(() => { });
    }
  }
};
</script>
