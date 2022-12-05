<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
            label-width="68px">
            <el-form-item prop="createTime">
                <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
                    type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
                    :default-time="['00:00:00', '23:59:59']" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
                <el-button type="primary" plain icon="el-icon-download" @click="handleExport" :loading="exportLoading"
                    v-hasPermi="['']">导出</el-button>
            </el-form-item>
        </el-form>
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="交易单号" align="center" prop="transactionNumber" />
            <el-table-column label="交易类型" align="center" prop="transactionType">
                <template v-slot="scope">
                    <dict-tag :type="DICT_TYPE.WALLET_TRANSACTION_TYPE" :value="scope.row.transactionType" />
                </template>
            </el-table-column>
            <el-table-column label="交易方式" align="center" prop="payType">
                <template v-slot="scope">
                    <dict-tag :type="DICT_TYPE.WALLET_PAY_TYPE" :value="scope.row.payType" />
                </template>
            </el-table-column>
            <el-table-column label="创建时间" align="center" prop="transactionTime" width="180">
                <template slot-scope="scope">
                    <span>{{ parseTime(scope.row.transactionTime) }}</span>
                </template>
            </el-table-column>
            <el-table-column label="售品名称" align="center" prop="transactionContent" />
            <el-table-column label="交易金额" align="center" prop="amount" />
            <el-table-column label="支付账户" align="center" prop="paymentAccountNumber" />
            <el-table-column label="收款账户" align="center" prop="payoutAccount" />
            <el-table-column label="交易对象名称" align="center" prop="recipient" />
            <el-table-column label="交易状态" align="center" prop="transactionStatus">
                <template v-slot="scope">
                    <dict-tag :type="DICT_TYPE.WALLET_TRANSACTION_STATUS" :value="scope.row.transactionStatus" />
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页组件 -->
        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
            @pagination="getList" />
    </div>
</template>

<script>
import { getWalletPage, exportWalletExcel } from "@/api/member/user";
export default {
    name: "User",
    props: {
        id: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            //加载
            loading: true,
            // 导出遮罩层
            exportLoading: false,
            // 显示搜索条件
            showSearch: true,
            // 总条数
            total: 1,
            //列表数据
            list: [],
            // 查询参数
            queryParams: {
                pageNo: 1,
                pageSize: 10,
                memberId: this.id,
                createTime: [],
            },
        }
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询列表 */
        getList() {
            this.loading = true;
            //执行查询
            getWalletPage(this.queryParams).then(response => {
                this.list = response.data.list;
                this.total = response.data.total;
                this.loading = false;
            });
        },
        handleQuery() {
            this.queryParams.pageNo = 1;
            this.getList();
        },
        resetQuery() {
            this.resetForm("queryForm");
            this.handleQuery();

        },
        /** 导出按钮操作 */
        handleExport() {
            // 处理查询参数
            let params = { ...this.queryParams };
            params.pageNo = undefined;
            params.pageSize = undefined;
            this.$modal.confirm('是否确认导出所有钱包交易记录数据项?').then(() => {
                this.exportLoading = true;
                return exportWalletExcel(params);
            }).then(response => {
                this.$download.excel(response, '钱包交易记录.xls');
                this.exportLoading = false;
            }).catch(() => { });
        }
    }
}


</script>