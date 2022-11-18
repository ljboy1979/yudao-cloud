<template>
    <div class="app-container">
        <div class="title">会员积分记录</div>
        <el-button type="primary" style="margin-right: 15px;" @click="addmemberPointsRecord">新增</el-button>
        <el-date-picker v-model="CheckDate" type="daterange" range-separator="至" start-placeholder="开始日期"
            end-placeholder="结束日期">
        </el-date-picker>
        <el-button style="margin-left: 15px;" type="primary" icon="el-icon-search" @click="handleQuery">搜索
        </el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="会员账号" align="center" prop="id" />
            <el-table-column label="会员名称" align="center" prop="nickname" />
            <el-table-column label="评分项目" align="center" prop="avatar" />
            <el-table-column label="本次积分变动" align="center" prop="status" />
            <el-table-column label="当前剩余积分" align="center" prop="status" />
            <el-table-column label="积分变动时间" align="center" prop="status" />
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleView(scope.row)"
                        v-hasPermi="['member:user:update']">查看</el-button>
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                        v-hasPermi="['member:user:update']">修改</el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                        v-hasPermi="['member:user:delete']">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页组件 -->
        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
            @pagination="getList" />
        <el-dialog title="提示" :visible.sync="memberPointsRecord" width="30%" :before-close="handleClose">
            <el-form :model="ruleForm" :rules="PointsRecordrules" ref="ruleForm" label-width="100px"
                class="demo-ruleForm">
                <el-form-item label="会员账户" prop="name" placeholder="请输入会员账户">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
                <el-form-item label="会员名称" prop="name" placeholder="请输入会员名称">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
                <el-form-item label="评分项目" prop="region">
                    <el-select v-model="ruleForm.region" placeholder="请选择评分项目">
                        <el-option label="一" value="shanghai"></el-option>
                        <el-option label="二" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="评分分数" prop="name" placeholder="请输入评分分数">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
                <el-form-item label="备注" prop="desc" placeholder="请输入备注，限定200字符">
                    <el-input type="textarea" v-model="ruleForm.desc"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                    <el-button @click="handleClose">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

    </div>
</template>

<script >
export default {
    name: 'memberPointsRecord',
    props: {
        id: {
            type: String,
            required: true
        }
    },
    data() {
        return {
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
            //新增会员积分记录验证
            PointsRecordrules: {
                name: [
                    { required: true, message: '请输入会员账号', trigger: 'blur' },
                ],
                region: [
                    { required: true, message: '请输入会员名称', trigger: 'change' }
                ],
                type: [
                    { type: 'array', required: true, message: '请至少选择一个评分项目', trigger: 'change' }
                ],
                resource: [
                    { required: true, message: '请输入评分分数', trigger: 'change' }
                ],
                desc: [
                    { required: true, message: '请输入备注', trigger: 'blur' }
                ]
            },
            //新增会员积分记录
            memberPointsRecord: false,
            ruleForm: {},
            CheckDate: '',

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
        //新增会员积分记录弹窗
        addmemberPointsRecord() {
            this.memberPointsRecord = true;
            //获取会员信息
        },
        //新增会员积分记录
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    alert('submit!');
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        //新增会员积分记录弹窗关闭
        handleClose() {
            this.memberPointsRecord = false;
        }
    }

}
</script>

<style  scoped>
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}
</style>