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
      url: "http://123.56.19.224:49087" + "/doc.html"
    };
  },
};
</script>
