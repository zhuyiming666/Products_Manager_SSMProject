<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单展示</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/mystyle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/test.js"></script>
</head>
<body>
<jsp:include page="left_page.jsp"></jsp:include>
<div class="main-div1">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="#" method="post">
                <table class="search-tab">
                    <tr>
                        <th width="120">选择分类:</th>
                        <td>
                            <select name="search-sort" id="selectStatus">
                                <option>全部</option>
                                <option>已发货</option>
                                <option>未发货</option>
                                <option>运输中</option>
                                <option>待收货</option>
                                <option>退款中</option>
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
                <table class="result-tab" width="100%" id="tbstr">
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
        </form>
    </div>
</div>
</body>
</html>
