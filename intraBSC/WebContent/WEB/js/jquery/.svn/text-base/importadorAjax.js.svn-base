
	$(function(){			
		$('#dialog').dialog({
			autoOpen: false,
			width: 550,
			resizable:false,
			title:'Importar',
			height:170,
			buttons: {
				"Executar Importacao": function() {
					ajaxFileUpload();
					/*var form = document.getElementById("formImportarXml");
					form.submit();
					*/
					$(this).dialog("close"); 
				}, 
				"Cancelar": function() { 
					$(this).dialog("close"); 
				} 
			}
		});
		
		// Dialog Link
		$('#dialog_link').click(function(){
			$('#dialog').dialog('open');
			return false;
		});

		$('#loading').dialog({
			autoOpen: false,
			width: 70,
			resizable:false,
			title:'Aguardar',
			modal:true,
			height:80
		});
		
	});
	
	function ajaxFileUpload() {
		$("#loading_p").ajaxStart(function(){
			$('#loading').dialog('open');
			return false;
		})
		.ajaxComplete(function(){
			$('#loading').dialog('close');
		});
		$.ajaxFileUpload({
			url:'/intraBSC/mapaEstrategico/importar.do?op=importarXml', 
			secureuri:false,
			fileElementId:'fileImportar',
			dataType: 'json',
			beforeSend:function() {
				//document.getElementById("loading")
				$('#loading').dialog('open');
				return false;
			},
			complete:function(){
				$('#loading').dialog('close');
				document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
				$('#loading').dialog('open');
			},
			success: function (data, status){
				if(typeof(data.error) != 'undefined'){
					if(data.error != '') {
						document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
						$('#loading').dialog('open');
					} else {
						document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
					}
				}
			},
			error: function (data, status, e){
				document.getElementById("loading").innerHTML = "Importação realizada com sucesso";
			}
		});
		return false;
	}  