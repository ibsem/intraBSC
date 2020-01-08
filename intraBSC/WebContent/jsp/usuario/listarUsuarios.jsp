<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>

<script type="text/javascript">
	function imprimirListaUsuario(){
		document.usuarioForm.action="<c:out value="${base}"/>/usuario/imprimir.do?op=imprimirUsuario";	
		document.usuarioForm.submit();
	}
</script>

<html:html>
	<body>
		<html:form action="/usuario/imprimir">
			<html:hidden property="op" value="consultarVarios"/>
			<br>
			<table border="0" cellspacing="0" cellpadding="0" width="900px">
				<tr>
				    <td valign="middle" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarusuario"/><br></td>  
				</tr>
				
			</table>
			<br>
			<table border="0" cellspacing="0" cellpadding="0" width="900px" >
					<td width="300px" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="200px" align="left">
						<u><bean:message key="bsc.label.grupo"/></u>
					</td>
					<td width="100px" align="left">
						<u><bean:message key="bsc.label.fone"/></u>
					</td>
					<td width="150px" align="left">
						<u><bean:message key="bsc.label.perfil"/></u>
					</td>
					<td width="100px" align="left">
						<u><bean:message key="bsc.label.login"/></u>
					</td>
			</table>
			<table border="0" width="900px">
				<logic:notEmpty name="listaUsuarios">
								
			</logic:notEmpty>
				
				<tr>
					<td colspan="5">
						<logic:present name="listaUsuarios">
							<displaytag:table width="900px" name="listaUsuarios" id="usuario" styleClass="its" pagesize="20" requestURI="" scope="session">
								<displaytag:column style="width:300px;" title="" align="left"> 
									<a href="<c:out value="${base}"/>/usuario/consultarUm.do?op=consultarUm&codigo=<c:out value="${usuario.idUsuario}"/>">
										<c:out value="${usuario.nome}"/>
									</a>
								</displaytag:column>
								<displaytag:column style="width:200px;" title="" align="left"> 
									<a href="<c:out value="${base}"/>/usuario/consultarUm.do?op=consultarUm&codigo=<c:out value="${usuario.idUsuario}"/>">
										<c:out value="${usuario.grupoTO.descricao}"/>
									</a>
								</displaytag:column>
								<displaytag:column style="width:100px;" title="" align="left"> 
									<a href="<c:out value="${base}"/>/usuario/consultarUm.do?op=consultarUm&codigo=<c:out value="${usuario.idUsuario}"/>">
										<c:out value="${usuario.telefone}"/>
									</a>
								</displaytag:column>
								<displaytag:column style="width:150px;" title="" align="left"> 
									<a href="<c:out value="${base}"/>/usuario/consultarUm.do?op=consultarUm&codigo=<c:out value="${usuario.idUsuario}"/>">
										<c:out value="${usuario.perfil}"/>
									</a>
								</displaytag:column>
								<displaytag:column style="width:100px;" title="" align="left"> 
									<a href="<c:out value="${base}"/>/usuario/consultarUm.do?op=consultarUm&codigo=<c:out value="${usuario.idUsuario}"/>">
										<c:out value="${usuario.login}"/>
									</a>
								</displaytag:column>
							</displaytag:table>
						</logic:present>
					</td>
				</tr>
			</table><br>
			<table width="900px">
				<tr>
					<td align="right" style="width:900px;">
						<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.voltar"/>
						</button>
					</td>
					<td align="right">
						<button type="button" onclick="imprimirListaUsuario();" class="botaoPreto" style="vertical-align: middle; width:90px;">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.imprimir"/>
						</button>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html:html>