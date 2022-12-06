<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <!-- <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="会员id" prop="memberId">
        <el-input v-model="queryParams.memberId" placeholder="请输入会员id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="queryParams.age" placeholder="请输入年龄" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="身高" prop="height">
        <el-input v-model="queryParams.height" placeholder="请输入身高" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="体重" prop="weight">
        <el-input v-model="queryParams.weight" placeholder="请输入体重" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="住院号" prop="inpatientNo">
        <el-input v-model="queryParams.inpatientNo" placeholder="请输入住院号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="收货点" prop="receiptPoint">
        <el-input v-model="queryParams.receiptPoint" placeholder="请输入收货点" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="疗区" prop="treatmentArea">
        <el-input v-model="queryParams.treatmentArea" placeholder="请输入疗区" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="科室" prop="department">
        <el-input v-model="queryParams.department" placeholder="请输入科室" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="楼栋号" prop="buildingNo">
        <el-input v-model="queryParams.buildingNo" placeholder="请输入楼栋号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="楼层号" prop="floorNo">
        <el-input v-model="queryParams.floorNo" placeholder="请输入楼层号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="房间号" prop="roomNo">
        <el-input v-model="queryParams.roomNo" placeholder="请输入房间号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="床位号" prop="bedNo">
        <el-input v-model="queryParams.bedNo" placeholder="请输入床位号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="入院日期" prop="admissionDate">
        <el-date-picker v-model="queryParams.admissionDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
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
      </el-form-item>
    </el-form> -->

    <!-- 操作工具栏 -->
    <!-- 新增member:patient-health:create;导出member:patient-health:export -->
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
      <el-table-column label="会员id" align="center" prop="memberId" /> -->
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="性别" align="center" prop="sex" >
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.SYSTEM_USER_SEX" :value="scope.row.sex" />
        </template>
      </el-table-column>
      <el-table-column label="身高" align="center" prop="height" />
      <el-table-column label="体重" align="center" prop="weight" />
      <el-table-column label="住院号" align="center" prop="inpatientNo" />
      <el-table-column label="收货点" align="center" prop="receiptPoint" />
      <el-table-column label="疗区" align="center" prop="treatmentArea" />
      <el-table-column label="科室" align="center" prop="department" />
      <el-table-column label="楼栋号" align="center" prop="buildingNo" />
      <el-table-column label="楼层号" align="center" prop="floorNo" />
      <el-table-column label="房间号" align="center" prop="roomNo" />
      <el-table-column label="床位号" align="center" prop="bedNo" />
      <el-table-column label="入院日期" align="center" prop="admissionDate" width="180" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180" />
      <!-- <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['member:patient-health:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['member:patient-health:delete']">删除</el-button>
        </template>
      </el-table-column> -->
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="会员id" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员id" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="form.sex">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="身高" prop="height">
          <el-input v-model="form.height" placeholder="请输入身高" />
        </el-form-item>
        <el-form-item label="体重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入体重" />
        </el-form-item>
        <el-form-item label="住院号" prop="inpatientNo">
          <el-input v-model="form.inpatientNo" placeholder="请输入住院号" />
        </el-form-item>
        <el-form-item label="收货点" prop="receiptPoint">
          <el-input v-model="form.receiptPoint" placeholder="请输入收货点" />
        </el-form-item>
        <el-form-item label="疗区" prop="treatmentArea">
          <el-input v-model="form.treatmentArea" placeholder="请输入疗区" />
        </el-form-item>
        <el-form-item label="科室" prop="department">
          <el-input v-model="form.department" placeholder="请输入科室" />
        </el-form-item>
        <el-form-item label="楼栋号" prop="buildingNo">
          <el-input v-model="form.buildingNo" placeholder="请输入楼栋号" />
        </el-form-item>
        <el-form-item label="楼层号" prop="floorNo">
          <el-input v-model="form.floorNo" placeholder="请输入楼层号" />
        </el-form-item>
        <el-form-item label="房间号" prop="roomNo">
          <el-input v-model="form.roomNo" placeholder="请输入房间号" />
        </el-form-item>
        <el-form-item label="床位号" prop="bedNo">
          <el-input v-model="form.bedNo" placeholder="请输入床位号" />
        </el-form-item>
        <el-form-item label="入院日期" prop="admissionDate">
          <el-date-picker clearable v-model="form.admissionDate" type="date" value-format="timestamp" placeholder="选择入院日期" />
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
import { createPatientHealth, updatePatientHealth, deletePatientHealth, getPatientHealth, getPatientHealthPage, exportPatientHealthExcel } from "@/api/patient/patientHealth";

export default {
  name: "PatientHealth",
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
      // 健康档案列表
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
        name: null,
        age: null,
        sex: null,
        height: null,
        weight: null,
        inpatientNo: null,
        receiptPoint: null,
        treatmentArea: null,
        department: null,
        buildingNo: null,
        floorNo: null,
        roomNo: null,
        bedNo: null,
        admissionDate: [],
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
      getPatientHealthPage(this.queryParams).then(response => {
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
        name: undefined,
        age: undefined,
        sex: undefined,
        height: undefined,
        weight: undefined,
        inpatientNo: undefined,
        receiptPoint: undefined,
        treatmentArea: undefined,
        department: undefined,
        buildingNo: undefined,
        floorNo: undefined,
        roomNo: undefined,
        bedNo: undefined,
        admissionDate: undefined,
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
      this.title = "添加健康档案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPatientHealth(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改健康档案";
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
          updatePatientHealth(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPatientHealth(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除健康档案编号为"' + id + '"的数据项?').then(function() {
          return deletePatientHealth(id);
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
      this.$modal.confirm('是否确认导出所有健康档案数据项?').then(() => {
          this.exportLoading = true;
          return exportPatientHealthExcel(params);
        }).then(response => {
          this.$download.excel(response, '健康档案.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
