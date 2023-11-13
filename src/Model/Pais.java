package Model;

public class Pais {
	private Pai pai;
	private Mae mae;
	private String email;
	private String senha;
	private int codigo;
	
	public Pais(int codigo) {
		setCodigo(codigo);
	}
	
	public Pais(String email,String senha,Mae mae,Pai pai) {
		setEmail(email);
		setSenha(senha);
		setMae(mae);
		setPai(pai);
	}
	
	public Pais(Mae mae,Pai pai) {
		setMae(mae);
		setPai(pai);
	}

	public Pai getPai() {
		return pai;
	}
	
	public void setPai(Pai pai) {
		this.pai = pai;
	}
	
	public Mae getMae() {
		return mae;
	}
	
	public void setMae(Mae mae) {
		this.mae = mae;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
