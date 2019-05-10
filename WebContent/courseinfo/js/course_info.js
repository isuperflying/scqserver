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
                    window.location.href="getCourseInfoDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    
  //新增-保存
    $("#save_course_info").click(function() {
        if ($("#ci_name").val() == '') {
            alert("请输入课程名称!");
            return false;
        }
	    if ($("#ci_simple_name").val() == '') {
	        alert("请输入课程简称!");
	        return false;
	    }
        if ($("#ci_first_menu").val() == 0) {
            alert("请选择课程所属菜单!");
            return false;
        }
        
        if(!isNumber($("#ci_course_hour").val())){
        	alert("课时输入有误,请输入数值！");
        	return false;
        }
        
        if(!isNumber($("#ci_course_total_price").val())){
        	alert("课程总费用输入有误,请输入数值！");
        	return false;
        }
        
        //提交表单
        $("#addCourseInfoForm").submit();
    });
    
  //编辑保存
    $("#update_course_info").click(function() {
        if ($("#ci_name").val() == '') {
            alert("请输入课程名称!");
            return false;
        }
 	    if ($("#ci_simple_name").val() == '') {
 	        alert("请输入课程简称!");
 	        return false;
 	    }
        if ($("#ci_first_menu").val() == 0) {
             alert("请选择课程所属菜单!");
             return false;
        }
        
        if(!isNumber($("#ci_course_hour").val())){
        	alert("课时输入有误,请输入数值！");
        	return false;
        }
        
        if(!isNumber($("#ci_course_total_price").val())){
        	alert("课程总费用输入有误,请输入数值！");
        	return false;
        }
        
        //提交表单
        $("#editCourseInfoForm").submit();
    });
    
    $("#ci_first_menu").change(function () {
        $.get("getAllMenuTypeByParentNumber.action?parentNumber="+$("#ci_first_menu").val(),function(data){
            if(data.status){
                var result = "<option>选择二级菜单</option>";
                $.each(data.obj,function(n,value){
                    result +="<option value='"+value.menuNumber+"'>"+value.typeName+"</option>";
                });
                $("#ci_second_menu").html('');
                $("#ci_second_menu").append(result);
            }
        },"json");
        $("#menu_type_id").val($("#ci_first_menu").val());
    });
    
    $("#ci_second_menu").change(function () {
        $.get("getAllMenuTypeByParentNumber.action?parentNumber="+$("#ci_second_menu").val(),function(data){
            if(data.status){
                var result = "<option>选择三级菜单</option>";
                $.each(data.obj,function(n,value){
                    result +="<option value='"+value.menuNumber+"'>"+value.typeName+"</option>";
                });
                $("#ci_three_menu").html('');
                $("#ci_three_menu").append(result);
            }
        },"json");
        $("#menu_type_id").val($("#ci_second_menu").val());
    });
    
    $("#ci_three_menu").change(function () {
    	$("#menu_type_id").val($("#ci_three_menu").val());
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
	window.location.href = "toAddCourseInfo.action?trainInfoId="+trainInfoId;
}
function toInput(){
	var trainInfoId = $("#trainInfoId").val();
	window.location.href = "toCourseInfoInput.action?trainInfoId="+trainInfoId;
}
/**
 * 培训课程ID
 * @param id
 */
function toEdit(id){
	window.location.href = "toEditCourseInfo.action?courseInfo.id="+id;
}
//删除
function toDelete(id){
	//询问框
	layer.confirm('你确定删除吗?', {
	    btn: ['确定','取消'] //按钮
	}, function(){
		$.ajax({
            url : 'deleteCourseInfo.action',
            dataType : 'text',
            type : 'post',
            data : {
                'menuType.id' : id
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