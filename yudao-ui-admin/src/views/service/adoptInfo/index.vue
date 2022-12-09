<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="服务id" prop="serviceId">
        <el-input v-model="queryParams.serviceId" placeholder="请输入服务id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地块id" prop="tunnelId">
        <el-input v-model="queryParams.tunnelId" placeholder="请输入地块id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="认养物id" prop="adoptId">
        <el-input v-model="queryParams.adoptId" placeholder="请输入认养物id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input v-model="queryParams.userId" placeholder="请输入用户id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否已认购 0未认购，1已认购" prop="adoptStatus">
        <el-select v-model="queryParams.adoptStatus" placeholder="请选择是否已认购 0未认购，1已认购" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="家庭成员id" prop="familyId">
        <el-input v-model="queryParams.familyId" placeholder="请输入家庭成员id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="可种植作物" prop="plantCropId">
        <el-input v-model="queryParams.plantCropId" placeholder="请输入可种植作物" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="可种植作物数量" prop="plantCropNum">
        <el-input v-model="queryParams.plantCropNum" placeholder="请输入可种植作物数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="基地id" prop="basesId">
        <el-input v-model="queryParams.basesId" placeholder="请输入基地id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区域id" prop="partitionsId">
        <el-input v-model="queryParams.partitionsId" placeholder="请输入区域id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="载体id(关联认养物/租凭物)" prop="carrierId">
        <el-input v-model="queryParams.carrierId" placeholder="请输入载体id(关联认养物/租凭物)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="可认购数量" prop="applyNum">
        <el-input v-model="queryParams.applyNum" placeholder="请输入可认购数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="已认购数量" prop="applySubNum">
        <el-input v-model="queryParams.applySubNum" placeholder="请输入已认购数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="认养类型 0,菜田 1 牧场" prop="adoptType">
        <el-select v-model="queryParams.adoptType" placeholder="请选择认养类型 0,菜田 1 牧场" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
                   v-hasPermi="['service:adopt-info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:adopt-info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="服务id" align="center" prop="serviceId" />
      <el-table-column label="地块id" align="center" prop="tunnelId" />
      <el-table-column label="认养物id" align="center" prop="adoptId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="是否已认购 0未认购，1已认购" align="center" prop="adoptStatus" />
      <el-table-column label="家庭成员id" align="center" prop="familyId" />
      <el-table-column label="可种植作物" align="center" prop="plantCropId" />
      <el-table-column label="可种植作物数量" align="center" prop="plantCropNum" />
      <el-table-column label="基地id" align="center" prop="basesId" />
      <el-table-column label="区域id" align="center" prop="partitionsId" />
      <el-table-column label="载体id(关联认养物/租凭物)" align="center" prop="carrierId" />
      <el-table-column label="可认购数量" align="center" prop="applyNum" />
      <el-table-column label="已认购数量" align="center" prop="applySubNum" />
      <el-table-column label="认养类型 0,菜田 1 牧场" align="center" prop="adoptType" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:adopt-info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:adopt-info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="服务id" prop="serviceId">
          <el-input v-model="form.serviceId" placeholder="请输入服务id" />
        </el-form-item>
        <el-form-item label="地块id" prop="tunnelId">
          <el-input v-model="form.tunnelId" placeholder="请输入地块id" />
        </el-form-item>
        <el-form-item label="认养物id" prop="adoptId">
          <el-input v-model="form.adoptId" placeholder="请输入认养物id" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="是否已认购 0未认购，1已认购" prop="adoptStatus">
          <el-radio-group v-model="form.adoptStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="家庭成员id" prop="familyId">
          <el-input v-model="form.familyId" placeholder="请输入家庭成员id" />
        </el-form-item>
        <el-form-item label="可种植作物" prop="plantCropId">
          <el-input v-model="form.plantCropId" placeholder="请输入可种植作物" />
        </el-form-item>
        <el-form-item label="可种植作物数量" prop="plantCropNum">
          <el-input v-model="form.plantCropNum" placeholder="请输入可种植作物数量" />
        </el-form-item>
        <el-form-item label="基地id" prop="basesId">
          <el-input v-model="form.basesId" placeholder="请输入基地id" />
        </el-form-item>
        <el-form-item label="区域id" prop="partitionsId">
          <el-input v-model="form.partitionsId" placeholder="请输入区域id" />
        </el-form-item>
        <el-form-item label="载体id(关联认养物/租凭物)" prop="carrierId">
          <el-input v-model="form.carrierId" placeholder="请输入载体id(关联认养物/租凭物)" />
        </el-form-item>
        <el-form-item label="可认购数量" prop="applyNum">
          <el-input v-model="form.applyNum" placeholder="请输入可认购数量" />
        </el-form-item>
        <el-form-item label="已认购数量" prop="applySubNum">
          <el-input v-model="form.applySubNum" placeholder="请输入已认购数量" />
        </el-form-item>
        <el-form-item label="认养类型 0,菜田 1 牧场" prop="adoptType">
          <el-select v-model="form.adoptType" placeholder="请选择认养类型 0,菜田 1 牧场">
            <el-option label="请选择字典生成" value="" />
          </el-select>
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
import { createAdoptInfo, updateAdoptInfo, deleteAdoptInfo, getAdoptInfo, getAdoptInfoPage, exportAdoptInfoExcel } from "@/api/service/adoptInfo";

export default {
  name: "AdoptInfo",
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
      // 认养信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        serviceId: null,
        tunnelId: null,
        adoptId: null,
        userId: null,
        adoptStatus: null,
        familyId: null,
        plantCropId: null,
        plantCropNum: null,
        basesId: null,
        partitionsId: null,
        carrierId: null,
        applyNum: null,
        applySubNum: null,
        adoptType: null,
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
      getAdoptInfoPage(this.queryParams).then(response => {
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
        serviceId: undefined,
        tunnelId: undefined,
        adoptId: undefined,
        userId: undefined,
        adoptStatus: undefined,
        familyId: undefined,
        plantCropId: undefined,
        plantCropNum: undefined,
        basesId: undefined,
        partitionsId: undefined,
        carrierId: undefined,
        applyNum: undefined,
        applySubNum: undefined,
        adoptType: undefined,
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
      this.title = "添加认养信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getAdoptInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改认养信息";
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
          updateAdoptInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createAdoptInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除认养信息编号为"' + id + '"的数据项?').then(function() {
          return deleteAdoptInfo(id);
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
      this.$modal.confirm('是否确认导出所有认养信息数据项?').then(() => {
          this.exportLoading = true;
          return exportAdoptInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, '认养信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
