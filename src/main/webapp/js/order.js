
$(function (){
    $("#selectStatus").change(function (){
        var selectStatus_Value=$(this).val();
        $.ajax({
            type:"post",
            url:"showAllOrderAjax?statusN="+selectStatus_Value,
            success:function (){
                alert();
            }
        })
    })
})