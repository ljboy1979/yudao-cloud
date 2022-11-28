<template>
    <div class="app-container">

        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
            <el-tab-pane label="基本信息" name="first">
                <div class="title">基本信息</div>
                <el-form :model="form" label-width="200px" ref="ruleForm" class="info" label-position="left">
                    <el-form-item label="会员账号" prop="">11111</el-form-item>
                    <el-form-item label="会员名称" prop=""></el-form-item>
                    <el-form-item label="微信号" prop=""></el-form-item>
                    <el-form-item label="手机号" prop=""></el-form-item>
                    <el-form-item label="住院号/员工卡号" prop=""></el-form-item>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="企业资料" name="second">
                <div class="title">企业基本信息</div>
                <el-form :model="form" label-width="200px" ref="ruleForm" class="info" label-position="left">
                    <el-form-item label="企业名称" prop="">11111</el-form-item>
                    <el-form-item label="经营模式" prop=""></el-form-item>
                    <el-form-item label="证件编号" prop=""></el-form-item>
                    <el-form-item label="产业角色" prop=""></el-form-item>
                    <el-form-item label="地址" prop=""></el-form-item>
                    <el-form-item label="证件照片" prop=""></el-form-item>
                    <el-form-item label="经营合格证号" prop=""></el-form-item>
                    <el-form-item label="社会信用代码" prop=""></el-form-item>
                </el-form>
                <div class="title">企业其他信息</div>
                <el-form :model="form" label-width="200px" ref="ruleForm" class="info" label-position="left">
                    <el-form-item label="主营业务" prop="">11111</el-form-item>
                    <el-form-item label="企业规模" prop=""></el-form-item>
                    <el-form-item label="企业介绍" prop=""></el-form-item>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="专业资质" name="ProfessionalQualification">
                <div class="title">专业资质</div>
                <ProfessionalQualification :id="userid" v-if="activeName=='ProfessionalQualification'"></ProfessionalQualification>
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
            <el-tab-pane label="会员积分记录" name="integralRecord">
                <div class="title">会员积分记录</div>
                <integralRecord :id="userid" v-if="activeName=='integralRecord'"></integralRecord>
            </el-tab-pane>
            <el-tab-pane label="健康档案" name="healthRecords">
                <healthRecords :id="userid" v-if="activeName=='healthRecords'"></healthRecords>
            </el-tab-pane>
            <el-tab-pane label="代理商管理" name="agentManagement">
                <div class="title">代理商管理</div>
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
import ProfessionalQualification from "../professionalQualification/index.vue";
import integralRecord from "../integralRecord/index.vue";
import agentManagement from "../agentManagement/index.vue";
import WalletTransactionHistory from "../user/componets/WalletTransactionHistory.vue";
import passInAndOutRecord from "../user/componets/passInAndOutRecord.vue";
import healthRecords from "../user/componets/healthRecords.vue";
import salesTransaction from "../user/componets/salesTransaction.vue"
import serviceTransaction from "../user/componets/serviceTransaction.vue"
export default {
    name: "User",
    components: {
        integralRecord,
        agentManagement,
        WalletTransactionHistory,
        passInAndOutRecord,
        ProfessionalQualification,
        healthRecords,
        serviceTransaction,
        salesTransaction
    },
    data() {
        return {
            //默认tab显示
            activeName: 'first',
            userid: '',
            form: {},
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
    margin: 10px 0 0 15px;
}

.info {
    font-size: 14px;
    margin: 15px 0 15px 15px;
}
</style>
  