<template>
	<div class="gray-bg ">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>请填写需要生成的<span class="text-navy">应用信息</span>，选择需要使用的<span class="text-navy">Spring Cloud组件</span>、<span class="text-navy">其它组件</span></h5>
						</div>
						<div class="ibox-content">
							<form method="POST" class="form-horizontal" action="http://localhost:2222/download" enctype="text/plain">
                <div class="form-group" v-for="(item,index) in items">
                  <label class="col-sm-2 control-label">{{ item.key }}</label>
                  <div class="col-sm-8">
                    <input v-if="item.type == 'TEXTFIELD'" class="form-control" :name="item.key" :value="item.value">
                    <el-switch v-if="item.type == 'CHECKBOX'" v-model="items[index].value" :name="item.key"></el-switch>
                    <el-select v-if="item.type == 'COMBOBOX'" v-model="items[index].value" :name="item.key" :select2Style="select2Style" :placeholder="item.label">
                      <el-option v-if="item.type == 'COMBOBOX'" v-for="option in item.options" :label="option" :value="option"></el-option>
                    </el-select>
                    <span v-if="item.type != 'COMBOBOX'">{{ item.label }}</span>
                  </div>
                </div>

                <strong data-v-fae5bece="" class="title">{{ chkboxModule.label }}</strong>
                <h5>{{ chkboxModule.description }}</h5>

                <strong data-v-fae5bece="" class="title">{{ radioModule.label }}</strong>
                <h5>{{ radioModule.description }}</h5>

                <strong data-v-fae5bece="" class="title">{{ comboModule.label }}</strong>
                <h5>{{ comboModule.description }}</h5>

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

	export default {
    components: {ElSwitch},
    name: 'survey',

		data: function() {
			return{
				select2Style: {//select2-style样式
					width: '100%'
				},
				form: {
					name: '',
					region: '',
					date1: '',
					date2: '',
					delivery: false,
					type: [],
					resource: '',
					desc: ''
				},
				options:{
					proposal:[
						{ id: '1.8', text: '1.8' },
						{ id: '1.5', text: '1.5' },
					],
				},
				radioValue: 'middle',
				radioValues: 'a',
				checkboxValue: ['one'],
        items: [{}],
        chkboxModule: {
				  label: 'CheckBox配置',
          description: 'CheckBox配置',
          key: 'configCheckBox',
          column: 2
        },
        chkboxItems: [{}],
        radioModule: {
          label: 'Radio配置',
          description: 'Radio配置',
          key: 'configRadio',
          column: 2
        },
        radioItems: [{}],
        comboModule: {
          label: 'ComboBox配置',
          description: 'ComboBox配置',
          key: 'configComboBox',
          column: 2
        },
        comboItems: [{}]
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
            console.log(data);
            vue.builtGlobalDom(data[0].entityList);
            vue.builtCheckBoxDom(data[1]);
            vue.builtRadioDom(data[2]);
            vue.builtComboDom(data[3]);
          }
        });
      },
      builtGlobalDom: function (data) {
        var i = 0 ;
        for (i in data) {
          var tmp = {};
          tmp.defaultable = data[i].defaultable;
          tmp.editable = data[i].editable;
          tmp.emptiable = data[i].emptiable;
          tmp.highlightable = data[i].highlightable;
          tmp.key = data[i].key;
          tmp.label = data[i].label;
          tmp.options = data[i].options;
          tmp.type = data[i].type;
          tmp.value = data[i].value;
          this.items.push(tmp);
        }
      },
      builtCheckBoxDom: function (data) {
        this.radioModule.label = data.label;
        this.radioModule.key = data.key;
        this.radioModule.description = data.description;
        this.radioModule.column = data.column;
        var i = 0;
        for (i in data) {

        }
      },
      builtComboDom: function (data) {

      },
      builtRadioDom: function (data) {

      }
		},
		mounted: function() {

		}
	}
</script>
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
