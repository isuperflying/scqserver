var diaEdit;
var cnum = 1;
$(document).ready(function() {
    var current_page = $("#current_page").val();
    var total_count = $("#total_count").val();
    
    if(Number(total_count) > 0){
        //初始化分页控件
        $.jqPaginator('#pagination', {
            totalCounts:Number(total_count),
            pageSize:10,
            visiblePages:10,
            first: '<li class="prev"><a href="javascript:;">首页</a></li>',
            prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
            next: '<li class="next"><a href="javascript:;">下一页</a></li>',
            last: '<li class="prev"><a href="javascript:;">尾页</a></li>',
            page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
            onPageChange: function (num, type) {
                if(type=="change"){
                	cnum = num;
                    window.location.href="getSourceInfoDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    
  //新增-保存
    $("#save_score_item").click(function() {
        if ($("#score_name").val() == null || $("#score_name").val() == '') {
        	layer.msg('请输入打分项');
            return false;
        }
	     
        //提交表单
        $("#addScoreItemForm").submit();
    });
    
    //编辑保存
    $("#edit_score_item").click(function() {
    	if ($("#score_name").val() == null || $("#score_name").val() == '') {
    		layer.msg('请输入打分项');
            return false;
        }
    	
        var loading = layer.msg('保存中', {
  		  icon: 16
  		  ,shade: 0.01
  		});
        
        var options = {
            success: function(data){
            	if(null != data && data == "success"){
            		layer.closeAll('loading');
            		window.location.href="getScoreItemDataList.action?page="+cnum;
            	}else{
            		layer.msg('修改失败');
            	}
            },
            error : function(data){
            	layer.msg('修改失败');
            }
    	 };
        $('#editScoreItemForm').ajaxForm(options).submit();
    });
    
    
    $("#mt_level").change(function () {
    	var level = $("#mt_level").val();
    	if(level==1){
    		$("#father_tx").hide();
    		$("#mt_parentNumber").hide();
    	}
    	if(level==2){
    		var op = "<option value='0'>选择父级菜单</option><option value='1' selected='selected'>兴趣</option><option value='2'>课业</option>";
    		$("#father_tx").show();
    		$("#mt_parentNumber").show();
    		$("#mt_parentNumber").html('');
    		$("#mt_parentNumber").append(op);
    	}
    	if(level==3){
    		$("#father_tx").show();
    		$("#mt_parentNumber").show();
    		$.get("getAllMenuTypeByLevel.action",function(data){
                if(data.status){
                    var result = "<option value='0'>选择父级菜单</option>";
                    $.each(data.obj,function(n,value){
                        result +="<option value='"+value.menuNumber+"'>"+value.typeName+"</option>";
                    });
                    $("#mt_parentNumber").html('');
                    $("#mt_parentNumber").append(result);
                }
            },"json");
    	}
    });
    
});

//字典详情
function toDetail(id){
    window.location.href = "getListByBaseDataId.action?baseDataId="+id;
}


//字典取值
function toBaseDataDetail(){
    window.location.href = "getTestData.action";
}

//同步数据
function toSyn(){
    //window.location.href = "toSynData.action";
    var d = dialog();
    d.title('正在同步数据...');
    d.show();
    $.ajax({
        url : 'toSynData.action',
        dataType : 'text',
        type : 'post',
        success: function (data) {
            if ($.trim(data) == "success") {
                d.close();
                alert("同步数据成功!");
            }
        },  
        error: function () {
            d.close();
            alert("同步数据失败!");
        }  
    });
}


function toAdd(){
	window.location.href = "toAddScoreItem.action";
}
function toInput(){
	window.location.href = "toInput.action";
}
//编辑
function toEdit(id,name){
	$("#sid").val(id);
	$("#score_name").val(name);
	//window.location.href = "toEditScoreItem.action?scoreItem.id="+id;
	layer.open({
		  type: 1,
		  title: false,
		  closeBtn: 0,
		  offset:[100,300],
		  area: '516px',
		  skin: '#ffffff', //没有背景色
		  shadeClose: true,
		  content: $('#edit_div')
		});
}
//删除
function toDelete(id){
	//询问框
	layer.confirm('你确定删除吗?', {
		offset:[100,400],
	    btn: ['确定','取消'] //按钮
	}, function(){
		$.ajax({
            url : 'deleteScoreItem.action',
            dataType : 'text',
            type : 'post',
            data : {
                'scoreItem.id' : id
            },
            success: function (data) {
                if ($.trim(data) == "success") {
                    window.location.reload();
                }
            },
            error: function () {
                //alert("删除失败!");
                layer.alert('删除失败!');
            }  
        });
	});
}