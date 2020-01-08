<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/funcoes.js"></script>
<script>
	function incluir(){
		if (document.usuarioForm.senha.value == document.usuarioForm.confirmaSenha.value){
			if (validateUsuarioForm(document.usuarioForm)){
				document.usuarioForm.action="<c:out value="${base}"/>/usuario/incluir.do?op=incluir";
				document.usuarioForm.submit();
			}else{
				return false;
			}
		}else{
			alert("O Campo senha deve ser igual ao campo de confirmassão.");
			return false;
		}
	}	

</script>

<html:form action="/usuario/incluir">
	<html:hidden property="op" value="incluir"/>
	<table border="0" width="415px">
		<tr height="3">
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirusuario"/></td>  
		</tr>
		
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.nome"/></td>
		</tr>
		<tr>
			<td colspan="4"><html:text maxlength="50" size="63" property="nome"/></td>
		</tr>
		<tr>
			<td width="20px" class="txtPreto" align="left"><bean:message key="bsc.campo.telefone"/></td>
			<td colspan="3" class="txtPreto" align="left"><bean:message key="bsc.campo.email"/></td>
		</tr>
		<tr>
			<td widht="100px"><html:text maxlength="13" size="15" property="telefone" onkeypress="formata(this, '(##)####-####');"/></td>		
			<td colspan="3"><html:text maxlength="50" size="42" property="email"/></td>
		</tr>
		<tr>
			<td width="20px" class="txtPreto" align="left"><bean:message key="bsc.campo.login"/></td>
			<td width="20%" class="txtPreto" align="left"><bean:message key="bsc.campo.senha"/></td>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.confirmaSenha"/></td>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.perfil"/></td>
		</tr>
		<tr>
			<td width="20px"><html:text maxlength="10" size="15" property="login" value=""/></td>		
			<td width="20%"><html:password maxlength="8" size="7" property="senha" value=""/></td>		
			<td><html:password maxlength="8" size="7" property="confirmaSenha" value=""/></td>
			<td>
				<html:select property="perfil" style="width:130px">
					<html:option value=""></html:option>
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
				<html:select property="idGrupo" style="width:415px">
					<html:option value=""></html:option>
						<html:options collection="listaGrupo" property="codigo" labelProperty="descricao" />
				</html:select>
			</td>
		</tr>
		<tr height="3">
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="415px" border="0">
		<tr>
			<td align="right" >
				<button type="button" onclick="incluir();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
				</button>	
				
			</td>
		</tr>
	</table>
	<html:javascript formName="usuarioForm"/>
</html:form>
