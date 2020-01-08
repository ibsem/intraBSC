<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dojo.js"></script>

<script language="JavaScript">
	var txtP = "";
	var numeroP = "";
	var dataP = "";
	var comboP = "";
	
	var formularioEstado = "aberto";
	function abreFechaFormulario(){
		var formulario = document.getElementById('formulario');
		if (formulario != null){
			if ((formularioEstado == "fechado")){
				dojo.lfx.html.wipeOut(formulario, 400).play();
				formularioEstado = "aberto";
			}else{
				dojo.lfx.html.wipeIn(formulario, 400).play();
				formularioEstado = "fechado";
			}
		}
	}
	
	function alterarFormularioCriticoTxt(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (txtP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoFormularioTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+txtP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	function alterarFormularioCriticoNum(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (numeroP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoFormularioTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+numeroP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	function alterarFormularioCriticoData(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		// var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (dataP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoFormularioTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+dataP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	function alterarFormularioCriticoCombo(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		// var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (comboP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoFormularioTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+comboP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	
	function alterarFormularioCriticoBox(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		// var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (boxP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoFormularioTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+boxP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	
	function mudarValorTxt(varP){
		txtP = varP.value;
	}
	function mudarValorNum(varP){
		numeroP = varP.value;
	}
	function mudarValorData(varP){
		dataP = varP.value;
	}
	function mudarValorCombo(varP){
		comboP = varP.value;
	}
	function mudarValorBox(varP){
		if (document.getElementById(varP).checked == true){
  			boxP = "1";
    	}
		else{
    		boxP = "0";
     	}	
	}
</script>
<logic:notEmpty name="formulariosCriticos">
	<table width="514px" border="0">
		<tr align="center" height="16px" class="menuPreto" valign="middle">
			<td align="left" colspan="3" style="vertical-align: middle;" width="90%">
				<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/formulario.gif" border="0" onclick="abreFechaFormulario();">
			<a href="#" style="vertical-align: middle;height:16px;" onclick="abreFechaFormulario();"><bean:message key="pro.label.formulario" /></a></td>
			<td align="right" width="10%">
				<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaFormulario();">
			</td>
		</tr>
	</table>
	<div id="formulario">
		<table width="514px" border="0">
			<tr>
				<td>
					<displaytag:table width="512px" name="formulariosCriticos" id="formularios" requestURI="" scope="session" style="border:none;border-color:black;">
						<c:if test="${formularios.codTipoDadoFormulario==4}">
							<displaytag:column style="width:75%;" >
							<c:if test="${formularios.codTipoDadoFormulario!=5}">
								<c:out value="${formularios.nomeFormulario}"/>
							</c:if>
							</displaytag:column>
						</c:if>
						<c:if test="${formularios.codTipoDadoFormulario<4}">
							<displaytag:column style="width:35%;" >
							<c:if test="${formularios.codTipoDadoFormulario!=5}">
								<c:out value="${formularios.nomeFormulario}"/>
							</c:if>
							</displaytag:column>
						</c:if>
						<displaytag:column style="width:5%;" >
							<c:if test="${formularios.codTipoDadoFormulario==1}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Formulario" onclick="alterarFormularioCriticoTxt(<c:out value="${formularios.numeroOrdem}"/>);">
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario==2}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Formulario" onclick="alterarFormularioCriticoNum(<c:out value="${formularios.numeroOrdem}"/>);">
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario==3}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Formulario" onclick="alterarFormularioCriticoData(<c:out value="${formularios.numeroOrdem}"/>);">
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario==4}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Formulario" onclick="alterarFormularioCriticoCombo(<c:out value="${formularios.numeroOrdem}"/>);">
							</c:if>
							<!-- 
							<c:if test="${formularios.codTipoDadoFormulario==5}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Formulario" onclick="alterarFormularioCriticoBox(<c:out value="${formularios.numeroOrdem}"/>);">
							</c:if>
							 -->
						</displaytag:column>
						
						<displaytag:column style="width:60%;" >
							<c:if test="${formularios.codTipoDadoFormulario==1}">
							<html:textarea name="formularios" property="textoFormularioTarefa" cols="62" rows="3" onblur="mudarValorTxt(this);">
								<c:out value="${formularios.textoFormularioTarefa}"/>
							</html:textarea>
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario==2}">
								<input type="text" maxlength="60" style="width:100%" name="textoFormulario" value="<c:out value="${formularios.textoFormularioTarefa}"/>" onblur="mudarValorNum(this);"/>
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario==3}">
								<input type="text" maxlength="10" style="width:35%" name="textoFormulario" value="<c:out value="${formularios.textoFormularioTarefa}"/>"  onkeydown="AutoFormataData(this)" onblur="validarData(this,'Data'),mudarValorData(this);"/>
							</c:if>
						<!-- 
							<c:if test="${formularios.codTipoDadoFormulario==5}">
								<c:if test="${formularios.textoFormularioTarefa == '1'}">
									<input id="<c:out value="${formularios.numeroOrdem}"/>" type="checkbox" style="width:5%" name="textoFormulario" value="<c:out value="${formularios.textoFormularioTarefa}"/>" CHECKED onclick="mudarValorBox(id);" />
								</c:if>
								<c:if test="${formularios.textoFormularioTarefa != '1'}">
									<input id="<c:out value="${formularios.numeroOrdem}"/>" type="checkbox" style="width:5%" name="textoFormulario" value="<c:out value="${formularios.textoFormularioTarefa}"/>" onclick="mudarValorBox(id);" />
								</c:if>
							</c:if>
						 -->
							<c:if test="${formularios.codTipoDadoFormulario==4}">
								<select name="textoFormularioTarefa" style="width:100px" onblur="mudarValorCombo(this);">
									<option value=""></option>
									<c:forEach var="lista" items="${formularios.listaOpcaoTipoFormulario}">
										<c:if test="${lista.codigo == formularios.textoFormularioTarefa}">
											<option selected value="<c:out value='${lista.codigo}'/>"><c:out value="${lista.texto}"/></option>
										</c:if>
										<c:if test="${lista.codigo != formularios.textoFormularioTarefa}">
											<option value="<c:out value='${lista.codigo}'/>"><c:out value="${lista.texto}"/></option>
										</c:if>
									</c:forEach>
								</select>
							</c:if>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>
		<table width="514px" border="0">
			<tr>
				<td>
					<displaytag:table width="512px" name="formulariosCriticos" id="formularios" requestURI="" scope="session" style="border:none;border-color:black;">
						<displaytag:column style="width:85%;" >
							<c:if test="${formularios.codTipoDadoFormulario==5}">
								<c:out value="${formularios.nomeFormulario}"/>
							</c:if>
						</displaytag:column>
						<displaytag:column style="width:10%;" >
							<c:if test="${formularios.codTipoDadoFormulario==5}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Formulario" onclick="alterarFormularioCriticoBox(<c:out value="${formularios.numeroOrdem}"/>);">
							</c:if>
						</displaytag:column>
						<displaytag:column style="width:5%;" >
							<c:if test="${formularios.codTipoDadoFormulario==5}">
								<c:if test="${formularios.textoFormularioTarefa == '1'}">
									<input id="<c:out value="${formularios.numeroOrdem}"/>" type="checkbox"  name="textoFormulario" value="<c:out value="${formularios.textoFormularioTarefa}"/>" CHECKED onclick="mudarValorBox(id);" />
								</c:if>
								<c:if test="${formularios.textoFormularioTarefa != '1'}">
									<input id="<c:out value="${formularios.numeroOrdem}"/>" type="checkbox"  name="textoFormulario" value="<c:out value="${formularios.textoFormularioTarefa}"/>" onclick="mudarValorBox(id);" />
								</c:if>
							</c:if>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>
	</div>			
</logic:notEmpty>	
							
