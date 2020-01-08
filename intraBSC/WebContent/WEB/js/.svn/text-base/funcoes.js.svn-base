function abrirPopup(URL) {
	var width = 500;
	var height = 300;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(500/2); 
    posy = (screen.height/2)-(300/2); 

	window.open(URL,'Aguarde', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}


function abrirPopupPesquisa(URL) {
	var width = 467;
	var height = 330;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'Aguarde', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function formata(src, mask){
	var i = src.value.length;
	var saida = '#';
	var texto = mask.substring(i)
	if (texto.substring(0,1) != saida){
		src.value += texto.substring(0,1);
	}
}

function chamaLink(url){
	document.getElementById("moldura").src=url;
}

function passValue(formulario, campo, id, msg){			
	valor = document.forms[formulario].elements[campo].value;
	if (valor != ""){
		document.getElementById(id).innerText=valor;
		mostraOculta('pesqNum', true);
		return true;
	}else{
		alert(msg);
		return false;
	}
}

function enviaDados(formulario, url) {
	document.forms[formulario].action=url;
	document.forms[formulario].submit();
}

// abrir janela popup 

function abrir(URL, S, W, H) {
	// URL --> setar o caminho do popup
	// W = width --> setar a largura do popup
	// H = height --> setar a altura do popup
	// S = Scrollbars --> op??es auto, yes, no
	var URL, W, H, S;
	if (document.all)
	var xMax = screen.width, yMax = screen.height;
		else
	if (document.layers)
		var xMax = window.outerWidth, yMax = window.outerHeight;
		else
	var xMax = 640, yMax = 480;
	var xOffset = (xMax - 200)/3, yOffset = (yMax - 200)/3;
	window.open(URL, 'windowbis', 'scrollbars=' + S + ',width=' + W + ',height='+ H +',screenX='+xOffset+',screenY='+yOffset+',top='+yOffset+',left='+xOffset+'');
}

function moverSelecionados(select1, select2){
	var index = select1.selectedIndex;
	if(index >= 0){
		var loop = select1.length;
		for(var i=0; i<loop; i++){
			moverUmElemento(select1, select2, index);
			index = select1.selectedIndex;
			if(index < 0) break;
		}
	}else
		alert("Selecione um registro.");
}

function mover(select1, select2){
	var index = select1.selectedIndex;
	if(index >= 0){
		moverUmElemento(select1, select2, index);
	}else
		alert("Selecione um registro.");
}

function moverUmElemento(select1, select2, index){
	var valor = select1.options[index].value;
	var descricao = select1.options[index].text;
	select2.options[select2.length] = new Option(descricao, valor, false, false);
	select1.options[index] = null;
}

var mostra = false;

function mostraOculta(id, condicao){
	if (id != null && id != ""){
		if (condicao != null){
			if(condicao){
				mostra = true;
			}else{
				mostra = false;
			}
		}else{
			if(mostra){
				mostra = false;
			}else{
				mostra = true;
			}
		}
		document.getElementById(id).style.display = mostra ? '' : 'none';
	}
}

function validaCampo(formulario, campo, url, msg) {
	if (document.forms[formulario].elements[campo].value != ""){
		document.forms[formulario].action=url;
		return true;
	}else{
		alert(msg);
		return false;
	}
}

function opcoes(formulario, campo, id) {
	if (document.forms[formulario].elements[campo][0].checked){
		mostraOculta(id, true);
	}else{
		mostraOculta(id, false);
	}
}

function carregaDados(formulario, campo, id) {
	var valor = document.forms[formulario].elements[campo].value;
	if (valor != ""){
		opener.document.getElementById(id).style.display='';
		opener.document.forms["aceiteGerencia"].elements["txt"].value=valor; // abre as informacoes digitadas na outra p?gina
		window.close();
		return true;
	}else{
		alert('Favor digitar uma descri??o!');
		return false;
	}
}

function mostraOcultaObjeto(){
	var args = new Array();
	args = mostraOcultaObjeto.arguments;
	if (args.length > 2){
		for (i = 0;  i < args.length; i++) {
			if (((i+1) % 2) == 0)
				if (eval(args[i]))
					document.getElementById(args[i -1]).style.display = '';
				else
					document.getElementById(args[i -1]).style.display = 'none';
		}
	}else {
		if (eval(args[1]))
			document.getElementById(args[0]).style.display = '';
		else
			document.getElementById(args[0]).style.display = 'none';
	}
}

function mostraOpcao(formulario, campo){
	var valor = document.forms[formulario].elements[campo].value;
	if (valor == 1)
		mostraOcultaObjeto('status', 'false', 'numero', 'false', 'dataInicial', 'false', 'gerencia', 'false');
	if (valor == 2)
		mostraOcultaObjeto('status', 'true', 'numero', 'false', 'dataInicial', 'false', 'gerencia', 'false');
	if (valor == 3)
		mostraOcultaObjeto('status', 'false', 'numero', 'true', 'dataInicial', 'false', 'gerencia', 'false');
	if (valor == 4)
		mostraOcultaObjeto('status', 'false', 'numero', 'false', 'dataInicial', 'true', 'gerencia', 'false');
	if (valor == 5)
		mostraOcultaObjeto('status', 'false', 'numero', 'false', 'dataInicial', 'false', 'gerencia', 'true');
}		

function enviaValor(formulario, campo, id, msg){			
	valor = document.forms[formulario].elements[campo].value;
	if (valor != ""){
		document.getElementById(id).innerText=valor;
		mostraOculta('pesqNum', true);
		return true;
	}else{
		alert(msg);
		return false;
	}
}

/**
 * Limpa todos os campos editaveis do formulario
 *
 * PARAMETRO: numForm --> numero do formulario que deve ser apagado.
 */
function limparFormulario(numForm){
	var elemento;
	var elementoFocus = null;
	var indiceFocus = 0;
	var numElementos = document.forms[numForm].elements.length;	
	for(var i=0 ; i<numElementos ; i++){
		elemento = document.forms[numForm].elements[i];
		if((elemento.type == "text") || (elemento.type == "textarea") || (elemento.type == "password")){
			elemento.value="";
			indiceFocus++;
		} else if (elemento.type == "select-one"){
			elemento.options.selectedIndex="";
			indiceFocus++;
		} else if((elemento.type == "checkbox")||(elemento.type == "radio")){
			elemento.checked = false;
			indiceFocus++;
		}
		if((indiceFocus == 1) && (elementoFocus == null)) elementoFocus=elemento;
	}
	elementoFocus.focus();
}

function popup(url,target,largura,altura,scrollbars) {
	esquerda = (screen.width - largura)/2;
	topo = (screen.height - altura)/2;
	if (topo > 0 ) {
		topo = topo - 3;
	}
	param = "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=" + scrollbars + ",resizable=no,width=" + largura + ",height=" + altura + ",top=" + topo + ",left=" + esquerda;
	window.open(url,target,param);
}

  var TECLA_PONTO = 46;
  var TECLA_VIRGULA = 44;
  var TECLA_TRACO_SINAL_MENOS = 45;
  var TECLA_ESPACO = 32;
  var TECLA_ABRE_PARENTESES = 40;
  var TECLA_FECHA_PARENTESES = 41;
  var TECLA_BARRA = 47;

  /*
   *  Funcoes auxiliares
   */
    function getDataHora(campoData,campoHora) {
        var dia = getDia(campoData);
        var mes = getMes(campoData);
        var ano = getAno(campoData);
        var hora = getHora(campoHora);
        var minuto = getMinuto(campoHora);
        return new Date(ano,mes,dia,hora,minuto,0,0);
    }

    function getData(campoData) {
        var dia = getDia(campoData);
        var mes = getMes(campoData);
        var ano = getAno(campoData);
        return new Date(ano,mes,dia,0,0,0,0);
    }
    
    
    function getDia(campoData) {
        var dia = new Number(campoData.substring(0,2));
        return dia;
    }

    function getMes(campoData) {
        var mes = new Number(campoData.substring(3,5)) - 1;
        return mes;
    }

    function getAno(campoData) {
        var ano = new Number(campoData.substring(6,10));
        return ano;
    }

    function getHora(campoHora) {
        var posDoisPontos = campoHora.indexOf(":");
        var hora = campoHora.substring(0,posDoisPontos);
        return hora;
    }

    function getMinuto(campoHora) {
        var posDoisPontos = campoHora.indexOf(":");
        var minuto = campoHora.substring(posDoisPontos+1,campoHora.length);
        return minuto;
    }
function formataHora(strCampo,event) {
    var vr;
    var tam;
    var TamanhoMaximo = 6;
    var tecla = getTecla(event);
	
	restringeCampoHora(event);
	
	vr = strCampo.value;
    vr = vr.replace("/", "");
    vr = vr.replace("/", "");
    vr = vr.replace(":", "");
    tam = vr.length;

    var dia;
    var mes;
    var ano;

    if (tam < TamanhoMaximo && tecla != 8) {
      tam = vr.length + 1;
    }

    if (tecla == 8) {
      tam = tam - 1;
    }

    if (tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105) {
      if (tam <= 2) {
         strCampo.value = vr;
      } else if ((tam > 2) && (tam <= 4)) {
         dia = vr.substr(0,2);
         mes =  vr.substr(2,2);
         strCampo.value = dia + ':' + mes;
      } else {
         dia = vr.substr(0,2);
         mes =  vr.substr(2,2);
         ano = vr.substr(5,1);
         strCampo.value = dia + ':' + mes + ':' + ano;
      }
    }
  }
  
  

//M?todo  para formatar a data
  function formataData(strCampo,event) {
  	
    var vr;
    var tam;
    var TamanhoMaximo = 8;
    var tecla = getTecla(event);

	restringeCampoNumerico(event);
	
	if (((tecla >= 37) && (tecla <= 40)) || (tecla == 9)) {
		return;
	}

    vr = strCampo.value;
    vr = vr.replace("/", "");
    vr = vr.replace("/", "");
    vr = vr.replace(":", "");
    tam = vr.length;

    var dia;
    var mes;
    var ano;

    if (tam < TamanhoMaximo && tecla != 8) {
      tam = vr.length + 1;
    }

    if (tecla == 8) {
      tam = tam - 1;
    }

    if (tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105) {
      if (tam <= 2) {
         strCampo.value = vr;
      } else if ((tam > 2) && (tam <= 4)) {
         dia = vr.substr(0,2);
         mes =  vr.substr(2,2);
         strCampo.value = dia + '/' + mes;
      } else {
         dia = vr.substr(0,2);
         mes =  vr.substr(2,2);
         ano = vr.substr(4,3);
         strCampo.value = dia + '/' + mes + '/' + ano;
      }
    }
  }
  
  
  // Somente numeros
function restringeCampoNumerico(event) {
	var tecla = getTecla(event);

    if ((tecla > 46) && (tecla < 58)) { // numeros de 0 a 9
        return true;
	} else {
        if (tecla != 8) { // backspace
            event.keyCode = 0;
		} else {
            return true;
		}
	}
}

function restringeCampoHora(event) {
	var tecla = getTecla(event);

    if ((tecla > 47) && (tecla < 59)) { // numeros de 0 a 9 e :
        return true;
	} else {
        if (tecla != 8) { // backspace
            stopEvent(event);
		} else {
            return true;
		}
	}
}

function soNumero(event) {
    var tecla = getTecla(event);
    if ((tecla >= 48 && tecla <= 57) || tecla == 13) { // numeros de 0 a 9
        return true;
	} else {
        if (tecla != 8) { // backspace
            event.keyCode = 0;
		} else {
            return true;
		}
	}
}  
  
function restringeCampoNumericoInteiro(event) {
	var tecla = getTecla(event);

    if ((tecla > 46 && tecla < 58) || (tecla == TECLA_PONTO)) { // numeros de 0 a 9 e .
        return true;
	} else {
        if (tecla != 8) { // backspace
            event.keyCode = 0;
		} else {
            return true;
		}
	}
}


function trocaCaracter(sString, caracter, por){
	if (sString == "")
	  return "";
	while (sString.indexOf(caracter) > -1){
		sString = sString.replace(caracter, por);
	}
	return sString;
}

function getTecla(event) {
	var tecla = null;
	if (document.all) {
		tecla = event.keyCode; //  IE4+ code
	} else if (document.layers) {
		tecla = event.which; //  NS4+ code
	} else if (document.getElementById) {
		tecla = event.which; // NS6+ code
	}
	return tecla;
}

function getValorTecla(event){
	var teclaASCII = (document.all)? event.keyCode : event.which ;
	return String.fromCharCode(teclaASCII);
}

stopEvent = function(ev) {
	ev || (ev = window.event);
	if (document.all) {
		ev.cancelBubble = true;
		ev.returnValue = false;
	} else {
		ev.preventDefault();
		ev.stopPropagation();
	}
	return false;
};

getElement = function(ev) {
	if (document.all) {
		return window.event.srcElement;
	} else {
		return ev.currentTarget;
	}
};

getTargetElement = function(ev) {
	if (document.all) {
		return window.event.srcElement;
	} else {
		return ev.target;
	}
};

function desabilitarCampos(numForm, naoDesabilitar){
	// verifica se o parametro ? nulo, se for ele ? inicializado.
	naoDesabilitar || (naoDesabilitar = {});

	var elemento;
	var numElementos = document.forms[numForm].elements.length;
	for(var i=0; i<numElementos ; i++){
		elemento = document.forms[numForm].elements[i];
		if ((typeof naoDesabilitar[elemento.name] != "boolean") || (!naoDesabilitar[elemento.name])){
			elemento.disabled = true;
		}
	}
}

function obterValorRadio(campo) {
	var resultado;
	for (i = 0; i < campo.length; i++){
		if (campo[i].checked) {
			resultado = campo[i].value;
		}
	}
	return resultado;
}

function seguir(e){	
	var x = (document.layers) ? e.pageX : document.body.scrollLeft+event.clientX
	var y = (document.layers) ? e.pageY : document.body.scrollTop+event.clientY
	if (document.all) {
		var camada = eval("span.style")
		camada.posLeft=(x+20)
		camada.posTop=y
	} else if (document.layers) {
		var camada = eval("document.span")
		camada.left=(x+1)
		camada.top=y
	}
}
function mensagem(nome){
	var corpo = document.getElementsByTagName("BODY")[0];
	var div = document.createElement("SPAN");
	div.id = nome;
	div.className = "aguardando";
	div.innerText = "Aguarde por favor";
	corpo.appendChild(div);
}
function aguardar(form,desabilitar){
	if(desabilitar){
		desabilitarCampos(form);
	}
	//document.body.style.cursor = "wait";
	mensagem("span");
	if (document.layers){
		document.captureEvents(Event.MOUSEMOVE);
	}
	document.onmousemove = seguir;
}

function validarData(dateStr, label) {
	if (dateStr.value != ""){
		var msg = validaData(dateStr.value, label);
		if(msg != null){
			alert(msg);
			dateStr.focus();
			dateStr.value = "";
			return false;
		}
		return true;
	}
} 

//M?todo para validar a data
function validaData(dateStr, label) { 

	// var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{2}|\d{4})$/; 

	//To require a 4 digit year entry, use this line instead: 
	var datePat = /^(\d{1,2})(\/)(\d{1,2})\2(\d{4})$/; 

	var matchArray = dateStr.match(datePat); 
	if (matchArray == null) { 
		return ""+label + " inv?lida!\n";
	} 
	// parse date into variables 
	day = matchArray[1]; 
	month = matchArray[3];
	year = matchArray[4]; 
	if (month < 1 || month > 12) { // check month range 
		return "O mes da "+label +"  deve estar entre 1 e 12!\n"; 
	} 
	if (day < 1 || day > 31) {
		return "O dia da  " +label+"  deve estar entre 1 e 31!\n"; 
	} 
	if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		return "O mes " + month + " n?o tem 31 dias!\n"; 
	} 
	if (month == 2) { // check for february 29th 
		var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)); 
		if (day>29 || (day==29 && !isleap)) { 
			return "Fevereiro de " + year + " n?o tem " + day + " dias!\n"; 
		} 
	} 
	return null; 
} 

function validarHora(dateStr) {
	var msg = validaHora(dateStr.value);
	if(msg != null){
		alert(msg);
		dateStr.focus();
		return false;
	}
	return true;
} 

//M?todo para validar a hora 
function validaHora(horaStr) { 

	var hh = horaStr.substring(0, 2);
	var mm = horaStr.substring(3, 5);
	var ss = horaStr.substring(6, 8);
	
	if (horaStr.length < 8) {
		return "Informe a hora no formato HH:MM:SS.";
	}
	if (hh < 0 || hh > 23) { 
		return "A HORA deve estar entre 0 e 23!\n"; 
	} 
	if (mm < 0 || mm> 59) {
		return "Os MINUTOS devem estar entre 0 e 59!\n"; 
	}
	if (ss < 0 || ss > 59) {
		return "Os SEGUNDOS devem estar entre 0 e 59!\n"; 
	} 
	return null; // date is valid 
} 

//M?todo para validar se uma data e menor q outra
function compararDatas(dataInicial, dataFinal) {
	if ( (Date.parse(dataInicial)) >= (Date.parse(dataFinal)) ) {
		return true;
	} else {
		return false;
	}
}

//M?todo para validar o tamanho de um campo
function minMax(campo, min, max) {
	if (campo.length < min || campo.length > max) {
		return false;
	} else {
		return true;
	}
}

String.prototype.substituir = function(novo, antigo){
	var retorno = this.toString(); 
	while(retorno.indexOf(novo) > -1){
		retorno = retorno.replace(novo,antigo);
	}
	return retorno.toString();
}

String.prototype.trim = function(){
	var str = this.toString();
	while (str.charAt(0) == " ")
		str = str.substr(1);
	
	while (str.charAt(str.length-1) == " ")
		str = str.substr(0,str.length-1);
	
	return str;
}

//compara duas datas (data fim n?o pode ser menor que a data inicial)
function datamaiorigual(dt1,dt2){
	var hoje = new Date();
	var ano = hoje.getYear();
	if(ano >= 50 && ano <= 99)
		ano = 1900 + ano
	else
		ano = 2000 + ano;
			
	var pos1 = dt1.indexOf("/",0)
	var dd = dt1.substring(0,pos1)
	pos2 = dt1.indexOf("/", pos1 + 1)
	var mm = dt1.substring(pos1 + 1,pos2)
	var aa = dt1.substring(pos2 + 1,10)
	if(aa.length < 4)
		if(ano > 1999)
			aa = (2000 + parseInt(aa,10))
		else
			aa = (1900 + parseInt(aa,10));
	var data1 = new Date(parseInt(aa,10),parseInt(mm,10) - 1, parseInt(dd,10));
	var pos1 = dt2.indexOf("/",0)
	var dd = dt2.substring(0,pos1)
	pos2 = dt2.indexOf("/", pos1 + 1)
	var mm = dt2.substring(pos1 + 1,pos2)
	var aa = dt2.substring(pos2 + 1,10)
	if(aa.length < 4)
	if(ano > 80 && ano <= 99)
		aa = (1900 + parseInt(aa,10))
	else
		aa = (2000 + parseInt(aa,10));
	var data2 = new Date(parseInt(aa,10),parseInt(mm,10) - 1,parseInt(dd,10));
			
	if(data1 >= data2)
		return true; 
	else
		return false;
} 
	 	
	 	
// compara duas datas, formata e retorna um Date
function stringToDate(stringdate) {
  camposDeData = stringdate.split("/");
  if (camposDeData.length == 3) {
    return new Date(camposDeData[2],camposDeData[1]-1,camposDeData[0]);
  }
  else {
    return "A data n?o est? no padr?o dd/MM/yyyy";
  }
}


// Fun??o utlizada contar a quantidade de caracteres restantes a serem digitados em um textarea
function ContarCaracteres(){
   intCaracteres = 1024 - document.tarefaForm.textoSolicitacao.value.length;
   if (document.tarefaForm.textoSolicitacao.value.length > 1024){				   		
   		document.tarefaForm.textoSolicitacao.value = document.tarefaForm.textoSolicitacao.value.substr(0,1024);
   }
   if (intCaracteres > 0) {
      document.tarefaForm.caracteres.value = intCaracteres;
      return true;
   }
   else {
      document.tarefaForm.caracteres.value = 0;
      document.tarefaForm.caracteres.value = document.tarefaForm.caracteres.value.substr(0,1024)
      return false;
   }				   				   
}


// Fun??o utlizada contar a quantidade de caracteres restantes a serem digitados em um textarea
function ContarCaracteresGeral(nomeCampo,caracteres){
	if (nomeCampo != null){	   
	   intCaracteres = 1024 - nomeCampo.value.length;
	   if (nomeCampo.value.length > 1024){	
	   		nomeCampo.value = nomeCampo.value.substr(0,1024);
	   }
	   if (intCaracteres > 0) {
	      caracteres.value = intCaracteres;
	      return true;
	   }
	   else {
	      caracteres.value = 0;
	      caracteres.value = caracteres.value.substr(0,1024)
	      return false;
	   }
	}
}

function AutoFormataData(e){//Usar no evento onKeyDown.
	if (e.value.charAt(0)) {
		if (e.value.charAt(1)) {
			if (e.value.charAt(4)) {
				if (e.value.charAt(5)) return;
				if (e.value.charAt(6)) return;
				if (e.value.charAt(7)) return;
				if (e.value.charAt(8)) return;
				if (e.value.charAt(9)) return;
				e.value = e.value + "/";
			}
			if (e.value.charAt(2)) return;
			if (e.value.charAt(3)) return;
			e.value = e.value + "/";
		}
	}
}		

function validaDiasNegativos(){
	if(document.Form.numDiasPrevistos.value <= 0){
		alert("Campo Dias Previstos n?o pode conter valor menor do que zero.");
		return false;
	}
	else{
		return true;
	}
}
				
	function validarDatasConteudoTarefa(dateStr, label){
		if(dateStr.value != null && dateStr.value  != ""){
			validarData(dateStr , label);
		}else{
			return true;
		}
	}
	
// Fun??o que exibe uma janela popup e imprime o elemento tipo bloco
// Parametros:
//   elementoConteudo - id do elemento presente na janela q sera exibido e impresso no popup
	function ativarPopupImpressao(elementoID) {
		window.open("/imprimir.do?elementoID="+elementoID
					,"popupImpressao"
					,"width=748,height=400,location=no,menubar=no,resizeable=no,scrollbars=yes,alwaysRaised=yes");
	}

	function imprimirConteudo(){		
		var objWin = window.opener;
		var conteudo = document.frmImpressao.elementoID.value;
		var objByID = objWin.document.getElementById(document.frmImpressao.elementoID.value);
		if(objByID != null){
			document.writeln(objByID.innerHTML);
			window.print();
		}else{
			document.writeln('<div class="alerta"><img src="/ad/imagens/exclErro.gif">&nbsp;&nbsp;Este recurso n?o est? dispon?vel para esta p?gina</div>');
		}
	}
				
	function validaChave(chave){
		var retorno = true;
		if (chave.value != ""){
			if (chave.value.toUpperCase().charAt(0) == "F"){
				for(var i=1; i<chave.value.length; i++){
					if ((chave.value.charAt(i) != "0") &&
						(chave.value.charAt(i) != "1") &&
						(chave.value.charAt(i) != "2") &&
						(chave.value.charAt(i) != "3") &&
						(chave.value.charAt(i) != "4") &&
						(chave.value.charAt(i) != "5") &&
						(chave.value.charAt(i) != "6") &&
						(chave.value.charAt(i) != "7") &&
						(chave.value.charAt(i) != "8") &&
						(chave.value.charAt(i) != "9")){
						retorno = false;
						break;
					}
				}
			}else{
				retorno = false;
			}
			if (!retorno){
				alert("Formato da chave est? incorreto."); 
				return false;
			}
		}
		return true;
	}				
				
	function validaAno(ano){
		var retorno = true;
		if (ano.value != ""){
			for(var i=1; i<ano.value.length; i++){
				if ((ano.value.charAt(i) != "0") &&
					(ano.value.charAt(i) != "1") &&
					(ano.value.charAt(i) != "2") &&
					(ano.value.charAt(i) != "3") &&
					(ano.value.charAt(i) != "4") &&
					(ano.value.charAt(i) != "5") &&
					(ano.value.charAt(i) != "6") &&
					(ano.value.charAt(i) != "7") &&
					(ano.value.charAt(i) != "8") &&
					(ano.value.charAt(i) != "9")){
					retorno = false;
					break;
				}
			}
		}
		if (!retorno){
			alert("Ano incorreto."); 
			return false;
		}
		return true;
	}

function abrirPopupSucesso(URL) {
	var width = 500;
	var height = 300;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'Aguarde', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupEtapa(URL) {
	var width = 450;
	var height = 300;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'etapaForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupItem(URL) {
	var width = 450;
	var height = 280;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'itemForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupFormulario(URL) {
	var width = 450;
	var height = 280;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'formularioForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}


function abrirPopupItemAlterar(URL) {
	var width = 450;
	var height = 460;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'itemForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupFormularioAlterar(URL) {
	var width = 450;
	var height = 460;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'formularioForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}



function abrirPopupAnexo(URL) {
	var width = 600;
	var height = 350;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'anexoForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupAnotacao(URL) {
	var width = 400;
	var height = 300;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'anotacaoForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupAnotacaoPesqusiar(URL) {
	var width = 570;
	var height = 400;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'anotacaoFormPesquisar', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupEmail(URL) {
	var width = 600;
	var height = 430;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'anotacaoForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupEtapaTarefa(URL) {
	var width = 470;
	var height = 450;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'anotacaoForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=no, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}

function abrirPopupItemTarefa(URL) {
	var width = 620;
	var height = 450;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(390/2); 
    posy = (screen.height/2)-(490/2); 
	window.open(URL,'anotacaoForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}
function abrirPopupRelatorio(URL) {
	var width = 700;
	var height = 650;

	var left = 200;
	var top = 200;
	
	posx = (screen.width/2)-(350/2); 
    posy = (screen.height/2)-(390/2); 
	window.open(URL,'anotacaoForm', 'width='+width+', height='+height+', top='+posy+', left='+posx+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
}