<!--
  功能：初始化功能描述
  作者：luojinbo
  时间：2020.11.23
-->
<template>
    <div class='app-container'>
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="基本信息" name="businessInfo">
                <businessInfo :id="userid"></businessInfo>
            </el-tab-pane>
            <el-tab-pane label="企业相关资料" name="businessRelatedInfo">
                <businessRelatedInfo :id="userid" v-if="activeName=='businessRelatedInfo'"></businessRelatedInfo>
            </el-tab-pane>
            <!-- <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
            <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane> -->
        </el-tabs>
    </div>
</template>
<script>
//import(导入)其他文件（如：组件，工具js，第三方插件js，json文件，图片文件等）
import businessInfo from "./businessInfo.vue"
import businessRelatedInfo from "./businessRelatedInfo.vue"
export default {
    /**注册组件*/
    components: {businessInfo,businessRelatedInfo},
    /**接受父组件传值*/
    props: {},
    name: 'EditbusinessInfo',
    data() {
        return {
            activeName: 'businessInfo',
            userid:''
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