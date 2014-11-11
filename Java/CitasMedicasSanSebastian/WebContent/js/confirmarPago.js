var responseCM;

$(function(){
	var dataServicio = {
			"idPac"   : $("#idpac").text(),
			"key":1
		};
	$.ajax({
         url:   'ServletCM',
         type:  'GET',
         dataType: "json",
         data: dataServicio,
         success:  function (response) {
        	 responseCM = response;
        	 $( ".linea-tabla" ).remove();
        	 var html='';
        	 $.each(response, function(i, item) {
        		 
        		 html+='<article class="linea-tabla" id="cita-'+i+'">';
        		 html+='<div class="info-cita">';
        		 html+='<div><strong>Servicio: </strong>'+item.nomServ+'</div>';
        		 html+='<div><strong>M&eacute;dico: </strong>'+item.nomMed+'</div>';
        		 html+='<div><strong>Fecha: </strong>'+item.fecha+'</div>';
        		 html+='<div><strong>Costo: </strong>'+item.costo+'</div>';
        		 html+='</div>';
        		 html+='<div class="opciones-boton">';
        		 html+='<div class="botonMenu"><div class="texto-boton-menu" onclick="confirmarPago('+i+')">Confirmar Pago</div></div>';
        		 html+='</div>';
        		 html+='</article>';
        		 
        		 
        	 });
        	 $("#citas-pendientes").append(html);
        },
		error: function(response){
			console.log("damm");
		}	});
	
});

function confirmarPago(position){
	
	var dataServicio = {
			"idPac"   : $("#idpac").text(),
			"idCita"  : responseCM[position].idCita,
			"saldo"   : $("#saldo").text(),
			"costo"   : responseCM[position].costo,
			"key":2
		};
	$.ajax({
         url:   'ServletCM',
         type:  'GET',
         dataType: "json",
         data: dataServicio,
         success:  function (response) {
        	 $( "#cita-"+position ).remove();
        	 
        	 if(response.result==-1){
        		 alert("saldo insufucuente");
        	 }else if(response.result==0 || response.result==1 ){
        		 alert("ocurrio un error");
        	 }else{
        		 alert("Cita confirmada");
        	 }
        	 
        	 
        },
		error: function(response){
			console.log("damm");
		}	});
	
}





















