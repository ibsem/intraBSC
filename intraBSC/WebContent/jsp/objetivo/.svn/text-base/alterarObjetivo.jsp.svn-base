<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<%Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");%>
<script language = "JavaScript">
	function encaminharCausaEfeito(){
		document.objetivoForm.action = "<c:out value="${base}"/>/causaEfeito/manutencao.do?op=encaminhaInclusao&idObjetivo="+document.objetivoForm.id.value+"&nomeObjetivo="+document.objetivoForm.nome.value;
		document.objetivoForm.submit();
	}
	function encaminhaTarefa(){
		var codMapa = <%=codMapa%>
		var codPers = 0;
		var codObj = document.objetivoForm.id.value;
		document.objetivoForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusaoMapa&codMapa="+0+"&codPerspectiva="+0+"&codObjetivo="+codObj+"&codIndicador="+0;
		document.objetivoForm.submit();
	}
	
	function vincularTarefa(){
		var codMapa = <%=codMapa%>
		var codTar = document.objetivoForm.codTarefa.value;
		if (codTar != ''){
			var codObjetivo = document.objetivoForm.id.value;
			document.objetivoForm.action = "<c:out value="${base}"/>/objetivo/tarefa.do?op=vincularTarefa&codTarefa="+codTar+"&codObjetivo="+codObjetivo+"&codMapa="+0+"&codPerspectiva="+0+"&codIndicador="+0;
			document.objetivoForm.submit();
		}else{
			alert("Selecione uma tarefa.");	
		}
	}
	
	function excluirTarefa(codTarefaParan,anoParan,codObjetivo){
		document.objetivoForm.action = "<c:out value="${base}"/>/objetivo/tarefa.do?op=excluirTarefa&codTarefa="+codTarefaParan+"&ano="+anoParan+"&codObjetivo="+codObjetivo;
		document.objetivoForm.submit();
	}
</script>

<html:html>
	<html:form action="/objetivo/manutencao.do?op=alterar" onsubmit="return validateObjetivoForm(this);">
		<html:hidden property="id"/>
		<table border="0" cellspacing="0" cellpadding="0">
			
			<tr>
			    <td colspan="2" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.alterarobjetivo"/></td>  
			</tr>
			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="100" size="54" style="width:400px"/></td>
			</tr>			
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.descricao"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:textarea name="objetivoForm" property="descricao" cols="61" rows="5" style="width:400px"/></td>
			</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.responsavel"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<html:select property="responsavel" style="width:400">
						<html:option value=""></html:option>
						<html:options collection="listaResponsavel" property="idUsuario" labelProperty="nome" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td><bean:message key="bsc.campo.tema"/></td>
				<td><bean:message key="bsc.campo.coluna"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="idTema" style="width:330px">
						<html:option value=""></html:option>
						<html:options collection="listaTema" property="idTema" labelProperty="nomeTema" />
					</html:select>
				</td>
				<td><html:text property="coluna" maxlength="2" size="10" style="width:50px"/></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><bean:message key="bsc.campo.perspectiva"/></td>
				<td><bean:message key="bsc.campo.ativo"/></td>
				<td><bean:message key="bsc.campo.linha"/></td>
			</tr>
			<tr>
				<td>
					<html:select property="idPerspectiva" style="width:285px">
						<html:option value=""></html:option>
						<html:options collection="listaPerspectiva" property="id" labelProperty="nome" />
					</html:select>
				</td>
				<td>
					<html:select property="ativo" style="width:50px">
						<html:option value="1"><bean:message key="bsc.label.sim"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.nao"/></html:option>
					</html:select>
				</td>
				<td>
					<html:select property="linha" style="width:50px">
						<html:option value="-6"><bean:message key="bsc.label.menosseis"/></html:option>
					    <html:option value="-5"><bean:message key="bsc.label.menoscinco"/></html:option>
					   	<html:option value="-4"><bean:message key="bsc.label.menosquatro"/></html:option>
					    <html:option value="-3"><bean:message key="bsc.label.menostres"/></html:option>
						<html:option value="-2"><bean:message key="bsc.label.menosdois"/></html:option>
						<html:option value="-1"><bean:message key="bsc.label.menosum"/></html:option>
						<html:option value="0"><bean:message key="bsc.label.zero"/></html:option>
						<html:option value="1"><bean:message key="bsc.label.um"/></html:option>
						<html:option value="2"><bean:message key="bsc.label.dois"/></html:option>
						<html:option value="3"><bean:message key="bsc.label.tres"/></html:option>
						<html:option value="4"><bean:message key="bsc.label.quatro"/></html:option>
						<html:option value="5"><bean:message key="bsc.label.cinco"/></html:option>
						<html:option value="6"><bean:message key="bsc.label.seis"/></html:option>
					</html:select>
				</td>
			</tr>
			<tr height="10px">
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="right" width="400px">
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
				<button type="button" onclick="encaminharCausaEfeito();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/causaefeito.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="bsc.botao.causaEfeito"/>
				</button>
				</td>
			</tr>
		</table>
		<c:if test="${listaTarefas ne '' and not empty listaTarefas}">
			<table width="350px" border="0" cellspacing="0" cellpadding="0">

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
		<br>
		<c:if test="${listaTarefasObejtivo ne '' and not empty listaTarefasObejtivo}">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="400px">
						<bean:message key="bsc.campo.tarefasVinculadas"/>
					</td>
				</tr>
				<tr height="3">
					<td>
						<displaytag:table width="400px" name="listaTarefasObejtivo" id="lista" styleClass="its" pagesize="5" requestURI="" scope="session">
							<displaytag:column style="width:90%;" title="" align="left">
							<a href="<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<c:out value="${lista.anoCriacao}"/>&codigo=<c:out value="${lista.codigo}"/>">
								<c:out value="${lista.nome}"/>
							</a>
							</displaytag:column>
							<displaytag:column style="width:10%;" title="" align="center">
								<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" title="Excluir Tarefa" onclick="excluirTarefa(<c:out value='${lista.codigo}'/>,<c:out value='${lista.anoCriacao}'/>,<c:out value='${objetivoForm.id}'/>);">
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
			</table>
		</c:if>
	</html:form>
	<html:javascript formName="objetivoForm" />
</html:html>