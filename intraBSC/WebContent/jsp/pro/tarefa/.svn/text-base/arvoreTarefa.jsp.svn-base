<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="br.com.intraPRO.modelo.TarefaTO"%>

<script language="JavaScript" type="text/javascript">
	function abrirAcoes(codMapa){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaAcoes&codMapaEstrategico="+codMapa;
	}
	function abrirCronograma(){
		window.location="<c:out value="${base}"/>/mapaEstrategico/detalhar.do?op=relatorioMapaCronograma";
	}
	function pesquisarTarefa(){
		window.location="<c:out value="${base}"/>/tarefa/encaminhar/consultar.do?op=encaminharConsultar";
	}
	function incluirTarefa(){
		window.location="<c:out value="${base}"/>/tarefa/encaminhar/incluir.do?op=encaminharInclusao";
	}
	function relatorioTarefasGrupo(){
		window.location="<c:out value="${base}"/>/tarefa/relatorioGrupoTarefa.do?op=relatorioGrupoTarefa";
	}
	function relatorioTarefasMes(){
		window.location="<c:out value="${base}"/>/tarefa/relatorioGrupoTarefa.do?op=relatorioGMesTarefas";
	}

</script>

<%Collection listaTarefa = (Collection)request.getSession().getAttribute("listaArvoreMapaEstrategicoConfig");%>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/dtree.js"></script>
<%if (listaTarefa != null){%>
	<table width="130px" border="0" cellpadding="0" cellspacing="0"  >
		<tr>
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="pesquisarTarefa();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/pesquisarTarefaSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/pesquisarTarefa.gif'">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/pesquisarTarefa.gif" 
					border="0" align="middle" title="Pesquisar Tarefas" />
				</button>
				</td>
				<td>
				<button style="width: 32px; height: 32px;" type="button"
					onclick="incluirTarefa();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirTarefaSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/incluirTarefa.gif'">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/incluirTarefa.gif" 
					border="0" align="middle" title="Incluir Tarefa" />
				</button>
				</td>
				<td>
					<button style="width: 32px; height: 32px;" type="button"
					onclick="relatorioTarefasGrupo();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/relTarefasGrupoSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/relTarefasGrupo.gif'">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/relTarefasGrupo.gif" 
					border="0" align="middle" title="Relatório de Tarefas agrupadas por Modelo" />
					</button>
				</td>
				<td>
					<button style="width: 32px; height: 32px;" type="button"
					onclick="relatorioTarefasMes();"
					onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/relTarefasMesSobre.gif'"
					onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/relTarefasMes.gif'">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/relTarefasMes.gif" 
					border="0" align="middle" title="Relatório de Tarefas agrupadas por Mês " />
					</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
				onclick="abrirAcoes(<c:out value="${tarefaForm.codMapa}"/>);"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaAcoesSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaAcoes.gif'">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaAcoes.gif"
						 
						 border="0" Title="Plano de Ações"/>
				</button>
				</td>
				<td align="center" >
				<button style="width: 32px; height: 32px;" type="button"
						 onclick="abrirCronograma();"
						 onmouseover="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaCronogramaSobre.gif'"
						 onmouseout="src='<c:out value='${base}'/>/WEB/imagens/comum/mapaCronograma.gif'"
						 >
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/mapaCronograma.gif"
						 border="0" Title="Cronograma"/>
				</button>
				</td>
								<td width="" align="center">
					<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle; width: 32px;height: 32px;padding: 2px;">
					<img align="bottom" src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" align="middle" style="vertical-align: middle">
					</button>
				</td>
			</tr>
	</table>
	<table width="400px" border="0"  >
		<tr>
			<td class="titulo" style="border-bottom:thin; border-bottom-style:solid;">
				<bean:message key="pro.label.tarefasporgrupo"/>
			</td>
	    </tr>
					
	</table>
<%}%>

	<%--********************************************************TAREFAS POR DATA***********************************************************--%>
	<table width="400px" border="0" align="left" >
	<tr>
	<td>
	<div id="listaTarefas">
		<div id="configTarefaExe" style="left:0; ">
			<script language = "JavaScript">
			<%if (listaTarefa != null){%>
				 a = new dTree('a');
		         a.add(0,-1,"<a href='javascript:a.aNodes[0]._io=!a.aNodes[0]._io;a.oAll(a.aNodes[0]._io);'><b>&nbsp;<bean:message key="pro.label.listatarefasemexecucao"/> </b>&nbsp;&nbsp;&nbsp;<img src='<c:out value="${base}"/>/WEB/imagens/arvore/maisMenos.gif'/></a>",'',''); 
            	         		          		  
				<%String grupoMesAnoAnterior = "";
				Iterator iter = listaTarefa.iterator();%>
		             <%while (iter.hasNext()){
		             	TarefaTO element = (TarefaTO) iter.next();%>
		             			             	
		             	<% if (element.getSinalizacaoGrupo() == 3){%>
							a.add("PAI_<%=element.getGrupoMesAno()%>","0","&nbsp;&nbsp;<%=element.getGrupoMesAno()%>","","","",
							"<c:out value="${base}"/>/WEB/imagens/comum/vermelhoConfigTarefa.gif","<c:out value="${base}"/>/WEB/imagens/comum/vermelhoConfigTarefa.gif");
						<%}else if (element.getSinalizacaoGrupo() == 2){%>
							a.add("PAI_<%=element.getGrupoMesAno()%>","0","&nbsp;&nbsp;<%=element.getGrupoMesAno()%>","","","",
							"<c:out value="${base}"/>/WEB/imagens/comum/amareloConfigTarefa.gif","<c:out value="${base}"/>/WEB/imagens/comum/amareloConfigTarefa.gif");
						<%}else if (element.getSinalizacaoGrupo() == 1){%>
							a.add("PAI_<%=element.getGrupoMesAno()%>","0","&nbsp;&nbsp;<%=element.getGrupoMesAno()%>","","","",
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
									a.add("TAR_<%=element.getCodigo()%>","PAI_<%=element.getGrupoMesAno()%>",
										  "&nbsp;&nbsp;"+
										  "<a href=<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<%=element.getAnoCriacao()%>&codigo=<%=element.getCodigo()%> title='<bean:message key="bsc.label.finaldatarefaem"/> <%=element.getDiasFaltam()%> <bean:message key="bsc.label.dias"/>'>"+
										  "<%=abreTagNova%><%=nome%><%=fechaTagNova%></a>",
										  "","","","<c:out value="${base}"/>/WEB/imagens/comum/vermelhoAntigo.gif","<c:out value="${base}"/>/WEB/imagens/comum/vermelhoAntigo.gif");
		
								<%}else if (element.getSinalizacaoTarefa() == 2){%>
									a.add("ATIV_<%=element.getCodigo()%>","PAI_<%=element.getGrupoMesAno()%>",
										  "&nbsp;&nbsp;"+
										  "<a href=<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<%=element.getAnoCriacao()%>&codigo=<%=element.getCodigo()%> title='<bean:message key="bsc.label.finaldatarefaem"/> <%=element.getDiasFaltam()%> <bean:message key="bsc.label.dias"/>'>"+
										  "<%=abreTagNova%><%=nome%><%=fechaTagNova%></a>",
										  "","","","<c:out value="${base}"/>/WEB/imagens/comum/amareloAntigo.gif","<c:out value="${base}"/>/WEB/imagens/comum/amareloAntigo.gif");
		
								<%}else if (element.getSinalizacaoTarefa() == 1){%>
									a.add("ATIV_<%=element.getCodigo()%>","PAI_<%=element.getGrupoMesAno()%>",
										  "&nbsp;&nbsp;"+
										  "<a href=<c:out value="${base}"/>/tarefa/encaminhar/alterarStatus.do?op=alterarStatusModificado&anoCriacao=<%=element.getAnoCriacao()%>&codigo=<%=element.getCodigo()%> title='<bean:message key="bsc.label.finaldatarefaem"/> <%=element.getDiasFaltam()%> <bean:message key="bsc.label.dias"/>'>"+
										  "<%=abreTagNova%><%=nome%><%=fechaTagNova%></a>",
										  "","","","<c:out value="${base}"/>/WEB/imagens/comum/verdeAntigo.gif","<c:out value="${base}"/>/WEB/pimagens/comum/verdeAntigo.gif");
								<%}%>
								<%grupoMesAnoAnterior = element.getGrupoMesAno();%>
								<%}%>   
	            <%}%> 
	             document.getElementById("configTarefaExe").innerHTML = a;
	             function imprimirExe(){
		             ImprimiTarefas();
	             }
	             
	             function ImprimiTarefas(){
							a.openAll();
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
							a.closeAll();
							nova_janelaA = null;
					};
			</script>		
		</div>		
		<br />
		<br />
		</div>
	</td>
	</tr>
	<script language="JavaScript">
		function imprimir(){
			window.location="<c:out value="${base}"/>/tarefa/relatorioGrupoTarefa.do?op=imprimirAgendaTarefas";
		}
	</script>
	<tr align="left">
		<td>
			<%if (listaTarefa != null){ %>
			<button type="button" onclick="imprimir();" class="botaoPreto">
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
				<bean:message key="pro.botao.pdf"/>
			</button>
			<%} else {%>
				<span style="color: blue;font-weight:bold;position:absolute;overflow:auto;top:0px;left:0px">
					<bean:message key="msg.mapaEstrategico.usuarioSemTarefa"/>
				</span>
			<%}%>
		</td>
	</tr>
</table>
