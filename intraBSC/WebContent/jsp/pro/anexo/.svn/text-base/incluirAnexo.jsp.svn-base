<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/c" prefix="c" %>

<script language="JavaScript">
	function excluir(){		
		 var frm = document.anexoForm;
		 var afirma=0;
		 var tipo =<%=request.getParameter("tipoParticipacao")%>;
		 var est= <%=request.getParameter("estado")%>;
				  for(i=1; i < frm.listaExcluir.length; i++){
					  if(frm.listaExcluir[i].checked==true){
					  	document.anexoForm.action = "<c:out value="${base}"/>/anexo/encaminhar/incluir.do?op=excluir&tipoParticipacao="+tipo+ "&estado=" + est;
					  	document.anexoForm.submit();
		 				afirma=1;
		 				break;
					  }else{
					  	afirma=0;
					  }
				  }
				  if(afirma ==0){
				  	alert("Selecione o anexo que será excluído.");
				  }
			}
		
		function download(codAnoCriacao, codTarefa, codArquivoAnexo){
			document.anexoForm.anoCriacao.value = codAnoCriacao;
			document.anexoForm.numeroSequencialTarefa.value = codTarefa;
			document.anexoForm.numeroSequencialArquivo.value = codArquivoAnexo;
			document.anexoForm.action = "<c:out value="${base}"/>/anexo/download.do";
			document.anexoForm.op.value = "download";
 			document.anexoForm.submit();
		}

	function anexar(){
		 var frm = document.anexoForm;
		 var tipo =<%=request.getParameter("tipoParticipacao")%>;
		 var est= <%=request.getParameter("estado")%>;
		 if(frm.arquivo.value !=""){
			document.anexoForm.action = "<c:out value="${base}"/>/anexo/incluir.do?op=incluir&tipoParticipacao="+tipo+ "&estado=" + est;
			document.anexoForm.submit();
			}else{
			 alert("Procure e selecione um anexo. campo obrigatório.");
			}
	}
	function retornaTarefa(){
		window.opener.location.href = "<c:out value="${base}"/>/tarefa/encaminhar/alterar.do?op=encaminharAlterar&anoCriacao="+document.anexoForm.anoCriacao.value+"&codigo="+document.anexoForm.numeroSequencialTarefa.value;
		window.close();
	}
</script>		
	<html:form action="/anexo/incluir"   enctype="multipart/form-data" >
	<html:hidden property="op" value="incluir" />
	<html:hidden property="numeroSequencialTarefa" />
	<html:hidden property="numeroSequencialArquivo" />
	<html:hidden property="anoCriacao" />
	<html:hidden property="listaExcluir" />
	<html:hidden property="estado" />
	<input type="hidden" name="tipoParticipacao" value="<%=request.getParameter("tipoParticipacao")%>"/>
		
	<table border="0" width="550px" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/anexo.gif" border="0">
				<b><bean:message key="pro.anexo.label.anexos"  /></b>
			</td>
		</tr>
		<tr>
			<td><b>
			<c:if test="${anexoForm.estado==5}">
				<input type="file" name="arquivo" style="width:500px" onkeypress="return false;" disabled="true" /><br/>
			</c:if>
			<c:if test="${anexoForm.estado!=5}">
				<input type="file" name="arquivo" style="width:500px" onkeypress="return false;"  /><br/>
			</c:if>
			</b>
			</td>
		</tr>
		</table>
		<table width="550px" border="0">
		<logic:notEmpty name="listaAnexos" scope="session">
			<tr height="3">
					<td colspan="4" >&nbsp;
					</td>
				</tr>
				<tr>
					<td width="6%" align="left">
					
					</td>
					<td width="55%" align="left">
						<u><bean:message key="pro.label.nome"/></u>
					</td>
					<td width="10%" align="left">
						<u><bean:message key="pro.label.tamanho"/></u>
					</td>
					<td width="25%" align="left">
						<u><bean:message key="pro.label.datainclusao"/></u>
					</td>
				</tr>
			
			<tr>
				<td colspan="4">
					<displaytag:table width="100%" styleClass="its" name="listaAnexos" id="anexo" pagesize="5" requestURI="" scope="session">
						<c:if test="${anexoForm.estado!=5}">
							<displaytag:column style="width:5%;" title="" align="left"> 
								<html:multibox property="listaExcluir" style="border:0" ><bean:write name="anexo" property="numeroSequencialArquivo"/></html:multibox>
							</displaytag:column>
						</c:if>
                        <displaytag:column style="width:57%;" title="" align="left">&nbsp;
							<a href="#" onclick="javascript: download(<c:out value='${anexo.anoCriacao}' />, <c:out value='${anexo.numeroSequencialTarefa}' />, <c:out value='${anexo.numeroSequencialArquivo}' /> )" >
								<c:out value="${anexo.nome}"/>
							</a>
						</displaytag:column>
						 <displaytag:column style="width:10%;" title="" align="left">&nbsp;
							<a href="#" onclick="javascript: download(<c:out value='${anexo.anoCriacao}' />, <c:out value='${anexo.numeroSequencialTarefa}' />, <c:out value='${anexo.numeroSequencialArquivo}' /> )" >
								<c:out value="${anexo.tamanho}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:25%;" title="" align="center">&nbsp;
							<a href="#" onclick="javascript: download(<c:out value='${anexo.anoCriacao}' />, <c:out value='${anexo.numeroSequencialTarefa}' />, <c:out value='${anexo.numeroSequencialArquivo}' /> )" >
								<c:out value="${anexo.tsCriacaoAnexoS}"/>
							</a>
						</displaytag:column>

					</displaytag:table>
				</td>
			</tr>
		</logic:notEmpty>	
		<tr>
			<td align="left" colspan="4">
				<bean:write property="capacidadeDisponivel" name="anexoForm" />
			</td>
		</tr>
		<tr>
			<td align="left"  colspan="4">
				<bean:message key="pro.label.anexo.tamanho.arquivo"  />
			</td>
		</tr>
	</table>
	<table border="0" width="550px" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right"><br/>
				<logic:notEmpty name="listaAnexos">
					<c:if test="${anexoForm.estado!=5}">
					&nbsp;&nbsp;
					<button type="button" onclick="javascript: excluir();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.excluir"/>
					</button>
					</c:if>
				</logic:notEmpty>
				<button type="button" onclick="javascript: anexar();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.salvar"/>
				</button>
				<button type="button" onclick="retornaTarefa();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.voltar"/>
				</button>
			</td>
		</tr>
	</table>
	<table border="0">
		<tr>
			<td>
				<b><font color="#FF0000"><html:errors/></font></b>
			</td>
		</tr>
		<tr>
	 </tr>
	</table>
</html:form>
