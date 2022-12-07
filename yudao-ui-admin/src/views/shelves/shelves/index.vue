<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分类id" prop="classifyId">
        <el-input v-model="queryParams.classifyId" placeholder="请输入分类id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
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
                   v-hasPermi="['shelves:shelves:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['shelves:shelves:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="分类id" align="center" prop="classifyId" />
      <el-table-column label="来源id" align="center" prop="sourceId" />
      <el-table-column label="货架编号" align="center" prop="number" />
      <el-table-column label="售品类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品" align="center" prop="type" />
      <el-table-column label="上架数量" align="center" prop="addNum" />
      <el-table-column label="可销售量" align="center" prop="availableNum" />
      <el-table-column label="销量" align="center" prop="salesNum" />
      <el-table-column label="计量单位" align="center" prop="measurementUnit" />
      <el-table-column label="计量单位名称" align="center" prop="measurementUnitName" />
      <el-table-column label="是否上架 0下架 1上架 2禁售" align="center" prop="saleState" />
      <el-table-column label="供应日期" align="center" prop="supplyDate" />
      <el-table-column label="餐次 0早/1中/2晚" align="center" prop="meals" />
      <el-table-column label="售品图片" align="center" prop="imgUrl" />
      <el-table-column label="售品视频" align="center" prop="videoUrl" />
      <el-table-column label="售品说明" align="center" prop="explain" />
      <el-table-column label="标签" align="center" prop="label" />
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label="供应商" align="center" prop="vendor" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="source" align="center" prop="source" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['shelves:shelves:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['shelves:shelves:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="分类id" prop="classifyId">
          <el-input v-model="form.classifyId" placeholder="请输入分类id" />
        </el-form-item>
        <el-form-item label="来源id" prop="sourceId">
          <el-input v-model="form.sourceId" placeholder="请输入来源id" />
        </el-form-item>
        <el-form-item label="货架编号" prop="number">
          <el-input v-model="form.number" placeholder="请输入货架编号" />
        </el-form-item>
        <el-form-item label="售品类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品" prop="type">
          <el-select v-model="form.type" placeholder="请选择售品类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="上架数量" prop="addNum">
          <el-input v-model="form.addNum" placeholder="请输入上架数量" />
        </el-form-item>
        <el-form-item label="可销售量" prop="availableNum">
          <el-input v-model="form.availableNum" placeholder="请输入可销售量" />
        </el-form-item>
        <el-form-item label="销量" prop="salesNum">
          <el-input v-model="form.salesNum" placeholder="请输入销量" />
        </el-form-item>
        <el-form-item label="计量单位" prop="measurementUnit">
          <el-input v-model="form.measurementUnit" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="计量单位名称" prop="measurementUnitName">
          <el-input v-model="form.measurementUnitName" placeholder="请输入计量单位名称" />
        </el-form-item>
        <el-form-item label="是否上架 0下架 1上架 2禁售" prop="saleState">
          <el-input v-model="form.saleState" placeholder="请输入是否上架 0下架 1上架 2禁售" />
        </el-form-item>
        <el-form-item label="供应日期" prop="supplyDate">
          <el-date-picker clearable v-model="form.supplyDate" type="date" value-format="timestamp" placeholder="选择供应日期" />
        </el-form-item>
        <el-form-item label="餐次 0早/1中/2晚" prop="meals">
          <el-input v-model="form.meals" placeholder="请输入餐次 0早/1中/2晚" />
        </el-form-item>
        <el-form-item label="售品图片" prop="imgUrl">
          <el-input v-model="form.imgUrl" placeholder="请输入售品图片" />
        </el-form-item>
        <el-form-item label="售品视频" prop="videoUrl">
          <el-input v-model="form.videoUrl" placeholder="请输入售品视频" />
        </el-form-item>
        <el-form-item label="售品说明" prop="explain">
          <el-input v-model="form.explain" placeholder="请输入售品说明" />
        </el-form-item>
        <el-form-item label="标签" prop="label">
          <el-input v-model="form.label" placeholder="请输入标签" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="供应商" prop="vendor">
          <el-input v-model="form.vendor" placeholder="请输入供应商" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
        </el-form-item>
        <el-form-item label="source" prop="source">
          <el-input v-model="form.source" placeholder="请输入source" />
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
import { createshelves, updateshelves, deleteshelves, getshelves, getshelvesPage, exportshelvesExcel } from "@/api/shelves/shelves";

export default {
  name: "shelves",
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
      // 货架列表
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
        classifyId: null,
        createTime: [],
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
      getshelvesPage(this.queryParams).then(response => {
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
        name: undefined,
        classifyId: undefined,
        sourceId: undefined,
        number: undefined,
        type: undefined,
        addNum: undefined,
        availableNum: undefined,
        salesNum: undefined,
        measurementUnit: undefined,
        measurementUnitName: undefined,
        saleState: undefined,
        supplyDate: undefined,
        meals: undefined,
        imgUrl: undefined,
        videoUrl: undefined,
        explain: undefined,
        label: undefined,
        sort: undefined,
        vendor: undefined,
        status: undefined,
        subjectId: undefined,
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
      this.title = "添加货架";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getshelves(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改货架";
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
          updateshelves(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createshelves(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除货架编号为"' + id + '"的数据项?').then(function() {
          return deleteshelves(id);
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
      this.$modal.confirm('是否确认导出所有货架数据项?').then(() => {
          this.exportLoading = true;
          return exportshelvesExcel(params);
        }).then(response => {
          this.$download.excel(response, '货架.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
