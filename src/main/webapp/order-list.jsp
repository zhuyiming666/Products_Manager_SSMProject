<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/mystyle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/order.js"></script>
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
                                    <option>待收获</option>
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
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
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
                        <c:forEach var="list" items="${pageBean.list}">
                         <tr>
                             <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                             <td>${list.oId}</td>
                             <td>${list.totalPrice}</td>
                             <td>${list.remarks}</td>
                             <td>${list.status}</td>
                             <td>
                                 <fmt:formatDate value="${list.oDate}"></fmt:formatDate>
                             </td>
                             <td>${list.users.uName}</td>
                             <td>${list.address.cnee}</td>
                             <td>${list.address.address}</td>
                             <td>${list.address.phone}</td>
                             <td>
                                 <a href="${pageContext.request.contextPath}/orderController/showOrderDetail?oId=${list.oId}">查看详情</a>
                             </td>
                         </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
                        <c:if test="${requestScope.pageBean.currPage != 1}">
                            <a href="${pageContext.request.contextPath}/orderController/showAllOrder?currPage=1">第一页</a>
                            <a href="${pageContext.request.contextPath}/orderController/showAllOrder?currPage=${pageBean.currPage-1}">上一页</a>
                        </c:if>
                        <c:if test="${requestScope.pageBean.currPage != requestScope.pageBean.totalPage}">
                            <a href="${pageContext.request.contextPath}/orderController/showAllOrder?currPage=${pageBean.currPage+1}">下一页</a>
                            <a href="${pageContext.request.contextPath}/orderController/showAllOrder?currPage=${pageBean.totalPage}">尾页</a>
                        </c:if>
                        <span>数据总条数:${pageBean.totalCount}&nbsp;&nbsp;</span>
                        <span>第${requestScope.pageBean.currPage }/ ${requestScope.pageBean.totalPage}页</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>

</body>
</html>