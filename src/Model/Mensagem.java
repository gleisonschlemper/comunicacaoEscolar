package Model;

import java.util.Date;

public class Mensagem {
	private String assunto;
	private String conteudo;
	private Date dataEnvio;
	private Date horaEnvio;
	
	public Mensagem(String usuario, String assunto, String conteudo,Date dataEnvio, Date horaEnvio) {
		this.assunto = assunto;
		this.conteudo = conteudo;
		this.dataEnvio = dataEnvio;
		this.horaEnvio = horaEnvio;
	}

	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Date getHoraEnvio() {
		return horaEnvio;
	}
	public void setHoraEnvio(Date horaEnvio) {
		this.horaEnvio = horaEnvio;
	}
	
	
}
