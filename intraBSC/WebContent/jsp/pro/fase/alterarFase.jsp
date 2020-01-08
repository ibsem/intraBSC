<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%Integer codProcesso = (Integer) request.getSession().getAttribute("codProcessoArvoreConfiguracao");%>
<script language = "JavaScript">
	function encaminhaTarefa(){
		var codProcesso = <%=codProcesso%>
		var codPers = document.faseForm.id.value;
		document.faseForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusaoProcesso&codProcesso="+codProcesso+"&codFase="+codPers+"&codAtividade="+0;
		document.faseForm.submit();
	}
	
	function vincularTarefa(){
		var codProcesso = <%=codProcesso%>
		var codTar = document.faseForm.codTarefa.value;
		if (codTar != ''){
			var codFase = document.faseForm.id.value;
			document.faseForm.action = "<c:out value="${base}"/>/fase/tarefa.do?op=vincularTarefa&codTarefa="+codTar+"&codFase="+codFase+"&codProcesso="+codProcesso;
			document.faseForm.submit();
		}else{
			alert("Selecione uma tarefa.");	
		}
	}
	
	function excluirTarefa(codTarefaParan,anoParan,codFase){
		document.faseForm.action = "<c:out value="${base}"/>/fase/tarefa.do?op=excluirTarefa&codTarefa="+codTarefaParan+"&ano="+anoParan+"&codFase="+codFase;
		document.faseForm.submit();
	}
	
</script>

<html:html>
	<html:form action="/fase/manutencao.do?op=alterar" onsubmit="return validateFaseForm(this);">
		<html:hidden property="id"/>
		<table width="400px" border="0" cellspacing="0" cellpadding="0">

			<tr>
			    <td colspan="2" valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarfase"/></td>  
			</tr>
			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="110" size="62"/></td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.numeroOrdem"/></td>
			</tr>
			<tr>
				<td><html:text property="ordem" maxlength="3" size="10"/></td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2" widht="100%"><html:textarea name="faseForm" property="descricao" cols="70" rows="5" style="width:400px"/></td>
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
				<td align="right" colspan="2">
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
		<c:if test="${listaTarefasFase ne '' and not empty listaTarefasFase}">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="400px">
						<bean:message key="bsc.campo.tarefasVinculadas"/>
					</td>
				<tr>
				<tr height="3">
					<td>
						<displaytag:table width="400px" name="listaTarefasFase" id="lista" styleClass="its" pagesize="5" requestURI="" scope="session">
							<displaytag:column style="width:90%;" title="" align="left">
							<a href="<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<c:out value="${lista.anoCriacao}"/>&codigo=<c:out value="${lista.codigo}"/>">
								<c:out value="${lista.nome}"/>
							</a>
							</displaytag:column>
							<displaytag:column style="width:10%;" title="" align="center">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" title="Excluir Tarefa" onclick="excluirTarefa(<c:out value='${lista.codigo}'/>,<c:out value='${lista.anoCriacao}'/>,<c:out value='${faseForm.id}'/>);">
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</c:if>
	</html:form>
	<html:javascript formName="faseForm" />
</html:html>