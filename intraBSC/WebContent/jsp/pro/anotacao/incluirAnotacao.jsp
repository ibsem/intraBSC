<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/c" prefix="c"%>

<script language="JavaScript">

		function visualizarAnotacao() {
			abrirPopupAnotacaoPesqusiar("<c:out value="${base}"/>/anotacao/encaminhar/visualizar.do?op=visualizar");
			window.close();
		}

		function incluirAnotacao() {
			if (validateAnotacaoTarefaFormIncluir(document.anotacaoTarefaFormIncluir)){
				document.anotacaoTarefaFormIncluir.action = "<c:out value="${base}"/>/anotacao/incluir.do?op=incluir&anoCriacao=" + document.anotacaoTarefaFormIncluir.anoTarefa.value + "&codTarefa="+document.anotacaoTarefaFormIncluir.codTarefa.value;
				document.anotacaoTarefaFormIncluir.submit();
			}
		}
		function retornaTarefa(){
			window.opener.document.tarefaForm.action = "<c:out value="${base}"/>/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao=" + document.anotacaoTarefaFormIncluir.anoTarefa.value + "&codigo="+document.anotacaoTarefaFormIncluir.codTarefa.value;
			window.opener.document.tarefaForm.submit();
			window.close();
		}
	 </script>

<html:form action="/anotacao/incluir">
	<html:hidden property="op" value="incluir" />
	<input type="hidden" name="codTarefa" value="<c:out value="${tarefaTO.codigo}"/>"/>
	<input type="hidden" name="anoTarefa" value="<c:out value="${tarefaTO.anoCriacao}"/>"/>

	<table border="0" width="400px" cellpadding="0" cellspacing="0">
				
		<tr>
			<td><img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/anotacoes.gif" border="0">
				<b><bean:message key="pro.label.anotacoes"/>:</b>
			</td>
			<td>&nbsp;</td>		
		</tr>
		<tr>
			<td colspan="2">&nbsp;<html:textarea property="textoAnotacao" rows="9" onkeyup="return ContarCaracteresGeral(textoAnotacao, caracteres)" style="width:100%" value="" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input name="caracteres" type="text"  style="background-color:#FFFFFF;border:0;text-align:right;" disabled value="1024" size="2" maxlength="4">&nbsp;<bean:message key="pro.label.caracteresdisponiveis"/></td>
		</tr>
		<tr>
			<td colspan="2"><br>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button type="button" onclick="incluirAnotacao();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.salvar"/>
				</button>
				<button  type="button" onclick="retornaTarefa();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.fechar"/>
				</button>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<html:javascript formName="anotacaoTarefaFormIncluir" />
</html:form>

