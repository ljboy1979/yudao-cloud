<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入主体名称" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="enterpriseType">
        <el-select v-model="queryParams.enterpriseType" placeholder="请选择主体类型" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.ENTERPRISE_TYPE)" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item prop="registerTime">
        <el-date-picker v-model="queryParams.registerTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item>
        <el-button icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-button type="primary" icon="el-icon-download" @click="handleExport" :loading="exportLoading"
          v-hasPermi="['enterprise:base-info:export']">导出</el-button>
      </el-form-item>
    </el-form>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主体编号" align="center" prop="code" />
      <el-table-column label="主体名称" align="center" prop="name" />
      <el-table-column label="主体类型" align="center" prop="enterpriseType">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.ENTERPRISE_TYPE" :value="scope.row.enterpriseType" />
        </template>
      </el-table-column>
      <el-table-column label="产业角色" align="center" prop="userTag">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.USER_TAG" :value="scope.row.userTag" />
        </template>
      </el-table-column>
      <el-table-column label="联系人电话" align="center" prop="contactPhone" />
      <el-table-column label="注册时间" align="center" prop="registerTime" />
      <el-table-column label="省名称" align="center" prop="villagesAreaName" />
      <el-table-column label="市名称" align="center" prop="areaName" />
      <el-table-column label="区名称" align="center" prop="ruralName" />
      <el-table-column label="状态" align="center" prop="stauts" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" @click="handleDetail(scope.row)" v-hasPermi="['']">管理</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

  </div>
</template>

<script>
import { getBaseInfoPage, exportBaseInfoExcel } from "@/api/enterprise/baseInfo";
import Editor from '@/components/Editor';

export default {
  name: "BaseInfo",
  components: {
    Editor,
  },
  data() {
    return {
      // 遮罩层
      // loading: true,
      loading: false,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 经营主体列表
      list: [{code:"11"}],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        name: null,
        enterpriseType: null,
        registerTime: [],
      },
    };
  },
  created() {
    // this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getBaseInfoPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
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
    /** 管理按钮操作 */
    handleDetail(row) {
      this.$router.push({ path: "/member/user/businessInfoManagement", query: { id: row.id } });
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = { ...this.queryParams };
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有经营主体数据项?').then(() => {
        this.exportLoading = true;
        return exportBaseInfoExcel(params);
      }).then(response => {
        this.$download.excel(response, '经营主体.xls');
        this.exportLoading = false;
      }).catch(() => { });
    }
  }
};
</script>
