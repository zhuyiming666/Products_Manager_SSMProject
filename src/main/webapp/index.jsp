<%@ page language="java" import="java.util.*" contentType="text/html; charset=gbk"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>思华就在您身边！</title>
    <script language='javascript'>
        history.go(1);
    </script>
    <meta http-equiv=Content-Type content=text/html;charset=gb2312>
</head>
<s:if test="#session.user == null">
    <c:redirect url="error.jsp"></c:redirect>
</s:if>
<frameset rows="64,*"  frameborder="NO" border="0" framespacing="0">
    <frame src="top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
    <frameset cols="200,*"  rows="560,*" id="frame">
        <frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
        <frame src="right.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
    </frameset>
</frameset>
<noframes>
    <body></body>
</noframes>
</html>









