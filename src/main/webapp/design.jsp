<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/mystyle.css"/>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/Product.js"></script>
    <script type="text/javascript" src="js/ProductType.js"></script>
</head>
<body>
   <jsp:include page="left_page.jsp"></jsp:include>
    <div class="main-div">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/showAll" method="post" onsubmit="return subt()">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="type_Id" id="select_test">
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="msgName"  type="text"></td>
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
                        <a href="insert.jsp"><i class="icon-font"></i>新增产品</a>
                        <a id="batchDel" href="javascript:deleteByIds('${pageInfo.currPage}','${pageInfo.msgName}','${pageInfo.type_Id}');">🔪批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                  <table class="result-tab" width="100%" style="text-align:center;">
                            <td>
                                <input type="checkbox" name="checks" id="checks">
                            </td>
                            <td>产品ID</td>
                            <td>产品名称</td>
                            <td>产品描述</td>
                            <td>产品价格</td>
                            <td>产品展示</td>
                            <td>产品库存</td>
                            <td>产品类型</td>
                            <td>上架日期</td>
                            <td>操作</td>
                        </tr>
                      <c:forEach var="list" items="${pageInfo.arrList}">
                        <tr>
                            <td>
                                <input type="checkbox" name="check" value="${list.p_Id}">
                            </td>
                            <td>${list.p_Id}</td>
                            <td>${list.p_Name}</td>
                            <td>${list.p_Content}</td>
                            <td>${list.p_price}</td>
                            <td>
                                <img src="image_ssm/${list.p_Image}" height="20%" width="50px" alt="图片">
                            </td>
                            <td>${list.p_Number}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${list.type_Id==1}">
                                        手机
                                    </c:when>
                                    <c:when test="${list.type_Id==2}">
                                        电脑
                                    </c:when>
                                    <c:when test="${list.type_Id==3}">
                                        电视
                                    </c:when>
                                    <c:otherwise>
                                        其他
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><fmt:formatDate value="${list.p_Date}" /></td>
                            <td>
                                <%--<a href="${pageContext.request.contextPath}/deleteProduct?pid=${list.p_Id}">删除</a>--%>
                                <a href="javascript:deleteById(${list.p_Id})">删除</a>
                                <a href="${pageContext.request.contextPath}/selectById?pid=${list.p_Id}&currPage=${pageInfo.currPage}">修改</a>
                            </td>
                        </tr>
                      </c:forEach>
                    </table>
                    <div class="list-page">
                            <a href="${pageContext.request.contextPath}/showAll?currPage=1&msgName=${pageInfo.msgName}&type_Id=${pageInfo.type_Id}">第一页</a>
                            <a href="${pageContext.request.contextPath}/showAll?currPage=${pageInfo.currPage+1}&msgName=${pageInfo.msgName}&type_Id=${pageInfo.type_Id}">下一页</a>
                            <a href="${pageContext.request.contextPath}/showAll?currPage=${pageInfo.currPage-1}&msgName=${pageInfo.msgName}&type_Id=${pageInfo.type_Id}">上一页</a>
                            <a href="${pageContext.request.contextPath}/showAll?currPage=${pageInfo.pageCount}&msgName=${pageInfo.msgName}&type_Id=${pageInfo.type_Id}">尾页</a>
                            <span>数据总条数:${pageInfo.totalCount}</span>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--/main-->
</body>
<script>
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
</html>