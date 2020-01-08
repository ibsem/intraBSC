<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<script language = "JavaScript">
	function encaminhaTarefa(){
		var codProcesso = document.processoForm.id.value;
		document.processoForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusaoProcesso&codProcesso="+codProcesso+"&codFase="+0+"&codAtividade="+0+"&codIndicador="+0;
		document.processoForm.submit();
	}
	function vincularTarefa(){
		var codTar = document.processoForm.codTarefa.value;
		if (codTar != ''){
			var codProcesso = document.processoForm.id.value;
			document.processoForm.action = "<c:out value="${base}"/>/processo/tarefa.do?op=vincularTarefa&codTarefa="+codTar+"&codProcesso="+codProcesso;
			document.processoForm.submit();
		}else{
			alert("Selecione uma tarefa.");	
		}
	}
	
	function excluirTarefa(codTarefaParan,anoParan,codProcessoParan){
		document.processoForm.action = "<c:out value="${base}"/>/processo/tarefa.do?op=excluirTarefa&codTarefa="+codTarefaParan+"&ano="+anoParan+"&codProcesso="+codProcessoParan;
		document.processoForm.submit();
	}
</script>

<html:html>
	<html:form action="/processo/manutencao.do?op=alterar" onsubmit="return validateProcessoForm(this);">
		<input type="hidden" name="id" value="<c:out value='${processoForm.id}'/>"/>
		<table border="0" cellspacing="0" cellpadding="0" width="400px">
			
			<tr>
			    <td colspan="2" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.alterarprocesso"/></td>  
			</tr>
			
			<tr>
				<td><bean:message key="bsc.campo.nome"/></td>
				<td colspan="1"><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" maxlength="100" size="50" value="<c:out value='${processoForm.nome}'/>"/></td>
				<td >
					<html:select property="ativo" style="width:50px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<bean:message key="bsc.campo.responsavel"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<html:select property="idResponsavel" style="width:398">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
		</table>
		<table border="0"  border="0" cellspacing="0" cellpadding="0" width="400px" >
			<tr height="10px">
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="right" width="350px">
					<button type="submit" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
				<td align="right">
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
						<u><bean:message key="bsc.botao.tarefa"/></u>
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
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluir.gif" border="0" style="vertical-align: text-bottom" onmouseover="<c:out value="${base}"/>/WEB/imagens/comum/incluirSobre.gif" onmouseout="src="<c:out value='${base}'/>/WEB/imagens/comum/incluir.gif"/>
						<bean:message key="pro.botao.vincular"/>
					</button>
					</td>
				</tr>
			</table>
		</c:if>
		<br>
		<c:if test="${listaTarefasProcesso ne '' and not empty listaTarefasProcesso}">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="400px">
						<u><bean:message key="bsc.campo.tarefasVinculadas"/></u>
					</td>
				<tr>
				<tr height="3">
					<td>
						<displaytag:table width="400px" name="listaTarefasProcesso" id="lista" styleClass="its" pagesize="5" requestURI="" scope="session">
							<displaytag:column style="width:90%;" align="left">
							<a href="<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<c:out value="${lista.anoCriacao}"/>&codigo=<c:out value="${lista.codigo}"/>">
								<c:out value="${lista.nome}"/>
							</a>
							</displaytag:column>
							<displaytag:column style="width:10%;" title="" align="center">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" title="Excluir Tarefa" onclick="excluirTarefa(<c:out value='${lista.codigo}'/>,<c:out value='${lista.anoCriacao}'/>,<c:out value='${processoForm.id}'/>);">
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</c:if>
		<html:javascript formName="processoForm" />
	</html:form>
</html:html>