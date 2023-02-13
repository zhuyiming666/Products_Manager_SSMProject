<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
</head>
<body>
<div class="lalayer_notice">
    jiji
</div>
</body>
<script>
    $(function (){
    layer.open({
        type: 1,
        title: 'title here',   //标题
        area: ['390px', '330px'],   //宽高
        shade: 0.4,   //遮罩透明度
        content: $("#test"),//支持获取DOM元素
        btn: ['确定', '取消'], //按钮组
        scrollbar: false,//屏蔽浏览器滚动条
        yes: function (index) {//layer.msg('yes');    //点击确定回调
            layer.close(index);
            showToast();
        },
        btn2: function () {//layer.alert('aaa',{title:'msg title'});  点击取消回调
            layer.msg('bbb');//layer.closeAll();
        }
    });
    });
</script>
</html>
