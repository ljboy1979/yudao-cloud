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
            <el-tab-pane label="专业资质" name="third">
                <div class="title">专业资质</div>
                <el-table v-loading="loading" :data="list" stripe>
                    <el-table-column label="备案类型" align="center" prop="id" />
                    <el-table-column label="备案名称" align="center" prop="nickname" />
                    <el-table-column label="许可证号码" align="center" prop="avatar" />
                    <el-table-column label="姓名" align="center" prop="status" />
                    <el-table-column label="手机号" align="center" prop="mobile" />
                    <el-table-column label="备案日期" align="center" prop="password" />
                    <el-table-column label="证照" align="center" prop="registerIp" />
                    <el-table-column label="审核状态" align="center" prop="loginIp" />
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="售品交易记录" name="fourth">
                <div class="title">售品交易记录</div>
                <el-table v-loading="loading" :data="list" stripe>
                    <el-table-column label="订单编号" align="center" prop="id" />
                    <el-table-column label="下单时间" align="center" prop="nickname" />
                    <el-table-column label="订单总额" align="center" prop="avatar" />
                    <el-table-column label="售品名称" align="center" prop="status" />
                    <el-table-column label="优惠活动" align="center" prop="mobile" />
                    <el-table-column label="订单状态" align="center" prop="password" />
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="服务交易记录" name="fifth">
                <div class="title">服务交易记录</div>
                <el-table v-loading="loading" :data="list" stripe>
                    <el-table-column label="订单编号" align="center" prop="id" />
                    <el-table-column label="订单总额" align="center" prop="nickname" />
                    <el-table-column label="服务提供方" align="center" prop="avatar" />
                    <el-table-column label="服务类型" align="center" prop="status" />
                    <el-table-column label="服务名称" align="center" prop="mobile" />
                    <el-table-column label="下单时间" align="center" prop="mobile" />
                    <el-table-column label="订单状态" align="center" prop="password" />
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="进出记录" name="sixth">
                <div class="title">进出记录</div>
                <passInAndOutRecord :id="userid" v-if="DynamicLoading[5].Loading"></passInAndOutRecord>
            </el-tab-pane>
            <el-tab-pane label="会员积分记录" name="seventh">
                <memberPointsRecord :id="userid" v-if="DynamicLoading[6].Loading"></memberPointsRecord>
            </el-tab-pane>
            <el-tab-pane label="健康档案" name="eighth">
                <div class="title">健康档案</div>
                <el-select v-model="value" placeholder="请选择">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            </el-tab-pane>
            <el-tab-pane label="代理商管理" name="ninth">
                <agentManagement :id="userid" v-if="DynamicLoading[8].Loading"></agentManagement>
            </el-tab-pane>
            <el-tab-pane label="钱包交易记录" name="tenth">
                <WalletTransactionHistory :id="userid" v-if="DynamicLoading[9].Loading"></WalletTransactionHistory>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
  
<script>
import { createUser, updateUser, deleteUser, getUser, getUserPage, exportUserExcel } from "@/api/member/user";
import memberPointsRecord from "../componets/memberPointsRecord.vue";
import agentManagement from "../componets/agentManagement.vue";
import WalletTransactionHistory from "../componets/WalletTransactionHistory.vue";
import passInAndOutRecord from "../componets/passInAndOutRecord.vue";
export default {
    name: "User",
    components: {
        memberPointsRecord,
        agentManagement,
        WalletTransactionHistory,
        passInAndOutRecord
    },
    data() {
        return {
            //默认tab显示
            activeName: 'first',
            // 遮罩层
            loading: false,
            // 导出遮罩层
            exportLoading: false,
            // 显示搜索条件
            showSearch: true,
            // 总条数
            total: 0,
            // 会员列表
            list: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            // 查询参数
            queryParams: {
                pageNo: 1,
                pageSize: 10,
                nickname: null,
                avatar: null,
                status: null,
                mobile: null,
                password: null,
                registerIp: null,
                loginIp: null,
                loginDate: [],
                createTime: [],
                source: null,
                subjectId: null,
            },
            // 表单参数
            form: {},
            // 表单校验
            rules: {
                nickname: [{ required: true, message: "用户昵称不能为空", trigger: "blur" }],
                avatar: [{ required: true, message: "头像不能为空", trigger: "blur" }],
                status: [{ required: true, message: "状态不能为空", trigger: "blur" }],
                mobile: [{ required: true, message: "手机号不能为空", trigger: "blur" }],
                password: [{ required: true, message: "密码不能为空", trigger: "blur" }],
                registerIp: [{ required: true, message: "注册 IP不能为空", trigger: "blur" }],
            },
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
            //下拉选择值
            value: '',
            //日期选择
            CheckDate: '',
            //代理商输入
            input: '',
            //新增会员积分记录
            userid: '',
            isOrno: false,
            DynamicLoading: [{ id: '0', Loading: false }, { id: '1', Loading: false }, { id: '2', Loading: false }, { id: '3', Loading: false }, { id: '4', Loading: false }, { id: '5', Loading: false }, { id: '6', Loading: false }, { id: '7', Loading: false }, { id: '8', Loading: false }, { id: '9', Loading: false }]
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
            // tab.index==6?this.isOrno=true:''
            if (this.DynamicLoading[tab.index]) {
                this.DynamicLoading[tab.index].Loading = true
            }


        },
        //会员积分记录搜索
        handleQuery() {

        },
        //会员积分记录重置
        resetQuery() {

        },
        //会员积分记录查看
        handleView() {

        },
        //会员积分记录修改
        handleUpdate() {

        },
        //会员积分记录删除
        handleDelete() {

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
  