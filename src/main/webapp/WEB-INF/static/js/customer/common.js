$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {// 如果这个name已经存在
			if (!o[this.name].push) {// 这个name还不是数组
				o[this.name] = [ o[this.name] ];// 把这个name嵌套成数组
				// {'weeks':'2'}==>{'weeks':['2']}
			}
			o[this.name].push(this.value || '');// 把值放到数组中
		} else {
			o[this.name] = this.value || '';// 先赋值
			if (this.name == "weeks") {// 第一次出现weeks
				o[this.name] = [ o[this.name] ];// 嵌套成数组
			}
		}
	});
	return o;
};

$.errTips = function(msg){
	this.innerHTML = "<div class=\"errMsg\">" + msg + "</div>";
}

function logincheck() {
	var username = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	if (username == null || username == '' || password == null
			|| password == '') {
		alert("用户名不能为空");
		return false;
	}
	return true;
}