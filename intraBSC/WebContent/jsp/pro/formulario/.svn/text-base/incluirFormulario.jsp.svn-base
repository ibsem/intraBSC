<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language="javascript" type="text/javascript">
	
	function cancelar(){
		window.close();
	}
	function incluir(){
		<%br.com.intraPRO.configTarefa.visao.ConfigTarefaForm configTarefaForm = (br.com.intraPRO.configTarefa.visao.ConfigTarefaForm) request.getSession().getAttribute("configTarefaForm");%>
		var codTipo = <%=configTarefaForm.getCodigoConfigTarefa()%>;
		document.formularioForm.action = "<c:out value="${base}"/>/formulario/incluir.do?op=incluir&tipoParticipacao=1&formAnce=configTarefaForm&acao=<c:out value="${base}"/>/configTarefa/consultarUm.do?op=consultarUm&codigoConfigTarefa="+codTipo;
		document.formularioForm.submit();		
	}
	
</script>

<html:form action="/formulario/incluir" onsubmit="return validateFormularioForm(this);">
			<html:hidden property="op" value="incluir"/>
			<%String  codTipo = (String)request.getSession().getAttribute("codConfigTarefa");%>
			<table border="0" width="385px" cellpadding="0" cellspacing="0">
				<tr>
					<td ><br/><bean:message key="pro.label.configTarefa" /></td>
				</tr>
				<tr>
	 				<td colspan="3">							
						<html:select property="codConfigTarefa" value="<%=codTipo%>" disabled="true" style="width=380px">
							<html:option value=""></html:option>
							<html:options collection="listaConfigTarefa" property="codigoConfigTarefa" labelProperty="textoConfigTarefa" />
						</html:select>
					</td>
				</tr>
				<tr colspan="3">
	 				<td><bean:message key="pro.label.nomeCampoInformacao" /></td>
				</tr>
				<tr>
	 				<td colspan="3"><html:text property="nome" size="59" maxlength="100" /></td>
				</tr>
				<tr>
					<td ><bean:message key="pro.label.numeroInformacao" /></td>
					<td ><bean:message key="pro.label.vigente" /></td>
	 				<td ><bean:message key="pro.label.Tipo" /> </td>
				</tr>
				<tr>
					<td ><html:text property="numeroOrdem" value="" size="35" maxlength="3" /></td>
	 				<td >
						<html:select property="indFormularioVigente">
								<html:option value="S"><bean:message key="pro.label.option.sim" /></html:option>
								<html:option value="N"><bean:message key="pro.label.option.nao" /></html:option>
						</html:select>
					</td>
					<td ><html:select property="codigoDadoFormulario" onchange="habilitaCombo();" style="width:65px">
							<html:option value="1"><bean:message key="pro.label.Texto" /></html:option>
							<html:option value="2"><bean:message key="pro.label.numero" /></html:option>
							<html:option value="3"><bean:message key="pro.label.data" /></html:option>
							<html:option value="4"><bean:message key="pro.label.combo" /></html:option>
							<html:option value="5"><bean:message key="pro.label.box" /></html:option>
					</html:select></td>
				</tr>
			</table>
		<table border="0" width="389px" cellpadding="0" cellspacing="0">
			<tr>
				<td align="right">
					<button type="button" onclick="incluir();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
					<button type="button" onclick="cancelar();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.voltar"/>
					</button>
				</td>
			</tr>
		</table>
	</br>
	<html:javascript formName="formularioForm" />
</html:form>