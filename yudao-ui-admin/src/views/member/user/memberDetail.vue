<template>
    <div class="app-container">

        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
            <el-tab-pane label="基本信息" name="first">
                <div class="title">基本信息</div>
                <el-form :model="userInfo" label-width="200px" ref="userInfo" class="info" label-position="left">
                    <el-form-item label="会员账号">{{ userInfo.memberAccount }}</el-form-item>
                    <el-form-item label="会员名称">{{ userInfo.nickname }}</el-form-item>
                    <el-form-item label="微信号">{{ }}</el-form-item>
                    <el-form-item label="手机号">{{ userInfo.mobile }}</el-form-item>
                    <el-form-item label="住院号/员工卡号">{{ }}</el-form-item>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="企业资料" name="second">
                <div class="title">企业基本信息</div>
                <el-form :model="baseInfo" label-width="200px" ref="baseInfo" class="info" label-position="left">
                    <el-form-item label="企业名称">{{ baseInfo.name }}</el-form-item>
                    <el-form-item label="主体类型">
                        <dict-tag :type="DICT_TYPE.ENTERPRISE_TYPE" :value="baseInfo.enterpriseType" />
                    </el-form-item>
                    <el-form-item label="产业角色">{{ baseInfo.userTagName }}</el-form-item>
                    <el-form-item label="地址">{{ baseInfo.address }}</el-form-item>
                    <el-form-item label="证件照片">
                        <div v-for="(item, index) in baseInfo.businessLicensePhoto" :key="index"
                            style="display: inline; margin: 0 10px;">
                            <!-- <img :src="item" alt="证件照片" style="height: 100px" /> -->
                            <el-image :src="item" alt="证件照片" style="height: 100px" :preview-src-list="baseInfo.businessLicensePhoto"/>
                        </div>
                    </el-form-item>
                    <el-form-item label="经营许可证号码">{{ baseInfo.businessLicenseNo }}</el-form-item>
                    <el-form-item label="统一社会信用代码或注册号">{{ baseInfo.socialCreditCode }}</el-form-item>
                </el-form>
                <div class="title">企业其他信息</div>
                <el-form :model="baseInfo" label-width="200px" ref="ruleForm" class="info" label-position="left">
                    <el-form-item label="主营业务">{{ baseInfo.serviceRange }}</el-form-item>
                    <el-form-item label="企业规模">
                        <dict-tag :type="DICT_TYPE.ENTERPRISE_SCALE" :value="baseInfo.enterpriseScale" />
                    </el-form-item>
                    <el-form-item label="企业介绍">
                        <div class="editor"></div>
                    </el-form-item>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="专业资质" name="ProfessionalQualification">
                <div class="title">专业资质</div>
                <ProfessionalQualification :id="userid" v-if="activeName == 'ProfessionalQualification'">
                </ProfessionalQualification>
            </el-tab-pane>
            <el-tab-pane label="售品交易记录" name="salesTransaction">
                <div class="title">售品交易记录</div>
                <salesTransaction :id="userid" v-if="activeName == 'salesTransaction'"></salesTransaction>
            </el-tab-pane>
            <el-tab-pane label="服务交易记录" name="serviceTransaction">
                <div class="title">服务交易记录</div>
                <serviceTransaction :id="userid" v-if="activeName == 'serviceTransaction'"></serviceTransaction>
            </el-tab-pane>
            <el-tab-pane label="进出记录" name="passInAndOutRecord">
                <div class="title">进出记录</div>
                <passInAndOutRecord :id="userid" v-if="activeName == 'passInAndOutRecord'"></passInAndOutRecord>
            </el-tab-pane>
            <el-tab-pane label="会员积分记录" name="integralRecord">
                <div class="title">会员积分记录</div>
                <integralRecord :id="userid" v-if="activeName == 'integralRecord'">
                </integralRecord>
            </el-tab-pane>
            <el-tab-pane label="健康档案" name="PatientHealth">
                <div class="title">健康档案</div>
                <el-select v-model="options" placeholder="请选择会员角色" size="small" style="margin: 20px 20px 0;">
                    <el-option label="常规信息" value="0" />
                    <el-option label="住院记录" value="1" />
                    <el-option label="营养检查记录" value="2" />
                    <el-option label="处方记录" value="3" />
                    <el-option label="医嘱记录" value="4" />
                    <el-option label="特医食品使用记录" value="5" />
                    <el-option label="病史记录" value="6" />
                    <el-option label="其它" value="7" />
                </el-select>
                <PatientHealth :id="userid" v-if="options == 0" @givePatientHealthId="getPatientHealthId" ></PatientHealth>
                <HospitalAdmissionRecord :id="patientHealthId" v-if="options == 1"></HospitalAdmissionRecord>
                <NutritionExaminationRecord :id="patientHealthId" v-if="options == 2"></NutritionExaminationRecord>
                <PrescriptionRecord :id="patientHealthId" v-if="options == 3"></PrescriptionRecord>
                <MedicalRecord :id="patientHealthId" v-if="options == 4"></MedicalRecord>
                <SpecialMedicalFoodRecords :id="patientHealthId" v-if="options == 5"></SpecialMedicalFoodRecords>
                <MedicalHistoryRecord :id="patientHealthId" v-if="options == 6"></MedicalHistoryRecord>
            </el-tab-pane>
            <el-tab-pane label="代理商管理" name="agentManagement">
                <div class="title">代理商管理</div>
                <agentManagement :id="userid" v-if="activeName == 'agentManagement'"></agentManagement>
            </el-tab-pane>
            <el-tab-pane label="钱包交易记录" name="WalletTransactionHistory">
                <div class="title">钱包交易记录</div>
                <WalletTransactionHistory :id="userid" v-if="activeName == 'WalletTransactionHistory'">
                </WalletTransactionHistory>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
  
<script>
import { getUser, } from "@/api/member/user";
import { getBaseInfo, } from "@/api/enterprise/baseInfo";
import ProfessionalQualification from "../professionalQualification/index.vue"; //专业资质
import integralRecord from "../integralRecord/index.vue"; //会员积分记录
import agentManagement from "../agentManagement/index.vue"; //代理商管理
import PatientHealth from "../../patient/patientHealth/index.vue"; //常规信息
import HospitalAdmissionRecord from "../../patient/hospitalAdmissionRecord/index.vue"; //住院记录
import NutritionExaminationRecord from "../../patient/nutritionExaminationRecord/index.vue"; //营养检查记录
import PrescriptionRecord from "../../patient/prescriptionRecord/index.vue"; //处方记录
import MedicalRecord from "../../patient/medicalRecord/index.vue"; //医嘱记录
import SpecialMedicalFoodRecords from "../../patient/specialMedicalFoodRecords/index.vue"; //特医食品使用记录
import MedicalHistoryRecord from "../../patient/medicalHistoryRecord/index.vue"; //病史记录
import WalletTransactionHistory from "../user/componets/WalletTransactionHistory.vue"; //钱包交易记录
import passInAndOutRecord from "../user/componets/passInAndOutRecord.vue";
import salesTransaction from "../user/componets/salesTransaction.vue"
import serviceTransaction from "../user/componets/serviceTransaction.vue"
export default {
    name: "User",
    components: {
        ProfessionalQualification,
        integralRecord,
        agentManagement,
        PatientHealth,
        HospitalAdmissionRecord,
        NutritionExaminationRecord,
        PrescriptionRecord,
        MedicalRecord,
        SpecialMedicalFoodRecords,
        MedicalHistoryRecord,
        WalletTransactionHistory,
        passInAndOutRecord,

        serviceTransaction,
        salesTransaction
    },
    data() {
        return {
            //默认tab显示
            activeName: 'first',
            // userid: '',
            userid: '',
            patientHealthId: '',
            enterpriseId: '',
            userInfo: {},
            baseInfo: {},
            form: {},
            options: '0',
        };
    },
    created() {
        this.userid = this.$route.query.id
        //调接口获取会员信息
        this.getUserInfo()
    },
    methods: {
        getPatientHealthId(id){
            this.patientHealthId = id
        },
        //切换tab
        handleClick(tab, event) {
            // console.log(tab.index, event);
        },
        /** 基本信息 */
        getUserInfo() {
            const id = this.userid
            getUser(id).then(response => {
                this.userInfo = response.data;
                if (this.userInfo.enterpriseId != null) {
                    this.getBase(this.userInfo.enterpriseId)
                }
            });
        },
        getBase(id) {
            getBaseInfo(id).then(response => {
                this.baseInfo = response.data;
                this.baseInfo.businessLicensePhoto = response.data.businessLicensePhoto.split(',');
                document.getElementsByClassName('editor')[0].innerHTML = this.baseInfo.description
            });
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
    width: 60%;
}

.editor >>>pre{
  overflow: auto;
  white-space: pre-wrap;
  white-space: -moz-pre-wrap;
  white-space: -pre-wrap;
  white-space: -o-pre-wrap;
  word-wrap: break-word;
}
</style>
  