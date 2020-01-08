<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<html:form action="/configTarefa/consultarVarios">
		<html:hidden property="op" value="consultarVarios"/>
		<table border="0" width="390px">
			<tr >
			    <td colspan="3" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.pesquisardefinicaotarefa"/></td>  
			</tr>
							
			<tr>
				<td width="200px" colspan="1"><bean:message key="pro.label.nome" /></td>
				<td width="100px"><bean:message key="pro.label.vigente" /></td>	 	
			</tr>
			<tr>
				<td width="200px" colspan="1"><html:text property="textoConfigTarefa" size="60" maxlength="100" /></td>
	 			<td width="100px">
					<html:select property="indTipoVigencia">
							<html:option value=""></html:option>
							<html:option value="S"><bean:message key="pro.label.option.sim"/></html:option>
							<html:option value="N"><bean:message key="pro.label.option.nao"/></html:option>
					</html:select>
				</td>
			</tr>			
				</br>
			<tr>
		</table>
		<table width="435px">
			<tr>
			   	<td>
			   		<table width="434px" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
			<logic:notEmpty name="listaConfigTarefa" scope="request">
			
				
				<tr>
					<td width="10%" align="center">
						<u><bean:message key="bsc.label.codigo"/></u>
					</td>
					<td width="75%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="15%" align="center">
						<u><bean:message key="bsc.label.vigente"/></u>
					</td>
				</tr>
				</table>
			<table width="434px" border="0" cellspacing="0" cellpadding="0">
			</logic:notEmpty>		
						<tr>
							<td colspan="3" >
								<logic:notEmpty name="listaConfigTarefa" scope="request">
									<displaytag:table width="434px" name="listaConfigTarefa" id="configTarefa" styleClass="its" pagesize="20" requestURI="" scope="request">
										<displaytag:column style="width:10%;" title="" align="center"> 
											<a class="linkPreto" href="consultarUm.do?op=consultarUm&codigoConfigTarefa=<c:out value='${configTarefa.codigoConfigTarefa}'/>">
												<c:out value="${configTarefa.codigoConfigTarefa}"/>
											</a>
										</displaytag:column>
										<displaytag:column style="width:75%;" title="" align="left">
											<a class="linkPreto" href="consultarUm.do?op=consultarUm&codigoConfigTarefa=<c:out value='${configTarefa.codigoConfigTarefa}'/>">
												<c:out value="${configTarefa.textoConfigTarefa}"/>
											</a>
										</displaytag:column>
										<c:if test="${configTarefa.indTipoVigencia == 'N'}">																							
											<displaytag:column style="width:15%;" title="" align="center">
												<a class="linkPreto" href="consultarUm.do?op=consultarUm&codigoConfigTarefa=<c:out value='${configTarefa.codigoConfigTarefa}'/>">
													<bean:message key="pro.label.option.nao" />
												</a>
											</displaytag:column>
										</c:if>
										<c:if test="${configTarefa.indTipoVigencia == 'S'}">												
											<displaytag:column style="width:15%;" title="" align="center">
												<a class="linkPreto" href="consultarUm.do?op=consultarUm&codigoConfigTarefa=<c:out value='${configTarefa.codigoConfigTarefa}'/>">
													<bean:message key="pro.label.option.sim" />
												</a>
											</displaytag:column>
										</c:if>
										
									</displaytag:table>
									</br></br>
									<table width="100%" border="0">
										<tr>
											<td align="right">
												<button type="submit" class="botaoPreto" style="vertical-align: middle">
													<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
													<bean:message key="pro.botao.pesquisar"/>
												</button>
											</td>
										</tr>
									</table>
								</logic:notEmpty>		
							</td>
						</tr>
					</table>	
				</td>
			</tr>
		</table>
		<logic:empty name="listaConfigTarefa" scope="request">
			<table width="435px" border="0">
				<tr>
					<td align="right" colspan="3" >
						<button type="submit" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.pesquisar"/>
						</button>
					</td>
				</tr>
			</table>
		</logic:empty>
</html:form>

