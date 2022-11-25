<template>
  <div class="app-container">

    <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
      <el-tab-pane label="企业信息" name="first">
        <div class="title">企业信息</div>
        <el-button @click="gotoEdit">编辑</el-button>
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
        <PolicySubsidiesInfo :id="id"></PolicySubsidiesInfo>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import PolicySubsidiesInfo from '../policySubsidiesInfo/index.vue'
export default {
  name: "User",
  components: {
    PolicySubsidiesInfo
  },
  data() {
    return {
      //默认tab显示
      activeName: 'first',
      id: '',
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


    };
  },
  created() {
    console.log(this.$route.query.id, 'query')
    this.businessid = this.$route.query.id
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
    gotoEdit() {
      this.$router.push({ path: "/enterprise/baseInfo/businessEditInfo" ,query: { id: this.businessid } });
    }
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
