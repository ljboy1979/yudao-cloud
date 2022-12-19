<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="行政区域" prop="areaId">
        <el-input v-model="queryParams.areaId" placeholder="请输入行政区域" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="行政区域" prop="areaName">
        <el-input v-model="queryParams.areaName" placeholder="请输入行政区域" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="乡镇id" prop="villagesAreaId">
        <el-input v-model="queryParams.villagesAreaId" placeholder="请输入乡镇id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="乡镇id" prop="villagesAreaName">
        <el-input v-model="queryParams.villagesAreaName" placeholder="请输入乡镇id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="村镇id" prop="ruralId">
        <el-input v-model="queryParams.ruralId" placeholder="请输入村镇id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="村镇id" prop="ruralName">
        <el-input v-model="queryParams.ruralName" placeholder="请输入村镇id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地名称" prop="baseName">
        <el-input v-model="queryParams.baseName" placeholder="请输入基地名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="联系人" prop="contactName">
        <el-input v-model="queryParams.contactName" placeholder="请输入联系人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="联系电话" prop="contactPhone">
        <el-input v-model="queryParams.contactPhone" placeholder="请输入联系电话" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入地址" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="联系邮箱" prop="email">
        <el-input v-model="queryParams.email" placeholder="请输入联系邮箱" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input v-model="queryParams.longitude" placeholder="请输入经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="纬度" prop="latitude">
        <el-input v-model="queryParams.latitude" placeholder="请输入纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="百度坐标系经度" prop="bdLongitude">
        <el-input v-model="queryParams.bdLongitude" placeholder="请输入百度坐标系经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="百度坐标系纬度" prop="bdLatitude">
        <el-input v-model="queryParams.bdLatitude" placeholder="请输入百度坐标系纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="边界范围" prop="coordinateGroup">
        <el-input v-model="queryParams.coordinateGroup" placeholder="请输入边界范围" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="实际可使用的面积" prop="areaNumber">
        <el-input v-model="queryParams.areaNumber" placeholder="请输入实际可使用的面积" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="geometry计算测出的面积" prop="muNumber">
        <el-input v-model="queryParams.muNumber" placeholder="请输入geometry计算测出的面积" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="颜色" prop="viewColor">
        <el-input v-model="queryParams.viewColor" placeholder="请输入颜色" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="google 抓取的图片" prop="staticPicture">
        <el-input v-model="queryParams.staticPicture" placeholder="请输入google 抓取的图片" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="海拔" prop="altitude">
        <el-input v-model="queryParams.altitude" placeholder="请输入海拔" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="常年供应" prop="persistSupply">
        <el-input v-model="queryParams.persistSupply" placeholder="请输入常年供应" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地编号" prop="baseCode">
        <el-input v-model="queryParams.baseCode" placeholder="请输入基地编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用水源" prop="waterSource">
        <el-input v-model="queryParams.waterSource" placeholder="请输入使用水源" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地形" prop="terrain">
        <el-input v-model="queryParams.terrain" placeholder="请输入地形" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="土壤类型" prop="soilType">
        <el-select v-model="queryParams.soilType" placeholder="请选择土壤类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="土壤酸碱度" prop="soilPh">
        <el-input v-model="queryParams.soilPh" placeholder="请输入土壤酸碱度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="气候类型" prop="climateType">
        <el-select v-model="queryParams.climateType" placeholder="请选择气候类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="年降雨量" prop="annualRainfall">
        <el-input v-model="queryParams.annualRainfall" placeholder="请输入年降雨量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="年平均温度" prop="averageTemperature">
        <el-input v-model="queryParams.averageTemperature" placeholder="请输入年平均温度" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="备注信息" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入备注信息" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="gap主键Id" prop="gapId">
        <el-input v-model="queryParams.gapId" placeholder="请输入gap主键Id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="所属企业" prop="affiliatedEnterprises">
        <el-input v-model="queryParams.affiliatedEnterprises" placeholder="请输入所属企业" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类" prop="classify">
        <el-input v-model="queryParams.classify" placeholder="请输入分类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户代码" prop="corpCode">
        <el-input v-model="queryParams.corpCode" placeholder="请输入租户代码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户名称" prop="corpName">
        <el-input v-model="queryParams.corpName" placeholder="请输入租户名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="颜色" prop="borderColor">
        <el-input v-model="queryParams.borderColor" placeholder="请输入颜色" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类" prop="panoramaUrl">
        <el-input v-model="queryParams.panoramaUrl" placeholder="请输入分类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="建设时间" prop="buildDate">
        <el-date-picker v-model="queryParams.buildDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="同步状态 1已同步" prop="syncStatus">
        <el-select v-model="queryParams.syncStatus" placeholder="请选择同步状态 1已同步" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="宣传视频" prop="propagandaVideo">
        <el-input v-model="queryParams.propagandaVideo" placeholder="请输入宣传视频" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="宣传视频" prop="opacity">
        <el-input v-model="queryParams.opacity" placeholder="请输入宣传视频" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="1.0Id" prop="oldId">
        <el-input v-model="queryParams.oldId" placeholder="请输入1.0Id" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['bases:info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['bases:info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="行政区域" align="center" prop="areaId" />
      <el-table-column label="行政区域" align="center" prop="areaName" />
      <el-table-column label="乡镇id" align="center" prop="villagesAreaId" />
      <el-table-column label="乡镇id" align="center" prop="villagesAreaName" />
      <el-table-column label="村镇id" align="center" prop="ruralId" />
      <el-table-column label="村镇id" align="center" prop="ruralName" />
      <el-table-column label="基地名称" align="center" prop="baseName" />
      <el-table-column label="联系人" align="center" prop="contactName" />
      <el-table-column label="联系电话" align="center" prop="contactPhone" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="联系邮箱" align="center" prop="email" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="百度坐标系经度" align="center" prop="bdLongitude" />
      <el-table-column label="百度坐标系纬度" align="center" prop="bdLatitude" />
      <el-table-column label="边界范围" align="center" prop="coordinateGroup" />
      <el-table-column label="实际可使用的面积" align="center" prop="areaNumber" />
      <el-table-column label="geometry计算测出的面积" align="center" prop="muNumber" />
      <el-table-column label="颜色" align="center" prop="viewColor" />
      <el-table-column label="google 抓取的图片" align="center" prop="staticPicture" />
      <el-table-column label="海拔" align="center" prop="altitude" />
      <el-table-column label="常年供应" align="center" prop="persistSupply" />
      <el-table-column label="基地编号" align="center" prop="baseCode" />
      <el-table-column label="使用水源" align="center" prop="waterSource" />
      <el-table-column label="地形" align="center" prop="terrain" />
      <el-table-column label="土壤类型" align="center" prop="soilType" />
      <el-table-column label="土壤酸碱度" align="center" prop="soilPh" />
      <el-table-column label="气候类型" align="center" prop="climateType" />
      <el-table-column label="年降雨量" align="center" prop="annualRainfall" />
      <el-table-column label="年平均温度" align="center" prop="averageTemperature" />
      <el-table-column label="基地介绍" align="center" prop="basesContent" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="gap主键Id" align="center" prop="gapId" />
      <el-table-column label="所属企业" align="center" prop="affiliatedEnterprises" />
      <el-table-column label="分类" align="center" prop="classify" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="颜色" align="center" prop="borderColor" />
      <el-table-column label="分类" align="center" prop="panoramaUrl" />
      <el-table-column label="建设时间" align="center" prop="buildDate" />
      <el-table-column label="同步状态 1已同步" align="center" prop="syncStatus" />
      <el-table-column label="宣传视频" align="center" prop="propagandaVideo" />
      <el-table-column label="宣传视频" align="center" prop="opacity" />
      <el-table-column label="1.0Id" align="center" prop="oldId" />
      <el-table-column label="图片，多张图片用逗号隔开" align="center" prop="basesImage" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['bases:info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['bases:info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="行政区域" prop="areaId">
          <el-input v-model="form.areaId" placeholder="请输入行政区域" />
        </el-form-item>
        <el-form-item label="行政区域" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入行政区域" />
        </el-form-item>
        <el-form-item label="乡镇id" prop="villagesAreaId">
          <el-input v-model="form.villagesAreaId" placeholder="请输入乡镇id" />
        </el-form-item>
        <el-form-item label="乡镇id" prop="villagesAreaName">
          <el-input v-model="form.villagesAreaName" placeholder="请输入乡镇id" />
        </el-form-item>
        <el-form-item label="村镇id" prop="ruralId">
          <el-input v-model="form.ruralId" placeholder="请输入村镇id" />
        </el-form-item>
        <el-form-item label="村镇id" prop="ruralName">
          <el-input v-model="form.ruralName" placeholder="请输入村镇id" />
        </el-form-item>
        <el-form-item label="基地名称" prop="baseName">
          <el-input v-model="form.baseName" placeholder="请输入基地名称" />
        </el-form-item>
        <el-form-item label="联系人" prop="contactName">
          <el-input v-model="form.contactName" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="contactPhone">
          <el-input v-model="form.contactPhone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="联系邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入联系邮箱" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="百度坐标系经度" prop="bdLongitude">
          <el-input v-model="form.bdLongitude" placeholder="请输入百度坐标系经度" />
        </el-form-item>
        <el-form-item label="百度坐标系纬度" prop="bdLatitude">
          <el-input v-model="form.bdLatitude" placeholder="请输入百度坐标系纬度" />
        </el-form-item>
        <el-form-item label="边界范围" prop="coordinateGroup">
          <el-input v-model="form.coordinateGroup" placeholder="请输入边界范围" />
        </el-form-item>
        <el-form-item label="实际可使用的面积" prop="areaNumber">
          <el-input v-model="form.areaNumber" placeholder="请输入实际可使用的面积" />
        </el-form-item>
        <el-form-item label="geometry计算测出的面积" prop="muNumber">
          <el-input v-model="form.muNumber" placeholder="请输入geometry计算测出的面积" />
        </el-form-item>
        <el-form-item label="颜色" prop="viewColor">
          <el-input v-model="form.viewColor" placeholder="请输入颜色" />
        </el-form-item>
        <el-form-item label="google 抓取的图片" prop="staticPicture">
          <el-input v-model="form.staticPicture" placeholder="请输入google 抓取的图片" />
        </el-form-item>
        <el-form-item label="海拔" prop="altitude">
          <el-input v-model="form.altitude" placeholder="请输入海拔" />
        </el-form-item>
        <el-form-item label="常年供应" prop="persistSupply">
          <el-input v-model="form.persistSupply" placeholder="请输入常年供应" />
        </el-form-item>
        <el-form-item label="基地编号" prop="baseCode">
          <el-input v-model="form.baseCode" placeholder="请输入基地编号" />
        </el-form-item>
        <el-form-item label="使用水源" prop="waterSource">
          <el-input v-model="form.waterSource" placeholder="请输入使用水源" />
        </el-form-item>
        <el-form-item label="地形" prop="terrain">
          <el-input v-model="form.terrain" placeholder="请输入地形" />
        </el-form-item>
        <el-form-item label="土壤类型" prop="soilType">
          <el-select v-model="form.soilType" placeholder="请选择土壤类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="土壤酸碱度" prop="soilPh">
          <el-input v-model="form.soilPh" placeholder="请输入土壤酸碱度" />
        </el-form-item>
        <el-form-item label="气候类型" prop="climateType">
          <el-select v-model="form.climateType" placeholder="请选择气候类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="年降雨量" prop="annualRainfall">
          <el-input v-model="form.annualRainfall" placeholder="请输入年降雨量" />
        </el-form-item>
        <el-form-item label="年平均温度" prop="averageTemperature">
          <el-input v-model="form.averageTemperature" placeholder="请输入年平均温度" />
        </el-form-item>
        <el-form-item label="基地介绍">
          <editor v-model="form.basesContent" :min-height="192"/>
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
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
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
        <el-form-item label="gap主键Id" prop="gapId">
          <el-input v-model="form.gapId" placeholder="请输入gap主键Id" />
        </el-form-item>
        <el-form-item label="所属企业" prop="affiliatedEnterprises">
          <el-input v-model="form.affiliatedEnterprises" placeholder="请输入所属企业" />
        </el-form-item>
        <el-form-item label="分类" prop="classify">
          <el-input v-model="form.classify" placeholder="请输入分类" />
        </el-form-item>
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
        </el-form-item>
        <el-form-item label="颜色" prop="borderColor">
          <el-input v-model="form.borderColor" placeholder="请输入颜色" />
        </el-form-item>
        <el-form-item label="分类" prop="panoramaUrl">
          <el-input v-model="form.panoramaUrl" placeholder="请输入分类" />
        </el-form-item>
        <el-form-item label="建设时间" prop="buildDate">
          <el-date-picker clearable v-model="form.buildDate" type="date" value-format="timestamp" placeholder="选择建设时间" />
        </el-form-item>
        <el-form-item label="同步状态 1已同步" prop="syncStatus">
          <el-radio-group v-model="form.syncStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="宣传视频" prop="propagandaVideo">
          <el-input v-model="form.propagandaVideo" placeholder="请输入宣传视频" />
        </el-form-item>
        <el-form-item label="宣传视频" prop="opacity">
          <el-input v-model="form.opacity" placeholder="请输入宣传视频" />
        </el-form-item>
        <el-form-item label="1.0Id" prop="oldId">
          <el-input v-model="form.oldId" placeholder="请输入1.0Id" />
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
import { createInfo, updateInfo, deleteInfo, getInfo, getInfoPage, exportInfoExcel } from "@/api/bases/info";
import Editor from '@/components/Editor';

export default {
  name: "Info",
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
      // 基地信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        areaId: null,
        areaName: null,
        villagesAreaId: null,
        villagesAreaName: null,
        ruralId: null,
        ruralName: null,
        baseName: null,
        contactName: null,
        contactPhone: null,
        address: null,
        email: null,
        longitude: null,
        latitude: null,
        bdLongitude: null,
        bdLatitude: null,
        coordinateGroup: null,
        areaNumber: null,
        muNumber: null,
        viewColor: null,
        staticPicture: null,
        altitude: null,
        persistSupply: null,
        baseCode: null,
        waterSource: null,
        terrain: null,
        soilType: null,
        soilPh: null,
        climateType: null,
        annualRainfall: null,
        averageTemperature: null,
        basesContent: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        remarks: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        gapId: null,
        affiliatedEnterprises: null,
        classify: null,
        corpCode: null,
        corpName: null,
        borderColor: null,
        panoramaUrl: null,
        buildDate: [],
        syncStatus: null,
        propagandaVideo: null,
        opacity: null,
        oldId: null,
        basesImage: null,
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
      getInfoPage(this.queryParams).then(response => {
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
        areaId: undefined,
        areaName: undefined,
        villagesAreaId: undefined,
        villagesAreaName: undefined,
        ruralId: undefined,
        ruralName: undefined,
        baseName: undefined,
        contactName: undefined,
        contactPhone: undefined,
        address: undefined,
        email: undefined,
        longitude: undefined,
        latitude: undefined,
        bdLongitude: undefined,
        bdLatitude: undefined,
        coordinateGroup: undefined,
        areaNumber: undefined,
        muNumber: undefined,
        viewColor: undefined,
        staticPicture: undefined,
        altitude: undefined,
        persistSupply: undefined,
        baseCode: undefined,
        waterSource: undefined,
        terrain: undefined,
        soilType: undefined,
        soilPh: undefined,
        climateType: undefined,
        annualRainfall: undefined,
        averageTemperature: undefined,
        basesContent: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        remarks: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        gapId: undefined,
        affiliatedEnterprises: undefined,
        classify: undefined,
        corpCode: undefined,
        corpName: undefined,
        borderColor: undefined,
        panoramaUrl: undefined,
        buildDate: undefined,
        syncStatus: undefined,
        propagandaVideo: undefined,
        opacity: undefined,
        oldId: undefined,
        basesImage: undefined,
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
      this.title = "添加基地信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改基地信息";
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
          updateInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除基地信息编号为"' + id + '"的数据项?').then(function() {
          return deleteInfo(id);
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
      this.$modal.confirm('是否确认导出所有基地信息数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '基地信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
