package Model;

import java.sql.Date;

public class Mae extends Pessoa {
	public Mae(String cpf, String nome, String sobrenome, int idade, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
	}
	
	public Mae (String cpf) {
		super(cpf);
	}
}
