package br.com.intraBSC.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	private static final String hexDigits = "0123456789abcdef";	
	
	public Criptografia(){
	}
	
	public static String criptografar(String senha) throws NoSuchAlgorithmException{
		MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
		sha1.reset();
		String str = senha;
		sha1.update(str.getBytes());
		return byteArrayToHexString(sha1.digest());
	}
		
	/* Converte o array de bytes em uma representa??o hexadecimal.*/
	private static String byteArrayToHexString(byte[] b) {
		
		StringBuffer buf = new StringBuffer();		    
		for (int i = 0; i < b.length; i++) {
			int j = ((int) b[i]) & 0xFF; 
		    buf.append(hexDigits.charAt(j / 16)); 
		    buf.append(hexDigits.charAt(j % 16)); 
		}
		return buf.toString();
	}
	
	
	public static String descritografar(String senha) throws NoSuchAlgorithmException{			
		MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
		sha1.reset();
		String str = senha;
		sha1.update(str.getBytes());
		return byteArrayToHexString(sha1.digest());
	}
	
	
	/*Converte uma String hexa no array de bytes correspondente.
	private static byte[] hexStringToByteArray(String hexa) throws IllegalArgumentException {
		 if (hexa.length() % 2 != 0) {
			 throw new IllegalArgumentException("String hexa inv?lida");  
		 }
		 byte[] b = new byte[hexa.length() / 2];
    
		 for (int i = 0; i < hexa.length(); i+=2) {
			 b[i / 2] = (byte) ((hexDigits.indexOf(hexa.charAt(i)) << 4) | (hexDigits.indexOf(hexa.charAt(i + 1))));          
		 }
		 return b;
	 }*/
	
}
