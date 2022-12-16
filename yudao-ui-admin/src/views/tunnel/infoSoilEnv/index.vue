<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="地块id" prop="tunnelId">
        <el-input v-model="queryParams.tunnelId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备" prop="equipId">
        <el-input v-model="queryParams.equipId" placeholder="请输入设备" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="平均土壤含水量" prop="avgSoilWater">
        <el-input v-model="queryParams.avgSoilWater" placeholder="请输入平均土壤含水量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="土类" prop="soilType">
        <el-select v-model="queryParams.soilType" placeholder="请选择土类" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="亚类" prop="subType">
        <el-select v-model="queryParams.subType" placeholder="请选择亚类" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="土属" prop="soilGenus">
        <el-input v-model="queryParams.soilGenus" placeholder="请输入土属" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="土种" prop="soilSpecies">
        <el-input v-model="queryParams.soilSpecies" placeholder="请输入土种" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="俗名" prop="commonName">
        <el-input v-model="queryParams.commonName" placeholder="请输入俗名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="成土母质" prop="soilParentMaterial">
        <el-input v-model="queryParams.soilParentMaterial" placeholder="请输入成土母质" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="剖面构型" prop="profilePattern">
        <el-input v-model="queryParams.profilePattern" placeholder="请输入剖面构型" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="质地" prop="texture">
        <el-input v-model="queryParams.texture" placeholder="请输入质地" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="土壤结构" prop="soilStructure">
        <el-input v-model="queryParams.soilStructure" placeholder="请输入土壤结构" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="障碍因素" prop="obstacleFactors">
        <el-input v-model="queryParams.obstacleFactors" placeholder="请输入障碍因素" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="侵蚀程度" prop="erosionDegree">
        <el-input v-model="queryParams.erosionDegree" placeholder="请输入侵蚀程度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="耕层厚度" prop="topsoilDepth">
        <el-input v-model="queryParams.topsoilDepth" placeholder="请输入耕层厚度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="采样深度" prop="samplingDepth">
        <el-input v-model="queryParams.samplingDepth" placeholder="请输入采样深度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="取样层次1" prop="samplingLevelFirst">
        <el-input v-model="queryParams.samplingLevelFirst" placeholder="请输入取样层次1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="质地1" prop="textureFirst">
        <el-input v-model="queryParams.textureFirst" placeholder="请输入质地1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="pH1" prop="phFirst">
        <el-input v-model="queryParams.phFirst" placeholder="请输入pH1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="有机质1" prop="organicMatterFirst">
        <el-input v-model="queryParams.organicMatterFirst" placeholder="请输入有机质1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="碱解氮1" prop="availableNitrogenFirst">
        <el-input v-model="queryParams.availableNitrogenFirst" placeholder="请输入碱解氮1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="有效磷1" prop="effectivePhosphorusFirst">
        <el-input v-model="queryParams.effectivePhosphorusFirst" placeholder="请输入有效磷1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="全钾1" prop="totalPotassiumFirst">
        <el-input v-model="queryParams.totalPotassiumFirst" placeholder="请输入全钾1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="缓效钾1" prop="slowEffectPotassiumFirst">
        <el-input v-model="queryParams.slowEffectPotassiumFirst" placeholder="请输入缓效钾1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="速效钾1" prop="availablePotassiumFirst">
        <el-input v-model="queryParams.availablePotassiumFirst" placeholder="请输入速效钾1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="全氮" prop="totalNitrogen">
        <el-input v-model="queryParams.totalNitrogen" placeholder="请输入全氮" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="项目标识" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入项目标识" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
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
                   v-hasPermi="['tunnel:info-soil-env:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['tunnel:info-soil-env:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="地块id" align="center" prop="tunnelId" />
      <el-table-column label="设备" align="center" prop="equipId" />
      <el-table-column label="测试者" align="center" prop="tester" />
      <el-table-column label="测试时间" align="center" prop="testTime" />
      <el-table-column label="时间" align="center" prop="insertTime" />
      <el-table-column label="平均土壤含水量" align="center" prop="avgSoilWater" />
      <el-table-column label="土类" align="center" prop="soilType" />
      <el-table-column label="亚类" align="center" prop="subType" />
      <el-table-column label="土属" align="center" prop="soilGenus" />
      <el-table-column label="土种" align="center" prop="soilSpecies" />
      <el-table-column label="俗名" align="center" prop="commonName" />
      <el-table-column label="成土母质" align="center" prop="soilParentMaterial" />
      <el-table-column label="剖面构型" align="center" prop="profilePattern" />
      <el-table-column label="质地" align="center" prop="texture" />
      <el-table-column label="土壤结构" align="center" prop="soilStructure" />
      <el-table-column label="障碍因素" align="center" prop="obstacleFactors" />
      <el-table-column label="侵蚀程度" align="center" prop="erosionDegree" />
      <el-table-column label="耕层厚度" align="center" prop="topsoilDepth" />
      <el-table-column label="采样深度" align="center" prop="samplingDepth" />
      <el-table-column label="取样层次1" align="center" prop="samplingLevelFirst" />
      <el-table-column label="质地1" align="center" prop="textureFirst" />
      <el-table-column label="pH1" align="center" prop="phFirst" />
      <el-table-column label="有机质1" align="center" prop="organicMatterFirst" />
      <el-table-column label="碱解氮1" align="center" prop="availableNitrogenFirst" />
      <el-table-column label="有效磷1" align="center" prop="effectivePhosphorusFirst" />
      <el-table-column label="全钾1" align="center" prop="totalPotassiumFirst" />
      <el-table-column label="缓效钾1" align="center" prop="slowEffectPotassiumFirst" />
      <el-table-column label="速效钾1" align="center" prop="availablePotassiumFirst" />
      <el-table-column label="全氮" align="center" prop="totalNitrogen" />
      <el-table-column label="项目标识" align="center" prop="source" />
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
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['tunnel:info-soil-env:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['tunnel:info-soil-env:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="地块id" prop="tunnelId">
          <el-input v-model="form.tunnelId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="设备" prop="equipId">
          <el-input v-model="form.equipId" placeholder="请输入设备" />
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
        <el-form-item label="平均土壤含水量" prop="avgSoilWater">
          <el-input v-model="form.avgSoilWater" placeholder="请输入平均土壤含水量" />
        </el-form-item>
        <el-form-item label="土类" prop="soilType">
          <el-select v-model="form.soilType" placeholder="请选择土类">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="亚类" prop="subType">
          <el-select v-model="form.subType" placeholder="请选择亚类">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="土属" prop="soilGenus">
          <el-input v-model="form.soilGenus" placeholder="请输入土属" />
        </el-form-item>
        <el-form-item label="土种" prop="soilSpecies">
          <el-input v-model="form.soilSpecies" placeholder="请输入土种" />
        </el-form-item>
        <el-form-item label="俗名" prop="commonName">
          <el-input v-model="form.commonName" placeholder="请输入俗名" />
        </el-form-item>
        <el-form-item label="成土母质" prop="soilParentMaterial">
          <el-input v-model="form.soilParentMaterial" placeholder="请输入成土母质" />
        </el-form-item>
        <el-form-item label="剖面构型" prop="profilePattern">
          <el-input v-model="form.profilePattern" placeholder="请输入剖面构型" />
        </el-form-item>
        <el-form-item label="质地" prop="texture">
          <el-input v-model="form.texture" placeholder="请输入质地" />
        </el-form-item>
        <el-form-item label="土壤结构" prop="soilStructure">
          <el-input v-model="form.soilStructure" placeholder="请输入土壤结构" />
        </el-form-item>
        <el-form-item label="障碍因素" prop="obstacleFactors">
          <el-input v-model="form.obstacleFactors" placeholder="请输入障碍因素" />
        </el-form-item>
        <el-form-item label="侵蚀程度" prop="erosionDegree">
          <el-input v-model="form.erosionDegree" placeholder="请输入侵蚀程度" />
        </el-form-item>
        <el-form-item label="耕层厚度" prop="topsoilDepth">
          <el-input v-model="form.topsoilDepth" placeholder="请输入耕层厚度" />
        </el-form-item>
        <el-form-item label="采样深度" prop="samplingDepth">
          <el-input v-model="form.samplingDepth" placeholder="请输入采样深度" />
        </el-form-item>
        <el-form-item label="取样层次1" prop="samplingLevelFirst">
          <el-input v-model="form.samplingLevelFirst" placeholder="请输入取样层次1" />
        </el-form-item>
        <el-form-item label="质地1" prop="textureFirst">
          <el-input v-model="form.textureFirst" placeholder="请输入质地1" />
        </el-form-item>
        <el-form-item label="pH1" prop="phFirst">
          <el-input v-model="form.phFirst" placeholder="请输入pH1" />
        </el-form-item>
        <el-form-item label="有机质1" prop="organicMatterFirst">
          <el-input v-model="form.organicMatterFirst" placeholder="请输入有机质1" />
        </el-form-item>
        <el-form-item label="碱解氮1" prop="availableNitrogenFirst">
          <el-input v-model="form.availableNitrogenFirst" placeholder="请输入碱解氮1" />
        </el-form-item>
        <el-form-item label="有效磷1" prop="effectivePhosphorusFirst">
          <el-input v-model="form.effectivePhosphorusFirst" placeholder="请输入有效磷1" />
        </el-form-item>
        <el-form-item label="全钾1" prop="totalPotassiumFirst">
          <el-input v-model="form.totalPotassiumFirst" placeholder="请输入全钾1" />
        </el-form-item>
        <el-form-item label="缓效钾1" prop="slowEffectPotassiumFirst">
          <el-input v-model="form.slowEffectPotassiumFirst" placeholder="请输入缓效钾1" />
        </el-form-item>
        <el-form-item label="速效钾1" prop="availablePotassiumFirst">
          <el-input v-model="form.availablePotassiumFirst" placeholder="请输入速效钾1" />
        </el-form-item>
        <el-form-item label="全氮" prop="totalNitrogen">
          <el-input v-model="form.totalNitrogen" placeholder="请输入全氮" />
        </el-form-item>
        <el-form-item label="项目标识" prop="source">
          <el-input v-model="form.source" placeholder="请输入项目标识" />
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
import { createInfoSoilEnv, updateInfoSoilEnv, deleteInfoSoilEnv, getInfoSoilEnv, getInfoSoilEnvPage, exportInfoSoilEnvExcel } from "@/api/tunnel/infoSoilEnv";
import Editor from '@/components/Editor';

export default {
  name: "InfoSoilEnv",
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
      // 地块土壤环境列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        tunnelId: null,
        equipId: null,
        tester: null,
        testTime: [],
        insertTime: [],
        avgSoilWater: null,
        soilType: null,
        subType: null,
        soilGenus: null,
        soilSpecies: null,
        commonName: null,
        soilParentMaterial: null,
        profilePattern: null,
        texture: null,
        soilStructure: null,
        obstacleFactors: null,
        erosionDegree: null,
        topsoilDepth: null,
        samplingDepth: null,
        samplingLevelFirst: null,
        textureFirst: null,
        phFirst: null,
        organicMatterFirst: null,
        availableNitrogenFirst: null,
        effectivePhosphorusFirst: null,
        totalPotassiumFirst: null,
        slowEffectPotassiumFirst: null,
        availablePotassiumFirst: null,
        totalNitrogen: null,
        source: null,
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
        createTime: [],
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
      getInfoSoilEnvPage(this.queryParams).then(response => {
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
        tunnelId: undefined,
        equipId: undefined,
        tester: undefined,
        testTime: undefined,
        insertTime: undefined,
        avgSoilWater: undefined,
        soilType: undefined,
        subType: undefined,
        soilGenus: undefined,
        soilSpecies: undefined,
        commonName: undefined,
        soilParentMaterial: undefined,
        profilePattern: undefined,
        texture: undefined,
        soilStructure: undefined,
        obstacleFactors: undefined,
        erosionDegree: undefined,
        topsoilDepth: undefined,
        samplingDepth: undefined,
        samplingLevelFirst: undefined,
        textureFirst: undefined,
        phFirst: undefined,
        organicMatterFirst: undefined,
        availableNitrogenFirst: undefined,
        effectivePhosphorusFirst: undefined,
        totalPotassiumFirst: undefined,
        slowEffectPotassiumFirst: undefined,
        availablePotassiumFirst: undefined,
        totalNitrogen: undefined,
        source: undefined,
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
      this.title = "添加地块土壤环境";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfoSoilEnv(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地块土壤环境";
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
          updateInfoSoilEnv(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createInfoSoilEnv(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除地块土壤环境编号为"' + id + '"的数据项?').then(function() {
          return deleteInfoSoilEnv(id);
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
      this.$modal.confirm('是否确认导出所有地块土壤环境数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoSoilEnvExcel(params);
        }).then(response => {
          this.$download.excel(response, '地块土壤环境.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
