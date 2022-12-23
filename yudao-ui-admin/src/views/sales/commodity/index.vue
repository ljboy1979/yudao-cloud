<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品编号" prop="commodityCode">
        <el-input v-model="queryParams.commodityCode" placeholder="请输入商品编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <!-- <el-form-item label="商品名称" prop="commodityName">
        <el-input v-model="queryParams.commodityName" placeholder="请输入商品名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item> -->
      <el-form-item label="商品分类" prop="commodityCategoryId">
        <el-input v-model="queryParams.commodityCategoryId" placeholder="请输入商品分类" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['sales:commodity:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['sales:commodity:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <!-- <el-table-column label="商品id" align="center" prop="id" /> -->
      <el-table-column label="商品编号" align="center" prop="commodityCode" />
      <el-table-column label="商品名称" align="center" prop="commodityName" />
      <!-- <el-table-column label="序号" align="center" prop="articleNo" /> -->
      <el-table-column label="商品条码" align="center" prop="commodityBarCode" />
      <!-- <el-table-column label="0 渠道商商品 1农资商城商品" align="center" prop="type" />
      <el-table-column label="排序权重" align="center" prop="sort" />
      <el-table-column label="关键字" align="center" prop="keyWord" />
      <el-table-column label="生产商" align="center" prop="manufacturer" />
      <el-table-column label="批次" align="center" prop="batch" />
      <el-table-column label="可销售数量" align="center" prop="availableNum" />
      <el-table-column label="供应商名称" align="center" prop="providerName" />
      <el-table-column label="供应商id" align="center" prop="providerId" />
      <el-table-column label="原供应商id,商品来源商户" align="center" prop="oldProviderId" />
      <el-table-column label="单位数量" align="center" prop="specNum" />
      <el-table-column label="多个标签id 逗号隔开" align="center" prop="lableIds" />
      <el-table-column label="库存预警数量" align="center" prop="warnStockNum" />
      <el-table-column label="规格单位 字典" align="center" prop="weightUnit" />
      <el-table-column label="包装单位 字典" align="center" prop="packageUnit" />
      <el-table-column label="商品分类" align="center" prop="commodityCategoryId" />
      <el-table-column label="生产商" align="center" prop="manufacturerName" />
      <el-table-column label="批发价格" align="center" prop="wholesalePrice" />
      <el-table-column label="零售价格" align="center" prop="retailPrice" />
      <el-table-column label="库存数量" align="center" prop="stockNum" />
      <el-table-column label="是否上架 0下架 1上架" align="center" prop="saleState" />
      <el-table-column label="介绍 富文本" align="center" prop="introduction" />
      <el-table-column label="是否追溯 0-否 1-是" align="center" prop="traceStatus" />
      <el-table-column label="库存商品分类id,关联os_plant表" align="center" prop="plantId" />
      <el-table-column label="商品分类id,关联plant表" align="center" prop="commodityPlantId" />
      <el-table-column label="销售类型 0-自营 1-代售" align="center" prop="sellType" />
      <el-table-column label="增加方式 0-货单上架 1-手工上架" align="center" prop="addType" />
      <el-table-column label="交货地址" align="center" prop="address" />
      <el-table-column label="销售数量" align="center" prop="num" />
      <el-table-column label="同步状态（0未同步1已同步）" align="center" prop="syncStatus" />
      <el-table-column label="货单上货到货时间" align="center" prop="arriveDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.arriveDate) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="0商品" align="center" prop="commodityType" />
      <el-table-column label="商品图片" align="center" prop="commodityImg" />
      <el-table-column label="公示单价" align="center" prop="publicityPrice" /> -->
      <el-table-column label="产地" align="center" prop="productionAddress" />
      <!-- <el-table-column label="产地地址" align="center" prop="originPlace" />
      <el-table-column label="商品别名" align="center" prop="antName" />
      <el-table-column label="创建的用户id" align="center" prop="createId" />
      <el-table-column label="视频连接" align="center" prop="videoUrl" />
      <el-table-column label="状态" align="center" prop="status" /> -->
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handledetail(scope.row)"
                     v-hasPermi="['sales:commodity:update']">管理</el-button>
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['sales:commodity:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['sales:commodity:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="商品编号" prop="commodityCode">
          <el-input v-model="form.commodityCode" placeholder="请输入商品编号" />
        </el-form-item>
        <el-form-item label="序号" prop="articleNo">
          <el-input v-model="form.articleNo" placeholder="请输入序号" />
        </el-form-item> -->
        
        <el-form-item label="商品名称" prop="commodityName">
          <el-input v-model="form.commodityName" placeholder="请输入商品名称" />
        </el-form-item>
        <!-- <el-form-item label="0 渠道商商品 1农资商城商品" prop="type">
          <el-radio-group v-model="form.type">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="排序权重" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序权重" />
        </el-form-item>
        <el-form-item label="关键字" prop="keyWord">
          <el-input v-model="form.keyWord" placeholder="请输入关键字" />
        </el-form-item>
        <el-form-item label="生产商" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入生产商" />
        </el-form-item>
        <el-form-item label="批次" prop="batch">
          <el-input v-model="form.batch" placeholder="请输入批次" />
        </el-form-item>
        <el-form-item label="可销售数量" prop="availableNum">
          <el-input v-model="form.availableNum" placeholder="请输入可销售数量" />
        </el-form-item>
        <el-form-item label="供应商名称" prop="providerName">
          <el-input v-model="form.providerName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-form-item label="供应商id" prop="providerId">
          <el-input v-model="form.providerId" placeholder="请输入供应商id" />
        </el-form-item>
        <el-form-item label="原供应商id,商品来源商户" prop="oldProviderId">
          <el-input v-model="form.oldProviderId" placeholder="请输入原供应商id,商品来源商户" />
        </el-form-item>
        <el-form-item label="单位数量" prop="specNum">
          <el-input v-model="form.specNum" placeholder="请输入单位数量" />
        </el-form-item>
        <el-form-item label="多个标签id 逗号隔开" prop="lableIds">
          <el-input v-model="form.lableIds" placeholder="请输入多个标签id 逗号隔开" />
        </el-form-item>
        <el-form-item label="库存预警数量" prop="warnStockNum">
          <el-input v-model="form.warnStockNum" placeholder="请输入库存预警数量" />
        </el-form-item>
        <el-form-item label="规格单位 字典" prop="weightUnit">
          <el-input v-model="form.weightUnit" placeholder="请输入规格单位 字典" />
        </el-form-item>
        <el-form-item label="包装单位 字典" prop="packageUnit">
          <el-input v-model="form.packageUnit" placeholder="请输入包装单位 字典" />
        </el-form-item> -->
        <el-form-item label="商品分类" prop="commodityCategoryId">
          <el-input v-model="form.commodityCategoryId" placeholder="请输入商品分类" />
        </el-form-item>
        <el-form-item label="商品条码" prop="commodityBarCode">
          <el-input v-model="form.commodityBarCode" placeholder="请输入商品条码" />
        </el-form-item>
        <!-- <el-form-item label="生产商" prop="manufacturerName">
          <el-input v-model="form.manufacturerName" placeholder="请输入生产商" />
        </el-form-item>
        <el-form-item label="批发价格" prop="wholesalePrice">
          <el-input v-model="form.wholesalePrice" placeholder="请输入批发价格" />
        </el-form-item>
        <el-form-item label="零售价格" prop="retailPrice">
          <el-input v-model="form.retailPrice" placeholder="请输入零售价格" />
        </el-form-item>
        <el-form-item label="库存数量" prop="stockNum">
          <el-input v-model="form.stockNum" placeholder="请输入库存数量" />
        </el-form-item>
        <el-form-item label="是否上架 0下架 1上架" prop="saleState">
          <el-input v-model="form.saleState" placeholder="请输入是否上架 0下架 1上架" />
        </el-form-item>
        <el-form-item label="介绍 富文本" prop="introduction">
          <el-input v-model="form.introduction" placeholder="请输入介绍 富文本" />
        </el-form-item>
        <el-form-item label="是否追溯 0-否 1-是" prop="traceStatus">
          <el-radio-group v-model="form.traceStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="库存商品分类id,关联os_plant表" prop="plantId">
          <el-input v-model="form.plantId" placeholder="请输入库存商品分类id,关联os_plant表" />
        </el-form-item>
        <el-form-item label="商品分类id,关联plant表" prop="commodityPlantId">
          <el-input v-model="form.commodityPlantId" placeholder="请输入商品分类id,关联plant表" />
        </el-form-item>
        <el-form-item label="销售类型 0-自营 1-代售" prop="sellType">
          <el-select v-model="form.sellType" placeholder="请选择销售类型 0-自营 1-代售">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="增加方式 0-货单上架 1-手工上架" prop="addType">
          <el-select v-model="form.addType" placeholder="请选择增加方式 0-货单上架 1-手工上架">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="交货地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入交货地址" />
        </el-form-item>
        <el-form-item label="销售数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入销售数量" />
        </el-form-item>
        <el-form-item label="同步状态（0未同步1已同步）" prop="syncStatus">
          <el-radio-group v-model="form.syncStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="货单上货到货时间" prop="arriveDate">
          <el-date-picker clearable v-model="form.arriveDate" type="date" value-format="timestamp" placeholder="选择货单上货到货时间" />
        </el-form-item>
        <el-form-item label="0商品" prop="commodityType">
          <el-select v-model="form.commodityType" placeholder="请选择0商品">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item> -->
        <el-form-item label="产地" prop="productionAddress">
          <el-input v-model="form.productionAddress" placeholder="请输入产地" />
        </el-form-item>
        <el-form-item label="商品图片" prop="commodityImg">
          <!-- <el-input v-model="form.commodityImg" placeholder="请输入商品图片" /> -->
          <el-upload action="#" list-type="picture-card" :auto-upload="false" :on-preview="handlePictureCardPreview"
            :on-remove="handleRemovecertificatePhoto" :on-change="changecertificatePhoto" :class="{ hide: certificate }"
            ref="certificatePhoto" :file-list="this.certificatePhoto"
            :headers="upload.headers" :action="upload.url" :on-success="certificatePhotoSuccess"
            >
            <i class="el-icon-plus"></i>
          </el-upload>
          <div style="font-size: 14px;color:#AAA">最多1张 <span style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span>
          </div>
          <el-dialog :visible.sync="dialogVisible" append-to-body>
            <img width="50%" height="50%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <!-- <el-form-item label="公示单价" prop="publicityPrice">
          <el-input v-model="form.publicityPrice" placeholder="请输入公示单价" />
        </el-form-item> -->
        
        <!-- <el-form-item label="产地地址" prop="originPlace">
          <el-input v-model="form.originPlace" placeholder="请输入产地地址" />
        </el-form-item>
        <el-form-item label="商品别名" prop="antName">
          <el-input v-model="form.antName" placeholder="请输入商品别名" />
        </el-form-item>
        <el-form-item label="创建的用户id" prop="createId">
          <el-input v-model="form.createId" placeholder="请输入创建的用户id" />
        </el-form-item>
        <el-form-item label="视频连接" prop="videoUrl">
          <el-input v-model="form.videoUrl" placeholder="请输入视频连接" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createCommodity, updateCommodity, deleteCommodity, getCommodity, getCommodityPage, exportCommodityExcel } from "@/api/sales/commodity";
import { getAccessToken } from "@/utils/auth";
export default {
  name: "Commodity",
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
      // 商品列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        commodityCode: null,
        articleNo: null,
        commodityBarCode: null,
        commodityName: null,
        type: null,
        sort: null,
        keyWord: null,
        manufacturer: null,
        batch: null,
        availableNum: null,
        providerName: null,
        providerId: null,
        oldProviderId: null,
        specNum: null,
        lableIds: null,
        warnStockNum: null,
        weightUnit: null,
        packageUnit: null,
        commodityCategoryId: null,
        manufacturerName: null,
        wholesalePrice: null,
        retailPrice: null,
        stockNum: null,
        saleState: null,
        introduction: null,
        traceStatus: null,
        plantId: null,
        commodityPlantId: null,
        sellType: null,
        addType: null,
        address: null,
        num: null,
        syncStatus: null,
        arriveDate: [],
        commodityType: null,
        commodityImg: null,
        publicityPrice: null,
        productionAddress: null,
        originPlace: null,
        antName: null,
        createId: null,
        videoUrl: null,
        status: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        commodityCategoryId: [{ required: true, message: "状态不能为空", trigger: "blur" },
        { min: 1, max: 50, message: '最大长度为50', trigger: 'blur' }
      ],
        commodityName: [{ required: true, message: "商品名称不能为空", trigger: "blur" },
        { min: 1, max: 50, message: '最大长度为50', trigger: 'blur' }],
      },
      certificatePhoto: [],//经营许可证
      certificate: false,//经营许可证是否可继续上传
      dialogVisible: false,//是否开启预览
      dialogImageUrl: '',//当前预览图片地址
      // 图片上传参数
      upload: {
        open: false, // 是否显示弹出层
        title: "", // 弹出层标题
        isUploading: false, // 是否禁用上传
        url: process.env.VUE_APP_BASE_API + "/admin-api/infra/file/upload", // 请求地址
        headers: { Authorization: "Bearer " + getAccessToken() }, // 设置上传的请求头部
        data: {} // 上传的额外数据，用于文件名
      },
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
      getCommodityPage(this.queryParams).then(response => {
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
        commodityCode: undefined,
        articleNo: undefined,
        commodityBarCode: undefined,
        commodityName: undefined,
        type: undefined,
        sort: undefined,
        keyWord: undefined,
        manufacturer: undefined,
        batch: undefined,
        availableNum: undefined,
        providerName: undefined,
        providerId: undefined,
        oldProviderId: undefined,
        specNum: undefined,
        lableIds: undefined,
        warnStockNum: undefined,
        weightUnit: undefined,
        packageUnit: undefined,
        commodityCategoryId: undefined,
        manufacturerName: undefined,
        wholesalePrice: undefined,
        retailPrice: undefined,
        stockNum: undefined,
        saleState: undefined,
        introduction: undefined,
        traceStatus: undefined,
        plantId: undefined,
        commodityPlantId: undefined,
        sellType: undefined,
        addType: undefined,
        address: undefined,
        num: undefined,
        syncStatus: undefined,
        arriveDate: undefined,
        commodityType: undefined,
        commodityImg: undefined,
        publicityPrice: undefined,
        productionAddress: undefined,
        originPlace: undefined,
        antName: undefined,
        createId: undefined,
        videoUrl: undefined,
        status: undefined,
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
      this.title = "添加商品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getCommodity(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品";
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
          updateCommodity(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createCommodity(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.commodityCode;
      this.$modal.confirm('是否确认删除商品编号为"' + id + '"的数据项?').then(function() {
          return deleteCommodity(row.id);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /*  管理按钮 */
    handledetail(row){
      this.$router.push({ path: "/sales/commodity/commodityDetail", query: { id: row.id } });
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有商品数据项?').then(() => {
          this.exportLoading = true;
          return exportCommodityExcel(params);
        }).then(response => {
          this.$download.excel(response, '商品.xls');
          this.exportLoading = false;
        }).catch(() => {});
    },
    //移除企业经营许可证
    handleRemovecertificatePhoto(file, fileList) {
      this.certificatePhoto = fileList
      fileList.length == 1 ? this.certificate = true : this.certificate = false
      this.Logoimg = false;
    },
    //预览照片
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    //上传经营许可证，等于6张隐藏上传按钮
    changecertificatePhoto(file, fileList) {
      console.log(fileList)
      let check = this.beforeAvatarUpload(file);
      if (check) {
        fileList.length == 1 ? this.certificate = true : ''
        this.certificatePhoto = fileList
        this.$refs.certificatePhoto.submit();
      } else {
        this.$refs.certificatePhoto.uploadFiles.splice(this.$refs.certificatePhoto.uploadFiles.length - 1, 1)
      }
    },
    certificatePhotoSuccess(response){
      this.certificatePhoto[this.certificatePhoto.length-1].url = response.data;
      console.log(this.certificatePhoto)
    },
    //检验上传图片格式以及大小
    beforeAvatarUpload(file) {
      const isJPG = file.raw.type === 'image/jpeg' ? true : file.raw.type === 'image/jpg' ? true : file.raw.type === 'image/png' ? true : false;
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error('上传图片只能是 JPG/JPEG/PNG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB!');
      }
      return isLt2M && isJPG;
    },
  }
};
</script>
<style scoped>
.hide>>>.el-upload--picture-card {
  display: none;
}
</style>