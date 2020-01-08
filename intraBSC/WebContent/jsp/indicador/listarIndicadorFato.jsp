<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" media="all" href="<c:out value="${base}"/>/WEB/calendario/css/calendar.css" title="win2k-cold-1" />
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-en.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-setup.js"></script>
<script language = "JavaScript">
	function consultar(){	
		if ((document.indicadorForm.idIndicador.value != "")||(document.indicadorForm.ultimaData.value != "")){
			document.indicadorForm.action = "<c:out value="${base}"/>/indicadorFato/manutencao.do?op=listarIndicadorFato";
			document.indicadorForm.submit();
		}else{
			alert("Digite um dado para realizar a consulta.");
		}
	}
	function alterar(){
		document.indicadorForm.action = "<c:out value="${base}"/>/indicadorFato/manutencao.do?op=alterarIndicadorFato";
		document.indicadorForm.submit();
	}
	function validarDataLocal(campo,label){
		if (campo.value != ""){
			if (!validarData(campo,label)){
				document.indicadorForm.ultimaData.value = "";
				return false;
			}
		}
	}
	function setaValorExcluir(id,data){
		document.indicadorForm.ultimaData.value = data;
		document.indicadorForm.idIndicador.value = id.value;
	}
	function excluir(){
		if ((document.indicadorForm.ultimaData.value != "")&&(document.indicadorForm.idIndicador.value != "")){
			document.indicadorForm.action = "<c:out value="${base}"/>/indicadorFato/manutencao.do?op=excluirIndicadorFato";
			document.indicadorForm.submit();
		}else{
			alert("Selecione um item para ser excluído.");
		}
	}
	function incluir(){
		if ((document.indicadorForm.ultimaData.value != "")&&(document.indicadorForm.idIndicador.value != "")&&(document.indicadorForm.ultimoValor.value != "")){
			document.indicadorForm.action = "<c:out value="${base}"/>/indicadorFato/manutencao/configuracao.do?op=incluirIndicadorFatoConfiguracao";
			document.indicadorForm.submit();
		}else{
			alert("Todos os campos são obrigatorios");
		}
	}
</script>
<html:html>
	<html:form action="/indicadorFato/manutencao">
		</br>
		<table border="0" cellspacing="0" cellpadding="0" width="470px">
			<tr>
			    <td valign = "center" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.manutencaoValores"/></br></td>  
			</tr>
			
		</table>
		<table border="0" cellspacing="0" cellpadding="0" width="470px">
			<tr>
				<td width="100px"><bean:message key="bsc.campo.data"/></td>
				<td><bean:message key="bsc.campo.indicador"/></td>
				<td><bean:message key="bsc.campo.valor"/></td>
			</tr>
			<tr>
<!-- 			<td width="20px">
					<html:text property="ultimaData" maxlength="10" size="8" onkeydown="formataData(this);" onblur="validarDataLocal(this,'Data');"/>
				</td>
 -->
				<td width="100px" colspan="1" align="left"><html:text property="ultimaData" styleId="f_date_c" readonly="false"
										    maxlength="10" size="8" onkeydown="formataData(this);" 
										    onblur="validarDataLocal(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_c" style="cursor: pointer; vertical-align: middle;" title="Selecionar a Data"/>
				</td>	
				
				
				<td align="left">
					<html:select property="idIndicador" style="width:280px;height:18;">
						<html:option value=""></html:option>
						<html:options collection="listaIndicador" property="id" labelProperty="nome" />
					</html:select>
				</td>
				
				<td width="35px">
					<html:text property="ultimoValor" maxlength="8" size="9" value=""/>
				</td>
			</tr>
			<tr height="5">
			</tr>
			<tr>
				<td colspan="3" align="right">

					<button type="button" property="" onclick="incluir();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.salvar"/>
					</button>
					<button type="button" property="" onclick="consultar();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.pesquisar"/>
					</button>
				
				</td>
			</tr>
		</table>
		</br>
		<c:if test="${ not empty listaIndicadorFato}">
			<table border="0" cellspacing="0" cellpadding="0" width="460px">
				<tr height="3">
					<td colspan="4" >&nbsp;
					</td>
				</tr>
				<tr>
				<td width="5%" align="left">
						
					</td>
					
					<td width="15%" align="left">
						<u><bean:message key="bsc.label.data"/></u>
					</td>
					<td width="70%" align="left">
						<u><bean:message key="bsc.label.nome"/></u>
					</td>
					<td width="10%" align="left">
						<u><bean:message key="bsc.label.valor"/></u>
					</td>
				</tr>
			</table>	
			</c:if>			
		<logic:present name="listaIndicadorFato">
			<table>
				<tr>
					<td>
						<displaytag:table width="460px" name="listaIndicadorFato" id="fato" styleClass="its" pagesize="20" requestURI="" scope="request">
							<displaytag:column title="" align="left">
									<input type="radio" name="idIndicador" onclick="setaValorExcluir(this,'<c:out value='${fato.strData}'/>')" value="<c:out value='${fato.id}'/>">
									<input type="hidden" name="listaId" value="<c:out value='${fato.id}'/>"/>
							</displaytag:column>
							<displaytag:column style="width:15%;" title="" align="left">
									<input type="hidden" name="listaDatas" value="<c:out value='${fato.strData}'/>"/><c:out value="${fato.strData}"/>
							</displaytag:column>
							<displaytag:column style="width:70%;" title="" align="left"> 
									<c:out value="${fato.nome}"/>
							</displaytag:column>
							<displaytag:column style="width:10%;" title="" align="left">
								<input type="text" size="10" name="listaValores" value="<c:out value='${fato.valor}'/>"/>
							</displaytag:column>
						</displaytag:table>
					</td>
				</tr>
				<tr>
					<td align="right">
						<button  property="" onclick="excluir();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/excluir.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.excluir"/>
						</button>
						<button  property="" onclick="alterar();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.salvar"/>
						</button>
					</td>
				</tr>
			</table>
		</logic:present>
	</html:form>
	<html:javascript formName="indicadorForm" />
		<script type="text/javascript">
	    Calendar.setup({
	        inputField     :    "f_date_c",     // id of the input field
			ifFormat       :    "%d/%m/%Y",
	        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
	        align          :    "Tl",           // alignment (defaults to "Bl")
	        singleClick    :    true
	    });
	</script>
</html:html>