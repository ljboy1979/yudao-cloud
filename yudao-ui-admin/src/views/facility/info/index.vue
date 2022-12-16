<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="基地" prop="baseId">
        <el-input v-model="queryParams.baseId" placeholder="请输入基地" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设施编号" prop="facilityCode">
        <el-input v-model="queryParams.facilityCode" placeholder="请输入设施编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类(生产类,加工类,服务类,管理类)" prop="classify">
        <el-input v-model="queryParams.classify" placeholder="请输入分类(生产类,加工类,服务类,管理类)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="加工车间,饭店等等" prop="facilityType">
        <el-select v-model="queryParams.facilityType" placeholder="请选择加工车间,饭店等等" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="实际可用面积" prop="areaNumber">
        <el-input v-model="queryParams.areaNumber" placeholder="请输入实际可用面积" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地图画出的面积" prop="muNumber">
        <el-input v-model="queryParams.muNumber" placeholder="请输入地图画出的面积" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="边界坐标集" prop="coordinateGroup">
        <el-input v-model="queryParams.coordinateGroup" placeholder="请输入边界坐标集" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="透明度" prop="opacity">
        <el-input v-model="queryParams.opacity" placeholder="请输入透明度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="边界颜色" prop="viewColor">
        <el-input v-model="queryParams.viewColor" placeholder="请输入边界颜色" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="边框颜色" prop="borderColor">
        <el-input v-model="queryParams.borderColor" placeholder="请输入边框颜色" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="品类id" prop="plantId">
        <el-input v-model="queryParams.plantId" placeholder="请输入品类id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品规格" prop="commoditySpec">
        <el-input v-model="queryParams.commoditySpec" placeholder="请输入商品规格" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品数量" prop="commodityNum">
        <el-input v-model="queryParams.commodityNum" placeholder="请输入商品数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="品类名称" prop="plantName">
        <el-input v-model="queryParams.plantName" placeholder="请输入品类名称" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="产业标签" prop="industryLabel">
        <el-input v-model="queryParams.industryLabel" placeholder="请输入产业标签" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入地址" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="类型" prop="secondFacilityType">
        <el-select v-model="queryParams.secondFacilityType" placeholder="请选择类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="储藏条件" prop="storageConditions">
        <el-input v-model="queryParams.storageConditions" placeholder="请输入储藏条件" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户代码" prop="corpCode">
        <el-input v-model="queryParams.corpCode" placeholder="请输入租户代码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户名称" prop="corpName">
        <el-input v-model="queryParams.corpName" placeholder="请输入租户名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="同步状态1已同步" prop="syncStatus">
        <el-select v-model="queryParams.syncStatus" placeholder="请选择同步状态1已同步" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="地块id" prop="tunnelInfoId">
        <el-input v-model="queryParams.tunnelInfoId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市id" prop="areaId">
        <el-input v-model="queryParams.areaId" placeholder="请输入市id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区id" prop="ruralId">
        <el-input v-model="queryParams.ruralId" placeholder="请输入区id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="省id" prop="villagesAreaId">
        <el-input v-model="queryParams.villagesAreaId" placeholder="请输入省id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市名称" prop="areaName">
        <el-input v-model="queryParams.areaName" placeholder="请输入市名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区名称" prop="ruralName">
        <el-input v-model="queryParams.ruralName" placeholder="请输入区名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="省名称" prop="villagesAreaName">
        <el-input v-model="queryParams.villagesAreaName" placeholder="请输入省名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="所属区域" prop="regionalManagementId">
        <el-input v-model="queryParams.regionalManagementId" placeholder="请输入所属区域" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设施状态(已出租0未出租1停用2)" prop="induFacilityInfoState">
        <el-input v-model="queryParams.induFacilityInfoState" placeholder="请输入设施状态(已出租0未出租1停用2)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="到期时间" prop="expirationTime">
        <el-date-picker v-model="queryParams.expirationTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="实际可用面积单位 关联字典" prop="areaNumberUnit">
        <el-input v-model="queryParams.areaNumberUnit" placeholder="请输入实际可用面积单位 关联字典" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="楼栋/单元" prop="building">
        <el-input v-model="queryParams.building" placeholder="请输入楼栋/单元" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="楼层 关联字典" prop="floor">
        <el-input v-model="queryParams.floor" placeholder="请输入楼层 关联字典" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="门牌号" prop="houseNumber">
        <el-input v-model="queryParams.houseNumber" placeholder="请输入门牌号" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['facility:info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['facility:info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="基地" align="center" prop="baseId" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="设施编号" align="center" prop="facilityCode" />
      <el-table-column label="分类(生产类,加工类,服务类,管理类)" align="center" prop="classify" />
      <el-table-column label="加工车间,饭店等等" align="center" prop="facilityType" />
      <el-table-column label="实际可用面积" align="center" prop="areaNumber" />
      <el-table-column label="地图画出的面积" align="center" prop="muNumber" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="百度坐标系经度" align="center" prop="bdLongitude" />
      <el-table-column label="百度坐标系纬度" align="center" prop="bdLatitude" />
      <el-table-column label="边界坐标集" align="center" prop="coordinateGroup" />
      <el-table-column label="透明度" align="center" prop="opacity" />
      <el-table-column label="边界颜色" align="center" prop="viewColor" />
      <el-table-column label="边框颜色" align="center" prop="borderColor" />
      <el-table-column label="品类id" align="center" prop="plantId" />
      <el-table-column label="商品规格" align="center" prop="commoditySpec" />
      <el-table-column label="商品数量" align="center" prop="commodityNum" />
      <el-table-column label="品类名称" align="center" prop="plantName" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="产业标签" align="center" prop="industryLabel" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="类型" align="center" prop="secondFacilityType" />
      <el-table-column label="储藏条件" align="center" prop="storageConditions" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="同步状态1已同步" align="center" prop="syncStatus" />
      <el-table-column label="地块id" align="center" prop="tunnelInfoId" />
      <el-table-column label="市id" align="center" prop="areaId" />
      <el-table-column label="区id" align="center" prop="ruralId" />
      <el-table-column label="省id" align="center" prop="villagesAreaId" />
      <el-table-column label="市名称" align="center" prop="areaName" />
      <el-table-column label="区名称" align="center" prop="ruralName" />
      <el-table-column label="省名称" align="center" prop="villagesAreaName" />
      <el-table-column label="所属区域" align="center" prop="regionalManagementId" />
      <el-table-column label="设施状态(已出租0未出租1停用2)" align="center" prop="induFacilityInfoState" />
      <el-table-column label="到期时间" align="center" prop="expirationTime" />
      <el-table-column label="图片，多个图片用逗号隔开" align="center" prop="indufacilityinfoImage" />
      <el-table-column label="实际可用面积单位 关联字典" align="center" prop="areaNumberUnit" />
      <el-table-column label="楼栋/单元" align="center" prop="building" />
      <el-table-column label="楼层 关联字典" align="center" prop="floor" />
      <el-table-column label="门牌号" align="center" prop="houseNumber" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['facility:info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['facility:info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="基地" prop="baseId">
          <el-input v-model="form.baseId" placeholder="请输入基地" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="设施编号" prop="facilityCode">
          <el-input v-model="form.facilityCode" placeholder="请输入设施编号" />
        </el-form-item>
        <el-form-item label="分类(生产类,加工类,服务类,管理类)" prop="classify">
          <el-input v-model="form.classify" placeholder="请输入分类(生产类,加工类,服务类,管理类)" />
        </el-form-item>
        <el-form-item label="加工车间,饭店等等" prop="facilityType">
          <el-select v-model="form.facilityType" placeholder="请选择加工车间,饭店等等">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="实际可用面积" prop="areaNumber">
          <el-input v-model="form.areaNumber" placeholder="请输入实际可用面积" />
        </el-form-item>
        <el-form-item label="地图画出的面积" prop="muNumber">
          <el-input v-model="form.muNumber" placeholder="请输入地图画出的面积" />
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
        <el-form-item label="边界坐标集" prop="coordinateGroup">
          <el-input v-model="form.coordinateGroup" placeholder="请输入边界坐标集" />
        </el-form-item>
        <el-form-item label="透明度" prop="opacity">
          <el-input v-model="form.opacity" placeholder="请输入透明度" />
        </el-form-item>
        <el-form-item label="边界颜色" prop="viewColor">
          <el-input v-model="form.viewColor" placeholder="请输入边界颜色" />
        </el-form-item>
        <el-form-item label="边框颜色" prop="borderColor">
          <el-input v-model="form.borderColor" placeholder="请输入边框颜色" />
        </el-form-item>
        <el-form-item label="品类id" prop="plantId">
          <el-input v-model="form.plantId" placeholder="请输入品类id" />
        </el-form-item>
        <el-form-item label="商品规格" prop="commoditySpec">
          <el-input v-model="form.commoditySpec" placeholder="请输入商品规格" />
        </el-form-item>
        <el-form-item label="商品数量" prop="commodityNum">
          <el-input v-model="form.commodityNum" placeholder="请输入商品数量" />
        </el-form-item>
        <el-form-item label="品类名称" prop="plantName">
          <el-input v-model="form.plantName" placeholder="请输入品类名称" />
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
        <el-form-item label="产业标签" prop="industryLabel">
          <el-input v-model="form.industryLabel" placeholder="请输入产业标签" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="类型" prop="secondFacilityType">
          <el-select v-model="form.secondFacilityType" placeholder="请选择类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="储藏条件" prop="storageConditions">
          <el-input v-model="form.storageConditions" placeholder="请输入储藏条件" />
        </el-form-item>
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
        </el-form-item>
        <el-form-item label="同步状态1已同步" prop="syncStatus">
          <el-radio-group v-model="form.syncStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="地块id" prop="tunnelInfoId">
          <el-input v-model="form.tunnelInfoId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="市id" prop="areaId">
          <el-input v-model="form.areaId" placeholder="请输入市id" />
        </el-form-item>
        <el-form-item label="区id" prop="ruralId">
          <el-input v-model="form.ruralId" placeholder="请输入区id" />
        </el-form-item>
        <el-form-item label="省id" prop="villagesAreaId">
          <el-input v-model="form.villagesAreaId" placeholder="请输入省id" />
        </el-form-item>
        <el-form-item label="市名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入市名称" />
        </el-form-item>
        <el-form-item label="区名称" prop="ruralName">
          <el-input v-model="form.ruralName" placeholder="请输入区名称" />
        </el-form-item>
        <el-form-item label="省名称" prop="villagesAreaName">
          <el-input v-model="form.villagesAreaName" placeholder="请输入省名称" />
        </el-form-item>
        <el-form-item label="所属区域" prop="regionalManagementId">
          <el-input v-model="form.regionalManagementId" placeholder="请输入所属区域" />
        </el-form-item>
        <el-form-item label="设施状态(已出租0未出租1停用2)" prop="induFacilityInfoState">
          <el-input v-model="form.induFacilityInfoState" placeholder="请输入设施状态(已出租0未出租1停用2)" />
        </el-form-item>
        <el-form-item label="到期时间" prop="expirationTime">
          <el-date-picker clearable v-model="form.expirationTime" type="date" value-format="timestamp" placeholder="选择到期时间" />
        </el-form-item>
        <el-form-item label="实际可用面积单位 关联字典" prop="areaNumberUnit">
          <el-input v-model="form.areaNumberUnit" placeholder="请输入实际可用面积单位 关联字典" />
        </el-form-item>
        <el-form-item label="楼栋/单元" prop="building">
          <el-input v-model="form.building" placeholder="请输入楼栋/单元" />
        </el-form-item>
        <el-form-item label="楼层 关联字典" prop="floor">
          <el-input v-model="form.floor" placeholder="请输入楼层 关联字典" />
        </el-form-item>
        <el-form-item label="门牌号" prop="houseNumber">
          <el-input v-model="form.houseNumber" placeholder="请输入门牌号" />
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
import { createInfo, updateInfo, deleteInfo, getInfo, getInfoPage, exportInfoExcel } from "@/api/facility/info";
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
      // 设施列表
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
        name: null,
        facilityCode: null,
        classify: null,
        facilityType: null,
        areaNumber: null,
        muNumber: null,
        longitude: null,
        latitude: null,
        bdLongitude: null,
        bdLatitude: null,
        coordinateGroup: null,
        opacity: null,
        viewColor: null,
        borderColor: null,
        plantId: null,
        commoditySpec: null,
        commodityNum: null,
        plantName: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        remarks: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        industryLabel: null,
        address: null,
        secondFacilityType: null,
        storageConditions: null,
        corpCode: null,
        corpName: null,
        syncStatus: null,
        tunnelInfoId: null,
        areaId: null,
        ruralId: null,
        villagesAreaId: null,
        areaName: null,
        ruralName: null,
        villagesAreaName: null,
        regionalManagementId: null,
        induFacilityInfoState: null,
        expirationTime: [],
        indufacilityinfoImage: null,
        areaNumberUnit: null,
        building: null,
        floor: null,
        houseNumber: null,
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
        syncStatus: [{ required: true, message: "同步状态1已同步不能为空", trigger: "blur" }],
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
        name: undefined,
        facilityCode: undefined,
        classify: undefined,
        facilityType: undefined,
        areaNumber: undefined,
        muNumber: undefined,
        longitude: undefined,
        latitude: undefined,
        bdLongitude: undefined,
        bdLatitude: undefined,
        coordinateGroup: undefined,
        opacity: undefined,
        viewColor: undefined,
        borderColor: undefined,
        plantId: undefined,
        commoditySpec: undefined,
        commodityNum: undefined,
        plantName: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        remarks: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        industryLabel: undefined,
        address: undefined,
        secondFacilityType: undefined,
        storageConditions: undefined,
        corpCode: undefined,
        corpName: undefined,
        syncStatus: undefined,
        tunnelInfoId: undefined,
        areaId: undefined,
        ruralId: undefined,
        villagesAreaId: undefined,
        areaName: undefined,
        ruralName: undefined,
        villagesAreaName: undefined,
        regionalManagementId: undefined,
        induFacilityInfoState: undefined,
        expirationTime: undefined,
        indufacilityinfoImage: undefined,
        areaNumberUnit: undefined,
        building: undefined,
        floor: undefined,
        houseNumber: undefined,
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
      this.title = "添加设施";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设施";
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
      this.$modal.confirm('是否确认删除设施编号为"' + id + '"的数据项?').then(function() {
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
      this.$modal.confirm('是否确认导出所有设施数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '设施.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
