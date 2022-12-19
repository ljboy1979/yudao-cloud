<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="基地id" prop="basesId">
        <el-input v-model="queryParams.basesId" placeholder="请输入基地id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备" prop="devicesId">
        <el-input v-model="queryParams.devicesId" placeholder="请输入设备" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试者" prop="tester">
        <el-input v-model="queryParams.tester" placeholder="请输入测试者" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试时间" prop="testTime">
        <el-date-picker v-model="queryParams.testTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="时间" prop="insertTime">
        <el-date-picker v-model="queryParams.insertTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="光照强度" prop="lightIntensity">
        <el-input v-model="queryParams.lightIntensity" placeholder="请输入光照强度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地貌类型" prop="geomorphicType">
        <el-select v-model="queryParams.geomorphicType" placeholder="请选择地貌类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="地形部位" prop="landform">
        <el-input v-model="queryParams.landform" placeholder="请输入地形部位" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地面坡度" prop="groundSlope">
        <el-input v-model="queryParams.groundSlope" placeholder="请输入地面坡度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="坡向" prop="slopeDirection">
        <el-input v-model="queryParams.slopeDirection" placeholder="请输入坡向" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="常年有效积温" prop="effectiveTemperature">
        <el-input v-model="queryParams.effectiveTemperature" placeholder="请输入常年有效积温" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="常年无霜期" prop="frostFreePeriod">
        <el-input v-model="queryParams.frostFreePeriod" placeholder="请输入常年无霜期" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="30年最低温度天数" prop="minTemperatureDays">
        <el-input v-model="queryParams.minTemperatureDays" placeholder="请输入30年最低温度天数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="30年最高温度天数" prop="maxTemperatureDays">
        <el-input v-model="queryParams.maxTemperatureDays" placeholder="请输入30年最高温度天数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="典型种植制度" prop="typicalCropSystem">
        <el-input v-model="queryParams.typicalCropSystem" placeholder="请输入典型种植制度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="熟制" prop="maturationSystem">
        <el-input v-model="queryParams.maturationSystem" placeholder="请输入熟制" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="常年产量水平" prop="annualYieldLevel">
        <el-input v-model="queryParams.annualYieldLevel" placeholder="请输入常年产量水平" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="农田基础设施" prop="farmlandInfrastructure">
        <el-input v-model="queryParams.farmlandInfrastructure" placeholder="请输入农田基础设施" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="备注信息" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入备注信息" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="机构编码" prop="officeCode">
        <el-input v-model="queryParams.officeCode" placeholder="请输入机构编码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="机构名称" prop="officeName">
        <el-input v-model="queryParams.officeName" placeholder="请输入机构名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="公司编码" prop="companyCode">
        <el-input v-model="queryParams.companyCode" placeholder="请输入公司编码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="公司名称" prop="companyName">
        <el-input v-model="queryParams.companyName" placeholder="请输入公司名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="审核状态" prop="reviewStatus">
        <el-select v-model="queryParams.reviewStatus" placeholder="请选择审核状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="审核人" prop="reviewer">
        <el-input v-model="queryParams.reviewer" placeholder="请输入审核人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="审核时间" prop="reviewDate">
        <el-date-picker v-model="queryParams.reviewDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户代码" prop="corpCode">
        <el-input v-model="queryParams.corpCode" placeholder="请输入租户代码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户名称" prop="corpName">
        <el-input v-model="queryParams.corpName" placeholder="请输入租户名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="海拔" prop="altitude">
        <el-input v-model="queryParams.altitude" placeholder="请输入海拔" clearable @keyup.enter.native="handleQuery"/>
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
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['bases:phenological-env:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['bases:phenological-env:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="基地id" align="center" prop="basesId" />
      <el-table-column label="设备" align="center" prop="devicesId" />
      <el-table-column label="测试者" align="center" prop="tester" />
      <el-table-column label="测试时间" align="center" prop="testTime" />
      <el-table-column label="时间" align="center" prop="insertTime" />
      <el-table-column label="光照强度" align="center" prop="lightIntensity" />
      <el-table-column label="地貌类型" align="center" prop="geomorphicType" />
      <el-table-column label="地形部位" align="center" prop="landform" />
      <el-table-column label="地面坡度" align="center" prop="groundSlope" />
      <el-table-column label="坡向" align="center" prop="slopeDirection" />
      <el-table-column label="常年有效积温" align="center" prop="effectiveTemperature" />
      <el-table-column label="常年无霜期" align="center" prop="frostFreePeriod" />
      <el-table-column label="30年最低温度天数" align="center" prop="minTemperatureDays" />
      <el-table-column label="30年最高温度天数" align="center" prop="maxTemperatureDays" />
      <el-table-column label="典型种植制度" align="center" prop="typicalCropSystem" />
      <el-table-column label="熟制" align="center" prop="maturationSystem" />
      <el-table-column label="常年产量水平" align="center" prop="annualYieldLevel" />
      <el-table-column label="农田基础设施" align="center" prop="farmlandInfrastructure" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="海拔" align="center" prop="altitude" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['bases:phenological-env:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['bases:phenological-env:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="基地id" prop="basesId">
          <el-input v-model="form.basesId" placeholder="请输入基地id" />
        </el-form-item>
        <el-form-item label="设备" prop="devicesId">
          <el-input v-model="form.devicesId" placeholder="请输入设备" />
        </el-form-item>
        <el-form-item label="测试者" prop="tester">
          <el-input v-model="form.tester" placeholder="请输入测试者" />
        </el-form-item>
        <el-form-item label="测试时间" prop="testTime">
          <el-date-picker clearable v-model="form.testTime" type="date" value-format="timestamp" placeholder="选择测试时间" />
        </el-form-item>
        <el-form-item label="时间" prop="insertTime">
          <el-date-picker clearable v-model="form.insertTime" type="date" value-format="timestamp" placeholder="选择时间" />
        </el-form-item>
        <el-form-item label="光照强度" prop="lightIntensity">
          <el-input v-model="form.lightIntensity" placeholder="请输入光照强度" />
        </el-form-item>
        <el-form-item label="地貌类型" prop="geomorphicType">
          <el-select v-model="form.geomorphicType" placeholder="请选择地貌类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="地形部位" prop="landform">
          <el-input v-model="form.landform" placeholder="请输入地形部位" />
        </el-form-item>
        <el-form-item label="地面坡度" prop="groundSlope">
          <el-input v-model="form.groundSlope" placeholder="请输入地面坡度" />
        </el-form-item>
        <el-form-item label="坡向" prop="slopeDirection">
          <el-input v-model="form.slopeDirection" placeholder="请输入坡向" />
        </el-form-item>
        <el-form-item label="常年有效积温" prop="effectiveTemperature">
          <el-input v-model="form.effectiveTemperature" placeholder="请输入常年有效积温" />
        </el-form-item>
        <el-form-item label="常年无霜期" prop="frostFreePeriod">
          <el-input v-model="form.frostFreePeriod" placeholder="请输入常年无霜期" />
        </el-form-item>
        <el-form-item label="30年最低温度天数" prop="minTemperatureDays">
          <el-input v-model="form.minTemperatureDays" placeholder="请输入30年最低温度天数" />
        </el-form-item>
        <el-form-item label="30年最高温度天数" prop="maxTemperatureDays">
          <el-input v-model="form.maxTemperatureDays" placeholder="请输入30年最高温度天数" />
        </el-form-item>
        <el-form-item label="典型种植制度" prop="typicalCropSystem">
          <el-input v-model="form.typicalCropSystem" placeholder="请输入典型种植制度" />
        </el-form-item>
        <el-form-item label="熟制" prop="maturationSystem">
          <el-input v-model="form.maturationSystem" placeholder="请输入熟制" />
        </el-form-item>
        <el-form-item label="常年产量水平" prop="annualYieldLevel">
          <el-input v-model="form.annualYieldLevel" placeholder="请输入常年产量水平" />
        </el-form-item>
        <el-form-item label="农田基础设施" prop="farmlandInfrastructure">
          <el-input v-model="form.farmlandInfrastructure" placeholder="请输入农田基础设施" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="机构编码" prop="officeCode">
          <el-input v-model="form.officeCode" placeholder="请输入机构编码" />
        </el-form-item>
        <el-form-item label="机构名称" prop="officeName">
          <el-input v-model="form.officeName" placeholder="请输入机构名称" />
        </el-form-item>
        <el-form-item label="公司编码" prop="companyCode">
          <el-input v-model="form.companyCode" placeholder="请输入公司编码" />
        </el-form-item>
        <el-form-item label="公司名称" prop="companyName">
          <el-input v-model="form.companyName" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="审核状态" prop="reviewStatus">
          <el-radio-group v-model="form.reviewStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="审核人" prop="reviewer">
          <el-input v-model="form.reviewer" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审核时间" prop="reviewDate">
          <el-date-picker clearable v-model="form.reviewDate" type="date" value-format="timestamp" placeholder="选择审核时间" />
        </el-form-item>
        <el-form-item label="审核内容">
          <editor v-model="form.reviewContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
        </el-form-item>
        <el-form-item label="海拔" prop="altitude">
          <el-input v-model="form.altitude" placeholder="请输入海拔" />
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
import { createPhenologicalEnv, updatePhenologicalEnv, deletePhenologicalEnv, getPhenologicalEnv, getPhenologicalEnvPage, exportPhenologicalEnvExcel } from "@/api/bases/phenologicalEnv";
import Editor from '@/components/Editor';

export default {
  name: "PhenologicalEnv",
  components: {
    Editor,
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
      // 基地物候环境列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        basesId: null,
        devicesId: null,
        tester: null,
        testTime: [],
        insertTime: [],
        lightIntensity: null,
        geomorphicType: null,
        landform: null,
        groundSlope: null,
        slopeDirection: null,
        effectiveTemperature: null,
        frostFreePeriod: null,
        minTemperatureDays: null,
        maxTemperatureDays: null,
        typicalCropSystem: null,
        maturationSystem: null,
        annualYieldLevel: null,
        farmlandInfrastructure: null,
        remarks: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        corpCode: null,
        corpName: null,
        altitude: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        corpCode: [{ required: true, message: "租户代码不能为空", trigger: "blur" }],
        corpName: [{ required: true, message: "租户名称不能为空", trigger: "blur" }],
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
      getPhenologicalEnvPage(this.queryParams).then(response => {
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
        basesId: undefined,
        devicesId: undefined,
        tester: undefined,
        testTime: undefined,
        insertTime: undefined,
        lightIntensity: undefined,
        geomorphicType: undefined,
        landform: undefined,
        groundSlope: undefined,
        slopeDirection: undefined,
        effectiveTemperature: undefined,
        frostFreePeriod: undefined,
        minTemperatureDays: undefined,
        maxTemperatureDays: undefined,
        typicalCropSystem: undefined,
        maturationSystem: undefined,
        annualYieldLevel: undefined,
        farmlandInfrastructure: undefined,
        remarks: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        corpCode: undefined,
        corpName: undefined,
        altitude: undefined,
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
      this.title = "添加基地物候环境";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPhenologicalEnv(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改基地物候环境";
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
          updatePhenologicalEnv(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPhenologicalEnv(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除基地物候环境编号为"' + id + '"的数据项?').then(function() {
          return deletePhenologicalEnv(id);
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
      this.$modal.confirm('是否确认导出所有基地物候环境数据项?').then(() => {
          this.exportLoading = true;
          return exportPhenologicalEnvExcel(params);
        }).then(response => {
          this.$download.excel(response, '基地物候环境.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
