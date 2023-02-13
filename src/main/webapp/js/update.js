

    window.onload=function(){
        var img_src=document.getElementById("img_src");
        var src=img_src.value;
        var img1=document.getElementById("img1");
        var bigImg = document.createElement("img");
        bigImg.src="image_ssm/"+src;
        bigImg.style.width='50px';
        bigImg.style.height='50px';
        bigImg.id="changeid";
        img1.appendChild(bigImg);
    }

    function test(src) {
        var index = src.lastIndexOf("\\");
        src = src.substring(index + 1, src.length);
        var img1=document.getElementById("img1");
        var changeid=document.getElementById("changeid");
        img1.removeChild(changeid);
        var bigImg = document.createElement("img");
        bigImg.id="changeid";
        bigImg.src="image_ssm/"+src;
        bigImg.style.width='50px';
        bigImg.style.height='50px';
        img1.appendChild(bigImg);
    }
    $.ajax({
        type:"post",
        url:"showProductType",
        dataType:"json",
        success:function(proList){
            var str="<option name='type_Id' value='0'>所有类型</option>";
            for (var i=0;i<proList.length;i++){
                var x;
                str+="<option name='type_Id' value="+proList[i].type_Id+">"+proList[i].type_Name+"</option>";
            }
            $("#select_test").html(str);
            var hid=$("#hid").val();
            $("#select_test").find("option[value="+hid+"]").attr("selected",true);
        }
    })

    function subt1(){
        var changeid=document.getElementById("changeid").src;
        var index = changeid.lastIndexOf("/");
        changeid = changeid.substring(index + 1, changeid.length);
        var img_src=document.getElementById("img_src");
        img_src.value=changeid;
        return true;
    }


