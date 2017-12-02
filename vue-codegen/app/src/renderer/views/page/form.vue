<template>
        <!--<el-form ref="form" :model="form" label-width="80px">-->
            <!--<el-form-item label="活动名称">-->
                <!--<el-input v-model="form.name"></el-input>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="活动区域">-->
                <!--<el-select v-model="form.region" placeholder="请选择活动区域">-->
                    <!--<el-option label="区域一" value="shanghai"></el-option>-->
                    <!--<el-option label="区域二" value="beijing"></el-option>-->
                <!--</el-select>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="活动时间">-->
                <!--<el-col :span="11">-->
                    <!--<el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>-->
                <!--</el-col>-->
                <!--<el-col class="line" :span="2">-</el-col>-->
                <!--<el-col :span="11">-->
                    <!--<el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>-->
                <!--</el-col>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="即时配送">-->
                <!--<el-switch on-text="" off-text="" v-model="form.delivery"></el-switch>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="活动性质">-->
                <!--<el-checkbox-group v-model="form.type">-->
                    <!--<el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>-->
                    <!--<el-checkbox label="地推活动" name="type"></el-checkbox>-->
                    <!--<el-checkbox label="线下主题活动" name="type"></el-checkbox>-->
                    <!--<el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>-->
                <!--</el-checkbox-group>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="特殊资源">-->
                <!--<el-radio-group v-model="form.resource">-->
                    <!--<el-radio label="线上品牌商赞助"></el-radio>-->
                    <!--<el-radio label="线下场地免费"></el-radio>-->
                <!--</el-radio-group>-->
            <!--</el-form-item>-->
            <!--<el-form-item label="活动形式">-->
                <!--<el-input type="textarea" v-model="form.desc"></el-input>-->
            <!--</el-form-item>-->
            <!--<el-form-item>-->
                <!--<el-button type="primary" @click="onSubmit">立即创建</el-button>-->
                <!--<el-button>取消</el-button>-->
            <!--</el-form-item>-->
        <!--</el-form>-->



        <div class="gray-bg ">
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>请填写需要生成的<samll class="text-navy">应用信息</samll>，选择需要使用的<samll class="text-navy">中间件</samll>、<samll class="text-navy">基础产品</samll></h5>
                            </div>
                            <div class="ibox-content">
                                <form method="get" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Aone应用名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Group</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Artifact</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Java Version</label>
                                        <div class="col-sm-10">
                                            <select2 :options="options.proposal" :select2Style="select2Style"></select2>
                                            <!--<input type="text" class="form-control">-->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">应用类型</label>
                                        <div class="col-sm-10">
                                            <n3-radio-group v-model="radioValue" type="primary" style="margin-top: 7px;">
                                                <n3-radio label="left">微服务应用（Pandora Boot）</n3-radio>
                                                <n3-radio label="middle">集成Spring Boot<samll class="text-navy">（推荐）</samll></n3-radio>
                                                <n3-radio label="right">传统War应用</n3-radio>
                                            </n3-radio-group>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Docker模板</label>
                                        <div class="col-sm-10">
                                            <n3-radio-group v-model="radioValues" type="primary" style="margin-top: 7px;">
                                                <n3-radio label="a">是</n3-radio>
                                                <n3-radio label="b">否</samll></n3-radio>
                                            </n3-radio-group>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Web框架<br><small class="text-navy">请按需勾选</small></label>
                                        <div class="col-sm-10" style="margin-top: 10px;">
                                            <div class="col-sm-4">
                                                <n3-checkbox label="one">
                                                    <span>Spring MVC</span>
                                                    <samll class="text-navy style">（推荐）</samll>
                                                    <p style="padding: 6px 17px;">Spring Web框架</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="two" disabled>
                                                    <span>webX3</span>
                                                    <p style="padding: 6px 17px;">集团通用Web框架</p>
                                                </n3-checkbox>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">中间件<br><small class="text-navy">请按需勾选</small></label>
                                        <div class="col-sm-10" style="margin-top: 10px;">
                                            <div class="col-sm-4">
                                                <n3-checkbox label="two">
                                                    <span>HSF</span>
                                                    <p style="padding: 6px 17px;">阿里高性能服务框架</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="one">
                                                    <span>TDDL</span>
                                                    <p style="padding: 6px 17px;">分库分表数据库服务</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="two">
                                                    <span>ONS</span>
                                                    <p style="padding: 6px 17px;">分布式消息服务</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="two">
                                                    <span>HSF</span>
                                                    <p style="padding: 6px 17px;">阿里高性能服务框架</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="one">
                                                    <span>TDDL</span>
                                                    <p style="padding: 6px 17px;">分库分表数据库服务</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="two">
                                                    <span>ONS</span>
                                                    <p style="padding: 6px 17px;">分布式消息服务</p>
                                                </n3-checkbox>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">基础产品<br><small class="text-navy">请按需勾选</small></label>
                                        <div class="col-sm-10" style="margin-top: 10px;">
                                            <div class="col-sm-4">
                                                <n3-checkbox label="one">
                                                    <span>Spring MVC</span>
                                                    <samll class="text-navy style">（推荐）</samll>
                                                    <p style="padding: 6px 17px;">Spring Web框架</p>
                                                </n3-checkbox>
                                            </div>
                                            <div class="col-sm-4">
                                                <n3-checkbox label="two" disabled>
                                                    <span>webX3</span>
                                                    <p style="padding: 6px 17px;">集团通用Web框架</p>
                                                </n3-checkbox>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group" style="text-align:center;">
                                        <div class="col-sm-12">
                                            <button class="btn btn-white" type="submit">重置</button>
                                            <button class="btn btn-primary" type="submit">生成工程</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



</template>

<!--<script>-->
  <!--export default {-->
    <!--data() {-->
      <!--return {-->
        <!--form: {-->
          <!--name: '',-->
          <!--region: '',-->
          <!--date1: '',-->
          <!--date2: '',-->
          <!--delivery: false,-->
          <!--type: [],-->
          <!--resource: '',-->
          <!--desc: ''-->
        <!--}-->
      <!--}-->
    <!--},-->
    <!--methods: {-->
      <!--onSubmit() {-->
        <!--console.log('submit!');-->
      <!--}-->
    <!--}-->
  <!--}-->
<!--</script>-->



<!--<script>-->
<!--//import select2 from '../../components/common/select2/select2.vue';-->
<!--export default {-->
    <!--name: 'survey',-->

    <!--data() {-->
        <!--return {-->
            <!--select2Style: {// select2-style样式-->
                <!--width: '100%'-->
            <!--},-->
            <!--options: {-->
                <!--proposal: [-->
                    <!--{ id: '1.8', text: '1.8' },-->
                    <!--{ id: '1.5', text: '1.5' }-->
                <!--]-->
            <!--},-->
            <!--radioValue: 'middle',-->
            <!--radioValues: 'a',-->
            <!--checkboxValue: ['one']-->
        <!--}-->
    <!--},-->
    <!--methods: {-->
    <!--},-->
    <!--mounted() {-->
<!--//        var that = this;-->
    <!--}-->
<!--}-->
<!--</script>-->
<style scoped>
    .el-radio{
        color:#666;
        font-size:12px;
        margin-top:7px;
    }
    .style{
        margin-left: 20px;
        top: 7px;
        position: relative;
    }
    .col-sm-4{
        padding-left: 0px;
    }

</style>
