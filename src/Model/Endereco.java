package Model;

public class Endereco {
	private int codigo;
	private String rua;
	private String cidade;
	private int casanumero;
	private String cep;
	
	public Endereco (int codigo) {
		setCodigo(codigo);
	}
	
	public Endereco (int codigo,String rua, String cidade, int casanumero, String cep) {
		setCodigo(codigo);
		setRua(rua);
		setCidade(cidade);
		setCasanumero(casanumero);
		setCep(cep);
	}
	
	public Endereco(String rua, String cidade, int casanumero, String cep) {
		setRua(rua);
		setCidade(cidade);
		setCasanumero(casanumero);
		setCep(cep);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getCasanumero() {
		return casanumero;
	}
	
	public void setCasanumero(int casanumero) {
		this.casanumero = casanumero;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}	
}
