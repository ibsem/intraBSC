<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c"%>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
<script language="JavaScript">
		function verificaCamposVazios(){
			var formulario = document.tarefaFormConsulta;
			if ((formulario.codigo.value == "")
	  		   &&(formulario.nome.value == "")
			   &&(formulario.dtPrazoInicioPesq.value == "")
			   &&(formulario.dtPrazoFimPesq.value == "")
			   &&(formulario.codEstado.value == "")
			   &&(formulario.codConfigTarefa.value == "")
			   ){
				alert('Preencha pelo menos um campo para efetuar a pesquisa.');		
				
			}else{
				if (validateTarefaFormConsulta(formulario)){
					document.tarefaFormConsulta.action = "<c:out value="${base}"/>/tarefa/consultar.do?op=consultarVarios";
					document.tarefaFormConsulta.submit();
					}
			}
		}
	
		function setaCheckBox(campo){
			if (campo.checked){
				campo.value = true;
			}else{
				campo.value = false;
			}
		}
	</script>

<html:form action="/tarefa/consultar" onsubmit="return validateTarefaFormConsulta(this);">
	<html:hidden property="op" value="consultarVarios" />
	<html:hidden property="chkBoxValor" value="" />
	<table border="0" width="480px" align="center">
		
				<tr><td colspan="2" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.pesquisartarefas" /></td></tr>
				<tr height="3"><td>&nbsp;</td></tr>
		<tr><td align = "left" width = "20%"><b><bean:message key="pro.label.exibirNoResultado"/></b></td>
			<td><b><bean:message key="pro.label.escolherfiltros" /></b></td>
		</tr>
	</table>
	<table border="0" width="450px">
		<!-- ********************************************************Numero Tarefa e prazo************************************************************ -->
		<tr>
			<td align = "center" width = "15%">&nbsp;</td>
			<td ><bean:message key="pro.label.numeroTarefa" /></td>
			<td colspan="2"><html:text name="tarefaFormConsulta" property="codigo" maxlength="10" value="" /></td>
		</tr>
		<tr>
			<td align = "center" width = "15%"><html:checkbox name="tarefaFormConsulta" property="chkPrazo" style="border:0" onclick="setaCheckBox(this);"/></td>
			<td><bean:message key="pro.label.prazo" /></td>
			<td ><html:text size="10" property="dtPrazoInicioPesq" maxlength="10"
				onkeydown="AutoFormataData(this)" /></td>

			<td ><html:text size="10" property="dtPrazoFimPesq" maxlength="10"
				onkeydown="AutoFormataData(this)" /></td>
		</tr>
<!-- ********************************************************Tipo Tarefa************************************************************** -->
		<tr>
			<td align = "center" width = "15%"><html:checkbox name="tarefaFormConsulta" property="chkConfigTarefa" style="border:0" onclick="setaCheckBox(this);"/></td>
			<td ><bean:message key="pro.label.configTarefa" /></td>
			<td colspan="5">
				<html:select property="codConfigTarefa" style="width:350">
					<html:option value=""></html:option>
						<html:options collection="listaConfigTarefa" property="codigoConfigTarefa" labelProperty="textoConfigTarefa" />
					</html:select>
			</td>
			
		</tr>
		<!-- ********************************************************Nome Tarefa************************************************************** -->
		<tr>
			<td align = "center" width="15%"><html:checkbox name="tarefaFormConsulta" property="chkNome" style="border:0" onclick="setaCheckBox(this);"/></td>
			<td ><bean:message key="pro.label.nomeTarefa" /></td>
			<td colspan="5"><html:text size="60" maxlength="20" property="nome" /></td>
		</tr>
		<tr>
			<td align = "center" width = "15%"><html:checkbox name="tarefaFormConsulta" property="chkEstado" style="border:0" onclick="setaCheckBox(this);"/></td>
			<td ><bean:message key="pro.label.estado" /></td>
			<td  width="10%"><html:select property="codEstado" value="">
				<html:option value=""></html:option>
				<html:option value="1">
					<bean:message key="pro.label.tarefa.naoIniciada" />
				</html:option>
				<html:option value="2">
					<bean:message key="pro.label.tarefa.iniciada" />
				</html:option>
				<html:option value="3">
					<bean:message key="pro.label.tarefa.concluida" />
				</html:option>
				<html:option value="4">
					<bean:message key="pro.label.tarefa.cancelada" />
				</html:option>
				<html:option value="5">
					<bean:message key="pro.label.tarefa.validada" />
				</html:option>
			</html:select></td>
			<td style="display: none">
				<html:radio property="estadoSimNao" value="S" style="border:0;"><bean:message key="pro.label.option.sim"/></html:radio>
				<html:radio property="estadoSimNao" value="N" style="border:0"><bean:message key="pro.label.option.nao"/></html:radio>
			</td>
		</tr>

		<!-- ********************************************************Solicitacao***************************************************************** -->
		<tr>
			<td colspan="4" align="right">
				<button type="button" onclick="verificaCamposVazios();" class="botaoPreto">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.pesquisar"/>
				</button>
			</td>			
		</tr>
		<tr>
			<td colspan="4" >
				<c:if test="${listaVazia == 1}">
					<bean:message key="pro.listaVazia.pesquisar"/>
				</c:if>
			</td>
		</tr>
		
		
		<tr>
			<td>
				</br>
			</td>
		</tr>
	</table>

		<!-- ***************************************Apresentacao do Resultado da Pesquisa******************************************************** -->
	<table width="500px">
		<tr>
			<td>
				<logic:notEmpty name="listaTarefa" scope="request">
					<div id="imprimi">
						<table width="100%">
								<tr bgcolor="#f2f8fa">									
									<td class="menuPreto"><bean:message key="pro.label.numero"/></td>
									<c:if test="${tarefaFormConsulta.chkNome}">
										<td class="menuPreto"><bean:message key="pro.label.nome"/></td>
									</c:if>
									<c:if test="${tarefaFormConsulta.chkSolicitacao}">
										<td class="menuPreto"><bean:message key="pro.label.descricao"/></td>
									</c:if>
									<c:if test="${tarefaFormConsulta.chkConfigTarefa}">
										<td class="menuPreto"><bean:message key="pro.label.configTarefa"/></td>
									</c:if>									
									<c:if test="${tarefaFormConsulta.chkPrazo}">
										<td class="menuPreto"><bean:message key="pro.label.prazo"/></td>
									</c:if>
									<c:if test="${tarefaFormConsulta.chkEstado}">
										<td class="menuPreto"><bean:message key="pro.label.estado"/></td>
									</c:if>
									<c:if test="${tarefaFormConsulta.chkCriticidade}">
										<td class="menuPreto"><bean:message key="pro.label.criticidade"/></td>
									</c:if>
									

								</tr>
								<logic:iterate name="listaTarefa" id="tarefa">
								   <tr bgcolor="#FFFFFF" width="100%" >
										<td class="linkPreto"><a href="encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<c:out value='${tarefa.anoCriacao}'/>&codigo=<c:out value='${tarefa.codigo}'/>"  class="linkPreto"><c:out value="${tarefa.anoCriacao}" />/<c:out value="${tarefa.codigo}" /> </a></td>
										<c:if test="${tarefaFormConsulta.chkNome}">
											<td ><c:out value="${tarefa.nome}" /></td>
										</c:if>
										<c:if test="${tarefaFormConsulta.chkSolicitacao}">
											<td><c:out value="${tarefa.textoSolicitacao}" /></td>
										</c:if>
										<c:if test="${tarefaFormConsulta.chkConfigTarefa}">
											<td><c:out value="${tarefa.nomeConfigTarefa}" /></td>
										</c:if>									
										<c:if test="${tarefaFormConsulta.chkPrazo}">
											<td><c:out value="${tarefa.dtPrazo}" /></td>
										</c:if>
										<c:if test="${tarefaFormConsulta.chkEstado}">
											<td><c:if test="${tarefa.codEstado == '1'}">
												<bean:message key="pro.label.tarefa.naoIniciada" />
											</c:if>
											<c:if test="${tarefa.codEstado == '2'}">
												<bean:message key="pro.label.tarefa.iniciada" />
											</c:if>
											<c:if test="${tarefa.codEstado == '3'}">
												<bean:message key="pro.label.tarefa.concluido" />
											</c:if>
											<c:if test="${tarefa.codEstado == '4'}">
												<bean:message key="pro.label.tarefa.cancelada" />
											</c:if>
											<c:if test="${tarefa.codEstado == '5'}">
												<bean:message key="pro.label.tarefa.validada" />
											</c:if></td>
										</c:if>
										<c:if test="${tarefaFormConsulta.chkCriticidade}">
											<td><c:if test="${tarefa.codCriticidade == '0'}">
												<bean:message key="pro.label.alta" />
											</c:if>
											<c:if test="${tarefa.codCriticidade == '1'}">
												<bean:message key="pro.label.medio" />
				
											</c:if>
											<c:if test="${tarefa.codCriticidade == '2'}">
												<bean:message key="pro.label.baixa" />
											</c:if></td>
										</c:if>
									</tr>
								
								</logic:iterate>
							</table>
					</div>
					</br>
					<table width="100%" border="0">
						<tr align="right">
							<td>
								<button type="button" onclick="ativarPopupImpressao('imprimi');" class="botaoPreto">
									<img src="<c:out value="${base}"/>/WEB/imagens/comum/imprimir.gif" border="0" style="vertical-align: text-bottom">
									<bean:message key="pro.botao.imprimir"/>
								</button>
							</td>
						</tr>
					</table>
			</logic:notEmpty></td>
		</tr>

	</table>
<html:javascript formName="tarefaFormConsulta" />
</html:form>

