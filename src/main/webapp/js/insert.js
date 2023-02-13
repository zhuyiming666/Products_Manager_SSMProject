



    function test(src) {
        var index = src.lastIndexOf("\\");
        src = src.substring(index + 1, src.length);
        var img1=document.getElementById("img1");
        var bigImg = document.createElement("img");
        bigImg.src="image_ssm/"+src;
        bigImg.style.width='50px';
        bigImg.style.height='50px';
        img1.appendChild(bigImg);
    }

