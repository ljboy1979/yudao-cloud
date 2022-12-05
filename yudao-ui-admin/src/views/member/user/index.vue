<template>
    <div class="app-container">
      <div class="title">会员管理</div>
      <!-- 搜索工作栏 -->
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item prop="memberRole">
          <el-select v-model="queryParams.memberRole" placeholder="请选择会员角色" clearable size="small">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.MEMBER_ROLE)" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item prop="memberType">
          <el-select v-model="queryParams.memberType" placeholder="请选择会员类型" clearable size="small">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.MEMBER_TYPE)" :key="dict.value" :label="dict.label"
              :value="dict.value" />
          </el-select>
        </el-form-item>
        <!-- <el-form-item prop="id">
          <el-input v-model="queryParams.id" placeholder="请输入会员id" clearable @keyup.enter.native="handleQuery" />
        </el-form-item> -->
        <el-form-item prop="memberAccount">
          <el-input v-model="queryParams.memberAccount" placeholder="请输入会员账号" clearable @keyup.enter.native="handleQuery" />
        </el-form-item>
        <el-form-item prop="nickname">
          <el-input v-model="queryParams.nickname" placeholder="请输入会员名称" clearable @keyup.enter.native="handleQuery" />
        </el-form-item>
        <el-form-item prop="mobile">
          <el-input v-model="queryParams.mobile" placeholder="请输入会员手机号" clearable @keyup.enter.native="handleQuery" />
        </el-form-item>
        <el-form-item prop="source">
          <el-input v-model="queryParams.source" placeholder="请输入会员门户" clearable @keyup.enter.native="handleQuery" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
          <el-button>用户开户统计表</el-button>
        </el-form-item>
      </el-form>
  
      <!-- 列表 -->
      <el-table v-loading="loading" :data="list">
        <!-- <el-table-column label="会员id" align="center" prop="id" /> -->
        <el-table-column label="会员账号" align="center" prop="memberAccount"  width="180"/>
        <el-table-column label="会员名称" align="center" prop="nickname" />
        <el-table-column label="手机号" align="center" prop="mobile" />
        <el-table-column label="角色" align="center" prop="memberRole" >
          <template v-slot="scope">
            <dict-tag :type="DICT_TYPE.MEMBER_ROLE" :value="scope.row.memberRole" />
          </template>
        </el-table-column>
        <el-table-column label="所属企业" align="center" prop="enterpriseName" />
        <el-table-column label="当前等级" align="center" prop="memberLevel" />
        <el-table-column label="当前积分" align="center" prop="integralRemaining" />
        <el-table-column label="注册时间" align="center" prop="createTime" width="180"/>
        <!-- <el-table-column label="注册时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column> -->
        <el-table-column label="小程序门户" align="center" prop="source" />
        <el-table-column label="会员类型" align="center" prop="memberType" >
          <template v-slot="scope">
            <dict-tag :type="DICT_TYPE.MEMBER_TYPE" :value="scope.row.memberType" />
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="auditStatus" >
          <template v-slot="scope">
            <dict-tag :type="DICT_TYPE.MEMBER_AUDIT_STATUS" :value="scope.row.auditStatus" />
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="220">
          <template slot-scope="scope">
            <el-button size="mini" type="text" @click="handleDetail(scope.row)" v-hasPermi="['']">管理</el-button>
            <el-button size="mini" type="text" @click="handleProcess(scope.row)" v-hasPermi="['']">审核</el-button>
            <el-button size="mini" type="text" v-if="scope.row.auditStatus==3" disabled>已解绑</el-button>
            <el-button size="mini" type="text" v-else @click="handleDelete(scope.row)" v-hasPermi="['']">解绑</el-button>
            <el-button size="mini" type="text" @click="handleType(scope.row)" v-hasPermi="['']">
              <span v-if="scope.row.memberType == 0">置为集采会员</span>
              <span v-else>置为普通会员</span>
            </el-button>
          </template>
        </el-table-column>
  
      </el-table>
      <!-- 分页组件 -->
      <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
        @pagination="getList" />
  
      <!-- 对话框(审核) -->
      <el-dialog :visible.sync="open" width="400px" v-dialogDrag append-to-body>
        <el-form ref="form" :model="form" :rules="rules">
          <el-form-item prop="auditStatus" label-width="100px">
            <el-radio-group v-model="form.auditStatus">
              <el-radio :key="1" :label="1">通过</el-radio>
              <el-radio :key="2" :label="2">不通过</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="备注" prop="remark" :rules="form.auditStatus == 2 ? rules.remark : { required: false }"
            label-width="55px">
            <el-input type="textarea" :rows="3" v-model="form.remark"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import { getUserPage, updateAuditStatus, userUnbundling, updateMemberType  } from "@/api/member/user";
  
  export default {
    name: "User",
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
        // 会员列表
        list: [],
        // 弹出层标题
        title: "审核",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNo: 1,
          pageSize: 10,
          memberRole: undefined,
          memberType: undefined,
          // id: undefined,
          memberAccount: undefined,
          nickname: undefined,
          mobile: undefined,
          source: undefined,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          auditStatus: [{ required: true, message: "审核结果不能为空", trigger: "blur" }],
          remark: [{ required: true, message: "备注不能为空", trigger: "blur" }],
        },
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
        getUserPage(this.queryParams).then(response => {
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
          romemberRole: undefined,
          romemberType: undefined,
          id: undefined,
          auditStatus: undefined,
          remark: undefined,
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
      /** 管理按钮操作 */
      handleDetail(row) {
        this.$router.push({ path: "/member/user/memberDetail", query: { id: row.id } });
      },
      /** 审核按钮操作 */
      handleProcess(row) {
        this.reset();
        this.form = {
          id: row.id,
          memberUserDetailId: row.memberUserDetailId,
        };
        this.open = true;
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (!valid) {
            return;
          }
          // 审核提交
          if (this.form.id != null) {
            updateAuditStatus(this.form).then(response => {
              this.$modal.msgSuccess("审核成功");
              this.open = false;
              this.getList();
            });
            return;
          }
        });
      },
      /** 解绑按钮操作 */
      handleDelete(row) {
        const form = {
          id: row.id,
          memberUserDetailId: row.memberUserDetailId,
          auditStatus: 3
        };
        this.$modal.confirm('是否确认将"' + row.nickname + '"解绑?').then(function () {
          return userUnbundling(form); 
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("解绑成功");
        }).catch(() => { });
      },
      /** 置为集采会员按钮操作 */
      handleType(row) {
        const form = {
          id: row.id,
          memberUserDetailId: row.memberUserDetailId,
          memberType: row.memberType == 0 ? 1 : 0
        };
        let type = row.memberType == 0 ? '集采' : '普通';
        this.$modal.confirm((`是否确认将${row.nickname}置为${type}会员？`)).then(function () {
          return updateMemberType(form); 
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess(`会员类型已变为${type}会员`);
        }).catch(() => { });
      }
    }
  };
  </script>
  <style scoped>
  .title {
      font-size: 24px;
      margin: 10px 0 20px 15px;
  }
  </style>
  