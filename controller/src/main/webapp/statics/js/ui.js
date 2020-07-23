
function getRootPath(){
//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
var curWwwPath=window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
var localhostPaht=curWwwPath.substring(0,pos);
//获取带"/"的项目名，如：/uimcardprj
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
return(localhostPaht+projectName);
}

function getpathName(){
	var pathName=window.location.pathname;
	return(pathName.substring(1, pathName.indexOf("/", 1)));
}



var mizhu = new function() {
	this.width = $(window).width() * 0.8;
	this.height = 172;

	this.close = function() {
		$('.win iframe').fadeOut();
		$('.win').fadeOut("fast");
		setTimeout(function() {
			$('.win iframe').remove();
			$('.win').remove();
		}, 200);
	};

	this.open = function(width, height, title, url, closed) {
		this._close = function() {
			this.close();
			if($.isFunction(closed)) closed();
		};
		var html = '<div class="win"><div class="mask-layer"></div><div class="window-panel"><iframe class="title-panel" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"></iframe><div class="title"><h3></h3></div><a href="javascript:void(0)" onclick="mizhu._close();" class="close-btn" title="关闭">×</a><iframe class="body-panel" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto" src=""></iframe></div></div>';
		var jq = $(html);
		jq.find(".window-panel").height(mizhu.height).width(mizhu.width).css("margin-left", -mizhu.width / 2).css("margin-top", -mizhu.height);
		jq.find(".title").find(":header").html(title);
		jq.find(".body-panel").height(height - 36).attr("src", url);
		jq.appendTo('body').fadeIn("fast");
		$(".win .window-panel").focus();
	};

	function messageBox(html, title, message, type) {
		var jq = $(html);
		if(type == "toast") {
			jq.find(".window-panel").width(message.length * 20).css("margin-left", -message.length * 20 / 2).css("margin-top", -mizhu.height / 2);
		} else {
			jq.find(".window-panel").width(mizhu.width).css("margin-left", -mizhu.width / 2).css("margin-top", -mizhu.height / 2 - 36);
		}
		if(valempty(title)) {
			jq.find(".title").remove();
			jq.find(".window-panel .body-panel").css("border-radius", "4px");
		} else {
			jq.find(".title").find(":header").html(title);
		}
		jq.find(".content").html(message.replace('\r\n', '<br/>'));
		jq.appendTo('body').fadeIn("fast");
		$(".win .w-btn:first").focus();
	}

	this.confirm = function(title, message, selected) {
		this._close = function(flag) {
			if(flag) {
				$(".win").remove();
				selected(flag);
			} else {
				this.close();
			};
		};

		var html = '<div class="win"><div class="mask-layer"></div><div class="window-panel"><iframe class="title-panel" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"></iframe><div class="title"><h3></h3></div><div class="body-panel"><p class="content"></p><p class="btns"><button class="w-btn" tabindex="1" onclick="mizhu._close(false);">取消</button><button class="w-btn" onclick="mizhu._close(true);">确定</button></p></div></div></div>';
		messageBox(html, title, message);
	};

	this.alert = function(title, message, ico) {
		var icon = "";
		if(!valempty(ico)) {
			icon = '<p class="btns" style="margin-bottom:-15px;"><img width="70px" height="70px" src='+getpathName()+'/statics/images/' + ico + '.png"></p>';
		}
		var html = '<div class="win"><div class="mask-layer"></div><div class="window-panel"><iframe class="title-panel" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"></iframe><div class="title"><h3></h3></div><div class="body-panel">' + icon + '<p class="content"></p><p class="btns"><button class="w-btn" tabindex="1" onclick="mizhu.close();">确定</button></p></div></div></div>';
		messageBox(html, title, message);
	}

	this.toast = function(message, time) {
		var html = '<div class="win"><div class="window-panel"><iframe class="title-panel" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"></iframe><div class="body-panel toast-panel"><p class="content toast-content"></p></div></div></div>';
		messageBox(html, "", message, "toast");
		setTimeout(function() {
			mizhu.close();
		}, time || 3000);
	}
};

function valempty(str) {
	if(str == "null" || str == null || str == "" || str == "undefined" || str == undefined || str == 0) {
		return true;
	} else {
		return false;
	}
}


/**
 * 删除
 */
var Delete = new function(){
	this.del= function(url){
	var ids = [];
	$("input[name='ids']:checked").each(function(){
		ids.push($(this).val());
	});
	if(ids.length==0){mizhu.alert("操作提示","请勾中要删除选项");return false;}
	var i = confirm("确定删除吗?");
	if(!i){return false;}
	var data="ids="+ids;
	$.ajax({
		url:url,
		data:data,
		dataType:"text",
		type : "post",
		async : true,
		success:function(jsonStr){
			var data = eval("(" + jsonStr+ ")");
			if(data.status==1){
				mizhu.alert('操作提醒',"成功!");
				window.location.reload();
			}else {
				mizhu.alert('操作提醒',data.message);
			}
		}
	});
	}

	
}