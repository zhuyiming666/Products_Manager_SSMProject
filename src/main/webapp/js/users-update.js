/*
window.onload=function (){
    var sta=document.getElementById("sta");
    alert(sta);
    var sta_value=sta.value;
    var catid=document.getElementById("catid");
    catid.value =sta_value;
}*/

function deleteByuId(uId,uName,uStatus,orderbyId_index,currPage,admin_type_id) {
    if(admin_type_id!=1){
        layer.alert('你没有这个权限');
        return;
    }
    if(confirm("确定要删除吗?")){
        $.ajax({
            type: "post",
            url:"getDeleteByuId?uId="+uId,
            success:function (data){
                alert('删除成功!');
                location.href="http://localhost:8080/ssmTemplte01/users/getUsersAll?currPage="+currPage+"&uName="+uName+"&orderbyId="+orderbyId_index+"&uStatus="+uStatus;
            },
            error:function (){
                layer.alert("该用户购买了商品,不能删除!");
            }
        })
    }
}