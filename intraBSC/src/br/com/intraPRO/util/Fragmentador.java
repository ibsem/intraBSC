/*
 * Created on 29/03/2005
 *
 */
package br.com.intraPRO.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Fragmentador {
	
	private static final int TAM_LINHA = 29696; // Definição do tamanho de cada fragmento.
    private static BASE64Encoder encoder = new BASE64Encoder();
	private static BASE64Decoder decoder = new BASE64Decoder();
	private static String strBase64 = "";
	private static byte[] bytesArquivo = null;	
	

	public static HashMap fragmentarArquivo(InputStream inputStream) {
		try	{
			bytesArquivo = new byte[inputStream.available()];			 
			inputStream.read(bytesArquivo);
			
			// Retira alguns caracteres desnecessarios que sao incluidos pelo sistema 
			strBase64 = retiraCaracterEspecial(encoder.encodeBuffer(bytesArquivo));
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException eis) {
				eis.printStackTrace();
			}
		}
		// Chama o método que monta a HashMap com os fragmentos prontos para serem inseridos no DB2.
		return montaHashMapFragmentos(strBase64);
	}	
	
	

	@SuppressWarnings("unchecked")
	private static HashMap montaHashMapFragmentos(String strArquivo){
		HashMap hashMap = new HashMap();
		int tamString = strArquivo.length();
		int inicio = 0;
		    
		if (tamString > 0 ) {
		    
		    // Define o número de fragmentos a serem gerados.
		   int contPartes = tamString / TAM_LINHA;
		   
		   // Gera os fragmentos do arquivo
		   for (int i = 0; i < contPartes; i++) {
	   	      hashMap.put(new Integer(i), strArquivo.substring(inicio, inicio + TAM_LINHA));
              inicio += TAM_LINHA;
		   }
		   
		   // Define no HashMap os fragmentos a serem incuidos no DB2
		   if (strArquivo.substring(inicio).trim().length() > 0 ) {
		   	  hashMap.put(new Integer(contPartes), strArquivo.substring(inicio));    
		   }
		}
		return hashMap; 
	}
	

	private static String montaFragmentos(HashMap hashMapFragmentos){
		StringBuffer strMontada = new StringBuffer();
		
		// Concatena cada fragmento na StringBuffer strMontada.
		for (int i = 0; i < hashMapFragmentos.size(); i++) {
		  strMontada.append(hashMapFragmentos.get(new Integer(i))); 
		}
		return strMontada.toString(); 
	}
	
	

	private static String retiraCaracterEspecial(String string){
		StringTokenizer strToken = new StringTokenizer(string, "\r\n");
		StringBuffer strBuffer = new StringBuffer();
		while (strToken.hasMoreElements()){
			strBuffer.append(strToken.nextElement());
		}
		return strBuffer.toString();
	}
	
	

	public static byte[] recuperaArrayByteArquivo(HashMap hashMap){
        String strBase64 = montaFragmentos(hashMap);
        byte[] vetByte = null;
		try {
		  vetByte = decoder.decodeBuffer(strBase64);
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return vetByte;
	}
	
	
	public static String reconstruirArquivo(HashMap hashMap){
        return montaFragmentos(hashMap);
	}
}