package Controller;

import java.util.List;

import Model.Aluno;
import Model.Endereco;
import Model.Pais;

public interface IControleEscola {
	
	 // PARTE DO GERENCIAMENTO DO ALUNO
	 List <Aluno> listarAlunos (); 
	 boolean cadastrarAluno(Aluno aluno);
	 boolean verificarAlunoExiste(Aluno aluno);
	 boolean alterarAluno(Aluno aluno);
	 boolean alterarEnderecoAluno(Aluno aluno);
	 boolean deletarAluno(Aluno aluno);
	 Aluno verAluno(Aluno aluno);

	// PARTE DO GERENCIAMENTO DOS PAIS
	boolean deletarPais(Pais pais); 
	boolean cadastrarPais(Pais pais); 
	Pais verPais(Pais pais);
	boolean verificarPaisExiste(Pais pais);
	
	// PARTE DO GERENCIAMENTO DO ENDEREÇO
	Endereco verEndereco (Endereco endereco);
	boolean verificarEndereco(Endereco endereco);
	boolean cadastrarEndereco(Endereco endereco);
	boolean deletarEndereco(Endereco endereco);

	
	
	// PARTE DA MENSAGEM 
	
	
	

}
