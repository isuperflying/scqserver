
$(document).ready(function() {
    var current_page = $("#current_page").val();
    var total_count = $("#total_count").val();
    
    var subject_result = $("#subject_result").val();
    if('' !=subject_result && null != subject_result && subject_result != undefined){
    	//$("input[@type=radio][name=subject_item][@value=B]").attr("checked",true);
    	
    	var temp = -1;
    	if(subject_result=="A"){
    		temp = 0;
    	}else if(subject_result=="B"){
    		temp = 1;
    	}else if(subject_result=="C"){
    		temp = 2;
    	}else if(subject_result=="D"){
    		temp = 3;
    	}else{
    	}
    	if(temp>-1){
    		$("input[name=subject_item]:eq("+temp+")").attr("checked",'checked');
    	}
    }
    
    time('begintime');//考试开始时间
    
    var exam_last_time = parseInt($("#exam_last_time").val());
    
    var times = exam_last_time;//剩余时间，单位秒
	var timeDiv = document.getElementById("timeDiv");
	var timeObj = null;
	
	function timer(){
		if (times <= 0){//考试时间结束，强制提交试卷
			doAutoSubmit();
			window.clearInterval(timeObj);
			return;
		}
		var t = Math.floor(times/60) + ':' + times%60;
		timeDiv.innerHTML = t;
		times--;
	}
	timeObj = window.setInterval(timer,1000);
    
   
    //上一题
    $("#pre_subject").click(function() {
    	var id=$("#exam_user_subject_id").val();
    	var examUserId=$("#exam_user_id").val();
    	var subject_id = $("#current_subject_id").val();
    	var current_subject_num=parseInt($("#current_subject_num").val());
    	
    	if(current_subject_num==1){
    		alert("已经是第一题！");
    		return;
    	}
    	
    	var next_subject_num = current_subject_num-1;
    	
    	var res = $('input:radio[name=subject_item]:checked').val();
    	
    	/*if(null == res || res == undefined){
    		alert("请选择答案!");
    		return;
    	}*/
    	
    	window.location.href = "toSubmitPreSubject.action?currentExamUserSubject.id="+id+"&currentExamUserSubject.subjectResult="+res+"&currentSubjectNum="+next_subject_num+"&examUser.id="+examUserId+"&examLastTime="+times;
    });
    
    //下一题
    $("#next_subject").click(function() {
    	var id=$("#exam_user_subject_id").val();
    	var examUserId=$("#exam_user_id").val();
    	var subject_id = $("#current_subject_id").val();
    	var current_subject_num=parseInt($("#current_subject_num").val());
    	
    	//类别
    	var current_subject_type=parseInt($("#current_subject_type").val());
    	//标准答案
    	var current_subject_standardAnswer=$("#current_subject_standardAnswer").val();
    	
    	if(current_subject_num==45){
    		alert("已经是最后一题！");
    		return;
    	}
    	
    	var next_subject_num = current_subject_num+1;
    	
    	var res = $('input:radio[name=subject_item]:checked').val();
    	
    	if(null == res || res == undefined){
    		alert("请选择答案!");
    		return;
    	}
    	
    	var question_score = 0;
    	if($.trim(current_subject_standardAnswer)==res){
    		if(current_subject_type == 1){
    			question_score = 3;
    		}else{
    			question_score = 2;
    		}
    	}
    	
    	window.location.href = "toSubmitNextSubject.action?currentExamUserSubject.id="+id+"&currentExamUserSubject.subjectResult="+res+"&currentExamUserSubject.questionScore="+question_score+"&currentSubjectNum="+next_subject_num+"&examUser.id="+examUserId+"&examLastTime="+times;
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
    
});

//自动提交试卷
function doAutoSubmit(){
	alert("考试时间已到，结束答卷!");
    window.location.href = "getTrainExamDataList.action";
}

//提交试卷
function doSubmit(){
    
	var id=$("#exam_user_subject_id").val();
	var examUserId=$("#exam_user_id").val();
	var subject_id = $("#current_subject_id").val();
	var current_subject_num=parseInt($("#current_subject_num").val());
	
	//类别
	var current_subject_type=parseInt($("#current_subject_type").val());
	//标准答案
	var current_subject_standardAnswer=$("#current_subject_standardAnswer").val();
	
	var next_subject_num = current_subject_num+1;
	
	var res = $('input:radio[name=subject_item]:checked').val();
	
	if(null == res || res == undefined){
		res = "";
	}
	
	var question_score = 0;
	if($.trim(current_subject_standardAnswer)==res){
		if(current_subject_type == 1){
			question_score = 3;
		}else{
			question_score = 2;
		}
	}
	
	//window.location.href = "toSubmitNextSubject.action?currentExamUserSubject.id="+id+"&currentExamUserSubject.subjectResult="+res+"&currentExamUserSubject.questionScore="+question_score+"&currentSubjectNum="+next_subject_num+"&examUser.id="+examUserId+"&examLastTime="+times;
	
	 if (confirm("你确定提交试卷吗?")==true){
		 $.ajax({
             url : 'toSubmit.action',
             dataType : 'text',
             type : 'post',
             data : {
                 'currentExamUserSubject.id' : id,
                 'currentExamUserSubject.subjectResult':res,
                 'currentExamUserSubject.questionScore':question_score,
                 'currentSubjectNum':next_subject_num,
                 'examUser.id':examUserId
             },
             success: function (data) {
                 if (null != $.trim(data)) {
                     alert("本次考试得分: "+data+" 分");
                     //window.location.href = "getTrainExamDataList.action";
                     window.location.href = "getTrainScoreDataList.action";
                 }
             },  
             error: function () {
                 alert("提交试卷失败!");
             }  
         });
	 }else{
	    return false; 
	 } 
    
}

//考试开始时间和结束时间
function time(id){
	var today = new Date();
	var y = today.getFullYear();
	var M = today.getMonth() + 1;
	var d = today.getDate();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	if (M <= 9)
		M = "0" + (today.getMonth() + 1);
	if (d <= 9)
		d = "0" + today.getDate();
	if (h <= 9)
		h = "0" + today.getHours();
	if (m <= 9)
		m = "0" + today.getMinutes();
	if (s <= 9)
		s = "0" + today.getSeconds();
	var time = y + "-" + M + "-" + d + " " + h + ":" + m + ":" + s;
	$('#'+id).val(time);
}

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