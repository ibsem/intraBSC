<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/fmt" prefix="fmt" %>
<%@ taglib uri="/tags/c" prefix="c"%>
<link rel="stylesheet" type="text/css" media="all" href="<c:out value="${base}"/>/WEB/calendario/css/calendar.css" title="win2k-cold-1" />
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-en.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/calendario/js/calendar-setup.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/displaytag.css" type="text/css">
<script language="JavaScript">
		var anotacaoEstado = "aberto";
		function abreFechaAnotacao(){
			var anotacao = document.getElementById('anotacao');
			if (anotacao != null){
				if ((anotacaoEstado == "fechado")){
					dojo.lfx.html.wipeOut(anotacao, 400).play();
					anotacaoEstado = "aberto";
				}else{
					dojo.lfx.html.wipeIn(anotacao, 400).play();
					anotacaoEstado = "fechado";
				}
			}
		}

		var anotacaoDatas = "aberto";
		function abreFechaDatas(){
			var anotacao = document.getElementById('datas');
			if (anotacao != null){
				if ((anotacaoDatas == "fechado")){
					dojo.lfx.html.wipeOut(anotacao, 400).play();
					anotacaoDatas = "aberto";
				}else{
					dojo.lfx.html.wipeIn(anotacao, 400).play();
					anotacaoDatas = "fechado";
				}
			}
		}

		
		var anotacaoTecnicas = "aberto";
		function abreFechaTecnicas(){
			var anotacao = document.getElementById('tecnicas');
			if (anotacao != null){
				if ((anotacaoTecnicas == "fechado")){
					dojo.lfx.html.wipeOut(anotacao, 400).play();
					anotacaoTecnicas = "aberto";
				}else{
					dojo.lfx.html.wipeIn(anotacao, 400).play();
					anotacaoTecnicas = "fechado";
				}
			}
		}
		

		function calcularDataPrazoTarefa(args){
			document.tarefaForm.action = "<c:out value="${base}"/>/tarefa/alterar.do?op=calcularDataPrazo";	
			document.tarefaForm.submit();
		}
		
		function incluirAnexos() {			
			var tipo =<c:out value="${tarefaForm.tipoParticipacao}"/>;
			var est = <c:out value="${tarefaForm.codEstado}"/>;
				
			var nomeP =document.tarefaForm.nome.value;
			var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
			var codEstadoP =document.tarefaForm.codEstado.value;
			var codCriticidadeP =document.tarefaForm.codCriticidade.value;
			var dtInicioP =document.tarefaForm.dtInicio.value;
			var dtFimP =document.tarefaForm.dtFim.value;
			var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
			
			abrirPopupAnexo("<c:out value="${base}"/>/anexo/encaminhar/incluir.do?op=encaminharIncluir&tipoParticipacao="+tipo + "&estado=" + est +"&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP);	
		}
		function visualizarAnotacao() {
			var nomeP =document.tarefaForm.nome.value;
			var dtPrazoP =document.tarefaForm.dtLimitePrazo.value;
			var codEstadoP =document.tarefaForm.codEstado.value;
			var codCriticidadeP =document.tarefaForm.codCriticidade.value;
			var dtInicioP =document.tarefaForm.dtInicio.value;
			var dtFimP =document.tarefaForm.dtFim.value;
			var txtDescricaoP =document.tarefaForm.textoSolicitacao.value;
		
			abrirPopupAnotacao("<c:out value="${base}"/>/anotacao/encaminhar/incluir.do?op=encaminharInclusao&tipoAnotacao=1&nome="+nomeP+"&dtPrazo="+dtPrazoP+"&codEstado="+codEstadoP+"&codCriticidade="+codCriticidadeP+"&dtInicio="+dtInicioP+"&dtFim="+dtFimP+"&txtDescricao="+txtDescricaoP);
		}
		
		function MudaData(){
			if (document.tarefaForm.codEstado.value == "2")
				document.tarefaForm.dtInicio.value = document.tarefaForm.dataAtual.value;
			if (document.tarefaForm.codEstado.value == "3")
				document.tarefaForm.dtFim.value = document.tarefaForm.dataAtual.value;
			document.tarefaForm.codEstadoAnexo.value = document.tarefaForm.codEstado.value;
		}

		function download(codAnoCriacao, codTarefa, codArquivoAnexo){
			document.tarefaForm.anoCriacao.value = codAnoCriacao;
			document.tarefaForm.numeroSequencialTarefa.value = codTarefa;
			document.tarefaForm.numeroSequencialArquivo.value = codArquivoAnexo;
			document.tarefaForm.action = "<c:out value="${base}"/>/anexo/download.do";
			document.tarefaForm.op.value = "download";
 			document.tarefaForm.submit();
		}
		
		function alterar(){
			var form = document.tarefaForm;
			if (validateTarefaForm(form)){
				if (validarDatasTarefa(form)){
					form.action = "<c:out value="${base}"/>/tarefa/alterar.do?op=alterar";
					form.submit();
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		
		function validarDatasTarefa(form) {
			if(validateTarefaForm(form)){					
				if(form.dtFim.value != "" && form.dtInicio.value != ""){	
					if(!datamaiorigual(form.dtFim.value,form.dtInicio.value)){
						alert("Data Fim não poderá ser menor que a data início.");
						return false;
					}
				}
				if((form.dtFim.value) != (form.dataFimParametro.value)){
					if (stringToDate(form.dtFim.value) > stringToDate(form.dataAtual.value)){
						alert("Data Fim não poderá ser maior que a data de hoje.");
						return false;
					}
				}
				return true;
			}else{
				return false;
			}
		}
		
		function imprimirTarefa(){
			window.location="<c:out value="${base}"/>/tarefa/alterar.do?op=imprimirTarefas";
		}
		
	 </script>

	<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/intraBSC.css" type="text/css">
<html:form action="/tarefa/alterar.do?op=alterar">
	<input type="hidden" name="dataCriacao"					value="<c:out value="${dataCriacao}"/>">
	<input type="hidden" name="dataInicioParametro"			value="<c:out value="${tarefaForm.dtInicio}"/>">	
	<input type="hidden" name="dataFimParametro"			value="<c:out value="${tarefaForm.dtFim}"/>">	
	<input type="hidden" name="dataPrazoParametro"			value="<c:out value="${tarefaForm.dtLimitePrazo}"/>">
	<input type="hidden" name="codigo"						value="<c:out value="${tarefaForm.codigo}"/>">
	<input type="hidden" name="anoCriacao"					value="<c:out value="${tarefaForm.anoCriacao}"/>">
	<input type="hidden" name="dataAtual"					value="<c:out value="${dataAtual}"/>">
	<input type="hidden" name="codEstadoAnexo" 				value="" />
	<input type="hidden" name="tipoAnotacao"				value="1"/>
	<html:hidden property="op" value="alterar"/>
	<input type="hidden" name="numeroSequencialTarefa">
	<input type="hidden" name="numeroSequencialArquivo">


	<div id="imprimi">	
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
				
				<tr>
				    <td valign="middle" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.alterarexecucaotarefa"/></td>  
				</tr>
				
		</table>
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/solicitante.gif" border="0">
				<b><bean:message key="pro.label.tarefa.solicitadapor"/></b>&nbsp;&nbsp; &nbsp;<c:out value="${tarefaForm.nomeUsuSolicitante}" />&nbsp; em &nbsp; <c:out value="${tarefaForm.tsCriacao}" /> <br></td>
			</tr>
		</table>
	
		<!-- Codigo e Nome -->
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
			<tr>
				<td><bean:message key="pro.label.numero" /></td>
				<TD>
					&nbsp;&nbsp;
				</TD>
				<td><bean:message key="pro.label.nomeTarefa" /></td>
			</tr>
			<tr>
				<td>
	                 <html:text property="codigoAno" size="10" disabled="true" /></td>
	            <TD>
				    &nbsp;&nbsp;
				</TD>
	        		<td><html:text property="nome" maxlength="100" size="55" disabled="false"  style="width:417px"/></td>
			</tr>
	    </table>
		<!-- Status e Datas -->
		<table width="512px" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="3" align="Left" style="vertical-align: middle;" width="90%"  class="menuPreto">
					<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/datasStatus.gif" border="0" onclick="abreFechaDatas();">
						<a href="#" onclick="abreFechaDatas();" style="vertical-align: middle;height: 16px;" ><b><bean:message key="pro.label.datasestatus"/></b></a>
				</td>
				<td align="right" width="10%">
					<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaDatas();">
				</td>
			</tr>
		</table>
		<div id="datas">
		
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
			<tr>
				<td width="125px"><bean:message key="pro.label.prazo" /></td>
	 			<td width="125px"><bean:message key="pro.label.inicio" /></td>
	 			<td width="125px"><bean:message key="pro.label.fim" /></td>
	 			<td width="75px"><bean:message key="pro.label.estado"/></td>	
	 			<td width="75px"><bean:message key="pro.label.criticidade" /></td>
	 		</tr>
	 		<tr>	
				<!-- <td width="130px"><html:text property="dtLimitePrazo" maxlength="10" size="10" onkeydown="AutoFormataData(this)" disabled="false" /></td> -->				 				
	 			<td width="125px" colspan="1" align="left"><html:text property="dtLimitePrazo" styleId="f_date_c" readonly="false"
										    maxlength="10" size="9" onkeydown="AutoFormataData(this);" 
										    onblur="validarData(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_c" style="cursor: pointer; vertical-align: middle;" title="Selecionar a Data"/>
				</td>
	 				 			
				<td width="125px" colspan="1" align="left"><html:text property="dtInicio" styleId="f_date_d" readonly="false"
										    maxlength="10" size="9" onkeydown="AutoFormataData(this);" 
										    onblur="validarData(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_d" style="cursor: pointer; vertical-align: middle;" title="Selecionar a Data"/>
				</td>				
			
				<td width="125px" colspan="1" align="left"><html:text property="dtFim" styleId="f_date_e" readonly="false"
										    maxlength="10" size="9" onkeydown="AutoFormataData(this);" 
										    onblur="validarData(this,'Data');"/>
					<img src="<c:out value="${base}"/>/WEB/calendario/imagem/calendario.gif" 
						 id="f_trigger_e" style="cursor: pointer; vertical-align: middle;" title="Selecionar a Data"/>
				</td>				

				<td width="75px"><input type="hidden" name="codEstadoDesabilitado"/>
					<html:select property="codEstado" disabled="false" onchange="MudaData()" style="width:70px">
						<html:option value="4"><bean:message key="pro.label.tarefa.cancelada"/></html:option>
						<html:option value="1"><bean:message key="pro.label.tarefa.naoIniciada"/></html:option>
						<html:option value="3"><bean:message key="pro.label.tarefa.concluida"/></html:option>
						<html:option value="2"><bean:message key="pro.label.tarefa.iniciada"/></html:option>
						<html:option value="5"><bean:message key="pro.label.tarefa.validada"/></html:option>
					</html:select>
			</td>
			<td width="75px">
				<html:select property="codCriticidade" disabled="false" style="width:70px">
						<html:option value="1">
							<bean:message key="pro.label.alta" />
						</html:option>
						<html:option value="3">
							<bean:message key="pro.label.baixa" />
						</html:option>
						<html:option value="2">
							<bean:message key="pro.label.medio" />
						</html:option>
					</html:select>
				</td>
			</tr>
			
		</table>
		</div>
<!-- Técnicas e Ferramentas -->
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
		
			<tr>
				<td colspan="2">
					<table width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="3" align="Left" style="vertical-align: middle;" width="90%"  class="menuPreto">
								<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/ferramentas.gif" border="0" onclick="abreFechaTecnicas();">
								<a href="#" onclick="abreFechaTecnicas();" style="vertical-align: middle;height: 16px;" ><b><bean:message key="pro.label.descricao"/></b></a>
							</td>
							<td align="right" width="10%">
								<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaTecnicas();">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
			<div id="tecnicas">
			<table>
			<tr>
				<td>
				<html:textarea name="tarefaForm" property="textoSolicitacao" cols="93" rows="8" style="width:511px"/>
				</td>
			</tr>
			</table>
			</div>	


		
<!-- ***************    Anotações da tarefa    ******************* -->
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
		     
		     <tr>
				<td><!-- Lista o anotacao da tarefa -->
					<table width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="3" align="Left" style="vertical-align: middle;" width="90%"  class="menuPreto">
								<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/anotacoes.gif" border="0" onclick="abreFechaAnotacao();">
								<a href="#" onclick="abreFechaAnotacao();" style="vertical-align: middle;height: 16px;" ><b><bean:message key="pro.label.anotacoes"/></b></a>
							</td>
							<td align="right" width="10%">
								<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaAnotacao();">
							</td>
						</tr>
					</table>
					<div id="anotacao">
						<table width="100%" border="0" bordercolor="black" style="border:none;" cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="5" align="right">
									<button type="button" onclick="visualizarAnotacao();" class="botaoPreto" style="vertical-align: middle">
										<img src="<c:out value="${base}"/>/WEB/imagens/comum/adicionar.gif" border="0" style="vertical-align: text-bottom">
										<bean:message key="pro.botao.adicionar"/>
									</button>
								</td>
							</tr>
							<logic:notEmpty name="listaAnotacao" scope="session">
								<tr>
									<td>
										<displaytag:table width="512px" name="listaAnotacao" id="lista" styleClass="linha" requestURI="" scope="session">
											<displaytag:column style="width:15%;text-align:center; " >
												<c:out value="${lista.responsavel.nome}"/>
											</displaytag:column>
											<displaytag:column style="width:15%;text-align:center; " >
												<c:out value="${lista.dataAnotacao}"/>
											</displaytag:column>
											<displaytag:column style="width:70%;" >
												<c:out value="${lista.textoAnotacao}"/>
											</displaytag:column>
										</displaytag:table>
									</td>
								</tr>
							</logic:notEmpty>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<table border="0" width="514px" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="5"><%@ include file="/jsp/pro/tarefa/listarFormulariosCriticos.jsp"%></td>
			</tr>
		</table>	
		<table border="0" width="514px" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="5"><%@ include file="/jsp/pro/tarefa/listarItemsCriticos.jsp"%></td>
			</tr>
		</table>	
	
	
		<table border="0" width="512px" cellpadding="0" cellspacing="0">	
			<tr align="left" valign="middle">
				<td width="90%" class="txtPreto" style="vertical-align: middle;">
					<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/participante.gif" border="0" onclick="abreFechaParticipante();">
					<a href="#" style="vertical-align: middle;height:16px;" onclick="abreFechaParticipante();"><b><bean:message key="pro.label.execucao" /></b></a>
				</td>
				<td align="right" width="10%">
					<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaParticipante();">
				</td>
			</tr>
			<tr align="left">
				<td colspan="2" width="512px"><%@ include file="/jsp/pro/tarefa/listaExecutanteTarefa.jsp"%></td>
			</tr>
		</table>
		<table border="0" width="512px" cellpadding="0" cellspacing="0" >	
			<tr>
				<td width="90%" align="left" valign="middle">
					<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/anexo.gif" border="0" onclick="abreFechaAnexo();">
					<a href="#" style="vertical-align: middle;height:16px;" onclick="abreFechaAnexo();"><b><bean:message key="pro.anexo.label.anexos"/></b></a>
				</td>
				<td align="right" width="10%">
					<img style="vertical-align:middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/abrir.gif" border="0" onclick="abreFechaAnexo();">
				</td>
			</tr>
			<tr>
				<td colspan="2" width="512px"><%@ include file="/jsp/pro/anexo/listarAnexo.jsp"%></td>
			</tr>

		</table>
<!-- Lista Anexo -->
	</div>
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="0">
				<img style="vertical-align: middle;height:16px;" src="<c:out value="${base}"/>/WEB/imagens/comum/causaefeito.gif" border="0">
				<b><bean:message key="pro.label.configTarefa" /></b>&nbsp;</td>
				<td colspan="0">
					<html:select property="codConfigTarefa" disabled="true" style="width:380px">
				   		<html:options collection="listaConfigTarefa" property="codigoConfigTarefa" labelProperty="textoConfigTarefa" />
					</html:select>
				</td>
			</tr>
		</table>
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
			<tr height="5px" >
				<td >&nbsp;</td>
			</tr>
				
			<tr>
	
				<td align="right" valign="middle">
						<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle">
							<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.voltar"/>
					</button>
					<button type="button" onclick="imprimirTarefa();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.pdf"/>
					</button>
					<button type="button" onclick="alterar();" class="botaoPreto" style="vertical-align: middle">
						<img src="<c:out value="${base}"/>/WEB/imagens/comum/salvar.gif" border="0" style="vertical-align: text-bottom">
						<bean:message key="pro.botao.salvar"/>
					</button>
				</td>
			</tr>
			<tr>
		 			<td  valign="middle" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"> &nbsp;</td>
			</tr>
		
		</table>
		<table border="0" width="512px" cellpadding="0" cellspacing="0">
			<tr>
			<td colspan="2" >
					<c:choose>
						<c:when test="${tarefaForm.codIndicador ne '' and not empty tarefaForm.codIndicador and tarefaForm.codIndicador ne '0'}">
							<div style="position: relative; left: 0px; top: 0px;">
							<br><img style="margin-left:0px; border:thin; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/arvore/indicador.gif" border="1">
							<b><bean:message key="bsc.label.indicadorv"/></b>&nbsp;
							<c:out value="${nomeIndicador}"/>
							</div>	
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
										  (usuarioBSC.perfil eq 'gerentegeral' ) or 
										  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionarioplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionario')}">
							<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/indicador/detalhar.do?op=indicadorRelatorioDetalha&codMapa=<c:out value="${codMapa}"/>&codPerspectiva=<c:out value="${codPerspectiva}"/>&codIndicador=<c:out value="${tarefaForm.codIndicador}"/>">
										<img style="margin-left:0px; border:thin; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/configuracao.gif" border="0" title="Relatorio">
									<u>Historico</u></a>
								</div> 
							</c:if>
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
									      (usuarioBSC.perfil eq 'gerentegeral' ) or 
									      (usuarioBSC.perfil eq 'gerenteplanejamento')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/indicador/encaminha.do?op=encaminharAlterar&codIndicador=<c:out value="${tarefaForm.codIndicador}"/>">
										<img style="margin-left:10px; border:thin; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/alterarIndicador.gif" border="0" title="Editar Indicador">
									<u>Alterar</u></a>
								</div>
							</c:if>
						</c:when>
						<c:when test="${tarefaForm.codObjetivo ne '' and not empty tarefaForm.codObjetivo and tarefaForm.codObjetivo ne '0'}">
							<br><img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/arvore/config.gif" border="0">
							<b><bean:message key="bsc.label.objetivov"/>:</b>&nbsp;
							<c:out value="${nomeObjetivo}"/>
							
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
										  (usuarioBSC.perfil eq 'gerentegeral' ) or 
										  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionarioplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionario')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/objetivo/detalhar.do?op=objetivoRelatorioDetalha&codMapa=<c:out value="${tarefaForm.codMapa}"/>&codObjetivo=<c:out value="${tarefaForm.codObjetivo}"/>">
										<img style="margin-left:0px; border:none; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/configuracao.gif" border="0" title="Relatorio">
									<u>
									Relatorio</u></a>
								</div>  
							</c:if>
							
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
									      (usuarioBSC.perfil eq 'gerentegeral' ) or 
									      (usuarioBSC.perfil eq 'gerenteplanejamento')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/objetivo/encaminha.do?op=encaminharAlterar&codObjetivo=<c:out value="${tarefaForm.codObjetivo}"/>">
										<img style="margin-left:10px; border:none; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/alterarObjetivo.gif" border="0" title="Editar Objetivo">      
									<u>
									Editar Objetivo</u></a>
								</div>
							</c:if>
						</c:when>
						<c:when test="${tarefaForm.codPerspectiva ne '' and not empty tarefaForm.codPerspectiva and tarefaForm.codPerspectiva ne '0'}">
							<br><img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/arvore/file.gif" border="0">
							<b><bean:message key="bsc.label.perspectivav"/></b>:&nbsp;
							<c:out value="${nomePerspectiva}"/>
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
										  (usuarioBSC.perfil eq 'gerentegeral' ) or 
										  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionarioplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionario')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/perspectiva/detalhar.do?op=perspectivaRelatorioDetalha&codMapa=<c:out value="${tarefaForm.codMapa}"/>&codPerspectiva=<c:out value="${tarefaForm.codPerspectiva}"/>">
										<img style="margin-left:0px; border:none; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/configuracao.gif" border="0" title="Relatorio">
									<u>
									Relatorio</u></a>
								</div>
							</c:if>
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
									      (usuarioBSC.perfil eq 'gerentegeral' ) or 
									      (usuarioBSC.perfil eq 'gerenteplanejamento')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/perspectiva/encaminha.do?op=encaminhaAlterar&codPerspectiva=<c:out value="${tarefaForm.codPerspectiva}"/>">
										<img style="margin-left:10px; border:none; vertical-align: middle"  src="<c:out value="${base}"/>/WEB/imagens/comum/alterarPerspectiva.gif" border="0" title="Editar Perspectiva">
									<u>
									Editar Perspectiva</u></a>
								</div>
							</c:if>
						</c:when>
						<c:when test="${tarefaForm.codMapa ne '' and not empty tarefaForm.codMapa and tarefaForm.codMapa ne '0'}">
							<br><img src="<c:out value="${base}"/>/WEB/imagens/arvore/pasta.gif" border="0">
							<b><bean:message key="bsc.label.mapav"/>:</b>&nbsp;
							<c:out value="${nomeMapa}"/>
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
										  (usuarioBSC.perfil eq 'gerentegeral' ) or 
										  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionarioplanejamento') or 
										  (usuarioBSC.perfil eq 'funcionario')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=mapaUsuarioRelatorioDetalha&codMapaEstrategico=<c:out value="${tarefaForm.codMapa}"/>">
										<img style="margin-left:0px; border:none; vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/configuracao.gif" border="0" title="Editar Mapa">
									<u>
									Relatorio</u></a>
								</div>
							</c:if> 
							<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
									      (usuarioBSC.perfil eq 'gerentegeral' ) or 
									      (usuarioBSC.perfil eq 'gerenteplanejamento')}">
								<div style="float: left;"><br>
									<a href="<c:out value="${base}"/>/mapaEstrategico/consultar.do?op=consultarUm&id=<c:out value="${tarefaForm.codMapa}"/>">
										<img style="margin-left:10px; border:none;vertical-align: middle" src="<c:out value="${base}"/>/WEB/imagens/comum/alterarMapa.gif" border="0" title="Editar Mapa">
									<u>
									Editar Mapa</u></a>
								</div>
							</c:if>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>	
			</tr>
			
		</table>
		
	<html:javascript formName="tarefaForm" />
	<script>
		abreFechaDatas();
		abreFechaTecnicas();
		abreFechaAnotacao();
		abreFechaFormulario();
		abreFechaItem();
		abreFechaParticipante();
		abreFechaAnexo();
	    Calendar.setup({
	        inputField     :    "f_date_c",     // id of the input field
			ifFormat       :    "%d/%m/%Y",
	        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
	        align          :    "Tl",           // alignment (defaults to "Bl")
	        singleClick    :    true
	    });
	    Calendar.setup({
	        inputField     :    "f_date_d",     // id of the input field
			ifFormat       :    "%d/%m/%Y",
	        button         :    "f_trigger_d",  // trigger for the calendar (button ID)
	        align          :    "Tl",           // alignment (defaults to "Bl")
	        singleClick    :    true
	    });
	    Calendar.setup({
	        inputField     :    "f_date_e",     // id of the input field
			ifFormat       :    "%d/%m/%Y",
	        button         :    "f_trigger_e",  // trigger for the calendar (button ID)
	        align          :    "Tl",           // alignment (defaults to "Bl")
	        singleClick    :    true
	    });
	</script>
</html:form>
