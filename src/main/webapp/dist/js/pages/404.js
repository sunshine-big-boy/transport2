var cfg =     {
        type: 'POST', 
        data: JSON.stringify({username:'winzip',password:'password'}), 
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',        
        success: function(result) { 
            alert(result.success); 
        } 
    };

function doTestJson(){
    cfg.url = "user/test";
    $.ajax(cfg);
}

function test1(){
	
	var jsondata = {"id":2,"gender":0,"mobile":"15072370640","password":"123456","accessToken":"fd6bf3dd3cca4b0ca7c9099447994dba"};
	alert(JSON.stringify(jsondata));
	var jsonobj = JSON.parse(jsondata);
	alert(jsonobj);
	
}
