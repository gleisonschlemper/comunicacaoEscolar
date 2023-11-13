package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Aluno extends Pessoa {
	private Pais pais;
	private Matricula matricula;
	private Endereco endereco;
	private ArrayList <Matricula> matriculas = new ArrayList<>();
	private ArrayList <Mensagem> mensagens = new ArrayList<>();
    private String email;
    private String senha;
    
    // Seta somente CPF do aluno 
    public Aluno(String cpf) {
    	 super(cpf);
    }
    
    // Seta somente CPF e Matricula do aluno 
    public Aluno(Matricula matricula,String cpf) {
    	 super(cpf);
    	 this.setMatricula(matricula);
    	 this.setMatriculas(matricula);
    }

	// Seta informações importante para encontrar o aluno
    public Aluno(String cpf, String nome, String sobrenome, String email, int idade, Date nascimento) {
    	 super(cpf,nome,sobrenome,idade,nascimento);
    	 setMatricula(getMatricula());
    	 setEmail(email);
    }
    

    
    // Seta matricula do aluno 
    public Aluno(String cpf, String nome, String sobrenome, String email,String senha, int idade, Date dataNascimento, Matricula matricula) {
    	super(cpf,nome,sobrenome,idade,dataNascimento);
        setEmail(email);
        setSenha(senha);
        setMatriculas(matricula);
        setMatricula(matricula);
    }

    // Seta sem matricula do aluno
    public Aluno(String cpf, String nome, String sobrenome, String email,String senha, int idade, Date dataNascimento) {
        super(cpf,nome,sobrenome,idade,dataNascimento);
        this.email = email;
        this.senha = senha;
    }
    
    
	 
    public Endereco getEndereco() {
		return endereco;
	}

	public void addEndereco (Endereco endereco) {
		this.endereco = endereco;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public ArrayList <Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas (Matricula matriculaAluno) {
		this.matriculas.add(matriculaAluno);
	}
    
    public ArrayList <Mensagem> getMensagens() {
		return this.mensagens;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addPais(Pais pais) {
    	this.pais = pais;
    }
    
    public Pai verPai() {
    	return this.pais.getPai();
    }
    
    public Mae verMae() {
    	return this.pais.getMae();
    }
    
    public String nomeDaMae () {
    	return this.verMae().getNome();
    }

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
}
