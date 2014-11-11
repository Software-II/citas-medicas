var idServicioSelected = "";
var idMedicoSelected = "";
var responseService;
var responseMedico;
var n;


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
	
	if($("#servicio-a-buscar").val()==""){
		alert("Ingrese un caracter");
		return false;
	}
	
	var dataServicio = {
			"letra"   : $("#servicio-a-buscar").val(),
			"key":0
		};
	$.ajax({
         url:   'ServletServicio',
         type:  'GET',
         dataType: "json",
         data: dataServicio,
         success:  function (response) {
        	 responseService = response;
    		 console.log(responseService);
        	 $( ".item-b" ).remove();
        	 var html="";
        	 $.each(response, function(i, item) {
        		 html+='<div class="item-b"><div onclick="getServicio('+i+')"class="botonMenu">'+response[i].nomServ+'</div></div>';
        	 });
        	 $("#lista-servicios").append(html);
        },
		error: function(response){
			console.log("damm");
		}	});
}

function getServicio(i){ 
	closeBuscarServicio ();
	idServicioSelected=responseService[i].idServicio;  
	$("#servicio").append(responseService[i].nomServ);
	$("#costo-servicio").append(responseService[i].cost);
}

function buscarMedico(){
	
	if($("#medico-a-buscar").val()==""){
		alert("Ingrese un caracter");
		return false;
	}
	
	var dataMedico = {
			"nombre"   : $("#medico-a-buscar").val(),
			"codServ"  : idServicioSelected,
			"key":0
		};
	
	$.ajax({
         url:   'ServletMedico',
         type:  'GET',
         dataType: "json",
         data: dataMedico,
         success:  function (response) {
        	 responseMedico = response;
    		 console.log(response);
        	 $( ".card-medico" ).remove();
        	 var html="";
        	 $.each(response, function(i, item) {
        		 
        		 html='<div class="card-medico" ">';
        		 html+='<div class="dato-medico">Doctor: <strong>'+response[i].nombre+'</strong></div>';
        		 html+='<div class="dato-medico">Horario de Atenci&oacute;: <strong>'+response[i].horario+'</strong></div>';
        		 html+='<div class="dato-medico">Cap de Atenci&oacute;: <strong>'+response[i].cap+'</strong></div>';
        		 html+='<div style="background: rgba(120, 49, 49, 1); color: #fff; border-radius: 10px; padding: 5px; cursor: pointer;" onclick="getMedico('+i+')">Selecciona M&eacute;dico</div>';
        		 html+='</div>';
        		 
        		 
        		 var d = new Date();
        		  n= (d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDay()+9);
        		 
        		 $("#fecha-cita").text(n);
        		 $("#hora-cita").text(d.getHours()+":"+d.getMinutes());
        		 
        		 
        	 });
        	 $("#lista-medicos").append(html);
        },
		error: function(response){
			console.log("damm");
		}
	
	});
}

function getMedico(i){
	closeBuscarMedico();
	idMedicoSelected=responseMedico[i].idMed;
	$("#medico").append(responseMedico[i].nombre+" "+responseMedico[i].apePat+" "+responseMedico[i].apeMat );
}

function salir(tipo,dni){
	
	window.open("validarDatos?tipo="+tipo+"&dni="+dni+"","_self");
}


function generarCitaMedica(){
	

	var dataMedico = {
			"idMed"   :idMedicoSelected,
			"idServ"  : idServicioSelected,
			"idPac"  : $("#idpac").text(),
			"fecha"  : n,
			"key":0
		};
	$.ajax({
         url:   'ServletCM',
         type:  'GET',
         dataType: "json",
         data: dataMedico,
         success:  function (response) {
        	 if(response[0].resssult==1){
        		 alert("La cita Medica se genero con éxito"); 
        		 window.open("http://localhost:8080/CitasMedicasSanSebastian/MenuPpalP.jsp","_self");
        		 
        	 }else{
        		 alert("No se genero la cita");  
        	 }
        	 
         
         },
		error: function(response){
			alert("Erro server");
		}
	
	});
	
}
