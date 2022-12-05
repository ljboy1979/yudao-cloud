<template>
    <div class="app-container">
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="订单编号" align="center" prop="id" />
            <el-table-column label="下单时间" align="center" prop="nickname" />
            <el-table-column label="订单总额" align="center" prop="avatar" />
            <el-table-column label="售品名称" align="center" prop="status" />
            <el-table-column label="优惠活动" align="center" prop="mobile" />
            <el-table-column label="订单状态" align="center" prop="password" />
        </el-table>
        <!-- 分页组件 -->
        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
            @pagination="getList" />
    </div>
</template>
<script>
export default {
    name: 'salesTransaction',
    props: {
        id: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            // 遮罩层
            // loading: true,
            loading: false,
            // 总条数
            // total: 0,
            total: 1,
            list: [],
            // 查询参数
            queryParams: {
                pageNo: 1,
                pageSize: 10,
            },
        }
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询列表 */
        getList() {
            // this.loading = true;
            // 执行查询
            // XXXX(this.queryParams).then(response => {
            //     this.list = response.data.list;
            //     this.total = response.data.total;
            //     this.loading = false;
            // });
        },
    }
}
</script>
<style scoped>
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}
</style>