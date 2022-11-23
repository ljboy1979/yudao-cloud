<template>
    <div class="app-container">
        <div class="title">代理商管理</div>
        <el-input style="width: 150px;" v-model="input" placeholder="请输入内容"></el-input>
        <el-button style="margin-left: 15px;" type="primary" icon="el-icon-search" @click="handleQuery">搜索
        </el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="代理商名称" align="center" prop="id" />
            <el-table-column label="行政区域" align="center" prop="nickname" />
            <el-table-column label="手机号" align="center" prop="avatar" />
            <el-table-column label="地址" align="center" prop="status" />
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                        v-hasPermi="['member:user:update']">编辑</el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                        v-hasPermi="['member:user:delete']">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页组件 -->
        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
            @pagination="getList" />
    </div>
</template>
<script>
export default {
    name: 'agentManagement',
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
            input: "",
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
        console.log(this.id)
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
        handleQuery() {

        },
        handleUpdate() {

        },
        handleDelete() {

        },
        //
        resetQuery() {

        }
    }
}
</script>
<style scoped>
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}
</style>