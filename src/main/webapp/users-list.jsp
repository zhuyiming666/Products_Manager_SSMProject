<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/mystyle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/users-update.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/users.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
</head>
<body>
<jsp:include page="left_page.jsp"></jsp:include>
<div class="main-div1">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span
                class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="${pageContext.request.contextPath}/users/getUsersAll" method="post">
                <table class="search-tab">
                    <tr>
                        <th width="120">选择分类:</th>
                        <td>
                            <select name="uStatus" id="selectStatus">
                                <option value="">全部</option>
                                <option value="1">会员</option>
                                <option value="0">非会员</option>
                            </select>
                        </td>
                        <th width="70">用户账号</th>
                        <td><input class="common-text" placeholder="关键字" name="uName"  type="text">
                        </td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form   name="myform" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <input type="hidden" value="${orderby_index}" id="orderby_index_id">
                    <input type="hidden" value="${uStatus}" id="uStatus_index">
                    <input type="hidden" value="${uName}" id="uName_str">
                    <a id="batchDel" href="javascript:orderByLevel(0);"><span id="span_text1">👆</span>根据等级升序</a>
                    <a id="updateOrd" href="javascript:orderByLevel(1);"><span id="span_text2">👇</span>根据等级降序</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th>用户ID</th>
                        <th>用户账号</th>
                        <th>用户状态</th>
                        <th>用户等级</th>
                        <th>用户积分</th>
                        <th>用户操作</th>
                    </tr>
                    <c:forEach items="${pageBean.list}" var="list">
                        <tr>
                            <td>${list.uId}</td>
                            <td>${list.uName}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${list.uStatus==0}">
                                        <span class="span_status">非会员</span>

                                    </c:when>
                                    <c:when test="${list.uStatus==1}">
                                        <span class="span_status">会员</span>
                                    </c:when>
                                </c:choose>
                            </td>
                                <%-- <td>${list.uStatus}</td>--%>
                            <td>${list.uLevel}</td>
                            <td>${list.score}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/users/getUsersByuId?uId=${list.uId}">修改</a>
                                <a href="javascript:deleteByuId('${list.uId}','${uName}','${uStatus}','${orderby_index}','${pageBean.currPage}','${admin.admin_type_id}')">注销</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="list-page">
                    <c:if test="${requestScope.pageBean.currPage != 1}">
                        <a href="${pageContext.request.contextPath}/users/getUsersAll?currPage=1&uName=${uName}&uStatus=${uStatus}&orderbyId=${orderby_index}">第一页</a>
                        <a href="${pageContext.request.contextPath}/users/getUsersAll?currPage=${pageBean.currPage-1}&uName=${uName}&uStatus=${uStatus}&orderbyId=${orderby_index}">上一页</a>
                    </c:if>
                    <c:if test="${requestScope.pageBean.currPage != requestScope.pageBean.totalPage}">
                        <a href="${pageContext.request.contextPath}/users/getUsersAll?currPage=${pageBean.currPage+1}&uName=${uName}&uStatus=${uStatus}&orderbyId=${orderby_index}">下一页</a>
                        <a href="${pageContext.request.contextPath}/users/getUsersAll?currPage=${pageBean.totalPage}&uName=${uName}&uStatus=${uStatus}&orderbyId=${orderby_index}">尾页</a>
                    </c:if>
                    <span>数据总条数:${pageBean.totalCount}</span>
                    <span>第${requestScope.pageBean.currPage }/ ${requestScope.pageBean.totalPage}页</span>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
