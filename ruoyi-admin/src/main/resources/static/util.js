//上传图片
function uploadFile(fileId) {
	return "";
	if(!fileId){
		fileId ="file";
	}
	var fileUrl;
	var files = document.getElementById(fileId);
	var filePath = $("#file").val(), // 获取到input的value，里面是文件的路径
	fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
	if (!/.(gif|jpg|jpeg|png|GIF|JPG|png)$/.test(fileFormat)) {
		$.modal.alertError("圖片必須是.gif,jpeg,jpg,png格式..");
		return false;
	}
	var formData = new FormData();
	formData.append("file", files.files[0]);
	$.ajax({
		type : "POST",
		async:false,
		url : ctx + "common/upload",
		data : formData,
		type : "post",
		processData : false,
		contentType : false,
		success : function(result) {
			if (result.code == web_status.SUCCESS) {
				fileUrl = result.url;
			} else {
				$.modal.alertError(result.msg);

			}
		},
		error : function(error) {
			$.modal.alertWarning("图片上传失败。");

		}
	});
	return fileUrl;
}
function sendFile(file, obj) {
    var data = new FormData();
    data.append("file", file);
    $.ajax({
        type: "POST",
        url: ctx + "common/upload",
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        success: function(result) {
            if (result.code == web_status.SUCCESS) {
            	$(obj).summernote('editor.insertImage', result.url, result.fileName);
			} else {
				$.modal.alertError(result.msg);
			}
        },
        error: function(error) {
            $.modal.alertWarning("圖片上传失败。");
        }
    });
}
$("#choiseNo").on('click',function(){
	
	$("#isVaild").val('no');
	$("#isValid").val('no');
	
});
$("#choiseYes").on('click',function(){
	
	$("#isVaild").val('yes');
	$("#isValid").val('yes');
});
$("#choiseNoSellOut").on('click',function(){
	$("#isSellOut").val('no');
	
});
$("#choiseYesSellOut").on('click',function(){
	$("#isSellOut").val('yes');
});
$("#choiseNoHot").on('click',function(){
	$("#isHot").val('no');
	
});
$("#choiseYesSellOut").on('click',function(){
	$("#isHot").val('yes');
});
function openImg(value){
	layer.open({
		  type: 1,
		  title: false,
		  closeBtn: 0,
		  area: '516px',
		  skin: 'layui-layer-nobg', //没有背景色
		  shadeClose: true,
		  content: "<img  src='"+value+"' />"
		});
	  
}

function openPage(title,url,width,hight){
		if(!width){
			width =1050;
		}
		if(!hight){
			hight =1050;
		}
		$.modal.open(title,url,width,hight);

}

