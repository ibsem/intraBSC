<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<html:form action="/configTarefa/incluir.do" onsubmit="return validateConfigTarefaForm(this);">
			<html:hidden property="op" value="incluir"/>
			<table border="0" width="512px" cellpadding="0" cellspacing="0">
				
				<tr>
				    <td colspan="4" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.incluirdefinicaotarefa"/></td>  
				</tr>
				
				<tr>
					<td colspan="4">
						<bean:message key="pro.label.nome" />  
					</td>		
				</tr>
				<tr>	
					<td colspan="4">
						<html:text property="textoConfigTarefa"  size="80" maxlength="90" value="" style="width:512px"/> 
					</td>
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
						<html:select property="indTipoVigencia" style="width:50px">
							<html:option value="S"><bean:message key="pro.label.option.sim" /></html:option>
							<html:option value="N"><bean:message key="pro.label.option.nao" /></html:option>
						</html:select>
					</td>	
					<td>
						<html:text property="numDiasPrevistos" size="10" value="" maxlength="3" />
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
						<html:select property="codCriticidadeIniTarefa">
							<html:option value="1"><bean:message key="pro.label.alta"/></html:option>
							<html:option value="2"><bean:message key="pro.label.medio"/></html:option>
							<html:option value="3"><bean:message key="pro.label.baixa"/></html:option>
						</html:select>
					</td>
				</tr>
											
				<tr>
					<td colspan="4"><bean:message key="pro.label.nomeInicialTarefa"/>
					</td>
				</tr>
				<tr>	
					<td colspan="4">
						<html:text property="nomeIniTarefa" size="80" maxlength="90" value="" style="width:512px"/></td>
				</tr>
				<tr>
					<td colspan="4"><bean:message key="pro.label.solicitacaoInicialTarefa"/></td>
				</tr>
				<tr>
					<td colspan="4"><html:textarea property="txtSolicitacaoIniTarefa"  cols="98" rows="4" value="" style="width:512px"/></td>
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
				<tr>					
					<td colspan="4" align="right">
						<button type="submit" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.salvar"/>
						</button>
					</td>
				</tr>

			</table>
			</br></br>
</html:form>
<html:javascript formName="configTarefaForm" />
