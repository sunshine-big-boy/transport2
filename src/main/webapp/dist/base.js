//将json数据格式转化为json字符串
$.fn.serializeString = function(){
	var o ={};
	var arr = this.serializeArray();
    $.each(arr, function(){ 
        if (o[this.name]) { 
            if (!o[this.name].push) { 
                o[this.name] = [o[this.name]]; 
            } 
            o[this.name].push(this.value || ''); 
        } 
        else { 
            o[this.name] = this.value || ''; 
        } 
    });  
	return JSON.stringify(o);
	
	
	
};