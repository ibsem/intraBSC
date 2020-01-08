<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag"%>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function salvar(){
		if (validateMetaForm(document.metaForm)){
			if(confirm("A meta que esta Ativa para este indicador passará a ser Inativo. Confirma alteração?")){
				document.metaForm.action = "<c:out value="${base}"/>/meta/manutencao.do?op=incluir";
				document.metaForm.submit();
			}
		}else{
			return false;
		}
	}
	function consultar(){
		document.metaForm.action = "<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=encaminharConsultarVarios";
		document.metaForm.submit();
	}
</script>

<html:form action="/meta/manutencao" onsubmit="return validateMetaForm(this)">
	<html:hidden property="op" value="incluir"/>
	<html:hidden property="idIndicador"/>
	<html:hidden property="nomeIndicador"/>
	<table border="0" width="40%" cellspacing="0" cellpadding="0">
		<tr height="3">
				<td>&nbsp;</td>
			</tr>
			<tr>
			    <td colspan="4" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.incluirmeta"/></td>  
			</tr>
			
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.nome"/></td>
		</tr>
		<tr>
			<td colspan="4" ><html:text maxlength="50" size="57%" property="nome"/></td>
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.descricao"/></td>			
		</tr>
		<tr>
			<td colspan="4"><html:textarea property="descricao" cols="64" rows="3"/></td>
		</tr>
		<tr>
			<td colspan="4" class="txtPreto" align="left"><bean:message key="bsc.campo.indicador"/></td>
		</tr>
		<tr>
			<td colspan="4"><html:text maxlength="50" size="57%" property="nomeIndicador" disabled="true"/></td>
		</tr>
	</table>
	<table border="0" style="width:320px" cellspacing="0" cellpadding="0">
		<tr>
			<td style="width:85px" align="left"><bean:message key="bsc.campo.limiteSuperior"/></td>
			<td style="width:90px" align="left"><bean:message key="bsc.campo.limiteInferior"/></td>
			<td style="width:40px" align="left"><bean:message key="bsc.campo.ativo"/></td>
			<td style="width:120px" align="left"><bean:message key="bsc.campo.inversaoLimite"/></td>
		</tr>
		<tr>
			<c:if test="${metaForm.limiteSuperior != 0}">
				<td><html:text maxlength="10" size="10" property="limiteSuperior"/></td>
			</c:if>
			<c:if test="${metaForm.limiteSuperior == 0}">
				<td><html:text maxlength="10" size="10" property="limiteSuperior" value=""/></td>
			</c:if>
			<c:if test="${metaForm.limiteInferior != 0}">
				<td><html:text maxlength="10" size="10" property="limiteInferior"/></td>
			</c:if>
			<c:if test="${metaForm.limiteInferior == 0}">
				<td><html:text maxlength="10" size="10" property="limiteInferior" value=""/></td>
			</c:if>
			<td>
				<html:select property="ativo" style="width:50px">
					<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
				</html:select>
			</td>
			<td>
				<html:select property="inversaoSinal" style="width:120px">
					<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<td colspan="4" width="10%" class="txtPreto" align="left"><bean:message key="bsc.campo.responsavel"/></td>
		</tr>
		<tr>
			<td colspan="4">
				<html:select property="responsavel" style="width:368px">
					<html:option value=""></html:option>
					<c:if test="${listaResponsavel ne null}">
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</c:if>
				</html:select>
			</td>
		</tr>	
	</table>
	<table border="0" width="98%">
		<tr>
			<td align="right">

			<button type="button" property="" onclick="salvar();" class="botaoPreto" style="vertical-align: middle">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.salvar"/>
			</button>
			</td>
			<td width="100px" align="right">

				<button type="button" onclick="consultar();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.pesquisar"/>
				</button>			
			</td>			
		</tr>
	</table>
	<html:javascript formName="metaForm" />
</html:form>