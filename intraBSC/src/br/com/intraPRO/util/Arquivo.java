//Source file: c:\\Java\\workspace\\AD\\WEB-INF\\src\\br\\com\\bb\\apoiodesenvolvimentoproducao\\ad\\util\\Arquivo.java

package br.com.intraPRO.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;




/**
 * Método utilitários para tratamento dos arquivos na aplicação.
 * @author CETI
 * @version 1.0
 */
public class Arquivo {

	public static final String EXT_XML = "XML";   
	public static final String EXT_HTM = "HTM";
	public static final String EXT_MOD = "ERX";
	public static final String EXT_OLD = "OLD";	
	public static final String EXT_CTL = "CTL";
	public static final String EXT_SQL = "SQL";	

   public Arquivo() {
   }
   
   /**
    * Envia o arquivo para download na máquina do cliente.
    * @roseuid 3EFC7ACB03D4
    */
	public static void download(byte[] bytesArquivo, String nomeArquivo, HttpServletResponse response) throws IOException {
   		// Limpando o conteúdo do response
   		response.reset();
		// Definindo os parâmetros do header 		
		response.setIntHeader("Content-Length", bytesArquivo.length);						// Tamanho em bytes do binário
		response.setHeader("Content-Disposition", "attachment; filename=" + nomeArquivo);	// Definindo o nome do arquivo
		// Definindo o contentType do arquivo para sempre realizar o download, não abrir diretamente
   		response.setContentType("application/download");
   		// Enviando os bytes do arquivo para o response
		response.getOutputStream().write(bytesArquivo);
		// Fechado a outputstream do response
		response.getOutputStream().close();
	}
	
	public static void download(File arquivo, String nomeArquivo, HttpServletResponse response) throws IOException {
		byte[] bytesArquivo = new byte[new Long(arquivo.length()).intValue()];
		FileInputStream inputFile = new FileInputStream(arquivo);
		inputFile.read(bytesArquivo);
		download(bytesArquivo,nomeArquivo,response);
	}
	
	/**
	* Envia o arquivo XML do glossário para download pelo conversor de modelos standalone.	
	*/
	/*private static void downloadXML(byte[] bytesArquivo, java.lang.String nomeArquivo, javax.servlet.http.HttpServletResponse response) throws IOException {
		// Limpando o conteúdo do response
		response.reset();
		// Definindo os parâmetros do header 		
		response.setIntHeader("Content-Length", bytesArquivo.length);						// Tamanho em bytes do binário
		// Definindo o contentType do arquivo
		response.setContentType("text/xml");
		// Enviando os bytes do arquivo para o response
		response.getOutputStream().write(bytesArquivo);
		// Fechado a outputstream do response
		response.getOutputStream().close();
	}*/	
	
				
}
