$(document).ready(function() {
    $(".subNav").click(
            function() {
                $(this).toggleClass("currentDd").siblings(".subNav")
                        .removeClass("currentDd");
                $(this).toggleClass("currentDt").siblings(".subNav")
                        .removeClass("currentDt");

                // 修改数字控制速度， slideUp(500)控制卷起速度
                $(this).next(".navContent").slideToggle(500).siblings(
                        ".navContent").slideUp(500);
     });
});

function toLoginOut(){
    //parent.location.href="login.jsp";
    $.ajax({
        type:"POST",
        url : "loginOut.action",
        dataType : 'text',
        success : function(data) {
            if (data == "success") {
                parent.location.href="login.jsp";
            } else {
                //parent.location.href="login.jsp";
                alert("退出失败!");
            }
        }
    });
}

function toShow(index){
    var url ="";
    if(index ==0){
        //url="report/add_report.jsp";
    }
    if(index ==1){
        url="getTpDataList.action";
    }
    if(index ==2){
        url="getStudyDataListByUserId.action";
    }
    
    if(index ==3){
        //url="selectAccessmentList";
    }
    
    if(index ==4){
        //url="getMonthExamineListByUserId";
    }
    
    if(index ==5){
        //url="getYearExamineListByUserId";
    }
    
    if(index ==6){
        //url="getMonthTotalList";
    }
    
    if(index ==7){
        alert("暂未开放!");
        return;
    }
    
    if(index ==8){
        url="getDataList.action";
    }
    if(index ==9){
        url="getTcDataList.action";
    }
    if(index ==10){
        //url="getUserById";
    }
    if(index ==11){
       // url="working.jsp";
    }
    
    //监管端修改密码
    if(index ==12){
        url="toUpdateUser.action"
    }
    //退出
    if(index ==13){
        url="loginOut.action";
    }
    
    if(index == 21){
    	url = "subjectList.action";
    }
    if(index == 22){
    	url = "trainNoticeList.action";
    }
    if(index == 23){
    	url = "examList.action";
    }
    if(index == 25){
    	url = "messageList.action?tm.messageType=0";
    }
    if(index == 26){
    	url = "messageList.action?tm.messageType=1";
    }
    if(index == 27){
    	url = "getTrainCourseList.action";
    }
    if(index == 28){
    	url = "getTrainExamList.action";
    }
    window.frames['main_show'].location.href = url;
}