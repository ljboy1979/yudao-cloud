<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="最多参与人数" prop="maxAttendPeople">
        <el-input v-model="queryParams.maxAttendPeople" placeholder="请输入最多参与人数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="实际参与人数" prop="attendPeople">
        <el-input v-model="queryParams.attendPeople" placeholder="请输入实际参与人数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="活动报名费用" prop="registrationFee">
        <el-input v-model="queryParams.registrationFee" placeholder="请输入活动报名费用" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="活动id" prop="activityId">
        <el-input v-model="queryParams.activityId" placeholder="请输入活动id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始时间" prop="startTime">
        <el-date-picker v-model="queryParams.startTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="备注信息" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入备注信息" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务id" prop="serviceId">
        <el-input v-model="queryParams.serviceId" placeholder="请输入服务id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始日期" prop="startDate">
        <el-date-picker v-model="queryParams.startDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束日期" prop="endDate">
        <el-date-picker v-model="queryParams.endDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker v-model="queryParams.endTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="基地id" prop="basesId">
        <el-input v-model="queryParams.basesId" placeholder="请输入基地id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="项目来源" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入项目来源" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['service:activity-session:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:activity-session:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="最多参与人数" align="center" prop="maxAttendPeople" />
      <el-table-column label="实际参与人数" align="center" prop="attendPeople" />
      <el-table-column label="活动报名费用" align="center" prop="registrationFee" />
      <el-table-column label="活动id" align="center" prop="activityId" />
      <el-table-column label="开始时间" align="center" prop="startTime" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="服务id" align="center" prop="serviceId" />
      <el-table-column label="开始日期" align="center" prop="startDate" />
      <el-table-column label="结束日期" align="center" prop="endDate" />
      <el-table-column label="结束时间" align="center" prop="endTime" />
      <el-table-column label="基地id" align="center" prop="basesId" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:activity-session:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:activity-session:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="最多参与人数" prop="maxAttendPeople">
          <el-input v-model="form.maxAttendPeople" placeholder="请输入最多参与人数" />
        </el-form-item>
        <el-form-item label="实际参与人数" prop="attendPeople">
          <el-input v-model="form.attendPeople" placeholder="请输入实际参与人数" />
        </el-form-item>
        <el-form-item label="活动报名费用" prop="registrationFee">
          <el-input v-model="form.registrationFee" placeholder="请输入活动报名费用" />
        </el-form-item>
        <el-form-item label="活动id" prop="activityId">
          <el-input v-model="form.activityId" placeholder="请输入活动id" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable v-model="form.startTime" type="date" value-format="timestamp" placeholder="选择开始时间" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="服务id" prop="serviceId">
          <el-input v-model="form.serviceId" placeholder="请输入服务id" />
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable v-model="form.startDate" type="date" value-format="timestamp" placeholder="选择开始日期" />
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable v-model="form.endDate" type="date" value-format="timestamp" placeholder="选择结束日期" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable v-model="form.endTime" type="date" value-format="timestamp" placeholder="选择结束时间" />
        </el-form-item>
        <el-form-item label="基地id" prop="basesId">
          <el-input v-model="form.basesId" placeholder="请输入基地id" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="项目来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入项目来源" />
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
import { createActivitySession, updateActivitySession, deleteActivitySession, getActivitySession, getActivitySessionPage, exportActivitySessionExcel } from "@/api/service/activitySession";

export default {
  name: "ActivitySession",
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
      // 时间排期列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        maxAttendPeople: null,
        attendPeople: null,
        registrationFee: null,
        activityId: null,
        startTime: [],
        remarks: null,
        serviceId: null,
        startDate: [],
        endDate: [],
        endTime: [],
        basesId: null,
        status: null,
        createTime: [],
        source: null,
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
      getActivitySessionPage(this.queryParams).then(response => {
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
        maxAttendPeople: undefined,
        attendPeople: undefined,
        registrationFee: undefined,
        activityId: undefined,
        startTime: undefined,
        remarks: undefined,
        serviceId: undefined,
        startDate: undefined,
        endDate: undefined,
        endTime: undefined,
        basesId: undefined,
        status: undefined,
        source: undefined,
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
      this.title = "添加时间排期";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getActivitySession(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改时间排期";
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
          updateActivitySession(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createActivitySession(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除时间排期编号为"' + id + '"的数据项?').then(function() {
          return deleteActivitySession(id);
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
      this.$modal.confirm('是否确认导出所有时间排期数据项?').then(() => {
          this.exportLoading = true;
          return exportActivitySessionExcel(params);
        }).then(response => {
          this.$download.excel(response, '时间排期.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
