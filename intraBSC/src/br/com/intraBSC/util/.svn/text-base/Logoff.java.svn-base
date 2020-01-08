package br.com.intraBSC.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;

public class Logoff  extends HttpServlet{

	public void  doService(){
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		UsuarioTO user = (UsuarioTO) request.getSession().getAttribute("usuarioBSC");
		request.getSession().setAttribute("usuarioBSC", null);
		response.sendRedirect(request.getContextPath()+ "/index.jsp");
	}

	@SuppressWarnings("unused")
	private void alterarOnline(UsuarioTO usuarioTO, Integer tipoStatus) throws ExceptionNegocioBSC{
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.alterarOnline(usuarioTO);
	}
}