 $(function () {


            var username = $("#username");
            var password = $("#password");
            username.blur(function () {
                    //验证用户名是否为空
                    if($(this).val()==""){
                            $("input[name=username]").css("border-color","red");
                            $("input[name=username]").val("");
                            $("input[name=username]").prop("placeholder","该框不能为空");
                            username.focus();

                    }else{
                            $("input[name=username]").css("border-color","");
                            //查询数据库判断是否有id
                            $.ajax({
                                    url:"admin/selectId",
                                    type:"POST",
                                    dataType:"json",
                                    data:{"AdminAccount":$('#username').val()},//传入的数据为输入的登录名

                                    success:function(data){
                                            alert(typeof data)
                                            if(data.state == 401){
                                                    //返回值为空
                                                    $("input[name=username]").css("border-color","red");
                                                    $("input[name=username]").val("");
                                                    $("input[name=username]").prop("placeholder","用户名不存在");
                                                    username.focus();
                                                    return;
                                            }else{
                                                    if(data.state == 200){
                                                            $("input[name=username]").css("border-color","green");
                                                    }else{
                                                            $("input[name=username]").css("border-color","red");
                                                            $("input[name=username]").val("");
                                                            $("input[name=password]").val("");
                                                            $("input[name=username]").prop("placeholder","该账号不可用");
                                                            username.focus();
                                                            return ;
                                                    }

                                            }
                                    },
                                    error:function () {
                                            $.messager.show({
                                                    title:'提示',
                                                    msg:'添加失败',
                                                    timeout:5000,
                                                    showType:'slide'

                                            });
                                    }


                            });
                    }
            });
            password.blur(function () {
                    //验证密码是否为空
                    if($(this).val()==""){
                            $("input[name=password]").css("border-color","red");
                            $("input[name=password]").val("");
                            $("input[name=password]").prop("placeholder","该框不能为空");
                            return ;
                    }else{
                            $("input[name=password]").css("border-color","");
                    }
            });
            //提交事件
            $("#submit").click(function () {
                    if(username.val()==""){
                            //判断空值
                            $("input[name=username]").css("border-color","red");
                            username.focus();
                            return ;
                    }
                    if(password.val()==""){
                            //判断空值
                            password.focus();
                            $("input[name=password]").css("border-color","red");
                            return ;
                    }

                    $.ajax({
                            url:"admin/selectId",
                            type:"POST",
                            dataType:"json",
                            data:{"AdminAccount":$('#username').val(),"AdminPwd":$('#password').val()},

                            success:function (data){
                                    if (data.state == 200){
                                            $("input[name=password]").css("border-color","green");
                                            //将id和账号添加到cookie中
                                            setCookie("adminAccount",data.data.adminAccount);
                                            setCookie("adminID",data.data.adminID);
                                            setCookie("adminRight",data.data.adminRight);
                                            //alert(getCookie("adminID"));
                                            window.location = "../main.html";
                                    }else {
                                            //密码错误
                                            $("input[name=password]").css("border-color","red");
                                            $("input[name=password]").val("");
                                            $("input[name=password]").prop("placeholder","密码错误");
                                            return ;
                                    }
                            },
                            error:function () {

                                    alert("网络异常");
                            }




                    });
            });

    });
         // 设置cookie，保存登录信息
         function setCookie(c_name, value, expiredays) {
                 var exdate = new Date();
                 exdate.setTime(Number(exdate) + expiredays);
                 document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
         }
         function getCookie(c_name) {
                 if(document.cookie.length > 0) {
                         c_start = document.cookie.indexOf(c_name + "=");//获取字符串的起点
                         if(c_start != -1) {
                                 c_start = c_start + c_name.length + 1;//获取值的起点
                                 c_end = document.cookie.indexOf(";", c_start);//获取结尾处
                                 if(c_end == -1) c_end = document.cookie.length;//如果是最后一个，结尾就是cookie字符串的结尾
                                 return decodeURI(document.cookie.substring(c_start, c_end));//截取字符串返回
                         }
                 }
                 return "";
         }

         function DelCookie(name) {
                 var exp = new Date();
                 exp.setTime(exp.getTime() + (-1 * 24 * 60 * 60 * 1000));
                 var cval = getCookie(name);
                 document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
         }



