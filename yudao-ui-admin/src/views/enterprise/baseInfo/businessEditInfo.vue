<!--
  功能：初始化功能描述
  作者：luojinbo
  时间：2020.11.23
-->
<template>
    <div class='app-container'>
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="基本信息" name="businessInfo">
                <businessInfo :id="businessId"></businessInfo>
            </el-tab-pane>
            <!-- <el-tab-pane label="企业相关资料" name="businessRelatedInfo">
                <businessRelatedInfo :id="businessId" v-if="activeName == 'businessRelatedInfo'"></businessRelatedInfo>
            </el-tab-pane> -->
            <el-tab-pane label="其他账户" name="otherCertificateInfo">
                <otherCertificateInfo :id="businessId" v-if="activeName == 'otherCertificateInfo'"></otherCertificateInfo>
            </el-tab-pane>
            <el-tab-pane label="其他证件" name="otherAccountInfo">
                <otherAccountInfo :id="businessId" v-if="activeName == 'otherAccountInfo'"></otherAccountInfo>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
//import(导入)其他文件（如：组件，工具js，第三方插件js，json文件，图片文件等）
import businessInfo from "./businessInfo.vue"
import businessRelatedInfo from "./businessRelatedInfo.vue"
import otherCertificateInfo from "../../enterprise/otherCertificateInfo"
import otherAccountInfo from "../../enterprise/otherAccountInfo"

export default {
    /**注册组件*/
    components: { businessInfo, businessRelatedInfo, otherCertificateInfo, otherAccountInfo },
    /**接受父组件传值*/
    props: {},
    name: 'EditbusinessInfo',
    data() {
        return {
            activeName: 'businessInfo',
            businessId: ''
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
        }

    },
    /**创建组件时执行(有VM对象this)*/
    created() {
        console.log(this.$route.query.id, 'query')
        this.businessId=this.$route.query.id;
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
</style>