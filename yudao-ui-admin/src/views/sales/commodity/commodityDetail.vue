<!--
  功能：初始化功能描述
  作者：luojinbo
  时间：2020.11.18
-->
<template>
    <div class='app-container'>
        <div class="title">商品详情</div>
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
            <el-tab-pane label="商品详情" name="commoditydetail">
                <div class="item">
                    <div>商品编号</div>
                    <div>{{form.commodityCode}}</div>
                </div>
                <div class="item">
                    <div>商品名称</div>
                    <div>{{form.commodityName}}</div>
                </div>
                <div class="item">
                    <div>商品分类</div>
                    <div>{{form.commodityCode}}</div>
                </div>
                <div class="item">
                    <div>商品条码</div>
                    <div>{{form.commodityBarCode}}</div>
                </div>
                <div class="item">
                    <div>产地</div>
                    <div>{{form.productionAddress}}</div>
                </div>
                <div class="item">
                    <div>更新时间</div>
                    <div>{{form.createTime}}</div>
                </div>
                <div class="item">
                    <div>备注</div>
                    <div>{{form.commodityCode}}</div>
                </div>
                <div class="item">
                    <div>商品图片</div>
                    <div>{{form.commodityImg}}</div>
                </div>
            </el-tab-pane>
            <el-tab-pane label="商品规格" name="CommoditySpecification">
                <CommoditySpecification  :id="id" v-if="activeName == 'CommoditySpecification'"></CommoditySpecification>
            </el-tab-pane>
            <el-tab-pane label="商品组成" name="CommodityOrganization">
                <CommodityOrganization  :id="id" v-if="activeName == 'CommodityOrganization'"></CommodityOrganization>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
//import(导入)其他文件（如：组件，工具js，第三方插件js，json文件，图片文件等）
import{getCommodity} from "@/api/sales/commodity";
import CommoditySpecification from "../commoditySpecification/index.vue"
import CommodityOrganization from "../commodityOrganization/index.vue"
export default {
    /**注册组件*/
    components: {CommoditySpecification,CommodityOrganization},
    /**接受父组件传值*/
    props: {},
    name: 'commodityDetail',
    data() {
        return {
            activeName: 'commoditydetail',
            form:{},
            id:'',
        };
    },
    /**计算属性*/
    computed: {},
    /**监听data数据变化*/
    watch: {},
    /**所有方法*/
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        },
        getCommodityDetail(id){
            getCommodity(id).then(response => {
                console.log(response)
                this.form= response.data
            })
        }
    },
    /**创建组件时执行(有VM对象this)*/
    created() {
        console.log(this.$route.query.id)
        this.id=this.$route.query.id
        this.getCommodityDetail(this.$route.query.id)
    },
    /**加载完组件时执行(主要预处理数据)*/
    mounted() {

    },
    beforeCreate() {/**生命周期 - 创建之前*/ },
    beforeMount() {/**生命周期 - 挂载之前*/ },
    beforeUpdate() {/**生命周期 - 更新之前*/ },
    updated() {/**生命周期 - 更新之后*/ },
    beforeDestroy() {/**生命周期 - 销毁之前*/ },
    destroyed() {/**生命周期 - 销毁完成*/ },
    activated() {/**keep-alive组件激活时调用。仅针对keep-alive组件有效*/ },
    deactivated() {/**keep-alive组件停用时调用。仅针对keep-alive组件有效*/ },
}
</script>
<style scoped >
/* @import url(); 引入css类 */
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}
.item{
    font-size: 14px;
    display: flex;
    width: 20%;
    margin: 10px 15px;
    align-items: center;
    justify-content: space-between;
}
</style>