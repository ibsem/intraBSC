<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<script language="javascript" type="text/javascript">
	
	<%String form = request.getParameter("formAnce");%>
	<%String acao = request.getParameter("acao").replace('$','&');%>
	function fechar(){
		window.opener.location.href = "<%=acao%>";
		window.close();
	}
	function aumentarJanela(){
		window.resizeTo(430,345);
	}
</script>

<html:html>
  <head>
    <title></title>
  </head>
	<body onload="fechar();">
 </body>
</html:html>

