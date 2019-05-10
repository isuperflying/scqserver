$(function() {
    var index = $("#main_index").val();
    toShow(index);
});


function toShow(index) {
	var url = "";
	//首页
	if (index == 0) {
        //url = "toEmpIndex.action";
	    window.parent.location.href = "toEmpIndex.action";
    }
	if (index == 1) {
		url = "messageList.action?tm.messageType=0&type=1";// 最新动态
	}
	if (index == 2) {
		url = "messageList.action?tm.messageType=1&type=1";// 政策法规
	}

	if (index == 3) {
		url = "getStudyDataListByUserId.action";
	}

	if (index == 4) {
		url = "examList.action";// 在线考试
	}

	if (index == 5) {
	    url = "createing.jsp";
	}

	if (index == 6) {
		url = "examResult.action";// 考试查询
	}

	if (index == 7) {
	    url = "createing.jsp";
	}

	if (index == 8) {
	    //url = "edit_user.jsp";
	    url = "toUpdateUser.action";
	}

	window.frames['emp_main_show'].location.href = url;
}