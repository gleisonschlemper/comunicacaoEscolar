package Model;

import java.sql.Date;

public class Administrador extends Pessoa {
	private static String cargo = "Admin";
	
	public Administrador(String cpf, String nome, String sobrenome, int idade, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
	}

	public static String getCargo() {
		return cargo;
	}
}
