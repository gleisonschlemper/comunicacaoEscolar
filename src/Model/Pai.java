package Model;

import java.sql.Date;

public class Pai extends Pessoa {
	public Pai(String cpf, String nome, String sobrenome, int idade, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
	}
	
	public Pai (String cpf) {
		super(cpf);
	}
}
