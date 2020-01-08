<%@ taglib uri="/tags/c" prefix="c" %>
<html>
<%
	//Sem cache no browser do cliente
	response.setHeader("Pragma", "no-cache, no-store");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=-1");
	response.setDateHeader("Expires", -1);
%>
	<body>
		
		<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
				  		  (usuarioBSC.perfil eq 'gerentegeral') or 
				  		  (usuarioBSC.perfil eq 'gerenteplanejamento') or
				  		  (usuarioBSC.perfil eq 'funcionarioplanejamento') or
				  		  (usuarioBSC.perfil eq 'gerenteprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionarioprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionario')}">
			<div id="mapasPrincipal" style="position:absolute;overflow:none;top:0px;left:420px;width:516px;height:190px;">
				<%@ include file="/jsp/mapaEstrategico/listarMapaEstrategico.jsp"%>
			</div>
		</c:if>
		<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
				  		  (usuarioBSC.perfil eq 'gerentegeral') or 
				  		  (usuarioBSC.perfil eq 'funcionario') or
				  		  (usuarioBSC.perfil eq 'gerenteplanejamento') or
				  		  (usuarioBSC.perfil eq 'funcionarioplanejamento') or
				  		  (usuarioBSC.perfil eq 'gerenteprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionarioprocesso')}">
			<div id="tarefaPrincipal" style="position:absolute;overflow:none;top:0px;left:5px;width:400px;height:600px">
				<%@ page import="java.util.Iterator"%>
				<%@ page import="java.util.Collection"%>
				<%@ page import="br.com.intraPRO.modelo.TarefaTO"%>
				<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
				<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/dtree.js"></script>
                                <%Collection listaTarefa = (Collection)request.getSession().getAttribute("listaArvoreMapaEstrategicoConfig");%>
					<%if (listaTarefa != null){%>
						<table width="400px" border="0" align="left">
							<tr><td class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="pro.label.tarefasporgrupo"/></td></tr>
							<tr>
							<td>
							<div id="listaTarefas">
								<div id="configTarefaExe" style="left:0; ">
									<script language = "JavaScript">
										 aT = new dTree('aT');
								         aT.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b>&nbsp;<bean:message key="bsc.label.acoes"/> </b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'',''); 

										<%String grupoMesAnoAnterior = "";
										Iterator iter = listaTarefa.iterator();%>
							             <%while (iter.hasNext()){
							             	TarefaTO element = (TarefaTO) iter.next();%>
							             	
							             	<%if (element.getSinalizacaoGrupo() == 3){%>
												aT.add("PAI_<%=element.getGrupoMesAno()%>","0","&nbsp;&nbsp;<%=element.getGrupoMesAno()%>","","","",
												"<c:out value="${base}"/>/WEB/imagens/comum/vermelhoConfigTarefa.gif","<c:out value="${base}"/>/WEB/imagens/comum/vermelhoConfigTarefa.gif");
											<%}else if (element.getSinalizacaoGrupo() == 2){%>
												aT.add("PAI_<%=element.getGrupoMesAno()%>","0","&nbsp;&nbsp;<%=element.getGrupoMesAno()%>","","","",
												"<c:out value="${base}"/>/WEB/imagens/comum/amareloConfigTarefa.gif","<c:out value="${base}"/>/WEB/imagens/comum/amareloConfigTarefa.gif");
											<%}else if (element.getSinalizacaoGrupo() == 1){%>
												aT.add("PAI_<%=element.getGrupoMesAno()%>","0","&nbsp;&nbsp;<%=element.getGrupoMesAno()%>","","","",
												"<c:out value="${base}"/>/WEB/imagens/comum/verdeConfigTarefa.gif","<c:out value="${base}"/>/WEB/imagens/comum/verdeConfigTarefa.gif");
											<%}%> 
																
											<%String nome = "";
											if (element.getNome().length() >= 57){
												nome = element.getNome().substring(0,57);
											}else{
												nome = element.getNome();
											}
										
											String abreTagNova = "<span class='linkunderline'>";
											String fechaTagNova = "</span>";
											if (((element.getTsAlteracao().getTime()) == (element.getTsCriacao().getTime())) || (element.getStatusModificado() == 2)){
												abreTagNova += "<font color=#FF0000><b>";
												fechaTagNova += "</font></b>";
											}%>
																
												<%if (element.getSinalizacaoTarefa() == 3){%>
													aT.add("TAR_<%=element.getCodigo()%>","PAI_<%=element.getGrupoMesAno()%>",
														  "&nbsp;&nbsp;"+
														  "<a href=<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<%=element.getAnoCriacao()%>&codigo=<%=element.getCodigo()%> title='<bean:message key="bsc.label.finaldatarefaem"/>  <%=element.getDiasFaltam()%> <bean:message key="bsc.label.dias"/>'>"+
														  "<%=abreTagNova%><%=nome%><%=fechaTagNova%></a>",
														  "","","","<c:out value="${base}"/>/WEB/imagens/comum/vermelhoAntigo.gif","<c:out value="${base}"/>/WEB/imagens/comum/vermelhoAntigo.gif");
						
												<%}else if (element.getSinalizacaoTarefa() == 2){%>
													aT.add("ATIV_<%=element.getCodigo()%>","PAI_<%=element.getGrupoMesAno()%>",
														  "&nbsp;&nbsp;"+
														  "<a href=<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<%=element.getAnoCriacao()%>&codigo=<%=element.getCodigo()%> title='<bean:message key="bsc.label.finaldatarefaem"/>  <%=element.getDiasFaltam()%> <bean:message key="bsc.label.dias"/>'>"+
														  "<%=abreTagNova%><%=nome%><%=fechaTagNova%></a>",
														  "","","","<c:out value="${base}"/>/WEB/imagens/comum/amareloAntigo.gif","<c:out value="${base}"/>/WEB/imagens/relatorio/amareloAntigo.gif");
						
												<%}else if (element.getSinalizacaoTarefa() == 1){%>
													aT.add("ATIV_<%=element.getCodigo()%>","PAI_<%=element.getGrupoMesAno()%>",
														  "&nbsp;&nbsp;"+
														  "<a href=<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<%=element.getAnoCriacao()%>&codigo=<%=element.getCodigo()%> title='<bean:message key="bsc.label.finaldatarefaem"/>  <%=element.getDiasFaltam()%> <bean:message key="bsc.label.dias"/>'>"+
														  "<%=abreTagNova%><%=nome%><%=fechaTagNova%></a>",
														  "","","","<c:out value="${base}"/>/WEB/imagens/comum/verdeAntigo.gif","<c:out value="${base}"/>/WEB/imagens/comum/verdeAntigo.gif");
												<%}%>
												<%grupoMesAnoAnterior = element.getGrupoMesAno();%>
																			
							             <%}%>
						            
						             document.getElementById("configTarefaExe").innerHTML = aT;
						             function ImprimiTarefas(){
												aT.openAll();
												nova_janelaA = window.open(null,'_blank','top=20,left=20,width=620,height=500,status=yes,scrollbars=yes,menubar=no,tools=no,statusbar=yes,toolbar=no,link=no,resizable=no');
												nova_janelaA.document.write('<html>');
												nova_janelaA.document.write("<title>Tarefas</title>");
												nova_janelaA.document.write('<LINK href="<c:out value="${base}"/>/WEB/css/IntraBSC.css" type=text/css rel=stylesheet>');
												nova_janelaA.document.write('<style>#tarefas{width:100%;height:100%;overflow:visible}');
												nova_janelaA.document.write('TABLE {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif}');
												nova_janelaA.document.write('.dtree{FONT-SIZE:11px; COLOR: #070d5b; FONT-FAMILY: Arial, Helvetica, sans-serif;left:50%;white-space: nowrap;border:thin}');
												nova_janelaA.document.write('.dtree img{border: 0px;vertical-align: middle;}');
												nova_janelaA.document.write('.dtree a{FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif; FONT-WEIGHT: normal; text-decoration: none;}');
												nova_janelaA.document.write('.dtree a.node, .dtree a.nodeSel{white-space: nowrap;padding: 1px 2px 1px 2px;}');
												nova_janelaA.document.write('.dtree a.node:hover, .dtree a.nodeSel:hover{color: #333;text-decoration: none;}');
												nova_janelaA.document.write('.dtree a.nodeSel{background-color: #c0d2ec;}');
												nova_janelaA.document.write('.dtree .clip{overflow: hidden;}');
												nova_janelaA.document.write('.linkunderline {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: Arial, Helvetica, sans-serif; FONT-WEIGHT: normal; text-decoration: underline;}');
												nova_janelaA.document.write('div#td1 {width:250px;height:16px;overflow:hidden}</style>');
												nova_janelaA.document.write('<body>');
												nova_janelaA.document.write(listaTarefas.outerHTML);
												nova_janelaA.document.write('</body>');
												nova_janelaA.document.write('</hmtl>');
												nova_janelaA.document.close();
												nova_janelaA.print();
												aT.closeAll();
												nova_janelaA = null;
										};
									</script>		
								</div>
								</div>
							</td>
							</tr>
						</table>
						<%} else {%>
				<span style="color: blue;font-weight:bold;position:absolute;overflow:auto;top:0px;left:10px">
					<bean:message key="msg.mapaEstrategico.usuarioSemTarefa"/>
				</span>
		
					<%}%>
			</div>
		</c:if>
		
		<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
				  		  (usuarioBSC.perfil eq 'gerentegeral') or 
				  		  (usuarioBSC.perfil eq 'funcionario') or
				  		  (usuarioBSC.perfil eq 'gerenteplanejamento') or
				  		  (usuarioBSC.perfil eq 'gerenteprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionarioprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionarioplanejamento')}">
		<div id="indicadorPrincipal" style="position:absolute;overflow:none;top:180px;left:420px;width:516px;height:300px">
			<%@ include file="/jsp/indicador/relDetalhaMeuIndicador.jsp"%>
			</div>
		</c:if>
		
	</body>	
</html>