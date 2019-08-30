$(function () {
    employeeTable();

});
//查找事件
// 查询按钮事件
function searchEmployeeSubmit(){
    $("#employeeTable").datagrid("load",{
        employeeName:$("#employeeNameSearch").val(),
        DepartmentName:$("#employeeSearchDepartment").val()
    })
}
function editEmployeeSubmit() {
    //编辑事件
    var editEmployeeID = $("#editEmployeeID").val();//员工id
    var editEmployeeName = $("#editEmployeeName").val();//员工姓名
    var editEmployeeGender = $("input[name='editEmployeeGender']:checked").val();//员工性别
    var editPositionName = $("#editPositionName").val();//职位
    var editEmployeeDepartment = $("#editEmployeeDepartment").val();//所属部门
    var editCardNumber = $("#editCardNumber").val();//员工卡号
    var editEmployeeState = $("#editEmployeeState").val();//员工状态
    //alert(typeof editPositionName);
    $.ajax({
        url:'employee/employeeUpdate',
        type:'POST',
        dataType:'json',
        data:{'EmployeeID':editEmployeeID,
            'EmployeeName':editEmployeeName,
            'EmployeeGender':editEmployeeGender,
            'PositionID':editPositionName,
            'DepartmentID':editEmployeeDepartment,
            'CardNumber':editCardNumber,
            'EmployeeState':editEmployeeState},
        success:function (data) {
            //判断传值
            if(data.update ==200){
                $("#editEmployeeBox").window("close");
                $.messager.show({
                    title:'提示',
                    msg:'修改成功',
                    timeout:1000,
                    showType:'slide'
                });
                $("#employeeTable").datagrid("reload");
            }else{
                $.messager.show({
                    title:'提示',
                    msg:'修改失败',
                    timeout:1000,
                    showType:'slide'

                });
            }

        },
        error:function () {
            $.messager.show({
                title: '提示',
                msg: '网络异常',
                timeout: 1000,
                showType: 'slide'

            });
        }


    });

}
//编辑事件
function editEmployee(rows) {
    $("#editEmployeeBox").dialog({
        title:"员工信息修改",
        width:800,
        height:500,
        closed: false,
        modal:true,
        shadow:true
    });
    var row = rows.split(",");
    $("#editEmployeeForm").form("load",{
        editEmployeeID:row[0],
        editEmployeeName:row[1],
        editEmployeeGender:row[2],
        //editPositionName:row[4],
        //editEmployeeDepartment:row[6],
        editCardNumber:row[7],
        editEmployeeState:row[8],
        editIndex:row[9]
    });
    $("#editPositionName").combobox({
        //初始化职位
        url:'Position/selectAll',
        valueField:'positionID',
        textField:'positionName'
    });
    $("#editEmployeeDepartment").combobox({
       //初始化部门
        url:'Department/selectAll',
        valueField:'departmentID',
        textField:'departmentName'
    });
}

function delEmployee(employeeID,index) {
    //删除事件
    $.messager.confirm('Confirm','确认删除?',function (r) {
        if(r){
            $.ajax({
                url:'employee/employeeDelete',
                type:'POST',
                dataType:'json',
                data:{'employeeID':employeeID},
                success:function (data) {
                    //删除成功
                    if(data.deleteAll == 200){
                        $.messager.show({
                            title:'提示',
                            msg:'删除成功',
                            timeout:1000,
                            showType:'slide'
                        });
                        $("#employeeTable").datagrid("reload");
                    }else{
                        $.messager.show({
                            title:'提示',
                            msg:'删除失败',
                            timeout:1000,
                            showType:'slide'
                        });
                    }
                },
                error:function () {
                    $.messager.show({
                        title:'提示',
                        msg:'网络异常',
                        timeout:1000,
                        showType:'slide'

                    });
                }
            });
        }
    })

    }
$("#addEmployeeSubmit").click(function () {
    //增加提交页面
    var name = $("#employeeName").val();//员工姓名
    var gender = $('input[name="txtEmployeeGender"]:checked').val()//性别
    var PositionID = $("#positionName").val();//职位
    var DepartmentID = $("#employeeDepartment").val();//部门
    var cardNumber = $("#cardNumber").val();//卡号
    var employeeState = $("#employeeState").val();//所属状态

    $.ajax({
        url:'employee/addEmployee',
        type:'POST',
        dataType:'json',
        data:{'EmployeeName':name,'EmployeeGender':gender,'PositionID':PositionID,
            'DepartmentID':DepartmentID,'CardNumber':cardNumber,'employeeState':employeeState},
        success:function (data) {
            if(data.select==200){
                //添加成功
                $.messager.show({
                    title:'提示',
                    msg:'添加成功',
                    timeout:5000,
                    showType:'slide'
                });
                $("#employeeName").val("");//员工姓名
                $("#cardNumber").val("");//卡号
                $("#addEmployeeBox").window("close");
                //刷新表格
                $("#employeeTable").datagrid("reload");
            }else{
                $.messager.show({
                    title:'提示',
                    msg:'添加失败',
                    timeout:5000,
                    showType:'slide'
                });

            }
        },
        error:function () {
            $.messager.show({
                title:'提示',
                msg:'网络异常',
                timeout:5000,
                showType:'slide'

            });
        }

    });
});



//初始化列表
function employeeTable() {
    $("#employeeTable").datagrid({
        title:"员工列表",
        url:"employee/employeeAll",
        fitColumns:true,
        striped:true,
        singleSelect:true,
        pagination:true,
        //pageSize:10,
        width:'100%',
        rownumbers:true,
        //pageNumber:10,
        nowrap:true,
        height:'auto',
        sortName:'employeeID',
        checkOnSelect:false,
        sortOrder:'asc',
        columns:[[
            {
                field:'employeeID',
                title:'编号',
                width:100,
                align:'center'
            },{
                field:'employeeName',
                title:'姓名',
                width:100,
                align:'center'
            },{
                field:'employeeGender',
                title:'性别',
                width:100,
                align:'center',
                formatter:function (value,row,index) {
                    if(value == 1){
                        return "男";
                    }else{
                        return "女";
                    }
                }
            },{
                field:'positionName',
                title:'职位',
                width:100,
                align:'center'
            },{
                field:'departmentName',
                title:'部门',
                width:100,
                align:'center'
            },{
                field:'cardNumber',
                title:'卡号',
                width:100,
                align:'center'
            },{
                field:'employeeState',
                title:'状态',
                width:100,
                align:'center',
                formatter:function (value,row,index) {
                    if(value == 1){
                        return "正常";
                    }else{
                        return "停用";
                    }

                }
            },
            {
                field:'opt',
                title:'操作',
                width:100,
                align:'center',
                formatter:function (value,row,index) {
                    var rows = [row.employeeID,row.employeeName,row.employeeGender,row.positionID,row.positionName,row.departmentID,row.departmentName,row.cardNumber,row.employeeState,index];

                    var content = '<a href="javascript:void(0)" class="operA" onclick="editEmployee(\'' + rows + '\')">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n' +
                        '<a href="javascript:void(0)" class="operA01" onclick="delEmployee(\'' + row.employeeID + '\',\'' + index+ '\')">删除</a>';
                    return content;
                }
            }

        ]]

    });
    //添加事件
    $("#addEmployeeBtn").click(function () {
        $("#addEmployeeBox").dialog({
            title:"添加员工信息",
            width:800,
            height:500,
            closed: false,
            modal:true,
            shadow:true
        });
        $("#positionName").combobox({
            //初始化员工表
            url:'Position/selectAll',
            valueField:'positionID',
            textField:'positionName'
        });

        $("#employeeDepartment").combobox({
            //初始化部门
            url:'Department/selectAll',
            valueField:'departmentID',
            textField:'departmentName'
        });


    });



}