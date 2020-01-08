<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>

<script>
	function alterar(){
		if((document.usuarioForm.nome.value != "") &&
			   (document.usuarioForm.telefone.value != "") &&
			   (document.usuarioForm.email.value != "")){
				document.usuarioForm.action="<c:out value="${base}"/>/usuario/alterar.do?op=alterar";
				document.usuarioForm.submit();
			}else{
				alert("Todos os campos sao obrigatorios");
			}
	}
	function excluir(){
		if(document.usuarioForm.senhaAtual.value != ""){
			if (confirm("Confirma a exclusão do usuario?")){
				document.usuarioForm.action="<c:out value="${base}"/>/usuario/excluir.do?op=excluir";
				document.usuarioForm.submit();
			}
		}else{
			alert("Campo senha é obrigatório");
		}
	}
	
	function alterarSenha(){
		var login = "<c:out value='${usuarioForm.login}'/>";
		var id = document.usuarioForm.idUsuario.value;
		document.usuarioForm.action="<c:out value="${base}"/>/usuario/encaminhar/alterarSenha.do?op=encaminharAlterarSenha&idUsuario="+id;
		document.usuarioForm.submit();
	}
	function alterarLogin(){
		var id = document.usuarioForm.idUsuario.value;
		document.usuarioForm.action="<c:out value="${base}"/>/usuario/encaminhar/alterarLogin.do?op=encaminharAlterarLogin&idUsuario="+id;
		document.usuarioForm.submit();
	}
</script>

<html:form action="/usuario/alterar">
	<html:hidden property="op" value="alterar"/>
	<input type="hidden" name="idUsuario" value="<c:out value="${usuarioForm.idUsuario}"/>"/>
	<input type="hidden" name="login" value="<c:out value="${usuarioForm.login}"/>"/>
	<table border="0" width="350px">
		<tr height="3"><td>&nbsp;</td></tr>
		<tr>
		    <td colspan="3" valign="middle" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarusuario"/></td>  
		</tr>
		<tr>
			<td colspan="3" class="txtPreto" align="left"><bean:message key="bsc.campo.nome"/></td>
		</tr>
		<tr>
			<td colspan="3"><html:text maxlength="50" size="57%" property="nome"/></td>
		</tr>
		<tr>
			<td width="10%" class="txtPreto" align="left"><bean:message key="bsc.campo.telefone"/></td>
			<td  class="txtPreto" align="left"><bean:message key="bsc.campo.email"/></td>
		</tr>
		<tr>			
			<td width="10%"><html:text maxlength="13" size="13%" property="telefone" onblur="formataTelefone(this);"/></td>		
			<td colspan="2"><html:text maxlength="50" size="39" property="email"/></td>			
		</tr>
		<c:if test="${(usuarioBSC.perfil eq 'administrador')}">
			<tr>
				<td colspan="2" class="txtPreto" align="left"><bean:message key="bsc.campo.perfil"/></td>
			</tr>
			<tr>
				<td colspan="2" width="300px">
					<html:select property="perfil" style="width:365px">
						<html:option value="administrador"><bean:message key="bsc.option.perfil.administrador"/></html:option>
						<html:option value="gerentegeral"><bean:message key="bsc.option.perfil.gerente.geral"/></html:option>
						<html:option value="gerenteplanejamento"><bean:message key="bsc.option.perfil.gerente.planejamento"/></html:option>
						<html:option value="gerenteprocesso"><bean:message key="bsc.option.perfil.gerente.processo"/></html:option>
						<html:option value="funcionarioplanejamento"><bean:message key="bsc.option.perfil.funcionario.planejamento"/></html:option>
						<html:option value="funcionarioprocesso"><bean:message key="bsc.option.perfil.funcionario.processo"/></html:option>
						<html:option value="funcionario"><bean:message key="bsc.option.perfil.funcionario"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.grupo"/></td>
			</tr>
			<tr>
				<td colspan="4">
					<html:select name="usuarioForm" property="idGrupo" style="width:365px">
						<html:options collection="listaGrupo" property="codigo" labelProperty="descricao" />
					</html:select>
				</td>
			</tr>
		</c:if>
	</table>
	<table border="0" width="376px">
		<tr>
			<td align="right">
			<button type="button" onclick="alterar();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.salvar"/>
			</button>		
			<!--  <button type="button" onclick="excluir();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.excluir"/>
			</button>-->
			<button  type="button" onclick="alterarSenha();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="bsc.botao.alterarSenha"/>
			</button>
			<button  type="button" onclick="alterarLogin();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="bsc.botao.alterarLogin"/>
			</button>
			</td>
		</tr>
	</table>
	<html:javascript formName="usuarioForm"/>
</html:form>
