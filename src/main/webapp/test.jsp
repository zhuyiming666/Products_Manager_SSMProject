<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/mystyle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/test.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/mobile/layer.js"></script>
</head>
<body>
<div>
    <select name="search-sort" id="selectStatus">
        <option>全部</option>
        <option>已发货</option>
        <option>待发货</option>
        <option>运输中</option>
        <option>待收货</option>
        <option>退款中</option>
    </select>
</div>
<div class="result-content">
    <table id="tbstr" class="result-tab" border="1">
        <tr id="tr_append">
            <th>订单编号</th>
            <th>订单总价格</th>
            <th>订单备注</th>
            <th>订单状态</th>
            <th>下单日期</th>
            <th>用户账号</th>
            <th>收货人</th>
            <th>收获地址</th>
            <th>联系人电话</th>
            <th>订单详情</th>
        </tr>
    </table>
</div>
<div id="div_currpage">
  <div id ="div_currpage_sub">
  </div>
</div>

</body>
</html>
