<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");%>
<script language = "JavaScript">
	function encaminhaTarefa(){
		var codMapa = <%=codMapa%>
		var codPers = document.perspectivaForm.id.value;
		document.perspectivaForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusaoMapa&codMapa="+0+"&codPerspectiva="+codPers+"&codObjetivo="+0+"&codIndicador="+0;
		document.perspectivaForm.submit();
	}
	
	function vincularTarefa(){
		var codMapa = <%=codMapa%>
		var codTar = document.perspectivaForm.codTarefa.value;
		if (codTar != ''){
			var codPerspectiva = document.perspectivaForm.id.value;
			document.perspectivaForm.action = "<c:out value="${base}"/>/perspectiva/tarefa.do?op=vincularTarefa&codTarefa="+codTar+"&codPerspectiva="+codPerspectiva+"&codMapa="+0+"&codIndicador="+0+"&codObjetivo="+0;
			document.perspectivaForm.submit();
		}else{
			alert("Selecione uma tarefa.");	
		}
	}
	
	function excluirTarefa(codTarefaParan,anoParan,codPerspectiva){
		document.perspectivaForm.action = "<c:out value="${base}"/>/perspectiva/tarefa.do?op=excluirTarefa&codTarefa="+codTarefaParan+"&ano="+anoParan+"&codPerspectiva="+codPerspectiva;
		document.perspectivaForm.submit();
	}
	
</script>

<html:html>
	<html:form action="/perspectiva/manutencao.do?op=alterar" onsubmit="return validatePerspectivaForm(this);">
		<html:hidden property="id"/>
		<table width="400px" border="0" cellspacing="0" cellpadding="0">

			<tr>
			    <td colspan="2" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarperspectiva"/></td>  
			</tr>
			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="110" size="62"/></td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.numeroOrdem"/></td>
				<td><bean:message key="bsc.campo.tipoPerspectiva"/></td>
			</tr>
			<tr>
				<td><html:text property="ordem" maxlength="3" size="10"/></td>
				<td align="right">
					<html:select property="tipoPerspectiva" style="width:300px" >
						<html:option value=""></html:option>
						<html:options collection="listaTipoPerspectiva" property="id" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2" widht="100%"><html:textarea name="perspectivaForm" property="descricao" cols="70" rows="5" style="width:400px"/></td>
			</tr>
		</table>
		<table width="400px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><bean:message key="bsc.campo.responsavel"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="responsavel" style="width:335px">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
				<td align="right">
				
					<html:select property="ativo" style="width:55px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr height="10px">
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="right" colspan="3">
					<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle">
						<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.voltar"/>
					</button>
					<button type="submit" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
			
					<button type="button" onclick="javascript: encaminhaTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/tarefa.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="bsc.botao.incluirTarefa"/>
					</button>
				</td>
			</tr>
		</table>
		<c:if test="${listaTarefas ne '' and not empty listaTarefas}">
			<table width="400px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td colspan="2">
						<bean:message key="bsc.botao.tarefa"/>
					</td>
				</tr>
				<tr>
					<td>
						<html:select property="codTarefa" style="width:400px" onchange="setaCodTarefa();">
							<html:option value=""></html:option>
							<html:options collection="listaTarefas" property="codigo" labelProperty="nome" />
						</html:select>
					</td>
				</tr>
				<tr height="10px">
				<td>&nbsp;</td>
				</tr>
				<tr align="right">
					<td>
					<button type="button" onclick="vincularTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.vincular"/>
					</button>
					</td>
				</tr>
			</table>
		</c:if>
		<br>
		<c:if test="${listaTarefasPerspectiva ne '' and not empty listaTarefasPerspectiva}">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="400px">
						<bean:message key="bsc.campo.tarefasVinculadas"/>
					</td>
				<tr>
				<tr height="3">
					<td>
						<displaytag:table width="400px" name="listaTarefasPerspectiva" id="lista" styleClass="its" pagesize="5" requestURI="" scope="session">
							<displaytag:column style="width:90%;" title="" align="left">
							<a href="<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<c:out value="${lista.anoCriacao}"/>&codigo=<c:out value="${lista.codigo}"/>">
								<c:out value="${lista.nome}"/>
							</a>
							</displaytag:column>
							<displaytag:column style="width:10%;" title="" align="center">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" title="Excluir Tarefa" onclick="excluirTarefa(<c:out value='${lista.codigo}'/>,<c:out value='${lista.anoCriacao}'/>,<c:out value='${perspectivaForm.id}'/>);">
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</c:if>
	</html:form>
	<html:javascript formName="perspectivaForm" />
</html:html>