<template>
  <div class="app-container">

    <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
      <el-tab-pane label="企业信息" name="first">
        <div class="title">企业信息
          <el-button type="primary" size="mini" @click="gotoEdit">编辑</el-button>
        </div>
        <div class="subtitle">基本信息</div>
        <el-form :model="ruleForm" label-width="200px" ref="ruleForm" class="demo-ruleForm" label-position="left">
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="主体编号" prop="code">{{ ruleForm.code }}</el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="主体名称" prop="name">{{ ruleForm.name }}</el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="主体类型" prop="enterpriseType">
                <dict-tag :type="DICT_TYPE.ENTERPRISE_TYPE" :value="ruleForm.enterpriseType" />
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="产业角色" prop="userTag">
                <dict-tag :type="DICT_TYPE.USER_TAG" :value="ruleForm.userTag" />
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="经营状态" prop="manageStatus">
                <dict-tag :type="DICT_TYPE.MANAGE_STATUS" :value="ruleForm.manageStatus" />
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="注册地址" prop="address">{{ ruleForm.address }}</el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="法定代表人" prop="legalPerson">{{ ruleForm.legalPerson }}</el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="法人身份证号" prop="legalIdCard">{{ ruleForm.legalIdCard }}</el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="法人身份证照片" prop="legalIdCardFrontPhoto">
                <el-image v-if="ruleForm.legalIdCardFrontPhoto" :src="ruleForm.legalIdCardFrontPhoto" alt="企业LOGO" 
                  style="width:100px;height: 100px" ></el-image>
                <div style="font-size: 14px;color:#AAA">身份证正面</div>
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="" prop="legalIdCardBackPhoto">
                <el-image v-if="ruleForm.legalIdCardBackPhoto" :src="ruleForm.legalIdCardBackPhoto" alt="企业LOGO"
                  style="height: 100px" />
                <div style="font-size: 14px;color:#AAA">身份证反面</div>
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="联系人" prop="contactName">{{ ruleForm.contactName }}</el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="联系人电话" prop="contactPhone">{{ ruleForm.contactPhone }}</el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="行政区域" prop="status">
                <dict-tag :type="DICT_TYPE.MANAGE_STATUS" :value="ruleForm.status" />
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="企业规模" prop="enterpriseScale">
                <dict-tag :type="DICT_TYPE.MANAGE_STATUS" :value="ruleForm.enterpriseScale" />
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="15">
              <el-form-item label="主营业务" prop="serviceRange">{{ ruleForm.serviceRange }}</el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="15">
              <el-form-item label="公司简介" prop="description">{{ ruleForm.description }}</el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-form-item label="企业LOGO" prop="LogoUrl">
              <el-image v-if="ruleForm.logo" :src="ruleForm.logo" alt="企业LOGO" style="height: 100px" />
            </el-form-item>
          </el-form-item>
          <el-form-item>
            <el-col :span="15">
              <el-form-item label="备注" prop="remarks">{{ ruleForm.remarks }}</el-form-item>
            </el-col>
          </el-form-item>
        </el-form>

        <div class="subtitle">企业相关资料</div>
        <el-form :model="ruleForm" label-width="200px" ref="ruleForm" class="demo-ruleForm" label-position="left">
          <el-form-item>
            <el-form-item label="统一社会信用代码或注册号" prop="socialCreditCode">{{ ruleForm.socialCreditCode }}</el-form-item>
          </el-form-item>
          <el-form-item>
            <el-form-item label="电子营业执照" prop="businessCertificatePhoto">
              <div v-for="(item, index) in ruleForm.businessLicensePhoto" :key="index"
                style="display: inline; margin: 0 10px;">
                <el-image :src="item" alt="电子营业执照" style="height: 100px" />
              </div>
            </el-form-item>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="经营许可证号码" prop="businessLicenseNo">{{ ruleForm.businessLicenseNo }}</el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="经营许可证有效日期" prop="businessLicenseEndTime">{{
                  parseTime(ruleForm.businessLicenseEndTime, '{y}-{m}-{d}')
              }}
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="20">
              <el-form-item label="经营许可证照片" prop="businessCertfront">
                <div v-for="(item, index) in ruleForm.businessCertificatePhoto" :key="index"
                  style="display: inline; margin: 0 10px;">
                  <el-image :src="item" alt="电子营业执照" style="height: 100px" />
                </div>
              </el-form-item>
            </el-col>
          </el-form-item>
        </el-form>
        <div class="subtitle">账户信息</div>
        <el-form :model="ruleForm" label-width="200px" ref="ruleForm" class="demo-ruleForm" label-position="left">
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="账户名" prop="accountName">{{ ruleForm.accountName }}</el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="身份证号" prop="accountIdCard">{{ ruleForm.accountIdCard }}
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="10">
              <el-form-item label="银行卡号" prop="accountNo">{{ ruleForm.accountNo }}</el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item label="开户行" prop="accountBank">{{ ruleForm.accountBank }}
              </el-form-item>
            </el-col>
          </el-form-item>
        </el-form>


      </el-tab-pane>
      <el-tab-pane label="设施" name="facilities">
        <div class="title">设施信息</div>
      </el-tab-pane>
      <el-tab-pane label="设备" name="equipment">
        <div class="title">设备信息</div>
      </el-tab-pane>
      <el-tab-pane label="地块" name="massif">
        <div class="title">地块信息</div>
      </el-tab-pane>
      <el-tab-pane label="交易账单" name="transactionStatement">
        <div class="title">账单交易信息</div>
        <!-- 搜索工作栏 -->
        <el-form :model="queryBillParams" ref="queryBillForm" size="small" :inline="true" v-show="showSearch"
          label-width="68px">
          <el-form-item prop="id">
            <el-input v-model="queryBillParams.id" placeholder="请输入交易单号" clearable @keyup.enter.native="handleQuery" />
          </el-form-item>
          <el-form-item prop="type">
            <el-select v-model="queryBillParams.type" placeholder="请选择交易类型" clearable size="small">
              <el-option label="请选择交易类型" value="" />
            </el-select>
          </el-form-item>
          <el-form-item prop="partner">
            <el-select v-model="queryBillParams.partner" placeholder="请选择交易对象" clearable size="small">
              <el-option label="请选择交易对象" value="" />
            </el-select>
          </el-form-item>
          <el-form-item prop="billDate">
            <el-date-picker v-model="queryBillParams.billDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
              type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
              :default-time="['00:00:00', '23:59:59']" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" @click="resetBillQuery">重置</el-button>
            <el-button type="primary" plain icon="el-icon-download" @click="handleExport" :loading="exportLoading">导出
            </el-button>
          </el-form-item>
        </el-form>
        <el-table v-loading="loading" :data="billlist" stripe>
          <el-table-column label="交易单号" align="center" prop="id" />
          <el-table-column label="交易类型" align="center" prop="" />
          <el-table-column label="交易方式" align="center" prop="" />
          <el-table-column label="交易时间" align="center" prop="" />
          <el-table-column label="售品名称" align="center" prop="" />
          <el-table-column label="交易金额" align="center" prop="" />
          <el-table-column label="支付账户" align="center" prop="" />
          <el-table-column label="收款账户" align="center" prop="" />
          <el-table-column label="交易对象名称" align="center" prop="" />
          <el-table-column label="交易状态" align="center" prop="" />
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="政策补贴记录" name="policySubsidyRecord">
        <div class="title">政策补贴记录</div>
        <PolicySubsidiesInfo :id="id"></PolicySubsidiesInfo>
      </el-tab-pane>
      <el-tab-pane label="其他证件" name="otherCertificateInfo">
        <div class="title">其他证件</div>
        <otherCertificateInfo :id="id" v-if="activeName == 'otherCertificateInfo'"></otherCertificateInfo>
      </el-tab-pane>
      <el-tab-pane label="其他账户" name="otherAccountInfo">
        <div class="title">其他账户</div>
        <otherAccountInfo :id="id" v-if="activeName == 'otherAccountInfo'"></otherAccountInfo>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import { getBaseInfo } from "@/api/enterprise/baseInfo"
import PolicySubsidiesInfo from '../policySubsidiesInfo/index.vue'
import otherCertificateInfo from "../../enterprise/otherCertificateInfo"
import otherAccountInfo from "../../enterprise/otherAccountInfo"
const defaultRefundDetail = {
  code: '',
  name: '',
  enterpriseType: '',
  userTag: '',
  manageStatus: false,
  address: '',
  legalPerson: '',
  legalIdCard: '',
  contactName: '',
  contactPhone: '',
  enterpriseScale: '',
  serviceRange: '',
  description: '',
  remarks: '',
  socialCreditCode: '',
  businessLicenseNo: '',
  businessLicenseEndTime: '',
  accountName: '',
  accountIdCard: '',
  accountNo: '',
  accountBank: '',
  legalIdCardBackPhoto: [],//法人身份证反面照片
  legalIdCardFrontPhoto: [],//法人身份证正面
  logo: [],//企业Logo
  businessLicensePhoto: [],//经营许可证
  businessCertificatePhoto: []//电子营业执照图片
}
export default {
  name: "User",
  components: {
    PolicySubsidiesInfo, otherCertificateInfo, otherAccountInfo
  },
  data() {
    return {
      //默认tab显示
      activeName: 'first',
      id: '',
      // 遮罩层
      // loading: true,
      loading: false,
      // 导出遮罩层
      exportLoading: false,

      //表单内容
      ruleForm: JSON.parse(JSON.stringify(defaultRefundDetail)),

      // 显示搜索条件
      showSearch: true,

      billlist: [],
      // 查询参数
      queryBillParams: {
        pageNo: 1,
        pageSize: 10,
        id: undefined,
        type: undefined,
        partner: undefined,
        billDate: []
      },


    };
  },
  created() {
    console.log(this.$route.query.id, 'query')
    this.businessid = this.$route.query.id
    //调接口获取会员信息
    this.getBaseInfoMessage()
  },
  methods: {
    //切换tab
    handleClick(tab, event) {
      console.log(tab.index, event);
    },

    //获取表单原有数据
    getBaseInfoMessage() {
      const id = this.businessid
      getBaseInfo(id).then(response => {
        this.ruleForm = response.data;
        this.ruleForm.businessLicensePhoto = response.data.businessLicensePhoto.split(',')
        this.ruleForm.businessCertificatePhoto = response.data.businessCertificatePhoto.split(',')
      });
    },

    /** 搜索按钮操作 */
    handleQuery() {

    },
    /** 重置按钮操作 */
    resetBillQuery() {
      this.resetForm("queryBillForm");
      this.handleQuery();
    },
    handleExport() {

    },
    gotoEdit() {
      this.$router.push({ path: "/enterprise/baseInfo/businessEditInfo", query: { id: this.businessid } });
    }
  }
};
</script>
<style scoped>
.title {
  font-size: 24px;
  margin: 10px 0 10px 15px;
}

.subtitle {
  font-size: 18px;
  margin: 10px 0 20px 15px;
  padding: 0 20px;
  background-color: rgb(215, 215, 215);
  border-radius: 4px;
}
</style>
