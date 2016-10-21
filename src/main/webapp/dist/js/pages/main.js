var username ;
function init(){
	username = $.cookie("username",username);
	$("#username").html(username);
	$("p#username").html(username);
}

function fetchAndUpdateTable() {
	var modal_name = $("#modal_name").val();
	var modal_amount = $("#modal_amount").val();
	var modal_weight = $("#modal_weight").val();
	var modal_fee = $("#modal_fee").val();
	var modal_else_fee = $("#modal_else_fee").val();
	var modal_else_price = $("#modal_else_price").val();
	var modal_paytype = $("#modal_paytype").val();
	var modal_fetchtype = $("#modal_fetchtype").val();
	var modal_baojia = $("#modal_baojia").val();
	var modal_daishou = $("#modal_daishou").val();
	var modal_shouxufei = $("#modal_shouxufei").val();
	var data = {
		'name' : modal_name,
		'amount' : modal_amount,
		'weight' : modal_weight,
		'fee' : modal_fee,
		'else_fee' : modal_else_fee,
		'else_price' : modal_else_price,
		'pay_type' : modal_paytype,
		'fetch_type' : modal_fetchtype,
		'baojia' : modal_baojia,
		'shouxufei' : modal_shouxufei,
		'daishou' : modal_daishou
	};
	alert(data);
	$("#myTable").bootstrapTable('append', data);

}

function initTable() {
	// 销毁表格
	$("#myTable").bootstrapTable('destroy');
	// 初始化表格
	$("#myTable").bootstrapTable({
		method : "post",
		url : "",
		striped : true,
		pagination : true,
		pageSize : 5,
		pageNumber : 1,
		pageList : [ 5, 10, 15, 20, 25 ],
		columns : [ [ {
			field : 'id',
			title : 'ID',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		}, {
			field : 'name',
			title : '货物名称',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		}, {
			field : 'amount',
			title : '件数',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		}, {
			field : 'weight',
			title : '重量kg/体积m3',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		}, {
			field : 'fee',
			title : '费用',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		}, {
			field : 'else_fee',
			title : '其他计费',
			align : 'center',
			colspan : 3
		}, {
			field : 'pay_type',
			title : '结算方式',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		}, {
			field : 'fetch_type',
			title : '提货方式',
			align : 'center',
			valign : 'middle',
			rowspan : 2
		} ], [ {
			field : 'baojia',
			title : '保价',
			align : 'center'
		}, {
			field : 'shouxufei',
			title : '手续费',
			align : 'center'
		}, {
			field : 'daishou',
			title : '代收货款',
			align : 'center'
		} ]

		]

	});
}
$(document).ready(function() {
	initTable();
});