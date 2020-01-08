<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function consultar(){
		document.metaForm.action = "<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=consultarVarios";
		document.metaForm.submit();
	}
</script>

<html:form action="/meta/encaminhar/configuracao">
	<html:hidden property="op" value="incluir"/>
	<html:hidden property="idIndicador"/>
	<html:hidden property="nomeIndicador"/>
	<table border="0" width="40%" cellspacing="0" cellpadding="0">
		<tr height="3">
			<td>&nbsp;</td>
		</tr>
		<tr>
		    <td colspan="4" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.pesquisarmeta"/></td>  
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.indicador"/></td>
		</tr>
		<tr>
			<td colspan="4"><html:text maxlength="50" size="57%" property="nomeIndicador" disabled="true"/></td>
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.nome"/></td>
		</tr>
		<tr>
			<td colspan="4" ><html:text maxlength="50" size="57%" property="nome"/></td>
		</tr>

		<tr>
			<td width="5%" class="txtPreto" align="left"><bean:message key="bsc.campo.ativo"/></td>
			<td width="10%" class="txtPreto" align="left"><bean:message key="bsc.campo.responsavel"/></td>
		</tr>
		<tr>
			
			<td>
				<html:select property="ativo" style="width:50px">
					<html:option value=""></html:option>
					<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
					<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
				</html:select>
			</td>		
			<td>
				<html:select property="responsavel" style="width:315px">
					<html:option value=""></html:option>
					<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
				</html:select>
			</td>
		</tr>	
	</table>
	<table border="0" width="100%">
		<tr>
			<td width="300px" align="right">
				<button type="button" property="" onclick="consultar();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.pesquisar"/>
			</td>
			<td>
				<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.voltar"/>
				</button>
			</td>
		</tr>
	</table>
	
	<logic:present name="listaMetas">
	<table border="0" cellspacing="0" cellpadding="0" width="350px">
				<tr height="3">
					<td colspan="2" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.codigo"/></u>
					</td>
					<td width="60%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="10%" align="left">
						<u><bean:message key="bsc.label.ativo"/></u>
					</td>
				</tr>
		</table>
		</logic:present>	
		<table>
		<tr>
			<td>
				<logic:present name="listaMetas">
					<displaytag:table width="350px" name="listaMetas" id="meta" styleClass="its" pagesize="20" requestURI="" scope="request">
						<displaytag:column style="width:15%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=consultarUm&codMeta=<c:out value='${meta.id}'/>&codIndicador=<c:out value='${meta.idIndicador}'/>&nomeIndicador=<c:out value='${metaForm.nomeIndicador}'/>">
								<c:out value="${meta.id}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:60%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=consultarUm&codMeta=<c:out value='${meta.id}'/>&codIndicador=<c:out value='${meta.idIndicador}'/>&nomeIndicador=<c:out value='${metaForm.nomeIndicador}'/>">
								<c:out value="${meta.nome}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:10%;" title="" align="left"> 
							<a href="<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=consultarUm&codMeta=<c:out value='${meta.id}'/>&codIndicador=<c:out value='${meta.idIndicador}'/>&nomeIndicador=<c:out value='${metaForm.nomeIndicador}'/>">
								<c:if test="${meta.ativo == 2.0000}">
									<bean:message key="bsc.label.nao"/>
								</c:if>
								<c:if test="${meta.ativo == 1.0000}">
									<bean:message key="bsc.label.sim"/>
								</c:if>
							</a>
						</displaytag:column>
					</displaytag:table>
				</logic:present>
			</td>
		</tr>
	</table>
</html:form>