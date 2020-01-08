<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/funcoes.js"></script>
<script>

	function consultar(){
		if ((document.usuarioForm.nome.value != "") ||
		    (document.usuarioForm.email.value != "") ||
		    (document.usuarioForm.idGrupo.value != "") || 
		    (document.usuarioForm.perfil.value != "")){
				document.usuarioForm.action="<c:out value="${base}"/>/usuario/consultar.do?op=consultarVarios";
				document.usuarioForm.submit();
		}else if ((document.usuarioForm.senha.value != "") ||
		          (document.usuarioForm.confirmaSenha.value != "")){
			alert("Os campos Senha e Confirmação de Senha nao podem ser utilizados na consulta de dados.");
			return false;
		}else{
			alert("Para realizar esta operação é necessário digitar algum dado.");
			return false;
		}
	}
	
</script>

<html:form action="/usuario/incluir">
	<html:hidden property="op" value="incluir"/>
	<table border="0" width="360px">
		<tr height="3">
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarusuario"/></td>  
		</tr>
		
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.nome"/></td>
		</tr>
		<tr>
			<td colspan="4"><html:text maxlength="50" size="62" property="nome"/></td>
		</tr>
		<tr>
			<td colspan="3" class="txtPreto" align="left"><bean:message key="bsc.campo.email"/></td>
		</tr>
		<tr>
			<td colspan="3"><html:text maxlength="50" size="42" property="email"/></td>
		</tr>
		<tr>
			<td class="txtPreto" align="left"><bean:message key="bsc.campo.perfil"/></td>
		</tr>
		<tr>
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
				<html:select property="idGrupo" style="width:395px">
					<html:option value=""></html:option>
						<html:options collection="listaGrupo" property="codigo" labelProperty="descricao" />
				</html:select>
			</td>
		</tr>
	</table>
	<table width="387px" border="0">
		<tr>
			<td align="right" >

				<button type="button" onclick="consultar();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.pesquisar"/>
				</button>
			</td>
		</tr>
	</table>
	<html:javascript formName="usuarioForm"/>
</html:form>
