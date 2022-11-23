<!--
  功能：初始化功能描述
  作者：luojinbo
  时间：2020.11.23
-->
<template>
    <div class='app-container'>
        <div class="title">企业相关资料</div>
        <el-form :model="ruleForm" label-width="200px" :rules="rules" ref="ruleForm" class="demo-ruleForm"
            label-position="left">

            <el-form-item>
                <el-form-item label="统一社会信用代码或注册号" prop="name">
                    <el-input v-model="ruleForm.name" class="inputSize"></el-input>
                </el-form-item>
            </el-form-item>
            <el-form-item>
                <el-form-item label="电子营业执照" prop="name">
                    <el-upload action="#" list-type="picture-card" :auto-upload="false"
                        :on-preview="handlePictureCardPreview" :on-remove="handleRemoveLicense"
                        :on-change="changeLicenseimg" :class="{ hide: Licenseimg }" ref="uploadLicense">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <div style="font-size: 14px;color:#AAA">最多6张 <span
                            style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>
                    <el-dialog :visible.sync="dialogVisible">
                        <img width="50%" height="50%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                </el-form-item>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="经营许可证号码" prop="name">
                        <el-input v-model="ruleForm.name" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="经营许可证有效日期" prop="date2">
                        <el-date-picker v-model="ruleForm.date2" type="date" placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item>
                <el-col :span="20">
                    <el-form-item label="经营许可证照片" prop="businessCertfront">
                        <el-upload action="#" list-type="picture-card" :auto-upload="false"
                            :on-preview="handlePictureCardPreview" :on-remove="handleRemove"
                            :on-change="changebusinessCert" :class="{ hide: businessCert }" ref="uploadID">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <div style="font-size: 14px;color:#AAA">最多6张 <span
                                style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>

                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="其他证件号码" prop="name">
                        <el-input v-model="ruleForm.name" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="其他证件号码有效日期" prop="date1">
                        <el-date-picker v-model="ruleForm.date1" type="date" placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item>
                <el-col :span="20">
                    <el-form-item label="其他证件号码照片" prop="businessCertfront">
                        <el-upload action="#" list-type="picture-card" :auto-upload="false"
                            :on-preview="handlePictureCardPreview" :on-remove="handleRemove"
                            :on-change="changebusinessCert" :class="{ hide: businessCert }" ref="uploadID">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <div style="font-size: 14px;color:#AAA">最多6张 <span
                                style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>

                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
//import(导入)其他文件（如：组件，工具js，第三方插件js，json文件，图片文件等）


export default {
    /**注册组件*/
    components: {},
    /**接受父组件传值*/
    props: {
        id: {
            type: String,
            required: true
        }
    },
    name: 'businessRelatedInfo',
    data() {
        return {
            //表单内容
            ruleForm: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            //表单检验规则
            rules: {
                name: [
                    { required: true, message: '请输入活动名称', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                bodyNumber: [
                    { required: true, message: '请选择活动区域', trigger: 'change' }
                ],
                date1: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                date2: [
                    { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                ],
                type: [
                    { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
                ],
                resource: [
                    { required: true, message: '请选择活动资源', trigger: 'change' }
                ],
                desc: [
                    { required: true, message: '请填写公司简介', trigger: 'blur' }
                ]
            },
            dialogVisible: false,//是否开启预览
            dialogImageUrl: '',//当前预览图片地址
            businessCert: false,//身份证正面是否可继续上传
            businessCertReverse: false,//身份证反面是否可继续上传
            LicenseimgList: [],//电子营业执照图片
            Licenseimg: false,//电子营业执照图片是否可继续上传
            Logoimg: false,//Logo是否可继续上传
        };
    },
    /**计算属性*/
    computed: {},
    /**监听data数据变化*/
    watch: {},
    /**所有方法*/
    methods: {
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
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        //移除身份证正面照片
        handleRemove(file, fileList) {
            console.log(file, fileList);
            this.businessCert = false;
        },
        //移除电子营业执照图片
        handleRemoveLicense(file, fileList) {
            console.log(file, fileList);
            fileList.length < 6 ? this.Licenseimg = false : ''
            this.LicenseimgList = fileList
        },
        //移除企业Logo
        handleRemoveLogo(file, fileList) {
            console.log(file, fileList);
            this.Logoimg = false;
        },
        //预览照片
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
        //上传身份证正面照片之后隐藏上传按钮
        changebusinessCert(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                fileList.length == 6 ? this.businessCert = true : ''
            } else {
                this.$refs.uploadID.uploadFiles.splice(this.$refs.uploadID.uploadFiles.length - 1, 1)
            }
        },
        //上传电子营业执照,等于6张的时候隐藏上传按钮
        changeLicenseimg(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                fileList.length == 6 ? this.Licenseimg = true : ''
                this.LicenseimgList = fileList
            } else {
                this.$refs.uploadLicense.uploadFiles.splice(this.$refs.uploadLicense.uploadFiles.length - 1, 1)
            }

        },
        //上传企业Logo之后隐藏上传按钮
        changeLogoimg(file) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                this.Logoimg = true;

            } else {
                this.$refs.uploadLogo.uploadFiles.splice(this.$refs.uploadLogo.uploadFiles.length - 1, 1)
            }
        },
        //检验上传图片格式以及大小
        beforeAvatarUpload(file) {
            const isJPG = file.raw.type === 'image/jpeg' ? true : file.raw.type === 'image/jpg' ? true : file.raw.type === 'image/png' ? true : false;
            const isLt2M = file.size / 1024 / 1024 < 2;
            if (!isJPG) {
                this.$message.error('上传图片只能是 JPG/JPEG/PNG 格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传图片大小不能超过 2MB!');
            }
            return isLt2M && isJPG;
        }
    },
    /**创建组件时执行(有VM对象this)*/
    created() {

    },
    /**加载完组件时执行(主要预处理数据)*/
    mounted() {

    },
    beforeCreate() {/**生命周期 - 创建之前*/ },
    beforeMount() {/**生命周期 - 挂载之前*/ },
    beforeUpdate() {/**生命周期 - 更新之前*/ },
    updated() {/**生命周期 - 更新之后*/ },
    beforeDestroy() {/**生命周期 - 销毁之前*/ },
    destroyed() {/**生命周期 - 销毁完成*/ },
    activated() {/**keep-alive组件激活时调用。仅针对keep-alive组件有效*/ },
    deactivated() {/**keep-alive组件停用时调用。仅针对keep-alive组件有效*/ },
}
</script>
<style scoped >
/* @import url(); 引入css类 */
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}

.inputSize {
    width: 250px;
}

.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}

.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
    border: 1px dashed #d9d9d9;
}

.avatar {
    width: 178px;
    height: 178px;
    display: block;
}

.hide>>>.el-upload--picture-card {
    display: none;
}
</style>