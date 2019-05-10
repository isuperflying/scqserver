
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
                    window.location.href="getManuscriptDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    //新增
    $("#toAdd_manuscript").click(function() {
        window.location.href = "manuscript/add_manuscript.jsp";
    });
    
    //新增-保存
    $("#save_manuscript").click(function() {
        
        if ($("#manuscript_theme").val() == '') {
            alert("请输入投稿主题!");
            return false;
        }
        if ($("#manuscript_content").val() == '') {
            alert("请输入投稿内容!");
            return false;
        }
        //提交表单
        //$("#addManuscriptForm").submit();
        
        $.ajax({
            url : 'saveManuscript.action',
            dataType : 'text',
            type : 'post',
            data : {
                'manuscript.manuscriptTheme' : $("#manuscript_theme").val(),
                'manuscript.manuscriptContent' : $("#manuscript_content").val()
            },
            success: function (data) {
                if ($.trim(data) == "success") {
                	alert("投稿成功!");
                	window.top.opener = null;
                    window.close();
                }
            },  
            error: function () {
                alert("投稿失败!");
            }  
        });
        
        
    });
    
    //设置选择的课程类型
    $('#tc_edit_type').val($('#tc_type').val());
    
    //修改-保存
    $("#update_manuscript").click(function() {
        
        if ($("#tc_edit_name").val() == '') {
            alert("请输入课程名称!");
            return false;
        }
        
        //提交表单
        $("#editManuscriptForm").submit();
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
    window.location.href = "toUpdateManuscript.action?manuscript.id="+id;
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
                url : 'deleteManuscript.action',
                dataType : 'text',
                type : 'post',
                data : {
                    'manuscript.id' : id
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