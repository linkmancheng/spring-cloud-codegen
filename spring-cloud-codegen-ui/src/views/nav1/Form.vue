<template>
  <div class="gray-bg ">
    <div class="wrapper wrapper-content animated fadeInRight">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
          <div class="ibox float-e-margins">
            <div class="ibox-content">
              <form method="POST" class="form-horizontal" action="http://localhost:2222/downloadResponse" enctype="text/plain">
                <div class="module-item" v-for="(module,number) in modules">
                  <div class="form-group" v-if="module.entityList[0].type != 'RADIO' && item.type != 'CHECKBOX'" v-for="(item,index) in module.entityList">
                    <label v-if="item.type != 'RADIO' && item.type != 'CHECKBOX'" class="col-sm-2 control-label">{{ item.label }}</label>
                    <div class="col-sm-8" v-if="item.type != 'RADIO' && item.type != 'CHECKBOX'">
                      <input v-if="item.type == 'TEXTFIELD'" class="form-control" :name="item.key" :value="item.value" required>
                      <span v-if="item.highlightable && item.type == 'TEXTFIELD'" class="must-need">*</span>
                      <el-select v-if="item.type == 'COMBOBOX'" v-model="modules[number].entityList[index].value" :name="item.key" :select2Style="select2Style" :placeholder="item.label">
                        <el-option v-if="item.type == 'COMBOBOX'" v-for="option in item.options" :label="option" :value="option"></el-option>
                      </el-select>
                    </div>
                  </div>
                  <div class="form-group" v-else-if="module.entityList[0].type == 'RADIO' && index == 1">
                    <label class="col-sm-2 control-label" v-if="index == 1">{{ module.label }}</label>
                    <div class="col-sm-10">
                      <div v-for="(radio,rnum) in module.entityList" class="col-sm-2" v-if="index == 1">
                        <el-radio  :label="radio.key" v-model="item.value" :name="module.key" >{{ radio.label }}</el-radio>
                      </div>
                    </div>

                  </div>
                  <div class="form-group" v-else-if="module.entityList[0].type == 'CHECKBOX' && index == 1">
                    <label class="col-sm-2 control-label" v-if="index == 1" style="margin-top: -7px;">{{ module.label }}</label>
                    <div class="col-sm-10" v-if="index == 1">
                      <el-checkbox-group v-model="modules[number].values">
                        <div v-for="(chkbox,cnum) in module.entityList" :class="'col-sm-2'">
                          <el-checkbox  :label="chkbox.label" :name="chkbox.key" style="color:#666" value="false"></el-checkbox>
                          <span v-if="chkbox.defaultable" class="recommend">（推荐）</span>
                        </div>
                      </el-checkbox-group>
                    </div>
                  </div>
                  <hr>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group" style="text-align:center;">
                  <div class="col-sm-12">
                    <a class="btn btn-default" type="button" href="#">重置</a>
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

<script>

  import axios from 'axios'
  import $ from '@/../static/js/jquery'
  import ElSwitch from "../../../node_modules/element-ui/packages/switch/src/component.vue";
  import ElRadio from "../../../node_modules/element-ui/packages/radio/src/radio.vue";
  import N3Radio from "../../../node_modules/N3-components/src/Radio/n3Radio.vue";
  import ElCheckboxGroup from "../../../node_modules/element-ui/packages/checkbox/src/checkbox-group.vue";
  import ElCheckbox from "../../../node_modules/element-ui/packages/checkbox/src/checkbox.vue";

  export default {
    components: {
      ElCheckbox,
      ElCheckboxGroup,
      N3Radio,
      ElRadio,
      ElSwitch},
    name: 'survey',

    data: function() {
      return{
        select2Style: {//select2-style样式
          width: '100%'
        },
        modules: [],
      }
    },
    created () {
      this.fetchData()
    },
    methods: {

      fetchData: async function () {
        this.getInitJq('getMetaData');
      },

      getInitJq : function (url) {
        var vue = this;
        return $.ajax({
          type: 'GET',
          url: 'http://localhost:2222/' + url,
          dataType: 'json',
          success: function (data) {
            vue.builtModules(data);
          }
        });
      },
      builtModules: function (data) {
        var i = 0;
        for (i in data) {
          var tmp = {};
          tmp.key = data[i].key;
          tmp.label = data[i].label;
          tmp.description = data[i].description;
          tmp.column = data[i].column;
          tmp.entityList = data[i].entityList;
          tmp.values = [];
          this.modules.push(tmp);
        }
      }

    },
    mounted: function() {

    }
  }
</script>
<style scoped>
  .recommend {
    color:#20a0ff;
    padding-left: 15px;
    font-size: 8pt;
  }
  .must-need{
    color:#20a0ff;
    font-size:15pt;
    display: block;
    position: absolute;
    top:7px;
    right:0px;
  }
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
