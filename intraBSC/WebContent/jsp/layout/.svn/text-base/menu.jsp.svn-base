<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<%@ taglib uri="/tags/struts-html" prefix="html" %>
	<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
	<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
	<%@ taglib uri="/tags/c" prefix="c"%>
	<script language="JavaScript" type="text/javascript">
		// Dojo configuration
		djConfig = { 
			isDebug: true
		};
	</script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dojo.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/html.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/prototype.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/effects.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/dragdrop.js"></script>
	
	<script type="text/javascript">
		dojo.require("dojo.lfx.*");
	
		function testExplode(start,item){
			if (item == 1) {
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.explode(start, "explodeitem", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 2){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.explode(start, "explodeacao", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}else if (item == 4){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.explode(start,"explodeconfig", 250).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 5){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.explode(start,"explodegrupo", 250).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 10){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.explode(start,"explodetema", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}else if (item == 15){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.explode(start,"explodeusuario", 250).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodetema", start, 10).play();
			}
		}
	
		function testImplode(start,item){
			if (item == 1) {
				dojo.lfx.implode("explodeitem", start, 10).play();
			}else if (item == 2){
				dojo.lfx.implode("explodeacao", start, 10).play();
			}else if (item == 3){
				dojo.lfx.implode("explodeitem", start, 10).play();
				dojo.lfx.implode("explodeacao", start, 10).play();
				dojo.lfx.implode("explodeconfig", start, 10).play();
				dojo.lfx.implode("explodegrupo", start, 10).play();
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}else if (item == 4){
				dojo.lfx.implode("explodeconfig", start, 10).play();
			}else if (item == 5){
				dojo.lfx.implode("explodegrupo", start, 10).play();
			}else if (item == 10){
				dojo.lfx.implode("explodetema", start, 10).play();
			}else if (item == 15){
				dojo.lfx.implode("explodeusuario", start, 10).play();
			}
		}
	   var myStartEffect = function(element) {
	     element._opacity = Element.getOpacity(element);
	     new Effect.Opacity(element, {duration:0.2, from:element._opacity, to:0.7});
	     new Effect.Highlight(element, {});
	   }
	</script>
</head>
<link rel="stylesheet" type="text/css" href="<c:out value="${base}"/>/WEB/css/menu.css" />
<div id="geral" >
	<div id="menu" >
		<ul>
			<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
				  		  (usuarioBSC.perfil eq 'gerentegeral') or 
				  		  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
						  (usuarioBSC.perfil eq 'funcionarioplanejamento') or
						  (usuarioBSC.perfil eq 'gerenteprocesso') or 
						  (usuarioBSC.perfil eq 'funcionarioprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionario')}">
				<li><a href="<c:out value="${base}"/>/principal.do?op=telaPrincipal"><bean:message key="bsc.label.home"/></a></li>
			</c:if>
				<!-- 
			<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
						  (usuarioBSC.perfil eq 'gerentegeral' ) or 
						  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
						  (usuarioBSC.perfil eq 'funcionarioplanejamento') or 
						  (usuarioBSC.perfil eq 'gerenteprocesso') or 
						  (usuarioBSC.perfil eq 'funcionario')}">
				<li><a href="<c:out value="${base}"/>/mapaEstrategico/inicial/listarCompleto.do?op=consultarMapaUsuario"><bean:message key="bsc.label.mapas"/></a></li>
			<li><a href="<c:out value="${base}"/>/principal.do?op=telaPrincipal"><bean:message key="bsc.campo.objetivos"/></a></li> -->
				<li><a href="<c:out value="${base}"/>/meuIndicador/detalharCompleto.do?op=meusIndicadoresRelatorioDetalha"><bean:message key="bsc.label.indicadores"/></a></li>
			</c:if>
			
			<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
			  			  (usuarioBSC.perfil eq 'gerentegeral' ) or 
			  			  (usuarioBSC.perfil eq 'gerenteprocesso') or 
			  			  (usuarioBSC.perfil eq 'funcionario' ) or 
			  			  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
						  (usuarioBSC.perfil eq 'funcionarioplanejamento') or 
			  			  (usuarioBSC.perfil eq 'funcionarioprocesso')}">
				<li><a href="<c:out value="${base}"/>/visualizar/configTarefa/arvore.do?op=consultarArvore"><bean:message key="pro.label.tarefasporgrupo"/></a></li>
			</c:if>
			
			<!--<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
				  		  (usuarioBSC.perfil eq 'gerentegeral') or 
				  		  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
						  (usuarioBSC.perfil eq 'funcionarioplanejamento') or
						  (usuarioBSC.perfil eq 'gerenteprocesso') or 
						  (usuarioBSC.perfil eq 'funcionarioprocesso') or
				  		  (usuarioBSC.perfil eq 'funcionario')}">
				<li><a href="<c:out value="${base}"/>/principal.do?op=telaPrincipal"><bean:message key="pro.label.processo"/></a></li>
			</c:if> -->
			
			
												
			<li><a href="javascript:;" onclick="testExplode(this,5)"><bean:message key="bsc.campo.administracao"/></a></li>
						
			<c:if test="${(usuarioBSC.perfil eq 'funcionario') or 
						  (usuarioBSC.perfil eq 'gerentegeral') or 
						  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
						  (usuarioBSC.perfil eq 'funcionarioplanejamento') or
						  (usuarioBSC.perfil eq 'gerenteprocesso') or 
						  (usuarioBSC.perfil eq 'funcionarioprocesso') or
						  (usuarioBSC.perfil eq 'administrador')}">
			<li><a href="<c:out value="${base}"/>/ajuda.do"><bean:message key="bsc.label.ajuda"/></a></li>
            <li><a href="<c:out value="${base}"/>/logoff.do"><bean:message key="bsc.label.sair"/></a></li>
			</c:if>
		</ul>
	</div>
</div>
</html>