$(document).ready(function() {

	$("#getUser").unbind().click(function(){	
		if($(this).attr("disabled") == null) {
			getUser($(this));
		}
	});
	
	$("#getUserAll").unbind().click(function(){	
		if($(this).attr("disabled") == null) {
			getUserAll($(this));
		}
	});
	
	$("#deleteUser").unbind().click(function(){	
		if($(this).attr("disabled") == null) {
			deleteUser($(this));
		}
	});
	
	$("#deleteAll").unbind().click(function(){	
		if($(this).attr("disabled") == null) {
			deleteAll($(this));
		}	
	});
	
	$("#updateUser").unbind().click(function(){	
		if($(this).attr("disabled") == null) {
			updateUser($(this));
		}	
	});
	
	$("#userForm").submit(function(){			
		createUser($(this).find(":submit"));
		return false;
	});
	
	
	$('#chainForm').submit( function() {
		submitChain();
		return false;
	});
	
});

function getUser(element) {
	
	$.ajax({
		url : contextPath + "api/v1/user/3",
		type : "get",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		beforeSend: function () {
			$(element).prop("disabled", true);		
			$(element).append('<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>');
		},
		success : function(data) {		
			console.log("Se ha obtenido el usuario correctamente");
			console.log(data);
		},
		error : function(data) {
			console.log("Error en el proceso getUser(). Code -> " + data.status);
			console.log(data);
		},
		complete: function() {
			$(element).find('.spinner-grow').remove();
			$(element).prop("disabled", false);
		}
	});
	
}

function getUserAll(element) {
	
	$.ajax({
		url : contextPath + "api/v1/user",
		type : "get",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		beforeSend: function () {
			$(element).prop("disabled", true);		
			$(element).append('<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>');
		},
		success : function(data) {	
			console.log("Se han obtenido todos los usuarios correctamente");
			console.log(data);
		},
		error : function(data) {
			console.log("Error en el proceso getUserAll(). Code -> " + data.status);
			console.log(data);
		},
		complete: function() {
			$(element).find('.spinner-grow').remove();
			$(element).prop("disabled", false);
		}
	});
	
}

function deleteUser(element) {
	
	$.ajax({
		url : contextPath + "api/v1/user/3",
		type : "delete",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		beforeSend: function () {
			$(element).prop("disabled", true);		
			$(element).append('<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>');
		},
		success : function(data) {
			console.log("Se ha eliminado el usuario correctamente");
			console.log(data);
		},
		error : function(data) {
			console.log("Error en el proceso deleteUser(). Code -> " + data.status);
			console.log(data);
		},
		complete: function() {
			$(element).find('.spinner-grow').remove();
			$(element).prop("disabled", false);
		}
	});
	
}

function deleteAll(element) {
	
	$.ajax({
		url : contextPath + "api/v1/user",
		type : "delete",
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		beforeSend: function () {
			$(element).prop("disabled", true);		
			$(element).append('<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>');
		},
		success : function(data) {
			console.log("Se han eliminado todos los usuarios correctamente");
			console.log(data);
		},
		error : function(data) {
			console.log("Error en el proceso deleteAll(). Code -> " + data.status);
			console.log(data);
		},
		complete: function() {
			$(element).find('.spinner-grow').remove();
			$(element).prop("disabled", false);
		}
	});
	
}

function updateUser(element) {
	
	var myObjData = { 
					"id": 3, 
					"email": "anonymous@anonymous.cat", 
					"firstName": "Anonymous",
					"lastName": "Anonymous",
					"birthdate": "28/07/1977" 
				};
	
	$.ajax({
		url : contextPath + "api/v1/user/3",
		type : "put",
		data : JSON.stringify(myObjData),
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		beforeSend : function () {
			$(element).prop("disabled", true);		
			$(element).append('<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>');
		},
		success : function(data) {
			console.log("Se ha eliminado el usuario correctamente");
			console.log(data);
		},
		error : function(data) {
			console.log("Error en el proceso deleteUser(). Code -> " + data.status);
			console.log(data);
		},
		complete: function() {
			$(element).find('.spinner-grow').remove();
			$(element).prop("disabled", false);
		}
	});
	
}

function createUser(element) {
	$.ajax({
		url : contextPath + "api/v1/user",
		type : "post",
		data: $('#userForm').serializeJSON(),
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		beforeSend : function () {
			$(element).prop("disabled", true);		
			$(element).append('<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>');
		},
		success : function(data) {
			console.log("Se ha creado el usuario correctamente");
			console.log(data);
		},
		error : function(data) {
			console.log("Error en el proceso createUser(). Code -> " + data.status);
			console.log(data);
		},
		complete: function() {
			$(element).find('.spinner-grow').remove();
			$(element).prop("disabled", false);
		}
	});
}