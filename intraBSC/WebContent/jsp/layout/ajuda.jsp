<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/c" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
function abrirAjuda(){
			window.open("<c:out value="${base}"/>/WEB/ajuda/ajuda.htm");
		}

		
</script>
<html>
<body>
<table width="650px">
		<tr>
		    <td align="left" class="titulo" style="border-bottom:thin; border-bottom-style:solid;"><bean:message key="bsc.label.ajuda"/></td>  
		</tr>
		
</table>
<table onmouseover="style.cursor='pointer'" border="0" width="650px" height="100px" cellpadding="0" cellspacing="0" >
  <tr>
    <td >
      <table cellpadding="0" cellspacing="0" >
        <tr>
        	<td class="texto1">&nbsp;&nbsp;
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/acoes.gif" border="0" style="vertical-align: text-bottom"
				onclick="abrirAjuda();">
				<a onclick="abrirAjuda();">Manual do Usu�rio em HTML</a>
			</td>
		</tr>
       <tr>
        	<td class="texto1">&nbsp;&nbsp;
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
				<a href="<c:out value="${base}"/>/folder.do?op=downloadManualOperacao">Manual do Usu�rio em PDF</a>
			</td>
		</tr>
    <tr>
        	<td class="texto1">&nbsp;&nbsp;
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
				<a href="<c:out value="${base}"/>/folder.do?op=downloadFolderProduto">A Solu��o IntraBSC</a>
			</td>
		</tr>
		<tr>
			<td class="texto1" >&nbsp;&nbsp;
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
				<a href="<c:out value="${base}"/>/folder.do?op=downloadFolderGrupo">O Grupo de Trabalho</a>
			</td>
		</tr>
		<tr>
			<td class="texto1">&nbsp;&nbsp;
				<img src="<c:out value="${base}"/>/WEB/imagens/comum/pdf.jpg" border="0" style="vertical-align: text-bottom">
				<a href="<c:out value="${base}"/>/folder.do?op=downloadFolderTecnico">As Especifica��es T�cnicas</a>
			</td>
		</tr>
        
        

      </table>
    </td>
   </tr>
</table>

</body>
</html>