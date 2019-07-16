/**
 *字符串空判断
 *日期工具方法
 *loading插件
 *alert插件
 */

//字符串是否为空
String.prototype.isEmpty=function (str){
	return str==undefined||str==null||str.trim()=="";
}
function isEmpty(str){
	return str==undefined||str==null||str.trim()=="";
}
function isNotEmpty(str){
	return !isEmpty(str);
}

/*小光日期工具类*/
var guangDate = {
 /*转换日期*/
 _transferDate : function(date){
	if(typeof date =="string"){
		return new Date(date.replace(/-/ig,"/"));
	}else{
		return date;
	}
 },
  /*格式化日期*/
 _toString : function(date,pattern){
	var d = this._transferDate(date);
	return d.format(pattern);
 },

 /*获取两个时间相减的时间*/
 _Date : function(date1,date2){
	var dateTime = this._numMillSecond(date1,date2);
	return new Date(dateTime).format("yyyy-MM-dd");
 },

 //间隔年份
 _numYear : function(date1,date2){
	var times = this._numDay(date1,date2);
	return  Math.floor(times/365);
 },

  //间隔月份
 _numMonth : function(date1,date2){
	var times = this._numDay(date1,date2);
	return  Math.floor(times/30);
 },

 //间隔天数
 _numDay : function(date1,date2){
	var times = this._numSecond(date1,date2);
	var hour = this._var().hour;
	var mills = this._var().mills;
	return Math.ceil(times/(mills * hour));
 },

//间隔时
 _numHour : function(date1,date2){
	return Math.floor(this._numMillSecond(date1,date2)/(1000*60*60));
 },

 //间隔分
 _numMinute : function(date1,date2){
	return Math.floor(this._numMillSecond(date1,date2)/(1000*60));
 },

 //间隔秒数
 _numSecond : function(date1,date2){
	 return Math.floor(this._numMillSecond(date1,date2) / 1000);
 },

  //间隔毫秒
 _numMillSecond : function(date1,date2){
	var stimes = this._getTime(this._transferDate(date1));
	var etimes = this._getTime(this._transferDate(date2));
	return etimes - stimes;
 },

 _var : function(){
	return {hour:24,second:60,mills:3600,format:"yyyy-MM-dd",dateFormat:"yyyy-MM-dd HH:mm:ss"};
 },

/*某个日期加上多少毫秒*/
 _plusMillisSeconds : function(date,millisSeconds){
	var dateTime = this._getTime(date);
	var mintimes = millisSeconds;
	var rdate = dateTime*1 + mintimes*1;
	return this._format(new Date(rdate));
 },
 /*某个日期加上多少秒*/
 _plusSeconds : function(date,seconds){
	var dateTime = this._getTime(date);
	var mintimes = seconds*1000;
	var rdate = dateTime*1 + mintimes*1;
	return this._format(new Date(rdate));
 },
  /*某个日期加上多少分钟*/
 _plusMinutes : function(date,minutes){
	var dateTime = this._getTime(date);
	var mintimes = minutes*60*1000;
	var rdate = dateTime*1 + mintimes*1;
	return this._format(new Date(rdate));
 },
  /*某个日期加上小时数*/
 _plusHours : function(date,hours){
	var dateTime = this._getTime(date);
	var mintimes = hours*60*60*1000;
	var rdate = dateTime + mintimes;
	return this._format(new Date(rdate));
 },
 /*某个日期加上天数*/
 _plusDays : function(date,days){
	var dateTime = this._getTime(date);
	var mintimes = days*60*60*1000*24;
	var rdate = dateTime*1 + mintimes*1;
	return this._format(new Date(rdate));
 },

 /*某个日期加上多少个月,这里是按照一个月30天来计算天数的*/
 _plusMonths : function(date,months){
	var dateTime = this._getTime(date);
	var mintimes = months*30*60*60*1000*24;
	var rdate = dateTime + mintimes*1;
	return this._format(new Date(rdate));
 },

 /*某个日期加上多少个年,这里是按照一个月365天来计算天数的，如果loop为true则按闰年计算*/
 _plusYears : function(date,years,isLoop){
	var dateTime = this._getTime(date);
	var day = 365;
	if(isLoop)day =366;
	var mintimes = years*day*60*60*1000*24;
	var rdate = dateTime + mintimes;
	return this._format(new Date(rdate));
 },

 /*某个日期加上某个日期，这样的操作视乎没什么意义*/
 _plusDate : function(date1,date2){
	var dateTime = this._getTime(date1);
	var dateTime2 = this._getTime(date2);;
	var rdate = dateTime + dateTime2;
	return this._format(new Date(rdate));
 },

 /*某个日期减去多少毫秒秒*/
 _minusMillisSeconds : function(date,millisSeconds){
	var dateTime = this._getTime(date);
	var mintimes = millisSeconds*1;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },
 /*某个日期减去多少秒*/
 _minusSeconds : function(date,seconds){
	var dateTime = this._getTime(date);
	var mintimes = seconds*1000;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },
  /*某个日期减去多少分钟*/
 _minusMinutes : function(date,minutes){
	var dateTime = this._getTime(date);
	var mintimes = minutes*60*1000;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },
  /*某个日期减去小时数*/
 _minusHours : function(date,hours){
	var dateTime = this._getTime(date);
	var mintimes = hours*60*60*1000;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },
 /*某个日期减去天数*/
 _minusDays : function(date,days){
	var dateTime = this._getTime(date);
	var mintimes = days*60*60*1000*24;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },

 /*某个日期减去多少个月,这里是按照一个月30天来计算天数的*/
 _minusMonths : function(date,months){
	var dateTime = this._getTime(date);
	var mintimes = months*30*60*60*1000*24;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },

 /*某个日期减去多少个年,这里是按照一个月365天来计算天数的*/
 _minusYears : function(date,years,isLoop){
	var dateTime = this._getTime(date);
	var day = 365;
	if(isLoop)day =366;
	var mintimes = years*day*60*60*1000*24;
	var rdate = dateTime - mintimes;
	return this._format(new Date(rdate));
 },

 /*某个日期减去某个日期，这样的操作视乎没什么意义*/
 _minusDate : function(date1,date2){
	var dateTime = this._getTime(date1);
	var dateTime2 = this._getTime(date2);;
	var rdate = dateTime - dateTime2;
	return this._format(new Date(rdate));
 },

 /*获取一个月有多少天*/
 _getMonthOfDay :function(date1){
	var currentMonth = this._getFirstDayOfMonth(date1);
	var nextMonth = this._getNextDayOfMonth(date1);
	return this._numDay(currentMonth,nextMonth);
 },

 /*获取一年又多少天*/
 _getYearOfDay : function(date){
	var firstDayYear = this._getFirstDayOfYear(date);
	var lastDayYear = this._getLastDayOfYear(date);
	return Math.ceil(this._numDay(firstDayYear,lastDayYear));
 },

 /*某个日期是当年中的第几天*/
 _getDayOfYear : function(date1){
	return Math.ceil(this._numDay(this._getFirstDayOfYear(date1),date1));	
 },

 /*某个日期是在当月中的第几天*/
  _getDayOfMonth : function(date1){
	return Math.ceil(this._numDay(this._getFirstDayOfMonth(date1),date1));	
 },

 /*获取某个日期在这一年的第几周*/
 _getDayOfYearWeek : function(date){
	var numdays = this._getDayOfYear(date);
	return Math.ceil(numdays / 7);
 },

  /*某个日期是在当月中的星期几*/
  _getDayOfWeek : function(date1){
	return this._getWeek(date1);
 },

 /*获取在当前日期中的时间*/
 _getHourOfDay : function(date){
	 return this._getHour(date);
 },
 _eq : function(date1,date2){
	 var stime = this._getTime(this._transferDate(date1));
	 var etime = this._getTime(this._transferDate(date2));
	 return stime == etime ? true :false; 
 },
 /*某个日期是否晚于某个日期*/
 _after : function(date1,date2){
	 var stime = this._getTime(this._transferDate(date1));
	 var etime = this._getTime(this._transferDate(date2));
	 return  stime < etime ? true :false; 
 },

  /*某个日期是否早于某个日期*/
 _before : function(date1,date2){
	 var stime = this._getTime(this._transferDate(date1));
	 var etime = this._getTime(this._transferDate(date2));
	 return  stime > etime ? true :false; 
 },
 
 /*获取某年的第一天*/
 _getFirstDayOfYear : function(date){
	var year = this._getYear(date);
	var dateString = year+"-01-01 00:00:00";
	return dateString;
 },

  /*获取某年的最后一天*/
 _getLastDayOfYear : function(date){
	var year = this._getYear(date);
	var dateString = year+"-12-01 00:00:00";
	var endDay = this._getMonthOfDay(dateString);
	return year+"-12-"+endDay+" 23:59:59";
 },

  /*获取某月的第一天*/
 _getFirstDayOfMonth: function(date){
	var year = this._getYear(date);
	var month = this._getMonth(date);
	var dateString = year +"-"+month+"-01 00:00:00";
	return dateString;
 },

 /*获取某月最后一天*/
 _getLastDayOfMonth : function(date){
	var endDay = this._getMonthOfDay(date);
	var year = this._getYear(date);
	var month = this._getMonth(date);
	return year +"-"+month+"-"+endDay+" 23:59:59";
 },
 /*一天的开始时间*/
 _getFirstOfDay : function(date){
	 var year = this._getYear(date);
	 var month = this._getMonth(date);
	 var dates = this._getDay(date);
	 return year+"-"+month+"-"+dates+" 00:00:00";
 },

 /*一天的结束时间*/
 _getLastOfDay : function(date){
	 var year = this._getYear(date);
	 var month = this._getMonth(date);
	 var dates = this._getDay(date);
	 return year+"-"+month+"-"+dates+" 23:59:59";
 },
 
 /*获取下个月的第一天*/
 _getNextDayOfMonth: function(date){
	var year = this._getYear(date);
	var month = this._getMonth(date);
	month = month * 1 +1;
	if(month>12){
		year = year+1;
		month = month - 12;
	}
	month = month>9 ? month : "0"+month;
	var dateString = year +"-"+month+"-01 00:00:00";
	return dateString;
 },

 _getFirstOfWeek : function(date1){
	 var week = this._getWeek(date1);
	 var date = this._minusDays(date1,week);
	 var year = this._getYear(date);
	 var month = this._getMonth(date);
	 var dates = this._getDay(date);
	 return year+"-"+month+"-"+dates+" 00:00:00";
 },
 
 _getLastOfWeek : function(date1){
	 var week = 6-this._getWeek(date1);
	 var date = this._minusDays(date1,week);
	 var year = this._getYear(date);
	 var month = this._getMonth(date);
	 var dates = this._getDay(date);
	 return year+"-"+month+"-"+dates+" 23:59:59";
 },
 
 _getNow : function(){
	return new Date();	
 },
 _format : function(date){
	return this._getYear(date)+"-"+this._getMonth(date)+"-"+this._getDay(date)+" "+this._getHour(date)+":"+this._getMinute(date)+":"+this._getSecond(date);
 },
 _getDate :function(){
	 return this._getNow();
 },
 /*年*/
 _getYear:function(date){
	 return this._transferDate(date).getFullYear();
 },

 /*月*/
 _getMonth:function(date){
	 var month = this._transferDate(date).getMonth()+1;
	 return month>9 ? month : "0"+month;
 },

 /*日*/
 _getDay:function(date){
	 var day = this._transferDate(date).getDate();
	 return day >9 ? day : "0"+day;
 },

  /*获取今天星期几,如果为0代表星期日*/
 _getWeek : function(date){
	 return this._transferDate(date).getDay();
 },

 /*时*/
 _getHour : function(date){
	 var hour = this._transferDate(date).getHours();
	 return hour >9 ? hour : "0"+hour;
 },

 /*12小时制时*/
 _getHour12 : function(date){
	 var hour = this._transferDate(date).getHours();
	 return hour%12 == 0 ? 12 : hour % 12;
 },

 /*分*/
 _getMinute : function(date){
	 var minutes = this._transferDate(date).getMinutes();
	 return minutes >9 ? minutes : "0"+minutes;
 },

 /*秒*/
 _getSecond : function(date){
	var seconds = this._transferDate(date).getSeconds();
	return seconds >9 ? seconds : "0"+seconds;
 },

 /*毫秒*/
 _getMillisecond : function(date){
	return this._transferDate(date).getMilliseconds();
 },

 /*获取今天在当年是第几季度*/
 _getPeriod : function(date){
	var month = this._getMonth(date)*1;
	return  Math.floor((month+3)/3);
 },

 /*星期*/
 _nowWeekChinies : function(date){
	var nowWeek = this._getWeek(date);
	var day = "";
	switch (nowWeek){
		case 0:day="日";break;
		  break;
		case 1:day="一";break;
		  break;
		case 2:day="二";break;
		  break;
		case 3:day="三";break;
		  break;
		case 4:day="四";break;
		  break;
		case 5:day="五";break;
		  break;
		case 6:day="六";break;
	 }
	 return day;
 },

 /*返回 1970 年 1 月 1 日至今的毫秒数。*/
 _getTime : function(date){
	 return this._transferDate(date).getTime();
 }
};
//小光Loading插件
var guangLoading={
	templates:function(){
		var templateArr=[];
		templateArr.push("<div id='loadingBar'></div>");
		templateArr.push("<div id='loadingBox'>"+
				"	<img src='"+guangUtils.getContextPath()+"/images/guangImg/loadingBox/loading5.gif' width='36' height='36'/>"+
				"	<span>数据加载中。。。</span>"+
				"</div>");
		return  templateArr[this.params.templateNum];	
	},
	params:{},
	defaultParams:{
		loadingSel:"#loadingBar",
		templateNum:0,
		auto:false,
		callback:function(){}
	},
	init:function(json){
		$.extend(this.params,{},this.defaultParams,json);
		//根据选择的模板编号切换对应的选择器
		if(0==this.params.tempateNum){
			this.params.loadingSel="#loadingBar";
		}else if(1==this.params.templateNum){
			this.params.loadingSel="#loadingBox";
		}else{
		    this.params.loadingSel="#loadingBar";
		}
		//loading模板添加到dom中
		if($(this.params.loadingSel)){
			$("body").append(this.templates());
			if(this.params.content){
				$(this.params.loadingSel).find("span").html(this.params.content);
			}
		}
		//居中
		if(this.params.templateNum==1){
			guangUtils.center(this.params.loadingSel);
		}
		//设置背景颜色
		if(this.params.bgColor){
			$(this.params.loadingSel).css("background-color",this.params.bgColor);
		}
		return this;
	},
	show:function(){
		$(this.params.loadingSel).show();
		var _this=this;
		if(this.params.auto){
			setTimeout(function(){
				_this.fadeOut(2000);
			},2000);
		}
		return this;
	},
	hide:function(){
		$(this.params.loadingSel).hide(function(){
			this.remove();
		});
		if(this.params.callback){
			this.params.callback();
		}
		return this;
	},
	fadeIn:function(time){
		if(time){
			$(this.params.loadingSel).fadeIn(time);
		}else{
			$(this.params.loadingSel).fadeIn();
		}
		return this;
	},
	fadeOut:function(time){
		if(time){
			$(this.params.loadingSel).fadeOut(time,function(){
				this.remove();
			});
		}else{
			$(this.params.loadingSel).fadeOut(function(){
				this.remove();
			});
		}
		if(this.params.callback){
			this.params.callback();
		}
		return this;
	}
};

//小光提示框插件
var guangAlert={
		templates:function(i){
			var templateArr=[];
			templateArr.push("<div id='guangAlert'>"+
					"<div class='a_title'><span>提示</span><a href='javascript:void(0);' class='a_close'>X</a></div>"+
					"<div class='a_content clearfix'>"+
					"	<p>我是小光弹出框的内容</p>"+
					"	<button>确认</button>"+
					"</div>"+
				    "</div><div class='guang_mask'></div>");
			if(!i){
			   i=0;
			}
			return  templateArr[i];	
		},
		params:{},
		defaultParams:{
			mask:true
		},
		init:function(json){
			$.extend(this.params,{},this.defaultParams,json);
			if(!document.getElementById("guangAlert")){
				$("body").append(this.templates());
			}
			this.center();
			if(this.params.title){
				$("#guangAlert").find(".a_title span").text(this.params.title);
			}
			if(this.params.content){
				$("#guangAlert").find(".a_content p").text(this.params.content);
			}
			if(this.params.mask){
				$(".guang_mask").height($(window).height());
			}
			this.bindEvents();
			return this;
		},
		bindEvents:function(){
			var _this=this;
			//确认按钮事件
			$("#guangAlert").find(".a_content button").on("click",function(){
				_this.fadeOut();
				if(_this.params.callback){
					_this.params.callback();
				}
			});
			$("#guangAlert").find(".a_title .a_close").on("click",function(){
				_this.fadeOut();
				if(_this.params.callback){
					_this.params.callback();
				}				
			});
			return this;
		},
		show:function(){
			if(this.params.mask){
				$(".guang_mask").show();
			}
			$("#guangAlert").show();
			return this;
		},
		hide:function(){
			if(this.params.mask){
				$(".guang_mask").hide(function(){
					this.remove();
				});
			}
			$("#guangAlert").hide(function(){
				this.remove();
			});
			return this;
		},
		fadeIn:function(time){
			if(this.params.mask){
				$(".guang_mask").show();
			}
			if(time){
				$("#guangAlert").fadeIn(time);
			}else{
				$("#guangAlert").fadeIn();
			}
			return this;
		},
		fadeOut:function(time){
			if(this.params.mask){
				$(".guang_mask").fadeOut(function(){
					this.remove();
				});
			}
			if(time){
				$("#guangAlert").fadeOut(time,function(){
					this.remove();
				});
			}else{
				$("#guangAlert").fadeOut(function(){
					this.remove();
				});
			}
			return this;
		},
		center:function(){
			var winWidth=$(window).width();
			var winHeight=$(window).height();
			var boxWidth=$("#guangAlert").width();
			var boxHeight=$("#guangAlert").height();
			var cLeft=(winWidth-boxWidth)/2;
			var cTop=(winHeight-boxHeight)/2;
			$("#guangAlert").css({left:cLeft,top:cTop});
			return this;
		}
};
//小光无限滚动
function guangUnlimitedScroll(callback){
	var _height=$(window).height();//窗口高度
	$(window).scroll(function(){
		var scrollHeight=$("body").height();//body总高度
		var scrollTop=$(window).scrollTop();//窗口顶部高度
		if(scrollTop+_height>=scrollHeight){//body到底了
			if(callback){
				callback();
			}
		}	
	});
}

//ajax加载数据
function ajaxLoadData(url,pageNo,pageSize,dataType,callback){
	guangLoading.init().fadeIn();
	$.ajax({
		url:url,
		data:{"pageNo":pageNo,"pageSize":pageSize},
		dataType:dataType,
		success:function(json){
			if(callback){
				callback(json);
			}
		},
		error:function(e){
			guangAlert.init({content:"数据加载失败！"}).show();	
		},
		complete:function(){
			guangLoading.fadeOut();
		}
	});
}

/**小光ajax上传图片组件*/
var guangAjaxUploadImg={
	defaultParams:{
		$form:$("#uploadImgForm"),
		$btn:$("#uploadImgBtn"),
		paramName:"img",
		dataType:"text"
	},
	params:{
	},
	init:function(json){
		$.extend(this.params,{},this.defaultParams,json);
		if(!document.getElementById("file")){
			this.params.$form.append("<input type='file' id='file' name='"+this.params.paramName+"'/>");
		}
		this.params.$btn.on("click",function(){
			$("#file").click();
		});
		var _this=this;
		$("#file").on("change",function(){
			_this.params.$form.ajaxSubmit({
				type:"post",
				dataType:_this.params.dataType,
				success:function(json){
					if(_this.params.success){
						_this.params.success(json);
					};
				},
				error:function(e){
					if(_this.params.error){
						_this.params.error(e);
					}
				}
			});
		});
		return this;
	}
};

//小光表单验证器
var guangFormValidator={
	valid:function($form){
		var _this=this;
		var flag=true;
		$form.find("input,textarea").each(function(){
			/**验证方式*/
			var valid=$(this).attr("data-valid");
			/**标签*/
			var label=$(this).attr("data-label");
			/**表单值*/
			var value=$(this).val();
			if(valid){
				var arr=valid.split(",");
				if(arr){
					for(var i=0;i<arr.length;i++){
						var validItem=$.trim(arr[i]);
						if(validItem=="notnull"){
							if(!_this.notnullValid(value,label)){
								flag=false;
								return; 
							};
						};
						if(validItem=="number"){
							if(!_this.numberValid(value,label)){
								flag=false;
								return;
							};
						};
						if(validItem=="email"){
							if(!_this.emailValid(value,label)){
								flag=false;
								return;
							};
						}
						if(validItem.indexOf("maxLength")!=-1){
							if(!_this.maxLengthValid(value,parseInt(validItem.substring(9)),label)){
								flag=false;
								return;
							}
						}
						if(validItem.indexOf("minLength")!=-1){
							if(!_this.minLengthValid(value,parseInt(validItem.substring(9)),label)){
								flag=false;
								return;
							}
						}
					}
				}
			}
		});
		return flag;
	},
	notnullValid:function(value,label){
		if(isEmpty(value)){
			guangAlert.init({"content":label+"不能为空！"}).fadeIn();
			return false;
		}
		return true;
	},
	numberValid:function(value,label){
		if(isNaN(value)){
			guangAlert.init({"content":label+"不是一个合法数字！"}).fadeIn();
			return false;
		}							
		return true;
	},
	emailValid:function(value,label){
		var emailPattern=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!emailPattern.test(value)){
			guangAlert.init({"content":label+"不是一个合法邮箱！"}).fadeIn();
			return false;
		}
		return true;
	},
	maxLengthValid:function(value,length,label){
		if((""+value).length>length){
			guangAlert.init({"content":label+"长度不能超过"+length}).fadeIn();
			return false;
		}
		return true;
	},
	minLengthValid:function(value,length,label){
		if((""+value).length<length){
			guangAlert.init({"content":label+"长度不能小于"+length}).fadeIn();
			return false;
		}
		return true;
	}
}
/*小光分页插件 start*/
var guangPagination={
	defaultParams:{
		$dom:$(".guangPage"),
		items_per_page:10,
		num_display_entries:3,
		current_page:0,
		num_edge_entries:3,
		link_to:"javascript:void(0)",
		prev_text:"前一页",
		next_text:"后一页",
		ellipse_text:"...",
		prev_show_always:true,
		next_show_always:true,
		renderer:"defaultRenderer",
		load_first_page:false,
		showGo : false,
		showSelect:false,
		callback:function(pageNo,pageSize){return false;},
		goback :function(){
		}
	},
	params:{},
	init:function(totalCount,json){
		json.totalCount=totalCount;
		$.extend(this.params,{},this.defaultParams,json);
		this.params.$dom.pagination(totalCount,this.params);
	},
	setPage:function(pageNo){
		//页码从0开始
		this.params.current_page=pageNo;
		this.params.$dom.pagination(this.params.totalCount,this.params);
	}
};
var GuangPage=function(){
}
GuangPage.prototype=guangPagination;
/*end 小光分页插件*/
/*小光图表插件 start*/
var guangChart={
	defaultParams:{
		type:"post",
		xName:"createTime",
		chartContainer:"#highcharts_container",
		chartParams:{
			chartType:"line",
			chartTitle:"xx统计数据",
			yName:"数值"
		}
	},
	params:{},
	init:function(json){
		$.extend(true,this.params,this.defaultPrams,json);
		this.ajaxLoadData();
	},
	ajaxLoadData:function(){
		var _this=this;
		$.ajax({
			url:_this.params.url,
			type:_this.params.type,
			data:_this.params.data,
			dataType:"json",
			success:function(json){
				if(!json||json.length==0){
					return;
				}
				var chartParam=_this.parseJson(json);
				$.extend(_this.params.chartParams,chartParam);
				_this.initChart();				
			},
			error:function(e){
				guangAlert.init({"content":"数据加载失败！"}).fadeIn();
			}
		});
	},
	parseJson:function(json){
		//每一个统计项
		var keyArr=[];
		//统计项的名字和展示的名字的映射
		var nameMap=this.params.nameMap;
		//x轴的值
		var xNameArr=[];
		//各统计项的数值
		var itemDataArr=[];
		for(var key in json[0]){
			keyArr.push(key);
		}
		for(var i=0;i<keyArr.length;i++){
			//x轴展示的值放到xNameArr中
			if(keyArr[i]==this.params.xName){
				for(var j=0;j<json.length;j++){
					xNameArr.push(json[j][keyArr[i]]);
				}
			}else{//各统计项的值放到itemDataArr中
				var item={};
				item.name=nameMap[keyArr[i]];
				item.data=[];
				for(var j=0;j<json.length;j++){
					item.data.push(json[j][keyArr[i]]);
				}
				itemDataArr.push(item);
			}
		}
		return {
			xNameArr:xNameArr,
			itemDataArr:itemDataArr
		}
	},
	initChart:function(chartParams){
		var _this=this;
		$(this.params.chartContainer).highcharts({ //图表展示容器，与div的id保持一致
			chart: {
				type: _this.params.chartParams.chartType      //图表类型
			},
			title: {
				text: _this.params.chartParams.chartTitle      //图表标题
			},
			xAxis: {
				categories:_this.params.chartParams.xNameArr,  //x轴名字
			},
			yAxis: {
				title: {
					text:_this.params.chartParams.yName             //y轴名字
				}
			},
			series:_this.params.chartParams.itemDataArr	       //统计项的数据
			,exporting: {
				type:'image/png',
				buttons: {
				contextButton: {
				menuItems: [, {
				text: '导出PNG图片文件',
				onclick: function() {
				this.exportChart();
				},
				separator: false
				}]
				}
				}
			}
		});		
	}
};
/*end 小光图表插件*/
/*小光回到顶部插件 start*/
var guangToTop={
	template:function(){
		return "<div id='toTop'><span>T</span></div>";
	},
	init:function(){
		if(!document.getElementById("toTop")){
			$("body").append(this.template());
		}
		this.bindEvents();
	},
	bindEvents:function(){
		$("#toTop").click(function(){
			$("body,html").animate({"scrollTop":0});
		});
		$(window).on("scroll",function(){
			var scrollTop=$(this).scrollTop();
			if(scrollTop>300){
				$("#toTop").fadeIn();
			}else{
				$("#toTop").fadeOut();
			}
		});
	}
};
/*end 小光回到顶部插件*/
/*小光工具方法 start*/
var guangUtils={
	center:function(boxSel){
		var winWidth=$(window).width();
		var winHeight=$(window).height();
		var boxWidth=$(boxSel).width();
		var boxHeight=$(boxSel).height();
		var cLeft=(winWidth-boxWidth)/2;
		var cTop=(winHeight-boxHeight)/2;
		$(boxSel).css({"position":"fixed",left:cLeft,top:cTop});
		return this;
	},
	getContextPath:function(){
		var contextPath = document.location.pathname; 
	    var index =contextPath.substr(1).indexOf("/"); 
	    contextPath = contextPath.substr(0,index+1); 
	    delete index; 
		return contextPath;
	},
	getBasePath:function(){
		var basePath=window.location.protocol+"//"+window.location.host+"/"+this.getContextPath();
		return basePath;
	}
}
/*end 小光工具方法*/