package br.com.intraBSC.modelo;

public class RelacionamentosTO {

	private int BSCIDBSC;
	private int BSCIDPERS;
	private int PERSIDPERS;
	private int PERSIDOBJ;
	private int OBJIDTHEME;
	private int OBJIDOBJ;
	
	public int getBSCIDBSC() {
		return BSCIDBSC;
	}
	public void setBSCIDBSC(int bscidbsc) {
		BSCIDBSC = bscidbsc;
	}
	public int getBSCIDPERS() {
		return BSCIDPERS;
	}
	public void setBSCIDPERS(int bscidpers) {
		BSCIDPERS = bscidpers;
	}
	public int getOBJIDOBJ() {
		return OBJIDOBJ;
	}
	public void setOBJIDOBJ(int objidobj) {
		OBJIDOBJ = objidobj;
	}
	public int getOBJIDTHEME() {
		return OBJIDTHEME;
	}
	public void setOBJIDTHEME(int objidtheme) {
		OBJIDTHEME = objidtheme;
	}
	public int getPERSIDOBJ() {
		return PERSIDOBJ;
	}
	public void setPERSIDOBJ(int persidobj) {
		PERSIDOBJ = persidobj;
	}
	public int getPERSIDPERS() {
		return PERSIDPERS;
	}
	public void setPERSIDPERS(int persidpers) {
		PERSIDPERS = persidpers;
	}

}
