<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="认养状态" prop="adoptState">
        <el-input v-model="queryParams.adoptState" placeholder="请输入认养状态" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['service:adopt-content:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:adopt-content:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
<!--      <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="编号" align="center" prop="adoptContentCode" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="认养状态" align="center" prop="adoptState" />
      <el-table-column label="关联地块" align="center" prop="tunnelInfoId" />
      <el-table-column label="设施id" align="center" prop="induFacilityInfoId" />
      <el-table-column label="植株/个体的id" align="center" prop="tunnelPlanterId" />
      <el-table-column label="分类id" align="center" prop="categoryId" />
      <el-table-column label="群体id" align="center" prop="groupId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:adopt-content:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:adopt-content:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="关联服务" prop="serviceInfoId">-->
<!--          <el-input v-model="form.serviceInfoId" placeholder="请输入关联服务" />-->
<!--        </el-form-item>-->
        <el-form-item label="编号" prop="adoptContentCode">
          <el-input v-model="form.adoptContentCode" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
<!--        <el-form-item label="省市区" prop="country">-->
<!--          <el-input v-model="form.country" placeholder="请输入省市区" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="详细地址" prop="addRess">-->
<!--          <el-input v-model="form.addRess" placeholder="请输入详细地址" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="经度" prop="longitude">-->
<!--          <el-input v-model="form.longitude" placeholder="请输入经度" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="维度" prop="latitude">-->
<!--          <el-input v-model="form.latitude" placeholder="请输入维度" />-->
<!--        </el-form-item>-->
        <el-form-item label="认养状态" prop="adoptState">
          <el-input v-model="form.adoptState" placeholder="请输入认养状态" />
        </el-form-item>
        <el-form-item label="认养方式" prop="adoptWay">
          <el-input v-model="form.adoptWay" placeholder="请输入认养方式" />
        </el-form-item>
        <el-form-item label="关联设备" prop="deviceId">
          <el-input v-model="form.deviceId" placeholder="请输入关联设备" />
        </el-form-item>
        <el-form-item label="关联地块" prop="tunnelInfoId">
          <el-input v-model="form.tunnelInfoId" placeholder="请输入关联地块" />
        </el-form-item>
        <el-form-item label="设施id" prop="induFacilityInfoId">
          <el-input v-model="form.induFacilityInfoId" placeholder="请输入设施id" />
        </el-form-item>
<!--        <el-form-item label="1 是植株/个体 空是认养" prop="plantType">-->
<!--          <el-select v-model="form.plantType" placeholder="请选择1 是植株/个体 空是认养">-->
<!--            <el-option label="请选择字典生成" value="" />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="种植时间" prop="plantTime">-->
<!--          <el-date-picker clearable v-model="form.plantTime" type="date" value-format="timestamp" placeholder="选择种植时间" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="种植的行号" prop="plantX">-->
<!--          <el-input v-model="form.plantX" placeholder="请输入种植的行号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="种植的列号" prop="plantY">-->
<!--          <el-input v-model="form.plantY" placeholder="请输入种植的列号" />-->
<!--        </el-form-item>-->
        <el-form-item label="介绍" prop="introduce">
          <el-input v-model="form.introduce" placeholder="请输入介绍" />
        </el-form-item>
<!--        <el-form-item label="年龄" prop="age">-->
<!--          <el-input v-model="form.age" placeholder="请输入年龄" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="习性" prop="habit">-->
<!--          <el-input v-model="form.habit" placeholder="请输入习性" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="体重" prop="weight">-->
<!--          <el-input v-model="form.weight" placeholder="请输入体重" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="身高" prop="height">-->
<!--          <el-input v-model="form.height" placeholder="请输入身高" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="性别" prop="gender">-->
<!--          <el-input v-model="form.gender" placeholder="请输入性别" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="血统" prop="ancestry">-->
<!--          <el-input v-model="form.ancestry" placeholder="请输入血统" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="特长" prop="strongPoint">-->
<!--          <el-input v-model="form.strongPoint" placeholder="请输入特长" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="品种" prop="plantCropId">-->
<!--          <el-input v-model="form.plantCropId" placeholder="请输入品种" />-->
<!--        </el-form-item>-->
        <el-form-item label="植株/个体的id" prop="tunnelPlanterId">
          <el-input v-model="form.tunnelPlanterId" placeholder="请输入植株/个体的id" />
        </el-form-item>
<!--        <el-form-item label="关联代理商" prop="agents">-->
<!--          <el-input v-model="form.agents" placeholder="请输入关联代理商" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="分类id" prop="categoryId">-->
<!--          <el-input v-model="form.categoryId" placeholder="请输入分类id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="认养名额总数" prop="adoptSum">-->
<!--          <el-input v-model="form.adoptSum" placeholder="请输入认养名额总数" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="认养数" prop="adoptNumber">-->
<!--          <el-input v-model="form.adoptNumber" placeholder="请输入认养数" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="区域id" prop="partitionsId">-->
<!--          <el-input v-model="form.partitionsId" placeholder="请输入区域id" />-->
<!--        </el-form-item>-->
        <el-form-item label="资源类型字段（1-认养物；2-租赁物）" prop="resourceType">
          <el-input v-model="form.resourceType" placeholder="请输入资源类型" />
        </el-form-item>
        <el-form-item label="群体id" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入群体id" />
        </el-form-item>
<!--        <el-form-item label="状态" prop="status">-->
<!--          <el-radio-group v-model="form.status">-->
<!--            <el-radio label="1">请选择字典生成</el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="项目来源" prop="source">-->
<!--          <el-input v-model="form.source" placeholder="请输入项目来源" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createAdoptContent, updateAdoptContent, deleteAdoptContent, getAdoptContent, getAdoptContentPage, exportAdoptContentExcel } from "@/api/resource/adoptContent";

export default {
  name: "AdoptContent",
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
      // 认养物/租凭物列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        name: null,
        type: null,
        adoptState: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [{ required: true, message: "状态不能为空", trigger: "blur" }],
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
      getAdoptContentPage(this.queryParams).then(response => {
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
        serviceInfoId: undefined,
        adoptContentCode: undefined,
        name: undefined,
        type: undefined,
        country: undefined,
        addRess: undefined,
        longitude: undefined,
        latitude: undefined,
        adoptState: undefined,
        adoptWay: undefined,
        deviceId: undefined,
        tunnelInfoId: undefined,
        induFacilityInfoId: undefined,
        plantType: undefined,
        plantTime: undefined,
        plantX: undefined,
        plantY: undefined,
        introduce: undefined,
        age: undefined,
        habit: undefined,
        weight: undefined,
        height: undefined,
        gender: undefined,
        ancestry: undefined,
        strongPoint: undefined,
        plantCropId: undefined,
        tunnelPlanterId: undefined,
        agents: undefined,
        categoryId: undefined,
        adoptSum: undefined,
        adoptNumber: undefined,
        partitionsId: undefined,
        resourceType: undefined,
        groupId: undefined,
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
      this.title = "添加认养物/租凭物";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getAdoptContent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改认养物/租凭物";
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
          updateAdoptContent(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createAdoptContent(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除认养物/租凭物编号为"' + id + '"的数据项?').then(function() {
          return deleteAdoptContent(id);
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
      this.$modal.confirm('是否确认导出所有认养物/租凭物数据项?').then(() => {
          this.exportLoading = true;
          return exportAdoptContentExcel(params);
        }).then(response => {
          this.$download.excel(response, '认养物/租凭物.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
