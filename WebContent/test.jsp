<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/dialog.js"></script>
<script type="text/javascript" src="js/jqPaginator.js"></script>
<link rel="stylesheet" type="text/css" href="css/ui-dialog.css">
<link type="text/css" rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css"/>
<title>弹出窗口测试</title>
<script type="text/javascript">
    $(document).ready(function() {
        
        var alertDiv = $("#first");
        
        $("#test").click(function() {
            var d = dialog({
                title: '消息',
                content: alertDiv,
                okValue: '确 定',
                ok: function () {
                    var that = this;
                    setTimeout(function () {
                        that.title('提交中..');
                    }, 2000);
                    return false;
                },
                cancelValue: '取消',
                cancel: function () {
                    alert('你点了取消按钮')
                }
            });
            
            d.show();
        });

        
        $.jqPaginator('#pagination1', {
            totalPages: 100,
            visiblePages: 10,
            currentPage: 3,
            onPageChange: function (num, type) {
                $('#p1').text(type + '：' + num);
            }
        });
        $.jqPaginator('#pagination2', {
            totalPages: 100,
            visiblePages: 10,
            currentPage: 3,
            prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
            next: '<li class="next"><a href="javascript:;">Next</a></li>',
            page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
            onPageChange: function (num, type) {
                $('#p2').text(type + '：' + num);
            }
        });
        
    });
</script>


</head>
<body>
    <div id="first" style="text-align: center;">测试层</div>
</body>
</html>