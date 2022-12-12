<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd" v-hasPermi="['member:integral-level:create']">
          新增</el-button>
      </el-form-item>
      <!-- <el-form-item label="企业id" prop="enterpriseId">
        <el-input v-model="queryParams.enterpriseId" placeholder="请输入企业id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="企业名称" prop="enterpriseName">
        <el-input v-model="queryParams.enterpriseName" placeholder="请输入企业名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="会员等级" prop="memberLevel">
        <el-input v-model="queryParams.memberLevel" placeholder="请输入会员等级" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="积分阀值" prop="integralThreshold">
        <el-input v-model="queryParams.integralThreshold" placeholder="请输入积分阀值" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="等级优惠" prop="levelDiscount">
        <el-input v-model="queryParams.levelDiscount" placeholder="请输入等级优惠" clearable @keyup.enter.native="handleQuery"/>
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
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          :loading="exportLoading" v-hasPermi="['member:integral-level:export']">导出</el-button>
      </el-form-item> -->
    </el-form>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list" tooltip-effect="light">
      <!-- <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="企业id" align="center" prop="enterpriseId" /> -->
      <el-table-column label="企业名称" align="center" prop="enterpriseName" />
      <el-table-column label="会员等级" align="center" prop="memberLevel" show-overflow-tooltip />
      <el-table-column label="积分阀值" align="center" prop="integralThreshold" />
      <el-table-column label="等级优惠" align="center" prop="levelDiscount">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.MEMBER_LEVEL_DISCOUNT" :value="scope.row.levelDiscount" />
        </template>
      </el-table-column>
      <el-table-column label="等级描述" align="center" prop="levelDescription" show-overflow-tooltip />
      <!-- <el-table-column label="等级描述" align="center" prop="levelDescription">
        <template slot-scope="scope">
          <el-tooltip class="item" effect="light" placement="top">
            <div v-html="ToBreak(scope.row.levelDescription)" slot="content"></div>
            <div class="content">{{ scope.row.levelDescription }}</div>
          </el-tooltip>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" @click="handleView(scope.row)" v-hasPermi="['']">查看</el-button>
          <el-button size="mini" type="text" @click="handleUpdate(scope.row)"
            v-hasPermi="['member:integral-level:update']">修改</el-button>
          <el-button size="mini" type="text" @click="handleDelete(scope.row)"
            v-hasPermi="['member:integral-level:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="企业id" prop="enterpriseId">
          <el-input v-model="form.enterpriseId" placeholder="请输入企业id" />
        </el-form-item> -->
        <el-form-item label="企业名称" prop="enterpriseName">
          <el-select v-model="form.enterpriseName" placeholder="请选择企业名称" value-key="id"
            @change="(item) => { this.getEnterpriseName(item) }">
            <el-option v-for="item in enterpriseNameData" :key="item.id" :label="item.name" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="会员等级" prop="memberLevel">
          <el-input v-model="form.memberLevel" placeholder="请输入会员等级名称" maxlength="64" />
        </el-form-item>
        <el-form-item label="积分阀值" prop="integralThreshold">
          <el-input v-model.number="form.integralThreshold" placeholder="请输入积分阀值" maxlength="9" />
        </el-form-item>
        <el-form-item label="等级优惠" prop="levelDiscount">
          <el-select v-model="form.levelDiscount" placeholder="请选择等级优惠" clearable size="small">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.MEMBER_LEVEL_DISCOUNT)" :key="dict.value"
              :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="等级描述">
          <el-input type="textarea" v-model="form.levelDescription" placeholder="请输入备注" maxlength="200"
            show-word-limit />
        </el-form-item>
        <!-- <el-form-item label="租户集合" prop="source">
          <el-input v-model="form.source" placeholder="请输入租户集合" />
        </el-form-item>
        <el-form-item label="经营主体ID" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体ID" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 对话框(查看) -->
    <el-dialog :title="title" :visible.sync="viewopen" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="企业名称" prop="enterpriseName">{{ form.enterpriseName }}</el-form-item>
        <el-form-item label="会员等级" prop="memberLevel">{{ form.memberLevel }}</el-form-item>
        <el-form-item label="积分阀值" prop="integralThreshold">{{ form.integralThreshold }}</el-form-item>
        <el-form-item label="等级优惠" prop="levelDiscount">
          <dict-tag :type="DICT_TYPE.MEMBER_LEVEL_DISCOUNT" :value="form.levelDiscount" />
        </el-form-item>
        <el-form-item label="等级描述" prop="levelDescription">{{ form.levelDescription }}</el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { createIntegralLevel, updateIntegralLevel, deleteIntegralLevel, getIntegralLevel, getIntegralLevelPage, exportIntegralLevelExcel, getBaseInfo } from "@/api/member/integralLevel";
import Editor from '@/components/Editor';

export default {
  name: "IntegralLevel",
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
      // 会员积分等级列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      viewopen: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        enterpriseId: null,
        enterpriseName: null,
        memberLevel: null,
        integralThreshold: null,
        levelDiscount: null,
        levelDescription: null,
        createTime: [],
        source: null,
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        enterpriseName: [{ required: true, message: "企业名称不能为空", trigger: "blur" }],
        memberLevel: [{ required: true, message: "会员等级不能为空", trigger: "blur" }],
        integralThreshold: [{ required: true, message: "积分阀值不能为空", trigger: "blur" },
        { type: 'number', message: '积分阀值必须为整数', trigger: "blur" }],
      },
      enterpriseNameData: [], //获取企业（经营主体）
      tooltipShow: "", //是否显示文字提示
    };
  },
  created() {
    this.getList();
    this.getEnterprise();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getIntegralLevelPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 获取企业 */
    getEnterprise() {
      getBaseInfo().then(response => {
        this.enterpriseNameData = response.data;
      });
    },
    getEnterpriseName(item) {
      this.form.enterpriseId = item.id
      this.form.enterpriseName = item.name
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
        enterpriseId: undefined,
        enterpriseName: undefined,
        memberLevel: undefined,
        integralThreshold: undefined,
        levelDiscount: undefined,
        levelDescription: undefined,
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
      this.title = "新增积分等级规则";
    },
    /** 查看按钮操作 */
    handleView(row) {
      this.reset();
      const id = row.id;
      getIntegralLevel(id).then(response => {
        this.form = response.data;
        this.viewopen = true;
        this.title = "查看积分等级规则";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getIntegralLevel(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改积分等级规则";
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
          updateIntegralLevel(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createIntegralLevel(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除企业名称为"' + row.enterpriseName + '"的数据项?').then(function () {
        return deleteIntegralLevel(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = { ...this.queryParams };
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有会员积分等级数据项?').then(() => {
        this.exportLoading = true;
        return exportIntegralLevelExcel(params);
      }).then(response => {
        this.$download.excel(response, '会员积分等级.xls');
        this.exportLoading = false;
      }).catch(() => { });
    },
    ToBreak(content) {
      let text, i;
      if (content) {
        let num = 80
        if (content.length > num) {
          // this.tooltipShow = true
          text = content.slice(0, num)
          for (i = 0; i < content.length; i += num) {
            text = text + "<br/>" + content.slice(i, i + num)
          }
        }else{
          // this.tooltipShow = false
          text = content
        }
      }
      return text
    }
  }
};
</script>
<!-- <style scoped>
.content {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style> -->
<style>
.el-tooltip__popper {
    max-width: 50%;
}
</style>