<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="br.com.intraBSC.negocio.UsuarioBO"%>


<script>
	function alterar(){
		if (document.usuarioForm.senha.value == document.usuarioForm.confirmaSenha.value){
			if((document.usuarioForm.senhaAtual.value != "") &&
			   (document.usuarioForm.senha.value != "") &&
			   (document.usuarioForm.confirmaSenha.value != "")){
				document.usuarioForm.action="<c:out value="${base}"/>/usuario/alterarSenha.do?op=alterarSenha";
				document.usuarioForm.submit();
			}else{
				alert("Todos os campos sao obrigatorios");
			}
		}else{
			alert("O Campo senha deve ser igual ao campo de confirmass�o.");
		}
	}	
</script>

<html:form action="/usuario/alterar">
	<html:hidden property="op" value="alterarSenha"/>
	<input type="hidden" name="idUsuario" value="<c:out value="${usuarioForm.idUsuario}"/>"/>
	<table border="0" width="445px">
		<tr height="3"><td>&nbsp;</td></tr>
		<tr>
		    <td colspan="4" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.botao.alterarSenha"/></td>  
		</tr>
		
		<tr>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.login"/></td>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.senhaAtual"/></td>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.senha"/></td>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.confirmaSenha"/></td>
		</tr>
		<tr>
			<td>
				<html:text property="login" maxlength="10" size="12%" disabled="true"/>
			</td>
			<td width="20%">
				<html:password maxlength="8" size="12%" property="senhaAtual"/>
			</td>
			<td>
				<html:password maxlength="8" size="15%" property="senha"/>
			</td>
			<td>
				<html:password maxlength="8" size="15%" property="confirmaSenha"/>
			</td>
		</tr>
	</table>
	<table border="0" width="445px">
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
