<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统登录</title>
    <#include "common.ftl">
</head>
<body>
<div class="main-body">
    <div class="login-main">
        <div class="login-top">
            <span>进销存系统登陆</span>
            <span class="bg1"></span>
            <span class="bg2"></span>
        </div>
        <form class="layui-form login-button" action="">
            <div class="center">
                <div class="item">
                    <span class="icon icon-2"></span>
                    <input type="text" name="username" placeholder="请输入登陆账号" maxlength="24"/>
                </div>
                <div class="item">
                    <span class="icon icon-3"></span>
                    <input type="text" name="password" placeholder="请输入密码" maxlength="24"/>
                    <span class="bind-password icon icon-4"></span>
                </div>
            </div>
            <div class="tip">
                <span><input type="checkbox" name="rememberMe" value="true" lay-skin="primary"></span>
                <span class="login=btn">保持登录</span>
                <a href="javascript:" class="forget-password">忘记密码?</a>
            </div>
            <div class="layui-form-item" style="">
                <button class="login-btn" lay-submit="" lay-filter="login">立即登录</button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="${ctx.contextPath}/js/index.js" charset="utf-8"></script>
</html>