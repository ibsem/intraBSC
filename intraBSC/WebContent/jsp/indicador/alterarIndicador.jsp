<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<%Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");%>
<script language = "JavaScript">
	function encaminhaMeta(){
		document.indicadorForm.action = "<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=encaminhaIncluirConfiguracao&codIndicador="+document.indicadorForm.idIndicador.value+"&nomeIndicador="+document.indicadorForm.nome.value;
		document.indicadorForm.submit();
	}
	function encaminhaTarefa(){
		var codMapa = <%=codMapa%>
		var codPers = 0;
		var codObj = 0;
		var codInd = document.indicadorForm.idIndicador.value;
		document.indicadorForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusaoMapa&codMapa="+0+"&codPerspectiva="+0+"&codObjetivo="+0+"&codIndicador="+codInd;
		document.indicadorForm.submit();
	}
	function excluirTarefa(codTarefaParan,anoParan,codIndParan){
		document.indicadorForm.action = "<c:out value="${base}"/>/indicador/excluir/tarefa.do?op=excluirTarefa&codTarefa="+codTarefaParan+"&ano="+anoParan+"&codInd="+codIndParan;
		document.indicadorForm.submit();
	}
	
	function vincularTarefa(){
		var codMapa = <%=codMapa%>
		var codTar = document.indicadorForm.codTarefa.value;
		if (codTar != ''){
			var codInd = document.indicadorForm.idIndicador.value;
			document.indicadorForm.action = "<c:out value="${base}"/>/indicador/excluir/tarefa.do?op=vincularTarefa&codTarefa="+codTar+"&codIndicador="+codInd+"&codMapa="+0+"&codMapa="+0+"&codPerspectiva="+0+"&codObjetivo="+0;
			document.indicadorForm.submit();
		}else{
			alert("Selecione uma tarefa.");	
		}
	}
</script>

<html:html>
	<html:form action="/indicador/manutencao.do?op=alterar" onsubmit="return validateIndicadorForm(this);">
		<html:hidden property="idIndicador"/>
		<html:hidden property="idPerspectiva"/>
		<table width="400px" border="0" cellspacing="0" cellpadding="0">
			<tr>
			    <td colspan="3" valign="middle" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarindicador"/></td>  
			</tr>
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="3"><html:text property="nome" maxlength="100" size="59" style="width:400px"/></td>
			</tr>			
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="3"><html:textarea name="indicadorForm" property="descricao" cols="66" rows="5" style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.responsavel"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<html:select property="idResponsavel" style="width:400">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="3"><bean:message key="bsc.campo.objetivo"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<html:select property="idObjetivo" style="width:400">
						<html:option value=""></html:option>
						<html:options collection="listaObjetivo" property="id" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.unidade"/></td>
				<td><bean:message key="bsc.campo.periodicidade"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="unidade" style="width:150">
						<html:option value=""></html:option>
						<html:options collection="listaUnidade" property="id" labelProperty="nome" />
					</html:select>
				</td>
				<td>
					<html:select property="periodicidade" style="width:150">
						<html:option value=""></html:option>
						<html:options collection="listaPeriodicidade" property="id" labelProperty="nome" />
					</html:select>
				</td>
				<td align="right">
					<html:select property="ativo" style="width:50px;">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr height="10px">
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="right" width="400px" colspan="5">
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
					
					<button type="button" onclick="encaminhaMeta();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/meta.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="bsc.botao.meta"/>
					</button>
				</td>
			</tr>
		</table>
		<br>
		<c:if test="${listaTarefas ne '' and not empty listaTarefas}">
			<table width="380px" border="0" cellspacing="0" cellpadding="0">
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
						<bean:message key="pro.botao.adicionar"/>
					</button>
					</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${listaTarefasIndicador ne '' and not empty listaTarefasIndicador}">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="400px" >
						<u><bean:message key="bsc.campo.tarefasVinculadas"/></u>
					</td>
				<tr>
				<tr height="3">
					<td>
						<displaytag:table width="400px" name="listaTarefasIndicador" id="lista" styleClass="its" pagesize="5" requestURI="" scope="session">
							<displaytag:column style=" width:90%;height:0;" title="" align="left">
							<a href="<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<c:out value="${lista.anoCriacao}"/>&codigo=<c:out value="${lista.codigo}"/>">
								<c:out value="${lista.nome}"/>
							</a>
							</displaytag:column>
							<displaytag:column style="width:10%;" title="" align="center">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" title="Excluir Tarefa" onclick="excluirTarefa(<c:out value='${lista.codigo}'/>,<c:out value='${lista.anoCriacao}'/>,<c:out value='${indicadorForm.idIndicador}'/>);">
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${ not empty listaMetas}">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr height="3">
					<td>&nbsp;
					</td>
				</tr>
			<tr>
					<td width="400px" >
						<u><bean:message key="bsc.label.metas"/></u>
					</td>
			<tr>
			<tr height="3">
			<td>
			<displaytag:table width="400px" name="listaMetas" id="meta" styleClass="its" pagesize="20" requestURI="" scope="request">
				<displaytag:column style="width:200px;height:0;" title="" align="left"> 
					<a href="<c:out value="${base}"/>/meta/encaminhar/configuracao.do?op=consultarUm&codMeta=<c:out value='${meta.id}'/>&codIndicador=<c:out value='${meta.idIndicador}'/>&nomeIndicador=<c:out value='${metaForm.nomeIndicador}'/>">
						<c:out value="${meta.nome}"/>
					</a>
				</displaytag:column>
			</displaytag:table>
			</td>
			</tr>
			</table>
		</c:if>
		<html:javascript formName="indicadorForm" />
	</html:form>
</html:html>
