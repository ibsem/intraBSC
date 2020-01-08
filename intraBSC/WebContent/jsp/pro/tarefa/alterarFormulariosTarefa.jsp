<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language="JavaScript">
		function retornaTarefa(){
			window.opener.document.tarefaForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao=" + document.conteudoFormularioTarefaForm.anoTarefa.value + "&codigo="+document.conteudoFormularioTarefaForm.codTarefa.value;
			window.opener.document.tarefaForm.submit();
			window.close();
		}

</script>

<HTML>
	<body>
		<html:form action="/conteudoFormularioTarefa/incluir?op=incluir">
			<html:hidden property="op" value="incluir"/>	
			<input type="hidden" name="codTarefa" value="<c:out value="${tarefaTO.codigo}"/>"/>
			<input type="hidden" name="anoTarefa" value="<c:out value="${tarefaTO.anoCriacao}"/>"/>
			<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8"></td>
						<td class="menuPreto"><bean:message key="pro.label.configTarefa"/> <c:out value="${tarefaTO.codigoAno}"/> - <c:out value="${tarefaTO.nome}"/></td>
					</tr>
			</table>
			<displaytag:table width="100%" name="listaFormularios" id="formularios" styleClass="its" border="0" scope="session">
						<c:if test="${formularios.indVigente == 'S'}">
							<displaytag:column style="width:5%;" title="Número" align="center">
								<html:hidden property="numeroOrdem" name="formularios" />
								<html:hidden property="anoCriacao" name="formularios" />							
								<html:hidden property="codConfigTarefa" name="formularios" />														
								<bean:write property="numeroOrdem" name="formularios" />
							</displaytag:column>
							<displaytag:column style="width:35%;" title="Nome" align="left">&nbsp;
								<bean:write property="nomeFormulario" name="formularios" />
							</displaytag:column>
							<displaytag:column style="width:60%;" title="Conteúdo" align="left">&nbsp;
								
										<c:if test="${formularios.codTipoDadoFormulario == 3}">
											<html:text name="formularios" property="textoFormularioTarefa" onkeydown="AutoFormataData(this)" maxlength="10" />
										</c:if>
										<c:if test="${formularios.codTipoDadoFormulario == 1}">
											<html:textarea name="formularios"  cols="62" rows="3" property="textoFormularioTarefa"/>
										</c:if>
										<c:if test="${formularios.codTipoDadoFormulario == 2}">
											<html:text name="formularios" property="textoFormularioTarefa" maxlength="10"/>
										</c:if> 
										<c:if test="${formularios.codTipoDadoFormulario == 5}">
											<html:checkbox name="formularios" property="textoFormularioTarefa" maxlength="10"/>
										</c:if>
										
										<c:if test="${formularios.codTipoDadoFormulario == 4}">
											<select name="textoFormularioTarefa" style="width:250px">
												<option value=""></option>
											<!-- 	<c:forEach var="lista"  formularios="${formularios.listaOpcaoTipoFormulario}">
													<c:if test="${lista.codigo == formularios.textoFormularioTarefa}">
														<option selected value="<c:out value='${lista.codigo}'/>"><c:out value="${lista.texto}"/></option>
													</c:if>
													<c:if test="${lista.codigo != formularios.textoFormularioTarefa}">
														<option value="<c:out value='${lista.codigo}'/>"><c:out value="${lista.texto}"/></option>
													</c:if>
												</c:forEach>
											 -->	
											</select>
										</c:if>
								
							</displaytag:column>																																
						</c:if>
						<c:if test="${formularios.indVigente == 'N'}">
							<c:if test="${formularios.textoFormularioTarefa != null && formularios.textoFormularioTarefa != ''}">
								<displaytag:column style="width:5%;" title="Número" align="center">
									<bean:write property="numeroOrdem" name="formularios" />
								</displaytag:column>
								<displaytag:column style="width:35%;" title="Nome" align="left">&nbsp;
									<bean:write property="nomeFormulario" name="formularios" />
								</displaytag:column>
								<displaytag:column style="width:60%;" title="Conteúdo" align="left">&nbsp;
										<c:if test="${formularios.codTipoDadoFormulario == '1'}">
											<html:textarea cols="62" rows="3" property="textoFormularioTarefa"/>
										</c:if>	
										<c:if test="${formularios.codTipoDadoFormulario == 2}">
											<html:text property="textoFormularioTarefa" maxlength="10"/>
										</c:if>	
										<c:if test="${formularios.codTipoDadoFormulario == 3}">
											<html:text property="textoFormularioTarefa" onkeydown="AutoFormataData(this)"/>
										</c:if>	
										<!-- 
										<c:if test="${formularios.codTipoDadoFormulario == 4}">
											<select name="textoFormularioTarefa" style="width:250px">
												<c:forEach var="lista" formularios="${formularios.listaOpcaoTipoFormulario}">
													<option value="<c:out value="${lista.codigo}"/>"><c:out value="${lista.texto}"/></option>
												</c:forEach>
											</select>
										</c:if>
									    -->	
										<c:if test="${formularios.codTipoDadoFormulario == 5}">
											<html:checkbox name="formularios" property="textoFormularioTarefa" maxlength="10"/>
										</c:if>
								</displaytag:column>
							</c:if>					
						</c:if>
			</displaytag:table>
			<table border="0" width="580px" cellpadding="0" cellspacing="0">
				<tr height="30">
					<td></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<c:if test="${tarefaTO.codEstado != '5'}">	
						<button type="submit" disabled="false" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.salvar"/>
						</button>
						</c:if>
						<button type="button" onclick="retornaTarefa();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.fechar"/>
						</button>
					</td>
				</tr>
			</table>
		</html:form>
	</body>		
</HTML>