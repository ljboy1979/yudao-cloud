<template>
    <div class="app-container">

        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
            <el-tab-pane label="基本信息" name="first">
                <div class="title">基本信息</div>
                <div class="info">会员账号</div>
                <div class="info">会员名称</div>
                <div class="info">微信号</div>
                <div class="info">手机号</div>
                <div class="info">住院号/员工卡号</div>
            </el-tab-pane>
            <el-tab-pane label="企业资料" name="second">
                <div class="title">企业基本信息</div>
                <div class="info">企业名称</div>
                <div class="info">经营模式</div>
                <div class="info">证件编号</div>
                <div class="info">产业角色</div>
                <div class="info">地址</div>
                <div class="info">证件照片</div>
                <div class="info">经营合格证号</div>
                <div class="info">社会信用代码</div>

                <div class="title">企业其他信息</div>
                <div class="info">主营业务</div>
                <div class="info">企业规模</div>
                <div class="info">企业介绍</div>
            </el-tab-pane>
            <el-tab-pane label="专业资质" name="professionalQualifications">
                <professionalQualifications :id="userid" v-if="activeName=='professionalQualifications'"></professionalQualifications>
            </el-tab-pane>
            <el-tab-pane label="售品交易记录" name="salesTransaction">
                <salesTransaction :id="userid" v-if="activeName=='salesTransaction'"></salesTransaction>
            </el-tab-pane>
            <el-tab-pane label="服务交易记录" name="serviceTransaction">
                <serviceTransaction :id="userid" v-if="activeName=='serviceTransaction'"></serviceTransaction>
            </el-tab-pane>
            <el-tab-pane label="进出记录" name="passInAndOutRecord">
                <passInAndOutRecord :id="userid" v-if="activeName=='passInAndOutRecord'"></passInAndOutRecord>
            </el-tab-pane>
            <el-tab-pane label="会员积分记录" name="memberPointsRecord">
                <memberPointsRecord :id="userid" v-if="activeName=='memberPointsRecord'"></memberPointsRecord>
            </el-tab-pane>
            <el-tab-pane label="健康档案" name="healthRecords">
                <healthRecords :id="userid" v-if="activeName=='healthRecords'"></healthRecords>
            </el-tab-pane>
            <el-tab-pane label="代理商管理" name="agentManagement">
                <agentManagement :id="userid" v-if="activeName=='agentManagement'"></agentManagement>
            </el-tab-pane>
            <el-tab-pane label="钱包交易记录" name="WalletTransactionHistory">
                <WalletTransactionHistory :id="userid" v-if="activeName =='WalletTransactionHistory'"></WalletTransactionHistory>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
  
<script>
import { createUser, updateUser, deleteUser, getUser, getUserPage, exportUserExcel } from "@/api/member/user";
import memberPointsRecord from "../user/componets/memberPointsRecord.vue";
import agentManagement from "../user/componets/agentManagement.vue";
import WalletTransactionHistory from "../user/componets/WalletTransactionHistory.vue";
import passInAndOutRecord from "../user/componets/passInAndOutRecord.vue";
import professionalQualifications from "../user/componets/professionalQualifications.vue";
import healthRecords from "../user/componets/healthRecords.vue";
import salesTransaction from "../user/componets/salesTransaction.vue"
import serviceTransaction from "../user/componets/serviceTransaction.vue"
export default {
    name: "User",
    components: {
        memberPointsRecord,
        agentManagement,
        WalletTransactionHistory,
        passInAndOutRecord,
        professionalQualifications,
        healthRecords,
        serviceTransaction,
        salesTransaction
    },
    data() {
        return {
            //默认tab显示
            activeName: 'first',
            userid: '',
        };
    },
    created() {
        console.log(this.$route.query.id, 'query')
        this.userid = this.$route.query.id
        //调接口获取会员信息
    },
    methods: {
        //切换tab
        handleClick(tab, event) {
            console.log(tab.index, event);
        },
    }
};
</script>
<style scoped>
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}

.info {
    font-size: 14px;
    margin: 15px 0 15px 15px;
}
</style>
  