$(function () {
    $.ajax({
        type: "post",
        url: "showProductType",
        dataType: "json",
        success: function (proList) {
            var str = "<option name='type_Id' value='0'>所有类型</option>";
            for (var i = 0; i < proList.length; i++) {
                var x;
                str += "<option name='type_Id' value=" + proList[i].type_Id + ">" + proList[i].type_Name + "</option>";
            }
            $("#select_test").html(str);
        }
    })
})

function deleteById(pid) {
    if (confirm("确定要删除吗?")) {
        $.ajax({
            type: "post",
            url: "deleteProduct?pid=" + pid,
            success: function (data) {
                alert("删除成功!");
                location.href = "http://localhost:8080/ssmTemplte01/showAll";
            }
        })
    }
}

/*window.onload = function () {
    var checks = document.getElementById("checks");
    var check = document.getElementsByName("check");
    checks.onclick = function () {
        if(checks.checked) {
            for (var i = 0; i < check.length; i++) {
                check[i].checked = true;
            }
        }else {
            for (var i = 0; i < check.length; i++) {
                check[i].checked = false;
            }
        }
    }
    for (var i=0;check.length;i++){
        check[i].onclick=function (){
            if(!this.checked){
                checks.checked=false;
            }
            for (var x=0;check.length;x++){
                if(!check[x].checked){
                   return;
                }
                checks.checked=true;
            }
        }

    }
}*/
window.onload = function () {
    var checks = document.getElementById("checks");
    var check = document.getElementsByName("check");
    checks.onclick = function () {
        for (var i = 0; i < check.length; i++) {
            check[i].checked = this.checked;
        }
    }
    for (var j = 0; j < check.length; j++) {
        check[j].onclick = function () {
            var flag = true;
            for (var i = 0; i < check.length; i++) {
                if (!check[i].checked) {
                    flag = false;
                    break;
                }
            }
            checks.checked = flag;
        }
    }
}

deleteByIds = function (currPage, msgName, type_Id) {
    var check = document.getElementsByName("check");
    var str = "";
    for (var i = 0; i < check.length; i++) {
        if (check[i].checked) {
            str += check[i].value + ",";
        }
    }
    if(str==""){
        alert("你还没有选中数据哦！");
        return;
    }
    var index = str.lastIndexOf(",");
    var ids = str.substring(0, index);
    if(confirm("确定要进行批量删除吗?")) {
        location.href = "http://localhost:8080/ssmTemplte01/deleteByIds?currPage=" + currPage + "&msgName=" + msgName + "&type_Id=" + type_Id + "&ids=" + ids;
    }
    }







