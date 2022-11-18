<template>
    <div>
        <div class="title">钱包交易记录</div>
        <el-date-picker v-model="CheckDate" type="daterange" range-separator="至" start-placeholder="开始日期"
            end-placeholder="结束日期">
        </el-date-picker>
        <el-button style="margin-left: 15px;" type="primary" icon="el-icon-search" @click="handleQuery">搜索
        </el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">导出</el-button>
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="交易单号" align="center" prop="id" />
            <el-table-column label="交易类型" align="center" prop="nickname" />
            <el-table-column label="交易方式" align="center" prop="avatar" />
            <el-table-column label="交易时间" align="center" prop="status" />
            <el-table-column label="售品名称" align="center" prop="mobile" />
            <el-table-column label="交易金额" align="center" prop="mobile" />
            <el-table-column label="支付账户" align="center" prop="password" />
            <el-table-column label="收款账户" align="center" prop="mobile" />
            <el-table-column label="交易对象名称" align="center" prop="mobile" />
            <el-table-column label="交易状态" align="center" prop="password" />
        </el-table>
    </div>
</template>

<script>
    export default{
        name: "User",
        data() {
        return {
            //加载
            loading: false,
            //列表数据
            list:[],
            //日期
            CheckDate:'',
        }
    },
    created() {

    },
    methods:{
        handleQuery(){

        },
        resetQuery(){

        },
    }
    }

</script>

<style scoped>
.title{
    font-size: 24px;
    margin: 10px 0 20px 15px; 
}
</style>