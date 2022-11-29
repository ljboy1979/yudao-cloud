<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
                   v-hasPermi="['sales:commodity-sku:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['sales:commodity-sku:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="sku_id" align="center" prop="id" />
      <el-table-column label="商品id" align="center" prop="commodityId" />
      <el-table-column label="发货单id" align="center" prop="shippingOrderInfoId" />
      <el-table-column label="进货单id" align="center" prop="stockManagementId" />
      <el-table-column label="会员VIP_Id" align="center" prop="vipId" />
      <el-table-column label="sku编号" align="center" prop="skuCode" />
      <el-table-column label="上货批次" align="center" prop="batch" />
      <el-table-column label="可销售数量" align="center" prop="availableNum" />
      <el-table-column label="可销售重量" align="center" prop="availableWeight" />
      <el-table-column label="单位数量" align="center" prop="specNum" />
      <el-table-column label="规格单位 字典" align="center" prop="weightUnit" />
      <el-table-column label="包装单位 字典" align="center" prop="packageUnit" />
      <el-table-column label="批发价格" align="center" prop="wholesalePrice" />
      <el-table-column label="零售价格" align="center" prop="retailPrice" />
      <el-table-column label="是否追溯 0-否 1-是" align="center" prop="traceStatus" />
      <el-table-column label="是否上架 0下架 1上架2禁售" align="center" prop="saleState" />
      <el-table-column label="货品标签 0新品、1应季、2推荐、3尾货拼团、4扶贫集采" align="center" prop="tag" />
      <el-table-column label="经营主体id" align="center" prop="subjectId" />
      <el-table-column label="销售单位 字典" align="center" prop="saleUnit" />
      <el-table-column label="规格单位" align="center" prop="specName" />
      <el-table-column label="追溯批次" align="center" prop="traceBatch" />
      <el-table-column label="溯源状态 10货单溯源 20自有溯源" align="center" prop="traceType" />
      <el-table-column label="溯源地址" align="center" prop="traceAddress" />
      <el-table-column label="产地/联系人名称" align="center" prop="traceContact" />
      <el-table-column label="联系方式" align="center" prop="tracePhone" />
      <el-table-column label="上游企业名称" align="center" prop="traceEnterName" />
      <el-table-column label="上游统一信用代码/身份证号" align="center" prop="traceLicense" />
      <el-table-column label="车牌号" align="center" prop="carCode" />
      <el-table-column label="浙食链报备id" align="center" prop="zslRecordId" />
      <el-table-column label="摊位号" align="center" prop="boothNo" />
      <el-table-column label="摊位号" align="center" prop="boothNo" />
      <el-table-column label="溯源纬度" align="center" prop="latitude" />
      <el-table-column label="溯源经度" align="center" prop="longitude" />
      <el-table-column label="商户id" align="center" prop="merchantId" />
      <el-table-column label="收货地址" align="center" prop="address" />
      <el-table-column label="到货时间" align="center" prop="arriveDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.arriveDate) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="商品规格id" align="center" prop="productSpecificationsId" />
      <el-table-column label="增加方式 0-货单上架 1-手工上架" align="center" prop="addType" />
      <el-table-column label="销售类型 0-自营 1-代售 2-合营" align="center" prop="sellType" />
      <el-table-column label="供应商id" align="center" prop="providerId" />
      <el-table-column label="原供应商id,商品来源商户" align="center" prop="oldProviderId" />
      <el-table-column label="来源sku id" align="center" prop="sourceSkuId" />
      <el-table-column label="公示单价" align="center" prop="publicityPrice" />
      <el-table-column label="包装类型 字典" align="center" prop="packingType" />
      <el-table-column label="库存类型 0弱库存 1强库存" align="center" prop="stockType" />
      <el-table-column label="货款" align="center" prop="goodsPrice" />
      <el-table-column label="售出价格" align="center" prop="sellingPrice" />
      <el-table-column label="采购价格" align="center" prop="purchasePrice" />
      <el-table-column label="上架数量" align="center" prop="addNum" />
      <el-table-column label="重量" align="center" prop="weight" />
      <el-table-column label="plu编号" align="center" prop="pluCode" />
      <el-table-column label="osCommodity_sku_thumbnail" align="center" prop="oscommoditySkuThumbnail" />
      <el-table-column label="personnel_info_slideshow" align="center" prop="personnelInfoSlideshow" />
      <el-table-column label="personnel_info_details_figure" align="center" prop="personnelInfoDetailsFigure" />
      <el-table-column label="等级" align="center" prop="grade" />
      <el-table-column label="创建的用户id" align="center" prop="createId" />
      <el-table-column label="商户端商品的标签" align="center" prop="businessSellerTag" />
      <el-table-column label="商品描述" align="center" prop="content" />
      <el-table-column label="检疫证明图片" align="center" prop="quarantineImgs" />
      <el-table-column label="包装名称" align="center" prop="packagingName" />
      <el-table-column label="销售单位名称" align="center" prop="saleUnitName" />
      <el-table-column label="每人限购数量" align="center" prop="availablePersonnel" />
      <el-table-column label="商品类型，1为农资商场" align="center" prop="commodityType" />
      <el-table-column label="溯源" align="center" prop="tracea" />
      <el-table-column label="食材" align="center" prop="ingredients" />
      <el-table-column label="烹饪方法" align="center" prop="cookingMethod" />
      <el-table-column label="商品规格" align="center" prop="specificationsName" />
      <el-table-column label="收藏数量" align="center" prop="collectNum" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['sales:commodity-sku:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['sales:commodity-sku:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品id" prop="commodityId">
          <el-input v-model="form.commodityId" placeholder="请输入商品id" />
        </el-form-item>
        <el-form-item label="发货单id" prop="shippingOrderInfoId">
          <el-input v-model="form.shippingOrderInfoId" placeholder="请输入发货单id" />
        </el-form-item>
        <el-form-item label="进货单id" prop="stockManagementId">
          <el-input v-model="form.stockManagementId" placeholder="请输入进货单id" />
        </el-form-item>
        <el-form-item label="会员VIP_Id" prop="vipId">
          <el-input v-model="form.vipId" placeholder="请输入会员VIP_Id" />
        </el-form-item>
        <el-form-item label="sku编号" prop="skuCode">
          <el-input v-model="form.skuCode" placeholder="请输入sku编号" />
        </el-form-item>
        <el-form-item label="上货批次" prop="batch">
          <el-input v-model="form.batch" placeholder="请输入上货批次" />
        </el-form-item>
        <el-form-item label="可销售数量" prop="availableNum">
          <el-input v-model="form.availableNum" placeholder="请输入可销售数量" />
        </el-form-item>
        <el-form-item label="可销售重量" prop="availableWeight">
          <el-input v-model="form.availableWeight" placeholder="请输入可销售重量" />
        </el-form-item>
        <el-form-item label="单位数量" prop="specNum">
          <el-input v-model="form.specNum" placeholder="请输入单位数量" />
        </el-form-item>
        <el-form-item label="规格单位 字典" prop="weightUnit">
          <el-input v-model="form.weightUnit" placeholder="请输入规格单位 字典" />
        </el-form-item>
        <el-form-item label="包装单位 字典" prop="packageUnit">
          <el-input v-model="form.packageUnit" placeholder="请输入包装单位 字典" />
        </el-form-item>
        <el-form-item label="批发价格" prop="wholesalePrice">
          <el-input v-model="form.wholesalePrice" placeholder="请输入批发价格" />
        </el-form-item>
        <el-form-item label="零售价格" prop="retailPrice">
          <el-input v-model="form.retailPrice" placeholder="请输入零售价格" />
        </el-form-item>
        <el-form-item label="是否追溯 0-否 1-是" prop="traceStatus">
          <el-radio-group v-model="form.traceStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否上架 0下架 1上架2禁售" prop="saleState">
          <el-input v-model="form.saleState" placeholder="请输入是否上架 0下架 1上架2禁售" />
        </el-form-item>
        <el-form-item label="货品标签 0新品、1应季、2推荐、3尾货拼团、4扶贫集采" prop="tag">
          <el-input v-model="form.tag" placeholder="请输入货品标签 0新品、1应季、2推荐、3尾货拼团、4扶贫集采" />
        </el-form-item>
        <el-form-item label="经营主体id" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体id" />
        </el-form-item>
        <el-form-item label="销售单位 字典" prop="saleUnit">
          <el-input v-model="form.saleUnit" placeholder="请输入销售单位 字典" />
        </el-form-item>
        <el-form-item label="规格单位" prop="specName">
          <el-input v-model="form.specName" placeholder="请输入规格单位" />
        </el-form-item>
        <el-form-item label="追溯批次" prop="traceBatch">
          <el-input v-model="form.traceBatch" placeholder="请输入追溯批次" />
        </el-form-item>
        <el-form-item label="溯源状态 10货单溯源 20自有溯源" prop="traceType">
          <el-select v-model="form.traceType" placeholder="请选择溯源状态 10货单溯源 20自有溯源">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="溯源地址" prop="traceAddress">
          <el-input v-model="form.traceAddress" placeholder="请输入溯源地址" />
        </el-form-item>
        <el-form-item label="产地/联系人名称" prop="traceContact">
          <el-input v-model="form.traceContact" placeholder="请输入产地/联系人名称" />
        </el-form-item>
        <el-form-item label="联系方式" prop="tracePhone">
          <el-input v-model="form.tracePhone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="上游企业名称" prop="traceEnterName">
          <el-input v-model="form.traceEnterName" placeholder="请输入上游企业名称" />
        </el-form-item>
        <el-form-item label="上游统一信用代码/身份证号" prop="traceLicense">
          <el-input v-model="form.traceLicense" placeholder="请输入上游统一信用代码/身份证号" />
        </el-form-item>
        <el-form-item label="车牌号" prop="carCode">
          <el-input v-model="form.carCode" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="浙食链报备id" prop="zslRecordId">
          <el-input v-model="form.zslRecordId" placeholder="请输入浙食链报备id" />
        </el-form-item>
        <el-form-item label="摊位号" prop="boothNo">
          <el-input v-model="form.boothNo" placeholder="请输入摊位号" />
        </el-form-item>
        <el-form-item label="摊位号" prop="boothNo">
          <el-input v-model="form.boothNo" placeholder="请输入摊位号" />
        </el-form-item>
        <el-form-item label="溯源纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入溯源纬度" />
        </el-form-item>
        <el-form-item label="溯源经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入溯源经度" />
        </el-form-item>
        <el-form-item label="商户id" prop="merchantId">
          <el-input v-model="form.merchantId" placeholder="请输入商户id" />
        </el-form-item>
        <el-form-item label="收货地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入收货地址" />
        </el-form-item>
        <el-form-item label="到货时间" prop="arriveDate">
          <el-date-picker clearable v-model="form.arriveDate" type="date" value-format="timestamp" placeholder="选择到货时间" />
        </el-form-item>
        <el-form-item label="商品规格id" prop="productSpecificationsId">
          <el-input v-model="form.productSpecificationsId" placeholder="请输入商品规格id" />
        </el-form-item>
        <el-form-item label="增加方式 0-货单上架 1-手工上架" prop="addType">
          <el-select v-model="form.addType" placeholder="请选择增加方式 0-货单上架 1-手工上架">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="销售类型 0-自营 1-代售 2-合营" prop="sellType">
          <el-select v-model="form.sellType" placeholder="请选择销售类型 0-自营 1-代售 2-合营">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="供应商id" prop="providerId">
          <el-input v-model="form.providerId" placeholder="请输入供应商id" />
        </el-form-item>
        <el-form-item label="原供应商id,商品来源商户" prop="oldProviderId">
          <el-input v-model="form.oldProviderId" placeholder="请输入原供应商id,商品来源商户" />
        </el-form-item>
        <el-form-item label="来源sku id" prop="sourceSkuId">
          <el-input v-model="form.sourceSkuId" placeholder="请输入来源sku id" />
        </el-form-item>
        <el-form-item label="公示单价" prop="publicityPrice">
          <el-input v-model="form.publicityPrice" placeholder="请输入公示单价" />
        </el-form-item>
        <el-form-item label="包装类型 字典" prop="packingType">
          <el-select v-model="form.packingType" placeholder="请选择包装类型 字典">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="库存类型 0弱库存 1强库存" prop="stockType">
          <el-select v-model="form.stockType" placeholder="请选择库存类型 0弱库存 1强库存">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="货款" prop="goodsPrice">
          <el-input v-model="form.goodsPrice" placeholder="请输入货款" />
        </el-form-item>
        <el-form-item label="售出价格" prop="sellingPrice">
          <el-input v-model="form.sellingPrice" placeholder="请输入售出价格" />
        </el-form-item>
        <el-form-item label="采购价格" prop="purchasePrice">
          <el-input v-model="form.purchasePrice" placeholder="请输入采购价格" />
        </el-form-item>
        <el-form-item label="上架数量" prop="addNum">
          <el-input v-model="form.addNum" placeholder="请输入上架数量" />
        </el-form-item>
        <el-form-item label="重量" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入重量" />
        </el-form-item>
        <el-form-item label="plu编号" prop="pluCode">
          <el-input v-model="form.pluCode" placeholder="请输入plu编号" />
        </el-form-item>
        <el-form-item label="osCommodity_sku_thumbnail" prop="oscommoditySkuThumbnail">
          <el-input v-model="form.oscommoditySkuThumbnail" placeholder="请输入osCommodity_sku_thumbnail" />
        </el-form-item>
        <el-form-item label="personnel_info_slideshow" prop="personnelInfoSlideshow">
          <el-input v-model="form.personnelInfoSlideshow" placeholder="请输入personnel_info_slideshow" />
        </el-form-item>
        <el-form-item label="personnel_info_details_figure" prop="personnelInfoDetailsFigure">
          <el-input v-model="form.personnelInfoDetailsFigure" placeholder="请输入personnel_info_details_figure" />
        </el-form-item>
        <el-form-item label="等级" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入等级" />
        </el-form-item>
        <el-form-item label="创建的用户id" prop="createId">
          <el-input v-model="form.createId" placeholder="请输入创建的用户id" />
        </el-form-item>
        <el-form-item label="商户端商品的标签" prop="businessSellerTag">
          <el-input v-model="form.businessSellerTag" placeholder="请输入商户端商品的标签" />
        </el-form-item>
        <el-form-item label="商品描述">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="检疫证明图片" prop="quarantineImgs">
          <el-input v-model="form.quarantineImgs" placeholder="请输入检疫证明图片" />
        </el-form-item>
        <el-form-item label="包装名称" prop="packagingName">
          <el-input v-model="form.packagingName" placeholder="请输入包装名称" />
        </el-form-item>
        <el-form-item label="销售单位名称" prop="saleUnitName">
          <el-input v-model="form.saleUnitName" placeholder="请输入销售单位名称" />
        </el-form-item>
        <el-form-item label="每人限购数量" prop="availablePersonnel">
          <el-input v-model="form.availablePersonnel" placeholder="请输入每人限购数量" />
        </el-form-item>
        <el-form-item label="商品类型，1为农资商场" prop="commodityType">
          <el-select v-model="form.commodityType" placeholder="请选择商品类型，1为农资商场">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="溯源" prop="tracea">
          <el-input v-model="form.tracea" placeholder="请输入溯源" />
        </el-form-item>
        <el-form-item label="食材" prop="ingredients">
          <el-input v-model="form.ingredients" placeholder="请输入食材" />
        </el-form-item>
        <el-form-item label="烹饪方法" prop="cookingMethod">
          <el-input v-model="form.cookingMethod" placeholder="请输入烹饪方法" />
        </el-form-item>
        <el-form-item label="商品规格" prop="specificationsName">
          <el-input v-model="form.specificationsName" placeholder="请输入商品规格" />
        </el-form-item>
        <el-form-item label="收藏数量" prop="collectNum">
          <el-input v-model="form.collectNum" placeholder="请输入收藏数量" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
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
import { createCommoditySku, updateCommoditySku, deleteCommoditySku, getCommoditySku, getCommoditySkuPage, exportCommoditySkuExcel } from "@/api/sales/commoditySku";
import Editor from '@/components/Editor';

export default {
  name: "CommoditySku",
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
      // 商品sku列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        commodityId: null,
        shippingOrderInfoId: null,
        stockManagementId: null,
        vipId: null,
        skuCode: null,
        batch: null,
        availableNum: null,
        availableWeight: null,
        specNum: null,
        weightUnit: null,
        packageUnit: null,
        wholesalePrice: null,
        retailPrice: null,
        traceStatus: null,
        saleState: null,
        tag: null,
        subjectId: null,
        saleUnit: null,
        specName: null,
        traceBatch: null,
        traceType: null,
        traceAddress: null,
        traceContact: null,
        tracePhone: null,
        traceEnterName: null,
        traceLicense: null,
        carCode: null,
        zslRecordId: null,
        boothNo: null,
        boothNo: null,
        latitude: null,
        longitude: null,
        merchantId: null,
        address: null,
        arriveDate: [],
        productSpecificationsId: null,
        addType: null,
        sellType: null,
        providerId: null,
        oldProviderId: null,
        sourceSkuId: null,
        publicityPrice: null,
        packingType: null,
        stockType: null,
        goodsPrice: null,
        sellingPrice: null,
        purchasePrice: null,
        addNum: null,
        weight: null,
        pluCode: null,
        oscommoditySkuThumbnail: null,
        personnelInfoSlideshow: null,
        personnelInfoDetailsFigure: null,
        grade: null,
        createId: null,
        businessSellerTag: null,
        content: null,
        quarantineImgs: null,
        packagingName: null,
        saleUnitName: null,
        availablePersonnel: null,
        commodityType: null,
        tracea: null,
        ingredients: null,
        cookingMethod: null,
        specificationsName: null,
        collectNum: null,
        status: null,
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
      getCommoditySkuPage(this.queryParams).then(response => {
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
        commodityId: undefined,
        shippingOrderInfoId: undefined,
        stockManagementId: undefined,
        vipId: undefined,
        skuCode: undefined,
        batch: undefined,
        availableNum: undefined,
        availableWeight: undefined,
        specNum: undefined,
        weightUnit: undefined,
        packageUnit: undefined,
        wholesalePrice: undefined,
        retailPrice: undefined,
        traceStatus: undefined,
        saleState: undefined,
        tag: undefined,
        subjectId: undefined,
        saleUnit: undefined,
        specName: undefined,
        traceBatch: undefined,
        traceType: undefined,
        traceAddress: undefined,
        traceContact: undefined,
        tracePhone: undefined,
        traceEnterName: undefined,
        traceLicense: undefined,
        carCode: undefined,
        zslRecordId: undefined,
        boothNo: undefined,
        boothNo: undefined,
        latitude: undefined,
        longitude: undefined,
        merchantId: undefined,
        address: undefined,
        arriveDate: undefined,
        productSpecificationsId: undefined,
        addType: undefined,
        sellType: undefined,
        providerId: undefined,
        oldProviderId: undefined,
        sourceSkuId: undefined,
        publicityPrice: undefined,
        packingType: undefined,
        stockType: undefined,
        goodsPrice: undefined,
        sellingPrice: undefined,
        purchasePrice: undefined,
        addNum: undefined,
        weight: undefined,
        pluCode: undefined,
        oscommoditySkuThumbnail: undefined,
        personnelInfoSlideshow: undefined,
        personnelInfoDetailsFigure: undefined,
        grade: undefined,
        createId: undefined,
        businessSellerTag: undefined,
        content: undefined,
        quarantineImgs: undefined,
        packagingName: undefined,
        saleUnitName: undefined,
        availablePersonnel: undefined,
        commodityType: undefined,
        tracea: undefined,
        ingredients: undefined,
        cookingMethod: undefined,
        specificationsName: undefined,
        collectNum: undefined,
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
      this.title = "添加商品sku";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getCommoditySku(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品sku";
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
          updateCommoditySku(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createCommoditySku(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除商品sku编号为"' + id + '"的数据项?').then(function() {
          return deleteCommoditySku(id);
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
      this.$modal.confirm('是否确认导出所有商品sku数据项?').then(() => {
          this.exportLoading = true;
          return exportCommoditySkuExcel(params);
        }).then(response => {
          this.$download.excel(response, '商品sku.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
