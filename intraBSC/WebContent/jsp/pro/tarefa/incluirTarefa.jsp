<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<html:html>
  <head>
	<script language="javascript">
		function calcularDataPrazoTarefa(args){
			document.tarefaForm.action = "<c:out value="${base}"/>/tarefa/incluir.do?op=calcularDataPrazo";	
			document.tarefaForm.submit();
		}
		function voltar(){
			var linkMapa="<c:out value="${base}"/>/mapaEstrategico/consultar.do?op=consultarUm&id=";
			var linkPers="<c:out value="${base}"/>/perspectiva/encaminha.do?op=encaminhaAlterar&codPerspectiva=";
			var linkObj="<c:out value="${base}"/>/objetivo/encaminha.do?op=encaminharAlterar&codObjetivo=";
			var linkInd="<c:out value="${base}"/>/indicador/encaminha.do?op=encaminharAlterar&codIndicador=";
			var form = document.tarefaForm;
			if (form.codIndicador.value != "0"){
				form.action = linkInd + form.codIndicador.value;
				form.submit();
			}else if (form.codObjetivo.value != "0"){
				form.action = linkObj + form.codObjetivo.value;
				form.submit();
			}else if (form.codPerspectiva.value != "0"){
				form.action = linkPers + form.codPerspectiva.value;
				form.submit();
			}else if (form.codMapa.value != "0"){
				form.action = linkMapa + form.codMapa.value;
				form.submit();
			}
		}
	</script>
   
  </head>
<body>
	<html:form action="/tarefa/incluir" onsubmit="return validateTarefaForm(this);">	
			<input type="hidden" name="dataAtual" value="<c:out value="${dataAtual}"/>">
			<input type="hidden" name="dataCriacao" value="<c:out value="${dataCriacao}"/>">
			<html:hidden property="sucessoSolicitante" value="sucessoIncluiTarefa"/>
			<html:hidden property="op" value="incluir"/>
			<html:hidden property="sucesso" value="sucessoIncluiTarefa"/>
			<input type="hidden" name="dataPrazoParametro">
			<input type="hidden" name="dataInicioParametro">	
			<input type="hidden" name="dataFimParametro">
			<html:hidden property="codigo" />
			
			<html:hidden property="dtInicio" />
			<html:hidden property="dtLimitePrazo" />
			<html:hidden property="dtFim" />
			
			<input type="hidden" name="codMapa" value="<c:out value="${codMapa}"/>"/>
			<input type="hidden" name="codPerspectiva" value="<c:out value="${codPerspectiva}"/>"/>
			<input type="hidden" name="codObjetivo" value="<c:out value="${codObjetivo}"/>"/>
			<input type="hidden" name="codIndicador" value="<c:out value="${codIndicador}"/>"/>
			
			
			<table border="0" width="512px" align="center" cellpadding="0" cellspacing="0">
				
				<tr>
				    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.incluirexecucaotarefa"/></td>  
				</tr>
				<tr>
	 				<td></br><bean:message key="pro.label.configTarefa" /></td>
	 			</tr>
	 			<tr>
	 				<td >
						<html:select property="codConfigTarefa" onchange="calcularDataPrazoTarefa();" style="width:512px">
							<html:option value=""></html:option>
							<html:options collection="listaConfigTarefa" property="codigoConfigTarefa" labelProperty="textoConfigTarefa" />
						</html:select>
					</td>
					</tr>
				</table>
				<table border="0" width="510px" cellpadding="0" cellspacing="0">
					<tr>
		 				<td colspan="2"><bean:message key="pro.label.nomeTarefa" /></td>
		 			</tr>
		 			<tr>
		 				<td>
							<html:text property="nome" maxlength="100" size="108" disabled="false" style="width:512px"/>
						</td>
					</tr>
					<tr>
		 				<td><bean:message key="pro.label.descricao" /></td>
		 			</tr>
		 			<tr>
		 				<td colspan="2"><html:textarea property="textoSolicitacao" cols="93" rows="4" readonly="true" style="width:512px"/></td> 
	
					</tr>					
				</table>
				<table border="0" width="470px" cellpadding="0" cellspacing="0">
					<tr>
						<!-- <td><bean:message key="pro.label.prazo" /></td> -->
						<td width="10%"><bean:message key="pro.label.estado" /></td>
						<td>&nbsp;&nbsp;</td>
						<td width="10%"><bean:message key="pro.label.criticidade" /></td>
					</tr>

		 			<tr>
	 					<td>
							<html:select property="codEstado" style="width:240px">
								<html:option value="4"><bean:message key="pro.label.tarefa.cancelada"/></html:option>
								<html:option value="1"><bean:message key="pro.label.tarefa.naoIniciada"/></html:option>
								<html:option value="3"><bean:message key="pro.label.tarefa.concluida"/></html:option>
								<html:option value="2"><bean:message key="pro.label.tarefa.iniciada"/></html:option>
								<html:option value="5"><bean:message key="pro.label.tarefa.validada"/></html:option>
							</html:select>
						</td>
						<td>&nbsp;&nbsp;</td>						
		 				<td>
							<html:select property="codCriticidade"  style="width:260px">
								<html:option value="1"><bean:message key="pro.label.alta"/></html:option>
								<html:option value="3"><bean:message key="pro.label.baixa"/></html:option>
								<html:option value="2"><bean:message key="pro.label.medio"/></html:option>
							</html:select>
						</td>
					</tr>
				</table>
				<table border="0" width="510px" cellpadding="0" cellspacing="0">
					<tr>
					<td></br>
						<c:choose>
							<c:when test="${codIndicador ne '' and not empty codIndicador and codIndicador ne '0'}">
								<b><bean:message key="bsc.label.indicador"/>:&nbsp;<c:out value="${nomeIndicador}"/></b>
							</c:when>
							<c:when test="${codObjetivo ne '' and not empty codObjetivo and codObjetivo ne '0'}">
								<b><bean:message key="bsc.label.objetivo"/>:&nbsp;<c:out value="${nomeObjetivo}"/></b>
							</c:when>
							<c:when test="${codPerspectiva ne '' and not empty codPerspectiva and codPerspectiva ne '0'}">
								<b><bean:message key="bsc.label.perspectiva"/>:&nbsp;<c:out value="${nomePerspectiva}"/></b>
							</c:when>
							<c:when test="${codMapa ne '' and not empty codMapa and codMapa ne '0'}">
								<b><bean:message key="bsc.label.mapa"/>:&nbsp;<c:out value="${nomeMapa}"/></b>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</td>
				</tr>
					
					<tr height="3">
					</tr>
				</table>
				<table border="0" width="512px" cellpadding="0" cellspacing="0">
				<tr>
	 				<td align="right">
						<button type="submit" class="botaoPreto">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.salvar"/>
						</button>
						<c:if test="${codMapa ne '' and not empty codMapa}">
						<button type="button" onclick="voltar();" class="botaoPreto">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.voltar"/>
						</button>
						</c:if>
					</td>
				</tr>
			</table>
	<html:javascript formName="tarefaForm" />
	</html:form>
</body>
</html:html>