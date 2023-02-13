<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../css/mystyle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/users-update.js"></script>
</head>
<body>
      <jsp:include page="left_page.jsp"></jsp:include>
      <div class="main-div">
          <div class="crumb-wrap">
              <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
          </div>
          <div class="result-wrap">
              <div class="result-content">
                  <form action="${pageContext.request.contextPath}/users/updateUsers" method="post" id="myform" name="myform">
                      <table class="insert-tab" width="100%">
                          <tbody>
                          <tr>
                              <th width="120"><i class="require-red">*</i>用户状态</th>
                              <td>
                                  <select name="uStatus" id="catid" class="required">
                                      <option value="0">非会员</option>
                                      <option value="1">会员</option>
                                  </select>
                              </td>
                              <td>
                                  <input type="hidden" value="${users.uStatus}" id="sta">
                              </td>
                          </tr>
                          <tr>
                              <td><input type="hidden" name="uId" value="${users.uId}"></td>
                          </tr>
                          <tr>
                              <th>用户账号:</th>
                              <td><input type="text" name="uName" value="${users.uName}"></td>
                          </tr>
                          <tr>
                              <th>用户等级:</th>
                              <td>用户等级:<input type="text" name="uLevel" value="${users.uLevel}"></td>
                          </tr>
                          <tr>
                              <th>用户积分:</th>
                              <td>用户积分:<input type="text" name="score" value="${users.score}"></td>
                          </tr>
                          <tr>
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
</body>
</html>
