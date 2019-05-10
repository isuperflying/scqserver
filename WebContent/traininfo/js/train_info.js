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
                    window.location.href="getTrainInfoDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    
  //新增-保存
    $("#save_train_info").click(function() {
        if ($("#ti_name").val() == '') {
            alert("请输入培训机构名称!");
            return false;
        }
        if ($("#ti_contacts_name").val() == '') {
            alert("请输入负责人!");
            return false;
        }
        if ($("#ti_contacts_phone").val() == '') {
            alert("请输入负责人电话!");
            return false;
        }
        if ($("#ti_enrollment_phone_number").val() == '') {
            alert("请输入报名电话!");
            return false;
        }
        //提交表单
        $("#addTrainInfoForm").submit();
    });
    
  //编辑保存
    $("#update_train_info").click(function() {
    	if ($("#ti_name").val() == '') {
            alert("请输入培训机构名称!");
            return false;
        }
        if ($("#ti_contacts_name").val() == '') {
            alert("请输入负责人!");
            return false;
        }
        if ($("#ti_contacts_phone").val() == '') {
            alert("请输入负责人电话!");
            return false;
        }
        if ($("#ti_enrollment_phone_number").val() == '') {
            alert("请输入报名电话!");
            return false;
        }
      //提交表单
        $("#editTrainInfoForm").submit();
    });
    
    
    $("#ti_province").change(function () {
        $.get("getAllCityByProvinceId.action?provinceId="+$("#ti_province").val(),function(data){
            if(data.status){
                var result = "<option>选择城市</option>";
                $.each(data.obj,function(n,value){
                    result +="<option value='"+value.cityId+"'>"+value.city+"</option>";
                });
                $("#ti_city").html('');
                $("#ti_city").append(result);
            }
        },"json");
    });
    
    $("#ti_city").change(function () {
        $.get("getAllAreaByCityId.action?cityId="+$("#ti_city").val(),function(data){
            if(data.status){
                var result = "<option>选择区域</option>";
                $.each(data.obj,function(n,value){
                    result +="<option value='"+value.areaId+"'>"+value.area+"</option>";
                });
                $("#ti_area").html('');
                $("#ti_area").append(result);
            }
        },"json");
    });
});

//教师信息列表
function toTeacherInfoList(id){
	window.location.href = "getTeacherInfoDataList.action?trainInfoId="+id;
}

//课程信息列表
function toCourseInfoList(id){
    window.location.href = "getCourseInfoDataList.action?trainInfoId="+id;
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
	window.location.href = "toAddTrainInfo.action";
}
function toInput(){
	window.location.href = "toTrainInfoInput.action";
}
//编辑
function toEdit(id){
	window.location.href = "toEditTrainInfo.action?trainInfo.id="+id;
}
//删除
function toDelete(id){
	//询问框
	layer.confirm('你确定删除吗?', {
	    btn: ['确定','取消'] //按钮
	}, function(){
		$.ajax({
            url : 'deleteTrainInfo.action',
            dataType : 'text',
            type : 'post',
            data : {
                'trainInfo.id' : id
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