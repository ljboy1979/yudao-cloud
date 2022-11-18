<template>
    <div>
        <div class="title">进出记录</div>
        <el-table v-loading="loading" :data="list" stripe>
            <el-table-column label="会员名称" align="center" prop="id" />
            <el-table-column label="设备号" align="center" prop="nickname" />
            <el-table-column label="进场时间" align="center" prop="avatar" />
            <el-table-column label="出厂时间" align="center" prop="status" />
        </el-table>
    </div>
</template>
<script>
export default {
    name: 'passInAndOutRecord',
    props: {
        id: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            // 遮罩层
            // loading: true,
            loading: false,
            list: [],

        }
    },
    created() {
        console.log("6:",this.id)
    },
}
</script>
<style scoped>
.title {
    font-size: 24px;
    margin: 10px 0 20px 15px;
}
</style>