<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd" v-hasPermi="['member:integral-record:create']">
          新增</el-button>
      </el-form-item>
      <!-- <el-form-item label="会员id" prop="memberId">
        <el-input v-model="queryParams.memberId" placeholder="请输入会员id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="会员账号" prop="memberAccount">
        <el-input v-model="queryParams.memberAccount" placeholder="请输入会员账号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="会员名称" prop="memberName">
        <el-input v-model="queryParams.memberName" placeholder="请输入会员名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="评分项目" prop="ratingItems">
        <el-input v-model="queryParams.ratingItems" placeholder="请输入评分项目" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="本次积分变动" prop="integralChange">
        <el-input v-model="queryParams.integralChange" placeholder="请输入本次积分变动" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="当前剩余积分" prop="integralRemaining">
        <el-input v-model="queryParams.integralRemaining" placeholder="请输入当前剩余积分" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="积分使用明细" prop="integralUseDetails">
        <el-input v-model="queryParams.integralUseDetails" placeholder="请输入积分使用明细" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item> -->
      <el-form-item prop="integralChangeTime">
        <el-date-picker v-model="queryParams.integralChangeTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <!-- <el-form-item label="图片" prop="picture">
        <el-input v-model="queryParams.picture" placeholder="请输入图片" clearable @keyup.enter.native="handleQuery"/>
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
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <!-- <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          :loading="exportLoading" v-hasPermi="['member:integral-record:export']">导出</el-button> -->
      </el-form-item>
    </el-form>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <!-- <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="会员id" align="center" prop="memberId" /> -->
      <el-table-column label="会员账号" align="center" prop="memberAccount" />
      <el-table-column label="会员名称" align="center" prop="memberName" />
      <el-table-column label="评分项目" align="center" prop="ratingItems" />
      <el-table-column label="本次积分变动" align="center" prop="integralChange" />
      <el-table-column label="当前剩余积分" align="center" prop="integralRemaining" />
      <!-- <el-table-column label="积分使用明细" align="center" prop="integralUseDetails" /> -->
      <el-table-column label="积分变动时间" align="center" prop="integralChangeTime" />
      <!-- <el-table-column label="图片" align="center" prop="picture" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" @click="handleView(scope.row)" v-hasPermi="['']">查看</el-button>
          <el-button size="mini" type="text" @click="handleUpdate(scope.row)"
            v-hasPermi="['member:integral-record:update']">修改</el-button>
          <el-button size="mini" type="text" @click="handleDelete(scope.row)"
            v-hasPermi="['member:integral-record:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="会员id" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员id" />
        </el-form-item> -->
        <el-form-item label="会员账号" prop="memberAccount">
          <el-input v-model="form.memberAccount" placeholder="请输入会员账号" />
        </el-form-item>
        <el-form-item label="会员名称" prop="memberName">
          <el-input v-model="form.memberName" placeholder="请输入会员名称" />
        </el-form-item>
        <el-form-item label="评分项目" prop="ratingItems">
          <el-select v-model="form.ratingItems" placeholder="请选择评分项目">
            <el-option label="数据" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="评分分数" prop="ratingScore">
          <el-input v-model="form.ratingScore" placeholder="请输入评分分数" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <!-- <el-form-item label="本次积分变动" prop="integralChange">
          <el-input v-model="form.integralChange" placeholder="请输入本次积分变动" />
        </el-form-item>
        <el-form-item label="当前剩余积分" prop="integralRemaining">
          <el-input v-model="form.integralRemaining" placeholder="请输入当前剩余积分" />
        </el-form-item>
        <el-form-item label="积分使用明细" prop="integralUseDetails">
          <el-input v-model="form.integralUseDetails" placeholder="请输入积分使用明细" />
        </el-form-item>
        <el-form-item label="积分变动时间" prop="integralChangeTime">
          <el-date-picker clearable v-model="form.integralChangeTime" type="date" value-format="timestamp" placeholder="选择积分变动时间" />
        </el-form-item>
        <el-form-item label="图片" prop="picture">
          <el-input v-model="form.picture" placeholder="请输入图片" />
        </el-form-item>
        <el-form-item label="租户集合" prop="source">
          <el-input v-model="form.source" placeholder="请输入租户集合" />
        </el-form-item>
        <el-form-item label="经营主体ID" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体ID" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 对话框(查看) -->
    <el-dialog :title="title" :visible.sync="viewopen" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="会员账号" prop="memberAccount">{{ form.memberAccount }}</el-form-item>
        <el-form-item label="会员名称" prop="memberName">{{ form.memberName }}</el-form-item>
        <el-form-item label="评分项目" prop="ratingItems">{{ form.ratingItems }}</el-form-item>
        <el-form-item label="评分分数" prop="ratingItratingScoreems">{{ form.ratingScore }}</el-form-item>
        <el-form-item label="备注" prop="remark">{{ form.remark }}</el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { createIntegralRecord, updateIntegralRecord, deleteIntegralRecord, getIntegralRecord, getIntegralRecordPage, exportIntegralRecordExcel } from "@/api/member/integralRecord";

export default {
  name: "IntegralRecord",
  components: {
  },
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
      // 会员积分记录列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      viewopen: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        memberId: null,
        memberAccount: null,
        memberName: null,
        ratingItems: null,
        integralChange: null,
        integralRemaining: null,
        integralUseDetails: null,
        integralChangeTime: [],
        picture: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        memberId: [{ required: true, message: "会员id不能为空", trigger: "blur" }],
        ratingItems: [{ required: true, message: "评分项目不能为空", trigger: "blur" }],
        ratingScore: [{ required: true, message: "评分分数不能为空", trigger: "blur" }],
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
      getIntegralRecordPage(this.queryParams).then(response => {
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
        memberId: undefined,
        memberAccount: undefined,
        memberName: undefined,
        ratingItems: undefined,
        integralChange: undefined,
        integralRemaining: undefined,
        integralUseDetails: undefined,
        integralChangeTime: undefined,
        picture: undefined,
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
      this.title = "添加会员积分记录";
    },
    /** 查看按钮操作 */
    handleView(row) {
      this.reset();
      const id = row.id;
      getIntegralRecord(id).then(response => {
        this.form = response.data;
        this.viewopen = true;
        this.title = "查看会员积分记录";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getIntegralRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员积分记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        this.form.memberId = this.id
        // 修改的提交
        if (this.form.id != null) {
          updateIntegralRecord(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createIntegralRecord(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除会员积分记录编号为"' + id + '"的数据项?').then(function () {
        return deleteIntegralRecord(id);
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
      this.$modal.confirm('是否确认导出所有会员积分记录数据项?').then(() => {
        this.exportLoading = true;
        return exportIntegralRecordExcel(params);
      }).then(response => {
        this.$download.excel(response, '会员积分记录.xls');
        this.exportLoading = false;
      }).catch(() => { });
    }
  }
};
</script>
