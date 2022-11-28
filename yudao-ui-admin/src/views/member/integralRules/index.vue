<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd" v-hasPermi="['member:integral-rules:create']">
          新增</el-button>
      </el-form-item>
      <!-- <el-form-item label="企业id" prop="enterpriseId">
        <el-input v-model="queryParams.enterpriseId" placeholder="请输入企业id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="企业名称" prop="enterpriseName">
        <el-input v-model="queryParams.enterpriseName" placeholder="请输入企业名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="上级项目" prop="parentLevelProject">
        <el-input v-model="queryParams.parentLevelProject" placeholder="请输入上级项目" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item> -->
      <el-form-item prop="ratingItems">
        <el-input v-model="queryParams.ratingItems" placeholder="请输入评分项目" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <!-- <el-form-item label="数值范围" prop="rangeValues">
        <el-input v-model="queryParams.rangeValues" placeholder="请输入数值范围" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="积分值" prop="integralValue">
        <el-input v-model="queryParams.integralValue" placeholder="请输入积分值" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input v-model="queryParams.remark" placeholder="请输入备注" clearable @keyup.enter.native="handleQuery"/>
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
        <!-- <el-button type="primary" plain icon="el-icon-download" @click="handleExport"
          :loading="exportLoading" v-hasPermi="['member:integral-rules:export']">导出</el-button> -->
      </el-form-item>
    </el-form>


    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="企业名称" align="center" prop="enterpriseName" />
      <el-table-column label="上级项目" align="center" prop="parentLevelProject" />
      <el-table-column label="评分项目" align="center" prop="ratingItems" />
      <el-table-column label="数值范围" align="center" prop="rangeValues" />
      <el-table-column label="积分值" align="center" prop="integralValue" />
      <el-table-column label="备注" align="center" prop="remark" />
      <!-- <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="企业id" align="center" prop="enterpriseId" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" @click="handleView(scope.row)" v-hasPermi="['']">查看</el-button>
          <el-button size="mini" type="text" @click="handleUpdate(scope.row)"
            v-hasPermi="['member:integral-rules:update']">修改</el-button>
          <el-button size="mini" type="text" @click="handleDelete(scope.row)"
            v-hasPermi="['member:integral-rules:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="企业id" prop="enterpriseId">
          <el-input v-model="form.enterpriseId" placeholder="请输入企业id" />
        </el-form-item> -->
        <el-form-item label="企业名称" prop="enterpriseName">
          <el-select v-model="form.enterpriseName" placeholder="请选择企业名称">
            <el-option label="数据" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="上级项目" prop="parentLevelProject">
          <el-select v-model="form.parentLevelProject" placeholder="请选择上级项目">
            <el-option label="模块维护" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="评分项目" prop="ratingItems">
          <el-select v-model="form.ratingItems" placeholder="请选择评分项目">
            <el-option label="模块维护" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="数值范围" prop="rangeValues">
          <!-- <el-input v-model="form.rangeValues" placeholder="请输入数值范围" /> -->
          <el-col :span="10">
            <el-input v-model="form.rangeLower" placeholder="下限" />
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="10">
            <el-input v-model="form.rangeUpper" placeholder="上限" />
          </el-col>

        </el-form-item>
        <el-form-item label="积分值" prop="integralValue">
          <el-input v-model="form.integralValue" placeholder="请输入积分值" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input type="textarea" v-model="form.remark" placeholder="请输入备注" maxlength="200"
            show-word-limit />
        </el-form-item>
        <!-- <el-form-item label="租户集合" prop="source">
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

    <el-dialog :title="title" :visible.sync="viewopen" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="企业名称" prop="enterpriseName">{{ form.enterpriseName }}</el-form-item>
        <el-form-item label="上级项目" prop="parentLevelProject">{{ form.parentLevelProject }}</el-form-item>
        <el-form-item label="评分项目" prop="ratingItems">{{ form.ratingItems }}</el-form-item>
        <el-form-item label="数值范围" prop="rangeValues">{{ form.rangeValues }}</el-form-item>
        <el-form-item label="积分值" prop="integralValue">{{ form.integralValue }}</el-form-item>
        <el-form-item label="备注" prop="remark">{{ form.remark }} </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import { createIntegralRules, updateIntegralRules, deleteIntegralRules, getIntegralRules, getIntegralRulesPage, exportIntegralRulesExcel } from "@/api/member/integralRules";

export default {
  name: "IntegralRules",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // loading: false,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 会员积分规则列表
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
        enterpriseId: null,
        enterpriseName: null,
        parentLevelProject: null,
        ratingItems: null,
        // rangeValues: null,
        rangeUpper: null,
        rangeLower: null,
        integralValue: null,
        remark: null,
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
      getIntegralRulesPage(this.queryParams).then(response => {
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
        enterpriseId: undefined,
        enterpriseName: undefined,
        parentLevelProject: undefined,
        ratingItems: undefined,
        rangeValues: undefined,
        integralValue: undefined,
        remark: undefined,
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
      this.title = "添加会员积分规则";
    },
    /** 查看按钮操作 */
    handleView(row) {
      this.reset();
      const id = row.id;
      getIntegralRules(id).then(response => {
        this.form = response.data;
        this.viewopen = true;
        this.title = "查看会员积分规则";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getIntegralRules(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员积分规则";
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
          updateIntegralRules(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createIntegralRules(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除会员积分规则编号为"' + id + '"的数据项?').then(function () {
        return deleteIntegralRules(id);
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
      this.$modal.confirm('是否确认导出所有会员积分规则数据项?').then(() => {
        this.exportLoading = true;
        return exportIntegralRulesExcel(params);
      }).then(response => {
        this.$download.excel(response, '会员积分规则.xls');
        this.exportLoading = false;
      }).catch(() => { });
    }
  }
};
</script>
<style>
.line{text-align: center;}
</style>