var diaEdit;

$(document).ready(function() {
    var base_data_id = $("#base_data_id").val();
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
                    window.location.href="getListByBaseDataId.action?page="+num+"&baseDataId="+base_data_id;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    var diaAdd;
    
    $("#toAdd_base_data_detail").click(function() {
        var add_div = $("#add_base_data_detail_div");
        diaAdd = dialog({
            title: '新增字典详情',
            content: add_div,
            width:500,
            height:200
        });
        diaAdd.show();
    });
    
    //新增保存
    $("#save_base_data_detail").click(function() {
        if ($("#base_data_detail_value").val() == '') {
            alert("请输入值!");
            return false;
        }
        
        $('#baseDataDetailAddForm').ajaxSubmit({
            success: function(data) {
                if ($.trim(data) == "success") {
                     $("#base_data_detail_key").val("");
                     $("#base_data_detail_value").val("");
                     diaAdd.close();
                     window.location.reload();
                }else {
                    diaAdd.close();
                }
            }
        });
    });
    
    //编辑保存
    $("#update_base_data_detail").click(function() {
        if ($("#base_data_detail_edit_value").val() == '') {
            alert("请输入值!");
            return false;
        }
        $('#baseDataDetailEditForm').ajaxSubmit({
            success: function(data) {
                if ($.trim(data) == "success") {
                    $("#base_data_detail_edit_key").val("");
                    $("#base_data_detail_edit_value").val("");
                     diaEdit.close();
                     window.location.reload();
                }else {
                     diaEdit.close();
                }
            }
        });
    });
    
});

//编辑
function toEdit(id,key,value){
    var edit_div = $("#edit_base_data_detail_div");
    
    $("#base_data_detail_id").val(id);
    $("#base_data_detail_edit_key").val(key);
    $("#base_data_detail_edit_value").val(value);
    
    diaEdit = dialog({
        title: '修改字典详情',
        content: edit_div,
        width:500,
        height:200
    });
    diaEdit.show();
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
                url : 'deleteBaseDataDetail.action',
                dataType : 'text',
                type : 'post',
                data : {
                    'baseDataDetail.id' : id
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

function toBack(){
    window.location.href="getDataList.action";
}
