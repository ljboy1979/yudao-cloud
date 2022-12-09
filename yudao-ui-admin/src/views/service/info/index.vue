<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="服务编号" prop="serviceCode">
        <el-input v-model="queryParams.serviceCode" placeholder="请输入服务编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务名称" prop="serviceName">
        <el-input v-model="queryParams.serviceName" placeholder="请输入服务名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务类型" prop="serviceType">
        <el-select v-model="queryParams.serviceType" placeholder="请选择服务类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="服务提供者" prop="serviceProvider">
        <el-input v-model="queryParams.serviceProvider" placeholder="请输入服务提供者" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务缴费者" prop="servicePayer">
        <el-input v-model="queryParams.servicePayer" placeholder="请输入服务缴费者" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始时间" prop="startTime">
        <el-date-picker v-model="queryParams.startTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker v-model="queryParams.endTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="服务状态(0上架中 1已下架)" prop="state">
        <el-input v-model="queryParams.state" placeholder="请输入服务状态(0上架中 1已下架)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="关联设施" prop="induFacilityInfoId">
        <el-input v-model="queryParams.induFacilityInfoId" placeholder="请输入关联设施" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="备注信息" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入备注信息" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块id" prop="tunnelInfoId">
        <el-input v-model="queryParams.tunnelInfoId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="设备的id" prop="devicesId">
        <el-input v-model="queryParams.devicesId" placeholder="请输入设备的id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经营主体的id" prop="induSubjectInfoId">
        <el-input v-model="queryParams.induSubjectInfoId" placeholder="请输入经营主体的id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="载体的id(关联认养物/租凭物)" prop="carrierId">
        <el-input v-model="queryParams.carrierId" placeholder="请输入载体的id(关联认养物/租凭物)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="子表的表名" prop="childrenTableName">
        <el-input v-model="queryParams.childrenTableName" placeholder="请输入子表的表名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务的费用" prop="serviceFee">
        <el-input v-model="queryParams.serviceFee" placeholder="请输入服务的费用" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="所属分类id" prop="categoryId">
        <el-input v-model="queryParams.categoryId" placeholder="请输入所属分类id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="可用时间段" prop="availableTime">
        <el-date-picker v-model="queryParams.availableTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="农事类型" prop="farmType">
        <el-select v-model="queryParams.farmType" placeholder="请选择农事类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="服务简介" prop="introduce">
        <el-input v-model="queryParams.introduce" placeholder="请输入服务简介" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务地址" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入服务地址" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务轮播图" prop="rotationImgs">
        <el-input v-model="queryParams.rotationImgs" placeholder="请输入服务轮播图" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务详情图" prop="detailsImgs">
        <el-input v-model="queryParams.detailsImgs" placeholder="请输入服务详情图" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="最大参与人数" prop="maxAttendPeople">
        <el-input v-model="queryParams.maxAttendPeople" placeholder="请输入最大参与人数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="实际参与人数" prop="attendPeople">
        <el-input v-model="queryParams.attendPeople" placeholder="请输入实际参与人数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地id" prop="basesId">
        <el-input v-model="queryParams.basesId" placeholder="请输入基地id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地名称" prop="basesName">
        <el-input v-model="queryParams.basesName" placeholder="请输入基地名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="种植数量" prop="plantNum">
        <el-input v-model="queryParams.plantNum" placeholder="请输入种植数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="种植品类" prop="plantCropIds">
        <el-input v-model="queryParams.plantCropIds" placeholder="请输入种植品类" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务标签" prop="label">
        <el-input v-model="queryParams.label" placeholder="请输入服务标签" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="收藏数量" prop="collectNum">
        <el-input v-model="queryParams.collectNum" placeholder="请输入收藏数量" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['service:info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="服务编号" align="center" prop="serviceCode" />
      <el-table-column label="服务名称" align="center" prop="serviceName" />
      <el-table-column label="服务类型" align="center" prop="serviceType" />
      <el-table-column label="服务提供者" align="center" prop="serviceProvider" />
      <el-table-column label="服务详情" align="center" prop="content" />
      <el-table-column label="服务缴费者" align="center" prop="servicePayer" />
      <el-table-column label="开始时间" align="center" prop="startTime" />
      <el-table-column label="结束时间" align="center" prop="endTime" />
      <el-table-column label="服务状态(0上架中 1已下架)" align="center" prop="state" />
      <el-table-column label="关联设施" align="center" prop="induFacilityInfoId" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="地块id" align="center" prop="tunnelInfoId" />
      <el-table-column label="设备的id" align="center" prop="devicesId" />
      <el-table-column label="经营主体的id" align="center" prop="induSubjectInfoId" />
      <el-table-column label="载体的id(关联认养物/租凭物)" align="center" prop="carrierId" />
      <el-table-column label="子表的表名" align="center" prop="childrenTableName" />
      <el-table-column label="服务的费用" align="center" prop="serviceFee" />
      <el-table-column label="所属分类id" align="center" prop="categoryId" />
      <el-table-column label="可用时间段" align="center" prop="availableTime" />
      <el-table-column label="农事类型" align="center" prop="farmType" />
      <el-table-column label="服务简介" align="center" prop="introduce" />
      <el-table-column label="服务地址" align="center" prop="address" />
      <el-table-column label="服务轮播图" align="center" prop="rotationImgs" />
      <el-table-column label="服务详情图" align="center" prop="detailsImgs" />
      <el-table-column label="最大参与人数" align="center" prop="maxAttendPeople" />
      <el-table-column label="实际参与人数" align="center" prop="attendPeople" />
      <el-table-column label="基地id" align="center" prop="basesId" />
      <el-table-column label="基地名称" align="center" prop="basesName" />
      <el-table-column label="种植数量" align="center" prop="plantNum" />
      <el-table-column label="种植品类" align="center" prop="plantCropIds" />
      <el-table-column label="服务标签" align="center" prop="label" />
      <el-table-column label="收藏数量" align="center" prop="collectNum" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="服务编号" prop="serviceCode">
          <el-input v-model="form.serviceCode" placeholder="请输入服务编号" />
        </el-form-item>
        <el-form-item label="服务名称" prop="serviceName">
          <el-input v-model="form.serviceName" placeholder="请输入服务名称" />
        </el-form-item>
        <el-form-item label="服务类型" prop="serviceType">
          <el-select v-model="form.serviceType" placeholder="请选择服务类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="服务提供者" prop="serviceProvider">
          <el-input v-model="form.serviceProvider" placeholder="请输入服务提供者" />
        </el-form-item>
        <el-form-item label="服务详情">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="服务缴费者" prop="servicePayer">
          <el-input v-model="form.servicePayer" placeholder="请输入服务缴费者" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable v-model="form.startTime" type="date" value-format="timestamp" placeholder="选择开始时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable v-model="form.endTime" type="date" value-format="timestamp" placeholder="选择结束时间" />
        </el-form-item>
        <el-form-item label="服务状态(0上架中 1已下架)" prop="state">
          <el-input v-model="form.state" placeholder="请输入服务状态(0上架中 1已下架)" />
        </el-form-item>
        <el-form-item label="关联设施" prop="induFacilityInfoId">
          <el-input v-model="form.induFacilityInfoId" placeholder="请输入关联设施" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="地块id" prop="tunnelInfoId">
          <el-input v-model="form.tunnelInfoId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="设备的id" prop="devicesId">
          <el-input v-model="form.devicesId" placeholder="请输入设备的id" />
        </el-form-item>
        <el-form-item label="经营主体的id" prop="induSubjectInfoId">
          <el-input v-model="form.induSubjectInfoId" placeholder="请输入经营主体的id" />
        </el-form-item>
        <el-form-item label="载体的id(关联认养物/租凭物)" prop="carrierId">
          <el-input v-model="form.carrierId" placeholder="请输入载体的id(关联认养物/租凭物)" />
        </el-form-item>
        <el-form-item label="子表的表名" prop="childrenTableName">
          <el-input v-model="form.childrenTableName" placeholder="请输入子表的表名" />
        </el-form-item>
        <el-form-item label="服务的费用" prop="serviceFee">
          <el-input v-model="form.serviceFee" placeholder="请输入服务的费用" />
        </el-form-item>
        <el-form-item label="所属分类id" prop="categoryId">
          <el-input v-model="form.categoryId" placeholder="请输入所属分类id" />
        </el-form-item>
        <el-form-item label="可用时间段" prop="availableTime">
          <el-date-picker clearable v-model="form.availableTime" type="date" value-format="timestamp" placeholder="选择可用时间段" />
        </el-form-item>
        <el-form-item label="农事类型" prop="farmType">
          <el-select v-model="form.farmType" placeholder="请选择农事类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="服务简介" prop="introduce">
          <el-input v-model="form.introduce" placeholder="请输入服务简介" />
        </el-form-item>
        <el-form-item label="服务地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入服务地址" />
        </el-form-item>
        <el-form-item label="服务轮播图" prop="rotationImgs">
          <el-input v-model="form.rotationImgs" placeholder="请输入服务轮播图" />
        </el-form-item>
        <el-form-item label="服务详情图" prop="detailsImgs">
          <el-input v-model="form.detailsImgs" placeholder="请输入服务详情图" />
        </el-form-item>
        <el-form-item label="最大参与人数" prop="maxAttendPeople">
          <el-input v-model="form.maxAttendPeople" placeholder="请输入最大参与人数" />
        </el-form-item>
        <el-form-item label="实际参与人数" prop="attendPeople">
          <el-input v-model="form.attendPeople" placeholder="请输入实际参与人数" />
        </el-form-item>
        <el-form-item label="基地id" prop="basesId">
          <el-input v-model="form.basesId" placeholder="请输入基地id" />
        </el-form-item>
        <el-form-item label="基地名称" prop="basesName">
          <el-input v-model="form.basesName" placeholder="请输入基地名称" />
        </el-form-item>
        <el-form-item label="种植数量" prop="plantNum">
          <el-input v-model="form.plantNum" placeholder="请输入种植数量" />
        </el-form-item>
        <el-form-item label="种植品类" prop="plantCropIds">
          <el-input v-model="form.plantCropIds" placeholder="请输入种植品类" />
        </el-form-item>
        <el-form-item label="服务标签" prop="label">
          <el-input v-model="form.label" placeholder="请输入服务标签" />
        </el-form-item>
        <el-form-item label="收藏数量" prop="collectNum">
          <el-input v-model="form.collectNum" placeholder="请输入收藏数量" />
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
import { createInfo, updateInfo, deleteInfo, getInfo, getInfoPage, exportInfoExcel } from "@/api/service/info";
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
      // 服务列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        serviceCode: null,
        serviceName: null,
        serviceType: null,
        serviceProvider: null,
        content: null,
        servicePayer: null,
        startTime: [],
        endTime: [],
        state: null,
        induFacilityInfoId: null,
        remarks: null,
        tunnelInfoId: null,
        devicesId: null,
        induSubjectInfoId: null,
        carrierId: null,
        childrenTableName: null,
        serviceFee: null,
        categoryId: null,
        availableTime: [],
        farmType: null,
        introduce: null,
        address: null,
        rotationImgs: null,
        detailsImgs: null,
        maxAttendPeople: null,
        attendPeople: null,
        basesId: null,
        basesName: null,
        plantNum: null,
        plantCropIds: null,
        label: null,
        collectNum: null,
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
        serviceCode: undefined,
        serviceName: undefined,
        serviceType: undefined,
        serviceProvider: undefined,
        content: undefined,
        servicePayer: undefined,
        startTime: undefined,
        endTime: undefined,
        state: undefined,
        induFacilityInfoId: undefined,
        remarks: undefined,
        tunnelInfoId: undefined,
        devicesId: undefined,
        induSubjectInfoId: undefined,
        carrierId: undefined,
        childrenTableName: undefined,
        serviceFee: undefined,
        categoryId: undefined,
        availableTime: undefined,
        farmType: undefined,
        introduce: undefined,
        address: undefined,
        rotationImgs: undefined,
        detailsImgs: undefined,
        maxAttendPeople: undefined,
        attendPeople: undefined,
        basesId: undefined,
        basesName: undefined,
        plantNum: undefined,
        plantCropIds: undefined,
        label: undefined,
        collectNum: undefined,
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
      this.title = "添加服务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改服务";
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
      this.$modal.confirm('是否确认删除服务编号为"' + id + '"的数据项?').then(function() {
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
      this.$modal.confirm('是否确认导出所有服务数据项?').then(() => {
          this.exportLoading = true;
          return exportInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '服务.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
