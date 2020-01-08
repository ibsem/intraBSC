/**
 * @author Ibsem Agrello Dias 01/07/2007
 */
package br.com.intraBSC.util;

import java.util.*;
import java.applet.Applet;
import java.awt.*;
import br.com.intraBSC.util.LineDrawer;

public class MapaGrafico extends Applet  {
	
	public void print (Graphics g){
		paint (g);
	}
    public void paint (Graphics g)
    {
    	super.paint(g);
    	Graphics2D g2d = (Graphics2D) (g);  
    	int numeroPerspectivas = Integer.parseInt(getParameter("numPersp"))+1;
    	String nomePerspectiva = "";
    	String idPerspectiva = "";
    	int idObjetivo = 1;
     	int xInicialPerspectiva = 0;
    	int yInicialPerspectiva = 0;
    	int xFinalPerspectiva = 0;
    	int yFinalPerspectiva = 0;
    	
    	//Desenha as Perspectivas
    	for (int perspectivas = 1; perspectivas < numeroPerspectivas ; perspectivas++){
    	idPerspectiva = String.valueOf(perspectivas);
    	String perspectiva = getParameter("per"+idPerspectiva);
    	StringTokenizer perspectivaToken = new StringTokenizer(perspectiva, "|");
    	xInicialPerspectiva = Integer.parseInt(String.valueOf(perspectivaToken.nextElement()));
	    yInicialPerspectiva = Integer.parseInt(String.valueOf(perspectivaToken.nextElement()));
		xFinalPerspectiva = Integer.parseInt(String.valueOf(perspectivaToken.nextElement()));
		yFinalPerspectiva = Integer.parseInt(String.valueOf(perspectivaToken.nextElement()));
		nomePerspectiva = String.valueOf(perspectivaToken.nextElement());
		g2d.setColor(Color.black);
		g2d.drawRect(xInicialPerspectiva, yInicialPerspectiva, xFinalPerspectiva-xInicialPerspectiva, yFinalPerspectiva-yInicialPerspectiva);
    	g2d.drawString(nomePerspectiva, 10, yInicialPerspectiva + 13);
    	}
    	int idObj = 0;
    	int xInicialObjetivo = 0;
    	int yInicialObjetivo = 0;
    	int xFinalObjetivo = 0;
    	int yFinalObjetivo = 0;
    	int xCausaEfeito = 0;
    	int yCausaEfeito = 0;
    	int idTemaCor ;
    	int xCausaEfeitoCau = 0;
    	int yCausaEfeitoCau = 0;
    	int xCausaEfeitoEfe = 0;
    	int yCausaEfeitoEfe = 0;
    	int idObjCau = 0;
    	int idObjEfe = 0;
    	int idCausaEfeito=1;
    	int numCausaEfeito = Integer.parseInt(String.valueOf(getParameter("numCauEfe")))+1;
    	String nomeObjetivo = "";
    	String intensidade = "";
    	String interacao = "";
    	float intensidadeLinha = 1.0F;
    	int ySeta = 0;
    	int yInicialSeta = 0;
    	Color corSeta = Color.BLACK;
    	//Desenha as linhas de Causa Efeito
    	while (numCausaEfeito > idCausaEfeito) {
		String causa = getParameter("cau"+idCausaEfeito);
		StringTokenizer causaToken = new StringTokenizer(causa, "|");
		idObjCau = Integer.parseInt(String.valueOf(causaToken.nextElement()));
		idObjetivo=1;
			do {    	
				String objetivo = getParameter("obj"+idObjetivo);
				StringTokenizer objetivoToken = new StringTokenizer(objetivo, "|");
				objetivoToken.nextElement();
				yInicialObjetivo = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
				objetivoToken.nextElement();
				objetivoToken.nextElement();
				objetivoToken.nextElement();
				idObj = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
				if (idObj == idObjCau){
				xCausaEfeitoCau = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
				yCausaEfeitoCau = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));	
				yInicialSeta = yInicialObjetivo;
				}
				idObjetivo = idObjetivo + 1;
			} while (idObj != idObjCau);	
		idObjEfe = Integer.parseInt(String.valueOf(causaToken.nextElement()));	
		idObjetivo=1;
			do {    	
				String objetivo = getParameter("obj"+idObjetivo);
				StringTokenizer objetivoToken = new StringTokenizer(objetivo, "|");
				objetivoToken.nextElement();
			    objetivoToken.nextElement();
				objetivoToken.nextElement();
				yFinalObjetivo = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
				objetivoToken.nextElement();
				idObj = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
				if (idObj == idObjEfe){
				xCausaEfeitoEfe = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
				yCausaEfeitoEfe = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));	
				ySeta = yFinalObjetivo;
				}
				idObjetivo = idObjetivo + 1;
			} while (idObj != idObjEfe);
		intensidade = String.valueOf(causaToken.nextElement());
		interacao = String.valueOf(causaToken.nextElement());
		g2d.setColor(Color.black);
		if (intensidade.equals("fraco")){
			intensidadeLinha = 1.0F;	
			}else if (intensidade.equals("medio")){
			intensidadeLinha = 1.0F;
			}else {
			intensidadeLinha = 1.0F;
			}
		if (interacao.equals("positivo")){
			corSeta = Color.green.darker();	
			}else {
			corSeta = Color.RED.darker();
			};
		LineDrawer seta = new LineDrawer (xCausaEfeitoCau,yInicialSeta,xCausaEfeitoEfe,ySeta);
		seta.draw(g2d,intensidadeLinha,corSeta);
		
		idCausaEfeito = idCausaEfeito + 1;
		}; 
		// desenha os Objetivos
    	int tamanhoFonte = 12;
		idObjetivo=1;
    	
    	while (getParameter("obj"+idObjetivo)!=null){    	
    		String objetivo = getParameter("obj"+idObjetivo);
    		StringTokenizer objetivoToken = new StringTokenizer(objetivo, "|");
    		xInicialObjetivo = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		yInicialObjetivo = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		xFinalObjetivo = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		yFinalObjetivo = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		nomeObjetivo = String.valueOf(objetivoToken.nextElement());
    		idObj = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		xCausaEfeito = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		yCausaEfeito = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		idTemaCor = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
    		tamanhoFonte = Integer.parseInt(String.valueOf(objetivoToken.nextElement()));
			
    		//inserir os dados da coordenada xy e id dos objetivos em array
    		int xTexto = 0;
    		int tamanho = nomeObjetivo.length();
    		int tamanhoTotal = tamanho;
    		String trema = "";
    		if (tamanhoFonte ==12){
    			xTexto = (int) Math.round(tamanho*7.0);
    			if (xTexto >= xFinalObjetivo-xInicialObjetivo)
    				{
    				xTexto= (xFinalObjetivo-xInicialObjetivo)-15;
    				tamanho = (int) Math.round(xTexto/7.0);
    				trema="...";
    				}
    		} else {
    			xTexto = (int) Math.round(tamanho*5.3);
    			if (xTexto >= xFinalObjetivo-xInicialObjetivo)
    				{
    				xTexto= (xFinalObjetivo-xInicialObjetivo)-8;
    				tamanho = (int) Math.round(xTexto/5.3);
    				trema="...";
    						}
    		}
    		g2d.setColor(Color.getHSBColor(80,idTemaCor,100));
    		g2d.fillOval(xInicialObjetivo, yInicialObjetivo, xFinalObjetivo-xInicialObjetivo, yFinalObjetivo-yInicialObjetivo);
    		g2d.setStroke(new BasicStroke(1.0F));
    		g2d.setColor(Color.black);
    		g2d.drawOval(xInicialObjetivo, yInicialObjetivo, xFinalObjetivo-xInicialObjetivo-1, yFinalObjetivo-yInicialObjetivo-1);
     		g2d.setFont( new Font("Arial", Font.PLAIN,tamanhoFonte));
    		// nomes dos objetivos
    		g2d.drawString(nomeObjetivo.substring(0,tamanho), xCausaEfeito-((xTexto-4)/2) , yCausaEfeito-8);
    		if (tamanhoTotal <= 2*tamanho){
    		g2d.drawString(nomeObjetivo.substring(tamanho,tamanhoTotal), xCausaEfeito-((xTexto-3)/2) , yCausaEfeito+4 );
    		}else{
        	g2d.drawString(nomeObjetivo.substring(tamanho,2*tamanho), xCausaEfeito-((xTexto-3)/2) , yCausaEfeito+4 );
        	if (tamanhoTotal <= 3*tamanho){
        	g2d.drawString(nomeObjetivo.substring(2*tamanho,tamanhoTotal), xCausaEfeito-((xTexto-4)/2) , yCausaEfeito+15 );	
        	}else{
        	g2d.drawString(nomeObjetivo.substring(2*tamanho,3*tamanho), xCausaEfeito-((xTexto-4)/2) , yCausaEfeito+15 );	
        	}
    		}
    		
    		idObjetivo = idObjetivo + 1;	
			};
    		
    }
}
