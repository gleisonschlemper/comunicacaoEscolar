package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Aluno;
import Model.Endereco;
import Model.Matricula;
import Model.Pais;

public class Escola implements IControleEscola {
    private static Connection conn;

    // PRONTO
    public Escola() {
        conn = Conexao.conectaBanco(); // Obtem a conexão na classe Conexao.java
    }

    // PARTE DE VISUALIZAÇÃO DOS ALUNOS
    @Override
    public List <Aluno> listarAlunos () { // Função de Listar alunos da escola
        List<Aluno> alunos = new ArrayList<>(); // Array de alunos
        try  { // Execução do código corretamente 
            String querySelect = "SELECT * FROM tb_alunos"; // Cria o select do aluno
            
        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
            ResultSet rs = stmt.executeQuery(); // Executa o select
            while (rs.next()) { // Excuta quantos objetos foram encontrado
            	
            	Endereco endereco = this.verEndereco(new Endereco(rs.getInt("end_codigo")));
            	Pais pais = new Pais(rs.getInt("pais_codigo"));
            	
            	Aluno aluno = new Aluno( // Cria o objeto Aluno com os dados do banco de dados 
            			rs.getString("alu_cpf"),  // Seta o CPF 
                		rs.getString("alu_nome"), // Seta o nome 
                		rs.getString("alu_sobrenome"),  // Seta o Sobrenome
                		rs.getString("alu_email"),  // Seta o email 
                		rs.getString("alu_senha"), // Seta a senha
                		rs.getInt("alu_idade"), // Seta a idade 
                		rs.getDate("alu_datanascimento"), // Seta data de nacimento 
                		new Matricula( // Cria objeto matricula
                        	rs.getInt("alu_matricula"), // Seta a matricula 
                        	rs.getDate("alu_datamatricula") // Seta data de matricula 
                		)
                );
            	aluno.addEndereco(endereco);
            	aluno.addPais(pais);   	
            	alunos.add(aluno);  // Seta o indece onde pode ser encontrada objeto na memória RAM 
            }
        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
            System.out.println(e.getMessage()); // Mensagem de erro 
        }
        return alunos; // Retorna Array de Alunos da escola 
    }
    
    // PARTE DE CADASTRO 
    @Override
	public boolean cadastrarPais(Pais pais) {
		try {
			if(this.verificarPaisExiste(pais)) 
				  return false;  
			else {
					String queryInsertPais = "INSERT INTO tb_pais (pais_email, pais_senha, mae_nome, mae_sobrenome, mae_cpf, mae_idade, mae_datanascimento, pai_nome, pai_sobrenome, pai_cpf, pai_idade, pai_datanascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement stmtInsertPais = conn.prepareStatement(queryInsertPais);
					stmtInsertPais.setString(1, pais.getEmail());
					stmtInsertPais.setString(2, pais.getSenha());
					stmtInsertPais.setString(3, pais.getMae().getNome());
					stmtInsertPais.setString(4, pais.getMae().getSobrenome());
					stmtInsertPais.setString(5, pais.getMae().getCpf());
					stmtInsertPais.setInt(6, pais.getMae().getIdade());
					stmtInsertPais.setDate(7, pais.getMae().getDataNascimento());
					stmtInsertPais.setString(8, pais.getPai().getNome());
					stmtInsertPais.setString(9, pais.getPai().getSobrenome());
					stmtInsertPais.setString(10, pais.getPai().getCpf());
					stmtInsertPais.setInt(11, pais.getPai().getIdade());
					stmtInsertPais.setDate(12, pais.getPai().getDataNascimento());
					int linhasAfetadas = stmtInsertPais.executeUpdate();
					return linhasAfetadas > 0;
			}
		}
		catch (SQLException e) {
			  System.out.println(e.getMessage());
			}
		return false;
	}
	
	@Override
	public boolean cadastrarEndereco(Endereco endereco) {
	    if (verificarEndereco(endereco)) {
	        return false;
	    } else {
	        try {
	            String queryInsertEndereco = "INSERT INTO tb_enderecos (end_rua, end_cidade, end_casanumero, end_cep) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement stmtInsertEndereco = conn.prepareStatement(queryInsertEndereco)) {
	                stmtInsertEndereco.setString(1, endereco.getRua());
	                stmtInsertEndereco.setString(2, endereco.getCidade());
	                stmtInsertEndereco.setInt(3, endereco.getCasanumero());
	                stmtInsertEndereco.setString(4, endereco.getCep());
	                int linhasAfetadas = stmtInsertEndereco.executeUpdate();
	                return linhasAfetadas > 0; // Retorna verdadeiro se houve pelo menos uma algum INSERT NA TABELA
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    return false;
	}
	
	@Override
	public boolean cadastrarAluno(Aluno aluno) {
		if(this.verificarAlunoExiste(aluno)) 
        	return false;

		this.cadastrarEndereco(aluno.getEndereco());
		this.cadastrarPais(aluno.getPais());

		try {		
			Endereco endereco = this.verEndereco(aluno.getEndereco());
			Pais pais = this.verPais(aluno.getPais());
			
            String queryInsertAluno = "INSERT INTO tb_alunos (alu_cpf, alu_nome, alu_sobrenome, alu_email, alu_senha, alu_idade, alu_datanascimento, alu_datamatricula, end_codigo, pais_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtInsertAluno = conn.prepareStatement(queryInsertAluno);
            stmtInsertAluno.setString(1, aluno.getCpf());
            stmtInsertAluno.setString(2, aluno.getNome());
            stmtInsertAluno.setString(3, aluno.getSobrenome());
            stmtInsertAluno.setString(4, aluno.getEmail());
            stmtInsertAluno.setString(5, aluno.getSenha());
            stmtInsertAluno.setInt(6, aluno.getIdade());
            stmtInsertAluno.setDate(7, aluno.getDataNascimento());
            stmtInsertAluno.setDate(8, aluno.getMatricula().getDataMatricula());
            stmtInsertAluno.setInt(9, aluno.getEndereco().getCodigo());
            stmtInsertAluno.setInt(10, aluno.getPais().getCodigo());
            int linhasAfetadas = stmtInsertAluno.executeUpdate(); 
            return linhasAfetadas > 0;     	
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
    	return false;
    }
	
	// PARTE DE VISUALIZAÇÃO DE UM OBJETO 
	@Override
	public Pais verPais(Pais pais) {
	    try {
	        String querySelect = "SELECT * FROM tb_pais WHERE pai_cpf = ? AND mae_cpf = ? OR pais_codigo = ?";
	        PreparedStatement stmtQueryPais = conn.prepareStatement(querySelect);
	        stmtQueryPais.setString(1, pais.getPai().getCpf());
	        stmtQueryPais.setString(2, pais.getMae().getCpf());
	        stmtQueryPais.setInt(3, pais.getCodigo());
	        ResultSet rs = stmtQueryPais.executeQuery();
	        if (rs.next()) { // Verifica se há pelo menos uma linha no resultado
	        	pais.setCodigo(rs.getInt("pais_codigo"));
	            pais.setEmail(rs.getString("pais_email"));
	            pais.setSenha(rs.getString("pais_senha"));
	            pais.getMae().setNome(rs.getString("mae_nome"));
	            pais.getMae().setSobrenome(rs.getString("mae_sobrenome"));
	            pais.getMae().setCpf(rs.getString("mae_cpf"));
	            pais.getMae().setIdade(rs.getInt("mae_idade"));
	            pais.getMae().setDataNascimento(rs.getDate("mae_datanascimento"));
	            pais.getPai().setNome(rs.getString("pai_nome"));
	            pais.getPai().setSobrenome(rs.getString("pai_sobrenome"));
	            pais.getPai().setIdade(rs.getInt("pai_idade"));
	            pais.getPai().setCpf(rs.getString("pai_cpf"));
	            pais.getPai().setDataNascimento(rs.getDate("pai_datanascimento"));
	            return pais;
	         } 
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return pais; // Retorna os pais sem o código do banco de dados oque quer dizer que não foi encontrado o pais do aluno
	}
	
	// Ver o endereco completo
	@Override
	public Endereco verEndereco (Endereco endereco) {
		if(this.verificarEndereco(endereco)) {
			try {
			     String querySelect = "SELECT * FROM tb_enderecos WHERE end_rua = ? AND end_cidade = ? AND end_casanumero = ? AND end_cep = ? OR end_codigo = ?";
			     PreparedStatement stmt = conn.prepareStatement(querySelect);
			     stmt.setString(1, endereco.getRua());
			     stmt.setString(2, endereco.getCidade());
			     stmt.setInt(3, endereco.getCasanumero());
			     stmt.setString(4, endereco.getCep());
			     stmt.setInt(5, endereco.getCodigo());
			     ResultSet rs = stmt.executeQuery();
				     if(rs.next()) {
				    	 endereco.setCodigo(rs.getInt("end_codigo"));
				    	 endereco.setRua(rs.getString("end_rua"));
				    	 endereco.setCidade(rs.getString("end_cidade"));
				    	 endereco.setCasanumero(rs.getInt("end_casanumero"));
				    	 endereco.setCep(rs.getString("end_cep"));
						 return endereco;
				     }
			    } catch (SQLException e) {
			        System.out.println(e.getMessage());
			    }
		}
		 
		return endereco;
	}
	
	@Override
	public Aluno verAluno(Aluno aluno) {
	    if (verificarAlunoExiste(aluno)) {
	        String queryAluno = "SELECT * FROM tb_alunos WHERE alu_cpf = ? OR alu_matricula = ?";
	        try {
	            PreparedStatement stmt = conn.prepareStatement(queryAluno);
	            stmt.setString(1, aluno.getCpf());
	            stmt.setInt(2, aluno.getMatricula().getMatricula());
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	Endereco endereco = this.verEndereco(new Endereco(rs.getInt("end_codigo")));
	            	Pais pais = new Pais(rs.getInt("pais_codigo"));
	            
	                aluno.setCpf(rs.getString("alu_cpf"));
	                aluno.setNome(rs.getString("alu_nome"));
	                aluno.setSobrenome(rs.getString("alu_sobrenome"));
	                aluno.setEmail(rs.getString("alu_email"));
	                aluno.setSenha(rs.getString("alu_senha"));
	                aluno.setIdade(rs.getInt("alu_idade"));
	                aluno.setDataNascimento(rs.getDate("alu_datanascimento"));
	                aluno.setMatricula(
	                    new Matricula(
	                        rs.getInt("alu_matricula"),
	                        rs.getDate("alu_datamatricula")
	                    )
	                );
	                aluno.addEndereco(endereco);
	                aluno.addPais(pais);
	        	 return aluno;
	            }
	        } catch (SQLException e) {
	           System.out.println(e.getMessage());
	        }
	    }
	    return null; // Retorna null se não existe o aluno
	}
	
	// PARTE DE VIRIFICAÇÃO DE EXISTÊNCIA NO BANCO
	@Override
	public boolean verificarEndereco(Endereco endereco) {
	    try {
	        String querySelect = "SELECT * FROM tb_enderecos WHERE end_rua = ? AND end_cidade = ? AND end_casanumero = ? AND end_cep = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, endereco.getRua());
	        stmt.setString(2, endereco.getCidade());
	        stmt.setInt(3, endereco.getCasanumero());
	        stmt.setString(4, endereco.getCep());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) 
	        	return rs.getInt(1) > 0;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	@Override
	public boolean verificarAlunoExiste(Aluno aluno) { // Função de verficação de alunos já cadastro no sistema 
        try { // Execução do código corretamente 
            String querySelect = "SELECT * FROM tb_alunos WHERE alu_cpf = ?"; // Cria o o select do aluno
        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select 
            stmt.setString(1, aluno.getCpf()); // Seta o valor do select
            ResultSet rs = stmt.executeQuery(); // Executa o select
            if (rs.next()) // // Excuta quantos objetos foram encontrado
                return rs.getInt(1) > 0; // Mostra quantos objetos foram encontrado no select
        } 
        catch (SQLException e) { // Mostra se ocorrer um error na execução do código
        	System.out.println(e.getMessage()); // Mensagem de erro 
        }
		return false; // Não foi encontrado nenhum objeto, então retorna falso
    }

	@Override
	public boolean verificarPaisExiste(Pais pais) {
		 try { // Execução do código corretamente 
	            String querySelect = "SELECT * FROM tb_pais WHERE pai_cpf = ? AND mae_cpf = ?"; // Cria o o select dos pais
	        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select 
	            stmt.setString(1, pais.getPai().getCpf()); 
	            stmt.setString(2, pais.getMae().getCpf()); 
	            ResultSet rs = stmt.executeQuery(); // Executa o select
	            if (rs.next()) // // Excuta quantos objetos foram encontrado
	                return rs.getInt(1) > 0; // Mostra quantos objetos foram encontrado no select
	        } 
	        catch (SQLException e) { // Mostra se ocorrer um error na execução do código
	        	System.out.println(e.getMessage()); // Mensagem de erro 
	        }
			return false; // Não foi encontrado nenhum objeto, então retorna falso
	}
	
	//  PARTE DE ALTERAR 
	@Override
	public boolean alterarAluno(Aluno aluno) {
	    if (this.verificarAlunoExiste(aluno)) {
	        try {
	            String queryUpdateAluno = "UPDATE tb_alunos SET alu_nome = ?, alu_sobrenome = ?, alu_email = ?, alu_idade = ?, alu_datanascimento = ? WHERE alu_cpf = ? AND alu_matricula = ?";
	            try (PreparedStatement stmtUpdateAluno = conn.prepareStatement(queryUpdateAluno)) {
	                stmtUpdateAluno.setString(1, aluno.getNome());
	                stmtUpdateAluno.setString(2, aluno.getSobrenome());
	                stmtUpdateAluno.setString(3, aluno.getEmail());
	                stmtUpdateAluno.setInt(4, aluno.getIdade());
	                stmtUpdateAluno.setDate(5, aluno.getDataNascimento());
	                stmtUpdateAluno.setString(6, aluno.getCpf());
	                stmtUpdateAluno.setInt(7, aluno.getMatricula().getMatricula());
	                int linhasAfetadas = stmtUpdateAluno.executeUpdate();
	                return linhasAfetadas > 0;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    return false;
	}
	
	@Override
	public boolean alterarEnderecoAluno(Aluno aluno) {
	    Endereco oEnderecoAluno = this.verEndereco(aluno.getEndereco());
	    Endereco novoEndereco = aluno.getEndereco();
	    Aluno alunoCompleto = this.verAluno(aluno);
	    
	    if (alunoCompleto.getEndereco().getCodigo() == oEnderecoAluno.getCodigo()) {
	        try {
	        	System.out.println(aluno.getEndereco().getRua());
	            String queryUpdateAluno = "UPDATE tb_enderecos SET end_rua = ?, end_cidade = ?, end_casanumero = ?, end_cep = ? WHERE end_codigo = ?";
	            PreparedStatement stmtUpdateAluno = conn.prepareStatement(queryUpdateAluno);
	            stmtUpdateAluno.setString(1,  novoEndereco.getRua());
	            stmtUpdateAluno.setString(2,  novoEndereco.getCidade());
	            stmtUpdateAluno.setInt(3,  novoEndereco.getCasanumero());
	            stmtUpdateAluno.setString(4, novoEndereco.getCep());
	            stmtUpdateAluno.setInt(5, oEnderecoAluno.getCodigo());

	            // Executar a atualização e verificar o número de linhas afetadas
	            int linhasAfetadas = stmtUpdateAluno.executeUpdate();
	            
	            // Retornar true se houve pelo menos uma linha afetada
	            return linhasAfetadas > 0;

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    return false;
	}

	// PARTE DE DELETAR
	@Override
	public boolean deletarAluno(Aluno aluno) {
		if (this.verificarAlunoExiste(aluno)) {
	        try {
	            String queryUpdateAluno = "DELETE FROM tb_alunos WHERE alu_cpf = ? AND alu_matricula = ?";
	            try (PreparedStatement stmtUpdateAluno = conn.prepareStatement(queryUpdateAluno)) {
	                stmtUpdateAluno.setString(1, aluno.getCpf());
	                stmtUpdateAluno.setInt(2, aluno.getMatricula().getMatricula());
	                int linhasAfetadas = stmtUpdateAluno.executeUpdate();
	                return linhasAfetadas > 0;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    return false;
	}
	
	
	@Override
	public boolean deletarPais(Pais Pais) {
		
		return false;
	}

	@Override
	public boolean deletarEndereco(Endereco endereco) {
		// TODO Auto-generated method stub
		return false;
	}
}



    
    
    



