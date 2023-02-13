<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『学习猿地』后台管理</title>
	<link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
    <script type="text/javascript" src="js/login.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="userd">用户名：</label>
                        <input type="text" name="username" value="${a_Name}"  id="userd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwdd">密码：</label>
                        <input type="password" name="password" id="pwdd" value="${a_Pass}" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        验证码:<input type="text" name="checkcode"  size="40" class="admin_input_style"/>
                        <img alt="图片" src="checkCode"  style="height:43px;cursor:pointer;width:80px"  onclick="this.src=this.src+'?'">
                        <span>点击图片换一张</span>
                    </li>
                    <li>
                        <input type="checkbox" name="checkCookie" title="三天内免登录">
                        <span>三天内免登录</span>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <h3>${errorMsg}</h3>
</div>
<script src="layer/layer.js"></script>
<script>
    layer.msg('hello');
</script>
</body>
</html>