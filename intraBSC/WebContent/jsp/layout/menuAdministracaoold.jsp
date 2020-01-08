<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<div name="arvore" id="itemmenu">
	<ul>
		<c:if test="${usuarioBSC.perfil eq 'administrador'}">
		<li><a href="<c:out value="${base}"/>/grupo/encaminhar/incluir.do?op=encaminharIncluir"> <bean:message key="bsc.label.grupo"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/grupo/encaminhar/consultar.do?op=encaminharConsultar"><bean:message key="bsc.label.grupo"/> <bean:message key="bsc.botao.alterar"/></a></li>							
		<li><a href="<c:out value="${base}"/>/mapaEstrategico/encaminha/incluir.do?op=encaminhaIncluir" ><bean:message key="bsc.label.mapa"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/mapaEstrategico/encaminha/abrirArvore.do" title="Abrir"><bean:message key="bsc.label.mapa"/> <bean:message key="bsc.botao.alterar"/></a></li>
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
		<li><a href="<c:out value="${base}"/>/usuario/encaminhar.do?op=encaminharIncluir"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/usuario/pesquisar/alterar.do?op=encaminharIncluir"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/usuario/alterarSenha.do?op=encaminharAlterarCadastro"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.alterar"/> Próprio</a></li>
		
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
		<li><a href="<c:out value="${base}"/>/usuario/alterarSenha.do?op=encaminharAlterarCadastro"><bean:message key="bsc.label.usuario"/> <bean:message key="bsc.botao.alterar"/> Próprio</a></li>
		<li><a href="<c:out value="${base}"/>/unidade/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.unidade"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/unidade/consultar.do?op=consultarVarios"><bean:message key="bsc.campo.unidade"/> <bean:message key="bsc.botao.alterar"/></a></li>
		<li><a href="<c:out value="${base}"/>/papel/encaminha/incluir.do?op=encaminharIncluir"><bean:message key="bsc.campo.papel"/> <bean:message key="bsc.botao.incluir"/></a></li>
		<li><a href="<c:out value="${base}"/>/papel/consultar.do?op=consultarVarios"><bean:message key="bsc.campo.papel"/> <bean:message key="bsc.botao.alterar"/></a></li>
		</c:if>
	
	</ul>
</div>
