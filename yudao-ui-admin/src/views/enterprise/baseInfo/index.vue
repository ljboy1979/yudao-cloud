<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item>
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd" v-hasPermi="['enterprise:base-info:create']">新增
        </el-button>
      </el-form-item> -->
      <el-form-item prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入主体名称" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="enterpriseType">
        <el-select v-model="queryParams.enterpriseType" placeholder="请选择主体类型" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.ENTERPRISE_TYPE)" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <!-- <el-form-item prop="registerTime">
        <el-date-picker v-model="queryParams.registerTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item> -->
      <el-form-item prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item>
        <el-button icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-button type="primary" plain icon="el-icon-download" @click="handleExport" :loading="exportLoading"
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
      <!-- <el-table-column label="注册时间" align="center" prop="registerTime" /> -->
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="省名称" align="center" prop="villagesAreaName" />
      <el-table-column label="市名称" align="center" prop="areaName" />
      <el-table-column label="区名称" align="center" prop="ruralName" />
      <el-table-column label="状态" align="center" prop="stauts">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.ENTERPRISE_STATUS" :value="scope.row.stauts" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" @click="handleDetail(scope.row)" v-hasPermi="['']">管理</el-button>
          <el-button size="mini" type="text" @click="handleStop(scope.row)" v-hasPermi="['']">
            <span v-if="scope.row.stauts==1">停用</span>
            <span v-else>启用</span>
          </el-button>
          <!-- <el-button size="mini" type="text" @click="handleUpdate(scope.row)"
            v-hasPermi="['enterprise:base-info:update']">修改</el-button>
          <el-button size="mini" type="text" @click="handleDelete(scope.row)"
            v-hasPermi="['enterprise:base-info:delete']">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="600px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="主体编号" prop="code">
          <el-input v-model="form.code" placeholder="请输入主体编号" />
        </el-form-item>
        <el-form-item label="主体名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入主体名称" />
        </el-form-item>
        <el-form-item label="主体类型" prop="enterpriseType">
          <el-select v-model="form.enterpriseType" placeholder="请选择主体类型">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.ENTERPRISE_TYPE)" :key="dict.value"
              :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="主体类型名称" prop="enterpriseTypeName">
          <el-input v-model="form.enterpriseTypeName" placeholder="请输入主体类型名称" />
        </el-form-item>
        <el-form-item label="状态" prop="stauts">
          <el-input v-model="form.stauts" placeholder="请输入状态" />
        </el-form-item>
        <el-form-item label="产业角色" prop="userTag">
          <el-select v-model="form.userTag" placeholder="请选择产业角色">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.USER_TAG)" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="产业角色名称" prop="userTagName">
          <el-input v-model="form.userTagName" placeholder="请输入产业角色名称" />
        </el-form-item>
        <el-form-item label="经营状态" prop="manageStatus">
          <el-select v-model="form.manageStatus" placeholder="请选择经营状态">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.MANAGE_STATUS)" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="注册地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入注册地址" />
        </el-form-item>
        <el-form-item label="详细地址" prop="detailedAddress">
          <el-input v-model="form.detailedAddress" placeholder="请输入详细地址" />
        </el-form-item>
        <el-form-item label="统一社会信用代码或注册号" prop="socialCreditCode">
          <el-input v-model="form.socialCreditCode" placeholder="请输入统一社会信用代码或注册号" />
        </el-form-item>
        <el-form-item label="电子营业执照" prop="businessCertificatePhoto">
          <el-input v-model="form.businessCertificatePhoto" placeholder="请输入电子营业执照" />
        </el-form-item>
        <el-form-item label="法定代表人" prop="legalPerson">
          <el-input v-model="form.legalPerson" placeholder="请输入法定代表人" />
        </el-form-item>
        <el-form-item label="法人身份证" prop="legalIdCard">
          <el-input v-model="form.legalIdCard" placeholder="请输入法人身份证" />
        </el-form-item>
        <el-form-item label="法人身份证照片" prop="legalIdCardPhoto">
          <el-input v-model="form.legalIdCardPhoto" placeholder="请输入法人身份证照片" />
        </el-form-item>
        <el-form-item label="注册时间" prop="registerTime">
          <el-date-picker clearable v-model="form.registerTime" type="date" value-format="timestamp"
            placeholder="选择注册时间" />
        </el-form-item>
        <el-form-item label="公司简介">
          <editor v-model="form.description" :min-height="192" />
        </el-form-item>
        <el-form-item label="企业LOGO" prop="logo">
          <el-input v-model="form.logo" placeholder="请输入企业LOGO" />
        </el-form-item>
        <el-form-item label="经营许可证号" prop="businessLicenseNo">
          <el-input v-model="form.businessLicenseNo" placeholder="请输入经营许可证号" />
        </el-form-item>
        <el-form-item label="生产/经营许可证图片" prop="businessLicensePhoto">
          <el-input v-model="form.businessLicensePhoto" placeholder="请输入生产/经营许可证图片" />
        </el-form-item>
        <el-form-item label="证件截止日期" prop="businessLicenseEndTime">
          <el-date-picker clearable v-model="form.businessLicenseEndTime" type="date" value-format="timestamp"
            placeholder="选择证件截止日期" />
        </el-form-item>
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
        <el-form-item label="联系人" prop="contactName">
          <el-input v-model="form.contactName" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系人电话" prop="contactPhone">
          <el-input v-model="form.contactPhone" placeholder="请输入联系人电话" />
        </el-form-item>
        <el-form-item label="省id" prop="villagesAreaId">
          <el-input v-model="form.villagesAreaId" placeholder="请输入省id" />
        </el-form-item>
        <el-form-item label="省名称" prop="villagesAreaName">
          <el-input v-model="form.villagesAreaName" placeholder="请输入省名称" />
        </el-form-item>
        <el-form-item label="市id" prop="areaId">
          <el-input v-model="form.areaId" placeholder="请输入市id" />
        </el-form-item>
        <el-form-item label="市名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入市名称" />
        </el-form-item>
        <el-form-item label="区id" prop="ruralId">
          <el-input v-model="form.ruralId" placeholder="请输入区id" />
        </el-form-item>
        <el-form-item label="区名称" prop="ruralName">
          <el-input v-model="form.ruralName" placeholder="请输入区名称" />
        </el-form-item>
        <el-form-item label="企业规模" prop="enterpriseScale">
          <el-input v-model="form.enterpriseScale" placeholder="请输入企业规模" />
        </el-form-item>
        <el-form-item label="主营业务" prop="serviceRange">
          <el-input v-model="form.serviceRange" placeholder="请输入主营业务" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="租户集合" prop="source">
          <el-input v-model="form.source" placeholder="请输入租户集合" />
        </el-form-item>
        <el-form-item label="经营主体ID" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体ID" />
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
import { createBaseInfo, updateBaseInfo, deleteBaseInfo, getBaseInfo, getBaseInfoPage, exportBaseInfoExcel, stopBaseInfoPage,changeStatusBaseInfoPage } from "@/api/enterprise/baseInfo";
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
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 经营主体列表
      list: [],
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
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        manageStatus: [{ required: true, message: "经营状态不能为空", trigger: "change" }],
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
      getBaseInfoPage(this.queryParams).then(response => {
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
        code: undefined,
        name: undefined,
        enterpriseType: undefined,
        enterpriseTypeName: undefined,
        stauts: undefined,
        userTag: undefined,
        userTagName: undefined,
        manageStatus: undefined,
        address: undefined,
        detailedAddress: undefined,
        socialCreditCode: undefined,
        businessCertificatePhoto: undefined,
        legalPerson: undefined,
        legalIdCard: undefined,
        legalIdCardPhoto: undefined,
        registerTime: undefined,
        description: undefined,
        logo: undefined,
        businessLicenseNo: undefined,
        businessLicensePhoto: undefined,
        businessLicenseEndTime: undefined,
        accountName: undefined,
        accountNo: undefined,
        accountIdCard: undefined,
        accountBank: undefined,
        contactName: undefined,
        contactPhone: undefined,
        villagesAreaId: undefined,
        villagesAreaName: undefined,
        areaId: undefined,
        areaName: undefined,
        ruralId: undefined,
        ruralName: undefined,
        enterpriseScale: undefined,
        serviceRange: undefined,
        remarks: undefined,
        source: undefined,
        subjectId: undefined,
      };
      this.resetForm("form");
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加经营主体";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getBaseInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改经营主体";
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
          updateBaseInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createBaseInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      
      const id = row.id;
      this.$modal.confirm('是否确认删除经营主体编号为"' + id + '"的数据项?').then(function () {
        return deleteBaseInfo(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
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
      this.$router.push({ path: "/enterprise/baseInfo/businessInfoManagement", query: { id: row.id } });
    },
    handleStop(row) {
      console.log(row)
      const code = row.code;
      const id =row.id
      let stauts = row.stauts == 1 ? '停用' : '启用';
      this.$modal.confirm(`是否确认${stauts}主体编号为${code}的经营主体`).then(function () {
        // return stopBaseInfoPage(id);
        return changeStatusBaseInfoPage(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess(`${stauts}成功!`);
      }).catch(() => { });
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
