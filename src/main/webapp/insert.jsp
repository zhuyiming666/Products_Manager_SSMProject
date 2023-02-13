<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/mystyle.css"/>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/insert.js"></script>
</head>
<body>
<jsp:include page="left_page.jsp"></jsp:include>
    <div class="main-div">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span
                    class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span
                    class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/insertProduct" method="post" id="myform" name="myform"
                      onsubmit="return subt()">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th width="120"><i class="require-red">*</i>分类：</th>
                            <td>
                                <select name="type_Id" id="select_test" class="required">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>名称：</th>
                            <td>
                                <input class="common-text required" id="title" name="p_Name" size="50"
                                       type="text">
                            </td>
                        </tr>
                        <tr>
                            <th>价格：</th>
                            <td><input class="common-text" name="p_price" size="50"  type="text"></td>
                        </tr>
                        <tr>
                            <th>库存：</th>
                            <td><input class="common-text" name="p_Number" size="50" type="text"></td>
                        </tr>
                        <tr>
                            <th>上架时间：</th>
                            <td><input class="common-text" name="p_Date" size="50" type="date"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>缩略图：</th>
                            <td>
                                <input name="p_Image" id="file_test" type="file"  onchange="test(this.value)">
                                <span id="img1"></span>
                            </td>
                        </tr>
                        <tr>
                            <th>描述：</th>
                            <td><textarea name="p_Content" class="common-textarea" id="content" cols="30"
                                          style="width: 98%;" rows="10"></textarea></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
<script>
    $(function(){
        $.ajax({
            type:"post",
            url:"showProductType",
            dataType:"json",
            success:function(proList){
                var str="<option name='type_Id' value='0'>所有类型</option>";
                for (var i=0;i<proList.length;i++){
                    var x;
                    str+="<option name='type_Id' value="+proList[i].type_Id+">"+proList[i].type_Name+"</option>";
                }
                $("#select_test").html(str);
            }
        })
    })

    function subt() {
        var select_test=document.getElementById("select_test");
        var index=select_test.selectedIndex;    // 选中索引(选取select中option选中的第几个)
        var value=select_test.options[index].value;
        select_test.value=value;
        if(select_test.value!=null){
            return true;
        }
        return false;
    }

</script>
</body>
</html>