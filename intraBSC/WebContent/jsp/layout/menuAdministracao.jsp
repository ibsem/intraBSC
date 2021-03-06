<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<head>
	<link type="text/css" href="<c:out value="${base}"/>/WEB/css/redmond/jquery-ui-1.8.9.custom.css" rel="stylesheet">	
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/ajaxfileupload/jquery.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/ajaxfileupload/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/jquery/jquery-ui-1.8.9.custom.min.js"></script>
	<script type="text/javascript" src="<c:out value="${base}"/>/WEB/js/jquery/importadorAjax.js"></script>
	<style type="text/css">
		#dialog_link {padding: .4em 1em .4em 20px;text-decoration: none;position: relative;}
		#dialog_link span.ui-icon {margin: 0 5px 0 0;position: absolute;left: .2em;top: 50%;margin-top: -8px;}
	</style>	
</head>

<div id="dialog" style="display: none;">
	<form action="<c:out value="${base}"/>/mapaEstrategico/importar.do?op=importarXml" id="formImportarXml" enctype="multipart/form-data">
		<input type="file" size="50" name="fileImportar" id="fileImportar"/>
	</form>
</div>
<div id="loading_p">
	<div id="loading"  style="display:none;">
		<img src="<c:out value="${base}"/>/WEB/js/ajaxfileupload/loading.gif">
	</div>
</div>

<div name="arvore" id="itemmenu">
	<ul>
		<c:if test="${usuarioBSC.perfil eq 'administrador'}">
		<li><a href="<c:out value="${base}"/>/grupo/encaminhar/incluir.do?op=encaminharIncluir"> <bean:message key="bsc.label.grupo"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/grupo/encaminhar/consultar.do?op=encaminharConsultar"><bean:message key="bsc.label.grupo"/> <bean:message key="bsc.botao.alterar"/></a></li>							
		<li><a href="<c:out value="${base}"/>/mapaEstrategico/encaminha/incluir.do?op=encaminhaIncluir" ><bean:message key="bsc.label.mapa"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/mapaEstrategico/encaminha/abrirArvore.do" title="Abrir"><bean:message key="bsc.label.mapa"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="#" style="left:0px;" id="dialog_link"><bean:message key="bsc.botao.importarMapa"/></a></li>
		<!--<li><a href="<c:out value="${base}"/>/processo/encaminha/incluir.do?op=encaminhaIncluir" ><bean:message key="pro.label.processo"/> <bean:message key="bsc.botao.incluir"/></a></li> -->
		<!--<li><a href="<c:out value="${base}"/>/processo/encaminha/incluir.do?op=encaminhaImportarXPDL" ><bean:message key="pro.label.processo"/> <bean:message key="pro.botao.importarXPDL"/></a></li> -->
		<!--<li><a href="<c:out value="${base}"/>/processo/encaminha/abrirArvore.do" title="Abrir"><bean:message key="pro.label.processo"/> <bean:message key="bsc.botao.alterar"/></a></li> -->
		<li><a href="<c:out value="${base}"/>/encaminhar/incluir/configTarefa.do?op=encaminharIncluir"><bean:message key="bsc.botao.incluirModeloTarefa"/></a></li>
		<li><a href="<c:out value="${base}"/>/encaminhar/pesquisar/configTarefa.do?op=encaminharConsultar"><bean:message key="bsc.botao.alterarModeloTarefa"/></a></li>
		<li><a href="<c:out value="${base}"/>/periodicidade/encaminha/incluir.do?op=encaminharIncluir" title="Periodicidade"><bean:message key="bsc.label.periodicidade"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/periodicidade/consultar.do?op=consultarVarios" title="Periodicidade"><bean:message key="bsc.label.periodicidade"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/tipoPerspectiva/encaminha/incluir.do?op=encaminharIncluir" title="TipoPerspectiva"><bean:message key="bsc.campo.tipoPerspectiva"/> <bean:message key="bsc.botao.incluir"/></a></li>	
		<li><a href="<c:out value="${base}"/>/tipoPerspectiva/consultar.do?op=consultarVarios" title="TipoPerspectiva"><bean:message key="bsc.campo.tipoPerspectiva"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/unidade/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.unidade"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/unidade/consultar.do?op=consultarVarios"><bean:message key="bsc.campo.unidade"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/papel/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.papel"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/papel/consultar.do?op=consultarVarios"><bean:message key="bsc.campo.papel"/> <bean:message key="bsc.botao.alterar"/></a></li>
		
		</c:if>
		
		<c:if test="${(usuarioBSC.perfil eq 'administrador') or 
						  (usuarioBSC.perfil eq 'gerentegeral')}">
		<li><a href="<c:out value="${base}"/>/usuario/encaminhar.do?op=encaminharIncluir"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/usuario/pesquisar/alterar.do?op=encaminharIncluir"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.alterar"/></a></li>
	<!-- <li><a href="<c:out value="${base}"/>/usuario/alterarSenha.do?op=encaminharAlterarCadastro"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.alterar"/> Pr�prio</a></li> -->
		</c:if>
		
		<c:if test="${(usuarioBSC.perfil eq 'funcionario') or 
						  (usuarioBSC.perfil eq 'gerentegeral') or 
						  (usuarioBSC.perfil eq 'gerenteplanejamento') or 
						  (usuarioBSC.perfil eq 'funcionarioplanejamento') or
						  (usuarioBSC.perfil eq 'gerenteprocesso') or 
						  (usuarioBSC.perfil eq 'funcionarioprocesso')}">
		<li><a href="<c:out value="${base}"/>/mapaEstrategico/encaminha/incluir.do?op=encaminhaIncluir" ><bean:message key="bsc.label.mapa"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/mapaEstrategico/encaminha/abrirArvore.do" title="Abrir"><bean:message key="bsc.label.mapa"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<!--<li><a href="<c:out value="${base}"/>/processo/encaminha/incluir.do?op=encaminhaIncluir" ><bean:message key="pro.label.processo"/> <bean:message key="bsc.botao.incluir"/></a></li>-->
		<!--<li><a href="<c:out value="${base}"/>/processo/encaminha/abrirArvore.do" title="Abrir"><bean:message key="pro.label.processo"/> <bean:message key="bsc.botao.alterar"/></a></li>-->
		<!--<li><a href="<c:out value="${base}"/>/processo/encaminha/incluir.do?op=encaminhaImportarXPDL" ><bean:message key="pro.label.processo"/> <bean:message key="pro.botao.importarXPDL"/></a></li>-->
		<li><a href="<c:out value="${base}"/>/encaminhar/incluir/configTarefa.do?op=encaminharIncluir"><bean:message key="bsc.botao.incluirModeloTarefa"/></a></li>
		<li><a href="<c:out value="${base}"/>/encaminhar/pesquisar/configTarefa.do?op=encaminharConsultar"><bean:message key="bsc.botao.alterarModeloTarefa"/></a></li>
		<li><a href="<c:out value="${base}"/>/periodicidade/encaminha/incluir.do?op=encaminharIncluir" title="Periodicidade"><bean:message key="bsc.label.periodicidade"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/periodicidade/consultar.do?op=consultarVarios" title="Periodicidade"><bean:message key="bsc.label.periodicidade"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/tipoPerspectiva/encaminha/incluir.do?op=encaminharIncluir" title="TipoPerspectiva"><bean:message key="bsc.campo.tipoPerspectiva"/> <bean:message key="bsc.botao.incluir"/></a></li>	
		<li><a href="<c:out value="${base}"/>/tipoPerspectiva/consultar.do?op=consultarVarios" title="TipoPerspectiva"><bean:message key="bsc.campo.tipoPerspectiva"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/usuario/alterarSenha.do?op=encaminharAlterarCadastro"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.alterar"/> Pr�prio</a></li>
		<li><a href="<c:out value="${base}"/>/unidade/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.unidade"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/unidade/consultar.do?op=consultarVarios"><bean:message key="bsc.campo.unidade"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/papel/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.papel"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/papel/consultar.do?op=consultarVarios"><bean:message key="bsc.campo.papel"/> <bean:message key="bsc.botao.alterar"/></a></li>
		</c:if>
	
	</ul>
</div>