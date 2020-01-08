<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function salvar(){
		if (validateMetaForm(document.metaForm)){
			if (document.metaForm.auxMudancaAtivo.value != ""){
				if (document.metaForm.auxMudancaAtivo.value == "1"){
					if(confirm("A meta que esta Ativa para este indicador passará a ser Inativo. Confirma alteração?")){
						document.metaForm.action = "<c:out value="${base}"/>/meta/manutencao.do?op=alterar";
						document.metaForm.submit();
					}
				}else{
					if(confirm("A meta que esta Inativa para este indicador passará a ser Ativo. Confirma alteração?")){
						document.metaForm.action = "<c:out value="${base}"/>/meta/manutencao.do?op=alterar";
						document.metaForm.submit();
					}
				}
			}else{
				document.metaForm.action = "<c:out value="${base}"/>/meta/manutencao.do?op=alterar";
				document.metaForm.submit();
			}
		}else{
			return false;
		}
	}
	
	function excluir(){
		if(confirm("Confirma Exclusão da Meta?")){
				document.metaForm.action = "<c:out value="${base}"/>/meta/manutencao.do?op=excluir";
				document.metaForm.submit();
		}
	}
	function consultar(){
		document.metaForm.action = "<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=encaminharConsultarVarios";
		document.metaForm.submit();
	}
	function mudaAtivo(campo){
		if (campo.value == "2"){
			document.metaForm.auxMudancaAtivo.value = "1";
		}else{
			document.metaForm.auxMudancaAtivo.value = "2";
		}
	}
</script>

<html:form action="/meta/manutencao" onsubmit="return validateMetaForm(this)">
	<html:hidden property="op" value="alterar"/>
	<html:hidden property="auxMudancaAtivo" value=""/><!-- Esta variavel guarda o valor do campo ativo caso o usuario modifique-o -->
	<html:hidden property="id"/>
	<html:hidden property="idIndicador"/>
	<html:hidden property="nomeIndicador"/>

<table border="0" width="379px" cellspacing="0" cellpadding="0">
		<tr>
		    <td colspan="4" valign="center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarmeta"/></td>  
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.nome"/></td>
		</tr>
		<tr>
			<td colspan="4" ><html:text maxlength="50" size="58" property="nome"/></td>
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.descricao"/></td>			
		</tr>
		<tr>
			<td colspan="4"><html:textarea property="descricao" cols="66" rows="3"/></td>
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.indicador"/></td>
		</tr>
		<tr>
			<td colspan="4"><html:text maxlength="50" size="58" property="nomeIndicador" disabled="true"/></td>
		</tr>
		<tr>
			<td style="width:30px" class="txtPreto" align="left"><bean:message key="bsc.campo.limiteSuperior"/></td>
			<td style="width:30px" class="txtPreto" align="left"><bean:message key="bsc.campo.limiteInferior"/></td>
			<td width="width:40px" class="txtPreto" align="left"><bean:message key="bsc.campo.ativo"/></td>
			<td width="width:40px" class="txtPreto" align="left"><bean:message key="bsc.campo.inversaoLimite"/></td>
		</tr>
		<tr>
			<c:if test="${metaForm.limiteSuperior != 0}">
				<td><html:text maxlength="10" size="12" property="limiteSuperior"/></td>
			</c:if>
			<c:if test="${metaForm.limiteSuperior == 0}">
				<td><html:text maxlength="10" size="12" property="limiteSuperior" value=""/></td>
			</c:if>
			<c:if test="${metaForm.limiteInferior != 0}">
				<td><html:text maxlength="10" size="10" property="limiteInferior"/></td>
			</c:if>
			<c:if test="${metaForm.limiteInferior == 0}">
				<td><html:text maxlength="10" size="10" property="limiteInferior" value=""/></td>
			</c:if>
			<td align="right">
				<html:select property="ativo" style="width:50px" onchange="mudaAtivo(this)">
					<html:option value="1.00000"><bean:message key="bsc.label.sim"/></html:option>
					<html:option value="2.00000"><bean:message key="bsc.label.nao"/></html:option>
				</html:select>
			</td>
			<td align="right">
				<html:select property="inversaoSinal" style="width:120px">
					<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<td colspan="4" width="15px" class="txtPreto" align="left"><bean:message key="bsc.campo.responsavel"/></td>
		</tr>
		<tr>
			<td colspan="4">
				<html:select property="responsavel" style="width:375px">
					<html:option value=""></html:option>
					<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
				</html:select>
			</td>
		</tr>	
	</table>
	<table border="0" width="380px">
		<tr>
			<td width="150px" align="right">
			<button type="button" property="" onclick="salvar();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.salvar"/>
			</button>
			</td>
			<td width="60px" align="right">
			<button type="button" property="" onclick="excluir();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="bsc.botao.excluir"/>
			</button>
			</td>
			<td width="70px" align="right">
			<button type="button" property="" onclick="consultar();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.pesquisar"/>
			</button>
			
			</td>			
		</tr>
	</table>

	<html:javascript formName="metaForm" />
</html:form>