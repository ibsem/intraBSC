<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c"%>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
<script language="JavaScript">

		function incluirAnotacao() {
			document.anotacaoTarefaFormIncluir.action = "<c:out value="${base}"/>/anotacao/encaminhar/incluir.do?op=encaminharInclusao";	
			document.anotacaoTarefaFormIncluir.submit();
		}
		
		function pesquisarAnotacao() {
			if ((document.anotacaoTarefaFormIncluir.textoAnotacao.value != "")){
				document.anotacaoTarefaFormIncluir.action = "<c:out value="${base}"/>/anotacao/pesquisar.do?op=consultarVarios";
				document.anotacaoTarefaFormIncluir.submit();
			}else{
				document.anotacaoTarefaFormIncluir.action = "<c:out value="${base}"/>/anotacao/pesquisar.do?op=visualizar";
				document.anotacaoTarefaFormIncluir.submit();
			}
		}
		
		function desabilitaComboEtapa(form) {	
			if(form == 3){
				document.anotacaoTarefaFormIncluir.etapa.disabled = false;
			}else{
				document.anotacaoTarefaFormIncluir.etapa.disabled = true;
				document.anotacaoTarefaFormIncluir.etapa.value="";
			}
		}
		function retornaTarefa(){
			window.close();
		<%--	document.anotacaoTarefaFormIncluir.action = "<c:out value="${base}"/>/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao=" + document.anotacaoTarefaFormIncluir.anoTarefa.value + "&codigo="+document.anotacaoTarefaFormIncluir.codTarefa.value;
			document.anotacaoTarefaFormIncluir.submit();--%>
		}
		
		function resizeWindow(){
			window.resizeTo(410,300);
		}
	 </script>

<html:form action="/anotacao/encaminhar/visualizar">
	<html:hidden property="op" value="alterar" />
	<html:hidden property="tipoAnotacao" value="1" />
	<html:hidden property="estado" />
	<input type="hidden" name="codTarefa" value="<c:out value="${tarefaTO.codigo}"/>"/>
	<input type="hidden" name="anoTarefa" value="<c:out value="${tarefaTO.anoCriacao}"/>"/>

	<table border="1" width="550px" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2" class="titulo">
				<bean:message key="pro.label.tarefa" />&nbsp; 
				<bean:write property="anoNumeroNome" name="anotacaoTarefaFormIncluir" />&nbsp;
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td>
				<bean:message key="pro.label.tipoAnotacao" />
			</td>
		</tr>
		<tr>
			<td colspan="1" width="70%"><html:select property="textoAnotacao" disabled="false" style="width:100%" onchange="desabilitaComboEtapa(this.options[this.selectedIndex].value);">
				<html:option value=""></html:option>
				<html:option value="1"><bean:message key="pro.label.anotacao"/></html:option>
			</html:select></td>
			
		</tr>
		<tr>
			<td width="100%" height="120" colspan="2">
			<logic:notEmpty name="listaAnotacao" scope="session">
				<div id="imprimi">
					<%int contLinha = 0; %>
					<c:if test="${visualizar == 'visualizar'}">
						<table width="100%">
							<logic:iterate name="listaAnotacao" id="listaTipo">								
								<c:set var="tipoHist"><bean:write name="listaTipo" property="codTipoAnotacao"/></c:set>
								<c:if test="${tipoHist != tipoHistAnt}">
									<c:if test="${tipoHist == '1'}">
										<tr>
											<td align="center" width="100%" bgcolor="#0038a8" height="24" class="menuBranco"><b>Histórico Sintético(Erro)</b></td>
										</tr>
									</c:if>
									
								</c:if>
								<%	if (contLinha % 2 == 0){%> 
									   <tr bgcolor="#FFFFFF" width="100%" >
								<%	}else{%> 
									   <tr bgcolor="#CCD7EE" width="100%">																	
								<%	}contLinha++;%>
								
										<td width="100%">
											<bean:write name="listaTipo" property="tsAnotacao"/> - 
											<bean:write name="listaTipo" property="codUsuario"/> - 
											<bean:write name="listaTipo" property="textoAnotacao"/>													
										</td>
								</tr>									
								<c:set var="tipoHistAnt"><c:out value="${tipoHist}"/></c:set>
						
							</logic:iterate>
						</table>
					</c:if>
					
					<%-- Pesquisa com filtro --%>
					<c:if test="${visualizar == 'consultar'}">
						<table width="100%">
							<logic:iterate name="listaAnotacao" id="listaTipo">
								<c:set var="tipoHist"><bean:write name="listaTipo" property="codTipoAnotacao"/></c:set>		
								<c:if test="${tipoHist != tipoHistAnt}">
									<c:if test="${tipoHist == '1'}">
										<tr>
											<td align="center" width="100%" bgcolor="#0038a8" height="24" class="menuBranco"><b>Histórico Sintético</b></td>
										</tr>
									</c:if>
								</c:if>
								<%	if (contLinha % 2 == 0){%> 
									   <tr bgcolor="#FFFFFF" width="100%" >
								<%	}else{%> 
									   <tr bgcolor="#CCD7EE" width="100%">																	
								<%	}contLinha++;%>
																				

										<td width="100%">
											<bean:write name="listaTipo" property="tsAnotacao"/> - 
											<bean:write name="listaTipo" property="codUsuario"/> - 
											<bean:write name="listaTipo" property="textoAnotacao"/>													
										</td>
								</tr>									
								<c:set var="tipoHistAnt"><c:out value="${tipoHist}"/></c:set>
							</logic:iterate>
						</table>		
					</c:if>
				</div>
			</logic:notEmpty></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><html:button property="" onclick="ativarPopupImpressao('imprimi');">
				<bean:message key="pro.botao.imprimir" />
			</html:button> 
			<html:button property="" onclick="pesquisarAnotacao();">
				<bean:message key="pro.botao.pesquisar" />
			</html:button> 
			<html:button property="" onclick="retornaTarefa();">
				<bean:message key="pro.botao.fechar" />
			</html:button></td>
		</tr>
	</table>
</html:form>
