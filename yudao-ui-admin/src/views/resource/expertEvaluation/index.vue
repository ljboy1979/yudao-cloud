<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="评估人" prop="evaluationPerson">
        <el-input v-model="queryParams.evaluationPerson" placeholder="请输入评估人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="异常项" prop="exceptionItem">
        <el-input v-model="queryParams.exceptionItem" placeholder="请输入异常项" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="评估时间" prop="evaluationTime">
        <el-date-picker v-model="queryParams.evaluationTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="评估结果" prop="evaluationResult">
        <el-input v-model="queryParams.evaluationResult" placeholder="请输入评估结果" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="关联认养物/租凭物" prop="adoptContentId">
        <el-input v-model="queryParams.adoptContentId" placeholder="请输入关联认养物/租凭物" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="行为" prop="behavior">
        <el-input v-model="queryParams.behavior" placeholder="请输入行为" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="被毛" prop="coat">
        <el-input v-model="queryParams.coat" placeholder="请输入被毛" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="食欲" prop="appetite">
        <el-input v-model="queryParams.appetite" placeholder="请输入食欲" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="牙齿" prop="teeth">
        <el-input v-model="queryParams.teeth" placeholder="请输入牙齿" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="眼睛" prop="eyes">
        <el-input v-model="queryParams.eyes" placeholder="请输入眼睛" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="鼻部" prop="nose">
        <el-input v-model="queryParams.nose" placeholder="请输入鼻部" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="躯干" prop="trunk">
        <el-input v-model="queryParams.trunk" placeholder="请输入躯干" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="排便" prop="defecation">
        <el-input v-model="queryParams.defecation" placeholder="请输入排便" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="体温" prop="temperature">
        <el-input v-model="queryParams.temperature" placeholder="请输入体温" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="心跳" prop="heartbeat">
        <el-input v-model="queryParams.heartbeat" placeholder="请输入心跳" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="呼吸" prop="breathing">
        <el-input v-model="queryParams.breathing" placeholder="请输入呼吸" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="体重" prop="weight">
        <el-input v-model="queryParams.weight" placeholder="请输入体重" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="类型 type=1体检记录；type=0专家评估" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型 type=1体检记录；type=0专家评估" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="排尿" prop="micturition">
        <el-input v-model="queryParams.micturition" placeholder="请输入排尿" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="经营主体id" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体id" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['service:expert-evaluation:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:expert-evaluation:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="评估人" align="center" prop="evaluationPerson" />
      <el-table-column label="异常项" align="center" prop="exceptionItem" />
      <el-table-column label="评估时间" align="center" prop="evaluationTime" />
      <el-table-column label="评估结果" align="center" prop="evaluationResult" />
      <el-table-column label="关联认养物/租凭物" align="center" prop="adoptContentId" />
      <el-table-column label="行为" align="center" prop="behavior" />
      <el-table-column label="被毛" align="center" prop="coat" />
      <el-table-column label="食欲" align="center" prop="appetite" />
      <el-table-column label="牙齿" align="center" prop="teeth" />
      <el-table-column label="眼睛" align="center" prop="eyes" />
      <el-table-column label="鼻部" align="center" prop="nose" />
      <el-table-column label="躯干" align="center" prop="trunk" />
      <el-table-column label="排便" align="center" prop="defecation" />
      <el-table-column label="体温" align="center" prop="temperature" />
      <el-table-column label="心跳" align="center" prop="heartbeat" />
      <el-table-column label="呼吸" align="center" prop="breathing" />
      <el-table-column label="体重" align="center" prop="weight" />
      <el-table-column label="行为异常介绍" align="center" prop="behaviorContent" />
      <el-table-column label="被毛异常介绍" align="center" prop="coatContent" />
      <el-table-column label="食欲异常介绍" align="center" prop="appetiteContent" />
      <el-table-column label="牙齿异常介绍" align="center" prop="teethContent" />
      <el-table-column label="眼睛异常介绍" align="center" prop="eyesContent" />
      <el-table-column label="鼻部异常介绍" align="center" prop="noseContent" />
      <el-table-column label="躯干异常介绍" align="center" prop="trunkContent" />
      <el-table-column label="排便异常介绍" align="center" prop="defecationContent" />
      <el-table-column label="体温异常介绍" align="center" prop="temperatureContent" />
      <el-table-column label="心跳异常介绍" align="center" prop="heartbeatContent" />
      <el-table-column label="呼吸异常介绍" align="center" prop="breathingContent" />
      <el-table-column label="体重异常介绍" align="center" prop="weightContent" />
      <el-table-column label="类型 type=1体检记录；type=0专家评估" align="center" prop="type" />
      <el-table-column label="排尿" align="center" prop="micturition" />
      <el-table-column label="排尿异常介绍" align="center" prop="micturitionContent" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:expert-evaluation:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:expert-evaluation:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="评估人" prop="evaluationPerson">
          <el-input v-model="form.evaluationPerson" placeholder="请输入评估人" />
        </el-form-item>
        <el-form-item label="异常项" prop="exceptionItem">
          <el-input v-model="form.exceptionItem" placeholder="请输入异常项" />
        </el-form-item>
        <el-form-item label="评估时间" prop="evaluationTime">
          <el-date-picker clearable v-model="form.evaluationTime" type="date" value-format="timestamp" placeholder="选择评估时间" />
        </el-form-item>
        <el-form-item label="评估结果" prop="evaluationResult">
          <el-input v-model="form.evaluationResult" placeholder="请输入评估结果" />
        </el-form-item>
        <el-form-item label="关联认养物/租凭物" prop="adoptContentId">
          <el-input v-model="form.adoptContentId" placeholder="请输入关联认养物/租凭物" />
        </el-form-item>
        <el-form-item label="行为" prop="behavior">
          <el-input v-model="form.behavior" placeholder="请输入行为" />
        </el-form-item>
        <el-form-item label="被毛" prop="coat">
          <el-input v-model="form.coat" placeholder="请输入被毛" />
        </el-form-item>
        <el-form-item label="食欲" prop="appetite">
          <el-input v-model="form.appetite" placeholder="请输入食欲" />
        </el-form-item>
        <el-form-item label="牙齿" prop="teeth">
          <el-input v-model="form.teeth" placeholder="请输入牙齿" />
        </el-form-item>
        <el-form-item label="眼睛" prop="eyes">
          <el-input v-model="form.eyes" placeholder="请输入眼睛" />
        </el-form-item>
        <el-form-item label="鼻部" prop="nose">
          <el-input v-model="form.nose" placeholder="请输入鼻部" />
        </el-form-item>
        <el-form-item label="躯干" prop="trunk">
          <el-input v-model="form.trunk" placeholder="请输入躯干" />
        </el-form-item>
        <el-form-item label="排便" prop="defecation">
          <el-input v-model="form.defecation" placeholder="请输入排便" />
        </el-form-item>
        <el-form-item label="体温" prop="temperature">
          <el-input v-model="form.temperature" placeholder="请输入体温" />
        </el-form-item>
        <el-form-item label="心跳" prop="heartbeat">
          <el-input v-model="form.heartbeat" placeholder="请输入心跳" />
        </el-form-item>
        <el-form-item label="呼吸" prop="breathing">
          <el-input v-model="form.breathing" placeholder="请输入呼吸" />
        </el-form-item>
        <el-form-item label="体重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入体重" />
        </el-form-item>
        <el-form-item label="行为异常介绍">
          <editor v-model="form.behaviorContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="被毛异常介绍">
          <editor v-model="form.coatContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="食欲异常介绍">
          <editor v-model="form.appetiteContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="牙齿异常介绍">
          <editor v-model="form.teethContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="眼睛异常介绍">
          <editor v-model="form.eyesContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="鼻部异常介绍">
          <editor v-model="form.noseContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="躯干异常介绍">
          <editor v-model="form.trunkContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="排便异常介绍">
          <editor v-model="form.defecationContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="体温异常介绍">
          <editor v-model="form.temperatureContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="心跳异常介绍">
          <editor v-model="form.heartbeatContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="呼吸异常介绍">
          <editor v-model="form.breathingContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="体重异常介绍">
          <editor v-model="form.weightContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="类型 type=1体检记录；type=0专家评估" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型 type=1体检记录；type=0专家评估">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="排尿" prop="micturition">
          <el-input v-model="form.micturition" placeholder="请输入排尿" />
        </el-form-item>
        <el-form-item label="排尿异常介绍">
          <editor v-model="form.micturitionContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="项目来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入项目来源" />
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
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
import { createExpertEvaluation, updateExpertEvaluation, deleteExpertEvaluation, getExpertEvaluation, getExpertEvaluationPage, exportExpertEvaluationExcel } from "@/api/resource/expertEvaluation";
import Editor from '@/components/Editor';

export default {
  name: "ExpertEvaluation",
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
      // 健康状况列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        evaluationPerson: null,
        exceptionItem: null,
        evaluationTime: [],
        evaluationResult: null,
        adoptContentId: null,
        behavior: null,
        coat: null,
        appetite: null,
        teeth: null,
        eyes: null,
        nose: null,
        trunk: null,
        defecation: null,
        temperature: null,
        heartbeat: null,
        breathing: null,
        weight: null,
        behaviorContent: null,
        coatContent: null,
        appetiteContent: null,
        teethContent: null,
        eyesContent: null,
        noseContent: null,
        trunkContent: null,
        defecationContent: null,
        temperatureContent: null,
        heartbeatContent: null,
        breathingContent: null,
        weightContent: null,
        type: null,
        micturition: null,
        micturitionContent: null,
        status: null,
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
      getExpertEvaluationPage(this.queryParams).then(response => {
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
        evaluationPerson: undefined,
        exceptionItem: undefined,
        evaluationTime: undefined,
        evaluationResult: undefined,
        adoptContentId: undefined,
        behavior: undefined,
        coat: undefined,
        appetite: undefined,
        teeth: undefined,
        eyes: undefined,
        nose: undefined,
        trunk: undefined,
        defecation: undefined,
        temperature: undefined,
        heartbeat: undefined,
        breathing: undefined,
        weight: undefined,
        behaviorContent: undefined,
        coatContent: undefined,
        appetiteContent: undefined,
        teethContent: undefined,
        eyesContent: undefined,
        noseContent: undefined,
        trunkContent: undefined,
        defecationContent: undefined,
        temperatureContent: undefined,
        heartbeatContent: undefined,
        breathingContent: undefined,
        weightContent: undefined,
        type: undefined,
        micturition: undefined,
        micturitionContent: undefined,
        status: undefined,
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
      this.title = "添加健康状况";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getExpertEvaluation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改健康状况";
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
          updateExpertEvaluation(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createExpertEvaluation(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除健康状况编号为"' + id + '"的数据项?').then(function() {
          return deleteExpertEvaluation(id);
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
      this.$modal.confirm('是否确认导出所有健康状况数据项?').then(() => {
          this.exportLoading = true;
          return exportExpertEvaluationExcel(params);
        }).then(response => {
          this.$download.excel(response, '健康状况.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
