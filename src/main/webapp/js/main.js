$(function () {
        if(getCookie("adminID")==""){
                alert("请登录后操作");
                window.location="login.html";
        }
        if(getCookie("adminRight")!="1"){
                //不是管理员，禁用一些功能
                $("#person").attr('href','');
                $("#person").click(function () {
                //alert("不可用");
                        $.messager.show({
                                title:'提示',
                                msg:'功能不可用',
                                timeout:1000,
                                showType:'slide'

                        });
                });
        }
      $("#adminAccount").val(getCookie("adminAccount"));
      $.ajax({
                url:"admin/selectAll",
                type:"POST",
                data:{"AdminID":getCookie("adminID")},
                dateType:"json",
                success:function (data) {

                        var result = eval("("+ data +")");
                        //alert(result.data.adminName);
                        $("#adminName").val(result.data.adminName);
                        if(result.data.adminRight=="1"){
                                //alert("aaa1");
                                $("#AdminRight").val("管理员");
                                $("#guanli").html("管理员帐号")
                        }else {
                               //不是管理员别的待补充
                        }
                        $("#Department").val(result.data.departmentName);

                },
              error:function () {

                      alert("网络异常");
              }
        });
      $("#reset").click(function () {
              $("#adminAccount").val(getCookie("adminAccount"));
              $.ajax({
                      url:"admin/selectId",
                      type:"POST",
                      data:{"AdminID":getCookie("adminID")},
                      dateType:"json",
                      success:function (data) {
                              var result = eval("("+ data +")");
                              $("#adminName").val(result.data.adminName);
                              if(result.data.adminRight=="1"){
                                      $("#AdminRight").val("管理员");

                              }
                              $("#Department").val(result.data.departmentName);

                      },
                      error:function () {

                              alert("网络异常");
                      }
              });
      });
      $("#sub").click(function () {
              //获取保存对象
                var adminAccount = $("#adminAccount").val();
                var adminPwd = $("adminPassword").val();


      });

});

$("#mainBox").layout({
        fit:true,
        border:false
})
$("#mean").menu('show',{
        left: 200,
        top: 100
})
$("#left01").accordion({
        border:false

})
$("#con").tabs({
        fit:true,
        border:false
})
$("#myMes").dialog({
        title:"个人信息详情",
        width:400,
        height:420,
        modal:true,
        iconCls:'icon-mes',
        maximizable:true,
        closed: true

})
function openMes() {
        $("#myMes").dialog({
                closed: false

        })

}
function saveExit() {
        $.messager.confirm('退出确认','你是否退出系统？',function () {

        })

}
function saveCanle() {
        $.messager.confirm('注销确认','你是否注销用户？',function () {

        })

}
$(".topText a").click(function () {
        $(this).addClass('textActive').siblings().removeClass('textActive');

})
$("#left01  a").click(function () {
        var testVal=$(this).text();
        var thisUrl=$(this).attr('href');
        var con = '<iframe scrolling="no" frameborder="0"  src="'+thisUrl+'" style="width:100%;height:100%;">';
        $('#con').tabs('add',{
                title: testVal,
                selected: true,
                closable:true,
               content:con


        });

})
$("#con").tabs({
        onSelect:function (tit,ind) {
                if(ind==0){
                        $("#ifDiv").attr('src',"home.html");
                }

        }
})


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
// 设置cookie，保存登录信息
function setCookie(c_name, value, expiredays) {
        var exdate = new Date();
        exdate.setTime(Number(exdate) + expiredays);
        document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
}
function DelCookie(name) {
        var exp = new Date();
        exp.setTime(exp.getTime() + (-1 * 24 * 60 * 60 * 1000));
        var cval = getCookie(name);
        document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
}