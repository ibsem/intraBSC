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
	    <title>Banco do Brasil SA - Super SC</title>
		<url></url>
		<description></description>
		<keywords></keywords>
		<charset>ISO-8859-1</charset>
</HEAD>


	<BODY > 
  	<form action="logon.do" method="post">
  	<table border="0" style="position:absolute;top:0px;left:0px;" valign="left" width="100%" height="450" cellpadding="0" border="0" cellspacing="0">  	
  		<tr>
		<td>
			<table  cellpadding="0" background="<c:out value="${base}"/>/WEB/imagens/comum/testeiradireita.jpg" border="0" style="position: relative;" cellspacing="0" width="100%" align="center" >
				<tr>
					<td width="797px" cellspacing="0"><img width="797" height="104px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/testeira.jpg" border="0">	</td>
				</tr>
			</table>
		</td>
		</tr>
		<tr>
			<td width="100%" align="center" >
         		<table border="0" height="430px" width="800px" cellspacing="0" cellpadding="0" style="vertical-align: top; ">
	         		<tr>
	         			<td  valign="top" align="center">
							<div id="conteudo" style="position:relative;overflow:auto;width:1030px;height:630px;top:0px;border-style:groove;">
									<table border="0" >
										<tr>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
											<td valign="top">
												<table border="0" style="vertical-align: top; ">
													<tr><td class="titulo2" colspan="2" >
													Estratégias e acompanhamento das Ações Núcleo Rede
       												</td></tr>
       												<tr><td colspan="2">&nbsp;</td></tr>
       												<td>
       												<table>
       												<tr>
       												       												
       												<td colspan="0" class="titulo">Visão - Núcleo Rede</td></tr>
       												<tr>
       												<td colspan="0" class="texto1" >
               											Ser o melhor núcleo de suporte operacional tanto aos serviços prestados
               										como para se trabalhar.
               										</td>
               										</tr>
       												<tr><td colspan="0" >&nbsp;</td></tr>
       												<tr><td class="titulo" colspan="0" >Fatores Críticos do Sucesso</td></tr>
													<tr><td class="texto1" >
														Planejamento, análise, comprometimento, tempestividade, aprendizagem e
													colaboração.
													</td>
													</tr>
													</table>
													</td>
													<td >
               										<img width="178px" height="160px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/transformarestrategia.gif" border="0">
               										</td>
													</tr>
													
													<tr><td colspan="2">&nbsp;</td></tr>
       												<tr>
       												<td colspan = "2">
       												<table border="0">
       												<tr>
														<td colspan="0">
               											<img width="252px" height="158px" align="left"  src="<c:out value="${base}"/>/WEB/imagens/comum/performance.jpg" border="0">
               											</td>
               											
               											<td colspan="0">
               											<table>
               												<tr><td class="titulo" colspan="0" style="text-align: right" >Função da Super</td></tr>
															<tr>
															<td colspan="0" class="texto1" style="text-align: right" >
																Unidade organizacional do nível tático, gestora das Redes de Agências Varejo e Governo em
															determinada região geo-econômica, responsável pela implementação das estratégias negociais
															definidas e pela gestão do acordo de trabalho das unidades subordinadas.
															</td>
															</tr>
															<tr><td colspan="0" >&nbsp;</td></tr>
       														<tr><td class="titulo" colspan="0" style="text-align: right">Missão</td></tr>
															<tr><td colspan="0" class="texto1" style="text-align: right">
 																Ser um banco competitivo e rentável, promover o desenvolvimento sustentável do Brasil e cumprir
 															sua função pública com eficiência.</td>
															</tr>
														</table>
														</td>
													</tr>	
													</table>
													</td>
													</tr>
												</table>
											</td>
               										
               										
               										
               										
               										
               										
               										
											<td valign="top" width="200px">
												<table  border="0"  >
									
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
											<tr height=5></tr>
											<tr>
												<td class="titulo3">
												<!-- &nbsp;&nbsp;Contato: -->
												</td>
											</tr>
											<tr height=2></tr>
											<tr>
												<td class="texto1">
												<!-- &nbsp;&nbsp;&nbsp; <b><u><font color="blue">acesso@intrabsc.com</font></u></b> -->	 	
												</td>
											</tr>
											<tr>
												
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

