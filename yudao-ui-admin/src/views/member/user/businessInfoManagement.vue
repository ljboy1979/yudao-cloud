<template>
  <div class="app-container">

    <el-tabs v-model="activeName" type="card" @tab-click="handleClick" lazy="true">
      <el-tab-pane label="企业信息" name="first">
        <div class="title">基本信息</div>
      </el-tab-pane>
      <el-tab-pane label="设施" name="second">
        <div class="title">设施</div>
      </el-tab-pane>
      <el-tab-pane label="设备" name="">
        <div class="title">设备</div>
      </el-tab-pane>
      <el-tab-pane label="地块" name="">
        <div class="title">地块</div>
      </el-tab-pane>
      <el-tab-pane label="交易账单" name="">
        <div class="title">交易账单</div>
      </el-tab-pane>
      <el-tab-pane label="政策补贴记录" name="">
        <div class="title">政策补贴记录</div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "User",
  components: {
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
