//上传图片
function uploadFile() {
	var fileUrl;
	var files = document.getElementById("file");
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
$("#choiseNo").on('click',function(){
	debugger;
	$("#isVaild").val('no');
	$("#isValid").val('no');
	
});
$("#choiseYes").on('click',function(){
	debugger;
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

