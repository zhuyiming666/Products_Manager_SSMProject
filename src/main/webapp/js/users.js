orderByLevel = function (orderbyId) {

    var uStatus_index = document.getElementById("uStatus_index").value;
    var uName_str = document.getElementById("uName_str").value;
    location.href = "http://localhost:8080/ssmTemplte01/users/getUsersAll?orderbyId=" + orderbyId + "&uName=" + uName_str + "&uStatus=" + uStatus_index;
    return;
}


