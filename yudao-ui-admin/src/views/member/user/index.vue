<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="role">
        <el-select v-model="queryParams.role" placeholder="请选择会员角色" clearable size="small">
          <el-option label="数据" value="" />
        </el-select>
      </el-form-item>
      <el-form-item prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择会员类型" clearable size="small">
          <el-option label="数据" value="" />
        </el-select>
      </el-form-item>
      <el-form-item prop="id">
        <el-input v-model="queryParams.id" placeholder="请输入会员账号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item prop="nickname">
        <el-input v-model="queryParams.nickname" placeholder="请输入会员名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item prop="mobile">
        <el-input v-model="queryParams.mobile" placeholder="请输入会员手机号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item prop="merchant">
        <el-input v-model="queryParams.merchant" placeholder="请输入会员门户" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-button>用户开户统计表</el-button>
      </el-form-item>

      <!-- <el-form-item label="用户昵称" prop="nickname">
        <el-input v-model="queryParams.nickname" placeholder="请输入用户昵称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="头像" prop="avatar">
        <el-input v-model="queryParams.avatar" placeholder="请输入头像" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="手机号" prop="mobile">
        <el-input v-model="queryParams.mobile" placeholder="请输入手机号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="queryParams.password" placeholder="请输入密码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="注册 IP" prop="registerIp">
        <el-input v-model="queryParams.registerIp" placeholder="请输入注册 IP" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="最后登录IP" prop="loginIp">
        <el-input v-model="queryParams.loginIp" placeholder="请输入最后登录IP" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="最后登录时间" prop="loginDate">
        <el-date-picker v-model="queryParams.loginDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户集合" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入租户集合" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经营主体ID" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item> -->
    </el-form>

    <!-- 操作工具栏 -->
    <!-- <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['member:user:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['member:user:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row> -->

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="会员账号" align="center" prop="id" />
      <el-table-column label="会员名称" align="center" prop="nickname" />
      <el-table-column label="手机号" align="center" prop="mobile" />
      <el-table-column label="角色" align="center" prop="" />
      <el-table-column label="所属企业" align="center" prop="" />
      <el-table-column label="当前等级" align="center" prop="" />
      <el-table-column label="当前积分" align="center" prop="" />
      <el-table-column label="注册时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="小程序门户" align="center" prop="" />
      <el-table-column label="会员类型" align="center" prop="" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="300">
        <template slot-scope="scope">
          <el-button size="mini" type="text" @click="handleDetail(scope.row)"
                     v-hasPermi="['']">管理</el-button>
          <el-button size="mini" type="text" @click="handleProcess(scope.row)"
                     v-hasPermi="['']">审核</el-button>
          <el-button size="mini" type="text" @click="handleDelete(scope.row)"
                     v-hasPermi="['']">解绑</el-button>
          <el-button size="mini" type="text" @click=""
                     v-hasPermi="['']">置为集采会员</el-button>
        </template>
      </el-table-column>

      <!-- <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="用户昵称" align="center" prop="nickname" />
      <el-table-column label="头像" align="center" prop="avatar" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="手机号" align="center" prop="mobile" />
      <el-table-column label="密码" align="center" prop="password" />
      <el-table-column label="注册 IP" align="center" prop="registerIp" />
      <el-table-column label="最后登录IP" align="center" prop="loginIp" />
      <el-table-column label="最后登录时间" align="center" prop="loginDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.loginDate) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['member:user:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['member:user:delete']">删除</el-button>
        </template>
      </el-table-column> -->
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>
    
    <!-- 对话框(审核) -->
    <el-dialog :visible.sync="open" width="400px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" >
        <el-form-item  prop="result" label-width="100px">
          <!-- <el-radio-group v-model="form.result" style="display: flex; align-items: center;justify-content: center;margin: 0 10px;"> -->
          <el-radio-group v-model="form.result" >
            <el-radio :key="true" :label="true">通过</el-radio>
            <el-radio :key="false" :label="false" >不通过</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark" :rules="form.result == false ? rules.remark : { required: false}" label-width="55px">
          <el-input type="textarea" :rows="3" v-model="form.remark"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    
    <!-- 对话框(添加 / 修改) -->
    <!-- <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户昵称" prop="nickname">
          <el-input v-model="form.nickname" placeholder="请输入用户昵称" />
        </el-form-item>
        <el-form-item label="头像" prop="avatar">
          <el-input v-model="form.avatar" placeholder="请输入头像" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="手机号" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="注册 IP" prop="registerIp">
          <el-input v-model="form.registerIp" placeholder="请输入注册 IP" />
        </el-form-item>
        <el-form-item label="最后登录IP" prop="loginIp">
          <el-input v-model="form.loginIp" placeholder="请输入最后登录IP" />
        </el-form-item>
        <el-form-item label="最后登录时间" prop="loginDate">
          <el-date-picker clearable v-model="form.loginDate" type="date" value-format="timestamp" placeholder="选择最后登录时间" />
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
    </el-dialog> -->
  </div>
</template>

<script>
import { createUser, updateUser, deleteUser, getUser, getUserPage, exportUserExcel } from "@/api/member/user";

export default {
  name: "User",
  components: {
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
        id: null,
        nickname: null,
        mobile: null,

        avatar: null,
        status: null,
        password: null,
        registerIp: null,
        loginIp: null,
        loginDate: [],
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        result: [{ required: true, message: "审核结果不能为空", trigger: "blur" }],
        remark: [{ required: true, message: "备注不能为空", trigger: "blur" }],

        nickname: [{ required: true, message: "用户昵称不能为空", trigger: "blur" }],
        avatar: [{ required: true, message: "头像不能为空", trigger: "blur" }],
        status: [{ required: true, message: "状态不能为空", trigger: "blur" }],
        mobile: [{ required: true, message: "手机号不能为空", trigger: "blur" }],
        password: [{ required: true, message: "密码不能为空", trigger: "blur" }],
        registerIp: [{ required: true, message: "注册 IP不能为空", trigger: "blur" }],
      },
  
      processid: '',
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
        role: undefined,
        role: undefined,
        id: undefined,
        nickname: undefined,
        mobile: undefined,
        merchant: undefined,

        avatar: undefined,
        status: undefined,
        password: undefined,
        registerIp: undefined,
        loginIp: undefined,
        loginDate: undefined,
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
    /** 详情按钮操作 */
    handleDetail(row) {
      this.$router.push({ path: "/member/user/memberDetail", query: { id: row.id}});
    },
    /** 审核按钮操作 */
    handleProcess(row) {
      this.reset();
      this.processid = row.id;
      this.open = true;
      
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        
      });
    },
    /** 解绑按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认将"' + id + '"解绑?').then(function () {
        console.log("解绑", id)
        // return delete(id); //解绑接口
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("解绑成功");
      }).catch(() => {});
    }
    /** 新增按钮操作 */
    // handleAdd() {
    //   this.reset();
    //   this.open = true;
    //   this.title = "添加会员";
    // },
    /** 修改按钮操作 */
    // handleUpdate(row) {
    //   this.reset();
    //   const id = row.id;
    //   getUser(id).then(response => {
    //     this.form = response.data;
    //     this.open = true;
    //     this.title = "修改会员";
    //   });
    // },
    /** 提交按钮 */
    // submitForm() {
    //   this.$refs["form"].validate(valid => {
    //     if (!valid) {
    //       return;
    //     }
    //     // 修改的提交
    //     if (this.form.id != null) {
    //       updateUser(this.form).then(response => {
    //         this.$modal.msgSuccess("修改成功");
    //         this.open = false;
    //         this.getList();
    //       });
    //       return;
    //     }
    //     // 添加的提交
    //     createUser(this.form).then(response => {
    //       this.$modal.msgSuccess("新增成功");
    //       this.open = false;
    //       this.getList();
    //     });
    //   });
    // },
    /** 删除按钮操作 */
    // handleDelete(row) {
    //   const id = row.id;
    //   this.$modal.confirm('是否确认删除会员编号为"' + id + '"的数据项?').then(function() {
    //       return deleteUser(id);
    //     }).then(() => {
    //       this.getList();
    //       this.$modal.msgSuccess("删除成功");
    //     }).catch(() => {});
    // },
    /** 导出按钮操作 */
    // handleExport() {
    //   // 处理查询参数
    //   let params = {...this.queryParams};
    //   params.pageNo = undefined;
    //   params.pageSize = undefined;
    //   this.$modal.confirm('是否确认导出所有会员数据项?').then(() => {
    //       this.exportLoading = true;
    //       return exportUserExcel(params);
    //     }).then(response => {
    //       this.$download.excel(response, '会员.xls');
    //       this.exportLoading = false;
    //     }).catch(() => {});
    // }
  }
};
</script>
