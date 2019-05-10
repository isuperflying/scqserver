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
                    window.location.href="getDataList.action?page="+num;
                }
            }
        });
        
        $('#pagination').jqPaginator('option', {
            currentPage: Number(current_page)
        });
    }
    
    var diaAdd;
    
    $("#toAdd_base_data").click(function() {
        var add_div = $("#add_base_data_div");
        diaAdd = dialog({
            fixed: true,
            title: '新增字典',
            content: add_div,
            width:500,
            height:200
        });
        diaAdd.show();
    });
    
    //新增保存
    $("#save_base_data").click(function() {
        if ($("#base_data_name").val() == '') {
            alert("请输入字典名称!");
            return false;
        }
        
        $('#baseDataAddForm').ajaxSubmit({
            success: function(data) {
                if ($.trim(data) == "success") {
                     $("#base_data_name").val("");
                     diaAdd.close();
                     window.location.reload();
                }else {
                     //diaAdd.close();
                     alert("字典名称不能重复!");
                }
            }
        });
    });
    
    //编辑保存
    $("#update_base_data").click(function() {
        if ($("#base_data_edit_name").val() == '') {
            alert("请输入字典名称!");
            return false;
        }
        $('#baseDataEditForm').ajaxSubmit({
            success: function(data) {
                if ($.trim(data) == "success") {
                     $("#base_data_edit_name").val("");
                     diaEdit.close();
                     window.location.reload();
                }else {
                     diaEdit.close();
                }
            }
        });
    });
    
});

//字典详情
function toDetail(id){
    window.location.href = "getListByBaseDataId.action?baseDataId="+id;
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

//编辑
function toEdit(id,name){
    var edit_div = $("#edit_base_data_div");
    
    $("#base_data_edit_id").val(id);
    $("#base_data_edit_name").val(name);
    
    diaEdit = dialog({
        title: '修改字典',
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
                url : 'deleteBaseData.action',
                dataType : 'text',
                type : 'post',
                data : {
                    'baseData.id' : id
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