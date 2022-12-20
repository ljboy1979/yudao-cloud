<template>
    <iframe :src="$store.state.baseURL_iframe.path + 'a/devices/devices/list'" frameborder="0" :style="{ width:'100%',height:'calc(100vh - 90px)'}"></iframe>
</template>
<script>
export default {
  name: 'demo02View',
}
</script>

