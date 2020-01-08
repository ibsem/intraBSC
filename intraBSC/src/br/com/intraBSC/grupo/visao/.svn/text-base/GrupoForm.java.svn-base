package br.com.intraBSC.grupo.visao;

import java.text.ParseException;

import org.apache.struts.validator.ValidatorForm;

import br.com.intraBSC.modelo.GrupoTO;
import br.com.intraBSC.util.DataUtil;

public class GrupoForm  extends ValidatorForm{

	
	private int codigo;
	private String descricao;
	private int ativo;
	private String dataUso;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setGrupoTO(GrupoTO grupoTO) throws Exception{
		grupoTO.setCodigo(getCodigo());
		grupoTO.setDescricao(getDescricao());
		grupoTO.setAtivo(getAtivo());
		if ((getDataUso() != null) && (!getDataUso().equals(""))){
			grupoTO.setDataUso(DataUtil.strToDateSql(getDataUso()));
		}
	}
	
	public void setGrupoForm(GrupoTO grupoTO) throws ParseException{
		setCodigo(grupoTO.getCodigo());
		setDescricao(grupoTO.getDescricao());
		setAtivo(grupoTO.getAtivo());
		if (grupoTO.getDataUso() != null){
			setDataUso(DataUtil.formataDataSql(grupoTO.getDataUso()));
		}
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public String getDataUso() {
		return dataUso;
	}
	public void setDataUso(String dataUso) {
		this.dataUso = dataUso;
	}
}
