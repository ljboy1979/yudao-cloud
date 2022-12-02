<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="套餐名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入套餐名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="序列号" prop="sort">
        <el-input v-model="queryParams.sort" placeholder="请输入序列号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="小程序套餐分类id一级 关联os_commodity_category_mini" prop="miniClassificationIdOne">
        <el-input v-model="queryParams.miniClassificationIdOne" placeholder="请输入小程序套餐分类id一级 关联os_commodity_category_mini" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="小程序套餐分类id二级 关联os_commodity_category_mini" prop="miniClassificationIdTwo">
        <el-input v-model="queryParams.miniClassificationIdTwo" placeholder="请输入小程序套餐分类id二级 关联os_commodity_category_mini" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="套餐商品构成" prop="commodityName">
        <el-input v-model="queryParams.commodityName" placeholder="请输入套餐商品构成" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="套餐视频" prop="video">
        <el-input v-model="queryParams.video" placeholder="请输入套餐视频" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="处理规格 字典Process_specifications 可存多个" prop="processTag">
        <el-input v-model="queryParams.processTag" placeholder="请输入处理规格 字典Process_specifications 可存多个" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="物流费" prop="logisticsFees">
        <el-input v-model="queryParams.logisticsFees" placeholder="请输入物流费" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="捕捞商品id" prop="osCommodityFishingId">
        <el-input v-model="queryParams.osCommodityFishingId" placeholder="请输入捕捞商品id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="捕捞规格id" prop="productSpecificationsFishingId">
        <el-input v-model="queryParams.productSpecificationsFishingId" placeholder="请输入捕捞规格id" clearable @keyup.enter.native="handleQuery"/>
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
      <el-form-item label="经营主体id" prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体id" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['sales:package:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['sales:package:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="套餐名称" align="center" prop="name" />
      <el-table-column label="套餐价格" align="center" prop="price" />
      <el-table-column label="meals_time" align="center" prop="mealsTime" />
      <el-table-column label="热量" align="center" prop="calories" />
      <el-table-column label="关联医嘱字典" align="center" prop="medicalAdvice" />
      <el-table-column label="套餐方案(字典)" align="center" prop="mealsPlan" />
      <el-table-column label="套餐规格" align="center" prop="mealsSpecs" />
      <el-table-column label="开放日期" align="center" prop="availableDate" />
      <el-table-column label="套餐图片" align="center" prop="imgs" />
      <el-table-column label="能量" align="center" prop="energy" />
      <el-table-column label="蛋白质" align="center" prop="protein" />
      <el-table-column label="专家建议" align="center" prop="expertAdvice" />
      <el-table-column label="脂肪" align="center" prop="fat" />
      <el-table-column label="碳水化合物" align="center" prop="carbohydrate" />
      <el-table-column label="套餐编号" align="center" prop="mealNumber" />
      <el-table-column label="创建者" align="center" prop="createBy" />
      <el-table-column label="创建时间" align="center" prop="createDate" />
      <el-table-column label="修改着" align="center" prop="updateBy" />
      <el-table-column label="修改时间" align="center" prop="updateDate" />
      <el-table-column label="供应商id" align="center" prop="providerId" />
      <el-table-column label="关联营养信息表" align="center" prop="nutritionId" />
      <el-table-column label="备注信息" align="center" prop="remarks" />
      <el-table-column label="钠" align="center" prop="sodium" />
      <el-table-column label="钾" align="center" prop="potassium" />
      <el-table-column label="磷" align="center" prop="phosphorus" />
      <el-table-column label="来源" align="center" prop="source" />
      <el-table-column label="库存数量（上架）" align="center" prop="num" />
      <el-table-column label="0下架 1上架" align="center" prop="auditStatus" />
      <el-table-column label="库存数量(剩余)" align="center" prop="inventoryNum" />
      <el-table-column label="剩余数量" align="center" prop="remnantNum" />
      <el-table-column label="来源套餐id" align="center" prop="originPackageId" />
      <el-table-column label="套餐类型" align="center" prop="skupageTag" />
      <el-table-column label="套餐类型名称" align="center" prop="skupageTagName" />
      <el-table-column label="套餐说明" align="center" prop="skupageExplain" />
      <el-table-column label="库存锁" align="center" prop="version" />
      <el-table-column label="序列号" align="center" prop="sort" />
      <el-table-column label="小程序套餐分类id一级 关联os_commodity_category_mini" align="center" prop="miniClassificationIdOne" />
      <el-table-column label="小程序套餐分类id二级 关联os_commodity_category_mini" align="center" prop="miniClassificationIdTwo" />
      <el-table-column label="套餐商品构成" align="center" prop="commodityName" />
      <el-table-column label="套餐视频" align="center" prop="video" />
      <el-table-column label="处理规格 字典Process_specifications 可存多个" align="center" prop="processTag" />
      <el-table-column label="物流费" align="center" prop="logisticsFees" />
      <el-table-column label="捕捞商品id" align="center" prop="osCommodityFishingId" />
      <el-table-column label="捕捞规格id" align="center" prop="productSpecificationsFishingId" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['sales:package:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['sales:package:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="套餐名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入套餐名称" />
        </el-form-item>
        <el-form-item label="套餐价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入套餐价格" />
        </el-form-item>
        <el-form-item label="meals_time" prop="mealsTime">
          <el-date-picker clearable v-model="form.mealsTime" type="date" value-format="timestamp" placeholder="选择meals_time" />
        </el-form-item>
        <el-form-item label="热量" prop="calories">
          <el-input v-model="form.calories" placeholder="请输入热量" />
        </el-form-item>
        <el-form-item label="关联医嘱字典" prop="medicalAdvice">
          <el-input v-model="form.medicalAdvice" placeholder="请输入关联医嘱字典" />
        </el-form-item>
        <el-form-item label="套餐方案(字典)" prop="mealsPlan">
          <el-input v-model="form.mealsPlan" placeholder="请输入套餐方案(字典)" />
        </el-form-item>
        <el-form-item label="套餐规格" prop="mealsSpecs">
          <el-input v-model="form.mealsSpecs" placeholder="请输入套餐规格" />
        </el-form-item>
        <el-form-item label="开放日期" prop="availableDate">
          <el-date-picker clearable v-model="form.availableDate" type="date" value-format="timestamp" placeholder="选择开放日期" />
        </el-form-item>
        <el-form-item label="套餐图片" prop="imgs">
          <el-input v-model="form.imgs" placeholder="请输入套餐图片" />
        </el-form-item>
        <el-form-item label="能量" prop="energy">
          <el-input v-model="form.energy" placeholder="请输入能量" />
        </el-form-item>
        <el-form-item label="蛋白质" prop="protein">
          <el-input v-model="form.protein" placeholder="请输入蛋白质" />
        </el-form-item>
        <el-form-item label="专家建议" prop="expertAdvice">
          <el-input v-model="form.expertAdvice" placeholder="请输入专家建议" />
        </el-form-item>
        <el-form-item label="脂肪" prop="fat">
          <el-input v-model="form.fat" placeholder="请输入脂肪" />
        </el-form-item>
        <el-form-item label="碳水化合物" prop="carbohydrate">
          <el-input v-model="form.carbohydrate" placeholder="请输入碳水化合物" />
        </el-form-item>
        <el-form-item label="套餐编号" prop="mealNumber">
          <el-input v-model="form.mealNumber" placeholder="请输入套餐编号" />
        </el-form-item>
        <el-form-item label="创建者" prop="createBy">
          <el-input v-model="form.createBy" placeholder="请输入创建者" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createDate">
          <el-date-picker clearable v-model="form.createDate" type="date" value-format="timestamp" placeholder="选择创建时间" />
        </el-form-item>
        <el-form-item label="修改着" prop="updateBy">
          <el-input v-model="form.updateBy" placeholder="请输入修改着" />
        </el-form-item>
        <el-form-item label="修改时间" prop="updateDate">
          <el-date-picker clearable v-model="form.updateDate" type="date" value-format="timestamp" placeholder="选择修改时间" />
        </el-form-item>
        <el-form-item label="供应商id" prop="providerId">
          <el-input v-model="form.providerId" placeholder="请输入供应商id" />
        </el-form-item>
        <el-form-item label="关联营养信息表" prop="nutritionId">
          <el-input v-model="form.nutritionId" placeholder="请输入关联营养信息表" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="钠" prop="sodium">
          <el-input v-model="form.sodium" placeholder="请输入钠" />
        </el-form-item>
        <el-form-item label="钾" prop="potassium">
          <el-input v-model="form.potassium" placeholder="请输入钾" />
        </el-form-item>
        <el-form-item label="磷" prop="phosphorus">
          <el-input v-model="form.phosphorus" placeholder="请输入磷" />
        </el-form-item>
        <el-form-item label="来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入来源" />
        </el-form-item>
        <el-form-item label="库存数量（上架）" prop="num">
          <el-input v-model="form.num" placeholder="请输入库存数量（上架）" />
        </el-form-item>
        <el-form-item label="0下架 1上架" prop="auditStatus">
          <el-radio-group v-model="form.auditStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="库存数量(剩余)" prop="inventoryNum">
          <el-input v-model="form.inventoryNum" placeholder="请输入库存数量(剩余)" />
        </el-form-item>
        <el-form-item label="剩余数量" prop="remnantNum">
          <el-input v-model="form.remnantNum" placeholder="请输入剩余数量" />
        </el-form-item>
        <el-form-item label="来源套餐id" prop="originPackageId">
          <el-input v-model="form.originPackageId" placeholder="请输入来源套餐id" />
        </el-form-item>
        <el-form-item label="套餐类型" prop="skupageTag">
          <el-input v-model="form.skupageTag" placeholder="请输入套餐类型" />
        </el-form-item>
        <el-form-item label="套餐类型名称" prop="skupageTagName">
          <el-input v-model="form.skupageTagName" placeholder="请输入套餐类型名称" />
        </el-form-item>
        <el-form-item label="套餐说明" prop="skupageExplain">
          <el-input v-model="form.skupageExplain" placeholder="请输入套餐说明" />
        </el-form-item>
        <el-form-item label="库存锁" prop="version">
          <el-input v-model="form.version" placeholder="请输入库存锁" />
        </el-form-item>
        <el-form-item label="序列号" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入序列号" />
        </el-form-item>
        <el-form-item label="小程序套餐分类id一级 关联os_commodity_category_mini" prop="miniClassificationIdOne">
          <el-input v-model="form.miniClassificationIdOne" placeholder="请输入小程序套餐分类id一级 关联os_commodity_category_mini" />
        </el-form-item>
        <el-form-item label="小程序套餐分类id二级 关联os_commodity_category_mini" prop="miniClassificationIdTwo">
          <el-input v-model="form.miniClassificationIdTwo" placeholder="请输入小程序套餐分类id二级 关联os_commodity_category_mini" />
        </el-form-item>
        <el-form-item label="套餐商品构成" prop="commodityName">
          <el-input v-model="form.commodityName" placeholder="请输入套餐商品构成" />
        </el-form-item>
        <el-form-item label="套餐视频" prop="video">
          <el-input v-model="form.video" placeholder="请输入套餐视频" />
        </el-form-item>
        <el-form-item label="处理规格 字典Process_specifications 可存多个" prop="processTag">
          <el-input v-model="form.processTag" placeholder="请输入处理规格 字典Process_specifications 可存多个" />
        </el-form-item>
        <el-form-item label="物流费" prop="logisticsFees">
          <el-input v-model="form.logisticsFees" placeholder="请输入物流费" />
        </el-form-item>
        <el-form-item label="捕捞商品id" prop="osCommodityFishingId">
          <el-input v-model="form.osCommodityFishingId" placeholder="请输入捕捞商品id" />
        </el-form-item>
        <el-form-item label="捕捞规格id" prop="productSpecificationsFishingId">
          <el-input v-model="form.productSpecificationsFishingId" placeholder="请输入捕捞规格id" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
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
import { createPackage, updatePackage, deletePackage, getPackage, getPackagePage, exportPackageExcel } from "@/api/sales/package";

export default {
  name: "Package",
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
      // 套餐列表
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
        sort: null,
        miniClassificationIdOne: null,
        miniClassificationIdTwo: null,
        commodityName: null,
        video: null,
        processTag: null,
        logisticsFees: null,
        osCommodityFishingId: null,
        productSpecificationsFishingId: null,
        status: null,
        createTime: [],
        subjectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [{ required: true, message: "套餐名称不能为空", trigger: "blur" }],
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
      getPackagePage(this.queryParams).then(response => {
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
        price: undefined,
        mealsTime: undefined,
        calories: undefined,
        medicalAdvice: undefined,
        mealsPlan: undefined,
        mealsSpecs: undefined,
        availableDate: undefined,
        imgs: undefined,
        energy: undefined,
        protein: undefined,
        expertAdvice: undefined,
        fat: undefined,
        carbohydrate: undefined,
        mealNumber: undefined,
        createBy: undefined,
        createDate: undefined,
        updateBy: undefined,
        updateDate: undefined,
        providerId: undefined,
        nutritionId: undefined,
        remarks: undefined,
        sodium: undefined,
        potassium: undefined,
        phosphorus: undefined,
        source: undefined,
        num: undefined,
        auditStatus: undefined,
        inventoryNum: undefined,
        remnantNum: undefined,
        originPackageId: undefined,
        skupageTag: undefined,
        skupageTagName: undefined,
        skupageExplain: undefined,
        version: undefined,
        sort: undefined,
        miniClassificationIdOne: undefined,
        miniClassificationIdTwo: undefined,
        commodityName: undefined,
        video: undefined,
        processTag: undefined,
        logisticsFees: undefined,
        osCommodityFishingId: undefined,
        productSpecificationsFishingId: undefined,
        status: undefined,
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
      this.title = "添加套餐";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getPackage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改套餐";
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
          updatePackage(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createPackage(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除套餐编号为"' + id + '"的数据项?').then(function() {
          return deletePackage(id);
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
      this.$modal.confirm('是否确认导出所有套餐数据项?').then(() => {
          this.exportLoading = true;
          return exportPackageExcel(params);
        }).then(response => {
          this.$download.excel(response, '套餐.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
