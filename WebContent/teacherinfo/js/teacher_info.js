var diaEdit;

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
                    window.location.href="getTeacherInfoDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    
    //新增-保存
    $("#save_teacher_info").click(function() {
        if ($("#ti_name").val() == '') {
            alert("请输入教师名称!");
            return false;
        }
	    if ($("ti_number").val() == '') {
	        alert("请输入教师编号!");
	        return false;
	    }
	    
	    var age=$("#ti_age").val();
	    if(isNaN(age)){
	    	alert("年龄输入有误!");
	    	return false;
	    }
	    
        if ($("#ti_phone_number").val() == 0) {
            alert("请输入教师联系方式!");
            return false;
        }
        
        if(!isNumber($("#ti_teacher_age").val())){
        	alert("教龄输入有误,请输入数值！");
        	return false;
        }
        
        //提交表单
        $("#addTeacherInfoForm").submit();
    });
    
    //编辑保存
    $("#update_teacher_info").click(function() {
    	if ($("#ti_name").val() == '') {
            alert("请输入教师名称!");
            return false;
        }
	    if ($("ti_number").val() == '') {
	        alert("请输入教师编号!");
	        return false;
	    }
	    
	    var age=$("#ti_age").val();
	    if(isNaN(age)){
	    	alert("年龄输入有误!");
	    	return false;
	    }
	    
        if ($("#ti_phone_number").val() == 0) {
            alert("请输入教师联系方式!");
            return false;
        }
        
        if(!isNumber($("#ti_teacher_age").val())){
        	alert("教龄输入有误,请输入数值！");
        	return false;
        }
        //提交表单
        $("#editTeacherInfoForm").submit();
    });
    
});

function isNumber(s){
    s = $.trim(s);
    var p =/^[1-9](\d+(\.\d{1,2})?)?$/; 
    var p1=/^[0-9](\.\d{1,2})?$/;
    return p.test(s) || p1.test(s);
}

//字典详情
function toDetail(id){
    window.location.href = "getListByBaseDataId.action?baseDataId="+id;
}


//字典取值
function toBaseDataDetail(){
    window.location.href = "getTestData.action";
}

//跳转到培训机构页面
function toTrainInfoList(){
	window.location.href = "getTrainInfoDataList.action";
}

function toInput(){
	var trainInfoId = $("#trainInfoId").val();
	window.location.href = "toTeacherInfoInput.action?trainInfoId="+trainInfoId;
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

/**
 * 培训机构ID
 * @param trainInfoId
 */
function toAdd(){
	var trainInfoId = $("#trainInfoId").val();
	window.location.href = "toAddTeacherInfo.action?trainInfoId="+trainInfoId;
}

//编辑
function toEdit(id){
	window.location.href = "toEditTeacherInfo.action?teacherInfo.id="+id;
}
//删除
function toDelete(id){
	//询问框
	layer.confirm('你确定删除吗?', {
	    btn: ['确定','取消'] //按钮
	}, function(){
		$.ajax({
            url : 'deleteTeacherInfo.action',
            dataType : 'text',
            type : 'post',
            data : {
                'teacherInfo.id' : id
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