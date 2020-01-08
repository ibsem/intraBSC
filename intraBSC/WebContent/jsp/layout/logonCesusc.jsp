<%@ page language="java" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<c:if test="${empty applicationScope.base}">
	<c:choose>
		<c:when test="${pageContext.request.contextPath eq '/'}">
			<c:set var="base" value="" scope="application" />
		</c:when>
		<c:otherwise>
			<c:set var="base" value="${pageContext.request.contextPath}" scope="application" />
		</c:otherwise>
	</c:choose>
</c:if>



<html:html>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	    <link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/intraBSC.css" type="text/css">
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/menu.css" type="text/css">
		<link rel="stylesheet" href="<c:out value="${base}"/>/WEB/css/displaytag.css" type="text/css">
<HEAD>
	    <title>Faculdade Cesusc</title>
		<url>cesusc.edu.br</url>
		<description>Plano de Desenvolvimento Institucional e Projeto Pedagógico</description>
		<keywords>Cesusc, PDI, PDC </keywords>
		<charset>ISO-8859-1</charset>
</HEAD>


	<BODY > 
  	<form action="logon.do" method="post">
  	<table border="0" style="position:absolute;top:0px;left:0px;" valign="left" width="100%" height="450" cellpadding="0" border="0" cellspacing="0">  	
  		<tr>
		<td>
			<table  cellpadding="0" background="<c:out value="${base}"/>/WEB/imagens/comum/testeiradireitaCesusc.jpg" border="0" style="position: relative;" cellspacing="0" width="100%" align="center" >
				<tr>
					<td width="797px" cellspacing="0"><img width="797" height="104px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/testeiraCesusc.jpg" border="0">	</td>
				</tr>
			</table>
		</td>
		</tr>
		<tr>
			<td width="100%" align="center" >
         		<table border="0" height="430px" width="800px" cellspacing="0" cellpadding="0" style="vertical-align: top; ">
	         		<tr>
	         			<td  valign="top" align="center">
							<div id="conteudo" style="position:relative;overflow:auto;width:830px;height:630px;top:0px;border-style:groove;">
									<table border="0" >
										<tr>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
											<td valign="top">
												<table border="0" style="vertical-align: top; ">
													<tr><td class="titulo2" colspan="2" >
													Plano de Desenvolvimento Institucional e Projeto Pedagógico dos Cursos
       												</td></tr>
       												<tr><td colspan="2">&nbsp;</td></tr>
       												<td>
       												<table>
       												<tr>
       												       												
       												<td colspan="0" class="tituloVerde1">PDI - Plano de Desenvolvimento Institucional</td></tr>
       												<tr>
       												<td colspan="0" class="texto1" >
               											O PDI do Cesusc contém as diretrizes instituicioanis e o Mapa Estratégico com os 
               										aspectos de gestão que orientam o alcance dos objetivos, metas e indicadores definidos
               										,proporcionando a implementação e acompanhamento coordenado dos planos de ações defindos
               										pela Instituição. 
               										</td>
               										</table>
													</td>
													<td >
               										<img width="280px" height="160px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/cesuscFachada.jpg" border="0">
               										</td>
													</tr>
													
													<tr><td colspan="2">&nbsp;</td></tr>
       												<tr>
       												<td colspan = "2">
       												<table border="0">
       												<tr>
														<td colspan="0">
               											<img width="238px" height="148px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/cesuscLaboratorio.jpg" border="0">
               											</td>
               											
               											<td colspan="0">
               											<table>
               												<tr><td class="tituloVerde1" colspan="0" style="text-align: right" >PPC - Plano Pedagógico dos Cursos</td></tr>
															<tr>
															<td colspan="0" class="texto1" style="text-align: right" >
																O PPC do Cesusc automatiza e gerencia os processos de cadastro e avaliação dos Projetos Pedagógicos que 
																orientam os diversos processos com informações curriculares dos cursos de Administração, Analise e
																Desenvolvimento de Sistemas, Design de Interiores, Direito e Marketing.
																 
															</td>
															</tr>
															</table>
														</td>
													</tr>	
													</table>
													</td>
													</tr>
												</table>
											</td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
											<td valign="top" width="200px">
												<table  border="0"  >
													<tr><td class="titulo3"><b>&nbsp;&nbsp;Downloads:</b></td></tr>
													<tr height=2></tr>
													<tr>
														<td class="texto1">&nbsp;&nbsp;
															<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
															<a href="<c:out value="${base}"/>/folder.do?op=downloadFolderProduto">Cal. Acadêmico 2016/17</a>
														</td>
													</tr>
													<tr>
														<td class="texto1" >&nbsp;&nbsp;
															<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
															<a href="<c:out value="${base}"/>/folder.do?op=downloadFolderGrupo">Guia Acadêmico 2016</a>
														</td>
													</tr>
													<tr>
														<td class="texto1">&nbsp;&nbsp;
															<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
															<a href="<c:out value="${base}"/>/folder.do?op=downloadFolderTecnico">Regimento Geral</a>
														</td>
													</tr> 
													<tr height=5></tr>
													<tr><td width="80%"><hr></td></tr>
													<tr height=5></tr>
													<tr>
															<td class="titulo3" >
															&nbsp;&nbsp;<b><bean:message key="bsc.label.entrelogin"/></b>
															</td>
													</tr>
													<tr height=3></tr>
													<tr >
													<td >
														<div id="nifty" style="width:160px;">
															<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>  
															<table>
																<tr height=2></tr>
																<tr>
																	<td class="txtPreto">
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><bean:message key="pro.botao.login"/>&nbsp;&nbsp;&nbsp;</b>
																	</td>
																</tr>
																<tr>			
																	<td>
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" maxlength="10" size="11%"/>
																	</td>
																</tr>
																<tr>
																	<td class="txtPreto">
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><bean:message key="pro.botao.senha"/>&nbsp;</b>
																	</td>
																</tr>
																<tr>
																	<td>
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" maxlength="8" size="11%"/>
																	</td>
																</tr>
																<tr height=2></tr>
																<tr>
																	<td align="left">
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="logar" value="<bean:message key="bsc.botao.entrar"/>"/>
																	</td>
																<tr>
															</table>
															<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>
														</div>
													<table>
														<tr>
															<td>
																<span style="font-weight:bold; color:#FF0000;"><c:out value="${UsuarioSenhaInvalido}"/></span>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr height=5></tr>
											<tr><td width="80%"><hr></td></tr>
											<tr height=1></tr>
											<tr>
												<td class="titulo3">
												<!-- &nbsp;&nbsp;Contato: -->
												</td>
											</tr>
											<tr>
											<table>
											<tr height=1 colspan="2"></tr>
											<tr colspan="2"><td class="titulo3"><b>&nbsp;&nbsp;Idioma:</b></td></tr>
											<tr height=2 colspan="2"></tr>
											<tr align="center" >
												<td width="30px" align="right">
												<a href="<c:out value="${request.contextPath}"/>/intraBSC"><img src="<c:out value="${base}"/>/WEB/imagens/comum/bandeira_br.gif" title="Português" >
												</a>
												</td>
												<td align="left" >
												<a href="<c:out value="${request.contextPath}"/>/intraBSC_en"><img src="<c:out value="${base}"/>/WEB/imagens/comum/bandeira_eua.gif" title="Inglês" >
												</a>
												</td>
											</tr>
											</table>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
		   	</table>
		  </td>
		</tr>
	</table>
</form>
</BODY>	


</html:html>
<table width="100%" border="0">
	<tr>
		<td align="center" style="color: #EA0000;font-weight: bold">
			<c:out value="${UsuarioSenhaInvalido}"/>
		</td>
	</tr>
</table>

