<script type="text/javascript" src="<c:out value="${base}"/>/WEB/imagens/js/funcoes.js"></script>
<body onload="window.close();">
<%@ taglib uri="/tags/displaytag" prefix="displaytag" %>
<form name="frmImpressao">
<input type="hidden" name="elementoID" value="<%= request.getParameter("elementoID") %>">
</form>

<script>
	imprimirConteudo();
</script>

</body>