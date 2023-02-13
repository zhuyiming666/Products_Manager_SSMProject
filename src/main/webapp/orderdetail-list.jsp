<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/mystyle.css"/>
</head>
<body>
<jsp:include page="left_page.jsp"></jsp:include>
<div class="main-div">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="#" method="post">
                <table class="search-tab">
                    <tr>
                        <th width="120">选择状态:</th>
                        <td>
                            <select name="order_status" id="selectStatus">

                            </select>
                        </td>
                        <th width="70">关键字:</th>
                        <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form name="myform" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="insert.html"><i class="icon-font"></i>新增作品</a>
                    <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                    <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th>订单编号</th>
                        <th>产品数量</th>
                        <th>产品单价</th>
                        <th>产品名称</th>
                        <th>产品样式</th>
                    </tr>
                    <c:forEach var="orderDetails" items="${orderDetails}">
                    <tr>
                        <td>${orderDetails.oId}</td>
                        <td>${orderDetails.pNumber}</td>
                        <c:forEach var="plist" varStatus="vs" begin="0" end="${fn:length(orderDetails.productList)-1}" step="1" items="${orderDetails.productList}">
                        <td>${plist.p_price}</td>
                        <td>${plist.p_Name}</td>
                        <td>
                            <img src="image_ssm/${plist.p_Image}" height="20%" width="50px" alt="图片">
                        </td>
                        </c:forEach>
                    </tr>
                    </c:forEach>
                </table>
                <div class="list-page"> 2 条 1/1 页</div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
