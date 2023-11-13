package Model;

import java.sql.Date;

public class Pessoa {
    private int idade;
    private Date dataNascimento;
    private String cpf;
    private String nome;
    private String sobrenome;
    
    public Pessoa() {}
    
    public Pessoa(String cpf) {
    	setCpf(cpf);
    }
    
	public Pessoa(String cpf, String nome, String sobrenome, int idade, Date dataNascimento) {
		setCpf(cpf);
		setIdade(idade);
		setDataNascimento(dataNascimento);
		setNome(nome);
		setSobrenome(sobrenome);

	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
