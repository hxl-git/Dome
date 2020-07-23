
//新增
function add(path){
	var name = $("#name").val();
	var sex =$("input[name='sex']:checked").val();

	data="name="+name+"&sex="+sex;
	$.ajax({
		url:path+"/add.html",
		data:data,
		dataType:"text",
		type : "post",
		async : true,
		success:function(jsonStr){
			var result = eval("(" + jsonStr+ ")");
			if(result.status==1){
				url="/index.html";
				tz(path,url);
			}else {
				alert(result.message);
				return false;
			}
			
		}
	});
	
}

//修改用户
function update(path,id){
	var name = $("#name").val();
	var sex =$("input[name='sex']:checked").val();

	data="name="+name+"&sex="+sex+"&id="+id;
	$.ajax({
		url:path+"/upUser.html",
		data:data,
		dataType:"text",
		type : "post",
		async : true,
		success:function(jsonStr){
			var result = eval("(" + jsonStr+ ")");
			if(result.status==1){
				url="/index.html";
				tz(path,url);
			}else {
				alert(result.message);
				return false;
			}
			
		}
	});
}


//删除
function del(path){
	
		var ids = [];
		$("input[name='ids']:checked").each(function(){
			ids.push($(this).val());
		});
		if(ids.length==0){alert("请勾中要删除的用户");return false;}
		
		var f = confirm("确认删除吗?");
		
		if(f){
		data="ids="+ids;
		$.ajax({
			url:path+"/delUser.html",
			data:data,
			dataType:"text",
			type : "post",
			async : true,
			success:function(data){
				if(data==1){
					alert("删除成功!");
				}else{
					alert("删除失败!");
				}
				$("#span10").load(path+"/index.html");
			}
		});
	
		}
}


function select(){
	var name = $("#name1").val();
	$("#span10").load('${path}'+"/index.html?name="+name);
}

//跳转
function tz(path,url){
	if(url=="up"){
		var ids = [];
		$("input[name='ids']:checked").each(function(){
			ids.push($(this).val());
		});
		if(ids.length==0){alert("请勾中要修改的用户");return false;}
		if(ids.length>1){alert("一次只能修改一个用户");return false;}
		url+="?ids="+ids;
	}
	$("#span10").load(path+url);
	
}





	
	
