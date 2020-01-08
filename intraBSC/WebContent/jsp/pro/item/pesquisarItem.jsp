<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<html:form action="/item/consultarVarios" >
		<html:hidden property="op" value="consultarItemConfigTarefa"/>
		<table border="0">	
			<tr>
				<td colspan="2"><br/>
					<bean:message key="pro.label.configTarefa" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<html:select property="codigoConfigTarefa" disabled="false">
						<html:option value="">&nbsp;</html:option>
						<logic:present name="listaConfigTarefaDepe">				
							<html:options collection="listaConfigTarefaDepe" property="codigoConfigTarefa" labelProperty="textoConfigTarefa" />
						</logic:present>
						<logic:present name="listaConfigTarefa">				
							<html:options collection="listaConfigTarefa" property="codigoConfigTarefa" labelProperty="textoConfigTarefa" />
						</logic:present>
					</html:select>
				</td> 
			</tr>
			<tr>
				<td height="7"></td>
			</tr>
			<tr>
				<td>
					<bean:message key="pro.label.nome" />
				</td>				
			</tr>
			<tr>
				<td>
					<html:text property="nome" size="40" maxlength="100" />
				</td>								
			</tr>
			<tr>
				<td>&nbsp;</td>		
			</tr>
			<tr>
				<td>
					<logic:notEmpty name="listaItems" scope="request">
						<displaytag:table width="100%" name="listaItems" id="item" styleClass="its" pagesize="20" requestURI="" scope="request">
							<%String cor = "black";%>
							<c:if test="${item.indItemVigente == 'N'}">
								<% cor = "gray"; %>
							</c:if>
							
                            <displaytag:column style="width:15px;" title="Prefixo"> 
								<a class="linkPreto" href="encaminhar/alterar.do?op=encaminharAlterar&codigoConfigTarefa=<c:out value='${item.codigoConfigTarefa}'/>&numeroOrdem=<c:out value='${item.numeroOrdem}'/>">
									<font color="<%=cor%>"><c:out value="${item.codPrefixo}"/></font>
								</a>
							</displaytag:column>

 							<displaytag:column style="width:250px;" title="Tipo de Tarefa"> 
								<a class="linkPreto" href="encaminhar/alterar.do?op=encaminharAlterar&codigoConfigTarefa=<c:out value='${item.codigoConfigTarefa}'/>&numeroOrdem=<c:out value='${item.numeroOrdem}'/>">
									<font color="<%=cor%>"><c:out value="${item.nomeConfigTarefa}"/></font>
								</a>
							</displaytag:column>

                           <displaytag:column style="width:15px;" title="Ordem"> 
								<a class="linkPreto" href="encaminhar/alterar.do?op=encaminharAlterar&codigoConfigTarefa=<c:out value='${item.codigoConfigTarefa}'/>&numeroOrdem=<c:out value='${item.numeroOrdem}'/>">
									<font color="<%=cor%>"><c:out value="${item.numeroOrdem}"/></font>
								</a>
							</displaytag:column>

							<displaytag:column style="width:250px;" title="Nome"> 
								<a class="linkPreto" href="encaminhar/alterar.do?op=encaminharAlterar&codigoConfigTarefa=<c:out value='${item.codigoConfigTarefa}'/>&numeroOrdem=<c:out value='${item.numeroOrdem}'/>">
									<font color="<%=cor%>"><c:out value="${item.nome}"/></font>
								</a>
							</displaytag:column>

							<displaytag:column style="width:15px;" title="Critico"> 
								<a class="linkPreto" href="encaminhar/alterar.do?op=encaminharAlterar&codigoConfigTarefa=<c:out value='${item.codigoConfigTarefa}'/>&numeroOrdem=<c:out value='${item.numeroOrdem}'/>">
									<font color="<%=cor%>">
									<c:choose>
										<c:when test="${item.indItemCritico == 'S'}">
											<bean:message key="pro.label.option.sim" />
										</c:when>
										<c:when test="${item.indItemCritico == 'N'}">
											<bean:message key="pro.label.option.nao" />
										</c:when>
									</c:choose>
									</font>
								</a>
							</displaytag:column>

							<displaytag:column style="width:15px;" title="Vigente"> 
								<a class="linkPreto" href="encaminhar/alterar.do?op=encaminharAlterar&codigoConfigTarefa=<c:out value='${item.codigoConfigTarefa}'/>&numeroOrdem=<c:out value='${item.numeroOrdem}'/>">
									<font color="<%=cor%>">
									<c:choose>
										<c:when test="${item.indItemVigente == 'S'}">
											<bean:message key="pro.label.option.sim" />
										</c:when>
										<c:when test="${item.indItemVigente == 'N'}">
											<bean:message key="pro.label.option.nao" />
										</c:when>
									</c:choose>
									</font>
								</a>
							</displaytag:column>
						</displaytag:table>						
  					</logic:notEmpty>		
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td colspan="2" align="right">					
					<html:submit><bean:message key="pro.botao.pesquisar"/></html:submit>
				</td>
			</tr>
		</table>
</html:form>
