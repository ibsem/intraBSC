<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language="JavaScript">
		function retornaTarefa(){
			window.opener.document.tarefaForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao=" + document.conteudoItemTarefaForm.anoTarefa.value + "&codigo="+document.conteudoItemTarefaForm.codTarefa.value;
			window.opener.document.tarefaForm.submit();
			window.close();
		}

</script>

<HTML>
	<body>
		<html:form action="/conteudoItemTarefa/incluir?op=incluir">
			<html:hidden property="op" value="incluir"/>	
			<input type="hidden" name="codTarefa" value="<c:out value="${tarefaTO.codigo}"/>"/>
			<input type="hidden" name="anoTarefa" value="<c:out value="${tarefaTO.anoCriacao}"/>"/>
			<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8"></td>
						<td class="menuPreto"><bean:message key="pro.label.configTarefa"/> <c:out value="${tarefaTO.codigoAno}"/> - <c:out value="${tarefaTO.nome}"/></td>
					</tr>
			</table>
			<displaytag:table width="100%" name="listaItems" id="items" styleClass="its" border="0" scope="session">
						<c:if test="${items.indVigente == 'S'}">
							<displaytag:column style="width:5%;" title="Número" align="center">
								<html:hidden property="numeroOrdem" name="items" />
								<html:hidden property="anoCriacao" name="items" />							
								<html:hidden property="codConfigTarefa" name="items" />														
								<bean:write property="numeroOrdem" name="items" />
							</displaytag:column>
							<displaytag:column style="width:35%;" title="Nome" align="left">&nbsp;
								<bean:write property="nomeItem" name="items" />
							</displaytag:column>
							<displaytag:column style="width:60%;" title="Conteúdo" align="left">&nbsp;
								
										<c:if test="${items.codTipoDadoItem == 3}">
											<html:text name="items" property="textoItemTarefa" onkeydown="AutoFormataData(this)" maxlength="10" />
										</c:if>
										<c:if test="${items.codTipoDadoItem == 1}">
											<html:textarea name="items"  cols="62" rows="3" property="textoItemTarefa"/>
										</c:if>
										<c:if test="${items.codTipoDadoItem == 2}">
											<html:text name="items" property="textoItemTarefa" maxlength="10"/>
										</c:if> 
										<c:if test="${items.codTipoDadoItem == 5}">
											<html:checkbox name="items" property="textoItemTarefa" maxlength="10"/>
										</c:if>
										
										<c:if test="${items.codTipoDadoItem == 4}">
											<select name="textoItemTarefa" style="width:250px">
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
						</c:if>
						<c:if test="${items.indVigente == 'N'}">
							<c:if test="${items.textoItemTarefa != null && items.textoItemTarefa != ''}">
								<displaytag:column style="width:5%;" title="Número" align="center">
									<bean:write property="numeroOrdem" name="items" />
								</displaytag:column>
								<displaytag:column style="width:35%;" title="Nome" align="left">&nbsp;
									<bean:write property="nomeItem" name="items" />
								</displaytag:column>
								<displaytag:column style="width:60%;" title="Conteúdo" align="left">&nbsp;
										<c:if test="${items.codTipoDadoItem == '1'}">
											<html:textarea cols="62" rows="3" property="textoItemTarefa"/>
										</c:if>	
										<c:if test="${items.codTipoDadoItem == 2}">
											<html:text property="textoItemTarefa" maxlength="10"/>
										</c:if>	
										<c:if test="${items.codTipoDadoItem == 3}">
											<html:text property="textoItemTarefa" onkeydown="AutoFormataData(this)"/>
										</c:if>	
										<c:if test="${items.codTipoDadoItem == 4}">
											<select name="textoItemTarefa" style="width:250px">
												<c:forEach var="lista" items="${items.listaOpcaoTipoItem}">
													<option value="<c:out value="${lista.codigo}"/>"><c:out value="${lista.texto}"/></option>
												</c:forEach>
											</select>
										</c:if>
										<c:if test="${items.codTipoDadoItem == 5}">
											<html:checkbox name="items" property="textoItemTarefa" maxlength="10"/>
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