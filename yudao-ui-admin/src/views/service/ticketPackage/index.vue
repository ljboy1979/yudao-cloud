<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="套票名称" prop="packageName">
        <el-input v-model="queryParams.packageName" placeholder="请输入套票名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="套票种类" prop="packageType">
        <el-select v-model="queryParams.packageType" placeholder="请选择套票种类" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="购买人" prop="purchaser">
        <el-input v-model="queryParams.purchaser" placeholder="请输入购买人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="服务id" prop="carrierId">
        <el-input v-model="queryParams.carrierId" placeholder="请输入服务id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用次数" prop="number">
        <el-input v-model="queryParams.number" placeholder="请输入使用次数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="套票金额" prop="packageMoney">
        <el-input v-model="queryParams.packageMoney" placeholder="请输入套票金额" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用期限" prop="serviceLife">
        <el-input v-model="queryParams.serviceLife" placeholder="请输入使用期限" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="授权人" prop="certigier">
        <el-input v-model="queryParams.certigier" placeholder="请输入授权人" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="套票状态(未开通/正常使用/过期/使用完毕)" prop="packageStatus">
        <el-select v-model="queryParams.packageStatus" placeholder="请选择套票状态(未开通/正常使用/过期/使用完毕)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input v-model="queryParams.remarks" placeholder="请输入备注" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="封面" prop="cover">
        <el-input v-model="queryParams.cover" placeholder="请输入封面" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用规则" prop="regulation">
        <el-input v-model="queryParams.regulation" placeholder="请输入使用规则" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label=" 使用期限说明" prop="serviceLifeType">
        <el-select v-model="queryParams.serviceLifeType" placeholder="请选择 使用期限说明" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="套票规则" prop="packageRule">
        <el-input v-model="queryParams.packageRule" placeholder="请输入套票规则" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始日期" prop="startDate">
        <el-date-picker v-model="queryParams.startDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="结束日期" prop="endDate">
        <el-date-picker v-model="queryParams.endDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="是否上架 0:已上架，1:未上架" prop="ticketStatus">
        <el-select v-model="queryParams.ticketStatus" placeholder="请选择是否上架 0:已上架，1:未上架" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="使用年限周期" prop="timeNum">
        <el-input v-model="queryParams.timeNum" placeholder="请输入使用年限周期" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用年限类型 0固定1不固定" prop="timeType">
        <el-select v-model="queryParams.timeType" placeholder="请选择使用年限类型 0固定1不固定" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="使用年限频次 0年1月" prop="timeLimitMode">
        <el-input v-model="queryParams.timeLimitMode" placeholder="请输入使用年限频次 0年1月" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="套票场景0活动1商品" prop="ticketType">
        <el-select v-model="queryParams.ticketType" placeholder="请选择套票场景0活动1商品" clearable size="small">
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
                   v-hasPermi="['service:ticket-package:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['service:ticket-package:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="套票编号" align="center" prop="id" />
      <el-table-column label="套票名称" align="center" prop="packageName" />
      <el-table-column label="套票种类" align="center" prop="packageType" />
      <el-table-column label="购买人" align="center" prop="purchaser" />
      <el-table-column label="服务id" align="center" prop="carrierId" />
      <el-table-column label="使用次数" align="center" prop="number" />
      <el-table-column label="套票金额" align="center" prop="packageMoney" />
      <el-table-column label="使用期限" align="center" prop="serviceLife" />
      <el-table-column label="授权人" align="center" prop="certigier" />
      <el-table-column label="套票状态(未开通/正常使用/过期/使用完毕)" align="center" prop="packageStatus" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="封面" align="center" prop="cover" />
      <el-table-column label="内容" align="center" prop="content" />
      <el-table-column label="使用规则" align="center" prop="regulation" />
      <el-table-column label=" 使用期限说明" align="center" prop="serviceLifeType" />
      <el-table-column label="套票内容" align="center" prop="packageContent" />
      <el-table-column label="套票规则" align="center" prop="packageRule" />
      <el-table-column label="开始日期" align="center" prop="startDate" />
      <el-table-column label="结束日期" align="center" prop="endDate" />
      <el-table-column label="是否上架 0:已上架，1:未上架" align="center" prop="ticketStatus" />
      <el-table-column label="使用年限周期" align="center" prop="timeNum" />
      <el-table-column label="使用年限类型 0固定1不固定" align="center" prop="timeType" />
      <el-table-column label="使用年限频次 0年1月" align="center" prop="timeLimitMode" />
      <el-table-column label="套票场景0活动1商品" align="center" prop="ticketType" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="项目来源" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['service:ticket-package:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['service:ticket-package:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="套票名称" prop="packageName">
          <el-input v-model="form.packageName" placeholder="请输入套票名称" />
        </el-form-item>
        <el-form-item label="套票种类" prop="packageType">
          <el-select v-model="form.packageType" placeholder="请选择套票种类">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="购买人" prop="purchaser">
          <el-input v-model="form.purchaser" placeholder="请输入购买人" />
        </el-form-item>
        <el-form-item label="服务id" prop="carrierId">
          <el-input v-model="form.carrierId" placeholder="请输入服务id" />
        </el-form-item>
        <el-form-item label="使用次数" prop="number">
          <el-input v-model="form.number" placeholder="请输入使用次数" />
        </el-form-item>
        <el-form-item label="套票金额" prop="packageMoney">
          <el-input v-model="form.packageMoney" placeholder="请输入套票金额" />
        </el-form-item>
        <el-form-item label="使用期限" prop="serviceLife">
          <el-input v-model="form.serviceLife" placeholder="请输入使用期限" />
        </el-form-item>
        <el-form-item label="授权人" prop="certigier">
          <el-input v-model="form.certigier" placeholder="请输入授权人" />
        </el-form-item>
        <el-form-item label="套票状态(未开通/正常使用/过期/使用完毕)" prop="packageStatus">
          <el-radio-group v-model="form.packageStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="封面" prop="cover">
          <el-input v-model="form.cover" placeholder="请输入封面" />
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="使用规则" prop="regulation">
          <el-input v-model="form.regulation" placeholder="请输入使用规则" />
        </el-form-item>
        <el-form-item label=" 使用期限说明" prop="serviceLifeType">
          <el-select v-model="form.serviceLifeType" placeholder="请选择 使用期限说明">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="套票内容">
          <editor v-model="form.packageContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="套票规则" prop="packageRule">
          <el-input v-model="form.packageRule" placeholder="请输入套票规则" />
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable v-model="form.startDate" type="date" value-format="timestamp" placeholder="选择开始日期" />
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable v-model="form.endDate" type="date" value-format="timestamp" placeholder="选择结束日期" />
        </el-form-item>
        <el-form-item label="是否上架 0:已上架，1:未上架" prop="ticketStatus">
          <el-radio-group v-model="form.ticketStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="使用年限周期" prop="timeNum">
          <el-input v-model="form.timeNum" placeholder="请输入使用年限周期" />
        </el-form-item>
        <el-form-item label="使用年限类型 0固定1不固定" prop="timeType">
          <el-select v-model="form.timeType" placeholder="请选择使用年限类型 0固定1不固定">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="使用年限频次 0年1月" prop="timeLimitMode">
          <el-input v-model="form.timeLimitMode" placeholder="请输入使用年限频次 0年1月" />
        </el-form-item>
        <el-form-item label="套票场景0活动1商品" prop="ticketType">
          <el-select v-model="form.ticketType" placeholder="请选择套票场景0活动1商品">
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
import { createTicketPackage, updateTicketPackage, deleteTicketPackage, getTicketPackage, getTicketPackagePage, exportTicketPackageExcel } from "@/api/service/ticketPackage";
import Editor from '@/components/Editor';

export default {
  name: "TicketPackage",
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
      // 套票列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        packageName: null,
        packageType: null,
        purchaser: null,
        carrierId: null,
        number: null,
        packageMoney: null,
        serviceLife: null,
        certigier: null,
        packageStatus: null,
        remarks: null,
        cover: null,
        content: null,
        regulation: null,
        serviceLifeType: null,
        packageContent: null,
        packageRule: null,
        startDate: [],
        endDate: [],
        ticketStatus: null,
        timeNum: null,
        timeType: null,
        timeLimitMode: null,
        ticketType: null,
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
      getTicketPackagePage(this.queryParams).then(response => {
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
        packageName: undefined,
        packageType: undefined,
        purchaser: undefined,
        carrierId: undefined,
        number: undefined,
        packageMoney: undefined,
        serviceLife: undefined,
        certigier: undefined,
        packageStatus: undefined,
        remarks: undefined,
        cover: undefined,
        content: undefined,
        regulation: undefined,
        serviceLifeType: undefined,
        packageContent: undefined,
        packageRule: undefined,
        startDate: undefined,
        endDate: undefined,
        ticketStatus: undefined,
        timeNum: undefined,
        timeType: undefined,
        timeLimitMode: undefined,
        ticketType: undefined,
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
      this.title = "添加套票";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getTicketPackage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改套票";
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
          updateTicketPackage(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createTicketPackage(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除套票编号为"' + id + '"的数据项?').then(function() {
          return deleteTicketPackage(id);
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
      this.$modal.confirm('是否确认导出所有套票数据项?').then(() => {
          this.exportLoading = true;
          return exportTicketPackageExcel(params);
        }).then(response => {
          this.$download.excel(response, '套票.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
