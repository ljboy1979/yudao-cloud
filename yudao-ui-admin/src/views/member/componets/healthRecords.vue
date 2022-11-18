<!--
  功能：初始化功能描述
  作者：luojinbo
  时间：2020.11.18
-->
<template>
    <div class='app-container'>
        <div class="title">健康档案</div>
        <el-select v-model="value" placeholder="请选择">
            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <el-table v-loading="loading" :data="list" stripe>
      <el-table-column label="健康档案" align="center" prop="id" />
      <el-table-column label="健康档案" align="center" prop="nickname" />
      <el-table-column label="健康档案" align="center" prop="avatar" />
      <el-table-column label="健康档案" align="center" prop="status" />
      <el-table-column label="健康档案" align="center" prop="mobile" />
      <el-table-column label="健康档案" align="center" prop="password" />
      <el-table-column label="健康档案" align="center" prop="registerIp" />
      <el-table-column label="健康档案" align="center" prop="loginIp" />
    </el-table>
        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
            @pagination="getList" />
    </div>
</template>
<script>
//import(导入)其他文件（如：组件，工具js，第三方插件js，json文件，图片文件等）

export default {
    /**注册组件*/
    components: {},
    /**接受父组件传值*/
    props: {
        id: {
            type: String,
            required: true
        }
    },
    name: 'healthRecords',
    data() {
        return {
            //是否显示加载动画
            loading: false,
            //列表条数
            total: 0,
            //查询参数
            queryParams: { pageNo: 1, pageSize: 1 },
            //下拉选择框
            options: [{
                value: '选项1',
                label: '常规信息',
            }, {
                value: '选项2',
                label: '住院记录'
            }, {
                value: '选项3',
                label: '营养检查记录'
            }, {
                value: '选项4',
                label: '处方记录'
            }, {
                value: '选项5',
                label: '医嘱记录'
            },
            {
                value: '选项6',
                label: '特医食品使用记录'
            },
            {
                value: '选项7',
                label: '病史记录'
            },
            {
                value: '选项8',
                label: '其他'
            }],
            list: [],
            value:'',
        };
    },
    /**计算属性*/
    computed: {},
    /**监听data数据变化*/
    watch: {},
    /**所有方法*/
    methods: {
        getList() {
            // this.loading = true;
            // 执行查询
            // XXXX(this.queryParams).then(response => {
            //     this.list = response.data.list;
            //     this.total = response.data.total;
            //     this.loading = false;
            // });
        },

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
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}
</style>