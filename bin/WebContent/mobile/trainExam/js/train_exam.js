
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
           // page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
            onPageChange: function (num, type) {
                if(type=="change"){
                    window.location.href="getTrainExamList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
     
    //新增
    $("#toAdd_train_exam").click(function() {
        //window.location.href = "trainExam/add_train_exam.jsp";
        window.location.href = "toAddTrainExam.action";
    });
    
    //新增-保存
    $("#save_train_exam").click(function() {
        
        if ($("#te_theme").val() == '') {
            alert("请输入培训考试主题!");
            return false;
        }
        
        if ($("#te_begin").val() == '') {
            alert("请输入培训开始时间!");
            return false;
        }
        if ($("#te_end").val() == '') {
            alert("请输入培训结束时间!");
            return false;
        }
        
        if(!checkTime()){
            alert("结束时间必须大于开始时间！");  
            return;  
        }  
        
        var re = /^[1-9]\d*$/;
        if (!re.test($("#te_time").val()))
        {
            alert("考试时长必须为正整数!");
            return;
        }
        
        //提交表单
        $("#addTrainExamForm").submit();
    });
    
    
  	//开始考试
    $("#start_exam").click(function() {
    	$("#startExamForm").submit();
    });
    //返回
    $("#score_back").click(function() {
    	window.location.href = "getTrainScoreDataList.action";
    });
    //设置选择的课件
    $('#te_edit_course_id').val($('#te_ware_id').val());
    
    //修改-保存
    $("#update_train_exam").click(function() {
        
    	if ($("#te_theme").val() == '') {
            alert("请输入培训考试主题!");
            return false;
        }
        
        if ($("#te_begin").val() == '') {
            alert("请输入培训开始时间!");
            return false;
        }
        if ($("#te_end").val() == '') {
            alert("请输入培训结束时间!");
            return false;
        }
        
        if(!checkTime()){
            alert("结束时间必须大于开始时间！");
            return;  
        }  
        
        var re = /^[1-9]\d*$/;
        if (!re.test($("#te_time").val()))
        {
            alert("考试时长必须为正整数!");
            return;
        }
    	
        //提交表单
        $("#editTrainExamForm").submit();
    });
    
    
    $(function(){ 
    	$("tr:odd").addClass("odd"); 
    	$("tr:even").addClass("even"); 
    }); 
});

/**
 * 时间比较函数
 * @returns {Boolean}
 */
function checkTime(){
	var startTime=$("#te_begin").val();
	var start=new Date(startTime.replace("-", "/").replace("-", "/"));
	var endTime=$("#te_end").val();
	var end=new Date(endTime.replace("-", "/").replace("-", "/"));
	if(end<start){
	 	return false;
	}
	return true;
}
//考试确认
function toConfirm(id){
    //window.location.href = "mobile/trainExam/train_exam_confirm.jsp";
	window.location.href = "toTrainExamConfirm.action?trainExam.id="+id;
}
//字典详情
function toDetail(id){
    window.location.href = "getListByBaseDataId.action?baseDataId="+id;
}

//编辑
function toEdit(id){
    window.location.href = "toUpdateTrainExam.action?trainExam.id="+id;
}
//成绩详情
function toScoreDetail(id){
	window.location.href = "toScoreDetail.action?trainExam.id="+id;
}
//删除
function toDelete(id){
    var d = dialog({
        title: '提示',
        content:"你确定删除吗?",
        width:150,
        okValue: '确定',
        ok: function () {
            $.ajax({
                url : 'deleteTrainExam.action',
                dataType : 'text',
                type : 'post',
                data : {
                    'trainExam.id' : id
                },
                success: function (data) {
                    if ($.trim(data) == "success") {
                        window.location.reload();
                    }
                },  
                error: function () {
                    alert("删除失败!");
                }  
            });
            return false;
        },
        cancelValue: '取消',
        cancel: function () {}
    });
    d.show();
}