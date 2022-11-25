<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd"
          v-hasPermi="['enterprise:other-certificate-info:create']">新增</el-button>
      </el-form-item>
      <!-- <el-form-item prop="enterpriseId">
        <el-input v-model="queryParams.enterpriseId" placeholder="请输入经营主体ID" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item> -->
      <el-form-item prop="certificateType">
        <el-select v-model="queryParams.certificateType" placeholder="请选择证件类型" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.CERTIFICATE_TYPE)" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item prop="certificateName">
        <el-input v-model="queryParams.certificateName" placeholder="请输入证件名称" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="certificateNo">
        <el-input v-model="queryParams.certificateNo" placeholder="请输入证件号" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="certificateEndTime">
        <el-date-picker v-model="queryParams.certificateEndTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="证件截止范围" end-placeholder="证件截止范围"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <!-- <el-form-item prop="certificatePhoto">
        <el-input v-model="queryParams.certificatePhoto" placeholder="请输入证件照片" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="tenantId">
        <el-input v-model="queryParams.tenantId" placeholder="请输入租户编号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="source">
        <el-input v-model="queryParams.source" placeholder="请输入租户集合" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item prop="subjectId">
        <el-input v-model="queryParams.subjectId" placeholder="请输入经营主体ID" clearable @keyup.enter.native="handleQuery" />
      </el-form-item> -->
      <el-form-item prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="创建开始日期" end-placeholder="创建结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item prop="updateTime">
        <el-date-picker v-model="queryParams.updateTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange" range-separator="-" start-placeholder="更新开始日期" end-placeholder="更新结束日期"
          :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
        <el-button type="primary" plain icon="el-icon-download" @click="handleExport" :loading="exportLoading"
          v-hasPermi="['enterprise:other-certificate-info:export']">导出</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <!-- <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
      </el-col>
      <el-col :span="1.5">
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row> -->

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="证件类型" align="center" prop="certificateType">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.CERTIFICATE_TYPE" :value="scope.row.certificateType" />
        </template>
      </el-table-column>
      <el-table-column label="证件名称" align="center" prop="certificateName" />
      <el-table-column label="证件号" align="center" prop="certificateNo" />
      <el-table-column label="证件截止日期" align="center" prop="certificateEndTime" />
      <!-- <el-table-column label="租户编号" align="center" prop="tenantId" />
      <el-table-column label="租户集合" align="center" prop="source" />
      <el-table-column label="经营主体ID" align="center" prop="subjectId" /> -->
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['enterprise:other-certificate-info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['enterprise:other-certificate-info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="证件类型" prop="certificateType">
          <el-select v-model="form.certificateType" placeholder="请选择证件类型">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.CERTIFICATE_TYPE)" :key="dict.value"
              :label="dict.label" :value="parseInt(dict.value)" />
          </el-select>
        </el-form-item>
        <el-form-item label="证件名称" prop="certificateName">
          <el-input v-model="form.certificateName" placeholder="请输入证件名称" />
        </el-form-item>
        <el-form-item label="证件号" prop="certificateNo">
          <el-input v-model="form.certificateNo" placeholder="请输入证件号" />
        </el-form-item>
        <el-form-item label="证件截止日期" prop="certificateEndTime">
          <el-date-picker clearable v-model="form.certificateEndTime" type="date" 
            placeholder="选择证件截止日期" />
        </el-form-item>
        <el-form-item label="证件照片" prop="certificatePhoto">
          <el-upload action="#" list-type="picture-card" :auto-upload="false" :on-preview="handlePictureCardPreview"
            :on-remove="handleRemovecertificatePhoto" :on-change="changecertificatePhoto" :class="{ hide: certificate }"
            ref="certificatePhoto" :file-list="form.certificatePhoto">
            <i class="el-icon-plus"></i>
          </el-upload>
          <div style="font-size: 14px;color:#AAA">最多6张 <span style="font-size: 12px;">仅支持扩展名".jpg/.jpeg/.png"</span>
          </div>
          <el-dialog :visible.sync="dialogVisible" append-to-body>
            <img width="50%" height="50%" :src="dialogImageUrl" alt="">
          </el-dialog>

        </el-form-item>
        <!-- <el-form-item label="租户编号" prop="tenantId">
          <el-input v-model="form.tenantId" placeholder="请输入租户编号" />
        </el-form-item>
        <el-form-item label="租户集合" prop="source">
          <el-input v-model="form.source" placeholder="请输入租户集合" />
        </el-form-item>
        <el-form-item label="经营主体ID" prop="subjectId">
          <el-input v-model="form.subjectId" placeholder="请输入经营主体ID" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createOtherCertificateInfo, updateOtherCertificateInfo, deleteOtherCertificateInfo, getOtherCertificateInfo, getOtherCertificateInfoPage, exportOtherCertificateInfoExcel } from "@/api/enterprise/otherCertificateInfo";

export default {
  name: "OtherCertificateInfo",
  components: {
  },
  props: {
    id: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 经营主体其他证件列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        enterpriseId: null,
        certificateType: null,
        certificateName: null,
        certificateNo: null,
        certificateEndTime: [],
        certificatePhoto: [],
        tenantId: null,
        source: null,
        subjectId: null,
        createTime: [],
        updateTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        // tenantId: [{ required: true, message: "租户编号不能为空", trigger: "blur" }],
      },
      businessLicensePhoto: [],//经营许可证
      certificate: false,//经营许可证是否可继续上传
      dialogVisible: false,//是否开启预览
      dialogImageUrl: '',//当前预览图片地址
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getOtherCertificateInfoPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    fileBeforeUpload(file) {
      console.log("---", file)
      // let format = '.' + file.name.split(".")[1];
      // if (format !== this.fileAccept) {
      //   this.$message.error('请上传指定格式"' + this.fileAccept + '"文件');
      //   return false;
      // }
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      return isRightSize
    },
    alipayPublicCertUpload(event) {
      const readFile = new FileReader()
      readFile.onload = (e) => {
        this.form.aliPayConfig.alipayPublicCertContent = e.target.result
      }
      readFile.readAsText(event.file);
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        certificateType: undefined,
        certificateName: undefined,
        certificateNo: undefined,
        certificateEndTime: undefined,
        certificatePhoto: undefined,
        tenantId: undefined,
        source: undefined,
        subjectId: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加经营主体其他证件";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getOtherCertificateInfo(id).then(response => {
        this.form = response.data;
        console.log(response)
        //图片反显
        this.certificatePhoto=this.ToUpload(this.form.certificatePhoto);
        this.open = true;
        this.title = "修改经营主体其他证件";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid||this.certificatePhoto.length==0||this.certificatePhoto=='') {
          this.$message.error("信息填写不完整");
          return;
        }
        console.log("form:", this.form)
        // 修改的提交
        if (this.form.id != null) {
          updateOtherCertificateInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        let obj = JSON.parse(JSON.stringify(this.form));
        obj.certificatePhoto=this.ArrayToString(this.certificatePhoto)
        console.log(obj)
        // createOtherCertificateInfo(obj).then(response => {
        //   this.$modal.msgSuccess("新增成功");
        //   this.open = false;
        //   this.getList();
        // });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除经营主体其他证件编号为"' + id + '"的数据项?').then(function () {
        return deleteOtherCertificateInfo(id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = { ...this.queryParams };
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有经营主体其他证件数据项?').then(() => {
        this.exportLoading = true;
        return exportOtherCertificateInfoExcel(params);
      }).then(response => {
        this.$download.excel(response, '经营主体其他证件.xls');
        this.exportLoading = false;
      }).catch(() => { });
    },
    //移除企业经营许可证
    handleRemovecertificatePhoto(file, fileList) {
      this.businessLicensePhoto = fileList
      fileList.length < 6 ? this.certificate = false : ''
      this.Logoimg = false;
    },
    //预览照片
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    //上传经营许可证，等于6张隐藏上传按钮
    changecertificatePhoto(file, fileList) {
      let check = this.beforeAvatarUpload(file);
      if (check) {
        fileList.length == 6 ? this.certificate = true : ''
        this.certificatePhoto = fileList
      } else {
        this.$refs.certificate.uploadFiles.splice(this.$refs.certificate.uploadFiles.length - 1, 1)
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
    //字符串转换成对应的upload接受类型参数
    ToUpload(imgurl) {
            //是否有多张图片
            if(imgurl==''||imgurl==undefined){
              return;
            }
            if (imgurl.indexOf(',') === -1) {
                if (imgurl instanceof Array) {
                } else {
                    imgurl = [imgurl]
                }
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
                    i == 0 ? Str = Arr[i].url : Str = Str+',' + Arr[i].url;

                }
                return Str
            }else{
            }

        }
  }
};
</script>
