<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language = "JavaScript">
	function consultar(){
		document.recursoForm.action = "<c:out value="${base}"/>/recurso/encaminha.do?op=consultarVarios&codIniciativa="+document.recursoForm.idIniciativa.value;
		document.recursoForm.submit();
	}
</script>

<html:html>
	<html:form action="/recurso/manutencao.do?op=incluir" onsubmit="return validateRecursoForm(this);">
	<html:hidden property="idIniciativa"/>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
	  			<td colspan="2" class="menuAzulEscuro">
	  				Consultar Recurso
	  			</td></br>
	  		</tr>
			<tr>
				<td colspan="2"><bean:message key="bsc.campo.nome"/></td>
			</tr>
			<tr>
				<td colspan="2"><html:text property="nome" maxlength="100" size="54"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right" width="250px"></br>
					<html:button property="" onclick="javascript:history.back();"><bean:message key="bsc.botao.voltar"/></html:button>
					<html:button property="" onclick="consultar();"><bean:message key="bsc.botao.consultar"/></html:button>
				</td>
			</tr>
		</table>
		<table>
		<tr>
			<td>
				<logic:present name="listaRecurso">
					<displaytag:table width="300px" name="listaRecurso" id="recurso" styleClass="its" pagesize="20" requestURI="" scope="request">
						<displaytag:column style="width:5%;" title="Codigo" align="left"> 
							<a href="<c:out value="${base}"/>/recurso/encaminha.do?op=encaminhaAlterar&codRecurso=<c:out value='${recurso.id}'/>&codIniciativa=<c:out value='${recurso.idIniciativa}'/>">
								<c:out value="${recurso.id}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:60%;" title="Nome" align="left"> 
							<a href="<c:out value="${base}"/>/recurso/encaminha.do?op=encaminhaAlterar&codRecurso=<c:out value='${recurso.id}'/>&codIniciativa=<c:out value='${recurso.idIniciativa}'/>">
								<c:out value="${recurso.nome}"/>
							</a>
						</displaytag:column>
					</displaytag:table>
				</logic:present>
			</td>
		</tr>
	</table>
	</html:form>
	<html:javascript formName="recursoForm" />
</html:html>