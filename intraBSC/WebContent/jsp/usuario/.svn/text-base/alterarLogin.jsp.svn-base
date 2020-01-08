<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="br.com.intraBSC.negocio.UsuarioBO"%>


<script>
	function alterar(){
		
		if((document.usuarioForm.senhaAtual.value != "") && (document.usuarioForm.login.value != "")){
			document.usuarioForm.action="<c:out value="${base}"/>/usuario/alterarLogin.do?op=alterarLogin";
			document.usuarioForm.submit();
		}else{
			alert("Todos os campos sao obrigatorios");
		}
	}	
</script>

<html:form action="/usuario/alterarLogin">
	<html:hidden property="op" value="alterarLogin"/>
	<input type="hidden" name="idUsuario" value="<c:out value="${usuarioForm.idUsuario}"/>"/>
	<table border="0" width="245px">
		<tr height="3"><td>&nbsp;</td></tr>
		<tr>
		    <td colspan="4" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.botao.alterarLogin"/></td>  
		</tr>
		<tr>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.login"/></td>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.senhaAtual"/></td>
		</tr>
		<tr>
			<td>
				<html:text property="login" maxlength="20" size="12%" disabled="false"/>
			</td>
			<td width="20%">
				<html:password maxlength="8" size="12%" property="senhaAtual"/>
			</td>
		</tr>
	</table>
	<table border="0" width="245px">
		<tr>
			<td align="right" colspan="2">
				<button type="button" onclick="alterar();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
				</button>		
			</td>
		</tr>
	</table>
</html:form>
