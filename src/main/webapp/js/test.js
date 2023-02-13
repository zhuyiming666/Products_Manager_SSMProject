$(function (){
    $("#selectStatus").change(function (){
        click_currPage(1);
    })

    function click_currPage(currPage){
        var selectStatus_Value=document.getElementById("selectStatus").value;
        if (selectStatus_Value=='全部'){
            selectStatus_Value='';
        }
        var currPage=currPage;
        var oIdN="";
        $.ajax({
            type:"post",
            url:"orderController/showTestAjax",
            data:JSON.stringify({"statusN":selectStatus_Value,"currPage":currPage,"oIdN":oIdN}),
            dataType:"json",
            contentType: "application/json; charset=utf-8",
            success:function (data){
                var str="";
                for (var i=0;i<data.list.length;i++){
                    var oId_str="/orderController/showOrderDetail?oId="+data.list[i].oId;
                    str+="<tr>"+
                        "<td>"+data.list[i].oId+"</td>"+
                        "<td>"+data.list[i].totalPrice+"</td>"+
                        "<td>"+data.list[i].remarks+"</td>"+
                        "<td>"+data.list[i].status+"</td>"+
                        "<td>"+data.list[i].oDate+"</td>"+
                        /*"<td>"+"<fmt:formatDate value="+data.list[i].oDate+"/>"+"</td>"+*/
                        "<td>"+data.list[i].users.uName+"</td>"+
                        "<td>"+data.list[i].address.cnee+"</td>"+
                        "<td>"+data.list[i].address.address+"</td>"+
                        "<td>"+data.list[i].address.phone+"</td>"+
                        "<td>"+"<input type=\"button\" value=\"订单详情\" onclick=orderdetail(\""+data.list[i].oId+"\");>"+"</td>"
                        +"</tr>"
                }
                $("#tr_append").nextAll().remove();
                $("#tbstr").append(str);

                $("#div_currpage>div").remove();
                var div_currpage_zi=document.createElement("div");
                var div_count=document.createElement("div");
                var str_currpage="";
                var str_count="数据总条数"+data.totalCount+"&nbsp;&nbsp;&nbsp"+"第"+data.currPage+"/"+data.totalPage+"页";
                if(currPage!=1){
                    str_currpage+="<input type=\"button\" value=\"第一页\" onclick=\"demo(1)\"/>"+
                        "<input type=\"button\" value=\"上一页\" onclick=\"demo("+(parseInt(data.currPage)-parseInt('1'))+")\" />";
                }
                if(currPage!=data.totalPage){
                    str_currpage+="<input type=\"button\" value=\"下一页\" onclick=\"demo("+(parseInt(data.currPage)+parseInt('1'))+");\"/>"+
                        "<input type=\"button\" value=\"尾页\" onclick=\"demo("+data.totalPage+");\"/>";
                }
                document.getElementById("div_currpage").appendChild(div_currpage_zi);
                document.getElementById("div_currpage").appendChild(div_count);
                $("#div_currpage>div:first").html(str_currpage);
                $("#div_currpage>div:last").html(str_count);
            },
            error:function (){
                alert("错误!");
            }
        })
    }

    demo=function (currPage){
        click_currPage(currPage);
    }

    orderdetail=function (oId){
       location.href="http://localhost:8080/ssmTemplte01/orderController/showOrderDetail?oId="+oId;
       /*$.ajax({
           type: "post",
           url:"orderController/showTestAjaxStr",
           data:{"oId":oId},
           dataType: "json",
           success:function (data){
               alert(data.length);
               for (var i=0;i<data.length;i++){

               }
           }
       })*/
    }
    click_currPage(1);
})
