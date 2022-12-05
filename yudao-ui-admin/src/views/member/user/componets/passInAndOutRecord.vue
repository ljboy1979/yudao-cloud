<template>
    <div class="app-container">
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="会员名称" align="center" prop="id" />
            <el-table-column label="设备号" align="center" prop="nickname" />
            <el-table-column label="进场时间" align="center" prop="avatar" />
            <el-table-column label="出厂时间" align="center" prop="status" />
        </el-table>
        <!-- 分页组件 -->
        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
            @pagination="getList" />
    </div>
</template>
<script>
export default {
    name: 'passInAndOutRecord',
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
            list: [{id:"1"}],
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