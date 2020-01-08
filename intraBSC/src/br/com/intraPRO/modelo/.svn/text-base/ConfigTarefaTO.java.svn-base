package br.com.intraPRO.modelo;

import java.util.Collection;

import br.com.intraBSC.modelo.UsuarioTO;

public class ConfigTarefaTO {
   private int codigoConfigTarefa;
   private int numDiasPrevistos;
   private String indTipoVigencia;
   private String textoConfigTarefa;
   private int codigoPrefGestorTipo;
   private String prefixoNomeTarefa;
   private int indVisivelPrefixo;
   
   private int codCriticidadeIniTarefa;
   private int codEstadoIniTarefa;
   private String txtSolicitacaoIniTarefa;   
   private String nomeIniTarefa;
   
   private int idResponsavel;
   
   private UsuarioTO usuarioTO;
   
   /*Variavel utilizada para setar o valor da sinalização da pior tarefa. Esta variavel é utilizada na tela principal*/
   private int valorSinal;
   /*Carrega todas as tarefas de um determinado tipo de tarefa*/
   private Collection listaTarefas;
   
   public ConfigTarefaTO(){
   }
		/**
		 * @return Returns the codigoPrefGestorTipo.
		 */
		public int getCodigoPrefGestorTipo() {
			return codigoPrefGestorTipo;
		}
		/**
		 * @param codigoPrefGestorTipo The codigoPrefGestorTipo to set.
		 */
		public void setCodigoPrefGestorTipo(int codigoPrefGestorTipo) {
			this.codigoPrefGestorTipo = codigoPrefGestorTipo;
		}
		/**
		 * @return Returns the codigoConfigTarefa.
		 */
		public int getCodigoConfigTarefa() {
			return codigoConfigTarefa;
		}
		/**
		 * @param codigoConfigTarefa The codigoConfigTarefa to set.
		 */
		public void setCodigoConfigTarefa(int codigoConfigTarefa) {
			this.codigoConfigTarefa = codigoConfigTarefa;
		}
		/**
		 * @return Returns the indTipoVigencia.
		 */
		public String getIndTipoVigencia() {
			return indTipoVigencia;
		}
		/**
		 * @param indTipoVigencia The indTipoVigencia to set.
		 */
		public void setIndTipoVigencia(String indTipoVigencia) {
			this.indTipoVigencia = indTipoVigencia;
		}
		/**
		 * @return Returns the numDiasPrevistos.
		 */
		public int getNumDiasPrevistos() {
			return numDiasPrevistos;
		}
		/**
		 * @param numDiasPrevistos The numDiasPrevistos to set.
		 */
		public void setNumDiasPrevistos(int numDiasPrevistos) {
			this.numDiasPrevistos = numDiasPrevistos;
		}
		/**
		 * @return Returns the textoTipTarefa.
		 */
		public String getTextoConfigTarefa() {
			//trim aplicado aqui para evitar textbox com espaços
		    if(textoConfigTarefa!=null)
		        return textoConfigTarefa.trim();
		    else{
		        return textoConfigTarefa;
		    }
		}
		/**
		 * @param textoTipTarefa The textoTipTarefa to set.
		 */
		public void setTextoConfigTarefa(String textoTipTarefa) {
			this.textoConfigTarefa = textoTipTarefa;
		}

		/**
		 * @return Returns the prefixoNomeTarefa.
		 */
		public String getPrefixoNomeTarefa() {
			return prefixoNomeTarefa;
		}
		/**
		 * @param prefixoNomeTarefa The prefixoNomeTarefa to set.
		 */
	    /*Método utilizado para concatenar o prefixo e o nome da tarefa. Isto cria um único campo
	    * que é mostrado na tela de pesqusa, dentro combobox "Tipo de Tarefa"
	    */
		public void setPrefixoNomeTarefa(int prefixo, String prefixoNomeTarefa) {
			this.prefixoNomeTarefa = prefixo + " - " + prefixoNomeTarefa;
		}
		public int getIndVisivelPrefixo() {
			return indVisivelPrefixo;
		}
		public void setIndVisivelPrefixo(int indVisivelPrefixo) {
			this.indVisivelPrefixo = indVisivelPrefixo;
		}
		public int getValorSinal() {
			return valorSinal;
		}
		public void setValorSinal(int valorSinal) {
			this.valorSinal = valorSinal;
		}
		public void setPrefixoNomeTarefa(String prefixoNomeTarefa) {
			this.prefixoNomeTarefa = prefixoNomeTarefa;
		}
		public int getCodCriticidadeIniTarefa() {
			return codCriticidadeIniTarefa;
		}
		public void setCodCriticidadeIniTarefa(int codCriticidadeIniTarefa) {
			this.codCriticidadeIniTarefa = codCriticidadeIniTarefa;
		}
		public int getCodEstadoIniTarefa() {
			return codEstadoIniTarefa;
		}
		public void setCodEstadoIniTarefa(int codEstadoIniTarefa) {
			this.codEstadoIniTarefa = codEstadoIniTarefa;
		}
		public String getNomeIniTarefa() {
			return nomeIniTarefa;
		}
		public void setNomeIniTarefa(String nomeIniTarefa) {
			this.nomeIniTarefa = nomeIniTarefa;
		}
		public String getTxtSolicitacaoIniTarefa() {
			return txtSolicitacaoIniTarefa;
		}
		public void setTxtSolicitacaoIniTarefa(String txtSolicitacaoIniTarefa) {
			this.txtSolicitacaoIniTarefa = txtSolicitacaoIniTarefa;
		}
		public Collection getListaTarefas() {
			return listaTarefas;
		}
		public void setListaTarefas(Collection listaTarefas) {
			this.listaTarefas = listaTarefas;
		}
		public int getIdResponsavel() {
			return idResponsavel;
		}
		public void setIdResponsavel(int idResponsavel) {
			this.idResponsavel = idResponsavel;
		}
		public UsuarioTO getUsuarioTO() {
			return usuarioTO;
		}
		public void setUsuarioTO(UsuarioTO usuarioTO) {
			this.usuarioTO = usuarioTO;
		}


}
