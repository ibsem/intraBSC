package br.com.intraBSC.util;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmail extends Authenticator 	{
	
	private static final ResourceBundle CONFIG = ResourceBundle.getBundle("recursos.email");
	

	@SuppressWarnings("static-access")
	public static void email(String addTO,String addFrom,String titulo,String mensagem) throws Exception{
		try {
			Properties props = new Properties();
			
			props.put("mail.smtps.host",CONFIG.getString("email.hostname"));
			props.put("mail.smtps.port", CONFIG.getString("email.port"));						
			props.put("mail.smtps.auth", "true");
			props.put("mail.smtps.starttls.enable", "true");
			props.put("mail.smtps.socketFactory.port", CONFIG.getString("email.port"));
			props.put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtps.socketFactory.fallback", "false"); 
			
			Authenticator auth = new MyAuthenticator();
			
			Session session = Session.getDefaultInstance(props, auth);
			session.setDebug(true);
			
			Message msg = new MimeMessage(session);
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(addTO));			
			
			msg.setFrom(new InternetAddress(addFrom));
			msg.setText(mensagem);
			msg.setSubject(titulo);
			msg.setContent(mensagem, "text/plain");
			
			Transport tr = session.getTransport("smtps");
			tr.connect(CONFIG.getString("email.hostname"), new MyAuthenticator().getPasswordAuthentication().getUserName(), 
					new MyAuthenticator().getPasswordAuthentication().getPassword());
			
			tr.sendMessage(msg, new Address[] { new InternetAddress(addTO) });
					
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	public static ResourceBundle getCONFIG() {
		return CONFIG;
	} 
}

class MyAuthenticator extends Authenticator	{  
	private String user = EnviarEmail.getCONFIG().getString("email.user");
	private String pass = EnviarEmail.getCONFIG().getString("email.pass");
 
 
	public MyAuthenticator() {
	}
 
 
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user,pass);
	}

}
