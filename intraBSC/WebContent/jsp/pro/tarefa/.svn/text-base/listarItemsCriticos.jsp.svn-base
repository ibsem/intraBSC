<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dojo.js"></script>

<script language="JavaScript">
	var txtP = "";
	var numeroP = "";
	var dataP = "";
	var comboP = "";
	
	var itemEstado = "fechado";
	function abreFechaItem(){
		var item = document.getElementById('item');
		if (item != null){
			if ((itemEstado == "fechado")){
				dojo.lfx.html.wipeOut(item, 400).play();
				itemEstado = "aberto";
			}else{
				dojo.lfx.html.wipeIn(item, 400).play();
				itemEstado = "fechado";
			}
		}
	}
	
	function alterarItemCriticoTxt(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (txtP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoItemTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+txtP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	function alterarItemCriticoNum(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (numeroP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoItemTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+numeroP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	function alterarItemCriticoData(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		// var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (dataP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoItemTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+dataP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	function alterarItemCriticoCombo(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		// var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (comboP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoItemTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+comboP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
			document.tarefaForm.submit();
		}else{
			alert("Digite uma informação.");
		}
	}
	
	function alterarItemCriticoBox(numero){
		var nomeP =document.tarefaForm.nome.value;
		var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
		var codEstadoP =document.tarefaForm.codEstado.value;
		var codCriticidadeP =document.tarefaForm.codCriticidade.value;
		var dtInicioP =document.tarefaForm.dtInicio.value;
		var dtFimP =document.tarefaForm.dtFim.value;
		// var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		if (boxP != ""){
			document.tarefaForm.action = "<c:out value="${base}"/>/conteudoItemTarefa/alterar.do?op=alterar&numOrdem="+numero+"&txtCampo="+boxP+"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP;
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
<logic:notEmpty name="itemsCriticos">
	<table width="514px" border="0">
		<tr align="center" height="16px" class="menuPreto" valign="middle">
			<td align="left" colspan="3" style="vertical-align: middle;" width="90%">
				<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/checklist.gif" border="0" onclick="abreFechaItem();">
			<a href="#" style="vertical-align: middle;height:16px;" onclick="abreFechaItem();"><bean:message key="pro.label.listaafazer" /></a></td>
			<td align="right" width="10%">
				<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaItem();">
			</td>
		</tr>
	</table>
	<div id="item">
		<table width="514px" border="0">
			<tr>
				<td>
					<displaytag:table width="512px" name="itemsCriticos" id="items" requestURI="" scope="session" style="border:none;border-color:black;">
						<displaytag:column style="width:30%;" >
							<c:if test="${items.codTipoDadoItem!=5}">
								<c:out value="${items.nomeItem}"/>
							</c:if>
						</displaytag:column>
						<displaytag:column style="width:10%;" >
							<c:if test="${items.codTipoDadoItem==1}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Item" onclick="alterarItemCriticoTxt(<c:out value="${items.numeroOrdem}"/>);">
							</c:if>
							<c:if test="${items.codTipoDadoItem==2}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Item" onclick="alterarItemCriticoNum(<c:out value="${items.numeroOrdem}"/>);">
							</c:if>
							<c:if test="${items.codTipoDadoItem==3}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Item" onclick="alterarItemCriticoData(<c:out value="${items.numeroOrdem}"/>);">
							</c:if>
							<c:if test="${items.codTipoDadoItem==4}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Item" onclick="alterarItemCriticoCombo(<c:out value="${items.numeroOrdem}"/>);">
							</c:if>
							<!-- 
							<c:if test="${items.codTipoDadoItem==5}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Item" onclick="alterarItemCriticoBox(<c:out value="${items.numeroOrdem}"/>);">
							</c:if>
							 -->
						</displaytag:column>
						
						<displaytag:column style="width:60%;" >
							<c:if test="${items.codTipoDadoItem==1}">
							<html:textarea name="items" property="textoItemTarefa" cols="62" rows="3" onblur="mudarValorTxt(this);">
								<c:out value="${items.textoItemTarefa}"/>
							</html:textarea>
							</c:if>
							<c:if test="${items.codTipoDadoItem==2}">
								<input type="text" maxlength="60" style="width:100%" name="textoItem" value="<c:out value="${items.textoItemTarefa}"/>" onblur="mudarValorNum(this);"/>
							</c:if>
							<c:if test="${items.codTipoDadoItem==3}">
								<input type="text" maxlength="10" style="width:35%" name="textoItem" value="<c:out value="${items.textoItemTarefa}"/>"  onkeydown="AutoFormataData(this)" onblur="validarData(this,'Data'),mudarValorData(this);"/>
							</c:if>
						<!-- 
							<c:if test="${items.codTipoDadoItem==5}">
								<c:if test="${items.textoItemTarefa == '1'}">
									<input id="<c:out value="${items.numeroOrdem}"/>" type="checkbox" style="width:5%" name="textoItem" value="<c:out value="${items.textoItemTarefa}"/>" CHECKED onclick="mudarValorBox(id);" />
								</c:if>
								<c:if test="${items.textoItemTarefa != '1'}">
									<input id="<c:out value="${items.numeroOrdem}"/>" type="checkbox" style="width:5%" name="textoItem" value="<c:out value="${items.textoItemTarefa}"/>" onclick="mudarValorBox(id);" />
								</c:if>
							</c:if>
						 -->
							<c:if test="${items.codTipoDadoItem==4}">
								<select name="textoItemTarefa" style="width:250px" onblur="mudarValorCombo(this);">
									<option value=""></option>
									<c:forEach var="lista" items="${items.listaOpcaoTipoItem}">
										<c:if test="${lista.codigo == items.textoItemTarefa}">
											<option selected value="<c:out value='${lista.codigo}'/>"><c:out value="${lista.texto}"/></option>
										</c:if>
										<c:if test="${lista.codigo != items.textoItemTarefa}">
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
					<displaytag:table width="512px" name="itemsCriticos" id="items" requestURI="" scope="session" style="border:none;border-color:black;">
						<displaytag:column style="width:85%;" >
							<c:if test="${items.codTipoDadoItem==5}">
								<c:out value="${items.nomeItem}"/>
							</c:if>
						</displaytag:column>
						<displaytag:column style="width:10%;" >
							<c:if test="${items.codTipoDadoItem==5}">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" title="Alterar Item" onclick="alterarItemCriticoBox(<c:out value="${items.numeroOrdem}"/>);">
							</c:if>
						</displaytag:column>
						<displaytag:column style="width:5%;" >
							<c:if test="${items.codTipoDadoItem==5}">
								<c:if test="${items.textoItemTarefa == '1'}">
									<input id="<c:out value="${items.numeroOrdem}"/>" type="checkbox"  name="textoItem" value="<c:out value="${items.textoItemTarefa}"/>" CHECKED onclick="mudarValorBox(id);" />
								</c:if>
								<c:if test="${items.textoItemTarefa != '1'}">
									<input id="<c:out value="${items.numeroOrdem}"/>" type="checkbox"  name="textoItem" value="<c:out value="${items.textoItemTarefa}"/>" onclick="mudarValorBox(id);" />
								</c:if>
							</c:if>
						</displaytag:column>
					</displaytag:table>
				</td>
			</tr>
		</table>
	</div>			
</logic:notEmpty>	
							
