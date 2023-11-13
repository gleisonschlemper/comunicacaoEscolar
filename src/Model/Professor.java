package Model;

import java.sql.Date;

public class Professor extends Pessoa{
	private static String cargo = "Professor";
	
	public Professor(String cpf, String nome, String sobrenome, int idade, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
	}
	
	public static String getCargo() {
		return cargo;
	}
}
