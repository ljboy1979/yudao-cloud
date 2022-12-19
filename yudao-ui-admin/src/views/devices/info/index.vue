<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="基地" prop="baseId">
        <el-input v-model="queryParams.baseId" placeholder="请输入基地" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块id" prop="tunnelId">
        <el-input v-model="queryParams.tunnelId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设施id" prop="facilitysId">
        <el-input v-model="queryParams.facilitysId" placeholder="请输入设施id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备名称" prop="deviceName">
        <el-input v-model="queryParams.deviceName" placeholder="请输入设备名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备编号" prop="deviceSn">
        <el-input v-model="queryParams.deviceSn" placeholder="请输入设备编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类（环境监测设备,自动控制设备等等）" prop="classify">
        <el-input v-model="queryParams.classify" placeholder="请输入分类（环境监测设备,自动控制设备等等）" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备类型（海康，大华的视频或者新普慧，首扑的传感器）" prop="deviceType">
        <el-select v-model="queryParams.deviceType" placeholder="请选择设备类型（海康，大华的视频或者新普慧，首扑的传感器）" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="设备类型名称" prop="deviceTypeName">
        <el-input v-model="queryParams.deviceTypeName" placeholder="请输入设备类型名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="购买人" prop="buyer">
        <el-input v-model="queryParams.buyer" placeholder="请输入购买人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="安装时间" prop="buyTime">
        <el-date-picker v-model="queryParams.buyTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="厂商" prop="productBy">
        <el-input v-model="queryParams.productBy" placeholder="请输入厂商" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="产品型号" prop="productModel">
        <el-input v-model="queryParams.productModel" placeholder="请输入产品型号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="功率" prop="power">
        <el-input v-model="queryParams.power" placeholder="请输入功率" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="0:工作,1:待命,2:库存" prop="workStatus">
        <el-select v-model="queryParams.workStatus" placeholder="请选择0:工作,1:待命,2:库存" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input v-model="queryParams.longitude" placeholder="请输入经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="纬度" prop="latitude">
        <el-input v-model="queryParams.latitude" placeholder="请输入纬度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频ip" prop="paramDeviceIp">
        <el-input v-model="queryParams.paramDeviceIp" placeholder="请输入视频ip" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频http端口" prop="paramHttpPort">
        <el-input v-model="queryParams.paramHttpPort" placeholder="请输入视频http端口" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频服务端口" prop="paramDevicePort">
        <el-input v-model="queryParams.paramDevicePort" placeholder="请输入视频服务端口" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频rtsp端口" prop="paramRtspPort">
        <el-input v-model="queryParams.paramRtspPort" placeholder="请输入视频rtsp端口" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频用户名" prop="paramDeviceUsername">
        <el-input v-model="queryParams.paramDeviceUsername" placeholder="请输入视频用户名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频密码" prop="paramDevicePassword">
        <el-input v-model="queryParams.paramDevicePassword" placeholder="请输入视频密码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频通道号" prop="paramChanelNum">
        <el-input v-model="queryParams.paramChanelNum" placeholder="请输入视频通道号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="影视云普清" prop="paramYsyUrl">
        <el-input v-model="queryParams.paramYsyUrl" placeholder="请输入影视云普清" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="萤石云高清" prop="paramYsyUrlHd">
        <el-input v-model="queryParams.paramYsyUrlHd" placeholder="请输入萤石云高清" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="视频码流类型" prop="paramStreamType">
        <el-select v-model="queryParams.paramStreamType" placeholder="请选择视频码流类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
      <el-form-item label="是否公开" prop="isopen">
        <el-input v-model="queryParams.isopen" placeholder="请输入是否公开" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="组态王链接" prop="kingViewUrl">
        <el-input v-model="queryParams.kingViewUrl" placeholder="请输入组态王链接" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="0移动设备,1固定设备" prop="isMobile">
        <el-input v-model="queryParams.isMobile" placeholder="请输入0移动设备,1固定设备" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户代码" prop="corpCode">
        <el-input v-model="queryParams.corpCode" placeholder="请输入租户代码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="租户名称" prop="corpName">
        <el-input v-model="queryParams.corpName" placeholder="请输入租户名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="标识时间（接口）" prop="serviceDate">
        <el-date-picker v-model="queryParams.serviceDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="同步状态1已同步" prop="syncStatus">
        <el-select v-model="queryParams.syncStatus" placeholder="请选择同步状态1已同步" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="1.0版本设备需要拉去数据" prop="isbeta">
        <el-input v-model="queryParams.isbeta" placeholder="请输入1.0版本设备需要拉去数据" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="1.0id" prop="oldId">
        <el-input v-model="queryParams.oldId" placeholder="请输入1.0id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="iot_key" prop="iotProductKey">
        <el-input v-model="queryParams.iotProductKey" placeholder="请输入iot_key" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="iot_name" prop="iotDeviceName">
        <el-input v-model="queryParams.iotDeviceName" placeholder="请输入iot_name" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="iot_product_name" prop="iotProductName">
        <el-input v-model="queryParams.iotProductName" placeholder="请输入iot_product_name" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="iot_id" prop="iotIotId">
        <el-input v-model="queryParams.iotIotId" placeholder="请输入iot_id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="警告设备(0-否1-是)" prop="isAlarm">
        <el-input v-model="queryParams.isAlarm" placeholder="请输入警告设备(0-否1-是)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否在线(0-否1-是)" prop="online">
        <el-input v-model="queryParams.online" placeholder="请输入是否在线(0-否1-是)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备型号id" prop="deviceModelId">
        <el-input v-model="queryParams.deviceModelId" placeholder="请输入设备型号id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类" prop="deviceClassify">
        <el-input v-model="queryParams.deviceClassify" placeholder="请输入分类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="厂家code" prop="manufacturer">
        <el-input v-model="queryParams.manufacturer" placeholder="请输入厂家code" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备型号id" prop="deviceModelName">
        <el-input v-model="queryParams.deviceModelName" placeholder="请输入设备型号id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设施id" prop="induFacilityInfoId">
        <el-input v-model="queryParams.induFacilityInfoId" placeholder="请输入设施id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="0阿里1物联网联网" prop="devicesSource">
        <el-input v-model="queryParams.devicesSource" placeholder="请输入0阿里1物联网联网" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="摄像头类型(0阿里1萤石云2直连)" prop="cameraType">
        <el-select v-model="queryParams.cameraType" placeholder="请选择摄像头类型(0阿里1萤石云2直连)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="摄像头id" prop="cameraId">
        <el-input v-model="queryParams.cameraId" placeholder="请输入摄像头id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="称账号" prop="account">
        <el-input v-model="queryParams.account" placeholder="请输入称账号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="称密码" prop="passWord">
        <el-input v-model="queryParams.passWord" placeholder="请输入称密码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="关联用户" prop="personnelInfoId">
        <el-input v-model="queryParams.personnelInfoId" placeholder="请输入关联用户" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备标签" prop="devicesTag">
        <el-input v-model="queryParams.devicesTag" placeholder="请输入设备标签" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否在线(0-否1-是)(新)" prop="devicesOnline">
        <el-input v-model="queryParams.devicesOnline" placeholder="请输入是否在线(0-否1-是)(新)" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['devices:info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['devices:info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="基地" align="center" prop="baseId" />
      <el-table-column label="地块id" align="center" prop="tunnelId" />
      <el-table-column label="设施id" align="center" prop="facilitysId" />
      <el-table-column label="设备名称" align="center" prop="deviceName" />
      <el-table-column label="设备编号" align="center" prop="deviceSn" />
      <el-table-column label="分类（环境监测设备,自动控制设备等等）" align="center" prop="classify" />
      <el-table-column label="设备类型（海康，大华的视频或者新普慧，首扑的传感器）" align="center" prop="deviceType" />
      <el-table-column label="设备类型名称" align="center" prop="deviceTypeName" />
      <el-table-column label="购买人" align="center" prop="buyer" />
      <el-table-column label="安装时间" align="center" prop="buyTime" />
      <el-table-column label="厂商" align="center" prop="productBy" />
      <el-table-column label="产品型号" align="center" prop="productModel" />
      <el-table-column label="功率" align="center" prop="power" />
      <el-table-column label="0:工作,1:待命,2:库存" align="center" prop="workStatus" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="视频ip" align="center" prop="paramDeviceIp" />
      <el-table-column label="视频http端口" align="center" prop="paramHttpPort" />
      <el-table-column label="视频服务端口" align="center" prop="paramDevicePort" />
      <el-table-column label="视频rtsp端口" align="center" prop="paramRtspPort" />
      <el-table-column label="视频用户名" align="center" prop="paramDeviceUsername" />
      <el-table-column label="视频密码" align="center" prop="paramDevicePassword" />
      <el-table-column label="视频通道号" align="center" prop="paramChanelNum" />
      <el-table-column label="影视云普清" align="center" prop="paramYsyUrl" />
      <el-table-column label="萤石云高清" align="center" prop="paramYsyUrlHd" />
      <el-table-column label="视频码流类型" align="center" prop="paramStreamType" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="是否公开" align="center" prop="isopen" />
      <el-table-column label="组态王链接" align="center" prop="kingViewUrl" />
      <el-table-column label="0移动设备,1固定设备" align="center" prop="isMobile" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="标识时间（接口）" align="center" prop="serviceDate" />
      <el-table-column label="同步状态1已同步" align="center" prop="syncStatus" />
      <el-table-column label="1.0版本设备需要拉去数据" align="center" prop="isbeta" />
      <el-table-column label="1.0id" align="center" prop="oldId" />
      <el-table-column label="iot_key" align="center" prop="iotProductKey" />
      <el-table-column label="iot_name" align="center" prop="iotDeviceName" />
      <el-table-column label="iot_product_name" align="center" prop="iotProductName" />
      <el-table-column label="iot_id" align="center" prop="iotIotId" />
      <el-table-column label="警告设备(0-否1-是)" align="center" prop="isAlarm" />
      <el-table-column label="是否在线(0-否1-是)" align="center" prop="online" />
      <el-table-column label="设备型号id" align="center" prop="deviceModelId" />
      <el-table-column label="分类" align="center" prop="deviceClassify" />
      <el-table-column label="厂家code" align="center" prop="manufacturer" />
      <el-table-column label="设备型号id" align="center" prop="deviceModelName" />
      <el-table-column label="设施id" align="center" prop="induFacilityInfoId" />
      <el-table-column label="0阿里1物联网联网" align="center" prop="devicesSource" />
      <el-table-column label="市id" align="center" prop="areaId" />
      <el-table-column label="区id" align="center" prop="ruralId" />
      <el-table-column label="省id" align="center" prop="villagesAreaId" />
      <el-table-column label="市名称" align="center" prop="areaName" />
      <el-table-column label="区名称" align="center" prop="ruralName" />
      <el-table-column label="省名称" align="center" prop="villagesAreaName" />
      <el-table-column label="摄像头类型(0阿里1萤石云2直连)" align="center" prop="cameraType" />
      <el-table-column label="摄像头id" align="center" prop="cameraId" />
      <el-table-column label="称账号" align="center" prop="account" />
      <el-table-column label="称密码" align="center" prop="passWord" />
      <el-table-column label="关联用户" align="center" prop="personnelInfoId" />
      <el-table-column label="设备标签" align="center" prop="devicesTag" />
      <el-table-column label="是否在线(0-否1-是)(新)" align="center" prop="devicesOnline" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['devices:info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['devices:info:delete']">删除</el-button>
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
        <el-form-item label="地块id" prop="tunnelId">
          <el-input v-model="form.tunnelId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="设施id" prop="facilitysId">
          <el-input v-model="form.facilitysId" placeholder="请输入设施id" />
        </el-form-item>
        <el-form-item label="设备名称" prop="deviceName">
          <el-input v-model="form.deviceName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="设备编号" prop="deviceSn">
          <el-input v-model="form.deviceSn" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="分类（环境监测设备,自动控制设备等等）" prop="classify">
          <el-input v-model="form.classify" placeholder="请输入分类（环境监测设备,自动控制设备等等）" />
        </el-form-item>
        <el-form-item label="设备类型（海康，大华的视频或者新普慧，首扑的传感器）" prop="deviceType">
          <el-select v-model="form.deviceType" placeholder="请选择设备类型（海康，大华的视频或者新普慧，首扑的传感器）">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="设备类型名称" prop="deviceTypeName">
          <el-input v-model="form.deviceTypeName" placeholder="请输入设备类型名称" />
        </el-form-item>
        <el-form-item label="购买人" prop="buyer">
          <el-input v-model="form.buyer" placeholder="请输入购买人" />
        </el-form-item>
        <el-form-item label="安装时间" prop="buyTime">
          <el-date-picker clearable v-model="form.buyTime" type="date" value-format="timestamp" placeholder="选择安装时间" />
        </el-form-item>
        <el-form-item label="厂商" prop="productBy">
          <el-input v-model="form.productBy" placeholder="请输入厂商" />
        </el-form-item>
        <el-form-item label="产品型号" prop="productModel">
          <el-input v-model="form.productModel" placeholder="请输入产品型号" />
        </el-form-item>
        <el-form-item label="功率" prop="power">
          <el-input v-model="form.power" placeholder="请输入功率" />
        </el-form-item>
        <el-form-item label="0:工作,1:待命,2:库存" prop="workStatus">
          <el-radio-group v-model="form.workStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="视频ip" prop="paramDeviceIp">
          <el-input v-model="form.paramDeviceIp" placeholder="请输入视频ip" />
        </el-form-item>
        <el-form-item label="视频http端口" prop="paramHttpPort">
          <el-input v-model="form.paramHttpPort" placeholder="请输入视频http端口" />
        </el-form-item>
        <el-form-item label="视频服务端口" prop="paramDevicePort">
          <el-input v-model="form.paramDevicePort" placeholder="请输入视频服务端口" />
        </el-form-item>
        <el-form-item label="视频rtsp端口" prop="paramRtspPort">
          <el-input v-model="form.paramRtspPort" placeholder="请输入视频rtsp端口" />
        </el-form-item>
        <el-form-item label="视频用户名" prop="paramDeviceUsername">
          <el-input v-model="form.paramDeviceUsername" placeholder="请输入视频用户名" />
        </el-form-item>
        <el-form-item label="视频密码" prop="paramDevicePassword">
          <el-input v-model="form.paramDevicePassword" placeholder="请输入视频密码" />
        </el-form-item>
        <el-form-item label="视频通道号" prop="paramChanelNum">
          <el-input v-model="form.paramChanelNum" placeholder="请输入视频通道号" />
        </el-form-item>
        <el-form-item label="影视云普清" prop="paramYsyUrl">
          <el-input v-model="form.paramYsyUrl" placeholder="请输入影视云普清" />
        </el-form-item>
        <el-form-item label="萤石云高清" prop="paramYsyUrlHd">
          <el-input v-model="form.paramYsyUrlHd" placeholder="请输入萤石云高清" />
        </el-form-item>
        <el-form-item label="视频码流类型" prop="paramStreamType">
          <el-select v-model="form.paramStreamType" placeholder="请选择视频码流类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
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
        <el-form-item label="是否公开" prop="isopen">
          <el-input v-model="form.isopen" placeholder="请输入是否公开" />
        </el-form-item>
        <el-form-item label="组态王链接" prop="kingViewUrl">
          <el-input v-model="form.kingViewUrl" placeholder="请输入组态王链接" />
        </el-form-item>
        <el-form-item label="0移动设备,1固定设备" prop="isMobile">
          <el-input v-model="form.isMobile" placeholder="请输入0移动设备,1固定设备" />
        </el-form-item>
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
        </el-form-item>
        <el-form-item label="标识时间（接口）" prop="serviceDate">
          <el-date-picker clearable v-model="form.serviceDate" type="date" value-format="timestamp" placeholder="选择标识时间（接口）" />
        </el-form-item>
        <el-form-item label="同步状态1已同步" prop="syncStatus">
          <el-radio-group v-model="form.syncStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="1.0版本设备需要拉去数据" prop="isbeta">
          <el-input v-model="form.isbeta" placeholder="请输入1.0版本设备需要拉去数据" />
        </el-form-item>
        <el-form-item label="1.0id" prop="oldId">
          <el-input v-model="form.oldId" placeholder="请输入1.0id" />
        </el-form-item>
        <el-form-item label="iot_key" prop="iotProductKey">
          <el-input v-model="form.iotProductKey" placeholder="请输入iot_key" />
        </el-form-item>
        <el-form-item label="iot_name" prop="iotDeviceName">
          <el-input v-model="form.iotDeviceName" placeholder="请输入iot_name" />
        </el-form-item>
        <el-form-item label="iot_product_name" prop="iotProductName">
          <el-input v-model="form.iotProductName" placeholder="请输入iot_product_name" />
        </el-form-item>
        <el-form-item label="iot_id" prop="iotIotId">
          <el-input v-model="form.iotIotId" placeholder="请输入iot_id" />
        </el-form-item>
        <el-form-item label="警告设备(0-否1-是)" prop="isAlarm">
          <el-input v-model="form.isAlarm" placeholder="请输入警告设备(0-否1-是)" />
        </el-form-item>
        <el-form-item label="是否在线(0-否1-是)" prop="online">
          <el-input v-model="form.online" placeholder="请输入是否在线(0-否1-是)" />
        </el-form-item>
        <el-form-item label="设备型号id" prop="deviceModelId">
          <el-input v-model="form.deviceModelId" placeholder="请输入设备型号id" />
        </el-form-item>
        <el-form-item label="分类" prop="deviceClassify">
          <el-input v-model="form.deviceClassify" placeholder="请输入分类" />
        </el-form-item>
        <el-form-item label="厂家code" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入厂家code" />
        </el-form-item>
        <el-form-item label="设备型号id" prop="deviceModelName">
          <el-input v-model="form.deviceModelName" placeholder="请输入设备型号id" />
        </el-form-item>
        <el-form-item label="设施id" prop="induFacilityInfoId">
          <el-input v-model="form.induFacilityInfoId" placeholder="请输入设施id" />
        </el-form-item>
        <el-form-item label="0阿里1物联网联网" prop="devicesSource">
          <el-input v-model="form.devicesSource" placeholder="请输入0阿里1物联网联网" />
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
        <el-form-item label="摄像头类型(0阿里1萤石云2直连)" prop="cameraType">
          <el-select v-model="form.cameraType" placeholder="请选择摄像头类型(0阿里1萤石云2直连)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="摄像头id" prop="cameraId">
          <el-input v-model="form.cameraId" placeholder="请输入摄像头id" />
        </el-form-item>
        <el-form-item label="称账号" prop="account">
          <el-input v-model="form.account" placeholder="请输入称账号" />
        </el-form-item>
        <el-form-item label="称密码" prop="passWord">
          <el-input v-model="form.passWord" placeholder="请输入称密码" />
        </el-form-item>
        <el-form-item label="关联用户" prop="personnelInfoId">
          <el-input v-model="form.personnelInfoId" placeholder="请输入关联用户" />
        </el-form-item>
        <el-form-item label="设备标签" prop="devicesTag">
          <el-input v-model="form.devicesTag" placeholder="请输入设备标签" />
        </el-form-item>
        <el-form-item label="是否在线(0-否1-是)(新)" prop="devicesOnline">
          <el-input v-model="form.devicesOnline" placeholder="请输入是否在线(0-否1-是)(新)" />
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
import { createInfo, updateInfo, deleteInfo, getInfo, getInfoPage, exportInfoExcel } from "@/api/devices/info";
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
      // 设备列表
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
        tunnelId: null,
        facilitysId: null,
        deviceName: null,
        deviceSn: null,
        classify: null,
        deviceType: null,
        deviceTypeName: null,
        buyer: null,
        buyTime: [],
        productBy: null,
        productModel: null,
        power: null,
        workStatus: null,
        longitude: null,
        latitude: null,
        paramDeviceIp: null,
        paramHttpPort: null,
        paramDevicePort: null,
        paramRtspPort: null,
        paramDeviceUsername: null,
        paramDevicePassword: null,
        paramChanelNum: null,
        paramYsyUrl: null,
        paramYsyUrlHd: null,
        paramStreamType: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        remarks: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        isopen: null,
        kingViewUrl: null,
        isMobile: null,
        corpCode: null,
        corpName: null,
        serviceDate: [],
        syncStatus: null,
        isbeta: null,
        oldId: null,
        iotProductKey: null,
        iotDeviceName: null,
        iotProductName: null,
        iotIotId: null,
        isAlarm: null,
        online: null,
        deviceModelId: null,
        deviceClassify: null,
        manufacturer: null,
        deviceModelName: null,
        induFacilityInfoId: null,
        devicesSource: null,
        areaId: null,
        ruralId: null,
        villagesAreaId: null,
        areaName: null,
        ruralName: null,
        villagesAreaName: null,
        cameraType: null,
        cameraId: null,
        account: null,
        passWord: null,
        personnelInfoId: null,
        devicesTag: null,
        devicesOnline: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        paramStreamType: [{ required: true, message: "视频码流类型不能为空", trigger: "change" }],
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
        tunnelId: undefined,
        facilitysId: undefined,
        deviceName: undefined,
        deviceSn: undefined,
        classify: undefined,
        deviceType: undefined,
        deviceTypeName: undefined,
        buyer: undefined,
        buyTime: undefined,
        productBy: undefined,
        productModel: undefined,
        power: undefined,
        workStatus: undefined,
        longitude: undefined,
        latitude: undefined,
        paramDeviceIp: undefined,
        paramHttpPort: undefined,
        paramDevicePort: undefined,
        paramRtspPort: undefined,
        paramDeviceUsername: undefined,
        paramDevicePassword: undefined,
        paramChanelNum: undefined,
        paramYsyUrl: undefined,
        paramYsyUrlHd: undefined,
        paramStreamType: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        remarks: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        isopen: undefined,
        kingViewUrl: undefined,
        isMobile: undefined,
        corpCode: undefined,
        corpName: undefined,
        serviceDate: undefined,
        syncStatus: undefined,
        isbeta: undefined,
        oldId: undefined,
        iotProductKey: undefined,
        iotDeviceName: undefined,
        iotProductName: undefined,
        iotIotId: undefined,
        isAlarm: undefined,
        online: undefined,
        deviceModelId: undefined,
        deviceClassify: undefined,
        manufacturer: undefined,
        deviceModelName: undefined,
        induFacilityInfoId: undefined,
        devicesSource: undefined,
        areaId: undefined,
        ruralId: undefined,
        villagesAreaId: undefined,
        areaName: undefined,
        ruralName: undefined,
        villagesAreaName: undefined,
        cameraType: undefined,
        cameraId: undefined,
        account: undefined,
        passWord: undefined,
        personnelInfoId: undefined,
        devicesTag: undefined,
        devicesOnline: undefined,
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
      this.title = "添加设备";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设备";
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
      this.$modal.confirm('是否确认删除设备编号为"' + id + '"的数据项?').then(function() {
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
      this.$modal.confirm('是否确认导出所有设备数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '设备.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
