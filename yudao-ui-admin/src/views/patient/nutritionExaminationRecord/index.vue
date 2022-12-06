<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <!-- <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="健康档案id" prop="patientHealthId">
        <el-input v-model="queryParams.patientHealthId" placeholder="请输入健康档案id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="医院" prop="hospital">
        <el-input v-model="queryParams.hospital" placeholder="请输入医院" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="科室" prop="department">
        <el-input v-model="queryParams.department" placeholder="请输入科室" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="检查医生" prop="doctor">
        <el-input v-model="queryParams.doctor" placeholder="请输入检查医生" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="检查日期" prop="checkDate">
        <el-date-picker v-model="queryParams.checkDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="检查类别" prop="checkCategory">
        <el-input v-model="queryParams.checkCategory" placeholder="请输入检查类别" clearable @keyup.enter.native="handleQuery"/>
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
      </el-form-item>
    </el-form> -->

    <!-- 操作工具栏 -->
    <!-- 新增member:nutrition-examination-record:create;导出member:nutrition-examination-record:export -->
    <!-- <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row> -->

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <!-- <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="健康档案id" align="center" prop="patientHealthId" /> -->
      <el-table-column label="医院" align="center" prop="hospital" />
      <el-table-column label="科室" align="center" prop="department" />
      <el-table-column label="检查医生" align="center" prop="doctor" />
      <el-table-column label="检查日期" align="center" prop="checkDate" width="180" />
      <el-table-column label="检查类别" align="center" prop="checkCategory" />
      <el-table-column label="检查内容" align="center" prop="checkContent" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180" />
      <!-- <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['member:nutrition-examination-record:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['member:nutrition-examination-record:delete']">删除</el-button>
        </template>
      </el-table-column> -->
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="健康档案id" prop="patientHealthId">
          <el-input v-model="form.patientHealthId" placeholder="请输入健康档案id" />
        </el-form-item>
        <el-form-item label="医院" prop="hospital">
          <el-input v-model="form.hospital" placeholder="请输入医院" />
        </el-form-item>
        <el-form-item label="科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入科室" />
        </el-form-item>
        <el-form-item label="检查医生" prop="doctor">
          <el-input v-model="form.doctor" placeholder="请输入检查医生" />
        </el-form-item>
        <el-form-item label="检查日期" prop="checkDate">
          <el-date-picker clearable v-model="form.checkDate" type="date" value-format="timestamp" placeholder="选择检查日期" />
        </el-form-item>
        <el-form-item label="检查类别" prop="checkCategory">
          <el-input v-model="form.checkCategory" placeholder="请输入检查类别" />
        </el-form-item>
        <el-form-item label="检查内容">
          <editor v-model="form.checkContent" :min-height="192"/>
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
import { createNutritionExaminationRecord, updateNutritionExaminationRecord, deleteNutritionExaminationRecord, getNutritionExaminationRecord, getNutritionExaminationRecordPage, exportNutritionExaminationRecordExcel } from "@/api/patient/nutritionExaminationRecord";
import Editor from '@/components/Editor';

export default {
  name: "NutritionExaminationRecord",
  components: {
    Editor,
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
      // 营养检查记录列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        memberId: this.id,
        patientHealthId: null,
        hospital: null,
        department: null,
        doctor: null,
        checkDate: [],
        checkCategory: null,
        checkContent: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        patientHealthId: [{ required: true, message: "健康档案id不能为空", trigger: "blur" }],
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
      getNutritionExaminationRecordPage(this.queryParams).then(response => {
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
        patientHealthId: undefined,
        hospital: undefined,
        department: undefined,
        doctor: undefined,
        checkDate: undefined,
        checkCategory: undefined,
        checkContent: undefined,
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
      this.title = "添加营养检查记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getNutritionExaminationRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改营养检查记录";
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
          updateNutritionExaminationRecord(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createNutritionExaminationRecord(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除营养检查记录编号为"' + id + '"的数据项?').then(function() {
          return deleteNutritionExaminationRecord(id);
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
      this.$modal.confirm('是否确认导出所有营养检查记录数据项?').then(() => {
          this.exportLoading = true;
          return exportNutritionExaminationRecordExcel(params);
        }).then(response => {
          this.$download.excel(response, '营养检查记录.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
