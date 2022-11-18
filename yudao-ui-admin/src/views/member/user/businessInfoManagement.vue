<template>
  <div class="app-container">

    <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
      <el-tab-pane label="企业信息" name="first">
        <div class="title">企业信息</div>
      </el-tab-pane>
      <el-tab-pane label="设施" name="facilities">
        <div class="title">设施信息</div>
      </el-tab-pane>
      <el-tab-pane label="设备" name="equipment">
        <div class="title">设备信息</div>
      </el-tab-pane>
      <el-tab-pane label="地块" name="massif">
        <div class="title">地块信息</div>
      </el-tab-pane>
      <el-tab-pane label="交易账单" name="transactionStatement">
        <div class="title">账单交易信息</div>
        <!-- 搜索工作栏 -->
        <el-form :model="queryBillParams" ref="queryBillForm" size="small" :inline="true" v-show="showSearch"
          label-width="68px">
          <el-form-item prop="id">
            <el-input v-model="queryBillParams.id" placeholder="请输入交易单号" clearable @keyup.enter.native="handleQuery" />
          </el-form-item>
          <el-form-item prop="type">
            <el-select v-model="queryBillParams.type" placeholder="请选择交易类型" clearable size="small">
              <el-option label="请选择交易类型" value="" />
            </el-select>
          </el-form-item>
          <el-form-item prop="partner">
            <el-select v-model="queryBillParams.partner" placeholder="请选择交易对象" clearable size="small">
              <el-option label="请选择交易对象" value="" />
            </el-select>
          </el-form-item>
          <el-form-item prop="billDate">
            <el-date-picker v-model="queryBillParams.billDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
              type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
              :default-time="['00:00:00', '23:59:59']" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" @click="resetBillQuery">重置</el-button>
            <el-button type="primary" plain icon="el-icon-download" @click="handleExport" :loading="exportLoading">导出
            </el-button>
          </el-form-item>
        </el-form>
        <el-table v-loading="loading" :data="billlist" stripe>
          <el-table-column label="交易单号" align="center" prop="id" />
          <el-table-column label="交易类型" align="center" prop="" />
          <el-table-column label="交易方式" align="center" prop="" />
          <el-table-column label="交易时间" align="center" prop="" />
          <el-table-column label="售品名称" align="center" prop="" />
          <el-table-column label="交易金额" align="center" prop="" />
          <el-table-column label="支付账户" align="center" prop="" />
          <el-table-column label="收款账户" align="center" prop="" />
          <el-table-column label="交易对象名称" align="center" prop="" />
          <el-table-column label="交易状态" align="center" prop="" />
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="政策补贴记录" name="policySubsidyRecord">
        <div class="title">政策补贴记录</div>
        <!-- 搜索工作栏 -->
        <el-form :model="querySubsidyParams" ref="querySubsidyForm" size="small" :inline="true" v-show="showSearch"
          label-width="68px">
          <el-form-item prop="status">
            <el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
          </el-form-item>
          <el-form-item prop="status">
            <el-select v-model="querySubsidyParams.status" placeholder="请选择补贴状态" clearable size="small">
              <el-option label="请选择补贴状态" value="" />
            </el-select>
          </el-form-item>
          <el-form-item prop="type">
            <el-input v-model="querySubsidyParams.type" placeholder="请输入种类" clearable
              @keyup.enter.native="handleQuery" />
          </el-form-item>
          <el-form-item prop="name">
            <el-input v-model="querySubsidyParams.name" placeholder="请输入名称" clearable
              @keyup.enter.native="handleQuery" />
          </el-form-item>
          <el-form-item prop="subsidyDate">
            <el-date-picker v-model="querySubsidyParams.subsidyDate" style="width: 240px"
              value-format="yyyy-MM-dd HH:mm:ss" type="daterange" range-separator="-" start-placeholder="开始日期"
              end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" @click="resetSubsidyQuery">重置</el-button>
          </el-form-item>
        </el-form>
        <el-table v-loading="loading" :data="subsidylist" stripe>
          <el-table-column label="申请时间" align="center" prop="" />
          <el-table-column label="补贴种类" align="center" prop="" />
          <el-table-column label="补贴名称" align="center" prop="" />
          <el-table-column label="补贴金额" align="center" prop="" />
          <el-table-column label="补贴状态" align="center" prop="" />
          <el-table-column label="申请人" align="center" prop="" />
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
              <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 对话框(添加 / 修改) -->
        <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
          <el-form ref="form" :model="form" :rules="rules" label-width="80px" >
            <el-form-item label="申请时间" prop="applicationDate">
              <el-date-picker clearable v-model="form.applicationDate" type="date" value-format="timestamp" class="w100"
                placeholder="请选择申请时间" />
            </el-form-item>
            <el-form-item label="补贴种类" prop="type">
              <el-select v-model="form.type" placeholder="请选择补贴种类" class="w100" >
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </el-form-item>
            <el-form-item label="补贴名称" prop="name" >
              <el-input v-model="form.name" placeholder="请输入补贴名称" />
            </el-form-item>
            <el-form-item label="补贴金额" prop="amount">
              <el-input v-model="form.amount" placeholder="请输入补贴金额" />
            </el-form-item>
            <el-form-item label="补贴方式" prop="mode">
              <el-select v-model="form.mode" placeholder="请选择补贴方式" class="w100">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </el-form-item>
            <el-form-item label="补贴状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择补贴状态" class="w100">
                <el-option label="审核" value="0" />
                <el-option label="正常" value="1" />
                <el-option label="停放" value="2" />
              </el-select>
            </el-form-item>
            <el-form-item label="申请人" prop="applicant">
              <el-input v-model="form.applicant" placeholder="请输入申请人" />
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="submitForm">确 定</el-button>
            <el-button @click="cancel">取 消</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "User",
  components: {
  },
  data() {
    return {
      //默认tab显示
      activeName: 'first',
      userid: '',
      // 遮罩层
      // loading: true,
      loading: false,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,

      billlist: [],
      // 查询参数
      queryBillParams: {
        pageNo: 1,
        pageSize: 10,
        id: undefined,
        type: undefined,
        partner: undefined,
        billDate: []
      },

      subsidylist: [],
      // 表单参数
      form: {},
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      querySubsidyParams: {
        pageNo: 1,
        pageSize: 10,
        status: undefined,
        type: undefined,
        name: undefined,
        subsidyDate: []
      },// 表单校验
      rules: {
      }

    };
  },
  created() {
    console.log(this.$route.query.id, 'query')
    this.userid = this.$route.query.id
    //调接口获取会员信息
  },
  methods: {
    //切换tab
    handleClick(tab, event) {
      console.log(tab.index, event);
    },
    /** 搜索按钮操作 */
    handleQuery() {

    },
    /** 重置按钮操作 */
    resetBillQuery() {
      this.resetForm("queryBillForm");
      this.handleQuery();
    },
    handleExport() {

    },
    handleDelete() {

    },


    /** 重置按钮操作 */
    resetSubsidyQuery() {
      this.resetForm("querySubsidyForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "新增政策补贴";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getUser(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改政策补贴";
      });
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        applicationDate: undefined,
        type: undefined,
        name: undefined,
        amount: undefined,
        mode: undefined,
        status: undefined,
        applicant: undefined,
      };
      this.resetForm("form");
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          // XXXX(this.form).then(response => {
          //   this.$modal.msgSuccess("修改成功");
          //   this.open = false;
          //   this.getList();
          // });
          console.log("修改", this.form)
          return;
        }
        // 添加的提交
        // XXXX(this.form).then(response => {
        //   this.$modal.msgSuccess("新增成功");
        //   this.open = false;
        //   this.getList();
        // });
        console.log("新增", this.form)
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 删除按钮操作 */
    handleDelete(row) {
    },
  }
};
</script>
<style scoped>
.title {
  font-size: 24px;
  margin: 10px 0 20px 15px;
}
.w100{
  width: 100%;
}
</style>
