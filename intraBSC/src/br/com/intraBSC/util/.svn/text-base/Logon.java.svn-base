package br.com.intraBSC.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;

public class Logon extends HttpServlet{
	
	public void  doService(){
	}
	
	private UsuarioTO logon(String login,String senha,HttpServletRequest request) throws FileNotFoundException, IOException{				        
		UsuarioTO usuarioTO = new UsuarioTO();
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioTO.setSenha(senha);
		usuarioTO.setLogin(login);
		UsuarioTO retorno = new UsuarioTO();
		
		try {
			retorno = usuarioBO.consultarLogon(usuarioTO);
			if((retorno.getIdUsuario() != 0)&&(!retorno.getPerfil().equals(""))){
				return retorno;
			}else{
				return null;
			}
		} catch (ExceptionNegocioBSC e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private void alterarOnline(UsuarioTO usuarioTO, Integer tipoStatus) throws ExceptionNegocioBSC{
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioTO.setOnline(tipoStatus);
		usuarioBO.alterarOnline(usuarioTO);
	}

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String urlDestino = "";
		DataUtil dataUtil = new DataUtil();
        if (((username == null) || (password == null)) ||
        	((username.equals(""))||(password.equals("")))) {
			urlDestino = "http://"+request.getServerName()+":" + 
						           request.getLocalPort()+""+ 
						           request.getContextPath()+"/encaminhaLogon.do";
		}else{
			UsuarioTO user = logon(username, password,request);
			if (user != null) {
				try {
					if ((user.getGrupoTO().getDataUso() != null) && 
						(dataUtil.comparaDatas(user.getGrupoTO().getDataUso()))){
						urlDestino = "http://"+request.getServerName()+":" + 
											   request.getLocalPort()+"" + 
											   request.getContextPath()+"/expirou.do";
					}else{
						request.getSession().setAttribute("usuarioBSC", user);
						((HttpServletRequest) request).getSession().removeAttribute("UsuarioSenhaInvalido");
						urlDestino = "http://"+request.getServerName()+":" + 
											   request.getLocalPort()+"" + 
											   request.getContextPath()+"/principal.do?op=telaPrincipal";
					}
				} catch (Exception e) {
					throw new ServletException("Ocorreu um erro na tentativa de logar no sistema.");
				}
			} else {
				if (urlDestino.equals(""))					
					urlDestino = "http://"+request.getServerName()+":" + 
										   request.getLocalPort()+"" + 
										   request.getContextPath()+"/encaminhaLogon.do";
					request.getSession().setAttribute("UsuarioSenhaInvalido","Login e/ou senha invalido.");
			}
		}
		response.sendRedirect(urlDestino);
	}
}