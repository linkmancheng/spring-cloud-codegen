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
							<form method="get" class="form-horizontal">
								<div class="form-group">
									<label class="col-sm-2 control-label">应用名</label>
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
										<el-select v-model="form.region" :select2Style="select2Style" placeholder="请选择jdk版本">
											<el-option label="1.7" value="1.7"></el-option>
											<el-option label="1.8" value="1.8"></el-option>
										</el-select>
										<!--<select2 :options="options.proposal" :select2Style="select2Style"></select2>-->
										<!--<input type="text" class="form-control">-->
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">应用类型</label>
									<div class="col-sm-10">
										<n3-radio-group v-model="radioValue" type="primary" style="margin-top: 7px;">
											<n3-radio label="left">Spring Boot应用<span class="text-navy">（推荐）</span></n3-radio>
											</n3-radio>
											<n3-radio label="middle">Spring Cloud应用<span class="text-navy">（推荐）</span></n3-radio>
											<n3-radio label="right">Venus Cloud应用</n3-radio>
										</n3-radio-group>
									</div>
								</div>
								<div class="hr-line-dashed"></div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Docker模板</label>
									<div class="col-sm-10">
										<n3-radio-group v-model="radioValues" type="primary" style="margin-top: 7px;">
											<n3-radio label="a">是</n3-radio>
											<n3-radio label="b">否</span></n3-radio>
										</n3-radio-group>
									</div>
								</div>
								<div class="hr-line-dashed"></div>
								<div class="form-group">
									<label class="col-sm-2 control-label">共同基础组件<br><small class="text-navy">请按需勾选</small></label>
									<div class="col-sm-10" style="margin-top: 10px;">
										<div class="col-sm-4">
											<n3-checkbox label="one">
												<span>Spring MVC</span>
												<span class="text-navy style">（推荐）</span>
												<p style="padding: 6px 17px;">Spring Web框架</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>Mybatis</span>
												<span class="text-navy style">（推荐）</span>
												<p style="padding: 6px 17px;">ORM框架</p>
											</n3-checkbox>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Spring Cloud组件<br><small class="text-navy">请按需勾选</small></label>
									<div class="col-sm-10" style="margin-top: 10px;">
										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>Eureka</span>
												<p style="padding: 6px 17px;">注册组件</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="one">
												<span>Zuul</span>
												<p style="padding: 6px 17px;">网关</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>zookeeper</span>
												<p style="padding: 6px 17px;">服务注册组件</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>Consul</span>
												<p style="padding: 6px 17px;">服务注册组件</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="one">
												<span>Feign</span>
												<p style="padding: 6px 17px;">Feign调用组件</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>Ribbon</span>
												<p style="padding: 6px 17px;">Ribbon负载均衡组件</p>
											</n3-checkbox>
										</div>

										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>Ribbon</span>
												<p style="padding: 6px 17px;">Ribbon负载均衡组件</p>
											</n3-checkbox>
										</div>

										<div class="col-sm-4">
											<n3-checkbox label="two">
												<span>Spring Cloud Gateway</span>
												<p style="padding: 6px 17px;">Spring Cloud Gateway网关</p>
											</n3-checkbox>
										</div>


									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Venus产品<br><small class="text-navy">请按需勾选</small></label>
									<div class="col-sm-10" style="margin-top: 10px;">
										<div class="col-sm-4">
											<n3-checkbox label="one">
												<span>Venus Boot</span>
												<span class="text-navy style">（推荐）</span>
												<p style="padding: 6px 17px;">Venus Boot框架</p>
											</n3-checkbox>
										</div>
										<div class="col-sm-4">
											<n3-checkbox label="two" disabled>
												<span>Venus Cloud</span>
												<p style="padding: 6px 17px;">Venus Cloud产品</p>
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

<script>

  import axios from 'axios'
  import $ from '@/../static/js/jquery'

	export default {
		name: 'survey',
//		components: {//select2-定义select2在当前组件中的名称
//		},

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
			}
		},
    created () {
      this.fetchData()
    },
		methods: {

      fetchData: async function () {
//        const entity = this.getInit('getMetaData');
        const entity2 = this.getInitJq('getMetaData');
      },

      getInitJq : function (url) {
        return $.ajax({
          type: 'GET',
          url: 'http://localhost:2222/' + url,
          dataType: 'json',
          success: function (data) {

          }
        });
      },

      getInit : function (url) {
        return axios({
          method: 'get',
          baseURL: 'http://localhost:2222/',
          url,
          timeout: 10000,
          headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json; charset=UTF-8',
            'Accept': 'application/json'
          }
        }).then(
          (response) => {
            // loading.close()
            return response
          }
        ).then(
          (res) => {
            return res
          }
        )
      }

		},
		mounted: function() {
			var that = this;
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
