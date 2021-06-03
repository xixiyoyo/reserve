<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>更改预约</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../css/font.css">
        <link rel="stylesheet" href="../css/xadmin.css">
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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
                <form class="layui-form" action="${pageContext.request.contextPath}/reserved/addRe" method="post">
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="username"  required="" lay-verify="required" autocomplete="off" class="layui-input" value="${reserved.user.uname}" readonly>
                            <input type="hidden" id="reid" name="reid" value="${reserved.reid}" >
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="phoneNum" class="layui-form-label">
                            <span class="x-red">*</span>电话号码</label>
                        <div class="layui-input-inline">
                            <input type="text" id="phoneNum"  required="" lay-verify="required" autocomplete="off" class="layui-input" value="${reserved.user.phoneNum}" readonly></div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">选择场地</label>
                            <div class="layui-input-inline layui-show-xs-block">
                                <select name="contrller" id="se">
                                    <option value="${reserved.sid}">选择场地</option>
                                    <c:forEach items="${allSite}" var="site">
                                        <option value="${site.sid}">${site.sname}</option>
                                    </c:forEach></select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="stime" class="layui-form-label">
                            <span class="x-red">*</span>开始时间</label>
                        <div class="layui-input-inline">
                            <input type="datetime-local" id="stime" name="stime" required="" lay-verify="" autocomplete="off" class="layui-input"><span id="sp1"></span></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="etime" class="layui-form-label">
                            <span class="x-red">*</span>结束时间</label>
                        <div class="layui-input-inline">
                            <input type="datetime-local" id="etime" name="etime" required="" lay-verify="" autocomplete="off" class="layui-input"></div>
                    </div>

<%--                    <div class="layui-form-item">--%>
<%--                        <label class="layui-form-label">--%>
<%--                            <span class="x-red">*</span>支付方式</label>--%>
<%--                        <div class="layui-input-inline">--%>
<%--                            <select name="contrller">--%>
<%--                                <option>支付方式</option>--%>
<%--                                <option>支付宝</option>--%>
<%--                                <option>微信</option>--%>
<%--                                <option>货到付款</option></select>--%>
<%--                        </div>--%>
<%--                    </div>--%>


                </form>
        </div>
<%--        <div class="layui-form-item layui-form-text">--%>
<%--            <label for="desc" class="layui-form-label">描述</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea"></textarea>--%>
<%--            </div>--%>
<%--        </div>--%>

        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="add" id="sub">修改</button>
        </div>

        <script>

            var now = new Date();
            var now2 = new Date();
            var now3 = new Date();
            var now4 = new Date();
            var str = now.getFullYear() + "-" + fix((now.getMonth() + 1), 2) + "-" + fix(now.getDate(), 2) + "T" + fix(now.getHours(), 2) + ":" + fix(now.getMinutes(), 2);
            var str1 = now2.getFullYear() + "-" + fix((now2.getMonth() + 1), 2) + "-" + fix(now2.getDate(), 2) + "T" + fix(now2.getHours(), 2) + ":" + fix(now2.getMinutes(), 2);
            $("#stime").val(str);
            $("#etime").val(str1);

            //将日期格式化为两位，不足补零
            function fix(num, length) {
                return ('' + num).length < length ? ((new Array(length + 1)).join('0') + num).slice(-length) : '' + num;
            }



            $(function () {
                $("#etime").on("change",function () {
                    var x = $("#stime").val();
                    now.setFullYear(parseInt(x.substring(0, 4)));
                    now.setMonth(parseInt(x.substring(5, 7)) - 1);
                    now.setDate(parseInt(x.substring(8, 10)));
                    now.setHours(parseInt(x.substring(11, 13)));
                    now.setMinutes(parseInt(x.substring(14, 16)));
                    var y = $(this).val();
                    now2.setFullYear(parseInt(y.substring(0, 4)));
                    now2.setMonth(parseInt(y.substring(5, 7)) - 1);
                    now2.setDate(parseInt(y.substring(8, 10)));
                    now2.setHours(parseInt(y.substring(11, 13)));
                    now2.setMinutes(parseInt(y.substring(14, 16)));
                    var stime = now;
                    // console.log(stime);
                    var etime = now2;
                    // console.log(etime);
                    var sid = $("#se").val();
                    var reid = $("#reid").val();
                    $.ajax({
                        url:"/site/checkTime",
                        type:"POST",
                        data:{stime:stime,etime:etime,sid:sid,reid:reid},
                        dataType:"text",
                        success:function (msg) {
                            if(msg == "1"){
                                $("#sp1").empty();
                                $("#sp1").html("当前时间已被选择，请重新选择");
                                $("#sp1").css("color","red");
                            }else if(msg == "0"){
                                $("#sp1").empty();
                                $("#sp1").html("可选");
                                $("#sp1").css("color","green");
                            }else if(msg == "2"){
                                $("#sp1").empty();
                                $("#sp1").html("起始时间不能大于结束时间");
                                $("#sp1").css("color","red");
                            }else if(msg == "3"){
                                $("#sp1").empty();
                                $("#sp1").html("当前时间不正确");
                                $("#sp1").css("color","red");
                            }
                        },
                        error:function () {
                            alert("error")
                        }

                    })
                });
                $("#sub").on("click",function () {
                    if($("#sp1").text() == "可选"){
                        var x = $("#stime").val();
                        var y = $("#etime").val();
                        console.log(x);
                        now3.setFullYear(parseInt(x.substring(0, 4)));
                        now3.setMonth(parseInt(x.substring(5, 7)) - 1);
                        now3.setDate(parseInt(x.substring(8, 10)));
                        now3.setHours(parseInt(x.substring(11, 13)));
                        now3.setMinutes(parseInt(x.substring(14, 16)));
                        console.log(y);
                        now4.setFullYear(parseInt(y.substring(0, 4)));
                        now4.setMonth(parseInt(y.substring(5, 7)) - 1);
                        now4.setDate(parseInt(y.substring(8, 10)));
                        now4.setHours(parseInt(y.substring(11, 13)));
                        now4.setMinutes(parseInt(y.substring(14, 16)));
                        var stime = now3;
                        var etime = now4;
                        var sid = $("#se").val();
                        var reid = $("#reid").val();
                        var data  = {stime:stime,etime:etime,sid:sid,reid:reid};
                        console.log(stime);
                        console.log(etime);
                        $.ajax({
                            url: "/reserved/updateReF",
                            type: "POST",
                            data: data,
                            dataType: "text",
                            success:function () {
                                    window.location.href="http://localhost:8080/jsp/success.jsp";
                            },
                            error:function () {
                                window.location.href="http://localhost:8080/jsp/success.jsp";
                            }

                        })
                    }
                })


            });
            layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
            //
            //     //自定义验证规则
            //     form.verify({
            //         nikename: function(value) {
            //             if (value.length < 5) {
            //                 return '昵称至少得5个字符啊';
            //             }
            //         },
            //         pass: [/(.+){6,12}$/, '密码必须6到12位'],
            //         repass: function(value) {
            //             if ($('#L_pass').val() != $('#L_repass').val()) {
            //                 return '两次密码不一致';
            //             }
            //         }
            //     });
            //
            //     //监听提交
            //     form.on('submit(add)',
            //     function(data) {
            //         console.log(data);
            //         //发异步，把数据提交给php
            //         layer.alert("增加成功", {
            //             icon: 6
            //         },
            //         function() {
            //             // 获得frame索引
            //             var index = parent.layer.getFrameIndex(window.name);
            //             //关闭当前frame
            //             parent.layer.close(index);
            //         });
            //         return false;
            //     });
            //
            });
        </script>

    </body>

</html>