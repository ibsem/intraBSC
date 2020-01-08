<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
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
	<div style="overflow:auto; left:100px; top:190px; width: 505px; height: 300px ">
		<table style="width: 400px" cellpadding="0" cellspacing="0">
			<tr>
				<td style="color:#FF0000">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/erro.gif" border="0">
					<html:errors/>
				</td>
			</tr>
			<tr>
				<td>
					<span style="float: right;"><br />
						<button type="button" onclick="javascript:history.back();" class="botaoPreto" style="vertical-align: middle">
							<img src="<c:out value="${base}"/>/WEB/imagens/comum/voltar.gif" border="0" style="vertical-align: text-bottom">
							<bean:message key="pro.botao.voltar"/>
						</button>
					</span>
				</td>
			 </tr>
		</table>
	</div>