
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
            //page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
            onPageChange: function (num, type) {
                if(type=="change"){
                    window.location.href="getComplainDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    //新增
    $("#toAdd_complain").click(function() {
        window.location.href = "complain/add_complain.jsp";
    });
    
    //新增-保存
    $("#save_complain").click(function() {
        
        if ($("#complain_theme").val() == '') {
            alert("请输入投诉主题!");
            return false;
        }
        if ($("#complain_content").val() == '') {
            alert("请输入投诉内容!");
            return false;
        }
        //提交表单
        //$("#addComplainForm").submit();
        
        $.ajax({
            url : 'saveComplain.action',
            dataType : 'text',
            type : 'post',
            data : {
                'complain.complainTheme' : $("#complain_theme").val(),
                'complain.complainContent' : $("#complain_content").val()
            },
            success: function (data) {
                if ($.trim(data) == "success") {
                	alert("投诉成功!");
                	window.top.opener = null;
                    window.close();
                }
            },  
            error: function () {
                alert("投诉失败!");
            }  
        });
        
        
    });
    
    //设置选择的课程类型
    $('#tc_edit_type').val($('#tc_type').val());
    
    //修改-保存
    $("#update_complain").click(function() {
        
        if ($("#tc_edit_name").val() == '') {
            alert("请输入课程名称!");
            return false;
        }
        
        //提交表单
        $("#editComplainForm").submit();
    });
    
    
    $(function(){ 
    	$("tr:odd").addClass("odd"); 
    	$("tr:even").addClass("even"); 
    }); 
    
});

//字典详情
function toDetail(id){
    window.location.href = "getListByBaseDataId.action?baseDataId="+id;
}

//编辑
function toEdit(id){
    window.location.href = "toUpdateComplain.action?complain.id="+id;
}

//播放
function toPlay(id){
    window.location.href = "mobile/video_test.jsp";
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
                url : 'deleteComplain.action',
                dataType : 'text',
                type : 'post',
                data : {
                    'complain.id' : id
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