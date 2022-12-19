<template>
  <div>
    <doc-alert title="接口文档" url="https://doc.iocoder.cn/api-doc/" />
    <i-frame :src="url" />
  </div>
</template>
<script>
import iFrame from "@/components/iFrame/index";
export default {
  name: "Druid",
  components: { iFrame },
  data() {
    return {
      // url: process.env.VUE_APP_BASE_API + "/doc.html"
      url: process.env.VUE_DOC + "/doc.html"
      // url: "http://123.56.19.224:49087" + "/doc.html"
    };
  },
  created(){
    console.log(this.url);
  }
};
</script>
