<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="区域编码" prop="areaCode">
        <el-input v-model="queryParams.areaCode" placeholder="请输入区域编码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="父级编号" prop="parentCode">
        <el-input v-model="queryParams.parentCode" placeholder="请输入父级编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="所有父级编号" prop="parentCodes">
        <el-input v-model="queryParams.parentCodes" placeholder="请输入所有父级编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="本级排序号（升序）" prop="treeSort">
        <el-input v-model="queryParams.treeSort" placeholder="请输入本级排序号（升序）" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="所有级别排序号" prop="treeSorts">
        <el-input v-model="queryParams.treeSorts" placeholder="请输入所有级别排序号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否最末级" prop="treeLeaf">
        <el-input v-model="queryParams.treeLeaf" placeholder="请输入是否最末级" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="层次级别" prop="treeLevel">
        <el-input v-model="queryParams.treeLevel" placeholder="请输入层次级别" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="全节点名" prop="treeNames">
        <el-input v-model="queryParams.treeNames" placeholder="请输入全节点名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区域名称" prop="areaName">
        <el-input v-model="queryParams.areaName" placeholder="请输入区域名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="区域类型" prop="areaType">
        <el-select v-model="queryParams.areaType" placeholder="请选择区域类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="是否删除" prop="deleted">
        <el-select v-model="queryParams.deleted" placeholder="请选择是否删除" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="创建者" prop="creator">
        <el-input v-model="queryParams.creator" placeholder="请输入创建者" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="更新者" prop="updater">
        <el-input v-model="queryParams.updater" placeholder="请输入更新者" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="更新时间" prop="updateTime">
        <el-date-picker v-model="queryParams.updateTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="备注信息" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入备注信息" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="地区拼音" prop="areaEn">
        <el-input v-model="queryParams.areaEn" placeholder="请输入地区拼音" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="上" prop="top">
        <el-input v-model="queryParams.top" placeholder="请输入上" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="下" prop="bottom">
        <el-input v-model="queryParams.bottom" placeholder="请输入下" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="左" prop="left">
        <el-input v-model="queryParams.left" placeholder="请输入左" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="右" prop="right">
        <el-input v-model="queryParams.right" placeholder="请输入右" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input v-model="queryParams.longitude" placeholder="请输入经度" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="纬度" prop="latitude">
        <el-input v-model="queryParams.latitude" placeholder="请输入纬度" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['system:area:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:area:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="区域编码" align="center" prop="areaCode" />
      <el-table-column label="父级编号" align="center" prop="parentCode" />
      <el-table-column label="所有父级编号" align="center" prop="parentCodes" />
      <el-table-column label="本级排序号（升序）" align="center" prop="treeSort" />
      <el-table-column label="所有级别排序号" align="center" prop="treeSorts" />
      <el-table-column label="是否最末级" align="center" prop="treeLeaf" />
      <el-table-column label="层次级别" align="center" prop="treeLevel" />
      <el-table-column label="全节点名" align="center" prop="treeNames" />
      <el-table-column label="区域名称" align="center" prop="areaName" />
      <el-table-column label="区域类型" align="center" prop="areaType" />
      <el-table-column label="是否删除" align="center" prop="deleted" />
      <el-table-column label="创建者" align="center" prop="creator" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="更新者" align="center" prop="updater" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="地区拼音" align="center" prop="areaEn" />
      <el-table-column label="上" align="center" prop="top" />
      <el-table-column label="下" align="center" prop="bottom" />
      <el-table-column label="左" align="center" prop="left" />
      <el-table-column label="右" align="center" prop="right" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="行政区划id" align="center" prop="id" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:area:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:area:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="父级编号" prop="parentCode">
          <el-input v-model="form.parentCode" placeholder="请输入父级编号" />
        </el-form-item>
        <el-form-item label="所有父级编号" prop="parentCodes">
          <el-input v-model="form.parentCodes" placeholder="请输入所有父级编号" />
        </el-form-item>
        <el-form-item label="本级排序号（升序）" prop="treeSort">
          <el-input v-model="form.treeSort" placeholder="请输入本级排序号（升序）" />
        </el-form-item>
        <el-form-item label="所有级别排序号" prop="treeSorts">
          <el-input v-model="form.treeSorts" placeholder="请输入所有级别排序号" />
        </el-form-item>
        <el-form-item label="是否最末级" prop="treeLeaf">
          <el-input v-model="form.treeLeaf" placeholder="请输入是否最末级" />
        </el-form-item>
        <el-form-item label="层次级别" prop="treeLevel">
          <el-input v-model="form.treeLevel" placeholder="请输入层次级别" />
        </el-form-item>
        <el-form-item label="全节点名" prop="treeNames">
          <el-input v-model="form.treeNames" placeholder="请输入全节点名" />
        </el-form-item>
        <el-form-item label="区域名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入区域名称" />
        </el-form-item>
        <el-form-item label="区域类型" prop="areaType">
          <el-select v-model="form.areaType" placeholder="请选择区域类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="是否删除" prop="deleted">
          <el-radio-group v-model="form.deleted">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="创建者" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入创建者" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker clearable v-model="form.createTime" type="date" value-format="timestamp" placeholder="选择创建时间" />
        </el-form-item>
        <el-form-item label="更新者" prop="updater">
          <el-input v-model="form.updater" placeholder="请输入更新者" />
        </el-form-item>
        <el-form-item label="更新时间" prop="updateTime">
          <el-date-picker clearable v-model="form.updateTime" type="date" value-format="timestamp" placeholder="选择更新时间" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="地区拼音" prop="areaEn">
          <el-input v-model="form.areaEn" placeholder="请输入地区拼音" />
        </el-form-item>
        <el-form-item label="上" prop="top">
          <el-input v-model="form.top" placeholder="请输入上" />
        </el-form-item>
        <el-form-item label="下" prop="bottom">
          <el-input v-model="form.bottom" placeholder="请输入下" />
        </el-form-item>
        <el-form-item label="左" prop="left">
          <el-input v-model="form.left" placeholder="请输入左" />
        </el-form-item>
        <el-form-item label="右" prop="right">
          <el-input v-model="form.right" placeholder="请输入右" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
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
import { createArea, updateArea, deleteArea, getArea, getAreaPage, exportAreaExcel } from "@/api/system/area";

export default {
  name: "Area",
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
      // 行政区划列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        areaCode: null,
        parentCode: null,
        parentCodes: null,
        treeSort: null,
        treeSorts: null,
        treeLeaf: null,
        treeLevel: null,
        treeNames: null,
        areaName: null,
        areaType: null,
        deleted: null,
        creator: null,
        createTime: [],
        updater: null,
        updateTime: [],
        remarks: null,
        areaEn: null,
        top: null,
        bottom: null,
        left: null,
        right: null,
        longitude: null,
        latitude: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        parentCode: [{ required: true, message: "父级编号不能为空", trigger: "blur" }],
        parentCodes: [{ required: true, message: "所有父级编号不能为空", trigger: "blur" }],
        treeSort: [{ required: true, message: "本级排序号（升序）不能为空", trigger: "blur" }],
        treeSorts: [{ required: true, message: "所有级别排序号不能为空", trigger: "blur" }],
        treeLeaf: [{ required: true, message: "是否最末级不能为空", trigger: "blur" }],
        treeLevel: [{ required: true, message: "层次级别不能为空", trigger: "blur" }],
        treeNames: [{ required: true, message: "全节点名不能为空", trigger: "blur" }],
        areaName: [{ required: true, message: "区域名称不能为空", trigger: "blur" }],
        deleted: [{ required: true, message: "是否删除不能为空", trigger: "blur" }],
        createTime: [{ required: true, message: "创建时间不能为空", trigger: "blur" }],
        updateTime: [{ required: true, message: "更新时间不能为空", trigger: "blur" }],
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
      getAreaPage(this.queryParams).then(response => {
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
        areaCode: undefined,
        parentCode: undefined,
        parentCodes: undefined,
        treeSort: undefined,
        treeSorts: undefined,
        treeLeaf: undefined,
        treeLevel: undefined,
        treeNames: undefined,
        areaName: undefined,
        areaType: undefined,
        deleted: undefined,
        creator: undefined,
        createTime: undefined,
        updater: undefined,
        updateTime: undefined,
        remarks: undefined,
        areaEn: undefined,
        top: undefined,
        bottom: undefined,
        left: undefined,
        right: undefined,
        longitude: undefined,
        latitude: undefined,
        id: undefined,
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
      this.title = "添加行政区划";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const areaCode = row.areaCode;
      getArea(areaCode).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改行政区划";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.areaCode != null) {
          updateArea(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createArea(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const areaCode = row.areaCode;
      this.$modal.confirm('是否确认删除行政区划编号为"' + areaCode + '"的数据项?').then(function() {
          return deleteArea(areaCode);
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
      this.$modal.confirm('是否确认导出所有行政区划数据项?').then(() => {
          this.exportLoading = true;
          return exportAreaExcel(params);
        }).then(response => {
          this.$download.excel(response, '行政区划.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
