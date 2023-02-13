<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『学习猿地』后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/update.js"></script>

</head>
<body>
<jsp:include page="left_page.jsp"></jsp:include>
    <div class="main-div">

        <div class="config-items">
            <div class="config-title">
                <h1><i class="icon-font">&#xe014;</i>站长信息设置</h1>
            </div>
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/updateProduct?currPage=${currPage1}" method="post" onsubmit="return subt1()">
                <table width="100%" class="insert-tab">
                    <tr>
                        <td><input type="hidden" name="p_Id" value="${product.p_Id}"><br></td>
                    </tr>
                    <tr>
                        <th width="15%"><i class="require-red">*</i>产品名称:</th>
                        <td><input type="text" name="p_Name" value="${product.p_Name}"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>产品价格:</th>
                        <td><input type="text" name="p_price" value="${product.p_price}"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>产品外观:</th>
                        <td>
                            <input type="file"  id="fileid" value="${product.p_Image}"
                                   onchange="test(this.value)">
                            <span id="img1"></span>
                            <input type="hidden" name="p_Image" value="${product.p_Image}" id="img_src">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>产品类型:</th>
                        <td>
                            <select name="type_Id" id="select_test" class="required">
                            </select>
                            <input type="hidden" value="${product.type_Id}" id="hid">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>产品库存:</th>
                        <td><input type="text" name="p_Number" value="${product.p_Number}"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>上架日期:</th>
                        <td><input type="date" name="p_Date" value="${d}"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>产品描述:</th>
                        <td><textarea name="p_Content" value="${product.p_Content}">${product.p_Content}</textarea></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="hidden" value="siteConf.inc.php" name="file">
                            <input type="submit" value="提交" class="btn btn-primary btn6 mr10">
                            <input type="button" value="返回" onClick="history.go(-1)" class="btn btn6">
                        </td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
        </form>
    </div>
</div>
<!--/main-->
</div>

</body>
</html>