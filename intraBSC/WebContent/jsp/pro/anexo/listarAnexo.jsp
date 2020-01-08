<script language="JavaScript">
	var anexoEstado = "fechado";
	function abreFechaAnexo(){
		var anexo = document.getElementById('anexo');
		if (anexo != null){
			if ((anexoEstado == "fechado")){
				dojo.lfx.html.wipeOut(anexo, 400).play();
				anexoEstado = "aberto";
			}else{
				dojo.lfx.html.wipeIn(anexo, 400).play();
				anexoEstado = "fechado";
			}
		}
	}
</script>
<div id="anexo">
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
		<logic:empty name="listaAnexos" scope="session">
			<tr valign="top" height="100%">
			<td>&nbsp;</td>
			<tr>
		</logic:empty>
		<logic:notEmpty name="listaAnexos" scope="session">
				
			<tr valign="top" height="100%">
				<td>
					<displaytag:table name="listaAnexos" id="anexo" class="link" requestURI="" scope="session" style="border:none;border-color:black;width:500px">
						<displaytag:column style="width:90%;" >
							<a href="#" onclick="javascript: download(<c:out value='${anexo.anoCriacao}' />, <c:out value='${anexo.numeroSequencialTarefa}' />, <c:out value='${anexo.numeroSequencialArquivo}' /> )" >
								<c:out value="${anexo.nome}"/>
							</a>
						</displaytag:column>
						<displaytag:column style="width:10%;" >
							<a href="#" onclick="javascript: download(<c:out value='${anexo.anoCriacao}' />, <c:out value='${anexo.numeroSequencialTarefa}' />, <c:out value='${anexo.numeroSequencialArquivo}' /> )" >
								<c:out value="${anexo.tamanho}"/>
							</a>
						</displaytag:column>
					
					</displaytag:table>
				</td>
			</tr>
		</logic:notEmpty>
		<tr>
			<td colspan="3" valign="bottom" align="right">
				<button type="button" onclick="incluirAnexos();" class="botaoPreto" style="vertical-align: middle">
					<img src="<c:out value="${base}"/>/WEB/imagens/comum/anexar.gif" border="0" style="vertical-align: text-bottom">
					<bean:message key="pro.botao.adicionarExcluir"/>
				</button>
			</td>
		</tr>
	</table>
</div>