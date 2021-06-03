<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
    
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">昵称</label>
                        <div class="layui-input-inline">
                            <input type="hidden" value="${user.uid}" name="uid" id="uid">
                            <input type="text" id="L_username" name="uname" value="${user.uname}" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="phone" class="layui-form-label">
                            <span class="x-red">*</span>电话号码</label>
                        <div class="layui-input-inline">
                            <input type="text" id="phone" name="phoneNum" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${user.phoneNum}"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="oldpwd" class="layui-form-label">
                            <span class="x-red">*</span>旧密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="oldpwd" name="oldpass" required="" lay-verify="required" autocomplete="off" class="layui-input"><span id="opwd"></span></div>
                    </div>

                    <div class="layui-form-item">
                        <label for="N_pass" class="layui-form-label">
                            <span class="x-red">*</span>新密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="N_pass" name="newpass" required="" lay-verify="pass" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux">6到16个字符</div></div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_repass" name="password" required="" lay-verify="repass" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="save" lay-submit="">保存</button></div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //自定义验证规则
                form.verify({
                    nikename: function(value) {
                        if (value.length < 5) {
                            return '昵称至少得5个字符啊';
                        }
                    },
                    pass: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#N_pass').val() != $('#L_repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });

                //监听提交
                form.on('submit(save)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    var uid = $("#uid").val();
                    var uname = $("#L_username").val();
                    var phoneNum = $("#phone").val();
                    var password = $("#L_repass").val();
                    var oldpwd =$("#oldpwd").val();

                    $.ajax({
                        url:"/user/updateUser",
                        type:"POST",
                        data:{uid:uid,uname:uname,phoneNum:phoneNum,password:password,oldpwd:oldpwd},
                        dataType:"text",
                        success:function (msg) {
                            if(msg == "true"){
                                layer.alert("修改成功", {
                                        icon: 6
                                    },
                                    function() {
                                        // 获得frame索引
                                        var index = parent.layer.getFrameIndex(window.name);
                                        //关闭当前frame
                                        parent.layer.close(index);
                                    });
                            }else if(msg == "false"){
                                layer.alert("修改失败", {
                                    icon: 6
                                })
                                window.location.href="/jsp/updateInfo.jsp";
                            }
                        }
                    });

                    return false;
                });

            });</script>
<!--        <script>var _hmt = _hmt || []; (function() {-->
<!--                var hm = document.createElement("script");-->
<!--                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";-->
<!--                var s = document.getElementsByTagName("script")[0];-->
<!--                s.parentNode.insertBefore(hm, s);-->
<!--            })();</script>-->
    </body>

</html>