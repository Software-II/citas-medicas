var idServicioSelected = "";

function openBuscarServicio () {
	$("#ventana-buscar-servicio").animate({top: '10%'});
}
function closeBuscarServicio () {
	$("#ventana-buscar-servicio").animate({top: '-120%'});
}

function openBuscarMedico () {
	if(idServicioSelected!=""){
		$("#ventana-buscar-medico").animate({top: '10%'});
	}else{
		alert("Seleccione un Servicio");
	}
}
function closeBuscarMedico () {
	$("#ventana-buscar-medico").animate({top: '-120%'});
}

function buscarServicio() {
	console.log("got");
	var datanoticias = {
			"letra"   : $("#servicio-a-buscar").val(),
			"key":0
		};
	$.ajax({
         url:   'ServletServicio',
         type:  'GET',
         dataType: "json",
         data: datanoticias,
         success:  function (response) {
        	 
        	 $( ".item" ).remove();
        	 var html="";
        	 $.each(response, function(i, item) {
        		 
        		 var id="'"+response[i].idServicio+"'";
        		 
        		 html+='<div class="item"><div onclick="getServicio('+id+')"class="botonMenu">'+response[i].nomServ+'</div></div>';
        		 
        	 });
        	 $("#lista-servicios").append(html);
        	 
		},
		error: function(response){
			console.log("damm");
		}
	
	});
}