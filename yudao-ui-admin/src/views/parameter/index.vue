<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备id" prop="deviceId">
        <el-input v-model="queryParams.deviceId" placeholder="请输入设备id" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="组态王链接" prop="kingViewUrl">
        <el-input v-model="queryParams.kingViewUrl" placeholder="请输入组态王链接" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['devices:parameter:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['devices:parameter:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="设备id" align="center" prop="deviceId" />
      <el-table-column label="视频ip" align="center" prop="paramDeviceIp" />
      <el-table-column label="视频http端口" align="center" prop="paramHttpPort" />
      <el-table-column label="视频服务端口" align="center" prop="paramDevicePort" />
      <el-table-column label="视频rtsp端口" align="center" prop="paramRtspPort" />
      <el-table-column label="视频用户名" align="center" prop="paramDeviceUsername" />
      <el-table-column label="视频密码" align="center" prop="paramDevicePassword" />
      <el-table-column label="视频通道号" align="center" prop="paramChanelNum" />
      <el-table-column label="组态王链接" align="center" prop="kingViewUrl" />
      <el-table-column label="机构编码" align="center" prop="officeCode" />
      <el-table-column label="机构名称" align="center" prop="officeName" />
      <el-table-column label="公司编码" align="center" prop="companyCode" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="审核状态" align="center" prop="reviewStatus" />
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核时间" align="center" prop="reviewDate" />
      <el-table-column label="审核内容" align="center" prop="reviewContent" />
      <el-table-column label="租户代码" align="center" prop="corpCode" />
      <el-table-column label="租户名称" align="center" prop="corpName" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['devices:parameter:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['devices:parameter:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备id" prop="deviceId">
          <el-input v-model="form.deviceId" placeholder="请输入设备id" />
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
        <el-form-item label="组态王链接" prop="kingViewUrl">
          <el-input v-model="form.kingViewUrl" placeholder="请输入组态王链接" />
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
        <el-form-item label="租户代码" prop="corpCode">
          <el-input v-model="form.corpCode" placeholder="请输入租户代码" />
        </el-form-item>
        <el-form-item label="租户名称" prop="corpName">
          <el-input v-model="form.corpName" placeholder="请输入租户名称" />
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
import { createParameter, updateParameter, deleteParameter, getParameter, getParameterPage, exportParameterExcel } from "@/api/devices/parameter";
import Editor from '@/components/Editor';

export default {
  name: "Parameter",
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
      // 设备表参数列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        deviceId: null,
        paramDeviceIp: null,
        paramHttpPort: null,
        paramDevicePort: null,
        paramRtspPort: null,
        paramDeviceUsername: null,
        paramDevicePassword: null,
        paramChanelNum: null,
        kingViewUrl: null,
        officeCode: null,
        officeName: null,
        companyCode: null,
        companyName: null,
        remarks: null,
        reviewStatus: null,
        reviewer: null,
        reviewDate: [],
        reviewContent: null,
        corpCode: null,
        corpName: null,
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
      getParameterPage(this.queryParams).then(response => {
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
        deviceId: undefined,
        paramDeviceIp: undefined,
        paramHttpPort: undefined,
        paramDevicePort: undefined,
        paramRtspPort: undefined,
        paramDeviceUsername: undefined,
        paramDevicePassword: undefined,
        paramChanelNum: undefined,
        kingViewUrl: undefined,
        officeCode: undefined,
        officeName: undefined,
        companyCode: undefined,
        companyName: undefined,
        remarks: undefined,
        reviewStatus: undefined,
        reviewer: undefined,
        reviewDate: undefined,
        reviewContent: undefined,
        corpCode: undefined,
        corpName: undefined,
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
      this.title = "添加设备表参数";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getParameter(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设备表参数";
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
          updateParameter(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createParameter(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除设备表参数编号为"' + id + '"的数据项?').then(function() {
          return deleteParameter(id);
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
      this.$modal.confirm('是否确认导出所有设备表参数数据项?').then(() => {
          this.exportLoading = true;
          return exportParameterExcel(params);
        }).then(response => {
          this.$download.excel(response, '设备表参数.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
