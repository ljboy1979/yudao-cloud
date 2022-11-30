<!--
  功能：初始化功能描述
  作者：luojinbo
  时间：2020.11.18
-->
<template>
    <div class='app-container'>
        <div class="title">基本信息</div>
        <el-form :model="ruleForm" label-width="200px" :rules="rules" ref="ruleForm" class="demo-ruleForm"
            label-position="left">
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="主体编号" prop="code">
                        <el-input v-model="ruleForm.code" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="主体名称" prop="name">
                        <el-input v-model="ruleForm.name" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="主体类型" prop="enterpriseType">
                        <el-select v-model="ruleForm.enterpriseType" placeholder="请选择主体类型">
                            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.ENTERPRISE_TYPE)" :key="dict.value"
                                :label="dict.label" :value="dict.value" />
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="产业角色" prop="userTag">
                        <el-select v-model="ruleForm.userTag" placeholder="请选择产业角色">
                            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.USER_TAG)" :key="dict.value"
                                :label="dict.label" :value="dict.value" />
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="经营状态" prop="manageStatus">
                        <el-select v-model="ruleForm.manageStatus" placeholder="请选择经营状态">
                            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.MANAGE_STATUS)" :key="dict.value"
                                :label="dict.label" :value="dict.value" />
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="注册地址" prop="address">
                        <el-input v-model="ruleForm.address" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <!-- <el-form-item>
                <el-form-item label="统一社会信用代码或注册号" prop="name">
                    <el-input v-model="ruleForm.name" class="inputSize"></el-input>
                </el-form-item>
            </el-form-item> -->
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="法定代表人" prop="legalPerson">
                        <el-input v-model="ruleForm.legalPerson" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="法人身份证号" prop="legalIdCard">
                        <el-input v-model="ruleForm.legalIdCard" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="法人身份证照片" prop="legalIdCardFrontPhoto">
                        <el-upload action="#" list-type="picture-card" :auto-upload="false"
                            :on-preview="handlePictureCardPreview" :on-remove="handleRemove" :on-change="changeIDimg"
                            :class="{ hide: IDimg }" ref="uploadID" :file-list="ruleForm.legalIdCardFrontPhoto">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <div style="font-size: 14px;color:#AAA">身份证正面 <span
                                style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>
                        <el-dialog :visible.sync="dialogVisible">
                            <img width="50%" height="50%" :src="dialogImageUrl" alt="">
                        </el-dialog>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="" prop="legalIdCardBackPhoto">
                        <el-upload action="#" list-type="picture-card" :auto-upload="false"
                            :on-preview="handlePictureCardPreview" :on-remove="handleRemoveReverse"
                            :on-change="changeIDimgReverse" :class="{ hide: IDimgReverse }" ref="uploadIDReverse"
                            :file-list="ruleForm.legalIdCardBackPhoto">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <div style="font-size: 14px;color:#AAA">身份证反面 <span
                                style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>

                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="联系人" prop="contactName">
                        <el-input v-model="ruleForm.contactName" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="联系人电话" prop="contactPhone">
                        <el-input v-model="ruleForm.contactPhone" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="行政区域" prop="name">
                        <el-cascader v-model="ruleForm.value" :options="options" @change="handleChange"
                        :props="{ value: 'id'}"></el-cascader>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="企业规模" prop="enterpriseScale">
                        <el-select v-model="ruleForm.enterpriseScale" placeholder="请选择企业规模">
                            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.MANAGE_STATUS)" :key="dict.value"
                                :label="dict.label" :value="parseInt(dict.value)" />
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="15">
                    <el-form-item label="主营业务" prop="serviceRange">
                        <el-input type="textarea" v-model="ruleForm.serviceRange" placeholder="请输入主营业务" :rows="2">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="15">
                    <el-form-item label="公司简介" prop="description">
                        <el-input type="textarea" v-model="ruleForm.description" placeholder="请输入公司简介" :rows="2">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-form-item label="企业LOGO" prop="logo">
                    <el-upload action="#" list-type="picture-card" :auto-upload="false"
                        :on-preview="handlePictureCardPreview" :on-remove="handleRemoveLogo" :on-change="changeLogoimg"
                        :class="{ hide: Logoimg }" :before-upload="beforeAvatarUpload" ref="uploadLogo"
                        :file-list="ruleForm.logo">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <div style="font-size: 14px;color:#AAA">最多1张 <span
                            style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>
                </el-form-item>
            </el-form-item>
            <el-form-item>
                <el-col :span="15">
                    <el-form-item label="备注" prop="remarks">
                        <el-input type="textarea" v-model="ruleForm.remarks" placeholder="请输入备注" :rows="2"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <div class="title">企业相关资料</div>
            <el-form-item>
                <el-form-item label="统一社会信用代码或注册号" prop="socialCreditCode">
                    <el-input v-model="ruleForm.socialCreditCode" class="inputSize"></el-input>
                </el-form-item>
            </el-form-item>
            <el-form-item>
                <el-form-item label="电子营业执照" prop="businessCertificatePhoto">
                    <el-upload action="#" list-type="picture-card" :auto-upload="false"
                        :on-preview="handlePictureCardPreview" :on-remove="handleRemoveLicense"
                        :on-change="changeLicenseimg" :class="{ hide: Licenseimg }" ref="uploadLicense"
                        :file-list="ruleForm.businessCertificatePhoto">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <div style="font-size: 14px;color:#AAA">最多6张 <span
                            style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>
                </el-form-item>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="经营许可证号码" prop="businessLicenseNo">
                        <el-input v-model="ruleForm.businessLicenseNo" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="经营许可证有效日期" prop="businessLicenseEndTime">
                        <el-date-picker v-model="ruleForm.businessLicenseEndTime" type="date" placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item>
                <el-col :span="20">
                    <el-form-item label="经营许可证照片" prop="businessLicensePhoto">
                        <el-upload action="#" list-type="picture-card" :auto-upload="false"
                            :on-preview="handlePictureCardPreview" :on-remove="handleRemovebusinessCert"
                            :on-change="changebusinessCert" :class="{ hide: businessCert }" ref="businessCert"
                            :file-list="ruleForm.businessLicensePhoto">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <div style="font-size: 14px;color:#AAA">最多6张 <span
                                style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span></div>

                    </el-form-item>
                </el-col>
            </el-form-item>
            <div class="title">账户信息</div>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="账户名" prop="accountName">
                        <el-input v-model="ruleForm.accountName" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="身份证号" prop="accountIdCard">
                        <el-input v-model="ruleForm.accountIdCard" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-form-item label="银行卡号" prop="accountNo">
                        <el-input v-model="ruleForm.accountNo" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="开户行" prop="accountBank">
                        <el-input v-model="ruleForm.accountBank" class="inputSize"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
//import(导入)其他文件（如：组件，工具js，第三方插件js，json文件，图片文件等）
import { getBaseInfo, updateBaseInfo, getTree } from "@/api/enterprise/baseInfo"
import { DICT_TYPE } from "../../../utils/dict"
import { Loading } from 'element-ui';
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
    name: 'businessInfo',
    data() {
        return {
            //表单内容
            ruleForm: {
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
            },
            //表单检验规则
            rules: {
                code: [
                    { required: true, message: '请输入主体编号', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                name: [
                    { required: true, message: '请输入主体名称', trigger: 'blur' },
                ],
                enterpriseType: [
                    { required: true, message: '请选择主体类型', trigger: 'change' }
                ],
                userTag: [
                    { required: true, message: '请选择产业角色', trigger: 'change' }
                ],
                manageStatus: [
                    { required: true, message: '请选择经营状态', trigger: 'change' }
                ],
                address: [
                    { required: true, message: '请输入注册地址', trigger: 'change' }
                ],
                legalPerson: [
                    { required: true, message: '请输入法定代表人', trigger: 'change' }
                ],
                legalIdCard: [
                    { required: true, message: '请输入法定代表人身份证号码', trigger: 'change' }
                ],
                contactName: [
                    { required: true, message: '请输入联系人', trigger: 'change' }
                ],
                contactPhone: [
                    { required: true, message: '请输入联系人电话号码', trigger: 'change' }
                ],
                enterpriseScale: [
                    { required: true, message: '请选择企业规模', trigger: 'change' }
                ],
                serviceRange: [
                    { required: true, message: '请输入主营业务', trigger: 'change' }
                ],
                description: [
                    { required: true, message: '请输入公司简介', trigger: 'change' }
                ],
                remarks: [
                    { required: true, message: '请输入备注', trigger: 'change' }
                ],
                socialCreditCode: [
                    { required: true, message: '请输入统一社会信用代码或注册号', trigger: 'change' }
                ],
                businessLicenseNo: [
                    { required: true, message: '请输入经营许可证号码', trigger: 'change' }
                ],
                businessLicenseEndTime: [
                    { required: true, message: '请选择经营许可证有效日期', trigger: 'change' }
                ],
                accountName: [
                    { required: true, message: '请输入账户名', trigger: 'change' }
                ],
                accountIdCard: [
                    { required: true, message: '请输入身份证号', trigger: 'change' }
                ],
                accountNo: [
                    { required: true, message: '请输入银行卡号', trigger: 'change' }
                ],
                accountBank: [
                    { required: true, message: '请输入开户行', trigger: 'change' }
                ],
            },
            dialogVisible: false,//是否开启预览
            dialogImageUrl: '',//当前预览图片地址
            IDimg: false,//身份证正面是否可继续上传
            IDimgReverse: false,//身份证反面是否可继续上传
            Licenseimg: false,//电子营业执照图片是否可继续上传
            Logoimg: false,//Logo是否可继续上传
            legalIdCardBackPhoto: [],//法人身份证反面照片
            legalIdCardFrontPhoto: [],//法人身份证正面
            logo: [],//企业Logo
            businessLicensePhoto: [],//经营许可证
            businessCert: false,//经营许可证是否可继续上传
            businessCertificatePhoto: [],//电子营业执照图片
            options: []
        };
    },
    /**计算属性*/
    computed: {},
    /**监听data数据变化*/
    watch: {},
    /**所有方法*/
    methods: {
        getAllTree() {
            getTree().then(response => {
                console.log(response.data);
                this.options=response.data
            })
        },
        handleChange(value) {
            console.log(value);
        },
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    //验证图片是否为空
                    if (this.legalIdCardFrontPhoto.length <= 0) {
                        this.$message.error('请上传法人身份证正面照片');
                        return;
                    }
                    if (this.legalIdCardBackPhoto.length <= 0) {
                        this.$message.error('请上传法人身份证反面照片');
                        return;
                    }
                    if (this.logo.length <= 0) {
                        this.$message.error('请上传企业Logo');
                        return;
                    }
                    if (this.businessCertificatePhoto.length <= 0) {
                        this.$message.error('请上传电子营业执照');
                        return;
                    }
                    if (this.businessLicensePhoto.length <= 0) {
                        this.$message.error('请上传经营许可证');
                        return;
                    }
                    //提交表单
                    let obj = JSON.parse(JSON.stringify(this.ruleForm));
                    obj.legalIdCardFrontPhoto = this.ArrayToString(this.legalIdCardFrontPhoto);
                    obj.legalIdCardBackPhoto = this.ArrayToString(this.legalIdCardBackPhoto);
                    obj.logo = this.ArrayToString(this.logo);
                    obj.businessLicensePhoto = this.ArrayToString(this.businessLicensePhoto);
                    obj.businessCertificatePhoto = this.ArrayToString(this.businessCertificatePhoto);
                    obj.id = this.id;
                    if (obj.userTagName) {
                        delete obj.userTagName
                    }
                    if (obj.enterpriseTypeName) {
                        delete obj.enterpriseTypeName
                    }
                    updateBaseInfo(obj).then(res => {
                        if (res.code == 0) {
                            this.getBaseInfoMessage();
                        }
                    })

                } else {
                    this.$message.error('您还有未填写的选项');
                    return false;
                }
            });
        },
        resetForm(formName) {
            // this.$refs[formName].resetFields();
            this.getBaseInfoMessage();
        },
        //移除身份证正面照片
        handleRemove(file, fileList) {
            this.legalIdCardFrontPhoto = fileList
            this.IDimg = false;
        },
        //移除身份证反面照片
        handleRemoveReverse(file, fileList) {
            this.legalIdCardBackPhoto = fileList;
            this.IDimgReverse = false;
        },
        //移除电子营业执照图片
        handleRemoveLicense(file, fileList) {
            fileList.length < 6 ? this.Licenseimg = false : ''
            this.businessCertificatePhoto = fileList
        },
        //移除企业Logo
        handleRemoveLogo(file, fileList) {
            this.logo = fileList
            this.Logoimg = false;
        },

        //移除企业经营许可证
        handleRemovebusinessCert(file, fileList) {
            this.businessLicensePhoto = fileList
            fileList.length < 6 ? this.businessCert = false : ''
            this.Logoimg = false;
        },
        //预览照片
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
        //上传身份证正面照片之后隐藏上传按钮
        changeIDimg(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                this.legalIdCardFrontPhoto = fileList;
                this.IDimg = true;
            } else {
                this.$refs.uploadID.uploadFiles.splice(this.$refs.uploadID.uploadFiles.length - 1, 1)
            }
        },
        //上传身份证反面照片之后隐藏上传按钮
        changeIDimgReverse(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                this.legalIdCardBackPhoto = fileList;
                this.IDimgReverse = true;
            } else {
                this.$refs.uploadIDReverse.uploadFiles.splice(this.$refs.uploadIDReverse.uploadFiles.length - 1, 1)
            }
        },
        //上传企业Logo之后隐藏上传按钮
        changeLogoimg(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                this.Logoimg = true;
                this.logo = fileList;
            } else {
                this.$refs.uploadLogo.uploadFiles.splice(this.$refs.uploadLogo.uploadFiles.length - 1, 1)
            }
        },
        //上传电子营业执照,等于6张的时候隐藏上传按钮
        changeLicenseimg(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                fileList.length == 6 ? this.Licenseimg = true : ''
                this.businessCertificatePhoto = fileList
            } else {
                this.$refs.uploadLicense.uploadFiles.splice(this.$refs.uploadLicense.uploadFiles.length - 1, 1)
            }

        },
        //上传经营许可证，等于6张隐藏上传按钮
        changebusinessCert(file, fileList) {
            let check = this.beforeAvatarUpload(file);
            if (check) {
                fileList.length == 6 ? this.businessCert = true : ''
                this.businessLicensePhoto = fileList
            } else {
                this.$refs.businessCert.uploadFiles.splice(this.$refs.businessCert.uploadFiles.length - 1, 1)
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
        },
        //获取表单原有数据
        getBaseInfoMessage() {
            const id = this.id
            let loadingInstance = Loading.service({ fullscreen: true });
            getBaseInfo(id).then(response => {
                //图片反显和是否显示上传按钮
                response.data.logo = this.ToUpload(response.data.logo);
                this.logo = response.data.logo
                response.data.logo.length >= 1 ? this.Logoimg = true : ''
                response.data.legalIdCardFrontPhoto = this.ToUpload(response.data.legalIdCardFrontPhoto);
                this.legalIdCardFrontPhoto = response.data.legalIdCardFrontPhoto
                response.data.legalIdCardFrontPhoto.length >= 1 ? this.IDimg = true : ''
                response.data.legalIdCardBackPhoto = this.ToUpload(response.data.legalIdCardBackPhoto);
                this.legalIdCardBackPhoto = response.data.legalIdCardBackPhoto
                response.data.legalIdCardBackPhoto ? this.IDimgReverse = true : ''
                response.data.businessLicensePhoto = this.ToUpload(response.data.businessLicensePhoto)
                this.businessLicensePhoto = response.data.businessLicensePhoto
                response.data.businessLicensePhoto.length >= 6 ? this.businessCert = true : ''
                response.data.businessCertificatePhoto = this.ToUpload(response.data.businessCertificatePhoto)
                this.businessCertificatePhoto = response.data.businessCertificatePhoto
                response.data.businessCertificatePhoto.length >= 6 ? this.Licenseimg = true : ''
                this.ruleForm = response.data;
                //取消接口加载过度动画
                setTimeout(function () {
                    loadingInstance.close();
                }, 1000)

            });
        },
        //字符串转换成对应Array接受类型参数
        ToUpload(imgurl) {
            //是否有多张图片
            if (imgurl.indexOf(',') === -1) {
                imgurl instanceof Array ? '' : imgurl = [imgurl]
            } else {
                imgurl = imgurl.split(',');
            }
            let imgObject = [];
            for (let i = 0; i < imgurl.length; i++) {
                let obj = {};
                obj.url = imgurl[i];
                imgObject.push(obj)
            }
            return imgObject;
        },
        //将数组转换为后端需要的图片地址
        ArrayToString(Arr) {
            if (Array.isArray(Arr)) {
                let Str = '';
                for (let i = 0; i < Arr.length; i++) {
                    i == 0 ? Str = Arr[i].url : Str = Str + ',' + Arr[i].url;

                }
                return Str
            }
        }
    },
    /**创建组件时执行(有VM对象this)*/
    created() {
        this.getBaseInfoMessage();
        this.getAllTree();
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