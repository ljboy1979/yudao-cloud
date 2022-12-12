<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="区域编码" prop="areaCode">
        <el-input v-model="queryParams.areaCode" placeholder="请输入区域编码" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="区域名称" prop="areaName">
        <el-input v-model="queryParams.areaName" placeholder="请输入区域名称" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleParentAdd"
          v-hasPermi="['system:area:create']">新增</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-scrollbar style="height: 100%;">
      <el-table row-key="id" v-loading="loading" :data="list" :load="load" lazy :key="symbolKey"
        :tree-props="{ hasChildren: 'treeLeaf', }">
        <!-- <el-table-column label="区域编码" align="center" prop="id" /> -->
        <el-table-column label="区域编码" align="center" prop="areaCode" />
        <el-table-column label="全节点名" align="center" prop="treeNames" />
        <el-table-column label="区域名称" align="center" prop="areaName" />
        <el-table-column label="区域类型" align="center" prop="areaType">
          <template v-slot="scope">
            <dict-tag :type="DICT_TYPE.ADMINISTRATIVE_AREA_TYPE" :value="scope.row.areaType" />
          </template>
        </el-table-column>
        <el-table-column label="创建时间" align="center" prop="createTime" />
        <el-table-column label="更新时间" align="center" prop="updateTime" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template v-slot="scope">
            <el-button size="mini" type="text" icon="el-icon-plus" @click="handleAdd(scope.row)"
              v-hasPermi="['system:area:update']">新增</el-button>
            <el-button v-if="(scope.row.status == '0' && !scope.row.treeLeaf)" size="mini" type="text"
              icon="el-icon-circle-close" @click="handleStop(scope.row)" v-hasPermi="['system:area:update']">
              <span>停用</span>

            </el-button>
            <el-button v-if="(scope.row.status == '1' && !scope.row.treeLeaf)" size="mini" type="text"
              icon="el-icon-circle-check" @click="handleStop(scope.row)" v-hasPermi="['system:area:update']">
              <span>启用</span>
            </el-button>
            <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
              v-hasPermi="['system:area:update']">修改</el-button>
            <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
              v-hasPermi="['system:area:delete']">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-scrollbar>
    <!-- 对话框(添加 / 修改) -->
    <!-- <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="上级区域" prop="parentCode">
          <el-input v-model="form.parentCode" placeholder="请选择上级区域" disabled />
        </el-form-item>
        <el-form-item label="区域代码" prop="areaCode">
          <el-input v-model="form.parentCodes" placeholder="请输入区域代码" />
        </el-form-item>
        <el-form-item label="区域名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入区域名称" />
        </el-form-item>
        <el-form-item label="区域类型" prop="areaType">
          <el-select v-model="form.areaType" placeholder="请选择区域类型">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.ADMINISTRATIVE_AREA_TYPE)" :key="dict.value"
                :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="本级排序" prop="treeSort">
          <el-input v-model="form.treeSort" placeholder="请输入本级排序号（升序）" />
        </el-form-item>
        <el-form-item label="上" prop="top">
          <el-input v-model="form.top" placeholder="请输入上" />
        </el-form-item>
        <el-form-item label="下" prop="bottom">
          <el-input v-model="form.remarks" placeholder="请输入下" />
        </el-form-item>
        <el-form-item label="左" prop="left">
          <el-input v-model="form.remarks" placeholder="请输入左" />
        </el-form-item>
        <el-form-item label="右" prop="right">
          <el-input v-model="form.remarks" placeholder="请输入右" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.remarks" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.remarks" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注信息" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog> -->
    <!-- 父级添加区域 -->
    <el-dialog :title="title" :visible.sync="Parentopen" width="500px" v-dialogDrag append-to-body>
      <el-form ref="Parentform" :model="Parentform" :rules="Parentrules" label-width="80px">
        <el-form-item label="上级区域" prop="parentCode">
          <el-cascader :disabled="updateOrNo" v-model="Parentform.parentCode" :options="options" :lazy="true"
            :props="{ checkStrictly: true, value: 'id' }" clearable @change="handleChange" ref="cascaderMallCatergory"
            placeholder="请选择上级区域"></el-cascader>
        </el-form-item>
        <el-form-item label="区域代码" prop="areaCode">
          <el-input v-model="Parentform.areaCode" placeholder="请输入区域代码" />
        </el-form-item>
        <el-form-item label="区域名称" prop="areaName">
          <el-input v-model="Parentform.areaName" placeholder="请输入区域名称" />
        </el-form-item>
        <el-form-item label="区域类型" prop="areaType">
          <el-select v-model="Parentform.areaType" placeholder="请选择区域类型">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.ADMINISTRATIVE_AREA_TYPE)" :key="dict.value"
              :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="本级排序" prop="treeSort">
          <el-input v-model.number="Parentform.treeSort" placeholder="请输入本级排序号（升序）" />
        </el-form-item>
        <el-form-item label="上" prop="top">
          <el-input v-model="Parentform.top" placeholder="请输入上" />
        </el-form-item>
        <el-form-item label="下" prop="bottom">
          <el-input v-model.number="Parentform.bottom" placeholder="请输入下" />
        </el-form-item>
        <el-form-item label="左" prop="left">
          <el-input v-model.number="Parentform.left" placeholder="请输入左" />
        </el-form-item>
        <el-form-item label="右" prop="right">
          <el-input v-model.number="Parentform.right" placeholder="请输入右" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model.number="Parentform.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model.number="Parentform.latitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarks">
          <el-input v-model="Parentform.remarks" placeholder="请输入备注信息" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="Parentcancel">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { createArea, updateArea, deleteArea, getArea, getAreaList4Query, updateStatus, getTree } from "@/api/system/area";
import { DICT_TYPE } from "../../../utils/dict"
export default {
  name: "Area",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 行政区划列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      //父级新增
      Parentopen: false,
      // 查询参数
      queryParams: {
        areaCode: null,
        areaName: null,
      },
      // 表单参数
      form: {

      },
      Parentform: {},
      // 表单校验
      Parentrules: {
        parentCode: [
          { type: 'array', required: true, message: '请选择上级区域', trigger: 'change', }
        ],
        areaCode: [
          { required: true, message: '请输入区域代码', trigger: 'blur' },
          { pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        areaName: [
          { required: true, message: '请输入区域名称', trigger: 'blur' },
          { min: 1, max: 64, message: '最多输入64位', trigger: 'blur' }
        ],
        areaType: [
          { required: true, message: '请选择区域类型', trigger: 'change' },
        ],
        treeSort: [
          { required: true, message: '请输入本级排序号（升序）(数字)', trigger: 'blur' },
          { pattern: /^\d{1,10}$/, message: '最多输入10位(数字)', trigger: 'blur' }
        ],
        top: [
          {  required: false, message: '请输入上(数字)', trigger: 'blur' },
          {  pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        bottom: [
          { type: 'number', required: false, message: '请输入下(数字)', trigger: 'blur' },
          { type: 'number', pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        left: [
          { type: 'number', required: false, message: '请输入左(数字)', trigger: 'blur' },
          { type: 'number', pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        right: [
          { type: 'number', required: false, message: '请输入右(数字)', trigger: 'blur' },
          { type: 'number', pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        longitude: [
          { type: 'number', required: false, message: '请输入经度(数字或.)', trigger: 'blur' },
          { type: 'number', pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        latitude: [
          { type: 'number', required: false, message: '请输入纬度(数字或.)', trigger: 'blur' },
          { type: 'number', pattern: /^\d{1,64}$/, message: '最多输入64位(数字)', trigger: 'blur' }
        ],
        remarks: [
          { required: false, message: '请输入备注信息', trigger: 'blur' },
          { min: 1, max: 250, message: '最多输入250', trigger: 'blur' }
        ],
      },
      options: [],//行政区域级联选择
      parentCodeName: [],
      //修改or新增
      updateOrNo: false,
      symbolKey: '',//数据改变时动态加载
    };
  },
  created() {
    this.getList();
    // this.getAllTree();
  },
  methods: {
    handleChange(value) {
      console.log(value)
      this.parentCodeName = this.$refs['cascaderMallCatergory'].getCheckedNodes()[0].pathLabels
    },
    ////行政区划三级列表
    getAllTree() {
      getTree().then(response => {
        console.log(response.data);
        this.options = response.data
      })
    },
    //懒加载子节点
    load(tree, treeNode, resolve) {
      let obj = {}
      obj.areaCode = tree.areaCode
      // 执行查询
      console.log(obj)
      getAreaList4Query(obj).then(response => {
        console.log(response)
        resolve(this.StringtoBoolean(response.data))
      })
    },

    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getAreaList4Query().then(response => {
        console.log(response.data)
        // this.list=response.data
        this.list = this.StringtoBoolean(response.data);
        this.loading = false;
        this.symbolKey = Symbol(new Date().toString())
        this.getAllTree();
      });
    },
    //将treeLeaf由数字0/1转换为布尔值
    StringtoBoolean(arr) {
      if (!arr instanceof Array) {
        return;
      }
      for (let i = 0; i < arr.length; i++) {
        arr[i].treeLeaf == '1' ? arr[i].treeLeaf = false : arr[i].treeLeaf = true
      }
      return arr;
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
      };
      this.resetForm("form");
    },
    Parentreset() {
      this.Parentform = {
      };
      this.resetForm("Parentform");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList(this.queryParams);
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleParentAdd() {
      this.Parentopen = true;
      this.updateOrNo = false
      this.title = "添加行政区划";
    },
    /** 新增按钮操作 */
    handleAdd(row) {
      console.log(row)
      if (row) {
        let codeArr = row.parentCodes.split(',')
        let arr = []
        if (codeArr.length > 2) {
          for (let i = 1; i < codeArr.length - 1; i++) {
            arr.push(codeArr[i])
          }
        }
        console.log(arr)
        // if (arr.length == 0) {
          arr.push(row.areaCode)
        // }

        this.Parentform.parentCode = arr
        console.log(this.Parentform.parentCode)
      }
      this.updateOrNo = false
      this.Parentopen = true;
      this.title = "添加行政区划";

    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      console.log(row)
      if (row) {
        let obj = JSON.parse(JSON.stringify(row));
        obj.originParentCode=obj.parentCode
        let codeArr = obj.parentCodes.split(',')
        let arr = []
        if (codeArr.length > 2) {
          for (let i = 1; i < codeArr.length - 1; i++) {
            arr.push(codeArr[i])
          }
        }
        if (arr.length == 0) {
          arr.push(obj.areaCode)
        }
        this.parentCodeName = obj.treeNames.split('/')
        obj.parentCode = arr
        this.Parentform = obj
      }
      console.log(this.Parentform)
      this.Parentopen = true;
      this.updateOrNo = true
      this.title = "修改行政区划";
    },
    //启用停用按钮
    handleStop(row) {
      console.log(row)
      const id = row.id
      let status = row.status == 0 ? '停用' : '启用';
      this.$modal.confirm(`是否确认${status}该行政区域`).then(function () {
        //执行接口
        console.log(id)
        return updateStatus(id).then(response => {
          console.log(response)
        })
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess(`${status}成功!`);
      }).catch(() => {
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["Parentform"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.updateOrNo) {
          this.parentCodeName[this.parentCodeName.length - 1] = this.Parentform.areaName
          this.Parentform.treeNames = this.parentCodeName.join('/');
          let codes = this.Parentform.parentCode
          // this.Parentform.parentCode = this.Parentform.parentCode[this.Parentform.parentCode.length - 1]
          this.Parentform.parentCode=this.Parentform.originParentCode
          delete this.Parentform.originParentCode
          this.Parentform.parentCodes = '0,' + codes.toString() + ','
          this.Parentform.treeLeaf == false ? this.Parentform.treeLeaf = '1' : this.Parentform.treeLeaf = '0'
          console.log(this.Parentform, '修改参数')
          updateArea(this.Parentform).then(response => {
            console.log(response)
            this.$modal.msgSuccess("修改成功");
            this.Parentopen = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        this.Parentform.treeNames = this.parentCodeName.join('/');
        let codes = this.Parentform.parentCode
        this.Parentform.parentCode = this.Parentform.parentCode[this.Parentform.parentCode.length - 1]
        this.Parentform.parentCodes = '0,' + codes.toString() + ','
        console.log(this.Parentform, '新增参数')

        createArea(this.Parentform).then(response => {
          console.log(response)
          this.$modal.msgSuccess("新增成功");
          this.Parentopen = false;
          this.getList();
        });
      });
    },
    Parentcancel() {
      this.Parentopen = false
      this.Parentreset()


    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const areaCode = row.areaCode;
      this.$modal.confirm('是否确认删除行政区划编号为"' + areaCode + '"的数据项?').then(function () {
        return deleteArea(areaCode);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },

  }
};
</script>
