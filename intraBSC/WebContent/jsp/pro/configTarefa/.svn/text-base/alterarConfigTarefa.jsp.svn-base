<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%br.com.intraPRO.configTarefa.visao.ConfigTarefaForm configTarefaForm = (br.com.intraPRO.configTarefa.visao.ConfigTarefaForm) request.getSession().getAttribute("configTarefaForm");%>
<script language="JavaScript">
	function abrirItem(){
		var codConfigTarefa = <%=String.valueOf(configTarefaForm.getCodigoConfigTarefa())%>;
		abrirPopupItem("<c:out value="${base}"/>/item/encaminhar/incluir.do?op=encaminharInclusao&codConfigTarefa="+codConfigTarefa);
	}
	function abrirFormulario(){
		var codConfigTarefa = <%=String.valueOf(configTarefaForm.getCodigoConfigTarefa())%>;
		abrirPopupFormulario("<c:out value="${base}"/>/formulario/encaminhar/incluir.do?op=encaminharInclusao&codConfigTarefa="+codConfigTarefa);
	}
	
	
</script>

<html:form action="/configTarefa/alterar.do" onsubmit="return validateConfigTarefaForm(this);">
	<html:hidden property="op" value="alterar"/>
		<input type=hidden name="chaveSelecionadaTipoParticipanteExecutante" value=""/>
	<html:hidden name="configTarefaForm" property="codigoConfigTarefa" value="<%=String.valueOf(configTarefaForm.getCodigoConfigTarefa())%>"/>
	<table border="0" width="512px" cellpadding="0" cellspacing="0">
		
		<tr>
		    <td colspan="4" valign = "top" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.alterardefinicaotarefa"/></td>  
		</tr>
		
		<tr>
			<td colspan="4">
				<bean:message key="pro.label.nome" />  
			</td>
		</tr>
		<tr>	
			<td colspan="4">
				<html:text property="textoConfigTarefa" size="80" maxlength="90" style="width:512px"/> 
			</td>
		</tr>
									
		<tr>
			<td colspan="4"><bean:message key="pro.label.nomeInicialTarefa"/>
			</td>
		</tr>
		<tr>	
		<td colspan="4">
			<html:text property="nomeIniTarefa" size="80" maxlength="90" style="width:512px"/></td>
		</tr>
		<tr>
			<td colspan="4"><bean:message key="pro.label.solicitacaoInicialTarefa"/></td>
		</tr>
		<tr>
			<td colspan="4"><html:textarea property="txtSolicitacaoIniTarefa"  cols="92" rows="4" style="width:512px"/></td>
		</tr>
		
		<tr>
			<td>
				<bean:message key="pro.label.vigente" />
			</td>				
			<td>
				<bean:message key="pro.label.diasPrevistos" />
			</td>
			<td ><bean:message key="pro.label.estaInicialTarefa"/>
			</td>
			<td ><bean:message key="pro.label.criticidadeInicialTarefa"/>
			</td>
		</tr>
		<tr>
			<td>
				<html:select property="indTipoVigencia" style="width:59px">
					<html:option value="S"><bean:message key="pro.label.option.sim" /></html:option>
					<html:option value="N"><bean:message key="pro.label.option.nao" /></html:option>
				</html:select>
			</td>	
			<td>
				
				<html:text property="numDiasPrevistos" size="10" maxlength="3" />
			</td>
			<td>
				<html:select property="codEstadoIniTarefa">
					<html:option value="1"><bean:message key="pro.label.tarefa.naoIniciada"/></html:option>
					<html:option value="2"><bean:message key="pro.label.tarefa.iniciada"/></html:option>
					<html:option value="3"><bean:message key="pro.label.tarefa.concluida"/></html:option>
					<html:option value="4"><bean:message key="pro.label.tarefa.cancelada"/></html:option>
					<html:option value="5"><bean:message key="pro.label.tarefa.validada"/></html:option>
				</html:select>
			</td>
			<td >	
				<html:select property="codCriticidadeIniTarefa" style="width:60px">
					<html:option value="1"><bean:message key="pro.label.alta"/></html:option>
					<html:option value="2"><bean:message key="pro.label.medio"/></html:option>
					<html:option value="3"><bean:message key="pro.label.baixa"/></html:option>
				</html:select>
			</td>
		</tr>
		
	
	
	
	</table>
	<table border="0" width="512px">
		<tr>
			<td class="txtPreto">
			<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/participante.gif" border="0">
			<b><bean:message key="pro.label.incluirExecucao" /></b></td>
		</tr>
		<tr>
			<td width="100%"><%@ include file="/jsp/pro/participanteConfigTarefa/listarParticipanteConfigTarefaExecutante.jsp"%></td>
		</tr>
	</table>
	<br/>
	
	<!-- Inicio Formulario -->
	<table border="0" width="512px">
		<tr>
			<td class ="menuPreto" colspan="4" height="21" align="left" >
			<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/formulario.gif" border="0">
			<bean:message key="pro.label.formulario"/></td>
		</tr>
	</table>
	<logic:notEmpty name="listaFormularios">
		<table border="0" width="512px">
				<tr height="4">
					<td colspan="4" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.vigente"/></u>
					</td>
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.ordem"/></u>
					</td>
					<td width="54%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="16%" align="left">
						<u><bean:message key="bsc.label.tipo"/></u>
					</td>
				</tr>
			<tr>
				<td colspan="4">
					<displaytag:table width="512px" name="listaFormularios" id="formularios"  requestURI="" scope="request">
						<displaytag:column style="width:15%;" title="" align="left">
							<c:out value="${formularios.indFormularioVigente}"/>
						</displaytag:column>
						<displaytag:column style="width:15%;" title="" align="left">
							<c:out value="${formularios.numeroOrdem}"/>
						</displaytag:column>
						<displaytag:column style="width:55%;" title="" align="left">
							<a class="linkPreto" href="#" onclick=abrirPopupFormularioAlterar("../formulario/encaminhar/alterar.do?op=encaminharAlterar&codConfigTarefa=<c:out value='${formularios.codConfigTarefa}'/>&numeroOrdem=<c:out value='${formularios.numeroOrdem}'/>");>
								<c:out value="${formularios.nome}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:15%;" title="" align="left">
							<c:if test="${formularios.codTipoDadoFormulario == '1'}">
								<bean:message key="pro.label.Texto" />
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario == '2'}">
								<bean:message key="pro.label.numero" />
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario == '3'}">
								<bean:message key="pro.label.data" />
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario == '4'}">
									<bean:message key="pro.label.combo" />
							</c:if>
							<c:if test="${formularios.codTipoDadoFormulario == '5'}">
									<bean:message key="pro.label.box" />
							</c:if>
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</logic:notEmpty>
		<table border="0" width="512px">
			<tr align = "right">
				<td colspan="4">
					<button type="button" onclick="abrirFormulario();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.adicionar"/>
					</button>
				</td>
			</tr>
		</table>


	
	
	<!-- Fim Formulario -->
	
	
	<!-- Inicio Checklist -->
	<table border="0" width="512px">
		<tr>
			<td class ="menuPreto" colspan="4" height="21" align="left" >
			<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/checklist.gif" border="0">
			<bean:message key="pro.label.listaafazer"/></td>
		</tr>
	</table>
	<logic:notEmpty name="listaItems">
		<table border="0" width="512px">
				<tr height="4">
					<td colspan="4" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.vigente"/></u>
					</td>
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.ordem"/></u>
					</td>
					<td width="54%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="16%" align="left">
						<u><bean:message key="bsc.label.tipo"/></u>
					</td>
				</tr>
			<tr>
				<td colspan="4">
					<displaytag:table width="512px" name="listaItems" id="items"  requestURI="" scope="request">
						<displaytag:column style="width:15%;" title="" align="left">
							<c:out value="${items.indItemVigente}"/>
						</displaytag:column>
						<displaytag:column style="width:15%;" title="" align="left">
							<c:out value="${items.numeroOrdem}"/>
						</displaytag:column>
						<displaytag:column style="width:55%;" title="" align="left">
							<a class="linkPreto" href="#" onclick=abrirPopupItemAlterar("../item/encaminhar/alterar.do?op=encaminharAlterar&codConfigTarefa=<c:out value='${items.codConfigTarefa}'/>&numeroOrdem=<c:out value='${items.numeroOrdem}'/>");>
								<c:out value="${items.nome}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:15%;" title="" align="left">
							<c:if test="${items.codTipoDadoItem == '1'}">
								<bean:message key="pro.label.Texto" />
							</c:if>
							<c:if test="${items.codTipoDadoItem == '2'}">
								<bean:message key="pro.label.numero" />
							</c:if>
							<c:if test="${items.codTipoDadoItem == '3'}">
								<bean:message key="pro.label.data" />
							</c:if>
							<c:if test="${items.codTipoDadoItem == '4'}">
									<bean:message key="pro.label.combo" />
							</c:if>
							<c:if test="${items.codTipoDadoItem == '5'}">
									<bean:message key="pro.label.box" />
							</c:if>
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</logic:notEmpty>
		
		<!-- Fim Checklist -->
		
		<table border="0" width="512px">
			<tr align = "right">
				<td colspan="4">
					<button type="button" onclick="abrirItem();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.adicionar"/>
					</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<bean:message key="bsc.campo.responsavel"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<html:select property="idResponsavel" style="width:512px">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="border-bottom:thin; border-bottom-style:solid;"></td>
			</tr>
		</table>
      	<br /><br />
		<table width="512px" border="0">
			<tr>
 				<td colspan="1" align="right" width="512px">
					<button type="submit" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
<!--					<button  type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle">-->
<!--						<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">-->
<!--						<bean:message key="pro.botao.voltar"/>-->
<!--					</button>-->
				</td>
			</tr>
		</table>
</html:form>
<html:javascript formName="configTarefaForm" />
