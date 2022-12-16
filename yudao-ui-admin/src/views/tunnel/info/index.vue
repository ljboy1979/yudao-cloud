<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="基地" prop="baseId">
        <el-input v-model="queryParams.baseId" placeholder="请输入基地" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分区" prop="partitionId">
        <el-input v-model="queryParams.partitionId" placeholder="请输入分区" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="当前种植的json" prop="realPlantJson">
        <el-input v-model="queryParams.realPlantJson" placeholder="请输入当前种植的json" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="原主键id 暂未使用" prop="tunnelInfoId">
        <el-input v-model="queryParams.tunnelInfoId" placeholder="请输入原主键id 暂未使用" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块名称" prop="tunnelName">
        <el-input v-model="queryParams.tunnelName" placeholder="请输入地块名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input v-model="queryParams.longitude" placeholder="请输入经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="维度" prop="latitude">
        <el-input v-model="queryParams.latitude" placeholder="请输入维度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="实际可用面积" prop="areaNumber">
        <el-input v-model="queryParams.areaNumber" placeholder="请输入实际可用面积" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地图画出的面积" prop="muNumber">
        <el-input v-model="queryParams.muNumber" placeholder="请输入地图画出的面积" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="行政区划：乡镇、村、区域" prop="areaId">
        <el-input v-model="queryParams.areaId" placeholder="请输入行政区划：乡镇、村、区域" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="百度经度" prop="bdLongitude">
        <el-input v-model="queryParams.bdLongitude" placeholder="请输入百度经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="百度纬度" prop="bdLatitude">
        <el-input v-model="queryParams.bdLatitude" placeholder="请输入百度纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="边界经纬度" prop="coordinateGroup">
        <el-input v-model="queryParams.coordinateGroup" placeholder="请输入边界经纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="类型" prop="plantEnvTypeId">
        <el-input v-model="queryParams.plantEnvTypeId" placeholder="请输入类型" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="google 抓取的静态图" prop="staticPicture">
        <el-input v-model="queryParams.staticPicture" placeholder="请输入google 抓取的静态图" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块颜色" prop="viewColor">
        <el-input v-model="queryParams.viewColor" placeholder="请输入地块颜色" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="边框颜色" prop="borderColor">
        <el-input v-model="queryParams.borderColor" placeholder="请输入边框颜色" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="透明度 0-100" prop="opacity">
        <el-input v-model="queryParams.opacity" placeholder="请输入透明度 0-100" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="星级" prop="littleStar">
        <el-input v-model="queryParams.littleStar" placeholder="请输入星级" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="小类别(灌溉水田,天然草地等)" prop="littleType">
        <el-select v-model="queryParams.littleType" placeholder="请选择小类别(灌溉水田,天然草地等)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="乡镇ID" prop="villagesId">
        <el-input v-model="queryParams.villagesId" placeholder="请输入乡镇ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="乡镇CODE" prop="villagesCode">
        <el-input v-model="queryParams.villagesCode" placeholder="请输入乡镇CODE" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="村id" prop="ruralId">
        <el-input v-model="queryParams.ruralId" placeholder="请输入村id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="村code" prop="ruralCode">
        <el-input v-model="queryParams.ruralCode" placeholder="请输入村code" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块编号" prop="tunnelCode">
        <el-input v-model="queryParams.tunnelCode" placeholder="请输入地块编号" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="归档状态0,正在使用1,已归档" prop="archiveStatus">
        <el-select v-model="queryParams.archiveStatus" placeholder="请选择归档状态0,正在使用1,已归档" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="归档时间" prop="archiveTime">
        <el-date-picker v-model="queryParams.archiveTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户代码" prop="corpCode">
        <el-input v-model="queryParams.corpCode" placeholder="请输入租户代码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户名称" prop="corpName">
        <el-input v-model="queryParams.corpName" placeholder="请输入租户名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="同步状态 1已同步" prop="syncStatus">
        <el-select v-model="queryParams.syncStatus" placeholder="请选择同步状态 1已同步" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="农户" prop="farmers">
        <el-input v-model="queryParams.farmers" placeholder="请输入农户" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="技术指导员" prop="instructors">
        <el-input v-model="queryParams.instructors" placeholder="请输入技术指导员" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="农户" prop="farmersName">
        <el-input v-model="queryParams.farmersName" placeholder="请输入农户" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="技术指导员" prop="instructorsName">
        <el-input v-model="queryParams.instructorsName" placeholder="请输入技术指导员" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="义田帮手1.0主键" prop="oldId">
        <el-input v-model="queryParams.oldId" placeholder="请输入义田帮手1.0主键" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市名称" prop="areaName">
        <el-input v-model="queryParams.areaName" placeholder="请输入市名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区名称" prop="ruralName">
        <el-input v-model="queryParams.ruralName" placeholder="请输入区名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="省名称" prop="villagesName">
        <el-input v-model="queryParams.villagesName" placeholder="请输入省名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="执行人Id" prop="performId">
        <el-input v-model="queryParams.performId" placeholder="请输入执行人Id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="部门Id" prop="departmentId">
        <el-input v-model="queryParams.departmentId" placeholder="请输入部门Id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="农户id" prop="makersId">
        <el-input v-model="queryParams.makersId" placeholder="请输入农户id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="农户部门id" prop="makersDepartmentId">
        <el-input v-model="queryParams.makersDepartmentId" placeholder="请输入农户部门id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经营主体id" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="面积单位" prop="areaNumUnit">
        <el-input v-model="queryParams.areaNumUnit" placeholder="请输入面积单位" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块位置" prop="areaLocation">
        <el-input v-model="queryParams.areaLocation" placeholder="请输入地块位置" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="多个标签id 逗号隔开" prop="lableIds">
        <el-input v-model="queryParams.lableIds" placeholder="请输入多个标签id 逗号隔开" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块使用状态 0=休耕,1=种植中" prop="plantStatus">
        <el-select v-model="queryParams.plantStatus" placeholder="请选择地块使用状态 0=休耕,1=种植中" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="可播种作物数量" prop="plantAmount">
        <el-input v-model="queryParams.plantAmount" placeholder="请输入可播种作物数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="0认养，1不可认养" prop="adoption">
        <el-input v-model="queryParams.adoption" placeholder="请输入0认养，1不可认养" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="租户集合" prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入租户集合" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['tunnel:info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['tunnel:info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="基地" align="center" prop="baseId" />
      <el-table-column label="分区" align="center" prop="partitionId" />
      <el-table-column label="当前种植的json" align="center" prop="realPlantJson" />
      <el-table-column label="原主键id 暂未使用" align="center" prop="tunnelInfoId" />
      <el-table-column label="地块名称" align="center" prop="tunnelName" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="维度" align="center" prop="latitude" />
      <el-table-column label="实际可用面积" align="center" prop="areaNumber" />
      <el-table-column label="地图画出的面积" align="center" prop="muNumber" />
      <el-table-column label="行政区划：乡镇、村、区域" align="center" prop="areaId" />
      <el-table-column label="百度经度" align="center" prop="bdLongitude" />
      <el-table-column label="百度纬度" align="center" prop="bdLatitude" />
      <el-table-column label="边界经纬度" align="center" prop="coordinateGroup" />
      <el-table-column label="类型" align="center" prop="plantEnvTypeId" />
      <el-table-column label="google 抓取的静态图" align="center" prop="staticPicture" />
      <el-table-column label="地块颜色" align="center" prop="viewColor" />
      <el-table-column label="边框颜色" align="center" prop="borderColor" />
      <el-table-column label="透明度 0-100" align="center" prop="opacity" />
      <el-table-column label="星级" align="center" prop="littleStar" />
      <el-table-column label="小类别(灌溉水田,天然草地等)" align="center" prop="littleType" />
      <el-table-column label="乡镇ID" align="center" prop="villagesId" />
      <el-table-column label="乡镇CODE" align="center" prop="villagesCode" />
      <el-table-column label="村id" align="center" prop="ruralId" />
      <el-table-column label="村code" align="center" prop="ruralCode" />
      <el-table-column label="地块编号" align="center" prop="tunnelCode" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="归档状态0,正在使用1,已归档" align="center" prop="archiveStatus" />
      <el-table-column label="归档时间" align="center" prop="archiveTime" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="同步状态 1已同步" align="center" prop="syncStatus" />
      <el-table-column label="农户" align="center" prop="farmers" />
      <el-table-column label="技术指导员" align="center" prop="instructors" />
      <el-table-column label="农户" align="center" prop="farmersName" />
      <el-table-column label="技术指导员" align="center" prop="instructorsName" />
      <el-table-column label="义田帮手1.0主键" align="center" prop="oldId" />
      <el-table-column label="市名称" align="center" prop="areaName" />
      <el-table-column label="区名称" align="center" prop="ruralName" />
      <el-table-column label="省名称" align="center" prop="villagesName" />
      <el-table-column label="执行人Id" align="center" prop="performId" />
      <el-table-column label="部门Id" align="center" prop="departmentId" />
      <el-table-column label="农户id" align="center" prop="makersId" />
      <el-table-column label="农户部门id" align="center" prop="makersDepartmentId" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="面积单位" align="center" prop="areaNumUnit" />
      <el-table-column label="地块位置" align="center" prop="areaLocation" />
      <el-table-column label="多个标签id 逗号隔开" align="center" prop="lableIds" />
      <el-table-column label="地块使用状态 0=休耕,1=种植中" align="center" prop="plantStatus" />
      <el-table-column label="图片，多张图片用逗号隔开" align="center" prop="tunnelinfoImage" />
      <el-table-column label="可播种作物数量" align="center" prop="plantAmount" />
      <el-table-column label="0认养，1不可认养" align="center" prop="adoption" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['tunnel:info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['tunnel:info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="基地" prop="baseId">
          <el-input v-model="form.baseId" placeholder="请输入基地" />
        </el-form-item>
        <el-form-item label="分区" prop="partitionId">
          <el-input v-model="form.partitionId" placeholder="请输入分区" />
        </el-form-item>
        <el-form-item label="当前种植的json" prop="realPlantJson">
          <el-input v-model="form.realPlantJson" placeholder="请输入当前种植的json" />
        </el-form-item>
        <el-form-item label="原主键id 暂未使用" prop="tunnelInfoId">
          <el-input v-model="form.tunnelInfoId" placeholder="请输入原主键id 暂未使用" />
        </el-form-item>
        <el-form-item label="地块名称" prop="tunnelName">
          <el-input v-model="form.tunnelName" placeholder="请输入地块名称" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="维度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入维度" />
        </el-form-item>
        <el-form-item label="实际可用面积" prop="areaNumber">
          <el-input v-model="form.areaNumber" placeholder="请输入实际可用面积" />
        </el-form-item>
        <el-form-item label="地图画出的面积" prop="muNumber">
          <el-input v-model="form.muNumber" placeholder="请输入地图画出的面积" />
        </el-form-item>
        <el-form-item label="行政区划：乡镇、村、区域" prop="areaId">
          <el-input v-model="form.areaId" placeholder="请输入行政区划：乡镇、村、区域" />
        </el-form-item>
        <el-form-item label="百度经度" prop="bdLongitude">
          <el-input v-model="form.bdLongitude" placeholder="请输入百度经度" />
        </el-form-item>
        <el-form-item label="百度纬度" prop="bdLatitude">
          <el-input v-model="form.bdLatitude" placeholder="请输入百度纬度" />
        </el-form-item>
        <el-form-item label="边界经纬度" prop="coordinateGroup">
          <el-input v-model="form.coordinateGroup" placeholder="请输入边界经纬度" />
        </el-form-item>
        <el-form-item label="类型" prop="plantEnvTypeId">
          <el-input v-model="form.plantEnvTypeId" placeholder="请输入类型" />
        </el-form-item>
        <el-form-item label="google 抓取的静态图" prop="staticPicture">
          <el-input v-model="form.staticPicture" placeholder="请输入google 抓取的静态图" />
        </el-form-item>
        <el-form-item label="地块颜色" prop="viewColor">
          <el-input v-model="form.viewColor" placeholder="请输入地块颜色" />
        </el-form-item>
        <el-form-item label="边框颜色" prop="borderColor">
          <el-input v-model="form.borderColor" placeholder="请输入边框颜色" />
        </el-form-item>
        <el-form-item label="透明度 0-100" prop="opacity">
          <el-input v-model="form.opacity" placeholder="请输入透明度 0-100" />
        </el-form-item>
        <el-form-item label="星级" prop="littleStar">
          <el-input v-model="form.littleStar" placeholder="请输入星级" />
        </el-form-item>
        <el-form-item label="小类别(灌溉水田,天然草地等)" prop="littleType">
          <el-select v-model="form.littleType" placeholder="请选择小类别(灌溉水田,天然草地等)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="乡镇ID" prop="villagesId">
          <el-input v-model="form.villagesId" placeholder="请输入乡镇ID" />
        </el-form-item>
        <el-form-item label="乡镇CODE" prop="villagesCode">
          <el-input v-model="form.villagesCode" placeholder="请输入乡镇CODE" />
        </el-form-item>
        <el-form-item label="村id" prop="ruralId">
          <el-input v-model="form.ruralId" placeholder="请输入村id" />
        </el-form-item>
        <el-form-item label="村code" prop="ruralCode">
          <el-input v-model="form.ruralCode" placeholder="请输入村code" />
        </el-form-item>
        <el-form-item label="地块编号" prop="tunnelCode">
          <el-input v-model="form.tunnelCode" placeholder="请输入地块编号" />
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
        <el-form-item label="归档状态0,正在使用1,已归档" prop="archiveStatus">
          <el-radio-group v-model="form.archiveStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="归档时间" prop="archiveTime">
          <el-date-picker clearable v-model="form.archiveTime" type="date" value-format="timestamp" placeholder="选择归档时间" />
        </el-form-item>
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
        </el-form-item>
        <el-form-item label="同步状态 1已同步" prop="syncStatus">
          <el-radio-group v-model="form.syncStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="农户" prop="farmers">
          <el-input v-model="form.farmers" placeholder="请输入农户" />
        </el-form-item>
        <el-form-item label="技术指导员" prop="instructors">
          <el-input v-model="form.instructors" placeholder="请输入技术指导员" />
        </el-form-item>
        <el-form-item label="农户" prop="farmersName">
          <el-input v-model="form.farmersName" placeholder="请输入农户" />
        </el-form-item>
        <el-form-item label="技术指导员" prop="instructorsName">
          <el-input v-model="form.instructorsName" placeholder="请输入技术指导员" />
        </el-form-item>
        <el-form-item label="义田帮手1.0主键" prop="oldId">
          <el-input v-model="form.oldId" placeholder="请输入义田帮手1.0主键" />
        </el-form-item>
        <el-form-item label="市名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入市名称" />
        </el-form-item>
        <el-form-item label="区名称" prop="ruralName">
          <el-input v-model="form.ruralName" placeholder="请输入区名称" />
        </el-form-item>
        <el-form-item label="省名称" prop="villagesName">
          <el-input v-model="form.villagesName" placeholder="请输入省名称" />
        </el-form-item>
        <el-form-item label="执行人Id" prop="performId">
          <el-input v-model="form.performId" placeholder="请输入执行人Id" />
        </el-form-item>
        <el-form-item label="部门Id" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入部门Id" />
        </el-form-item>
        <el-form-item label="农户id" prop="makersId">
          <el-input v-model="form.makersId" placeholder="请输入农户id" />
        </el-form-item>
        <el-form-item label="农户部门id" prop="makersDepartmentId">
          <el-input v-model="form.makersDepartmentId" placeholder="请输入农户部门id" />
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
        </el-form-item>
        <el-form-item label="面积单位" prop="areaNumUnit">
          <el-input v-model="form.areaNumUnit" placeholder="请输入面积单位" />
        </el-form-item>
        <el-form-item label="地块位置" prop="areaLocation">
          <el-input v-model="form.areaLocation" placeholder="请输入地块位置" />
        </el-form-item>
        <el-form-item label="多个标签id 逗号隔开" prop="lableIds">
          <el-input v-model="form.lableIds" placeholder="请输入多个标签id 逗号隔开" />
        </el-form-item>
        <el-form-item label="地块使用状态 0=休耕,1=种植中" prop="plantStatus">
          <el-radio-group v-model="form.plantStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="可播种作物数量" prop="plantAmount">
          <el-input v-model="form.plantAmount" placeholder="请输入可播种作物数量" />
        </el-form-item>
        <el-form-item label="0认养，1不可认养" prop="adoption">
          <el-input v-model="form.adoption" placeholder="请输入0认养，1不可认养" />
        </el-form-item>
        <el-form-item label="租户集合" prop="source">
          <el-input v-model="form.source" placeholder="请输入租户集合" />
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
import { createInfo, updateInfo, deleteInfo, getInfo, getInfoPage, exportInfoExcel } from "@/api/tunnel/info";
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
      // 地块信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        baseId: null,
        partitionId: null,
        realPlantJson: null,
        tunnelInfoId: null,
        tunnelName: null,
        longitude: null,
        latitude: null,
        areaNumber: null,
        muNumber: null,
        areaId: null,
        bdLongitude: null,
        bdLatitude: null,
        coordinateGroup: null,
        plantEnvTypeId: null,
        staticPicture: null,
        viewColor: null,
        borderColor: null,
        opacity: null,
        littleStar: null,
        littleType: null,
        villagesId: null,
        villagesCode: null,
        ruralId: null,
        ruralCode: null,
        tunnelCode: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        remarks: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        archiveStatus: null,
        archiveTime: [],
        corpCode: null,
        corpName: null,
        syncStatus: null,
        farmers: null,
        instructors: null,
        farmersName: null,
        instructorsName: null,
        oldId: null,
        areaName: null,
        ruralName: null,
        villagesName: null,
        performId: null,
        departmentId: null,
        makersId: null,
        makersDepartmentId: null,
        subjectId: null,
        areaNumUnit: null,
        areaLocation: null,
        lableIds: null,
        plantStatus: null,
        tunnelinfoImage: null,
        plantAmount: null,
        adoption: null,
        createTime: [],
        source: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        corpCode: [{ required: true, message: "租户代码不能为空", trigger: "blur" }],
        corpName: [{ required: true, message: "租户名称不能为空", trigger: "blur" }],
        syncStatus: [{ required: true, message: "同步状态 1已同步不能为空", trigger: "blur" }],
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
        baseId: undefined,
        partitionId: undefined,
        realPlantJson: undefined,
        tunnelInfoId: undefined,
        tunnelName: undefined,
        longitude: undefined,
        latitude: undefined,
        areaNumber: undefined,
        muNumber: undefined,
        areaId: undefined,
        bdLongitude: undefined,
        bdLatitude: undefined,
        coordinateGroup: undefined,
        plantEnvTypeId: undefined,
        staticPicture: undefined,
        viewColor: undefined,
        borderColor: undefined,
        opacity: undefined,
        littleStar: undefined,
        littleType: undefined,
        villagesId: undefined,
        villagesCode: undefined,
        ruralId: undefined,
        ruralCode: undefined,
        tunnelCode: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        remarks: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        archiveStatus: undefined,
        archiveTime: undefined,
        corpCode: undefined,
        corpName: undefined,
        syncStatus: undefined,
        farmers: undefined,
        instructors: undefined,
        farmersName: undefined,
        instructorsName: undefined,
        oldId: undefined,
        areaName: undefined,
        ruralName: undefined,
        villagesName: undefined,
        performId: undefined,
        departmentId: undefined,
        makersId: undefined,
        makersDepartmentId: undefined,
        subjectId: undefined,
        areaNumUnit: undefined,
        areaLocation: undefined,
        lableIds: undefined,
        plantStatus: undefined,
        tunnelinfoImage: undefined,
        plantAmount: undefined,
        adoption: undefined,
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
      this.title = "添加地块信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地块信息";
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
      this.$modal.confirm('是否确认删除地块信息编号为"' + id + '"的数据项?').then(function() {
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
      this.$modal.confirm('是否确认导出所有地块信息数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '地块信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
